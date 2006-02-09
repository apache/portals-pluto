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
import org.apache.pluto.testsuite.impl.PreferencesValidatorImpl;

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
public class SimplePreferenceTest extends ActionAbstractReflectivePortletTest
implements ActionTest {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(SimplePreferenceTest.class);
    
    private static final String BOGUS_KEY = "org.apache.pluto.testsuite.BOGUS_KEY";
    
    private static final String PREF_NAME = "dummyName";
    private static final String PREF_VALUE = "dummyValue";
    private static final String DEF_VALUE = "Default";
    private static final String NEW_VALUE = "notTheOriginal";
    
    
    public String getTestSuiteName() {
        return "Simple Preferences Test";
    }
    
    
    // Test Methods ------------------------------------------------------------
    
    protected TestResult checkGetEmptyPreference(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkGetEmptyPreference");
        result.setDesc("Ensure proper default is returned when a non-existing "
        		+ "preference is requested.");
        
        PortletPreferences preferences = request.getPreferences();
        String value =  preferences.getValue("nonexistence!", DEF_VALUE);
        if (value.equals(DEF_VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
            result.setResults("Preferences value was '" + value + "', "
            		+ "expected '" + DEF_VALUE + "'.");
        }
        return result;
    }

    protected TestResult checkGetEmptyPreferences(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkGetEmptyPreferences");
        result.setDesc("Ensure proper defaults are returned when "
        		+ "a non-existent preference set is requested.");
        
        PortletPreferences preferences = request.getPreferences();
        String[] values = preferences.getValues("nonexistence!",
        		                                new String[] { DEF_VALUE });
        if (values != null && values.length == 1
        		&& values[0].equals(DEF_VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (values == null) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preference values were NULL, "
        			+ "expected '" + DEF_VALUE + "'.");
        } else if (values.length != 1) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preference has " + values.length + " values, "
        			+ "expected 1 value.");
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preferences value was '" + values[0] + "', "
        			+ "expected '" + DEF_VALUE + "'.");
        }
        return result;
    }


    protected TestResult checkGetPreferences(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkGetPreferences");
        result.setDesc("Tests that preferences defined in the deployment "
        		+ "descriptor may be retrieved.");
        
        PortletPreferences preferences = request.getPreferences();
        String value =  preferences.getValue(PREF_NAME, DEF_VALUE);
        if (value != null && value.equals(PREF_VALUE)) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preferences value was '"+ value +"', "
        			+ "expected '" + PREF_VALUE + "'.");
        }
        return result;
    }
    
    protected TestResult checkSetPreferenceSingleValue(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkSetPreferenceSingleValue");
        result.setDesc("Ensure a single preference value can be set.");

        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValue("TEST", "TEST_VALUE");
        } catch (ReadOnlyException ex) {
        	String message = "Unable to set preference value (ReadOnly error): "
        			+ ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
            return result;
        }
        
        String value = preferences.getValue("TEST", DEF_VALUE);
        if (value != null && value.equals("TEST_VALUE")) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preferences value was '" + value + "', "
        			+ "expected 'TEST_VALUE'.");
        }
        return result;
    }

    protected TestResult checkSetPreferenceMultiValues(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkSetPreferenceMultiValues");
        result.setDesc("Ensure multiple preference values can be set.");

        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValues("TEST", new String[] {"ONE", "ANOTHER"});
        } catch (ReadOnlyException ex) {
        	String message = "Unable to set preference value (ReadOnly error): "
        			+ ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
        	return result;
        }

        String[] values = preferences.getValues(
        		"TEST", new String[] { DEF_VALUE });
        if (values != null && values.length == 2
        		&& values[0].equals("ONE") && values[1].equals("ANOTHER")) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (values == null) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preference values were NULL, "
        			+ "expected 'ONE' and 'ANOTHER'.");
        } else if (values.length != 2) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preference has " + values.length + " values, "
        			+ "expected 2 values.");
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preference values were '" + values[0] +"' and '"
        			+ values[1] + "' ,expected 'ONE' and 'ANOTHER'.");
        }
        return result;
    }

    protected TestResult checkSetPreferencesReturnsFirst(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkSetPreferencesReturnsFirst");
        result.setDesc("Ensure the first value set to a given preference "
        		+ "is returned first by PortletPreferences.getValue().");

        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValues("TEST", new String[] { "FIRST", "SECOND" });
        } catch (ReadOnlyException ex) {
        	String message = "Unable to set preference value (ReadOnly error): "
    			+ ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
        	return result;
        }

        String value = preferences.getValue("TEST", DEF_VALUE);
        if (value != null && value.equals("FIRST")) {
        	result.setReturnCode(TestResult.PASSED);
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preference value was '" + value + "', "
        			+ "expected 'FIRST'.");
        }
        return result;
    }
    
    protected TestResult checkPreferenceValidator(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkPreferenceValidator");
        result.setDesc("Ensure the validator catches invalid preferences.");
        
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
        	String message = "Unable to set preference value (ReadOnly error): "
    			+ ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
        	return result;
        	
        } catch (IOException ex) {
        	String message = "Unable to store preference value (IO error): "
    			+ ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
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
        	result.setResults("Illegal value not caught by validator.");
        }
        return result;
    }

    protected TestResult checkOnePreferenceValidatorPerPortletDefinition(
    		PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkOnePreferenceValidatorPerPortletDefinition");
        result.setDesc("Ensure only one validator instance is created "
        		+ "per portlet definition.");
        
        PortletPreferences preferences = request.getPreferences();
        try {
            preferences.setValue(PreferencesValidatorImpl.CHECK_VALIDATOR_COUNT,
            		"true");
            // Call store() method to invoke the validator.
            preferences.store();
            result.setReturnCode(TestResult.PASSED);
            
        } catch (ReadOnlyException ex) {
        	String message = "Unable to set preference value (ReadOnly error): "
    			+ ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
        	
        } catch (IOException ex) {
        	String message = "Unable to store preference value (IO error): "
    			+ ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
        	
        } catch (ValidatorException ex) {
        	String message = "Unable to store preference value "
        		+ "(Validation error): " + ex.getMessage();
        	LOG.error(message);
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(message);
        	
        } finally {
        	try {
        		preferences.reset(PreferencesValidatorImpl.CHECK_VALIDATOR_COUNT);
        	} catch (ReadOnlyException ex) {
        		LOG.error("Unable to reset preference value for: "
        				+ PreferencesValidatorImpl.CHECK_VALIDATOR_COUNT
        				+ " (ReadOnly error)");
        	}
        }
        
        return result;
    }

    protected TestResult checkStorePreferences(PortletRequest request) {
        TestResult result = new TestResult();
        result.setName("checkStorePreference");
        result.setDesc("Ensure storage works for portlet preferences.");
        
        PortletPreferences preferences = request.getPreferences();
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Preferences to store: " + preferences);
        }
        
        boolean setOccured = false;
        boolean storeOccured = false;
        boolean errorOccured = false;
        String errorMessage = null;
        
        try {
            preferences.setValue("dummyName", "notTheOriginal");
            String value = preferences.getValue("dummyName", "Default");
            if ("notTheOriginal".equals(value)) {
                setOccured = true;
            }
            
            preferences.store();
            value = preferences.getValue("dummyName", "Default");
            if ("notTheOriginal".equals(value)) {
                storeOccured = true;
            }
            
            preferences.reset("dummyName");
            
        } catch (ReadOnlyException ex) {
        	errorOccured = true;
        	errorMessage = "ReadOnly error: " + ex.getMessage();
        	LOG.error(errorMessage, ex);
        } catch (ValidatorException ex) {
        	errorOccured = true;
        	errorMessage = "Validation error: " + ex.getMessage();
        	LOG.error(errorMessage, ex);
        } catch(IOException ex) {
        	errorOccured = true;
        	errorMessage = "IO error: " + ex.getMessage();
        	LOG.error(errorMessage, ex);
        }

        if (!errorOccured && setOccured && storeOccured) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (errorOccured) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults(errorMessage);
        } else if (!setOccured) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("A function upon which the reset test depends "
        			+ "failed to execute as expected. "
        			+ "Check the other test results in this test suite.");
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preferences not successfully stored.");
        }
        return result;
    }
    
    protected TestResult checkResetPreferences(PortletRequest request) {
        
    	TestResult result = new TestResult();
    	result.setName("Reset Preference Test");
    	result.setDesc("Tests that preferences are properly reset.");
        
        PortletPreferences preferences = request.getPreferences();
        LOG.warn("PortletPreferences impl: " + preferences.getClass().getName());
        boolean setOccured = false;
        boolean storeOccured = false;
        boolean resetOccured = false;
        try {
            preferences.setValue("dummyName", "notTheOriginal");
            String pref = preferences.getValue("dummyName", "Default");
            if ("notTheOriginal".equals(pref)) {
                setOccured = true;
            }
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Original preferences:");
            	logPreferences(preferences);
            }
            preferences.store();
            if ("notTheOriginal".equals(preferences.getValue("dummyName", "Default"))) {
                storeOccured = true;
            }

            preferences.reset("dummyName");
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Preferences after dummyName reset:");
            	logPreferences(preferences);
            }

            String preference =  preferences.getValue("dummyName", "defaultValue");
            if ("dummyValue".equals(preference)) {
                resetOccured = true;
            }
        } catch (ReadOnlyException ex) {
        	LOG.error(ex);
        } catch (ValidatorException ex) {
        	LOG.error(ex);
        } catch (IOException ex) {
        	LOG.error(ex);
        }

        if (setOccured && storeOccured && resetOccured) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (!setOccured || !storeOccured) {
        	result.setReturnCode(TestResult.WARNING);
        	result.setResults("A function upon which the reset test depends "
        			+ "failed to execute as expected. "
        			+ "Check the other test results in this test suite.");
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preferences value was not successfully reset after store");
        }
        return result;
    }
    
    /**
     * 
     * @param request  the portlet request.
     * @return
     */
    protected TestResult checkResetToNullPreferences(PortletRequest request) {
        
    	TestResult result = new TestResult();
        result.setName("Reset to Null Preference Test");
        result.setDesc("Tests that preferences are properly reset when originally null.");
        
        PortletPreferences preferences = request.getPreferences();
        boolean setOccured = false;
        boolean storeOccured = false;
        boolean resetOccured = false;
        try {
            preferences.setValue(BOGUS_KEY, "notTheOriginal");
            String pref = preferences.getValue(BOGUS_KEY, "Default");
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Original preferences:");
            	logPreferences(preferences);
            }
            if ("notTheOriginal".equals(pref)) {
                setOccured = true;
            }

            preferences.store();
            if ("notTheOriginal".equals(preferences.getValue(BOGUS_KEY, "Default"))) {
                storeOccured = true;
            }

            preferences.reset(BOGUS_KEY);
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Preferences after BOGUS_KEY reset:");
            	logPreferences(preferences);
            }

            String preference =  preferences.getValue(BOGUS_KEY, "defaultValue");
            if ("defaultValue".equals(preference)) {
                resetOccured = true;
            }
        } catch (ReadOnlyException ex) {
        	LOG.error(ex);
        } catch (ValidatorException ex) {
        	LOG.error(ex);
        } catch (IOException ex) {
        	LOG.error(ex);
        }

        if (setOccured && storeOccured && resetOccured) {
        	result.setReturnCode(TestResult.PASSED);
        } else if (!setOccured || !storeOccured) {
        	result.setReturnCode(TestResult.WARNING);
        	result.setResults("A function upon which the reset test depends failed to execute as expected. Check the other test results in this test suite.");
        } else {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Preferences value was not successfully reset after store.");
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
        res.setName("Preference Read Only Test");
        res.setDesc("Check to make sure that read only preferences may not be set.");

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
            res.setResults("Read Only Preference was written.");
        }

        return res;
    }

    protected TestResult checkGetPreferenceMap(PortletRequest req) {
        TestResult res = checkGetPreferenceNames(req);
        res.setName("Preference Map Test.");
        res.setDesc("Ensure returned map is valid");
        return res;
    }

    protected TestResult checkGetPreferenceNames(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Preference Names Enumeration Test.");
        res.setDesc("Ensure returned enumeration is valid");

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
            res.setResults("All names not found as preferences.");
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
    	res.setName("Preferences Map Not Modifiable Test.");
    	res.setDesc("Preferences values are not modified if the values " +
    			"in the Map are altered.");
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
    		res.setResults("Preferences values modified.");
    	} else {
    		res.setReturnCode(TestResult.PASSED);
    	}
    	return res;
    }

    
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
