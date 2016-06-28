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

import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTENAMES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETAUTHTYPE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTEXTPATH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCOOKIES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETDATEHEADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERNAMES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERS;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINPUTSTREAM;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINTHEADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALADDR;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALNAME;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALPORT;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETMETHOD;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERVALUES;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHINFO;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHTRANSLATED;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPROTOCOL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETQUERYSTRING;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREALPATH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEADDR;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEHOST;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEPORT;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEUSER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTDISPATCHER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURI;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTEDSESSIONID;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSCHEME;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERNAME;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERPORT;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVLETPATH;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSESSION;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETUSERPRINCIPAL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISREQUESTEDSESSIONIDVALID;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISSECURE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISUSERINROLE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_REMOVEATTRIBUTE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_SETATTRIBUTE;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_event
 *
 */
public class DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest implements Portlet, ResourceServingPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
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

      QName eventQName = new QName(TCKNAMESPACE,
             "DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest");
      portletResp.setEvent(eventQName, "Hi!");
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

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getAttribute */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getAttribute must provide the same         */
      /* functionality as EventRequest.getAttribute"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getAttributeNames */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getAttributeNames must provide the same    */
      /* functionality as EventRequest.getAttributeNames"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETATTRIBUTENAMES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getAuthType */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getAuthType must provide the same          */
      /* functionality as EventRequest.getAuthType"                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETAUTHTYPE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getCharacterEncoding */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getCharacterEncoding must return null"     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCHARACTERENCODING, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getContentLength */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getContentLength must return 0"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTLENGTH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getContentType */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getContentType must return null"           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTENTTYPE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getContextPath */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getContextPath must provide the same       */
      /* functionality as EventRequest.getContextPath"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCONTEXTPATH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getCookies */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getCookies must provide the same           */
      /* functionality as EventRequest.getCookies"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETCOOKIES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getDateHeader */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getDateHeader must return a value          */
      /* corresponding to that returned by EventRequest.getProperty for the   */
      /* corresponding header name"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETDATEHEADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getHeader */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getHeader must return a value              */
      /* corresponding to that returned by EventRequest.getProperty for the   */
      /* corresponding header name"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getHeaderNames */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* Enumeration returned by HttpServletRequest.getHeaderNames must be    */
      /* contained in the Enumeration returned by                             */
      /* EventRequest.getPropertyNames"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERNAMES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getHeaders */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getHeaders must return a value             */
      /* corresponding to that returned by EventRequest.getProperties for     */
      /* the corresponding header name"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETHEADERS, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getInputStream */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getInputStream must return null"           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINPUTSTREAM, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getIntHeader */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getIntHeader must return a value           */
      /* corresponding to that returned by EventRequest.getProperty for the   */
      /* corresponding header name"                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETINTHEADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocalAddr */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getLocalAddr must return null"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALADDR, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocalName */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getLocalName must return null"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALNAME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocalPort */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getLocalPort must return 0"                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALPORT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocale */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getLocale must provide the same            */
      /* functionality as EventRequest.getLocale"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getLocales */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getLocales must provide the same           */
      /* functionality as EventRequest.getLocales"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETLOCALES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getMethod */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getMethod must provide the same            */
      /* functionality as EventRequest.getMethod"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETMETHOD, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameter */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getParameter must provide the same         */
      /* functionality as EventRequest.getParameter"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameterMap */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getParameterMap must provide the same      */
      /* functionality as EventRequest.getParameterMap"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERMAP, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameterNames */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getParameterNames must provide the same    */
      /* functionality as EventRequest.getParameterNames"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERNAMES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getParameterValues */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getParameterValues must provide the same   */
      /* functionality as EventRequest.getParameterValues"                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPARAMETERVALUES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getPathInfo */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getPathInfo must a value corresponding     */
      /* to the path used to obtain the PortletRequestDispatcher"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHINFO, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getPathTranslated */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getPathTranslated must a value             */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPATHTRANSLATED, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getProtocol */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getProtocol must return \"HTTP/1.1\""      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETPROTOCOL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getQueryString */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getQueryString must a value                */
      /* corresponding to the query string information used to obtain the     */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETQUERYSTRING, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getReader */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getReader must return null"                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRealPath */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRealPath must return null"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREALPATH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemoteAddr */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRemoteAddr must return null"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEADDR, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemoteHost */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRemoteHost must return null"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEHOST, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemotePort */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRemotePort must return 0"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEPORT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRemoteUser */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRemoteUser must provide the same        */
      /* functionality as EventRequest.getRemoteUser"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREMOTEUSER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestDispatcher */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRequestDispatcher must provide          */
      /* functionality as defined in the servlet specification"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTDISPATCHER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestURI */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRequestURI must a value corresponding   */
      /* to the path and query string information used to obtain the          */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURI, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestURL */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRequestURL must return null"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTURL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getRequestedSessionId */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getRequestedSessionId must provide the     */
      /* same functionality as EventRequest.getRequestedSessionId"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETREQUESTEDSESSIONID, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getScheme */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getScheme must provide the same            */
      /* functionality as EventRequest.getScheme"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSCHEME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getServerName */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getServerName must provide the same        */
      /* functionality as EventRequest.getServerName"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERNAME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getServerPort */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getServerPort must provide the same        */
      /* functionality as EventRequest.getServerPort"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVERPORT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getServletPath */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getServletPath must a value                */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSERVLETPATH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getSession */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getSession must provide the same           */
      /* functionality as                                                     */
      /* EventRequest.getPortletSession(APPLICATION_SCOPE)"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETSESSION, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_getUserPrincipal */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.getUserPrincipal must provide the same     */
      /* functionality as EventRequest.getUserPrincipal"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_GETUSERPRINCIPAL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_isRequestedSessionIdValid */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.isRequestedSessionIdValid must provide     */
      /* the same functionality as EventRequest.isRequestedSessionIdValid"    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISREQUESTEDSESSIONIDVALID, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_isSecure */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.isSecure must provide the same             */
      /* functionality as EventRequest.isSecure"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISSECURE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_isUserInRole */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.isUserInRole must provide the same         */
      /* functionality as EventRequest.isUserInRole"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_ISUSERINROLE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_removeAttribute */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.removeAttribute must provide the same      */
      /* functionality as EventRequest.removeAttribute"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_REMOVEATTRIBUTE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventRequest_setAttribute */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletRequest.setAttribute must provide the same         */
      /* functionality as EventRequest.setAttribute"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTREQUEST_SETATTRIBUTE, aurl);
         tb.writeTo(writer);
      }

   }

}
