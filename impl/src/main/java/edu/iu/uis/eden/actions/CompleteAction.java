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
package edu.iu.uis.eden.actions;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.MDC;
import org.kuali.rice.kew.util.EdenConstants;

import edu.iu.uis.eden.KEWServiceLocator;
import edu.iu.uis.eden.actionrequests.ActionRequestValue;
import edu.iu.uis.eden.actiontaken.ActionTakenValue;
import edu.iu.uis.eden.exception.EdenUserNotFoundException;
import edu.iu.uis.eden.exception.InvalidActionTakenException;
import edu.iu.uis.eden.exception.ResourceUnavailableException;
import edu.iu.uis.eden.routeheader.DocumentRouteHeaderValue;
import edu.iu.uis.eden.user.WorkflowUser;
import edu.iu.uis.eden.util.Utilities;

/**
 * CompleteAction records and process a complete action
 *
 * The routeheader is first checked to make sure the action is valid for the document.
 * Next the user is checked to make sure he/she has not taken a previous action on this
 * document at the actions responsibility or below. The action is recorded. Any requests
 * related to this user are deactivated.
 *
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 */
public class CompleteAction extends ActionTakenEvent {
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CompleteAction.class);

    /**
     * @param rh
     *            RouteHeader for the document upon which the action is taken.
     * @param user
     *            User taking the action.
     */
    public CompleteAction(DocumentRouteHeaderValue rh, WorkflowUser user) {
        super(EdenConstants.ACTION_TAKEN_COMPLETED_CD, rh, user);
    }

    /**
     * @param rh
     *            RouteHeader for the document upon which the action is taken.
     * @param user
     *            User taking the action.
     * @param annotation
     *            User comment on the action taken
     */
    public CompleteAction(DocumentRouteHeaderValue rh, WorkflowUser user, String annotation) {
        super(EdenConstants.ACTION_TAKEN_COMPLETED_CD, rh, user, annotation);
    }

    /* (non-Javadoc)
     * @see edu.iu.uis.eden.actions.ActionTakenEvent#isActionCompatibleRequest(java.util.List)
     */
    @Override
    public String validateActionRules() throws EdenUserNotFoundException {
        return validateActionRules(getActionRequestService().findAllValidRequests(getUser(), routeHeader.getRouteHeaderId(), EdenConstants.ACTION_REQUEST_COMPLETE_REQ));
    }

    private String validateActionRules(List<ActionRequestValue> actionRequests) throws EdenUserNotFoundException {
        String superError = super.validateActionTakenRules();
        if (!Utilities.isEmpty(superError)) {
            return superError;
        }
        if (!getRouteHeader().isValidActionToTake(getActionPerformedCode())) {
            return "Document is not in a state to be completed";
        }
        if (!isActionCompatibleRequest(actionRequests)) {
            return "No request for the user is compatible " + "with the COMPLETE action";
        }
        return "";
    }

    /* (non-Javadoc)
     * @see edu.iu.uis.eden.actions.ActionTakenEvent#isActionCompatibleRequest(java.util.List)
     */
    @Override
    public boolean isActionCompatibleRequest(List requests) throws EdenUserNotFoundException {
        // we allow pre-approval
        if (requests.isEmpty()) {
            return true;
        }

        // can always cancel saved or initiated document
        if (routeHeader.isStateInitiated() || routeHeader.isStateSaved()) {
            return true;
        }

        boolean actionCompatible = false;
        Iterator ars = requests.iterator();
        ActionRequestValue actionRequest = null;

        while (ars.hasNext()) {
            actionRequest = (ActionRequestValue) ars.next();
            String request = actionRequest.getActionRequested();

            // Complete action matches Complete, Approve, FYI, and ACK requests
            if ( (EdenConstants.ACTION_REQUEST_FYI_REQ.equals(request)) ||
                    (EdenConstants.ACTION_REQUEST_ACKNOWLEDGE_REQ.equals(request)) ||
                    (EdenConstants.ACTION_REQUEST_APPROVE_REQ.equals(request)) ||
                    (EdenConstants.ACTION_REQUEST_COMPLETE_REQ.equals(request)) ) {
                actionCompatible = true;
                break;
            }
        }
        return actionCompatible;
    }

    /**
     * Records the complete action. - Checks to make sure the document status allows the action. - Checks that the user has not taken a previous action. - Deactivates the pending requests for this user - Records the action
     *
     * @throws InvalidActionTakenException
     * @throws ResourceUnavailableException
     */
    public void recordAction() throws edu.iu.uis.eden.exception.InvalidActionTakenException, EdenUserNotFoundException {
        MDC.put("docId", getRouteHeader().getRouteHeaderId());
   //     checkLocking();
        updateSearchableAttributesIfPossible();
        LOG.debug("Completing document : " + annotation);

        List actionRequests = getActionRequestService().findAllValidRequests(getUser(), getRouteHeaderId(), EdenConstants.ACTION_REQUEST_COMPLETE_REQ);
        LOG.debug("Checking to see if the action is legal");
        String errorMessage = validateActionRules(actionRequests);
        if (!Utilities.isEmpty(errorMessage)) {
            throw new InvalidActionTakenException(errorMessage);
        }

//        LOG.debug("Checking to see if the action is legal");
//
//        if (! getRouteHeader().isValidActionToTake(getActionTakenCode())) {
//            LOG.warn("Document not in state to be completed.");
//            throw new InvalidActionTakenException("Document is not in a state to be completed");
//        }
//
//        List actionRequests = getActionRequestService().findAllValidRequests(getUser(), getRouteHeaderId(), EdenConstants.ACTION_REQUEST_COMPLETE_REQ);
//        //getActionRequestService().findAllPendingByUserAndDoc(getDelegator(), getRouteHeaderId());

        LOG.debug("Record the complete action");
        ActionTakenValue actionTaken = saveActionTaken(findDelegatorForActionRequests(actionRequests));

//        if (!isActionCompatibleRequest(actionRequests, getActionTakenCode())) {
//            throw new InvalidActionTakenException("No request for the user is compatible " + "with the DISAPPROVE or DENY action");
//        }

        LOG.debug("Deactivate all pending action requests");
        getActionRequestService().deactivateRequests(actionTaken, actionRequests);
        notifyActionTaken(actionTaken);

        boolean isException = getRouteHeader().isInException();
        boolean isSaved = getRouteHeader().isStateSaved();
        if (isException || isSaved) {
            String oldStatus = getRouteHeader().getDocRouteStatus();
            LOG.debug("Moving document back to Enroute from "+EdenConstants.DOCUMENT_STATUSES.get(oldStatus));
            getRouteHeader().markDocumentEnroute();
            String newStatus = getRouteHeader().getDocRouteStatus();
            notifyStatusChange(newStatus, oldStatus);
            KEWServiceLocator.getRouteHeaderService().saveRouteHeader(getRouteHeader());
        }
    }

}