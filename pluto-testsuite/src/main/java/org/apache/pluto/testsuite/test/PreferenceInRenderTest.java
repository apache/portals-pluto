package org.apache.pluto.testsuite.test;

import java.io.IOException;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ValidatorException;

import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.TestUtils;

public class PreferenceInRenderTest extends PreferenceCommonTest {
	
	// Test Methods ------------------------------------------------------------
	
	protected TestResult checkStorePreferences(PortletRequest request) {
		TestResult result = new TestResult();
		result.setDescription("Ensure that if the store() method is invoked "
				+ "within render() method, an IllegalStateException will be "
				+ "thrown out.");
		result.setSpecPLT("14.1");
		
		PortletPreferences preferences = request.getPreferences();
        boolean exceptionThrown = false;
        
        // Store preferences and wait for IllegalStateException.
        try {
            preferences.store();
        } catch (ValidatorException ex) {
        	TestUtils.failOnException("Unable to store preferences.", ex, result);
        	return result;
        } catch (IOException ex) {
        	TestUtils.failOnException("Unable to store preferences.", ex, result);
        	return result;
        } catch (IllegalStateException ex) {
        	exceptionThrown = true;
        }
		
        if (exceptionThrown) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResultMessage("IllegalStateException is not thrown out "
        			+ "when store() method is invoked within render() method.");
        }
		return result;
	}
	
}
