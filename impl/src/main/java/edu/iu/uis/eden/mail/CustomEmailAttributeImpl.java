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
package edu.iu.uis.eden.mail;

import org.kuali.rice.kew.dto.ActionRequestDTO;
import org.kuali.rice.kew.dto.RouteHeaderDTO;

import edu.iu.uis.eden.plugin.attributes.CustomEmailAttribute;

/**
 * Default implementation of the {@link CustomEmailAttribute}.
 *
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 */
public class CustomEmailAttributeImpl implements CustomEmailAttribute {

    private RouteHeaderDTO routeHeaderVO;
    private ActionRequestDTO actionRequestVO;

    public CustomEmailAttributeImpl() {}
    
    public String getCustomEmailSubject() throws Exception {
        return "";
    }
    
    public String getCustomEmailBody() throws Exception {
        return "";
    }

    public RouteHeaderDTO getRouteHeaderVO() {
        return routeHeaderVO;
    }

    public void setRouteHeaderVO(RouteHeaderDTO routeHeaderVO) {
        this.routeHeaderVO = routeHeaderVO;
    }

	public ActionRequestDTO getActionRequestVO() {
		return actionRequestVO;
	}

	public void setActionRequestVO(ActionRequestDTO actionRequestVO) {
		this.actionRequestVO = actionRequestVO;
	}

}
