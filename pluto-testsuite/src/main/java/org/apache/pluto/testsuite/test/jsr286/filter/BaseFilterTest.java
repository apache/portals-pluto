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

import javax.portlet.PortletRequest;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.annotations.DefaultTestPhase;
import org.apache.pluto.testsuite.test.AbstractReflectivePortletTest;

public abstract class BaseFilterTest extends AbstractReflectivePortletTest {

    public TestResult checkTestsRunInCorrectPhase(PortletRequest request) {
        TestResult result = new TestResult();
        DefaultTestPhase dtp = this.getClass()
                                    .getAnnotation(DefaultTestPhase.class);
        result.setDescription(
                "Ensure that these filter tests run in correct phase (" + 
                dtp.value() + ")");
        if (!dtp.value().equals(request.getAttribute(PortletRequest.LIFECYCLE_PHASE))) {
            result.setResultMessage("Tests should have run in " + dtp.value() +
                    " but actually ran in " +
                    request.getAttribute(PortletRequest.LIFECYCLE_PHASE));
            result.setReturnCode(TestResult.FAILED);
        } else {
            result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }
    
    public TestResult checkAttributeFromWildcardFilter(PortletRequest request) {
        TestResult result = new TestResult();
        result.setSpecPLT("20.4");
        result.setDescription("Check that filters can be mapped " +
        		"to portlet names using wildcard notation.");
        if (Boolean.TRUE.equals(
                request.getAttribute(WildcardMappedFilter.ATTR_SET_IN_FILTER))) {
            result.setReturnCode(TestResult.PASSED);    
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("The request attribute that should have " +
            		"been set in the wildcard mapped filter was not set.");
        }
        return result;
    }
 
    public TestResult checkSecondFilterOverwroteAttribute(PortletRequest req) {
        TestResult result = new TestResult();
        result.setSpecPLT("20.4");
        result.setDescription("Check that filters are applied in the same "
                + " order as defined in the deployment descriptor.");
        if (req.getAttribute(WildcardMappedFilter.ATTR_TO_BE_OVERWRITTEN) == null) {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage(
                    "It appears the the attribute that was to be " +
                    "applied by both filter was not applied at all.");
        } else if (WildcardMappedFilter.ATTR_TO_BE_OVERWRITTEN.equals(
                req.getAttribute(WildcardMappedFilter.ATTR_TO_BE_OVERWRITTEN))) {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("The attribute that should have been " +
            		"overwritten by the second filter in the chain was" +
            		"not properly overwritten.");
        } else {
            result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }
    
    public TestResult checkAttributeFromTestFilter(PortletRequest request) {
        TestResult result = new TestResult();
        result.setSpecPLT("20.4");
        result.setDescription("Check that filters can be mapped " +
                        "to logical portlet names.");
        if (Boolean.TRUE.equals(
                request.getAttribute(TestFilter.TEST_FILTER_ATTR))) {
            result.setReturnCode(TestResult.PASSED);    
        } else {
            result.setReturnCode(TestResult.FAILED);
            result.setResultMessage("The request attribute that should have " +
                        "been set in the test filter was not set.");
        }
        return result;
    }
}
