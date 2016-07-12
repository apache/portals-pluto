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

import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTENAMES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETAUTHTYPE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTEXTPATH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCOOKIES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETDATEHEADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERNAMES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERS;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINTHEADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALADDR;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALNAME;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALPORT;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETMETHOD;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERVALUES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHINFO;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHTRANSLATED;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPROTOCOL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETQUERYSTRING;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREALPATH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEADDR;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEHOST;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEPORT;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEUSER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTDISPATCHER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURI;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTEDSESSIONID;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSCHEME;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERNAME;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERPORT;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVLETPATH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSESSION;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETUSERPRINCIPAL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISREQUESTEDSESSIONIDVALID;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISSECURE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISUSERINROLE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_REMOVEATTRIBUTE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_SETATTRIBUTE;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_PREFIX;
import static javax.portlet.tck.constants.Constants.JSP_SUFFIX;
import static javax.portlet.tck.constants.Constants.PARM_NAME;
import static javax.portlet.tck.constants.Constants.PARM_VALUE;
import static javax.portlet.tck.constants.Constants.QUERY_STRING;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestSetupLink;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_event
 *
 */
public class DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest implements Portlet, ResourceServingPortlet {
   
   private PortletConfig portletConfig = null;

   @Override
   public void init(PortletConfig config) throws PortletException {
      this.portletConfig = config;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);


      // Prereq for: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute
      portletReq.setAttribute(ATTR_PREFIX +"V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute", "Value1");

      // Prereq for: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames
      portletReq.setAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames", "Value1");

