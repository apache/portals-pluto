/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package javax.portlet.tck.portlets;

import java.io.*;
import java.util.Map;

import javax.portlet.*;
import javax.portlet.annotations.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.util.ModuleTestCaseDetails;
import javax.servlet.http.Cookie;

import static javax.portlet.PortletSession.PORTLET_SCOPE;
import static javax.portlet.ResourceURL.PAGE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.util.ModuleTestCaseDetails.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 */
@PortletApplication(publicParams = {
      @PublicRenderParameterDefinition(identifier = "tckPRP3", qname = @PortletQName(localPart = "tckPRP3", namespaceURI = "")),
      @PublicRenderParameterDefinition(identifier = "tr1_ready", qname = @PortletQName(localPart = "tr1_ready", namespaceURI = "")) })
@PortletConfiguration(portletName = "HeaderPortletTests_SPEC15_Header", publicParams = {
      "tckPRP3", "tr1_ready" }, supports = { @Supports(mimeType = "text/html") })
public class HeaderPortletTests_SPEC15_Header
      implements Portlet, HeaderPortlet, ResourceServingPortlet {

   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {
      String action = portletReq.getParameter("inputval");
      if (action != null) {
         if (V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS10.equals(action)
               && portletReq.getParameter("actionURLTr0") != null
               && portletReq.getParameter("actionURLTr0").equals("true")) {
            /* TestCase: V2AddlRequestTests_SPEC2_11_Render_parameters10 */
            /* Details: "The portlet-container must not propagate parameters */
            /* received in an action or event request to subsequent render */
            /* requests of the portlet" */
            portletResp.setRenderParameter("tr0", "true");
         } else if (V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS15
               .equals(action) && portletReq.getParameter("tr3a") != null
               && portletReq.getParameter("tr3a").equals("true")) {
            /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters15 */
            /*
             * Details: "Render parameters get automatically cleared if the
             * portlet receives a processAction or processEvent call"
             */
            portletResp.setRenderParameter("tr3b", "true");
         } else if (V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE9.equals(action)) {
            /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie9 */
            /*
             * Details: "Cookies set during the Header phase should be available
             * to the portlet during a subsequent Action phase"
             */
            Cookie[] cookies = portletReq.getCookies();
            for (Cookie c : cookies) {
               if (c.getName().equals("header_tr1_cookie")
                     && c.getValue().equals("true")) {
                  c.setMaxAge(0);
                  c.setValue("");
                  portletResp.setRenderParameter("trCookie1", "true");
               }
            }
         }
      }
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie8 */
      /*
       * Details: "Cookies set during the Header phase should be available to
       * the portlet during the Resource phase"
       */
      writer.write(
            "<div id=\"V3HeaderPortletTests_SPEC15_Header\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write(
            "         document.getElementById(\"V3HeaderPortletTests_SPEC15_Header\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write(
            "   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
      
      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie10 */
      /*
       * Details: "Cookies set during the Header phase should be available to
       * the portlet during a subsequent Render phase"
       */
      Cookie[] cookies = portletReq.getCookies();
      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr2 = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE10);
      for (Cookie c : cookies) {
        txt.append("Name: ").append(c.getName());
        txt.append(", Value: ").append(c.getValue()).append("<br>");
        if (c.getName().equals("header_tr2_cookie") && c.getValue().equals("true")) {
          txt.append("<br>").append("Found my cookie!").append("<br>");
          c.setMaxAge(0);
          c.setValue("");
          tr2.setTcSuccess(true);
        }
      }
      tr2.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());

      String msg = ((String) portletReq.getPortletSession().getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_Header",
            PORTLET_SCOPE));
      writer.write("<p>" + msg + "</p>");
      portletReq.getPortletSession().removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_Header",
            PORTLET_SCOPE);

   }

   @Override
   public void renderHeaders(HeaderRequest portletReq,
         HeaderResponse portletResp) throws PortletException, IOException {
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      StringWriter writer = new StringWriter();

      RenderParameters renderParams = portletReq.getRenderParameters();
      String action = portletReq.getParameter("inputval");
      Boolean successTr2 = false, successTr5 = false, successTr6 = false;
      Boolean successTr7 = false, successTr8 = false, successTr13 = false;

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters10 */
      /*
       * Details: "The portlet-container must not propagate parameters received
       * in an action or event request to subsequent header requests of the
       * portlet"
       */
      if (renderParams.getValue("actionURLTr0") == null
            && renderParams.getValue("tr0") != null
            && "true".equals(renderParams.getValue("tr0"))) {
         TestResult tr0 = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS10);
         tr0.setTcSuccess(true);
         tr0.writeTo(writer);
      } else {
         ActionURL aurl = portletResp.createActionURL();
         aurl.setParameter("actionURLTr0", "true");
         TestButton tb = new TestButton(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS10, aurl);
         tb.writeTo(writer);
      }

      if (action != null) {
         if (action.equals(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS13)) {
            /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters13 */
            /*
             * Details: "If a portlet receives a render request that is the
             * result of invoking a render URL targeting this portlet the render
             * parameters received with the render request must be the
             * parameters set on the render URL"
             */
            TestResult tr2 = tcd.getTestResultFailed(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS13);
            if (portletReq.getParameter("renderURLTr2") != null
                  && portletReq.getParameter("tr2") != null
                  && portletReq.getParameter("renderURLTr2")
                        .contains("tr2:" + portletReq.getParameter("tr2"))) {
               tr2.setTcSuccess(true);
               successTr2 = true;
            } else {
               tr2.appendTcDetail(
                     "Parameter renderURLTr2 is missing or does not contain tr2 parameter value.");
            }
            tr2.writeTo(writer);
         } else if (action
               .equals(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS2)) {
            /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters2 */
            /* Details: "The parameters the request object returns must be */
            /* \"x-www-form-urlencoded\" decoded" */
            TestResult tr5 = tcd.getTestResultFailed(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS2);
            if (portletReq.getParameter("tr5") != null
                  && portletReq.getParameter("tr5").equals("true&<>'")) {
               tr5.setTcSuccess(true);
               successTr5 = true;
            }
            tr5.writeTo(writer);
         } else if (action
               .equals(V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6)) {
            /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters6 */
            /*
             * Details: "The getParameterMap method must return an unmodifiable
             * Map object"
             */
            TestResult tr6 = tcd.getTestResultFailed(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6);
            if (portletReq.getParameterMap().containsKey("inputval")
                  && V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6.equals(
                        portletReq.getParameterMap().get("inputval")[0])) {
               String tr6TestStringArray[] = { "Modified Value" };
               portletReq.getParameterMap().put("inputval", tr6TestStringArray);
               if (V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6
                     .equals(portletReq.getParameterMap().get("inputval")[0])) {
                  tr6.setTcSuccess(true);
                  successTr6 = true;
               }
            }
            tr6.writeTo(writer);
         } else if (action.equals(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS15)) {
            /*
             * TestCase:
             * V3HeaderPortletTests_SPEC15_Header_publicRenderParameters15
             */
            /*
             * Details: "A map of private parameters can be obtained through the
             * getPrivateParameterMap method"
             */
            TestResult tr7 = tcd.getTestResultFailed(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS15);
            Map<String, String[]> privateParamMap = portletReq
                  .getPrivateParameterMap();
            if (privateParamMap != null && privateParamMap.containsKey("tr7")
                  && privateParamMap.get("tr7")[0].equals("true")) {
               tr7.setTcSuccess(true);
               successTr7 = true;
            }
            tr7.writeTo(writer);
         } else if (action.equals(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS16)) {
            /*
             * TestCase:
             * V3HeaderPortletTests_SPEC15_Header_publicRenderParameters16
             */
            /*
             * Details: "A map of public parameters can be obtained through the
             * getPublicParameterMap method"
             */
            TestResult tr8 = tcd.getTestResultFailed(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS16);
            if (portletReq.getPublicParameterMap() != null && portletReq
                  .getPublicParameterMap().containsKey("tckPRP3")) {
               tr8.setTcSuccess(true);
               successTr8 = true;
            } else {
               tr8.appendTcDetail("No public render parameter found.");
            }
            tr8.writeTo(writer);
         } else if (action.equals(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS13A)) {
            /*
             * TestCase:
             * V3HeaderPortletTests_SPEC15_Header_publicRenderParameters13a
             */
            /* Details: "A public render parameter can be deleted using the */
            /* removePublicRenderParameter method on the PortletURL" */
            TestResult tr13 = tcd.getTestResultFailed(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS13A);
            if (portletReq.getPublicParameterMap() != null && !portletReq
                  .getPublicParameterMap().containsKey("tckPRP3")) {
               tr13.setTcSuccess(true);
               successTr13 = true;
            } else {
               tr13.appendTcDetail("Render parameter tckPRP3 is not removed.");
            }
            tr13.writeTo(writer);
         }
      }

      if (!successTr2) {
         /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters13 */
         /*
          * Details: "If a portlet receives a render request that is the result
          * of invoking a render URL targeting this portlet the render
          * parameters received with the render request must be the parameters
          * set on the render URL"
          */
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameters(portletReq.getPrivateParameterMap());
         rurl.setParameter("tr2", "true");
         rurl.setParameter("renderURLTr2", rurl.toString());
         TestButton tb = new TestButton(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS13, rurl);
         tb.writeTo(writer);
      }

      if (!successTr5) {
         /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters2 */
         /* Details: "The parameters the request object returns must be */
         /* \"x-www-form-urlencoded\" decoded" */
         PortletURL purl = portletResp.createRenderURL();
         purl.setParameter("tr5", "true&<>'");
         TestButton tb = new TestButton(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS2, purl);
         tb.writeTo(writer);
      }

      if (!successTr6) {
         /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters6 */
         /*
          * Details: "The getParameterMap method must return an unmodifiable Map
          * object"
          */
         PortletURL purl = portletResp.createRenderURL();
         TestButton tb = new TestButton(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS6, purl);
         tb.writeTo(writer);
      }

      if (!successTr7) {
         /*
          * TestCase:
          * V3HeaderPortletTests_SPEC15_Header_publicRenderParameters15
          */
         /* Details: "A map of private parameters can be obtained through the */
         /* getPrivateParameterMap method" */
         PortletURL purl = portletResp.createRenderURL();
         purl.setParameter("tr7", "true");
         TestButton tb = new TestButton(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS15,
               purl);
         tb.writeTo(writer);
      }

      if (!successTr8) {
         /*
          * TestCase:
          * V3HeaderPortletTests_SPEC15_Header_publicRenderParameters16
          */
         /* Details: "A map of public parameters can be obtained through the */
         /* getPublicParameterMap method" */
         if (portletReq.getParameter("tckPRP3") == null) {
            PortletURL purl = portletResp.createRenderURL();
            purl.setParameter("tckPRP3", "true");
            TestSetupLink tl = new TestSetupLink(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS16,
                  purl);
            tl.writeTo(writer);
         } else {
            PortletURL aurl = portletResp.createRenderURL();
            aurl.setParameters(portletReq.getPrivateParameterMap());
            TestButton tb = new TestButton(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS16,
                  aurl);
            tb.writeTo(writer);
         }
      }

      if (!successTr13) {
         /*
          * TestCase:
          * V3HeaderPortletTests_SPEC15_Header_publicRenderParameters13a
          */
         /* Details: "A public render parameter can be deleted using the */
         /* removePublicRenderParameter method on the PortletURL" */
         if (portletReq.getParameter("tckPRP3") == null) {
            PortletURL purl = portletResp.createRenderURL();
            purl.setParameter("tckPRP3", "true");
            TestSetupLink tl = new TestSetupLink(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS13A,
                  purl);
            tl.writeTo(writer);
         } else {
            PortletURL purl = portletResp.createRenderURL();
            purl.setParameters(portletReq.getPrivateParameterMap());
            purl.removePublicRenderParameter("tckPRP3");
            TestButton tb = new TestButton(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PUBLICRENDERPARAMETERS13A,
                  purl);
            tb.writeTo(writer);
         }
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_parameters15 */
      /* Details: "Render parameters get automatically cleared if the portlet */
      /* receives a processAction or processEvent call" */
      if (portletReq.getParameter("tr3a") != null) {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter("tr3a", "true");
         TestButton tb = new TestButton(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS15, aurl);
         tb.writeTo(writer);
      } else {
         if (portletReq.getParameter("tr3b") != null
               && portletReq.getParameter("tr3b").equals("true")) {
            TestResult tr3 = tcd.getTestResultFailed(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS15);
            tr3.setTcSuccess(true);
            tr3.writeTo(writer);
         } else {
            PortletURL purl = portletResp.createRenderURL();
            purl.setParameter("tr3a", "true");
            TestSetupLink tl = new TestSetupLink(
                  V3HEADERPORTLETTESTS_SPEC15_HEADER_PARAMETERS15, purl);
            tl.writeTo(writer);
         }
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties1 */
      /*
       * Details: "The portlet can use the getProperty method to access single
       * portal property and optionally-available HTTP header values"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES1);
         if (portletReq.getProperty("Accept") != null) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because Accept header is not found in request headers.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties2 */
      /*
       * Details: "The portlet can use the getProperties method to access
       * multiple portal property and optionally-available HTTP header values by
       * the same property name"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES2);
         if (portletReq.getProperties("Accept").hasMoreElements()) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because Accept header is not found in request headers.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties3 */
      /*
       * Details: "The portlet can use the getPropertyNames method to obtain an
       * Enumeration of all available property names"
       */
      {

         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES3);
         if (portletReq.getPropertyNames().hasMoreElements()) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because no header is not found in request headers.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_properties4 */
      /*
       * Details: "The portlet can access cookies provided by the current
       * request using the getCookies method"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_PROPERTIES4);
         if (portletReq.getCookies().length > 0) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail(
                  "Failed because no cookies are found in HeaderRequest object");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie8 */
      /*
       * Details: "Cookies set during the Header phase should be available to
       * the portlet during the Resource phase"
       */
      {
         Cookie c = new Cookie("header_tr0_cookie", "true");
         c.setMaxAge(100);
         c.setPath("/");
         portletResp.addProperty(c);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie9 */
      /*
       * Details: "Cookies set during the Header phase should be available to
       * the portlet during a subsequent Action phase"
       */
      if(portletReq.getParameter("trCookie1")!=null && portletReq.getParameter("trCookie1").equals("true")){
         TestResult tr1 = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE9);
         tr1.setTcSuccess(true);
         tr1.writeTo(writer);
      } else {
         Cookie c = new Cookie("header_tr1_cookie", "true");
         c.setMaxAge(100);
         c.setPath("/");
         portletResp.addProperty(c);
         PortletURL aurl = portletResp.createActionURL();
         TestButton tb = new TestButton(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE9, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie10 */
      /*
       * Details: "Cookies set during the Header phase should be available to
       * the portlet during a subsequent Render phase"
       */
      {
         Cookie c = new Cookie("header_tr2_cookie", "true");
         c.setMaxAge(100);
         c.setPath("/");
         portletResp.addProperty(c);
         PortletURL rurl = portletResp.createRenderURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE10, rurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie11 */
      /*
       * Details: "Cookies set during the Header phase should be available to
       * the portlet during a subsequent request triggered by a URL"
       */
      if(portletReq.getParameter("tr3")!=null && portletReq.getParameter("tr3").equals("true")){
         Cookie[] cookies = portletReq.getCookies();

         StringBuilder txt = new StringBuilder(128);
         txt.append("<p>Debug info:");
         txt.append("<br>");
         txt.append("# Cookies: ").append(cookies.length).append("<br>");
         TestResult tr2 = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE11);
         for (Cookie c : cookies) {
           txt.append("Name: ").append(c.getName());
           txt.append(", Value: ").append(c.getValue()).append("<br>");
           if (c.getName().equals("header_tr3_cookie") && c.getValue().equals("true")) {
             txt.append("<br>").append("Found my cookie!").append("<br>");
             c.setMaxAge(0);
             c.setValue("");
             tr2.setTcSuccess(true);
           }
         }
         tr2.writeTo(writer);
         txt.append("</p>");
         writer.append(txt.toString());
      } else {
         Cookie c = new Cookie("header_tr3_cookie", "true");
         c.setMaxAge(100);
         c.setPath("/");
         portletResp.addProperty(c);
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter("tr3", "true");
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE11, rurl);
         tb.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie12 */
      /*
       * Details: "Cookies set during the Header phase after the response has
       * been committed are ignored"
       */
      // TODO: HeaderResponse has flushBuffer() method which commits the response.
      //       We are still able to set the cookie. Is this test case wrong?
      {
         portletResp.flushBuffer();
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE12);
         Cookie c = new Cookie("header_tr4_cookie", "true");
         c.setMaxAge(100);
         c.setPath("/");
         portletResp.addProperty(c);
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_contentType5 */
      /*
       * Details: "If the setContentType method is not called before the
       * getWriter or getPortletOutputStream method is used, the portlet
       * container uses the content type returned by getResponseContentType"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_CONTENTTYPE5);
         if(portletReq.getResponseContentType()!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Content type is - "+portletReq.getResponseContentType());
         } else {
            result.appendTcDetail("Failed because getResponseContentType() method returned null");
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC15_Header_characterEncoding4 */
      /*
       * Details: "If the portlet does not set the character encoding, the
       * portlet container uses UTF-8 as the default character encoding"
       */
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_CHARACTERENCODING4);
         if(portletResp.getCharacterEncoding().equals("UTF-8")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because default character encoding is not UTF-8 but "+portletResp.getCharacterEncoding());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_characterEncoding3 */
      /*
       * Details: "The character encoding can be set via the setContentType
       * method if the given content type string provides a value for the
       * charset attribute" */
      // TODO: fix test case
      {
         TestResult result = tcd.getTestResultFailed(
               V3HEADERPORTLETTESTS_SPEC15_HEADER_CHARACTERENCODING3);
         portletResp.setContentType("text/html;charset=ANSI");
         if(portletResp.getCharacterEncoding().equals("ANSI")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because charset is not ANSI but "+portletResp.getCharacterEncoding());
         }
         result.writeTo(writer);
      }

      portletReq.getPortletSession().setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC15_Header",
            writer.toString(), PORTLET_SCOPE);

   }

   @Override
   public void serveResource(ResourceRequest portletReq,
         ResourceResponse portletResp) throws PortletException, IOException {

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V3HeaderPortletTests_SPEC15_Header_cookie8 */
      /*
       * Details: "Cookies set during the Header phase should be available to
       * the portlet during the Resource phase"
       */
      Cookie[] cookies = portletReq.getCookies();

      StringBuilder txt = new StringBuilder(128);
      txt.append("<p>Debug info:");
      txt.append("<br>");
      txt.append("# Cookies: ").append(cookies.length).append("<br>");
      TestResult tr1 = tcd
            .getTestResultFailed(V3HEADERPORTLETTESTS_SPEC15_HEADER_COOKIE8);
      for (Cookie c : cookies) {
         txt.append("Name: ").append(c.getName());
         txt.append(", Value: ").append(c.getValue()).append("<br>");
         if (c.getName().equals("header_tr0_cookie")
               && c.getValue().equals("true")) {
            txt.append("<br>").append("Found my cookie!").append("<br>");
            c.setMaxAge(0);
            c.setValue("");
            tr1.setTcSuccess(true);
         }
      }
      tr1.writeTo(writer);
      txt.append("</p>");
      writer.append(txt.toString());

   }

}
