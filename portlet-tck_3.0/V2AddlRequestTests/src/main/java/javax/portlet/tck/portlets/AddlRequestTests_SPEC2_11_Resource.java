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
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.ResourceURL;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.beans.TestSetupLink;

import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS17;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS7;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS6;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.ResourceURL.PORTLET;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlRequestTests_SPEC2_11_Resource_event
 * 
 * @author ahmed
 */
public class AddlRequestTests_SPEC2_11_Resource implements Portlet, ResourceServingPortlet {

  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {

    portletResp.setRenderParameters(portletReq.getParameterMap());
    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    String action = portletReq.getParameter("action");
    if (action != null) {
      if (action.equals("V2AddlRequestTests_SPEC2_11_Resource_parameters2")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_parameters2 */
        /* Details: "The parameters the request object returns must be */
        /* \"x-www-form-urlencoded\" decoded" */
        TestResult tr1 =
            tcd.getTestResultFailed("V2AddlRequestTests_SPEC2_11_Resource_parameters2");
        if (portletReq.getParameter("tr1") != null
            && portletReq.getParameter("tr1").equals("true&<>\"'")) {
          tr1.setTcSuccess(true);
        } else {
          tr1.appendTcDetail("tr1 paramater value:true&<>\"' is not decoded properly");
        }
        tr1.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Resource_parameters6")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_parameters6 */
        /* Details: "The getParameterMap method must return an unmodifiable */
        /* Map object" */
        TestResult tr2 = tcd.getTestResultFailed(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS6);
        if (portletReq.getParameterMap().containsKey("action")
            && "V2AddlRequestTests_SPEC2_11_Resource_parameters6"
                .equals(portletReq.getParameterMap().get("action")[0])) {
          String tr2TestStringArray[] = {"Modified Value"};
          try {
            portletReq.getParameterMap().put("action", tr2TestStringArray);
            if ("V2AddlRequestTests_SPEC2_11_Resource_parameters6"
                .equals(portletReq.getParameterMap().get("action")[0])) {
              tr2.setTcSuccess(true);
            }
          } catch (UnsupportedOperationException e) {
            tr2.setTcSuccess(true);
          }
        }
        tr2.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Resource_parameters17")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_parameters17 */
        /* Details: "If the cacheability level of the resource URL is PORTLET */
        /* or PAGE, the portlet must also receive the render parameters */
        /* present in the request in which the URL was created" */
        TestResult tr3 =
            tcd.getTestResultFailed("V2AddlRequestTests_SPEC2_11_Resource_parameters17");
        if (portletReq.getParameter("tr3") != null
            && portletReq.getParameter("tr3").equals("true")) {
          tr3.setTcSuccess(true);
        } else {
          tr3.appendTcDetail(
              "Render parameter tr3 is not included in resourceURL after setting cacheability level to PORTLET");
        }
        tr3.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters15")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters15 */
        /* Details: "A map of private parameters can be obtained through the */
        /* getPrivateParameterMap method" */
        TestResult tr4 = tcd
            .getTestResultFailed("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters15");
        Map<String, String[]> privateParamMap = portletReq.getPrivateParameterMap();
        if (privateParamMap != null && privateParamMap.containsKey("tr4")
            && privateParamMap.get("tr4")[0].equals("true")) {
          tr4.setTcSuccess(true);
        }
        tr4.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters16")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters16 */
        /* Details: "A map of public parameters can be obtained through the */
        /* getPublicParameterMap method" */
        TestResult tr5 = tcd
            .getTestResultFailed("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters16");
        if (portletReq.getPublicParameterMap() != null
            && portletReq.getPublicParameterMap().containsKey("tckPRP4")) {
          tr5.setTcSuccess(true);
        } else {
          tr5.appendTcDetail("No public render parameter found.");
        }
        tr5.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters7")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters7 */
        /* Details: "Public render parameters are available in the */
        /* serveResource method" */
        TestResult tr6 =
            tcd.getTestResultFailed("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters7");
        Map<String, String[]> publicParamMapTr6 = portletReq.getPublicParameterMap();
        if (publicParamMapTr6 != null && publicParamMapTr6.containsKey("tckPRP4")
            && publicParamMapTr6.get("tckPRP4")[0].equals("true")) {
          tr6.setTcSuccess(true);
        } else {
          tr6.appendTcDetail("Render parameter tckPRP4 is not found or is not equal to \"true\".");
        }
        tr6.writeTo(writer);
      } else if (action.equals("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters12")) {
        /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters12 */
        /* Details: "If the portlet sets a resource parameter with the same */
        /* name as a public render parameter, this results in a multi-valued */
        /* parameter. The public render parameter values must be the last */
        /* entries in the parameter value array" */
        TestResult tr7 = tcd
            .getTestResultFailed("V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters12");
        String[] mergedParamsTr7 = portletReq.getParameterValues("tckPRP4");
        if (mergedParamsTr7 != null && mergedParamsTr7.length == 2
            && mergedParamsTr7[0].equals("false") && mergedParamsTr7[1].equals("true")) {
          tr7.setTcSuccess(true);
        } else {
          tr7.appendTcDetail(
              "Render parameter tckPRP4 is not found or is not equal {\"false\",\"true\"}.");
        }
        tr7.writeTo(writer);
      } else {
        writer.write("\"action\" parameter value did not match the name of test case");
      }
    } else {
      writer.write("No \"action\" parameter was found in resourceURL");
    }
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    writer.write("<script type=\"text/javascript\" id=\"getResourceCall\">");
    writer.write("  function getResource(testCase, URL) {");
    writer.write("    var xhr = new XMLHttpRequest();");
    writer.write("    xhr.onreadystatechange=function() {");
    writer.write("      if (xhr.readyState==4 && xhr.status==200) {");
    writer.write("        document.getElementById(testCase).innerHTML = xhr.responseText;");
    writer.write("      }");
    writer.write("    };");
    writer.write("    xhr.open(\"POST\",URL,true);");
    writer.write("    xhr.send();");
    writer.write("  }");
    writer.write("</script>");


    /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_parameters2 */
    /* Details: "The parameters the request object returns must be */
    /* \"x-www-form-urlencoded\" decoded" */
    {
      ResourceURL resurlTr1 = portletResp.createResourceURL();
      resurlTr1.setParameter("action", "V2AddlRequestTests_SPEC2_11_Resource_parameters2");
      resurlTr1.setParameter("tr1", "true&<>\"'");
      writer.write("<DIV id=\"tr1\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr1','" + resurlTr1.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_parameters6 */
    /* Details: "The getParameterMap method must return an unmodifiable */
    /* Map object" */
    {
      ResourceURL resurlTr2 = portletResp.createResourceURL();
      resurlTr2.setParameter("action", "V2AddlRequestTests_SPEC2_11_Resource_parameters6");
      writer.write("<DIV id=\"tr2\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr2','" + resurlTr2.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_parameters17 */
    /* Details: "If the cacheability level of the resource URL is PORTLET */
    /* or PAGE, the portlet must also receive the render parameters */
    /* present in the request in which the URL was created" */
    {
      if (portletReq.getParameter("tr3") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tr3", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PARAMETERS17, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr3 = portletResp.createResourceURL();
        resurlTr3.setCacheability(PORTLET);
        resurlTr3.setParameter("action", "V2AddlRequestTests_SPEC2_11_Resource_parameters17");
        writer.write("<DIV id=\"tr3\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr3','" + resurlTr3.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters15 */
    /* Details: "A map of private parameters can be obtained through the */
    /* getPrivateParameterMap method" */
    {
      ResourceURL resurlTr4 = portletResp.createResourceURL();
      resurlTr4.setParameter("action",
          "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters15");
      resurlTr4.setParameter("tr4", "true");
      writer.write("<DIV id=\"tr4\"></DIV>");
      writer.write("<script type=\"text/javascript\">");
      writer.write("getResource('tr4','" + resurlTr4.toString() + "');");
      writer.write("</script>");
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters16 */
    /* Details: "A map of public parameters can be obtained through the */
    /* getPublicParameterMap method" */
    {
      if (portletReq.getParameter("tckPRP4") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP4", "true");
        TestSetupLink tl = new TestSetupLink(
            "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters16", purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr5 = portletResp.createResourceURL();
        resurlTr5.setParameter("action",
            "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters16");
        writer.write("<DIV id=\"tr5\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr5','" + resurlTr5.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters7 */
    /* Details: "Public render parameters are available in the */
    /* serveResource method" */
    {
      if (portletReq.getParameter("tckPRP4") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP4", "true");
        TestSetupLink tl =
            new TestSetupLink(V2ADDLREQUESTTESTS_SPEC2_11_RESOURCE_PUBLICRENDERPARAMETERS7, purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr6 = portletResp.createResourceURL();
        resurlTr6.setParameter("action",
            "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters7");
        writer.write("<DIV id=\"tr6\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr6','" + resurlTr6.toString() + "');");
        writer.write("</script>");
      }
    }

    /* TestCase: V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters12 */
    /* Details: "If the portlet sets a resource parameter with the same */
    /* name as a public render parameter, this results in a multi-valued */
    /* parameter. The public render parameter values must be the last */
    /* entries in the parameter value array" */
    {
      if (portletReq.getParameter("tckPRP4") == null) {
        PortletURL purl = portletResp.createRenderURL();
        purl.setParameter("tckPRP4", "true");
        TestSetupLink tl = new TestSetupLink(
            "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters12", purl);
        tl.writeTo(writer);
      } else {
        ResourceURL resurlTr7 = portletResp.createResourceURL();
        resurlTr7.setParameter("tckPRP4", "false");
        resurlTr7.setParameter("action",
            "V2AddlRequestTests_SPEC2_11_Resource_publicRenderParameters12");
        writer.write("<DIV id=\"tr7\"></DIV>");
        writer.write("<script type=\"text/javascript\">");
        writer.write("getResource('tr7','" + resurlTr7.toString() + "');");
        writer.write("</script>");
      }
    }
  }

}
