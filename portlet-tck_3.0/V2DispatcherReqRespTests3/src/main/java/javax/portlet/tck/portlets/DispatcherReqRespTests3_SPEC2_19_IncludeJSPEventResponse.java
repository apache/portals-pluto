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

import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_CONTAINSHEADER;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL1;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL1;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETBUFFERSIZE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETLOCALE;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ISCOMMITTED;
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
 * portlet DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_event
 *
 */
public class DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse implements Portlet, ResourceServingPortlet {

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
             "DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse");
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

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_containsHeader */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.containsHeader must return false"         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_CONTAINSHEADER, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeRedirectURL1 */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.encodeRedirectURL must return null"       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeRedirectUrl */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.encodeRedirectUrl must return null"       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEREDIRECTURL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeURL1 */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.encodeURL must provide the same           */
      /* functionality as EventResponse.encodeURL"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_encodeUrl */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.encodeUrl must provide the same           */
      /* functionality as EventResponse.encodeURL"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ENCODEURL, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getBufferSize */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.getBufferSize must return 0"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETBUFFERSIZE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getCharacterEncoding */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.getCharacterEncoding must return null"    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCHARACTERENCODING, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getContentType */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.getContentType must return null"          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETCONTENTTYPE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_getLocale */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.getLocale must return null"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_GETLOCALE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2DispatcherReqRespTests3_SPEC2_19_IncludeJSPEventResponse_isCommitted */
      /* Details: "In a target jsp of a include in the Event phase, the       */
      /* method HttpServletResponse.isCommitted must return true"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2DISPATCHERREQRESPTESTS3_SPEC2_19_INCLUDEJSPEVENTRESPONSE_ISCOMMITTED, aurl);
         tb.writeTo(writer);
      }

   }

}
