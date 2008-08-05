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
package edu.iu.uis.eden.edl.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.kuali.rice.kew.exception.WorkflowException;
import org.kuali.rice.kew.util.EdenConstants;
import org.kuali.rice.util.RiceConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.iu.uis.eden.clientapp.WorkflowDocument;
import edu.iu.uis.eden.clientapp.WorkflowInfo;
import edu.iu.uis.eden.edl.EDLContext;
import edu.iu.uis.eden.edl.EDLModelComponent;
import edu.iu.uis.eden.edl.EDLXmlUtils;
import edu.iu.uis.eden.edl.RequestParser;
import edu.iu.uis.eden.edl.UserAction;
import edu.iu.uis.eden.exception.WorkflowRuntimeException;
import edu.iu.uis.eden.util.Utilities;
import edu.iu.uis.eden.util.XmlHelper;

/**
 * Generates document state based on the workflow document in session.
 *
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 *
 */
public class WorkflowDocumentState implements EDLModelComponent {

	private static final Logger LOG = Logger.getLogger(WorkflowDocumentState.class);

	public void updateDOM(Document dom, Element configElement, EDLContext edlContext) {

		try {
			Element documentState = EDLXmlUtils.getDocumentStateElement(dom);

			Element dateTime = EDLXmlUtils.getOrCreateChildElement(documentState, "dateTime", true);
			dateTime.appendChild(dom.createTextNode(RiceConstants.getDefaultDateAndTimeFormat().format(new Date())));

			Element definition = EDLXmlUtils.getOrCreateChildElement(documentState, "definition", true);
			definition.appendChild(dom.createTextNode(edlContext.getEdocLiteAssociation().getDefinition()));

			Element docType = EDLXmlUtils.getOrCreateChildElement(documentState, "docType", true);
			docType.appendChild(dom.createTextNode(edlContext.getEdocLiteAssociation().getEdlName()));

			Element style = EDLXmlUtils.getOrCreateChildElement(documentState, "style", true);
			String styleName = edlContext.getEdocLiteAssociation().getStyle();
			if (styleName == null) {
				styleName = "Default";
			}
			style.appendChild(dom.createTextNode(styleName));

			Element showAttachments = EDLXmlUtils.getOrCreateChildElement(documentState, "showAttachments", true);
			String showContants = Utilities.getApplicationConstant(EdenConstants.APP_CONST_SHOW_ATTACHMENTS);
			showAttachments.appendChild(dom.createTextNode(Boolean.valueOf(showContants).toString()));

			WorkflowDocument document = (WorkflowDocument)edlContext.getRequestParser().getAttribute(RequestParser.WORKFLOW_DOCUMENT_SESSION_KEY);
			WorkflowInfo info = new WorkflowInfo();
			
			boolean documentEditable = false;
			if (document != null) {
				List validActions = determineValidActions(document);
				documentEditable = isEditable(validActions);
				edlContext.getTransformer().setParameter("readOnly", String.valueOf(documentEditable));
				addActions(dom, documentState, validActions);
				boolean isAnnotatable = isAnnotatable(validActions);
				EDLXmlUtils.createTextElementOnParent(documentState, "annotatable", String.valueOf(isAnnotatable));
				EDLXmlUtils.createTextElementOnParent(documentState, "docId", document.getRouteHeaderId().toString());
				Element workflowDocumentStatus = EDLXmlUtils.getOrCreateChildElement(documentState, "workflowDocumentState", true);
				EDLXmlUtils.createTextElementOnParent(workflowDocumentStatus, "status", document.getStatusDisplayValue());
				EDLXmlUtils.createTextElementOnParent(workflowDocumentStatus, "createDate", RiceConstants.getDefaultDateAndTimeFormat().format(document.getDateCreated()));
				String[] nodeNames = document.getPreviousNodeNames();
				if (nodeNames.length > 0) {
				    Element previousNodes = EDLXmlUtils.getOrCreateChildElement(documentState, "previousNodes", true);
				    // don't include LAST node (where the document is currently...don't want to return to current location)
				    for (int i = 0; i < nodeNames.length; i++) {
					EDLXmlUtils.createTextElementOnParent(previousNodes, "node", nodeNames[i]);
				    }
				}
				String[] currentNodeNames = info.getCurrentNodeNames(document.getRouteHeaderId());
				for (String currentNodeName : currentNodeNames) {
				    EDLXmlUtils.createTextElementOnParent(documentState, "currentNodeName", currentNodeName);
				}

			}

			Element editable = EDLXmlUtils.getOrCreateChildElement(documentState, "editable", true);
			editable.appendChild(dom.createTextNode(String.valueOf(documentEditable)));

			// display the buttons
			EDLXmlUtils.createTextElementOnParent(documentState, "actionable", "true");

			List globalErrors = (List)edlContext.getRequestParser().getAttribute(RequestParser.GLOBAL_ERRORS_KEY);
			List globalMessages = (List)edlContext.getRequestParser().getAttribute(RequestParser.GLOBAL_MESSAGES_KEY);
			Map<String, String> globalFieldErrors = (Map)edlContext.getRequestParser().getAttribute(RequestParser.GLOBAL_FIELD_ERRORS_KEY);
			EDLXmlUtils.addErrorsAndMessagesToDocument(dom, globalErrors, globalMessages, globalFieldErrors);
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Transforming dom " + XmlHelper.jotNode(dom, true));
            }
		} catch (Exception e) {
			throw new WorkflowRuntimeException(e);
		}
	}

	public static List determineValidActions(WorkflowDocument wfdoc) throws WorkflowException {
		if (wfdoc == null) {
			List l = new ArrayList();
			l.add(UserAction.ACTION_CREATE);
			return l;
		}
		List list = new ArrayList();
		if (wfdoc.isAcknowledgeRequested()) {
			list.add(UserAction.ACTION_ACKNOWLEDGE);
		}
		if (wfdoc.isApprovalRequested()) {
			list.add(UserAction.ACTION_APPROVE);
			if (wfdoc.isBlanketApproveCapable()) {
				list.add(UserAction.ACTION_BLANKETAPPROVE);
			}
			list.add(UserAction.ACTION_DISAPPROVE);
	 	 	//should invoke WorkflowDocument.saveRoutingData(...).
			list.add(UserAction.ACTION_SAVE);
			if (wfdoc.getPreviousNodeNames().length > 0) {
				list.add(UserAction.ACTION_RETURN_TO_PREVIOUS);
			}
		}
		if (wfdoc.isCompletionRequested()) {
			list.add(UserAction.ACTION_COMPLETE);
			if (wfdoc.isBlanketApproveCapable()) {// duplicating this because
													// it determines display
													// order. this is a
													// limitation of the style
													// sheet but most easily
													// corrected here for now...
				list.add(UserAction.ACTION_BLANKETAPPROVE);
			}
			list.add(UserAction.ACTION_CANCEL);
		}
		if (wfdoc.isFYIRequested()) {
			list.add(UserAction.ACTION_FYI);
		}
		if (wfdoc.isRouteCapable()) {
			list.add(UserAction.ACTION_ROUTE);
			if (wfdoc.isBlanketApproveCapable()) {// duplicating this because
													// it determines display
													// order. this is a
													// limitation of the style
													// sheet but most easily
													// corrected here for now...
				list.add(UserAction.ACTION_BLANKETAPPROVE);
			}
			list.add(UserAction.ACTION_SAVE);
			list.add(UserAction.ACTION_CANCEL);
		}
		return list;
	}

	

	public static boolean isEditable(List actions) {
		return listContainsItems(actions, UserAction.EDITABLE_ACTIONS);
	}

    public static void addActions(Document dom, Element documentState, List actions) {
        Element actionsPossible = EDLXmlUtils.getOrCreateChildElement(documentState, "actionsPossible", true);
        Iterator it = actions.iterator();
        while (it.hasNext()) {
            String action = it.next().toString();
            Element actionElement = dom.createElement(action);
            // if we use string.xsl we can avoid doing this here
            // (unless for some reason we decide we want different titles)
            if (!Character.isUpperCase(action.charAt(0))) {
                StringBuffer sb = new StringBuffer(action);
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
                action = sb.toString();
            }
            actionElement.setAttribute("title", action);
            actionsPossible.appendChild(actionElement);
        }

        Element annotatable = EDLXmlUtils.getOrCreateChildElement(documentState, "annotatable", true);
        annotatable.appendChild(dom.createTextNode(String.valueOf(isAnnotatable(actions))));
    }


    

    public static boolean listContainsItems(List list, Object[] items) {
        for (int i = 0; i < items.length; i++) {
            if (list.contains(items[i])) return true;
        }
        return false;
    }

    /**
     * Determines whether to display the annotation text box
     * Currently we will show the annotation box if ANY of the possible actions are
     * annotatable.
     * But what happens if we have an un-annotatable action?
     * Hey, why don't we just make all actions annotatable.
     * @param actions list of possible actions
     * @return whether to show the annotation text box
     */
    public static boolean isAnnotatable(List actions) {
        return listContainsItems(actions, UserAction.ANNOTATABLE_ACTIONS);
    }

}