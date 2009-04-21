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
package org.apache.pluto.testsuite.test.jsr286.event;

import java.lang.reflect.Method;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.StateAwareResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.annotations.DefaultTestPhase;
import org.apache.pluto.testsuite.annotations.TestPhase;
import org.apache.pluto.testsuite.test.AbstractReflectivePortletTest;

@DefaultTestPhase(PortletRequest.EVENT_PHASE)
public abstract class BaseEventTest extends AbstractReflectivePortletTest {
  
    private int numMethodsCache = -1;
    
    protected Logger LOG = LoggerFactory.getLogger(getClass());
    
    @TestPhase(PortletRequest.ACTION_PHASE)
    public TestResult checkFireEventsFromActionPhase(ActionRequest request,
            ActionResponse response) {
        tally(response);
        TestResult result = new TestResult();
        result.setReturnCode(TestResult.UNDEFINED);
        result.setDescription("Fire several events to test processing." +
                " Be sure to check to Companion portlet to make sure" +
                " that all tests are correctly run.");
        result.setSpecPLT("15.2.3");
        fireEvents(request, response);
        
        return result;
    }

    /*
    @TestPhase(PortletRequest.RENDER_PHASE)
    public TestResult checkCorrectNumberOfMethods(RenderRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Check to make sure that all of the test " +
        		"methods were triggered. More accurately, checks to " +
        		"make sure that all of the methods that are capable " +
        		"of accepting a StateAwareResponse have called the " +
        		"tally() method during this request.");
        int actual = getTally(request);
        int expected = getNumberOfMethodsThatShouldRun(request); 
        if (actual == expected) {
            result.setReturnCode(TestResult.PASSED);
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setDescription("Expected " + expected + " test methods " +
                    "to run, but actually " + actual + " ran.");
        }
        return result;
    }
    */
    
    protected int getNumberOfMethodsThatShouldRun(PortletRequest request) {
        if (numMethodsCache == -1) {
            Class<?> clazz = getClass();
            for (Method m : clazz.getMethods()) {
                if (m.getName().startsWith("check") && 
                        m.getReturnType().equals(TestResult.class)) {
                    for (Class<?> paramType : m.getParameterTypes()) {
                        if (StateAwareResponse.class
                                .isAssignableFrom(paramType)) {
                            numMethodsCache++;
                        }
                    }
                }
            }
        }
        return numMethodsCache;
    }
    
    protected void tally(StateAwareResponse response) {
        // Eventually will track how many test methods run...
        // Maybe should move to the AbstractReflectivePortletTest class?
    }
    
    protected abstract void fireEvents(
                        ActionRequest request, ActionResponse response);
    
    
}
