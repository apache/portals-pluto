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
package org.apache.pluto.portalImpl.portlet.test;

import java.util.Map;
import java.util.Enumeration;
import java.io.IOException;

import javax.portlet.PortletRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class SimplePreferenceTest
 extends ActionAbstractReflectivePortletTest
 implements ActionTest {

    private static final String BOGUS_KEY = "org.apache.pluto.testsuite.BOGUS_KEY";

    public String getTestSuiteName() {
        return "Simple Preferences Test";
    }

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
        boolean exceptionThrown = false;
        try {
            preferences.setValue("VALIDATION_TEST_KEY", " Spaces removed by trim ");
            preferences.store();
        }
        catch (ReadOnlyException roe) {

        }
        catch (ValidatorException e) {
            exceptionThrown = true;
            try { preferences.reset("VALIDATION_TEST_KEY"); }catch(Throwable t) {}
        }
        catch (IOException io) {

        }

        if(exceptionThrown) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
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
        catch(ReadOnlyException roe) {

        }
        catch(ValidatorException ve) {

        }
        catch(IOException io) {

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

    protected TestResult checkResetPreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Reset Preference Test");
        res.setDesc("Tests that preferences are properly reset.");
        PortletPreferences preferences = req.getPreferences();
        boolean setOccured = false;
        boolean storeOccured = false;
        boolean resetOccured = false;
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

            String preference =  preferences.getValue("dummyName", "defaultValue");
            if(preference.equals("dummyValue")) {
                resetOccured = true;
            }
        }
        catch(ReadOnlyException roe) {
            roe.printStackTrace();
        }
        catch(ValidatorException ve) {
            ve.printStackTrace();
        }
        catch(IOException io) {
            io.printStackTrace();
        }

        if(setOccured && storeOccured && resetOccured) {
            res.setReturnCode(TestResult.PASSED);
        }
        else if(!setOccured || !storeOccured) {
            res.setReturnCode(TestResult.WARNING);
            res.setResults("A function upon which the reset test depends failed to execute as expected. Check the other test results in this test suite.");
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was not successfully reset after store");
        }

        return res;
    }

    protected TestResult checkResetToNullPreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Reset to Null Preference Test");
        res.setDesc("Tests that preferences are properly reset when originally null.");
        PortletPreferences preferences = req.getPreferences();
        boolean setOccured = false;
        boolean storeOccured = false;
        boolean resetOccured = false;
        try {
            preferences.setValue(BOGUS_KEY, "notTheOriginal");
            String pref = preferences.getValue(BOGUS_KEY, "Default");
            if("notTheOriginal".equals(pref)) {
                setOccured = true;
            }

            preferences.store();
            if("notTheOriginal".equals(preferences.getValue(BOGUS_KEY, "Default"))) {
                storeOccured = true;
            }

            preferences.reset(BOGUS_KEY);

            String preference =  preferences.getValue(BOGUS_KEY, "defaultValue");
            if("defaultValue".equals(preference)) {
                resetOccured = true;
            }
        }
        catch(ReadOnlyException roe) {
            roe.printStackTrace();
        }
        catch(ValidatorException ve) {
            ve.printStackTrace();
        }
        catch(IOException io) {
            io.printStackTrace();
        }

        if(setOccured && storeOccured && resetOccured) {
            res.setReturnCode(TestResult.PASSED);
        }
        else if(!setOccured || !storeOccured) {
            res.setReturnCode(TestResult.WARNING);
            res.setResults("A function upon which the reset test depends failed to execute as expected. Check the other test results in this test suite.");
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Preferences value was not successfully reset after store.");
        }
        return res;
    }

    protected TestResult checkReadOnlyPreferences(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Preference Read Only Test");
        res.setDesc("Check to make sure that read only preferences may not be set.");

        PortletPreferences preferences = req.getPreferences();
        boolean exceptionThrown = false;
        try {
            preferences.setValue("readonly", "written");
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
        Enumeration enum = prefs.getNames();
        boolean hasAll = true;
        while(enum.hasMoreElements()) {
            if(!map.containsKey(enum.nextElement())) {
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


}
