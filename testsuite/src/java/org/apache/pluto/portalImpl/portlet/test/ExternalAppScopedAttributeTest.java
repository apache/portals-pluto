package org.apache.pluto.portalImpl.portlet.test;

import javax.portlet.PortletSession;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class ExternalAppScopedAttributeTest extends AbstractReflectivePortletTest {

    public static final String INT_KEY = "org.apache.pluto.testsuite.INTERNALLY_SET_APP_SCOPED_SESSION_TEST_KEY";
    public static final String EXT_KEY = "org.apache.pluto.testsuite.EXTERNALLY_SET_APP_SCOPED_SESSION_TEST_KEY";
    public static final String VALUE = "Should be visible to all Portlets and Web Resources.";

    public String getTestSuiteName() {
        return "External Application Scoped Attribute Test";
    }

    public TestResult checkSetHereSeenElsewhere(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Session Visibility Test");
        res.setDesc("Ensure application scoped attributes set here can be seen elsewhere.");
        res.setReturnCode(TestResult.WARNING);
        res.setResults("Click the provided link to validate test.");

        session.setAttribute(INT_KEY, VALUE, PortletSession.APPLICATION_SCOPE);
        return res;
    }

    public TestResult checkSetElsewhereSeenHere(PortletSession session) {
        TestResult res = new TestResult();
        res.setName("Session Visibility Test");
        res.setDesc("Ensure application scoped attributes set elsewhere can be seen here.");

        Object val = session.getAttribute(EXT_KEY, PortletSession.APPLICATION_SCOPE);
        if(VALUE.equals(val)) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.WARNING);
            res.setResults("This test will not pass until you have opened the external resource using the link provided below.");
        }
        return res;
    }
}
