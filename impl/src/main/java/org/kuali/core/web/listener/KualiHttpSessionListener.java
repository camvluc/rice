/*
 * Copyright 2007 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl1.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.core.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.lang.StringUtils;
import org.kuali.core.UserSession;
import org.kuali.core.document.Document;
import org.kuali.core.document.authorization.PessimisticLock;
import org.kuali.core.util.GlobalVariables;
import org.kuali.core.util.ObjectUtils;
import org.kuali.rice.KNSServiceLocator;
import org.kuali.rice.kew.exception.WorkflowException;
import org.kuali.rice.kns.util.KNSConstants;


/**
 * This class is used to handle session timeouts where {@link PessimisticLock} objects should
 * be removed from a document 
 * 
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 *
 */
public class KualiHttpSessionListener implements HttpSessionListener {

    /**
     *  EMPTY METHOD IMPLEMENTATION
     */
    public void sessionCreated(HttpSessionEvent se) {
        // no operation required at this time
    }

    /**
     * This method checks for the existence of a document based on session variables and deletes any locks
     * associated with the document that belong to the current user
     * 
     * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se) {
        String documentNumber = (String) se.getSession().getAttribute(KNSConstants.DOCUMENT_HTTP_SESSION_KEY);
        if (StringUtils.isNotBlank(documentNumber)) {
            try {
                // document service needs the usersession to operate but we need the document from document service to verify it exists
                GlobalVariables.setUserSession((UserSession)se.getSession().getAttribute(KNSConstants.USER_SESSION_KEY));
                Document document = KNSServiceLocator.getDocumentService().getByDocumentHeaderId(documentNumber);
                if (ObjectUtils.isNotNull(document)) {
                    KNSServiceLocator.getPessimisticLockService().releaseAllLocksForUser(document.getPessimisticLocks(), GlobalVariables.getUserSession().getUniversalUser());
                }
            } catch (WorkflowException e) {
                throw new RuntimeException(e);
            } finally {
                GlobalVariables.setUserSession(null);
            }
           
        }
    }

}
