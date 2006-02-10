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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

/**
 * Tests basic attribute retrieval and storage functions within the portlet
 * request, session, and context objects.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class SimpleAttributeTest extends AbstractReflectivePortletTest {
	
    private static final String KEY = "org.apache.pluto.testsuite.BOGUS_KEY";
    private static final String VAL = "! TEST VAL !";

    public Map doPrerequisiteAction(PortletContext context, ActionRequest req,
                                    ActionResponse res) {
        return new HashMap();

    }
    
    
    // Protected Test Methods --------------------------------------------------
    
    protected TestResult checkGetNullAttribute(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Retrieve Missing Request Attribute Test");
        res.setDesc("Retrieves an attribute bound to an invalid key set are retrieved as null");

        Object val = req.getAttribute(KEY);
        if(val != null) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' for attribute '"+KEY+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }


    protected TestResult checkSetAttribute(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Set Request Attribute Test");
        res.setDesc("Sets and retrieves portlet request attribute.");

        req.setAttribute(KEY, VAL);
        Object val = req.getAttribute(KEY);
        if(!VAL.equals(val)) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' - Expected '"+VAL+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }

        req.removeAttribute(KEY);
        return res;
    }

    protected TestResult checkRemoveAttribute(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Remove Request Attribute Test");
        res.setDesc("Sets, removes and retrieves portlet request attribute.");

        req.setAttribute(KEY, VAL);
        req.removeAttribute(KEY);
        Object val = req.getAttribute(KEY);
        if(val!=null) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' - Expected '"+VAL+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }

        return res;
    }

    protected TestResult checkEnumerateAttributes(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Enumerate Request Attribute Names Test");
        res.setDesc("Sets request attributes and enumerates over them.");

        int count = 5;
        for(int i=0;i<count;i++) {
            req.setAttribute(KEY+"."+i,VAL);
        }

        int found = 0;
        Enumeration enumerator= req.getAttributeNames();
        while(enumerator.hasMoreElements()) {
            if(enumerator.nextElement().toString().startsWith(KEY)) {
                found++;
            }
        }

        if(count != found) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected "+count+" attributes.  Found "+found);
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }

//
// Begin Session Tests
//

    protected TestResult checkGetNullAttribute(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Retrieve Missing Session Attribute Test");
        res.setDesc("Retrieves an attribute bound to an invalid key set are retrieved as null");

        Object val = session.getAttribute(KEY);
        if(val != null) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' for attribute '"+KEY+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }

    protected TestResult checkSetAttribute(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Set Attribute Test");
        res.setDesc("Sets and retrieves portlet sessionuest attribute.");

        session.setAttribute(KEY, VAL);
        Object val = session.getAttribute(KEY);
        if(!VAL.equals(val)) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' - Expected '"+VAL+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }

        session.removeAttribute(KEY);
        return res;
    }

    protected TestResult checkRemoveAttribute(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Remove Session Attribute Test");
        res.setDesc("Sets, removes and retrieves portlet request attribute.");

        session.setAttribute(KEY, VAL);
        session.removeAttribute(KEY);
        Object val = session.getAttribute(KEY);
        if(val!=null) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' - Expected '"+VAL+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }

        return res;
    }

    protected TestResult checkEnumerateAttributes(PortletSession session) {
    	
        TestResult result = new TestResult();
        result.setName("Enumerate Session Attribute Names Test");
        result.setDesc("Sets request attributes and enumerates over them.");
        
        int count = 5;
        for (int i = 0; i < count; i++) {
        	session.setAttribute(KEY + "." + i, VAL);
        }

        int found = 0;
        for (Enumeration en = session.getAttributeNames();
        		en.hasMoreElements(); ) {
        	String name = (String) en.nextElement();
            if (name.startsWith(KEY)) {
                found++;
            }
            // FIXME:
            System.err.println("\n\n\n\n");
            System.err.println("Got attribute name in session: " + name);
            System.err.println("\n\n\n\n");
        }
        
        if (count != found) {
        	result.setReturnCode(TestResult.FAILED);
        	result.setResults("Expected " + count + " attributes. "
        			+ "Found " + found);
        } else {
        	result.setReturnCode(TestResult.PASSED);
        }
        return result;
    }

//
// Context Tests
//

    protected TestResult checkGetNullAttribute(PortletContext context) {
        TestResult res = new TestResult();
        res.setName("Retrieve Missing Context Attribute Test");
        res.setDesc("Retrieves an attribute bound to an invalid key set are retrieved as null");

        Object val = context.getAttribute(KEY);
        if(val != null) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' for attribute '"+KEY+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }

    protected TestResult checkSetAttribute(PortletContext context) {
        TestResult res = new TestResult();
        res.setName("Set Attribute Test");
        res.setDesc("Sets and retrieves portlet contextuest attribute.");

        context.setAttribute(KEY, VAL);
        Object val = context.getAttribute(KEY);
        if(!VAL.equals(val)) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' - Expected '"+VAL+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }

        context.removeAttribute(KEY);
        return res;
    }

    protected TestResult checkRemoveAttribute(PortletContext context) {
        TestResult res = new TestResult();
        res.setName("Remove Context Attribute Test");
        res.setDesc("Sets, removes and retrieves portlet request attribute.");

        context.setAttribute(KEY, VAL);
        context.removeAttribute(KEY);
        Object val = context.getAttribute(KEY);
        if(val!=null) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Retrieved value: '"+val+"' - Expected '"+VAL+"'");
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }

        return res;
    }

    protected TestResult checkEnumerateAttributes(PortletContext req) {
        TestResult res = new TestResult();
        res.setName("Enumerate Context Attribute Names Test");
        res.setDesc("Sets request attributes and enumerates over them.");

        int count = 5;
        for(int i=0;i<count;i++) {
            req.setAttribute(KEY+"."+i,VAL);
        }

        int found = 0;
        Enumeration enumerator= req.getAttributeNames();
        while(enumerator.hasMoreElements()) {
            if(enumerator.nextElement().toString().startsWith(KEY)) {
                found++;
            }
        }

        if(count != found) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected "+count+" attributes.  Found "+found);
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }

}
