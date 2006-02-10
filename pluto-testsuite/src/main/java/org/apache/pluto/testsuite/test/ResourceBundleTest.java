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

import org.apache.pluto.testsuite.TestResult;

import javax.portlet.*;
import java.util.*;

/**
 * Tests basic attribute retrieval and storage functions within
 * the portlet request, session, and context objects.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class ResourceBundleTest extends AbstractReflectivePortletTest {

    public Map doPrerequisiteAction(PortletContext context, ActionRequest req,
                                    ActionResponse res) {
        return new HashMap();

    }
//
// Begin Request Tests
//
    protected TestResult checkResourceBundleExists(PortletConfig config,
                                                   PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Get ResourceBundle Test");
        res.setDesc("Retrieves the resource bundle and ensures it's not null.");

        ResourceBundle rb = config.getResourceBundle(req.getLocale());
        if(rb != null) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults(TestResult.FAILED);
        }
        return res;
    }
    protected TestResult checkGetNames(PortletConfig config, PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Get Property Keys Test");
        res.setDesc("Retrieve the property names and ensure that the required keys are present.");

        ArrayList keys = new ArrayList();
        keys.add("javax.portlet.title");
        keys.add("javax.portlet.short-title");
        keys.add("javax.portlet.keywords");

        ResourceBundle rb = config.getResourceBundle(req.getLocale());
        Enumeration enumerator= rb.getKeys();
        while(enumerator.hasMoreElements()) {
            String key = enumerator.nextElement().toString();
            keys.remove(key);
        }

        if(keys.size() < 1) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            Iterator it = keys.iterator();
            while(it.hasNext()) {
                sb.append(it.next()).append(", ");
            }

            res.setResults("Keys: "+sb.toString()+" are not defined.");
        }

        return res;
    }

    protected TestResult checkGetGermanBundle(PortletConfig config,
                                             PortletRequest req) {
        return doGenericLocaleRequiredFields(config, req, Locale.GERMAN);
    }

    protected TestResult checkGetEnglishBundle(PortletConfig config,
                                              PortletRequest req) {
        return doGenericLocaleRequiredFields(config, req, Locale.ENGLISH);
    }

    /*
    protected TestResult checkGetDfltBundle(PortletConfig config,
                                            PortletRequest req) {
        return doGenericLocaleRequiredFields(config, req, new Locale("dflt"));
    }
    */

    private TestResult doGenericLocaleRequiredFields(PortletConfig config,
                                          PortletRequest req,
                                          Locale locale) {

        TestResult res = new TestResult();
        res.setName("Get Portlet Info for "+locale.getLanguage());
        res.setDesc("Retrieve the title and ensure it's set properly");

        String prefix = "_"+locale.getLanguage();

        if(!isBundleDeclared()) {
            prefix = "";
        }
        Map params = getInitParameters();
        ResourceBundle rb = config.getResourceBundle(locale);

        String eTitle = (String)params.get("title"+prefix);
        String eSTitle = (String)params.get("shorttitle"+prefix);
        String eKeywds = (String)params.get("keywords"+prefix);

        String title = rb.getString("javax.portlet.title");
        String sTitle = rb.getString("javax.portlet.short-title");
        String keywds = rb.getString("javax.portlet.keywords");

        StringBuffer sb = new StringBuffer();
        if(title==null || !title.trim().equals(eTitle.trim())) {
            sb.append("Title :'").append(title).append("' != '").append(eTitle).append("';");
        }
        if(sTitle==null || !sTitle.trim().equals(eSTitle.trim())) {
            sb.append("Short Title :'").append(sTitle).append("' != '").append(eSTitle).append("';");
        }
        if(keywds==null || !keywds.trim().equals(eKeywds.trim())) {
            sb.append("Keywords :'").append(keywds).append("' != '").append(eKeywds).append("' ");
        }

        if(sb.length() < 1) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            sb.insert(0, "The following information is not correct: ");
            res.setResults(sb.toString());
        }
        return res;
    }

    private boolean isBundleDeclared() {
        String param = (String)getInitParameters().get("resource-bundle");
        if(Boolean.TRUE.toString().equals(param)) {
            return true;
        }
        return false;
    }





}
