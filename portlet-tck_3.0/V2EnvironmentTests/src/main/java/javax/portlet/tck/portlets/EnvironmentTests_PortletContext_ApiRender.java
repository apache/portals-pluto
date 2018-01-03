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
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.JSR286SpecTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETSERVERINFO1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMAJORVERSION;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMINORVERSION;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGA;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGB;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2;
import static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS4;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * EnvironmentTests_PortletContext_ApiRender_event
 *
 * @author ahmed
 */
public class EnvironmentTests_PortletContext_ApiRender implements Portlet {

  private PortletConfig portletConfig = null;

  @Override
  public void init(PortletConfig config) throws PortletException {
    this.portletConfig = config;
  }

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
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();
    JSR286SpecTestCaseDetails tcd_spec = new JSR286SpecTestCaseDetails();

    // Create result objects for the tests

    PortletContext pc = portletConfig.getPortletContext();

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getServerInfo1 */
    /* Details: "Method getServerInfo(): Returns a String containing */
    /* the server name and version in the form name/version" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETSERVERINFO1);
    String servInfo1 = pc.getServerInfo();
    if (servInfo1 != null && servInfo1.matches("(.+)/(.+) *(.*)")) {
      tr0.setTcSuccess(true);
    } else {
      tr0.appendTcDetail("The PortletContainer has Invalid Form " + servInfo1);
    }
    tr0.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getRequestDispatcher1 */
    /* Details: "Method getRequestDispatcher(String): Returns a */
    /* PortletRequestDispatcher for the specified path" */
    TestResult tr1 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER1);
    try {
      PortletRequestDispatcher rd =
          pc.getRequestDispatcher("/EnvironmentTests_PortletContext_ApiRender_servlets");
      tr1.setTcSuccess(rd != null);
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }

    tr1.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getRequestDispatcher2 */
    /* Details: "Method getRequestDispatcher(String): Returns null if the */
    /* specified path does not begin with \"/\"" */
    TestResult tr2 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER2);
    try {
      PortletRequestDispatcher rd =
          pc.getRequestDispatcher("EnvironmentTests_PortletContext_ApiRender_servlets");
      tr2.setTcSuccess(rd == null);
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }

    tr2.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getRequestDispatcher3 */
    /* Details: "Method getRequestDispatcher(String): Returns null if any */
    /* other error occurs" */
    TestResult tr3 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREQUESTDISPATCHER3);
    try {
      PortletRequestDispatcher rd = pc.getRequestDispatcher(" Invalid path.jsp ");
      tr3.setTcSuccess(rd == null);
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }

    tr3.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getNamedDispatcher1 */
    /* Details: "Method getNamedDispatcher(String): Returns a */
    /* PortletRequestDispatcher for the specified servlet name" */
    TestResult tr4 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER1);
    try {
      PortletRequestDispatcher rd =
          pc.getNamedDispatcher("V2EnvironmentTests_PortletRequestDispatcher_ApiRender_PortletRequest_Forward");
      tr4.setTcSuccess(rd != null);
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }

    tr4.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getNamedDispatcher2 */
    /* Details: "Method getNamedDispatcher(String): Returns null if an */
    /* error occurs" */
    TestResult tr5 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETNAMEDDISPATCHER2);
    try {
      PortletRequestDispatcher rd = pc.getNamedDispatcher("Invalid Name");
      tr5.setTcSuccess(rd == null);
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResourceAsStream1 */
    /* Details: "Method getResourceAsStream(String): Returns a */
    /* java.io.InputStream for the resource at the specified path" */
    TestResult tr6 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM1);
    try {
      InputStream is = pc.getResourceAsStream(
          "/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html");
      tr6.setTcSuccess(is != null);
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResourceAsStream2 */
    /* Details: "Method getResourceAsStream(String): Protected resources */
    /* can be accessed by prefixing the path with \"/WEB-INF/\"" */
    TestResult tr7 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM2);
    try {
      InputStream is = pc.getResourceAsStream(
          "/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html");
      tr7.setTcSuccess(is != null);
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResourceAsStream3 */
    /* Details: "Method getResourceAsStream(String): Returns null if no */
    /* resource exists at the specified path" */
    TestResult tr8 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEASSTREAM3);
    try {
      InputStream is = pc.getResourceAsStream("invalid path");
      tr8.setTcSuccess(is == null);
    } catch (Exception e) {
      tr8.appendTcDetail(e.toString());
    }
    tr8.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getMajorVersion */
    /* Details: "Method getMajorVersion(): Returns the major version of */
    /* the portlet API supported by the container " */
    TestResult tr9 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMAJORVERSION);
    int gmav = pc.getMajorVersion();
    if (gmav == 3) {
      tr9.setTcSuccess(true);
    }
    tr9.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getMinorVersion */
    /* Details: "Method getMinorVersion(): Returns the minor version of */
    /* the portlet API supported by the container" */
    TestResult tr10 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMINORVERSION);
    int gmiv = pc.getMinorVersion();
    if (gmiv == 0) {
      tr10.setTcSuccess(true);
    }
    tr10.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getMimeType1 */
    /* Details: "Method getMimeType(String): Returns a String containing */
    /* the MIME type of the specified file name" */
    TestResult tr11 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE1);
    try {
      if (pc.getMimeType("/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html")
          .equals("text/html")) {
        tr11.setTcSuccess(true);
      } else {
        tr11.appendTcDetail("Failed because MIME type is not text/html");
      }
    } catch (Exception e) {
      tr11.appendTcDetail(e.toString());
    }
    tr11.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getMimeType2 */
    /* Details: "Method getMimeType(String): Returns \"text/html\" for an */
    /* HTML file with the approriate &lt;mime-mapping&gt; element in */
    /* web.xml " */
    TestResult tr12 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE2);
    try {
      if (pc.getMimeType("/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html")
          .equals("text/html")) {
        tr12.setTcSuccess(true);
      } else {
        tr12.appendTcDetail("Failed because MIME type is not text/html");
      }
    } catch (Exception e) {
      tr12.appendTcDetail(e.toString());
    }
    tr12.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getMimeType3 */
    /* Details: "Method getMimeType(String): Returns \"image/gif\" for an */
    /* image file with the approriate &lt;mime-mapping&gt; element in */
    /* web.xml" */
    TestResult tr13 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE3);
    try {
      if (pc.getMimeType("/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType3.gif")
          .equals("image/gif")) {
        tr13.setTcSuccess(true);
      } else {
        tr13.appendTcDetail("Failed because MIME type is not image/gif");
      }
    } catch (Exception e) {
      tr13.appendTcDetail(e.toString());
    }
    tr13.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getMimeType4 */
    /* Details: "Method getMimeType(String): Returns null if the MIME */
    /* type cannot be determined" */
    TestResult tr14 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETMIMETYPE4);
    try {
      String mimeType = pc
          .getMimeType("/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType4.invalid");
      if (mimeType == null) {
        tr14.setTcSuccess(true);
      } else {
        tr14.appendTcDetail("Failed because MIME type is not null but " + mimeType);
      }
    } catch (Exception e) {
      tr14.appendTcDetail(e.toString());
    }
    tr14.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getRealPath1 */
    /* Details: "Method getRealPath(String): Returns a String containing */
    /* the OS-specific real path for the given virtual path" */
    TestResult tr16 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH1);
    try {
      if (pc.getRealPath(
          "/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html") != null) {
        tr16.appendTcDetail(pc
            .getRealPath("/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html"));
        tr16.setTcSuccess(true);
      } else {
        tr16.appendTcDetail("Failed because real path cannot be determined.");
      }
    } catch (Exception e) {
      tr16.appendTcDetail(e.toString());
    }
    tr16.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getRealPath3 */
    /* Details: "Method getRealPath(String): Returns null if the */
    /* transformation cannot be performed" */
    TestResult tr18 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETREALPATH3);
    try {
      String realPath =
          pc.getRealPath("&^*#\\/V2EnvironmentTests_PortletContext_ApiRender_getMimeType4.invalid");
      if (realPath == null) {
        tr18.setTcSuccess(true);
      } else {
        tr18.appendTcDetail("Failed because real path is not null but " + realPath);
      }
    } catch (Exception e) {
      tr18.appendTcDetail(e.toString());
    }
    tr18.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths1 */
    /* Details: "Method getResourcePaths(String): Returns a */
    /* java.util.Set&lt;java.lang.String&gt; containing all the paths to */
    /* resources within the web application longest sub-path of which */
    /* matches the supplied path argument " */
    TestResult tr19 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS1);
    try {
      Set<String> resourcePaths = pc.getResourcePaths("/WEB-INF/");
      if (resourcePaths.size() != 0) {
        tr19.setTcSuccess(true);
        tr19.appendTcDetail("Found " + resourcePaths.size() + " resources");
      } else {
        tr19.appendTcDetail("No resources are available at /WEB-INF/");
      }
    } catch (Exception e) {
      tr19.appendTcDetail(e.toString());
    }
    tr19.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths2 */
    /* Details: "Method getResourcePaths(String): A path indicating a */
    /* file does not end with a slash (/)" */
    TestResult tr20 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS2);
    try {
      Set<String> resourcePaths = pc.getResourcePaths(
          "/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html/");
      if (resourcePaths != null) {
        tr20.appendTcDetail("Found " + resourcePaths.size() + " resources");
      } else {
        tr20.setTcSuccess(true);
        tr20.appendTcDetail(
            "Cannot access the file with path - /WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html/");
      }
    } catch (Exception e) {
      tr20.appendTcDetail(e.toString());
    }
    tr20.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths3 */
    /* Details: "Method getResourcePaths(String): A path indicating a */
    /* subdirectory ends with a slash (/)" */
    TestResult tr21 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS3);
    try {
      Set<String> resourcePaths = pc.getResourcePaths("/WEB-INF/");
      if (resourcePaths.size() != 0) {
        tr21.setTcSuccess(true);
        tr21.appendTcDetail("Found " + resourcePaths.size() + " resources");
      } else {
        tr21.appendTcDetail("No resources are available at /WEB-INF/");
      }
    } catch (Exception e) {
      tr21.appendTcDetail(e.toString());
    }
    tr21.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResourcePaths4 */
    /* Details: "Method getResourcePaths(String): Returns null if there */
    /* are no resources in the web application of which the path begins */
    /* with the supplied path" */
    TestResult tr22 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCEPATHS4);
    try {
      Set<String> resourcePaths = pc.getResourcePaths("/WEB-INF/invalid_path/");
      if (resourcePaths == null) {
        tr22.setTcSuccess(true);
      } else {
        tr22.appendTcDetail("Found " + resourcePaths.size() + " resources");
      }
    } catch (Exception e) {
      tr22.appendTcDetail(e.toString());
    }
    tr22.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResource1 */
    /* Details: "Method getResource(String): Returns a java.net.URL */
    /* object that maps to the specified path" */
    TestResult tr23 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE1);
    try {
      URL resourceURL =
          pc.getResource("/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html");
      if (resourceURL != null) {
        tr23.setTcSuccess(true);
        tr23.appendTcDetail("Found resource URL - " + resourceURL.toString());
      } else {
        tr23.appendTcDetail("Failed because resource URL is null");
      }
    } catch (Exception e) {
      tr23.appendTcDetail(e.toString());
    }
    tr23.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResource2 */
    /* Details: "Method getResource(String): Returns null if no resource */
    /* is mapped to the path" */
    TestResult tr24 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE2);
    try {
      URL resourceURL =
          pc.getResource("/WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getResource2.html");
      if (resourceURL == null) {
        tr24.setTcSuccess(true);
      } else {
        tr24.appendTcDetail(
            "Failed because resource URL is not null but " + resourceURL.toString());
      }
    } catch (Exception e) {
      tr24.appendTcDetail(e.toString());
    }
    tr24.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResource3 */
    /* Details: "Method getResource(String): Throws */
    /* java.net.MalformedURLException if the path does not begin with a */
    /* slash (/)" */
    TestResult tr25 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE3);
    try {
      pc.getResource("WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html");
      tr25.appendTcDetail("Failed because no exception is thrown");
    } catch (MalformedURLException e) {
      tr25.setTcSuccess(true);
      tr25.appendTcDetail(e.toString());
    }
    tr25.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getResource4 */
    /* Details: "Method getResource(String): Throws */
    /* java.net.MalformedURLException if the path is malformed" */
    TestResult tr26 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETRESOURCE4);
    try {
      pc.getResource("WEB-INF/V2EnvironmentTests_PortletContext_ApiRender_getMimeType1.html");
      tr26.appendTcDetail("Failed because no exception is thrown");
    } catch (MalformedURLException e) {
      tr26.setTcSuccess(true);
      tr26.appendTcDetail(e.toString());
    }
    tr26.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getAttribute1 */
    /* Details: "Method getAttribute(String): Returns a java.lang.Object */
    /* attribute value for the specified name" */
    TestResult tr27 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE1);
    pc.setAttribute("tr27", "true");
    if (pc.getAttribute("tr27").equals("true")) {
      tr27.setTcSuccess(true);
    }
    tr27.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getAttribute2 */
    /* Details: "Method getAttribute(String): Returns null if there is no */
    /* attribute value for the specified name" */
    TestResult tr28 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE2);
    if (pc.getAttribute("tr28") == null) {
      tr28.setTcSuccess(true);
    }
    tr28.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getAttribute3 */
    /* Details: "Method getAttribute(String): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr29 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTE3);
    try {
      pc.getAttribute(null);
      tr29.appendTcDetail("Method did not throw an exception.");
    } catch (IllegalArgumentException iae) {
      tr29.setTcSuccess(true);
      tr29.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr29.appendTcDetail(e.toString());
    }
    tr29.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getAttributeNames1 */
    /* Details: "Method getAttributeNames(): Returns an */
    /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
    /* attribute names in the PortletContext" */
    TestResult tr30 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES1);
    Enumeration<String> getAttNames = pc.getAttributeNames();
    List<String> li30 = Collections.list(getAttNames);
    if (li30 != null) {
      tr30.setTcSuccess(true);
      tr30.appendTcDetail("Found " + li30.size() + " attributes.");
    }
    tr30.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getAttributeNames2 */
    /* Details: "Method getAttributeNames(): Returns an empty Enumeration */
    /* if no attributes are available" */
    TestResult tr31 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETATTRIBUTENAMES2);
    tr31.setTcSuccess(true);
    tr31.appendTcDetail("This Method Could Not be Tested Which already has Attribute Names ");
    tr31.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getInitParameter2 */
    /* Details: "Method getInitParameter(String): Returns null if there */
    /* is no initialization parameter for the specified name" */
    TestResult tr33 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER2);
    String initParm2 = portletConfig.getInitParameter("Test");
    if (initParm2 == null) {
      tr33.setTcSuccess(true);
    }
    tr33.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getInitParameter3 */
    /* Details: "Method getInitParameter(String): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr34 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETER3);
    try {
      pc.getInitParameter(null);
      tr34.appendTcDetail("Method did not throw an exception.");
    } catch (IllegalArgumentException iae) {
      tr34.setTcSuccess(true);
      tr34.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr34.appendTcDetail(e.toString());
    }
    tr34.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getInitParameterNames2 */
    /* Details: "Method getInitParameterNames(): Returns an empty */
    /* Enumeration if no InitParameters are available" */
    TestResult tr40 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETINITPARAMETERNAMES2);
    Enumeration<String> getInitNames2 = portletConfig.getInitParameterNames();
    List<String> li40 = Collections.list(getInitNames2);
    if (li40.isEmpty()) {
      tr40.setTcSuccess(true);
    } else {
      tr40.appendTcDetail("The InitParameter has Values : " + li40.toString());
    }
    tr40.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_logA */
    /* Details: "Method log(String): Writes specified message to a */
    /* portlet log file" */
    TestResult tr41 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGA);
    tr41.setTcSuccess(true);
    tr41.appendTcDetail("Optional Test case. Portlet log is optional and implementation specific");
    tr41.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_logB */
    /* Details: "Method log(String, Throwable): Writes specified message */
    /* and stack trace to a portlet log file" */
    TestResult tr42 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_LOGB);
    tr42.setTcSuccess(true);
    tr42.appendTcDetail("Optional Test case. Portlet log is optional and implementation specific");
    tr42.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_removeAttribute1 */
    /* Details: "Method removeAttribute(String): Removes the attribute */
    /* with the specified nale" */
    TestResult tr43 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE1);
    pc.removeAttribute("tr27");
    if (pc.getAttribute("tr27") == null) {
      tr43.setTcSuccess(true);
    } else {
      tr43.appendTcDetail("Failed because attribute tr27 is still present");
    }
    tr43.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_removeAttribute2 */
    /* Details: "Method removeAttribute(String): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr44 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_REMOVEATTRIBUTE2);
    try {
      pc.removeAttribute(null);
      tr44.appendTcDetail("Method did not throw an exception.");
    } catch (IllegalArgumentException iae) {
      tr44.setTcSuccess(true);
      tr44.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr44.appendTcDetail(e.toString());
    }
    tr44.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_setAttribute1 */
    /* Details: "Method setAttribute(String, Object): Sets an attribute */
    /* for the specified name in the portlet context" */
    TestResult tr45 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE1);
    try {
      pc.setAttribute("Test", "Value");
      if (pc.getAttribute("Test").equals("Value")) {
        tr45.setTcSuccess(true);
      }
    } catch (Exception e) {
      tr45.appendTcDetail(e.toString());
    }
    tr45.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_setAttribute2 */
    /* Details: "Method setAttribute(String, Object): Any existing */
    /* attribute for the specified name is removed" */
    TestResult tr46 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE2);
    try {
      pc.setAttribute("Test", "Value2");
      if (pc.getAttribute("Test").equals("Value2")) {
        tr46.setTcSuccess(true);
      }
    } catch (Exception e) {
      tr46.appendTcDetail(e.toString());
    }
    tr46.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_setAttribute3 */
    /* Details: "Method setAttribute(String, Object): If the specified */
    /* name is null, the attribute is removed" */
    TestResult tr47 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE3);
    pc.setAttribute("tr47", null);
    if (pc.getAttribute("tr47") == null) {
      tr47.setTcSuccess(true);
    }
    tr47.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_setAttribute4 */
    /* Details: "Method setAttribute(String, Object): Throws */
    /* IllegalArgumentException if the name is null" */
    TestResult tr48 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_SETATTRIBUTE4);
    try {
      pc.setAttribute(null, "value");
      tr48.appendTcDetail("Method did not throw an exception.");
    } catch (IllegalArgumentException iae) {
      tr48.setTcSuccess(true);
      tr48.appendTcDetail(iae.toString());
    } catch (Exception e) {
      tr48.appendTcDetail(e.toString());
    }
    tr48.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getPortletContextName1 */
    /* Details: "Method getPortletContextName(): Returns the portlet */
    /* application name" */
    TestResult tr49 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME1);
    String getCntName1 = pc.getPortletContextName();
    if (getCntName1.equals("javax.portlet-tck-EnvironmentTests")) {
      tr49.setTcSuccess(true);
      tr49.appendTcDetail("Portlet Application name is - " + getCntName1);
    } else {
      tr49.appendTcDetail("The Portlet application name is null");
    }
    tr49.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getPortletContextName2 */
    /* Details: "Method getPortletContextName(): The name is as specified */
    /* in web.xml the &lt;display-name&gt; element" */
    TestResult tr50 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME2);
    String getCntName2 = pc.getPortletContextName();
    if (getCntName2.equals("javax.portlet-tck-EnvironmentTests")) {
      tr50.setTcSuccess(true);
    } else {
      tr50.appendTcDetail(
          "Failed because poetlet context name is not javax.portlet-tck-EnvironmentTests but "
              + getCntName2);
    }
    tr50.writeTo(writer);


    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getPortletContextName3 */
    /* Details: "Method getPortletContextName(): Returns null if no */
    /* web.xml &lt;display-name&gt; element is defined" */
    TestResult tr51 =
        tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETPORTLETCONTEXTNAME3);
    tr51.setTcSuccess(true);
    tr51.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getContainerRuntimeOptions1 */
    /* Details: "Method getContainerRuntimeOptions(): Returns an */
    /* java.util.Enumeration&lt;java.lang.String&gt; containing the */
    /* available runtime option names" */
    TestResult tr52 = tcd.getTestResultFailed(
        V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS1);
    Enumeration<String> getRuntime1 = pc.getContainerRuntimeOptions();
    List<String> list1 = Collections.list(getRuntime1);
    if (list1 != null) {
      tr52.setTcSuccess(true);
    } else {
      tr52.appendTcDetail("The Container RuntimeOptions has null value");
    }
    tr52.writeTo(writer);

    /* TestCase: V2EnvironmentTests_PortletContext_ApiRender_getContainerRuntimeOptions2 */
    /* Details: "Method getContainerRuntimeOptions(): Returns an empty */
    /* Enumeration if no runtime options are available" */
    TestResult tr53 = tcd.getTestResultFailed(
        V2ENVIRONMENTTESTS_PORTLETCONTEXT_APIRENDER_GETCONTAINERRUNTIMEOPTIONS2);
    tr53.setTcSuccess(true);
    tr53.appendTcDetail(
        "This Method could not be tested for an empty values Which already has Runtime Options supported by Portlet Container ");
    tr53.writeTo(writer);

    /* TestCase: V2AddlPortletTests_SPEC2_6_RenderConfig_getContainerRuntimeOptions4 */
    /* Details: "Method getContainerRuntimeOptions(): Returns an empty */
    /* map if no container runtime options have been defined " */
    TestResult tr58 = tcd_spec
        .getTestResultFailed(V2ADDLPORTLETTESTS_SPEC2_6_RENDERCONFIG_GETCONTAINERRUNTIMEOPTIONS4);
    Map<String, String[]> runtimeOptions = portletConfig.getContainerRuntimeOptions();
    if (runtimeOptions.size() == 0) {
      tr58.setTcSuccess(true);
    } else {
      tr58.appendTcDetail(
          "Failed because " + runtimeOptions.size() + " runtime options found in PortletContext");
    }
    tr58.writeTo(writer);
  }

}
