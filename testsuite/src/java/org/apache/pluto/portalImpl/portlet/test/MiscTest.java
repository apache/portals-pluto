package org.apache.pluto.portalImpl.portlet.test;

import java.util.Properties;
import java.util.Set;
import java.util.Enumeration;

import javax.portlet.PortletRequest;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.testsuite.ExpectedResults;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class MiscTest extends AbstractReflectivePortletTest {


    public String getTestSuiteName() {
        return "Misc Test";
    }

    protected TestResult checkContextServerInfo(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Server Info Test");
        res.setDesc("Make sure that the expected server info is returned.");
        Properties props = ExpectedResults.getExpectedProperties();
        System.out.println("PortalContext: "+req.getPortalContext());
        if(req.getPortalContext().getPortalInfo().equals(props.getProperty("expected.portalInfo"))) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            res.setResults("Server info: "+req.getPortalContext().getPortalInfo()+". Expected: "+props.getProperty("expected.portalInfo"));
        }
        return res;
    }

    /**
     * Test to ensure that the basic modes are supported.
     * @todo Enhance to check for custom modes.
     * @param req
     * @return
     */
    protected TestResult checkSupportedModes(PortletRequest req)  {
        TestResult res = new TestResult();
        res.setName("Supported Modes Test");
        res.setDesc("Make sure that the expected modes are returned.");

        boolean hasView = false;
        boolean hasEdit = false;
        boolean hasHelp = false;

        Enumeration enum = req.getPortalContext().getSupportedPortletModes();
        while(enum.hasMoreElements()) {
            PortletMode mode = (PortletMode)enum.nextElement();
            if(mode.equals(PortletMode.VIEW)) {
                hasView  = true;
            }
            else if(mode.equals(PortletMode.EDIT)) {
                hasEdit  = true;
            }
            else if(mode.equals(PortletMode.HELP)) {
                hasHelp  = true;
            }
        }

        if(hasView && hasEdit &&  hasHelp) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasView) {
                sb.append("'View' mode not found. ");
            }
            if(!hasEdit) {
                sb.append("'Edit' mode not found. ");
            }
            if(!hasHelp) {
                sb.append("'Help' mode not found. ");
            }
        }
        return res;
    }

    protected TestResult checkSupportedWindowSates(PortletRequest req) {
        TestResult res = new TestResult();
        res.setName("Supported Window States Test");
        res.setDesc("Make sure that the expected states are returned.");

        boolean hasMin = false;
        boolean hasMax = false;
        boolean hasNor = false;

        Enumeration enum = req.getPortalContext().getSupportedWindowStates();
        while(enum.hasMoreElements()) {
            WindowState mode = (WindowState)enum.nextElement();
            if(mode.equals(WindowState.MINIMIZED)) {
                hasMin  = true;
            }
            else if(mode.equals(WindowState.MAXIMIZED)) {
                hasMax  = true;
            }
            else if(mode.equals(WindowState.NORMAL)) {
                hasNor  = true;
            }
        }

        if(hasMin && hasMax &&  hasNor) {
            res.setReturnCode(TestResult.PASSED);
        }
        else {
            res.setReturnCode(TestResult.FAILED);
            StringBuffer sb = new StringBuffer();
            if(!hasMin) {
                sb.append("'Minimized' state not found. ");
            }
            if(!hasMax) {
                sb.append("'Maximized' state not found. ");
            }
            if(!hasNor) {
                sb.append("'Normal' state not found. ");
            }
        }
        return res;
    }

}
