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
package org.apache.pluto.testsuite.test.jsr286;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.test.AbstractReflectivePortletTest;

/**
 * Testsuite test to test public render parmeters. 
 *
 *
 */
public class PublicRenderParameterTest extends AbstractReflectivePortletTest {
	public static final String TEST_PARAM = "public-render-param1";
	public static final String TEST_PARAM2 = "public-render-param2";
	public static final String TEST_PARAM_VALUE = "Passed";

	public TestResult checkPublicRenderParameter(PortletResponse response) {
		TestResult result = new TestResult();
        result.setDescription("Check the 286 Companion Portlet for evidence " +
        		"that this test passed.");
        result.setSpecPLT("11.1.2");
       	result.setReturnCode(TestResult.WARNING);
        return result;
    }

	@Override
	public Map<String, String[]> getRenderParameters(PortletRequest request) {
		Map<String, String[]> params = super.getRenderParameters(request);
		params.put(TEST_PARAM, new String[]{TEST_PARAM_VALUE});
		params.put(TEST_PARAM2, new String[]{TEST_PARAM_VALUE});
		return params;
	}
	
}
