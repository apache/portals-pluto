package org.apache.pluto.portalImpl.portlet.test;

import java.util.Map;
import java.util.HashMap;
import java.util.Enumeration;

import javax.portlet.PortletContext;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class SimpleParameterTest extends AbstractReflectivePortletTest {
    public static final String KEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY";
    public static final String VALUE = "org.apache.pluto.testsuite.PARAM_TEST_VALUE";

    private static final String IKEY = "org.apache.pluto.testsuite.PARAM_TEST_KEY";

    public String getTestSuiteName() {
        return "Simple Parameter Test";
    }

    public Map getRenderParameters(PortletRequest req) {
        Map map = new HashMap(req.getParameterMap());
        map.put(IKEY, new String[] {VALUE});
        return map;
    }

    protected TestResult checkSentParameters(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Sent Parameter Test");
        res.setDesc("Ensure that parameters sent through the action query stream have made it all the way through");

        String val = req.getParameter(KEY);
        if(val == null || !VALUE.equals(val)) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected : "+VALUE+" retrieved "+val);
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }


    protected TestResult checkInternalRenderParameters(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Render Parameters Test");
        res.setDesc("Enumerate through all render parameters sent in the action");

        String val = req.getParameter(IKEY);
        if(val == null || !VALUE.equals(val)) {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Expected : "+VALUE+" retrieved "+val);
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }

    protected TestResult checkParameterNames(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Test Parameter Names Enumeration.");
        res.setDesc("Enumerate through all expected names.");

        boolean hasExternal = false;
        boolean hasInternal = false;
        Enumeration enum = req.getParameterNames();
        while(enum.hasMoreElements()) {
            String val = enum.nextElement().toString();
            if(KEY.equals(val)) {
                hasExternal = true;
            }
            if(IKEY.equals(val)) {
                hasInternal = true;
            }
        }
        if(!hasInternal || !hasExternal) {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasInternal) {
                sb.append("Internal Parameter Not Found. ");
            }
            if(!hasExternal) {
                sb.append("External Parameter Not Found. ");
            }
            res.setResults(sb.toString());
        }
        else {
            res.setReturnCode(TestResult.PASSED);
        }
        return res;
    }
}
