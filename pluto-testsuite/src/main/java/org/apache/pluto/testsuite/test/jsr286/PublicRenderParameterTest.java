package org.apache.pluto.testsuite.test.jsr286;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.TestUtils;
import org.apache.pluto.testsuite.annotations.DefaultTestPhase;
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
