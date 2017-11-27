/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS13;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS6;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS16;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13A;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS10;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS15;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_Render_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_Render implements Portlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @SuppressWarnings("deprecation")
@Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    String action = portletReq.getParameter("inputval");
    if (V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS10.equals(action)
        && portletReq.getParameter("actionURLTr0") != null
        && portletReq.getParameter("actionURLTr0").equals("true")) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters10 */
      /* Details: "The portlet-container must not propagate parameters */
      /* received in an action or event request to subsequent render */
      /* requests of the portlet" */
      portletResp.setRenderParameter("tr0", "true");
    } else if (V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15.equals(action)
        && portletReq.getParameter("tr3a") != null
        && portletReq.getParameter("tr3a").equals("true")) {
       /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters15 */
       /* Details: "Render parameters get automatically cleared if the */
       /* portlet receives a processAction or processEvent call" */
      portletResp.setRenderParameter("tr3b", "true");
    } else {
      portletResp.setRenderParameters(portletReq.getParameterMap());
    }

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

  }

  @SuppressWarnings("deprecation")
@Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    String action = portletReq.getParameter("inputval");
    Boolean successTr2 = false, successTr5 = false, successTr6 = false;
    Boolean successTr7 = false, successTr8 = false, successTr13 = false;
    // Create result objects for the tests

    /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters10 */
    /* Details: "The portlet-container must not propagate parameters */
    /* received in an action or event request to subsequent render */
    /* requests of the portlet" */
    if (portletReq.getParameter("actionURLTr0") == null && portletReq.getParameter("tr0") != null
        && "true".equals(portletReq.getParameter("tr0"))) {
      TestResult tr0 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS10);
      tr0.setTcSuccess(true);
      tr0.writeTo(writer);
    } else {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      aurl.setParameter("actionURLTr0", "true");
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS10, aurl);
      tb.writeTo(writer);
    }

    if (action != null) {
      if (action.equals("V2AddlRequestTests_SPEC2_11_Render_parameters13")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters13 */
        /* Details: "If a portlet receives a render request that is the */
        /* result of invoking a render URL targeting this portlet the render */
        /* parameters received with the render request must be the parameters */
        /* set on the render URL" */
        TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS13);
        if (portletReq.getParameter("renderURLTr2") != null
            && portletReq.getParameter("tr2") != null && portletReq.getParameter("renderURLTr2")
                .contains("tr2:" + portletReq.getParameter("tr2"))) {
          tr2.setTcSuccess(true);
          successTr2 = true;
        } else {
          tr2.appendTcDetail(
              "Parameter renderURLTr2 is missing or does not contain tr2 parameter value.");
        }
        tr2.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Render_parameters2")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters2 */
        /* Details: "The parameters the request object returns must be */
        /* \"x-www-form-urlencoded\" decoded" */
        TestResult tr5 = tcd.getTestResultFailed("V2AddlRequestTests_SPEC2_11_Render_parameters2");
        if (portletReq.getParameter("tr5") != null
            && portletReq.getParameter("tr5").equals("true&<>'")) {
          tr5.setTcSuccess(true);
          successTr5 = true;
        }
        tr5.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Render_parameters6")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters6 */
        /* Details: "The getParameterMap method must return an unmodifiable */
        /* Map object" */
        TestResult tr6 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS6);
        if (portletReq.getParameterMap().containsKey("inputval")
            && "V2AddlRequestTests_SPEC2_11_Render_parameters6"
                .equals(portletReq.getParameterMap().get("inputval")[0])) {
          String tr6TestStringArray[] = {"Modified Value"};
          try {
            portletReq.getParameterMap().put("inputval", tr6TestStringArray);
            if ("V2AddlRequestTests_SPEC2_11_Render_parameters6"
                .equals(portletReq.getParameterMap().get("inputval")[0])) {
              tr6.setTcSuccess(true);
              successTr6 = true;
            }
          } catch (UnsupportedOperationException e) {
            tr6.setTcSuccess(true);
            successTr6 = true;
          }
        }
        tr6.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters15")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters15 */
        /* Details: "A map of private parameters can be obtained through the */
        /* getPrivateParameterMap method" */
        TestResult tr7 =
            tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS15);
        Map<String, String[]> privateParamMap = portletReq.getPrivateParameterMap();
        if (privateParamMap != null && privateParamMap.containsKey("tr7")
            && privateParamMap.get("tr7")[0].equals("true")) {
          tr7.setTcSuccess(true);
          successTr7 = true;
        }
        tr7.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters16")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters16 */
        /* Details: "A map of public parameters can be obtained through the */
        /* getPublicParameterMap method" */
        TestResult tr8 =
            tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS16);
        if (portletReq.getPublicParameterMap() != null
            && portletReq.getPublicParameterMap().containsKey("tckPRP3")) {
          tr8.setTcSuccess(true);
          successTr8 = true;
        } else {
          tr8.appendTcDetail("No public render parameter found.");
        }
        tr8.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13a")) {
         /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13a */
         /* Details: "A public render parameter can be deleted using the */
         /* removePublicRenderParameter method on the PortletURL" */
        TestResult tr13 =
            tcd.getTestResultFailed("V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13a");
        if (portletReq.getPublicParameterMap() != null
            && !portletReq.getPublicParameterMap().containsKey("tckPRP3")) {
          tr13.setTcSuccess(true);
          successTr13 = true;
        } else {
          tr13.appendTcDetail("Render parameter tckPRP3 is not removed.");
        }
        tr13.writeTo(writer);
      }
    }
    
    if (!successTr2) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters13 */
      /* Details: "If a portlet receives a render request that is the */
      /* result of invoking a render URL targeting this portlet the render */
      /* parameters received with the render request must be the parameters */
      /* set on the render URL" */
      PortletURL rurl = portletResp.createRenderURL();
      rurl.setParameters(portletReq.getPrivateParameterMap());
      rurl.setParameter("tr2", "true");
      rurl.setParameter("renderURLTr2", rurl.toString());
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS13, rurl);
      tb.writeTo(writer);
    }

    if (!successTr5) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters2 */
      /* Details: "The parameters the request object returns must be */
      /* \"x-www-form-urlencoded\" decoded" */
      PortletURL purl = portletResp.createRenderURL();
      purl.setParameter("tr5", "true&<>'");
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS2, purl);
      tb.writeTo(writer);
    }

    if (!successTr6) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters6 */
      /* Details: "The getParameterMap method must return an unmodifiable */
      /* Map object" */
      PortletURL purl = portletResp.createRenderURL();
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS6, purl);
      tb.writeTo(writer);
    }

    if (!successTr7) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters15 */
      /* Details: "A map of private parameters can be obtained through the */
      /* getPrivateParameterMap method" */
      PortletURL purl = portletResp.createRenderURL();
      purl.setParameter("tr7", "true");
      TestButton tb =
          new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS15, purl);
      tb.writeTo(writer);
    }

    if (!successTr8) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters16 */
      /* Details: "A map of public parameters can be obtained through the */
      /* getPublicParameterMap method" */
      if (portletReq.getParameter("tckPRP3") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP3", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS16, purl);
        tl.writeTo(writer);
      } else {
        PortletURL aurl = portletResp.createRenderURL();
        aurl.setParameters(portletReq.getPrivateParameterMap());
        TestButton tb =
            new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS16, aurl);
        tb.writeTo(writer);
      }
    }

    if (!successTr13) {
      /* TestCase: V2AddlRequestTests_SPEC2_11_Render_publicRenderParameters13a */
      /* Details: "A public render parameter can be deleted using the */
      /* removePublicRenderParameter method on the PortletURL" */
      if (portletReq.getParameter("tckPRP3") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP3", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13A, purl);
        tl.writeTo(writer);
      } else {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameters(portletReq.getPrivateParameterMap());
        purl.removePublicRenderParameter("tckPRP3");
        TestButton tb =
            new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PUBLICRENDERPARAMETERS13A, purl);
        tb.writeTo(writer);
      }
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters15 */
    /* Details: "Render parameters get automatically cleared if the */
    /* portlet receives a processAction or processEvent call" */
    if (portletReq.getParameter("tr3a") != null) {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      aurl.setParameter("tr3a", portletReq.getParameter("tr3a"));
      TestButton tb = new TestButton(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15, aurl);
      tb.writeTo(writer);
    } else {
      if (portletReq.getParameter("tr3b") != null
          && portletReq.getParameter("tr3b").equals("true")) {
        TestResult tr3 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15);
        tr3.setTcSuccess(true);
        tr3.writeTo(writer);
      } else {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr3a", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS15, purl);
        tl.writeTo(writer);
      }
    }
    
    /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters11 */
    /* Details: "If a portlet receives a render request that is the */
    /* result of a client request targeted to another portlet in the */
    /* portal page, the parameters should be the same parameters as of */
    /* the previous render request from this client" */
    {
       PortletURL rurl = portletResp.createRenderURL();
       rurl.setParameters(portletReq.getPrivateParameterMap());
       rurl.setParameter("tr1_ready", "true");
       TestLink tb = new TestLink(V2ADDLREQUESTTESTS_SPEC2_11_RENDER_PARAMETERS11, rurl);
       tb.writeTo(writer);
    }
    
  }
}
