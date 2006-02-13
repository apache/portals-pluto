/*
 * Copyright 2003,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.testsuite.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.testsuite.ActionTest;
import org.apache.pluto.testsuite.TestResult;
import org.apache.pluto.testsuite.TestUtils;
import org.apache.pluto.testsuite.validator.PreferencesValidatorImpl;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class SimplePreferenceTest extends AbstractReflectivePortletTest
implements ActionTest {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(SimplePreferenceTest.class);
    
    private static final String BOGUS_KEY = "org.apache.pluto.testsuite.BOGUS_KEY";
    
    private static final String PREF_NAME = "dummyName";
    private static final String PREF_VALUE = "dummyValue";
    private static final String DEF_VALUE = "Default";
    private static final String NEW_VALUE = "notTheOriginal";
    
    
    // Test Methods ------------------------------------------------------------
    
    protected TestResult checkGetEmptyPreference(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure proper default is returned when "
        		+ "a non-existing preference is requested.");
        
        PortletPreferences preferences = request.getPreferences();
        String value =  preferences.getValue("nonexistence!", DEF_VALUE);
        if (value.equals(DEF_VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	TestUtils.failOnAssertion("preference value", value, DEF_VALUE, result);
        }
        return result;
    }

    protected TestResult checkGetEmptyPreferences(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure proper defaults are returned when "
        		+ "a non-existent preference set is requested.");
        
        PortletPreferences preferences = request.getPreferences();
        String[] values = preferences.getValues("nonexistence!",
        		                                new String[] { DEF_VALUE });
        if (values != null && values.length == 1
        		&& values[0].equals(DEF_VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (values == null) {
        	TestUtils.failOnAssertion("preference values",
        	                          values,
        	                          new String[] { DEF_VALUE },
        	                          result);
        } else if (values.length != 1) {
        	TestUtils.failOnAssertion("length of preference values",
        	                          String.valueOf(values.length),
        	                          String.valueOf(1),
        	                          result);
        } else {
        	TestUtils.failOnAssertion("preference values",
        	                          values,
        	                          new String[] { DEF_VALUE },
        	                          result);
        }
        return result;
    }

    protected TestResult checkGetPreferences(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure that preferences defined "
        		+ "in the deployment descriptor may be retrieved.");
        
        PortletPreferences preferences = request.getPreferences();
        String value =  preferences.getValue(PREF_NAME, DEF_VALUE);
        if (value != null && value.equals(PREF_VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	TestUtils.failOnAssertion("preference value", value, PREF_VALUE, result);
        }
        return result;
    }
    
    protected TestResult checkSetPreferenceSingleValue(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure a single preference value can be set.");

        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValue("TEST", "TEST_VALUE");
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference value.", ex, result);
            return result;
        }
        
        String value = preferences.getValue("TEST", DEF_VALUE);
        if (value != null && value.equals("TEST_VALUE")) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	TestUtils.failOnAssertion("preference value", value, "TEST_VALUE", result);
        }
        return result;
    }

    protected TestResult checkSetPreferenceMultiValues(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure multiple preference values can be set.");

        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValues("TEST", new String[] {"ONE", "ANOTHER"});
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference values.", ex, result);
        	return result;
        }

        String[] values = preferences.getValues("TEST", new String[] { DEF_VALUE });
        if (values != null && values.length == 2
        		&& values[0].equals("ONE") && values[1].equals("ANOTHER")) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (values == null) {
        	TestUtils.failOnAssertion("preference values",
        	                          values,
        	                          new String[] { "ONE", "ANOTHER" },
        	                          result);
        } else if (values.length != 2) {
        	TestUtils.failOnAssertion("length of preference values",
        	                          String.valueOf(values.length),
        	                          String.valueOf(2),
        	                          result);
        } else {
        	TestUtils.failOnAssertion("preference values",
        	                          values,
        	                          new String[] { "ONE", "ANOTHER" },
        	                          result);
        }
        return result;
    }
    
    protected TestResult checkSetPreferencesReturnsFirst(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure the first value set to a given "
        		+ "preference is returned first by PortletPreferences.getValue().");

        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValues("TEST", new String[] { "FIRST", "SECOND" });
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference values.", ex, result);
        	return result;
        }

        String value = preferences.getValue("TEST", DEF_VALUE);
        if (value != null && value.equals("FIRST")) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	TestUtils.failOnAssertion("preference value", value, "FIRST", result);
        }
        return result;
    }
    
    protected TestResult checkPreferenceValidator(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure the validator catches invalid preferences.");
        
        PortletPreferences preferences = request.getPreferences();
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Original preferences:");
        	logPreferences(preferences);
        }
        boolean exceptionThrown = false;
        try {
            preferences.setValue("TEST", " Spaces removed by trim ");
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Modified VALIDATION_TEST_KEY preference:");
            	logPreferences(preferences);
            }
            // Call store() method to invoke the validator.
            preferences.store();
            
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference value.", ex, result);
        	return result;
        	
        } catch (IOException ex) {
        	TestUtils.failOnException("Unable to store preference value.", ex, result);
        	return result;
        	
        } catch (ValidatorException ex) {
        	// We are expecting this exception!
            exceptionThrown = true;
            // FIXME: what is going on below?
            try {
            	//get rid of spaces because it causes problems with reset() call.
                preferences.setValue("TEST", "OK");
            	preferences.reset("TEST");
            } catch (Throwable th) {
            	LOG.error(th);            	
            }
        }
        
        if (exceptionThrown) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResultMessage("Illegal value not caught by validator.");
        }
        return result;
    }

    protected TestResult checkOnePreferenceValidatorPerPortletDefinition(
    		PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure only one validator instance is created "
        		+ "per portlet definition.");
        
        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValue(
            		PreferencesValidatorImpl.CHECK_VALIDATOR_COUNT,
            		"true");
            // Call store() method to invoke the validator.
            preferences.store();
            result.setReturnCode(TestResult.PASSED);
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference value.", ex, result);
        } catch (IOException ex) {
        	TestUtils.failOnException("Unable to store preference value.", ex, result);
        } catch (ValidatorException ex) {
        	TestUtils.failOnException("Unable to store preference value.", ex, result);
        } finally {
        	try {
        		preferences.reset(PreferencesValidatorImpl.CHECK_VALIDATOR_COUNT);
        	} catch (ReadOnlyException ex) {
        		TestUtils.failOnException("Unable to reset preference value for "
        				+ PreferencesValidatorImpl.CHECK_VALIDATOR_COUNT,
        				ex, result);
        	}
        }
        return result;
    }

    protected TestResult checkStorePreferences(PortletRequest request) {
        TestResult result = new TestResult();
        result.setDescription("Ensure storage works for portlet preferences.");
        
        PortletPreferences preferences = request.getPreferences();
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Preferences to store: " + preferences);
        }
        
        boolean setOccured = false;
        boolean storeOccured = false;
        
        try {
        	// Set new value for preference "dummyName".
            preferences.setValue(PREF_NAME, NEW_VALUE);
            String value = preferences.getValue(PREF_NAME, DEF_VALUE);
            if (NEW_VALUE.equals(value)) {
                setOccured = true;
            }
            
            // Store the preference and get value.
            preferences.store();
            value = preferences.getValue(PREF_NAME, DEF_VALUE);
            if (NEW_VALUE.equals(value)) {
                storeOccured = true;
            }
            
            // Reset preference to default value.
            preferences.reset(PREF_NAME);
            
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference value.", ex, result);
        	return result;
        } catch (ValidatorException ex) {
        	TestUtils.failOnException("Unable to store preference value.", ex, result);
        	return result;
        } catch(IOException ex) {
        	TestUtils.failOnException("Unable to store preference value.", ex, result);
        	return result;
        }
        
        // Everything is OK.
        if (setOccured && storeOccured) {
        	result.setReturnCode(TestResult.PASSED);
        }
        // Error occurred when setting preference value.
        else if (!setOccured) {
        	result.setReturnCode(TestResult.WARNING);
        	result.setResultMessage("A function upon which the reset test "
        			+ "depends failed to execute as expected. "
        			+ "Check the other test results in this test suite.");
        }
        // Error occurred when storing preference value.
        else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResultMessage("Preferences not successfully stored.");
        }
        return result;
    }
    
    protected TestResult checkResetPreferences(PortletRequest request) {
        
    	TestResult result = new TestResult();
    	result.setDescription("Ensure preferences are properly reset.");
        
        PortletPreferences preferences = request.getPreferences();
        boolean setOccured = false;
        boolean storeOccured = false;
        boolean resetOccured = false;
        
        try {
        	// Set new value to overwrite the default value.
            preferences.setValue(PREF_NAME, NEW_VALUE);
            String value = preferences.getValue(PREF_NAME, DEF_VALUE);
            if (NEW_VALUE.equals(value)) {
                setOccured = true;
            }
            
            // Store the preferences.
            preferences.store();
            value = preferences.getValue(PREF_NAME, DEF_VALUE);
            if (NEW_VALUE.equals(value)) {
                storeOccured = true;
            }
            
            // Reset the preference so that default value is restored.
            preferences.reset(PREF_NAME);
            value =  preferences.getValue(PREF_NAME, DEF_VALUE);
            if (PREF_VALUE.equals(value)) {
                resetOccured = true;
            }
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference value.", ex, result);
        	return result;
        } catch (ValidatorException ex) {
        	TestUtils.failOnException("Unable to store preferences.", ex, result);
        	return result;
        } catch (IOException ex) {
        	TestUtils.failOnException("Unable to store preferences.", ex, result);
        	return result;
        }
        
        // Everything is OK.
        if (setOccured && storeOccured && resetOccured) {
        	result.setReturnCode(TestResult.PASSED);
        }
        // Error occurred when setting or storing preferences.
        else if (!setOccured || !storeOccured) {
        	result.setReturnCode(TestResult.WARNING);
        	result.setResultMessage("A function upon which the reset test "
        			+ "depends failed to execute as expected. "
        			+ "Check the other test results in this test suite.");
        }
        // Error occurred when resetting preference.
        else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResultMessage("Preferences value was not successfully reset after store");
        }
        return result;
    }
    
    protected TestResult checkResetToNullPreferences(PortletRequest request) {
        
    	TestResult result = new TestResult();
        result.setDescription("Ensure preferences are properly reset when originally null.");
        
        PortletPreferences preferences = request.getPreferences();
        boolean setOccured = false;
        boolean storeOccured = false;
        boolean resetOccured = false;
        
        try {
        	// Set preference value to overwrite the original (null).
            preferences.setValue(BOGUS_KEY, NEW_VALUE);
            String value = preferences.getValue(BOGUS_KEY, DEF_VALUE);
            if (NEW_VALUE.equals(value)) {
                setOccured = true;
            }
            
            // Store the preferences.
            preferences.store();
            value = preferences.getValue(BOGUS_KEY, DEF_VALUE);
            if (NEW_VALUE.equals(value)) {
                storeOccured = true;
            }
            
            // Reset preference value to null.
            preferences.reset(BOGUS_KEY);
            value =  preferences.getValue(BOGUS_KEY, DEF_VALUE);
            if (DEF_VALUE.equals(value)) {
                resetOccured = true;
            }
        } catch (ReadOnlyException ex) {
        	TestUtils.failOnException("Unable to set preference value.", ex, result);
        	return result;
        } catch (ValidatorException ex) {
        	TestUtils.failOnException("Unable to store preferences.", ex, result);
        	return result;
        } catch (IOException ex) {
        	TestUtils.failOnException("Unable to store preferences.", ex, result);
        	return result;
        }
        
        // Everything is OK.
        if (setOccured && storeOccured && resetOccured) {
        	result.setReturnCode(TestResult.PASSED);
        }
        // Error occurred when setting or storing preferences.
        else if (!setOccured || !storeOccured) {
        	result.setReturnCode(TestResult.WARNING);
        	result.setResultMessage("A function upon which the reset test "
        			+ "depends failed to execute as expected. "
        			+ "Check the other test results in this test suite.");
        }
        // Error occurred when resetting preference value.
        else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResultMessage("Preferences value was not successfully "
        			+ "reset after store.");
        }
        return result;
    }
    
    /**
     * Check PLT. 14.3: Read-only preference attributes could not be modifed.
     * @param req  the portlet request.
     * @return the test result.
     */
    protected TestResult checkReadOnlyPreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setDescription("Ensure that read only preferences may not be set.");

        PortletPreferences preferences = req.getPreferences();
        boolean exceptionThrown = false;
        try {
            preferences.setValue("readonly", "written");
            if (LOG.isDebugEnabled()) {
            	logPreferences(preferences);
            }
        }
        catch (ReadOnlyException roe) {
            exceptionThrown = true;
        }

        if(exceptionThrown) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResultMessage("Read Only Preference was written.");
        }

        return res;
    }
    
    /**
     * FIXME:
     * @param req
     * @return
     */
    protected TestResult checkGetPreferenceMap(PortletRequest req) {
        TestResult result = checkGetPreferenceNames(req);
        result.setDescription("Ensure returned map is valid");
        return result;
    }

    protected TestResult checkGetPreferenceNames(PortletRequest req) {
        TestResult res = new TestResult();
        res.setDescription("Ensure returned enumeration is valid");

        PortletPreferences prefs = req.getPreferences();
        Map map = prefs.getMap();
        Enumeration enumerator= prefs.getNames();
        boolean hasAll = true;
        while(enumerator.hasMoreElements()) {
            if(!map.containsKey(enumerator.nextElement())) {
                hasAll = false;
                break;
            }
        }

        if(hasAll) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResultMessage("All names not found as preferences.");
        }
        return res;
    }
    
    /**
     * Check (xci) SPEC 91, PLT 14.1:
     * Preferences values are not modified if the values in the Map are altered.
     * @param req  the portlet request.
     * @return the test result.
     */
    protected TestResult checkPreferencesValuesNotModified(PortletRequest req) {
    	TestResult res = new TestResult();
    	res.setDescription("Preferences values are not modified "
    			+ "if the values in the Map are altered.");
    	PortletPreferences prefs = req.getPreferences();
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Original Preferences:");
        	logPreferences(prefs);
        }
    	Map prefMap = prefs.getMap();
    	String[] values = (String[]) prefMap.get("dummyName");
    	String originalValue = null;
    	String modifiedValue = "Dummy value modified in preferences map.";
    	if (values != null && values.length == 1) {
    		originalValue = values[0];
    		values[0] = modifiedValue;
    	}
    	
    	String newValue = prefs.getValue("dummyName", "");
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Modified Preferences:");
        	logPreferences(prefs);
        }
    	if (!newValue.equals(originalValue)) {
    		res.setReturnCode(TestResult.FAILED);
    		res.setResultMessage("Preferences values modified.");
    	} else {
    		res.setReturnCode(TestResult.PASSED);
    	}
    	return res;
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Logs out the portlet preferences.
     * @param preferences  PortletPreferences to log.
     */
    private void logPreferences(PortletPreferences preferences) {
    	StringBuffer buffer = new StringBuffer();
    	Map map = preferences.getMap();
    	for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
    		String key = (String) it.next();
    		String[] values = (String[]) map.get(key);
    		buffer.append(key).append("=");
    		if (values != null) {
    			buffer.append("{");
    			for (int i = 0; i < values.length; i++) {
    				buffer.append(values[i]);
    				if (i < values.length - 1) {
    					buffer.append(",");
    				}
    			}
    			buffer.append("}");
    		} else {
    			// Spec allows null values.
    			buffer.append("NULL");
    		}
    		buffer.append(";");    		
    	}
    	LOG.debug("PortletPreferences: " + buffer.toString());
    }

}
