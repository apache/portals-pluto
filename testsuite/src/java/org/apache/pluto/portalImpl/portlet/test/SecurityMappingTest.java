package org.apache.pluto.portalImpl.portlet.test;

import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class SecurityMappingTest extends AbstractReflectivePortletTest {

    public String getTestSuiteName() {
        return "Security Mapping Tests";
    }

    public Map doPrerequisiteAction(PortletContext context, ActionRequest req,
                                    ActionResponse res) {
        return new java.util.HashMap();
    }

    protected TestResult checkIsUserInMappedRole(PortletRequest req) {
        TestResult res = isUserLoggedIn(req);
        res.setName("User In Mapped Role Test");
        res.setDesc("Test if user is in mapped role");
        if(TestResult.WARNING.equals(res.getReturnCode())) {
            return res;
        }

        if(req.isUserInRole("plutoTestRole")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.WARNING);
            res.setReturnCode("User is not in the expected 'tomcat' role.  This may be due to misconfiuration.");
        }

        return res;
    }

    protected TestResult checkIsUserInUnmappedRole(PortletRequest req) {
        TestResult res = isUserLoggedIn(req);
        res.setName("User In Unmapped Role Test");
        res.setDesc("Test if user is in unmapped role");
        if(TestResult.WARNING.equals(res.getReturnCode())) {
            return res;
        }

        if(req.isUserInRole("tomcat")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.WARNING);
            res.setReturnCode("User is not in the expected 'tomcat' role.  This may be due to misconfiuration.");
        }

        return res;
    }

    protected TestResult checkIsUserIndUndeclaredRole(PortletRequest req) {
        TestResult res = isUserLoggedIn(req);
        res.setName("User In Role Test");
        res.setDesc("Test if user is in undeclared role");
        if(TestResult.WARNING.equals(res.getReturnCode())) {
            return res;
        }

        if(!req.isUserInRole("fakeTestRoleFooBar")) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setReturnCode("User is in the fake role named 'fakeTestRoleFooBar'");
        }

        return res;
    }


    private TestResult isUserLoggedIn(PortletRequest req) {
        if(req.getRemoteUser()==null) {
            TestResult res = new TestResult();
            res.setReturnCode(TestResult.WARNING);
            res.setResults("User is not logged in.");
            return res;
        }
        else return new TestResult();
    }
}
