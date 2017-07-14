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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDUSER_INFO;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCCPP_PROFILE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDBASIC_AUTH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDFORM_AUTH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCLIENT_CERT_AUTH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDDIGEST_AUTH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_PHASE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDEVENT_PHASE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PHASE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRESOURCE_PHASE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDLIFECYCLE_PHASE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PART;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_HEADERS;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_MARKUP;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_SCOPE_ID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPREFERENCES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTALCONTEXT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER5;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES4;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALES;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSCHEME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERNAME;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERPORT;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWID;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP1;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP2;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP3;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_EXISTS;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet RequestTests_PortletRequest_ApiEvent_event
 *
 */
public class RequestTests_PortletRequest_ApiEvent implements Portlet, ResourceServingPortlet {

   private final Logger LOGGER = LoggerFactory.getLogger(RequestTests_PortletRequest_ApiEvent.class);

   @Override
   public void init(PortletConfig config) throws PortletException {
      
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq, ActionResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

     

      QName eventQName = new QName(TCKNAMESPACE,
             "RequestTests_PortletRequest_ApiEvent");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.trace("main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldUSER_INFO      */
      /* Details: "Has String field USER_INFO with value of                   */
      /* \"javax.portlet.userinfo\" "                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDUSER_INFO, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldCCPP_PROFILE   */
      /* Details: "Has String field CCPP_PROFILE with value of                */
      /* \"javax.portlet.ccpp\" "                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCCPP_PROFILE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldBASIC_AUTH     */
      /* Details: "Has String field BASIC_AUTH with value of \"BASIC\" "      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDBASIC_AUTH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldFORM_AUTH      */
      /* Details: "Has String field FORM_AUTH with value of \"FORM\" "        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDFORM_AUTH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldCLIENT_CERT_AUTH */
      /* Details: "Has String field CLIENT_CERT_AUTH with value of            */
      /* \"CLIENT_CERT\" "                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDCLIENT_CERT_AUTH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldDIGEST_AUTH    */
      /* Details: "Has String field DIGEST_AUTH with value of \"DIGEST\" "    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDDIGEST_AUTH, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldACTION_PHASE   */
      /* Details: "Has String field ACTION_PHASE with value of                */
      /* \"ACTION_PHASE\" "                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_PHASE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldEVENT_PHASE    */
      /* Details: "Has String field EVENT_PHASE with value of                 */
      /* \"EVENT_PHASE\" "                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDEVENT_PHASE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_PHASE   */
      /* Details: "Has String field RENDER_PHASE with value of                */
      /* \"RENDER_PHASE\" "                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PHASE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldRESOURCE_PHASE */
      /* Details: "Has String field RESOURCE_PHASE with value of              */
      /* \"RESOURCE_PHASE\" "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRESOURCE_PHASE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldLIFECYCLE_PHASE */
      /* Details: "Has String field LIFECYCLE_PHASE with value of             */
      /* \"javax.portlet.lifecycle_phase\" "                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDLIFECYCLE_PHASE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_PART    */
      /* Details: "Has String field RENDER_PART with value of                 */
      /* \"javax.portlet.render_part\" "                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_PART, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_HEADERS */
      /* Details: "Has String field RENDER_HEADERS with value of              */
      /* \"RENDER_HEADERS\" "                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_HEADERS, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldRENDER_MARKUP  */
      /* Details: "Has String field RENDER_MARKUP with value of               */
      /* \"RENDER_MARKUP\" "                                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDRENDER_MARKUP, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_fieldACTION_SCOPE_ID */
      /* Details: "Has String field ACTION_SCOPE_ID with value of             */
      /* \"javax.portlet.as\" "                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_FIELDACTION_SCOPE_ID, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isWindowStateAllowed1 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns true     */
      /* if the specified WindowState is allowed"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isWindowStateAllowed2 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns false    */
      /* if the specified WindowState is not allowed"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISWINDOWSTATEALLOWED2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isPortletModeAllowed1 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns true     */
      /* if the specified PortletMode is allowed"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isPortletModeAllowed2 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns false    */
      /* if the specified PortletMode is not allowed"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISPORTLETMODEALLOWED2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortletMode      */
      /* Details: "Method getPortletMode(): Returns current PortletMode "     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETMODE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getWindowState      */
      /* Details: "Method getWindowState(): Returns current WindowState"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWSTATE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPreferences      */
      /* Details: "Method getPreferences(): Returns the PortletPreferences    */
      /* object associated with the portlet"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPREFERENCES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortletSessionA1 */
      /* Details: "Method getPortletSession(): Returns current                */
      /* PortletSession if one already exists"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortletSessionA2 */
      /* Details: "Method getPortletSession(): Returns new PortletSession     */
      /* if one does not already exist"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONA2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB1 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* true, returns current PortletSession if one already exists"          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB2 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* true, returns new PortletSession if one does not already exist"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB3 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* false, returns current PortletSession if one already exists"         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortletSessionB4 */
      /* Details: "Method getPortletSession(boolean): If input flag is        */
      /* false, returns null if one does not already exist"                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTLETSESSIONB4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getProperty1        */
      /* Details: "Method getProperty(String): If specified request           */
      /* property exists, returns its value "                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getProperty2        */
      /* Details: "Method getProperty(String): If specified request           */
      /* property does not exist, returns null"                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getProperty3        */
      /* Details: "Method getProperty(String): Throws                         */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTY3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getProperties1      */
      /* Details: "Method getProperties(String): If specified request         */
      /* property exists, returns its values as an Enumeration "              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getProperties2      */
      /* Details: "Method getProperties(String): If specified request         */
      /* property does not exist, returns an empty Enumeration"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getProperties3      */
      /* Details: "Method getProperties(String): Throws                       */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTIES3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPropertyNames1   */
      /* Details: "Method getPropertyNames(): Returns an Enumeration of all   */
      /* request property names"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPropertyNames2   */
      /* Details: "Method getPropertyNames(): Returns an empty Enumeration    */
      /* if there are no request properties defined"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPROPERTYNAMES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPortalContext    */
      /* Details: "Method getPortalContext(): Returns the context of the      */
      /* portal"                                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPORTALCONTEXT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getAuthType1        */
      /* Details: "Method getAuthType(): Returns a String indicating the      */
      /* authentication type if the request was authenticated"                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getAuthType2        */
      /* Details: "Method getAuthType(): Returns null if the request was      */
      /* not authenticated"                                                   */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETAUTHTYPE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getContextPath1     */
      /* Details: "Method getContextPath(): Returns a String representing     */
      /* the context path associated with the portlet"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getContextPath2     */
      /* Details: "Method getContextPath(): Returns an empty String if the    */
      /* portlet is deployed in the default context"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getContextPath3     */
      /* Details: "Method getContextPath(): If the context path is not        */
      /* empty, it must start with \"/\" and may not end with \"/\""          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCONTEXTPATH3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getRemoteUser1      */
      /* Details: "Method getRemoteUser(): Returns a String representing      */
      /* the login of the user if the request is authenticated"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getRemoteUser2      */
      /* Details: "Method getRemoteUser(): Returns null if the request has    */
      /* not been authenticated"                                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREMOTEUSER2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getUserPrincipal1   */
      /* Details: "Method getUserPrincipal(): Returns a                       */
      /* java.security.Principal object representing the user if the          */
      /* request has been authenticated"                                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getUserPrincipal2   */
      /* Details: "Method getUserPrincipal(): Returns null if the request     */
      /* has not been authenticated"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETUSERPRINCIPAL2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isUserInRole1       */
      /* Details: "Method isUserInRole(): Returns true if the authenticated   */
      /* user is in the specified role"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isUserInRole2       */
      /* Details: "Method isUserInRole(): Returns false if the                */
      /* authenticated user is not in the specified role"                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isUserInRole3       */
      /* Details: "Method isUserInRole(): Returns false if the user is not    */
      /* authenticated"                                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISUSERINROLE3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getAttribute1       */
      /* Details: "Method getAttribute(String): Returns a java.lang.Object    */
      /* for the specified attribute name"                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getAttribute2       */
      /* Details: "Method getAttribute(String): Returns null if no            */
      /* attribute with the specified name exists"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getAttribute3       */
      /* Details: "Method getAttribute(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTE3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getAttributeNames1  */
      /* Details: "Method getAttributeNames(): Returns a                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* attribute names"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getAttributeNames2  */
      /* Details: "Method getAttributeNames(): Returns an empty Enumeration   */
      /* if there are no attributes available"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETATTRIBUTENAMES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameter1       */
      /* Details: "Method getParameter(String): Returns String value of       */
      /* parameter specified by the name"                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER1,"TestValue");
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameter2       */
      /* Details: "Method getParameter(String): Returns String value of a     */
      /* public render parameter specified by the name"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter("tckPRP1","TestValue2");
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameter3       */
      /* Details: "Method getParameter(String): Returns null if no            */
      /* parameter exists for the specified name"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameter4       */
      /* Details: "Method getParameter(String): Returns first String value    */
      /* from values array if use with a multivalued parameter"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER4,new String[] {"TestValue1","TestValue2"});
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameter5       */
      /* Details: "Method getParameter(String): Throws                        */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETER5, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterNames1  */
      /* Details: "Method getParameterNames(): Returns a                      */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available       */
      /* parameter names"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterNames2  */
      /* Details: "Method getParameterNames(): Returns an empty Enumeration   */
      /* if there are no parameters available"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERNAMES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterValues1 */
      /* Details: "Method getParameterValues(String): Returns String[]        */
      /* value of parameter specified by the name"                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES1,new String[] {"Value1","Value2","Value3"});
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterValues2 */
      /* Details: "Method getParameterValues(String): Returns String[]        */
      /* value of a public render parameter specified by the name"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter("tckPRP1",new String[] {"Value1","Value2","Value3"});
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterValues3 */
      /* Details: "Method getParameterValues(String): Returns null if no      */
      /* parameter exists for the specified name"                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameter(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES3,new String[] {});
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterValues4 */
      /* Details: "Method getParameterValues(String): Throws                  */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERVALUES4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterMap1    */
      /* Details: "Method getParameterMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the parameter names and values if parameters are available"      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterMap2    */
      /* Details: "Method getParameterMap(): The returned map contains all    */
      /* public and private parameters for the request"                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getParameterMap3    */
      /* Details: "Method getParameterMap(): Returns an empty map if no       */
      /* parameters exist"                                                    */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPARAMETERMAP3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isSecure1           */
      /* Details: "Method isSecure(): Returns true if the request was made    */
      /* through a secure channel"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isSecure2           */
      /* Details: "Method isSecure(): Returns false if the request was not    */
      /* made through a secure channel"                                       */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISSECURE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_setAttribute1       */
      /* Details: "Method setAttribute(String, Object): Stores an attribute   */
      /* object under the specified name in the request"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_setAttribute2       */
      /* Details: "Method setAttribute(String, Object): Removes the           */
      /* attribute by the specified name if the object is null"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_setAttribute3       */
      /* Details: "Method setAttribute(String, Object): Throws                */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_SETATTRIBUTE3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_removeAttribute1    */
      /* Details: "Method removeAttribute(String): Removes the attribute      */
      /* specified by the name from the request"                              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_removeAttribute2    */
      /* Details: "Method removeAttribute(String): Throws                     */
      /* IllegalArgumentException if the name is null"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_REMOVEATTRIBUTE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getRequestedSessionId1 */
      /* Details: "Method getRequestedSessionId(): Returns the session ID     */
      /* indicated in the client request"                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getRequestedSessionId2 */
      /* Details: "Method getRequestedSessionId(): Returns null if no         */
      /* session ID was indicated in the client request"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETREQUESTEDSESSIONID2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isRequestedSessionIdValid1 */
      /* Details: "Method isRequestedSessionIdValid(): Returns true if the    */
      /* session ID is valid"                                                 */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_isRequestedSessionIdValid2 */
      /* Details: "Method isRequestedSessionIdValid(): Returns false if the   */
      /* session ID is not valid"                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_ISREQUESTEDSESSIONIDVALID2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getResponseContentType1 */
      /* Details: "Method getResponseContentType(): Returns a String          */
      /* representing the portal preferred content type for the response if   */
      /* the content type is defined in the portlet descriptor  "             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getResponseContentType2 */
      /* Details: "Method getResponseContentType(): Returns an empty          */
      /* Enumeration if the content type is not defined in the portlet        */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPE2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getResponseContentTypes1 */
      /* Details: "Method getResponseContentTypes(): Returns an               */
      /* java.util.Enumeration&lt;java.lang.String&gt; object representing    */
      /* the portal preferred content types for the response if the content   */
      /* types are defined in the portlet descriptor"                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getResponseContentTypes2 */
      /* Details: "Method getResponseContentTypes(): Returns an empty         */
      /* Enumeration if the content types are not defined in the portlet      */
      /* descriptor"                                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETRESPONSECONTENTTYPES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getLocale           */
      /* Details: "Method getLocale(): Returns an java.util.Locale object     */
      /* representing the preferred Locale for the response"                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALE, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getLocales          */
      /* Details: "Method getLocales(): Returns an                            */
      /* java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in      */
      /* which the portal will accept content"                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETLOCALES, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getScheme           */
      /* Details: "Method getScheme(): Returns a String value representing    */
      /* the scheme name for the request"                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSCHEME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getServerName       */
      /* Details: "Method getServerName(): Returns a String value             */
      /* representing the host name for the request"                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERNAME, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getServerPort       */
      /* Details: "Method getServerPort(): Returns an int value               */
      /* representing the port number for the request"                        */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETSERVERPORT, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getWindowID         */
      /* Details: "Method getWindowID(): Returns a String value               */
      /* representing the portlet window ID"                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETWINDOWID, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getCookies1         */
      /* Details: "Method getCookies(): Returns a                             */
      /* javax.servlet.http.Cookie[] array containing the cookies for this    */
      /* request"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getCookies2         */
      /* Details: "Method getCookies(): Returns null if no cookies are        */
      /* present"                                                             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETCOOKIES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPrivateParameterMap1 */
      /* Details: "Method getPrivateParameterMap(): Returns an                */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the private parameter names and values if available"             */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPrivateParameterMap2 */
      /* Details: "Method getPrivateParameterMap(): The returned map is       */
      /* immutable"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPrivateParameterMap3 */
      /* Details: "Method getPrivateParameterMap(): Returns an empty map if   */
      /* no private parameters exist"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPRIVATEPARAMETERMAP3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPublicParameterMap1 */
      /* Details: "Method getPublicParameterMap(): Returns an                 */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the public parameter names and values if available"              */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPublicParameterMap2 */
      /* Details: "Method getPublicParameterMap(): The returned map is        */
      /* immutable"                                                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_getPublicParameterMap3 */
      /* Details: "Method getPublicParameterMap(): Returns an empty map if    */
      /* no public parameters exist"                                          */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_GETPUBLICPARAMETERMAP3, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2RequestTests_PortletRequest_ApiEvent_exists              */
      /* Details: "Method exists(): The P3PUserInfos exist as a public        */
      /* static enum"                                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(V2REQUESTTESTS_PORTLETREQUEST_APIEVENT_EXISTS, aurl);
         tb.writeTo(writer);
      }

   }

}
