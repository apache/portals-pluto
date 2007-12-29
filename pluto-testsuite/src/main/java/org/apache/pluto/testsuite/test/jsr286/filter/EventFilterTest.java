/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.apache.pluto.testsuite.test.jsr286.filter;

import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.annotations.DefaultTestPhase;
import org.apache.pluto.testsuite.annotations.TestPhase;

@DefaultTestPhase(PortletRequest.EVENT_PHASE)
public class EventFilterTest extends BaseFilterTest {

    public static String EVENT_PHASE_TRIGGER = "trigger-event-phase";
    
    @TestPhase(PortletRequest.ACTION_PHASE)
    public TestResult checkTriggerEventFromActionPhase(ActionResponse response) {
        TestResult result = new TestResult();
        result.setDescription(
                "Trigger the event phase from the action phase" +
		"so that the event filter can be tested.");
        result.setReturnCode(TestResult.UNDEFINED);
        response.setEvent(EVENT_PHASE_TRIGGER, getClass().getName());
        return result;
    }
    
}
