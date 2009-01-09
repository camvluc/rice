/*
 * Copyright 2005-2006 The Kuali Foundation.
 * 
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
package org.kuali.rice.kew.actions;

import org.apache.log4j.MDC;
import org.kuali.rice.kew.actiontaken.ActionTakenValue;
import org.kuali.rice.kew.exception.InvalidActionTakenException;
import org.kuali.rice.kew.routeheader.DocumentRouteHeaderValue;
import org.kuali.rice.kew.util.KEWConstants;
import org.kuali.rice.kew.util.Utilities;
import org.kuali.rice.kim.bo.entity.KimPrincipal;


/**
 * Simply records an action taken with an annotation.  
 *
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 */
public class LogDocumentActionAction extends ActionTakenEvent {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(LogDocumentActionAction.class);

    /**
     * @param rh RouteHeader for the document upon which the action is taken.
     * @param user User taking the action.
     */
    public LogDocumentActionAction(DocumentRouteHeaderValue rh, KimPrincipal principal) {
        super(KEWConstants.ACTION_TAKEN_LOG_DOCUMENT_ACTION_CD, rh, principal);
    }

    /**
     * @param rh RouteHeader for the document upon which the action is taken.
     * @param user User taking the action.
     * @param annotation User comment on the action taken
     */
    public LogDocumentActionAction(DocumentRouteHeaderValue rh, KimPrincipal principal, String annotation) {
        super(KEWConstants.ACTION_TAKEN_LOG_DOCUMENT_ACTION_CD, rh, principal, annotation);
    }

    /* (non-Javadoc)
     * @see org.kuali.rice.kew.actions.ActionTakenEvent#validateActionRules()
     */
    @Override
    public String validateActionRules() {
        // log action is always valid so return no error message
        return "";
    }

    /**
     * Records the non-routed document action. - Checks to make sure the document status allows the action. Records the action.
     * 
     * @throws InvalidActionTakenException
     */
    public void recordAction() throws InvalidActionTakenException {
        MDC.put("docId", getRouteHeader().getRouteHeaderId());

        String errorMessage = validateActionRules();
        if (!Utilities.isEmpty(errorMessage)) {
            throw new InvalidActionTakenException(errorMessage);
        }

        LOG.debug("Logging document action");
        ActionTakenValue actionTaken = saveActionTaken(Boolean.FALSE);
        notifyActionTaken(actionTaken);
       
    }
}