      // Now do the actual dispatch
      String target = JSP_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest" + JSP_SUFFIX + "?" + QUERY_STRING;
      PortletRequestDispatcher rd = portletConfig.getPortletContext()
            .getRequestDispatcher(target);
      rd.forward(portletReq, portletResp);
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);


   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(RESULT_ATTR_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest", APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(RESULT_ATTR_PREFIX + "DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest", APPLICATION_SCOPE);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttribute */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getAttribute must provide the same         */
      /* functionality as ActionRequest.getAttribute"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAttributeNames */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getAttributeNames must provide the same    */
      /* functionality as ActionRequest.getAttributeNames"                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETATTRIBUTENAMES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getAuthType */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getAuthType must provide the same          */
      /* functionality as ActionRequest.getAuthType"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETAUTHTYPE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getCharacterEncoding must provide the      */
      /* same functionality as ActionRequest.getCharacterEncoding"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCHARACTERENCODING, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentLength */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getContentLength must provide the same     */
      /* functionality as ActionRequest.getContentLength"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTLENGTH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContentType */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getContentType must provide the same       */
      /* functionality as ActionRequest.getContentType"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTENTTYPE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getContextPath */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getContextPath must provide the same       */
      /* functionality as ActionRequest.getContextPath"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCONTEXTPATH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getCookies */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getCookies must provide the same           */
      /* functionality as ActionRequest.getCookies"                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETCOOKIES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getDateHeader */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getDateHeader must return a value          */
      /* corresponding to that returned by ActionRequest.getProperty for      */
      /* the corresponding header name"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETDATEHEADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeader */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getHeader must return a value              */
      /* corresponding to that returned by ActionRequest.getProperty for      */
      /* the corresponding header name"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaderNames */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* Enumeration returned by HttpServletRequest.getHeaderNames must be    */
      /* contained in the Enumeration returned by                             */
      /* ActionRequest.getPropertyNames"                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERNAMES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getHeaders */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getHeaders must return a value             */
      /* corresponding to that returned by ActionRequest.getProperties for    */
      /* the corresponding header name"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETHEADERS, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getIntHeader */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getIntHeader must return a value           */
      /* corresponding to that returned by ActionRequest.getProperty for      */
      /* the corresponding header name"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETINTHEADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalAddr */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocalAddr must return null"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALADDR, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalName */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocalName must return null"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALNAME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocalPort */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocalPort must return 0"                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALPORT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocale */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocale must provide the same            */
      /* functionality as ActionRequest.getLocale"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getLocales */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getLocales must provide the same           */
      /* functionality as ActionRequest.getLocales"                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETLOCALES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getMethod */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getMethod must provide the same            */
      /* functionality as ActionRequest.getMethod"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETMETHOD, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameter */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameter must provide the same         */
      /* functionality as ActionRequest.getParameter"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterMap */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameterMap must provide the same      */
      /* functionality as ActionRequest.getParameterMap"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERMAP, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterNames */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameterNames must provide the same    */
      /* functionality as ActionRequest.getParameterNames"                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERNAMES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getParameterValues */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getParameterValues must provide the same   */
      /* functionality as ActionRequest.getParameterValues"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERVALUES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathInfo */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getPathInfo must a value corresponding     */
      /* to the path used to obtain the PortletRequestDispatcher"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHINFO, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getPathTranslated */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getPathTranslated must a value             */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPATHTRANSLATED, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getProtocol */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getProtocol must return \"HTTP/1.1\""      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPROTOCOL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getQueryString */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getQueryString must a value                */
      /* corresponding to the query string information used to obtain the     */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETQUERYSTRING, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRealPath */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRealPath must return null"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREALPATH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteAddr */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemoteAddr must return null"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEADDR, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteHost */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemoteHost must return null"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEHOST, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemotePort */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemotePort must return 0"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEPORT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRemoteUser */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRemoteUser must provide the same        */
      /* functionality as ActionRequest.getRemoteUser"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREMOTEUSER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestDispatcher */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestDispatcher must provide          */
      /* functionality as defined in the servlet specification"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTDISPATCHER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURI */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestURI must a value corresponding   */
      /* to the path and query string information used to obtain the          */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURI, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestURL */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestURL must return null"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTURL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getRequestedSessionId */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getRequestedSessionId must provide the     */
      /* same functionality as ActionRequest.getRequestedSessionId"           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETREQUESTEDSESSIONID, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getScheme */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getScheme must provide the same            */
      /* functionality as ActionRequest.getScheme"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSCHEME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerName */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getServerName must provide the same        */
      /* functionality as ActionRequest.getServerName"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERNAME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServerPort */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getServerPort must provide the same        */
      /* functionality as ActionRequest.getServerPort"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVERPORT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getServletPath */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getServletPath must a value                */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSERVLETPATH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getSession */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getSession must provide the same           */
      /* functionality as                                                     */
      /* ActionRequest.getPortletSession(APPLICATION_SCOPE)"                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETSESSION, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_getUserPrincipal */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.getUserPrincipal must provide the same     */
      /* functionality as ActionRequest.getUserPrincipal"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETUSERPRINCIPAL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isRequestedSessionIdValid */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.isRequestedSessionIdValid must provide     */
      /* the same functionality as ActionRequest.isRequestedSessionIdValid"   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISREQUESTEDSESSIONIDVALID, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isSecure */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.isSecure must provide the same             */
      /* functionality as ActionRequest.isSecure"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISSECURE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_isUserInRole */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.isUserInRole must provide the same         */
      /* functionality as ActionRequest.isUserInRole"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_ISUSERINROLE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_removeAttribute */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.removeAttribute must provide the same      */
      /* functionality as ActionRequest.removeAttribute"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_REMOVEATTRIBUTE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest_setAttribute */
      /* Details: "In a target jsp of a forward in the Action phase, the      */
      /* method HttpServletRequest.setAttribute must provide the same         */
      /* functionality as ActionRequest.setAttribute"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_SETATTRIBUTE, aurl);
         tb.writeTo(writer);
      }

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      {
         String val = portletReq.getParameter(PARM_NAME);
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_NAME, PARM_VALUE);
            TestSetupLink tl = new TestSetupLink(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETER, rurl);
            tl.writeTo(writer);
         }
      }

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      {
         String val = portletReq.getParameter(PARM_NAME);
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_NAME, PARM_VALUE);
            TestSetupLink tl = new TestSetupLink(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERMAP, rurl);
            tl.writeTo(writer);
         }
      }

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      {
         String val = portletReq.getParameter(PARM_NAME);
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_NAME, PARM_VALUE);
            TestSetupLink tl = new TestSetupLink(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERNAMES, rurl);
            tl.writeTo(writer);
         }
      }

      // TestSetupLink for: DispatcherReqRespTests1_SPEC2_19_ForwardJSPActionRequest
      {
         String val = portletReq.getParameter(PARM_NAME);
         if (val == null) {
            PortletURL rurl = ((RenderResponse)portletResp).createRenderURL();
            rurl.setParameters(portletReq.getPrivateParameterMap());
            rurl.setParameter(PARM_NAME, PARM_VALUE);
            TestSetupLink tl = new TestSetupLink(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPACTIONREQUEST_GETPARAMETERVALUES, rurl);
            tl.writeTo(writer);
         }
      }

   }

}
