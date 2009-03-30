/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.testsuite.test.jsr286.event;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletRequest;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.annotations.DefaultTestPhase;

@DefaultTestPhase(PortletRequest.EVENT_PHASE)
public class SimplePayloadEventTest extends BaseEventTest {

    public static final String SIMPLE_VALUE_PAYLOAD = "SIMPLE_STRING_VALUE";
    
    public static final String SIMPLE_PAYLOAD_EVENT = "event-with-simple-value";
    
    @Override
    protected void fireEvents(ActionRequest request, ActionResponse response) {
        response.setEvent(SIMPLE_PAYLOAD_EVENT, SIMPLE_VALUE_PAYLOAD);
    }

    public TestResult checkExpectedEventWasFired(EventRequest request,
            EventResponse response) {
        tally(response);
        TestResult result = new TestResult();
        result.setSpecPLT("15.2.2");
        result.setDescription("Check to make sure the the " + 
                SIMPLE_PAYLOAD_EVENT + " event was fired.");
        Event event = request.getEvent();
        if (event == null) {
            throw new NullPointerException("No event was received!");
        }
        if (SIMPLE_PAYLOAD_EVENT.equals(event.getName())) {
            result.setReturnCode(TestResult.PASSED);
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected event name to be '" +
                    SIMPLE_PAYLOAD_EVENT + "' but it was actually '" +
                    event.getName() + "'");
        }
        return result;
    }
    
    public TestResult checkEventPayloadIsCorrectClass(EventRequest request,
            EventResponse response) {
        tally(response);
        TestResult result = new TestResult();
        result.setSpecPLT("15.2.2");
        result.setDescription("Check to make sure that payload is an instance" +
                        "of " + String.class);
        Event event = request.getEvent();
        if (event == null) {
            throw new NullPointerException("No event received!");
        }
        Object value = event.getValue();
        if (value == null) {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected event payload type to be '" + 
                    String.class.getName() + "' but it was null.");
        } else if (value instanceof String) {
            result.setReturnCode(TestResult.PASSED);
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected event payload type to be '" + 
                    String.class.getName() + "' but it was actually '" +
                    value.getClass().getName() + "'");
        }
        return result;
    }
    
    public TestResult checkEventPayloadIsCorrect(EventRequest request,
            EventResponse response) {
        tally(response);
        TestResult result = new TestResult();
        result.setSpecPLT("15.2.2");
        result.setDescription(
                "Check to make sure that the payload carries the " +
                "proper state information from the event.");
        String value = (String) request.getEvent().getValue();
        if (!SIMPLE_VALUE_PAYLOAD.equals(value)) {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected payload color to be " + 
                    SIMPLE_VALUE_PAYLOAD + " but it was " + value);
        } else {
            result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }
    
}
