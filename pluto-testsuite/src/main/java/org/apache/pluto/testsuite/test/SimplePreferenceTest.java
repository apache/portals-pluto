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
 */
public class SimplePreferenceTest extends ActionAbstractReflectivePortletTest
implements ActionTest {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(SimplePreferenceTest.class);
    
    private static final String BOGUS_KEY = "org.apache.pluto.testsuite.BOGUS_KEY";

    public String getTestSuiteName() {
        return "Simple Preferences Test";
    }
    
    
    // Test Methods ------------------------------------------------------------
    
    protected TestResult checkGetEmptyPreference(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Get Empty Preference Test");
        res.setDesc("Ensure proper default is returned when a non-existing preference is requested.");
        PortletPreferences preferences = req.getPreferences();
        String preference =  preferences.getValue("nonexistence!", "Default");
        if(preference.equals("Default")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was '"+preference+"' expected 'permanent'.");
        }
        return res;
    }

    protected TestResult checkGetEmptyPreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Get Empty Preferences Test");
        res.setDesc("Ensure proper defaults are returned when a non-existent preference set is requested.");
        PortletPreferences preferences = req.getPreferences();
        String[] preference = preferences.getValues("nonexistence!", new String[] {"Default"});
        if(preference.length == 1 && preference[0].equals("Default")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was '"+preference[0]+"' expected 'permanent'.");
        }
        return res;
    }


    protected TestResult checkGetPreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Get Preference Test");
        res.setDesc("Tests that preferences defined in the deployment descriptor may be retrieved.");
        PortletPreferences preferences = req.getPreferences();
        String preference =  preferences.getValue("dummyName", "defaultValue");
        if(preference.equals("dummyValue")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was '"+preference+"' expected 'dummyValue'.");
        }
        return res;
    }

    protected TestResult checkSetPreference(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Set Preference  Test");
        res.setDesc("Ensure a single preference can be set");

        PortletPreferences preferences = req.getPreferences();
        try {
            preferences.setValue("TEST", "TEST_VALUE");
        }
        catch(ReadOnlyException roe) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults(roe.getMessage());
            return res;
        }

        String preference = preferences.getValue("TEST", "Error!");
        if(preference.equals("TEST_VALUE")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was '"+preference+"' expected 'permanent'.");
        }
        return res;
    }

    protected TestResult checkSetPreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Set Preferences Test");
        res.setDesc("Ensure preferences can be set.");

        PortletPreferences preferences = req.getPreferences();
        try {
            preferences.setValues("TEST", new String[] {"TEST_VALUE", "ANOTHER"});
        }
        catch(ReadOnlyException roe) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults(roe.getMessage());
            return res;
        }

        String[] preference = preferences.getValues("TEST", new String[] { "Error!" });
        if(preference.length == 2 && preference[0].equals("TEST_VALUE") &&
           preference[1].equals("ANOTHER")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was '"+preference+"' expected 'permanent'.");
        }
        return res;
    }

    protected TestResult checkSetPreferencesReturnsFirst(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Set Preferences Test");
        res.setDesc("Ensure preferences can be set.");

        PortletPreferences preferences = req.getPreferences();
        try {
            preferences.setValues("TEST", new String[] {"TEST_VALUE", "ANOTHER"});
        }
        catch(ReadOnlyException roe) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults(roe.getMessage());
            return res;
        }

        String preference = preferences.getValue("TEST", "Error!");
        if(preference.equals("TEST_VALUE")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was '"+preference+"' expected 'permanent'.");
        }
        return res;
    }

    protected TestResult checkPreferenceValidator(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Preference Validator Test");
        res.setDesc("Check to make sure that the validator catches invalid preferences.");

        PortletPreferences preferences = req.getPreferences();
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Original preferences:");
        	logPreferences(preferences);
        }
        boolean exceptionThrown = false;
        try {
            preferences.setValue("VALIDATION_TEST_KEY", " Spaces removed by trim ");
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Modified VALIDATION_TEST_KEY preference:");
            	logPreferences(preferences);
            }
            preferences.store();
        } catch (ReadOnlyException e) {
        	LOG.error(e);
        } catch (ValidatorException e) {
        	//We should get here.
            exceptionThrown = true;
            try {
            	//get rid of spaces because it causes problems with reset() call.
                preferences.setValue("VALIDATION_TEST_KEY", "OK");
            	preferences.reset("VALIDATION_TEST_KEY");
            } catch (Throwable t) {
            	LOG.error(t);            	
            }
        } catch (IOException e) {
        	LOG.error(e);
        }

        if (exceptionThrown) {
            res.setReturnCode(TestResult.PASSED);
        } else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Illegal value not caught by validator.");
        }
        return res;
    }

    protected TestResult checkStorePreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Preference Store Test");
        res.setDesc("Ensure storage works.");

        PortletPreferences preferences = req.getPreferences();
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Preferences to store: " + preferences);
        }
        boolean setOccured = false;
        boolean storeOccured = false;
        try {
            preferences.setValue("dummyName", "notTheOriginal");
            String pref = preferences.getValue("dummyName", "Default");
            if("notTheOriginal".equals(pref)) {
                setOccured = true;
            }

            preferences.store();
            
            if("notTheOriginal".equals(preferences.getValue("dummyName", "Default"))) {
                storeOccured = true;
            }

            preferences.reset("dummyName");
        }
        catch(ReadOnlyException e) {
        	LOG.error("ReadOnly problem: ", e);
        }
        catch(ValidatorException e) {
        	LOG.error("Validation problem: ",e);
        }
        catch(IOException e) {
        	LOG.error("IO problem: ", e);
        }

        if(setOccured && storeOccured) {
            res.setReturnCode(TestResult.PASSED);
        }
        else if (!setOccured) {
            res.setReturnCode(TestResult.WARNING);
            res.setResults("A function upon which the reset test depends failed to execute as expected. Check the other test results in this test suite.");
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences not successfully stored.");
        }
        return res;
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
