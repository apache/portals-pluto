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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.TestButton;
import javax.xml.namespace.QName;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_SCOPE_ID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDBASIC_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCCPP_PROFILE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCLIENT_CERT_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDDIGEST_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDEVENT_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDFORM_AUTH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDLIFECYCLE_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_HEADERS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_MARKUP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PART;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRESOURCE_PHASE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDUSER_INFO;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTENAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATH;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATHRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAPRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERVALUES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTALCONTEXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSION;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONA;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPRIVATEPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTY;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPUBLICPARAMETERMAP;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREQUESTEDSESSIONID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETUSERPRINCIPAL;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWID;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWIDRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISPORTLETMODEALLOWED;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISWINDOWSTATEALLOWED;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTERETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;
import static javax.portlet.tck.constants.Constants.TCKNAMESPACE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * SigTestsEvent_PortletRequest_SIGEvent_event
 *
 */
public class SigTestsEvent_PortletRequest_SIGEvent implements Portlet {

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

    QName eventQName = new QName(TCKNAMESPACE, "SigTestsEvent_PortletRequest_SIGEvent");
    portletResp.setEvent(eventQName, "Hi!");
  }

  @Override
  public void render(RenderRequest portletReq, RenderResponse portletResp)
      throws PortletException, IOException {

    long tid = Thread.currentThread().getId();
    portletReq.setAttribute(THREADID_ATTR, tid);

    PrintWriter writer = portletResp.getWriter();

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_PHASE */
    /* Details: "EventRequest has String field ACTION_PHASE " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_PHASE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldACTION_SCOPE_ID */
    /* Details: "EventRequest has String field ACTION_SCOPE_ID " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDACTION_SCOPE_ID, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldBASIC_AUTH */
    /* Details: "EventRequest has String field BASIC_AUTH " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDBASIC_AUTH, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldCCPP_PROFILE */
    /* Details: "EventRequest has String field CCPP_PROFILE " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCCPP_PROFILE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldCLIENT_CERT_AUTH */
    /* Details: "EventRequest has String field CLIENT_CERT_AUTH " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDCLIENT_CERT_AUTH, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldDIGEST_AUTH */
    /* Details: "EventRequest has String field DIGEST_AUTH " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDDIGEST_AUTH, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldEVENT_PHASE */
    /* Details: "EventRequest has String field EVENT_PHASE " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDEVENT_PHASE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldFORM_AUTH */
    /* Details: "EventRequest has String field FORM_AUTH " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDFORM_AUTH, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldLIFECYCLE_PHASE */
    /* Details: "EventRequest has String field LIFECYCLE_PHASE " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDLIFECYCLE_PHASE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_HEADERS */
    /* Details: "EventRequest has String field RENDER_HEADERS " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_HEADERS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_MARKUP */
    /* Details: "EventRequest has String field RENDER_MARKUP " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_MARKUP, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PART */
    /* Details: "EventRequest has String field RENDER_PART " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PART, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRENDER_PHASE */
    /* Details: "EventRequest has String field RENDER_PHASE " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRENDER_PHASE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldRESOURCE_PHASE */
    /* Details: "EventRequest has String field RESOURCE_PHASE " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDRESOURCE_PHASE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_fieldUSER_INFO */
    /* Details: "EventRequest has String field USER_INFO " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_FIELDUSER_INFO, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttribute */
    /* Details: "EventRequest has a getAttribute(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNames */
    /* Details: "EventRequest has a getAttributeNames()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTENAMES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNamesReturns */
    /* Details: "EventRequest method getAttributeNames() returns */
    /* java.util.Enumeration " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeNamesReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAttributeReturns */
    /* Details: "EventRequest method getAttribute(String) returns Object */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETATTRIBUTERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthType */
    /* Details: "EventRequest has a getAuthType()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetAuthTypeReturns */
    /* Details: "EventRequest method getAuthType() returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETAUTHTYPERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPath */
    /* Details: "EventRequest has a getContextPath()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATH, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetContextPathReturns */
    /* Details: "EventRequest method getContextPath() returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCONTEXTPATHRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookies */
    /* Details: "EventRequest has a getCookies()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetCookiesReturns */
    /* Details: "EventRequest method getCookies() returns */
    /* javax.servlet.http.Cookie[] " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETCOOKIESRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocale */
    /* Details: "EventRequest has a getLocale()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocaleReturns */
    /* Details: "EventRequest method getLocale() returns java.util.Locale */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocales */
    /* Details: "EventRequest has a getLocales()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetLocalesReturns */
    /* Details: "EventRequest method getLocales() returns */
    /* java.util.Enumeration " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETLOCALESRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameter */
    /* Details: "EventRequest has a getParameter(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETER, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMap */
    /* Details: "EventRequest has a getParameterMap()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAP, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterMapReturns */
    /* Details: "EventRequest method getParameterMap() returns */
    /* java.util.Map " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERMAPRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNames */
    /* Details: "EventRequest has a getParameterNames()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERNAMES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNamesReturns */
    /* Details: "EventRequest method getParameterNames() returns */
    /* java.util.Enumeration " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterNamesReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterReturns */
    /* Details: "EventRequest method getParameter(String) returns String */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValues */
    /* Details: "EventRequest has a getParameterValues(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPARAMETERVALUES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValuesReturns */
    /* Details: "EventRequest method getParameterValues(String) returns */
    /* String[] " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetParameterValuesReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContext */
    /* Details: "EventRequest has a getPortalContext()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTALCONTEXT, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContextReturns */
    /* Details: "EventRequest method getPortalContext() returns */
    /* PortalContext " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortalContextReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletMode */
    /* Details: "EventRequest has a getPortletMode()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletModeReturns */
    /* Details: "EventRequest method getPortletMode() returns PortletMode */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETMODERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSession */
    /* Details: "EventRequest has a getPortletSession()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSION, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionA */
    /* Details: "EventRequest has a getPortletSession(boolean)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPORTLETSESSIONA, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturns */
    /* Details: "EventRequest method getPortletSession() returns */
    /* PortletSession " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturnsA */
    /* Details: "EventRequest method getPortletSession(boolean) returns */
    /* PortletSession " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPortletSessionReturnsA", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferences */
    /* Details: "EventRequest has a getPreferences()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPreferencesReturns */
    /* Details: "EventRequest method getPreferences() returns */
    /* PortletPreferences " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPREFERENCESRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMap */
    /* Details: "EventRequest has a getPrivateParameterMap()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPRIVATEPARAMETERMAP, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMapReturns */
    /* Details: "EventRequest method getPrivateParameterMap() returns */
    /* java.util.Map " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPrivateParameterMapReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperties */
    /* Details: "EventRequest has a getProperties(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertiesReturns */
    /* Details: "EventRequest method getProperties(String) returns */
    /* java.util.Enumeration " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTIESRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetProperty */
    /* Details: "EventRequest has a getProperty(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTY, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNames */
    /* Details: "EventRequest has a getPropertyNames()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYNAMES, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNamesReturns */
    /* Details: "EventRequest method getPropertyNames() returns */
    /* java.util.Enumeration " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyNamesReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPropertyReturns */
    /* Details: "EventRequest method getProperty(String) returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPROPERTYRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMap */
    /* Details: "EventRequest has a getPublicParameterMap()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETPUBLICPARAMETERMAP, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMapReturns */
    /* Details: "EventRequest method getPublicParameterMap() returns */
    /* java.util.Map " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetPublicParameterMapReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUser */
    /* Details: "EventRequest has a getRemoteUser()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSER, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRemoteUserReturns */
    /* Details: "EventRequest method getRemoteUser() returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREMOTEUSERRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionId */
    /* Details: "EventRequest has a getRequestedSessionId()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETREQUESTEDSESSIONID, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionIdReturns */
    /* Details: "EventRequest method getRequestedSessionId() returns */
    /* String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetRequestedSessionIdReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentType */
    /* Details: "EventRequest has a getResponseContentType()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETRESPONSECONTENTTYPE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypeReturns */
    /* Details: "EventRequest method getResponseContentType() returns */
    /* String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypeReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypes */
    /* Details: "EventRequest has a getResponseContentTypes()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypes", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypesReturns */
    /* Details: "EventRequest method getResponseContentTypes() returns */
    /* java.util.Enumeration " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetResponseContentTypesReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetScheme */
    /* Details: "EventRequest has a getScheme()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEME, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetSchemeReturns */
    /* Details: "EventRequest method getScheme() returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSCHEMERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerName */
    /* Details: "EventRequest has a getServerName()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAME, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerNameReturns */
    /* Details: "EventRequest method getServerName() returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERNAMERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPort */
    /* Details: "EventRequest has a getServerPort()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORT, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetServerPortReturns */
    /* Details: "EventRequest method getServerPort() returns int " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETSERVERPORTRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipal */
    /* Details: "EventRequest has a getUserPrincipal()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETUSERPRINCIPAL, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipalReturns */
    /* Details: "EventRequest method getUserPrincipal() returns */
    /* java.security.Principal " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasGetUserPrincipalReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowID */
    /* Details: "EventRequest has a getWindowID()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWID, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowIDReturns */
    /* Details: "EventRequest method getWindowID() returns String " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWIDRETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowState */
    /* Details: "EventRequest has a getWindowState()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasGetWindowStateReturns */
    /* Details: "EventRequest method getWindowState() returns WindowState */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASGETWINDOWSTATERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowed */
    /* Details: "EventRequest has a isPortletModeAllowed(PortletMode) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISPORTLETMODEALLOWED, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowedReturns */
    /* Details: "EventRequest method isPortletModeAllowed(PortletMode) */
    /* returns boolean " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsPortletModeAllowedReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValid */
    /* Details: "EventRequest has a isRequestedSessionIdValid()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValid", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValidReturns */
    /* Details: "EventRequest method isRequestedSessionIdValid() returns */
    /* boolean " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsRequestedSessionIdValidReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecure */
    /* Details: "EventRequest has a isSecure()  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsSecureReturns */
    /* Details: "EventRequest method isSecure() returns boolean " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISSECURERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRole */
    /* Details: "EventRequest has a isUserInRole(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsUserInRoleReturns */
    /* Details: "EventRequest method isUserInRole(String) returns boolean */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISUSERINROLERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowed */
    /* Details: "EventRequest has a isWindowStateAllowed(WindowState) */
    /* method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASISWINDOWSTATEALLOWED, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowedReturns */
    /* Details: "EventRequest method isWindowStateAllowed(WindowState) */
    /* returns boolean " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb = new TestButton(
          "V2SigTestsEvent_PortletRequest_SIGEvent_hasIsWindowStateAllowedReturns", aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttribute */
    /* Details: "EventRequest has a removeAttribute(String)  method " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasRemoveAttributeReturns */
    /* Details: "EventRequest method removeAttribute(String) returns void */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASREMOVEATTRIBUTERETURNS, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttribute */
    /* Details: "EventRequest has a setAttribute(String, Object) method */
    /* " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTE, aurl);
      tb.writeTo(writer);
    }

    /* TestCase: V2SigTestsEvent_PortletRequest_SIGEvent_hasSetAttributeReturns */
    /* Details: "EventRequest method setAttribute(String, Object) returns */
    /* void " */
    {
      PortletURL aurl = portletResp.createActionURL();
      aurl.setParameters(portletReq.getPrivateParameterMap());
      TestButton tb =
          new TestButton(V2SIGTESTSEVENT_PORTLETREQUEST_SIGEVENT_HASSETATTRIBUTERETURNS, aurl);
      tb.writeTo(writer);
    }

  }

}
