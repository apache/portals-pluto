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
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletRequest;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.annotations.DefaultTestPhase;

@DefaultTestPhase(PortletRequest.EVENT_PHASE)
public class ComplexPayloadEventTest extends BaseEventTest {

    public static final String TEST_COLOR = "red";
    
    //public static final Point TEST_POINT = new Point(1, -1);

    public static final String TEST_POINT = "1, 1";
    
    public static final String COMPLEX_PAYLOAD_EVENT = 
                                                "event-with-complex-value"; 
    
    @Override
    protected void fireEvents(ActionRequest request, ActionResponse response) {
        ComposedObject payload = new ComposedObject(TEST_COLOR, TEST_POINT);
        response.setEvent(COMPLEX_PAYLOAD_EVENT, payload);
    }
    
    public TestResult checkExpectedEventWasFired(EventRequest request,
            EventResponse response) {
        tally(response);
        TestResult result = new TestResult();
        result.setSpecPLT("15.2.2");
        result.setDescription("Check to make sure the the " + 
                COMPLEX_PAYLOAD_EVENT + " event was fired.");
        if (COMPLEX_PAYLOAD_EVENT.equals(request.getEvent().getName())) {
            result.setReturnCode(TestResult.PASSED);
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected event name to be '" +
                    COMPLEX_PAYLOAD_EVENT + "' but it was actually '" +
                    request.getEvent().getName().getClass().getName() + "'");
        }
        return result;
    }
    
    public TestResult checkEventPayloadIsCorrectClass(EventRequest request,
            EventResponse response) {
        tally(response);
        TestResult result = new TestResult();
        result.setSpecPLT("15.2.2");
        result.setDescription("Check to make sure that payload is an instance" +
        		"of " + ComposedObject.class);
        Object value = request.getEvent().getValue();
        if (value == null) {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected event payload type to be '" + 
                    ComposedObject.class.getName() + "' but it was null.");
        } else if (value instanceof ComposedObject) {
            result.setReturnCode(TestResult.PASSED);
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected event payload type to be '" + 
                    ComposedObject.class.getName() + "' but it was actually '" +
    		    request.getEvent().getValue() + "'");
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
        ComposedObject value = (ComposedObject) request.getEvent().getValue();
        if (!TEST_COLOR.equals(value.getColor())) {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected payload color to be " + 
                    TEST_COLOR + " but it was " + value.getColor());
        } else if (!TEST_POINT.equals(value.getPoint())) { 
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("Expected payload point to be " + 
                    TEST_POINT + " but it was " + value.getPoint());
        } else {
            result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }
    
    
}