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
package org.kuali.rice.kcb.services.impl;

import java.util.Collection;

import org.junit.Test;
import org.kuali.rice.kcb.bo.MessageDelivery;
import org.kuali.rice.kcb.deliverer.MessageDeliverer;
import org.kuali.rice.kcb.test.RollbackKCBTestCase;
import org.kuali.rice.kcb.test.TestConstants;

/**
 * This class tests the registry service.
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 */
public class MessageDelivererRegistryServiceTest extends RollbackKCBTestCase {
    /**
     * This method tests the hard coded registry list.
     */
    @Test
    public void testGetAllDeliverTypes() {
        Collection<MessageDeliverer> deliverers = services.getMessageDelivererRegistryService().getAllDeliverers();

        assertEquals(4, deliverers.size());

        for(MessageDeliverer deliverer: deliverers) {
            assertTrue(deliverer.getName() != null);
            assertTrue(deliverer.getName().length() > 0);
        }
    }

    /**
     * This method tests a valid deliverer retrieval from the registry.
     */
    @Test
    public void testGetDeliverer_valid() {
        MessageDelivery mockValid = new MessageDelivery();
        mockValid.setDelivererTypeName(TestConstants.VALID_DELIVERER_NAME);
        

        MessageDeliverer deliverer = services.getMessageDelivererRegistryService().getDeliverer(mockValid);
        if (deliverer == null) {
            throw new RuntimeException("Message deliverer could not be obtained");
        }

        assertEquals(TestConstants.VALID_DELIVERER_NAME, deliverer.getName());
    }

    /**
     * This method tests a valid deliverer retrieval from the registry.
     */
    @Test
    public void testGetDeliverer_nonExistent() {
        MessageDelivery mockInvalid = new MessageDelivery();
        mockInvalid.setDelivererTypeName(TestConstants.NON_EXISTENT_DELIVERER_NAME);

        boolean caughtException = false;

        MessageDeliverer deliverer = services.getMessageDelivererRegistryService().getDeliverer(mockInvalid);

        assertNull(deliverer);
    }

    /**
     * This method tests a valid deliverer retrieval by name.
     */
    @Test
    public void testGetDelivererByName_valid() {
        MessageDeliverer deliverer = services.getMessageDelivererRegistryService().getDelivererByName(TestConstants.VALID_DELIVERER_NAME);

        assertEquals(TestConstants.VALID_DELIVERER_NAME, deliverer.getName());
    }

    @Test
    public void testGetDelivererByName_nonExistent() {
        boolean caughtException = false;

        MessageDeliverer deliverer = services.getMessageDelivererRegistryService().getDelivererByName(TestConstants.NON_EXISTENT_DELIVERER_NAME);

        assertNull(deliverer);
    }
}
