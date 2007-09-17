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
package components;

import edu.iu.uis.eden.actionitem.ActionItem;
import edu.iu.uis.eden.actionlist.DisplayParameters;
import edu.iu.uis.eden.actions.ActionSet;
import edu.iu.uis.eden.plugin.attributes.CustomActionListAttribute;
import edu.iu.uis.eden.web.session.UserSession;

/**
 * {@link CustomActionListAttribute} to be used for load testing purposes. 
 * 
 * @author rkirkend
 *
 */
public class LoadTestActionListAttibute implements CustomActionListAttribute {

    private static final long serialVersionUID = 6216539270341233969L;

    public DisplayParameters getDocHandlerDisplayParameters(UserSession userSession, ActionItem actionItem) throws Exception {
	return new DisplayParameters(100);
    }
    
    public ActionSet getLegalActions(UserSession userSession, ActionItem actionItem) throws Exception {
	ActionSet as = new ActionSet();
	as.addAcknowledge();
	as.addApprove();
	as.addFyi();
	return as;
    }

}
