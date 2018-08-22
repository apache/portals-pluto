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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ActionURL;
import javax.portlet.HeaderPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.portlet.WindowState;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.PublicRenderParameterDefinition;
import javax.portlet.annotations.Supports;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestLink;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.util.ModuleTestCaseDetails;

import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDUSER_INFO;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCCPP_PROFILE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDBASIC_AUTH;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDFORM_AUTH;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCLIENT_CERT_AUTH;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDDIGEST_AUTH;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_PHASE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDEVENT_PHASE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PHASE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRESOURCE_PHASE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDHEADER_PHASE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDLIFECYCLE_PHASE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PART;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_HEADERS;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_MARKUP;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_SCOPE_ID;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPREFERENCES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTALCONTEXT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER5;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES4;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE3;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPE1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALE;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALES;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSCHEME;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERNAME;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERPORT;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETWINDOWID;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP1;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP2;
import static javax.portlet.tck.util.ModuleTestCaseDetails.V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_EXISTS;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletApplication(publicParams = {
      @PublicRenderParameterDefinition(identifier = "trPara2", qname = @PortletQName(localPart = "trPara2", namespaceURI = "")),
      @PublicRenderParameterDefinition(identifier = "trPara8", qname = @PortletQName(localPart = "trPara8", namespaceURI = "")),
      @PublicRenderParameterDefinition(identifier = "trPara10a", qname = @PortletQName(localPart = "trPara10a", namespaceURI = "")),
      @PublicRenderParameterDefinition(identifier = "trPublic1", qname = @PortletQName(localPart = "trPublic1", namespaceURI = "")),
      @PublicRenderParameterDefinition(identifier = "trPublic2", qname = @PortletQName(localPart = "trPublic2", namespaceURI = ""))})
@PortletConfiguration(portletName = "HeaderPortletTests_SPEC14_PortletRequest_ApiHeader1", publicParams = {
"trPara2", "trPara8", "trPara10a", "trPublic1", "trPublic2" }, supports = {
      @Supports(mimeType = "text/html"), @Supports(mimeType = "*/*") })
public class HeaderPortletTests_SPEC14_PortletRequest_ApiHeader1 implements Portlet, HeaderPortlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
      MutableRenderParameters renderParams = actionResponse.getRenderParameters();
      renderParams.setValue("trB3", "true");
      renderParams.setValue("trB1", "true");
      renderParams.setValue("trA1", "true");
      renderParams.setValue("trPara1", "true");
      renderParams.setValue("trPara2", "true");
      renderParams.setValues("trPara4", "true", "false");
      renderParams.setValue("trPara6", "true");
      renderParams.setValues("trPara7", "true", "false");
      renderParams.setValues("trPara8", "true", "false");
      renderParams.setValue("trPara9", "true");
      renderParams.setValue("trPara10a", "true");
      renderParams.setValue("trPara10b", "true");
      renderParams.setValue("trPrivate1", "true");
      renderParams.setValue("trPrivate2", "true");
      renderParams.setValue("trPublic1", "true");
      renderParams.setValue("trPublic2", "true");
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      
      PrintWriter writer = renderResponse.getWriter();
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute1 */
      /* Details: "Method setAttribute(String, Object): Stores an attribute object  */
      /* under the specified name in the request"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE1);
         String trAttr1 = (String) renderRequest.getAttribute("trAttr1");
         if(trAttr1!=null && trAttr1.equals("true")){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because attribute trAttr1 is not found.");
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute2 */
      /* Details: "Method setAttribute(String, Object): Removes the attribute by    */
      /* the specified name if the object is null"                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE2);
         String trAttr2 = (String) renderRequest.getAttribute("trAttr2");
         if(trAttr2==null){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because attribute trAttr2 is still present.");
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_removeAttribute1 */
      /* Details: "Method removeAttribute(String): Removes the attribute specified  */
      /* by the name from the request"                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE1);
         String trAttr4 = (String) renderRequest.getAttribute("trAttr4");
         if(trAttr4==null){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because attribute trAttr4 is still present.");
         }
         result.writeTo(writer);
      }
      
      String msg = (String) renderRequest.getAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_PortletRequest_ApiHeader1");
      writer.write("<p>" + msg + "</p>\n");
      renderRequest.removeAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_PortletRequest_ApiHeader1");

   }

   @Override
   public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
         throws PortletException, IOException {
      
      StringWriter writer = new StringWriter();
      
      Map<String, Object> sessionAttributes;
      
      ModuleTestCaseDetails tcd = new ModuleTestCaseDetails();
      
      ClassChecker cc = new ClassChecker(headerRequest.getClass());
      
      RenderParameters renderParams = headerRequest.getRenderParameters();

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldUSER_INFO */
      /* Details: "Has String field USER_INFO with value of                         */
      /* \"javax.portlet.userinfo\" "                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDUSER_INFO);
         try {
            result.setTcSuccess(cc.hasField("USER_INFO", "javax.portlet.userinfo"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldCCPP_PROFILE */
      /* Details: "Has String field CCPP_PROFILE with value of                      */
      /* \"javax.portlet.ccpp\" "                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCCPP_PROFILE);
         try {
            result.setTcSuccess(cc.hasField("CCPP_PROFILE", "javax.portlet.ccpp"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldBASIC_AUTH */
      /* Details: "Has String field BASIC_AUTH with value of \"BASIC\" "            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDBASIC_AUTH);
         try {
            result.setTcSuccess(cc.hasField("BASIC_AUTH", "BASIC"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldFORM_AUTH */
      /* Details: "Has String field FORM_AUTH with value of \"FORM\" "              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDFORM_AUTH);
         try {
            result.setTcSuccess(cc.hasField("FORM_AUTH", "FORM"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldCLIENT_CERT_AUTH */
      /* Details: "Has String field CLIENT_CERT_AUTH with value of \"CLIENT_CERT\"  */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDCLIENT_CERT_AUTH);
         try {
            result.setTcSuccess(cc.hasField("CLIENT_CERT_AUTH", "CLIENT_CERT"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldDIGEST_AUTH */
      /* Details: "Has String field DIGEST_AUTH with value of \"DIGEST\" "          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDDIGEST_AUTH);
         try {
            result.setTcSuccess(cc.hasField("DIGEST_AUTH", "DIGEST"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldACTION_PHASE */
      /* Details: "Has String field ACTION_PHASE with value of \"ACTION_PHASE\" "   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_PHASE);
         try {
            result.setTcSuccess(cc.hasField("ACTION_PHASE", "ACTION_PHASE"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldEVENT_PHASE */
      /* Details: "Has String field EVENT_PHASE with value of \"EVENT_PHASE\" "     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDEVENT_PHASE);
         try {
            result.setTcSuccess(cc.hasField("EVENT_PHASE", "EVENT_PHASE"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_PHASE */
      /* Details: "Has String field RENDER_PHASE with value of \"RENDER_PHASE\" "   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PHASE);
         try {
            result.setTcSuccess(cc.hasField("RENDER_PHASE", "RENDER_PHASE"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRESOURCE_PHASE */
      /* Details: "Has String field RESOURCE_PHASE with value of \"RESOURCE_PHASE\" */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRESOURCE_PHASE);
         try {
            result.setTcSuccess(cc.hasField("RESOURCE_PHASE", "RESOURCE_PHASE"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldHEADER_PHASE */
      /* Details: "Has String field HEADER_PHASE with value of \"HEADER_PHASE\" "   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDHEADER_PHASE);
         try {
            result.setTcSuccess(cc.hasField("HEADER_PHASE", "HEADER_PHASE"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldLIFECYCLE_PHASE */
      /* Details: "Has String field LIFECYCLE_PHASE with value of                   */
      /* \"javax.portlet.lifecycle_phase\" "                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDLIFECYCLE_PHASE);
         try {
            result.setTcSuccess(cc.hasField("LIFECYCLE_PHASE", "javax.portlet.lifecycle_phase"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_PART */
      /* Details: "Has String field RENDER_PART with value of                       */
      /* \"javax.portlet.render_part\" "                                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_PART);
         try {
            result.setTcSuccess(cc.hasField("RENDER_PART", "javax.portlet.render_part"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_HEADERS */
      /* Details: "Has String field RENDER_HEADERS with value of \"RENDER_HEADERS\" */
      /* "                                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_HEADERS);
         try {
            result.setTcSuccess(cc.hasField("RENDER_HEADERS", "RENDER_HEADERS"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldRENDER_MARKUP */
      /* Details: "Has String field RENDER_MARKUP with value of \"RENDER_MARKUP\" " */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDRENDER_MARKUP);
         try {
            result.setTcSuccess(cc.hasField("RENDER_MARKUP", "RENDER_MARKUP"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_fieldACTION_SCOPE_ID */
      /* Details: "Has String field ACTION_SCOPE_ID with value of                   */
      /* \"javax.portlet.as\" "                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_FIELDACTION_SCOPE_ID);
         try {
            result.setTcSuccess(cc.hasField("ACTION_SCOPE_ID", "javax.portlet.as"));
         } catch(Exception e) {result.appendTcDetail(e.toString());}
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isWindowStateAllowed1 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns true if the    */
      /* specified WindowState is allowed"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED1);
         result.setTcSuccess(headerRequest.isWindowStateAllowed(WindowState.NORMAL));
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isWindowStateAllowed2 */
      /* Details: "Method isWindowStateAllowed(WindowState): Returns false if the   */
      /* specified WindowState is not allowed"                                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISWINDOWSTATEALLOWED2);
         result.setTcSuccess(!headerRequest.isWindowStateAllowed(WindowState.UNDEFINED));
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isPortletModeAllowed1 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns true if the    */
      /* specified PortletMode is allowed"                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED1);
         result.setTcSuccess(headerRequest.isPortletModeAllowed(PortletMode.VIEW));
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isPortletModeAllowed2 */
      /* Details: "Method isPortletModeAllowed(PortletMode): Returns false if the   */
      /* specified PortletMode is not allowed"                                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISPORTLETMODEALLOWED2);
         result.setTcSuccess(!headerRequest.isPortletModeAllowed(PortletMode.UNDEFINED));
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPreferences */
      /* Details: "Method getPreferences(): Returns the PortletPreferences object   */
      /* associated with the portlet"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPREFERENCES);
         PortletPreferences pp = headerRequest.getPreferences();
         if(pp!=null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB3 */
      /* Details: "Method getPortletSession(boolean): If input flag is false,       */
      /* returns current PortletSession if one already exists"                      */
      if(renderParams.getValue("trB3")!=null && renderParams.getValue("trB3").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB3);
         PortletSession ps = headerRequest.getPortletSession(false);
         if(!ps.isNew()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because this is a new portlet session");
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB3, aurl);
         tb.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB1 */
      /* Details: "Method getPortletSession(boolean): If input flag is true,        */
      /* returns current PortletSession if one already exists"                      */
      if(renderParams.getValue("trB1")!=null && renderParams.getValue("trB1").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB1);
         PortletSession ps = headerRequest.getPortletSession(false);
         if(!ps.isNew()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because this is a new portlet session");
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB1, aurl);
         tb.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionA1 */
      /* Details: "Method getPortletSession(): Returns current PortletSession if    */
      /* one already exists"                                                        */
      if(renderParams.getValue("trA1")!=null && renderParams.getValue("trA1").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA1);
         PortletSession ps = headerRequest.getPortletSession();
         if(!ps.isNew()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because this is a new portlet session");
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA1, aurl);
         tb.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isRequestedSessionIdValid2 */
      /* Details: "Method isRequestedSessionIdValid(): Returns false if the session */
      /* ID is not valid"                                                           */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID2);
         PortletSession ps = headerRequest.getPortletSession();
         
         // Take backup of attributes set in APPLICATION_SCOPE by other portlets. 
         // We will restore them as soon as we initialize a new session
         // in test case V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB2.
         sessionAttributes = ps.getAttributeMap(APPLICATION_SCOPE);
         ps.invalidate();
         if(!headerRequest.isRequestedSessionIdValid()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because Session ID is still valid.");
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB4 */
      /* Details: "Method getPortletSession(boolean): If input flag is false,       */
      /* returns null if one does not already exist"                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB4);
         PortletSession ps = headerRequest.getPortletSession(false);
         if(ps==null){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because null is not returned.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionB2 */
      /* Details: "Method getPortletSession(boolean): If input flag is true,        */
      /* returns new PortletSession if one does not already exist"                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONB2);
         PortletSession ps = headerRequest.getPortletSession(true);
         
         // Since session is restored now, we now restore all APPLICATION_SCOPED attributes 
         // set by other portlets in header phase.
         for (Map.Entry<String, Object> attribute : sessionAttributes.entrySet())
         {
             ps.setAttribute(attribute.getKey(), attribute.getValue(), APPLICATION_SCOPE);
         }
         if(ps.isNew()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because this is not a new session which means previous session already exists.");
         }
         result.writeTo(writer);
      }      

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortletSessionA2 */
      /* Details: "Method getPortletSession(): Returns new PortletSession if one    */
      /* does not already exist"                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTLETSESSIONA2);
         PortletSession ps = headerRequest.getPortletSession();
         if(ps.isNew()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because portlet session already exists");
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty1 */
      /* Details: "Method getProperty(String): If specified request property        */
      /* exists, returns its value "                                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY1);
         if(headerRequest.getProperty("Accept")!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Accept property is found to be "+headerRequest.getProperty("Accept"));
         } else {
            result.appendTcDetail("Failed because there is no \"Accept\" property in HeaderRequest");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty2 */
      /* Details: "Method getProperty(String): If specified request property does   */
      /* not exist, returns null"                                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY2);
         if(headerRequest.getProperty("NeverMind")==null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperty3 */
      /* Details: "Method getProperty(String): Throws IllegalArgumentException if   */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTY3);
         try{
            headerRequest.getProperty(null);
            result.setTcDetail("Failed because no exception is thrown");
         } catch (IllegalArgumentException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties1 */
      /* Details: "Method getProperties(String): If specified request property      */
      /* exists, returns its values as an Enumeration "                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES1);
         Enumeration<String> properties = headerRequest.getProperties("Accept");
         if(properties.hasMoreElements()){
            result.setTcSuccess(true);
            result.appendTcDetail("Got \"Accept\" property as an enumeration");
         } else {
            result.appendTcDetail("\"Accept\" property couldn't be obtained as an enumeration");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties2 */
      /* Details: "Method getProperties(String): If specified request property does */
      /* not exist, returns an empty Enumeration"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES2);
         Enumeration<String> properties = headerRequest.getProperties("NeverMind");
         if(!properties.hasMoreElements()){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getProperties3 */
      /* Details: "Method getProperties(String): Throws IllegalArgumentException if */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTIES3);
         try{
            headerRequest.getProperties(null);
            result.appendTcDetail("Failed because no exception is thrown");
         } catch (IllegalArgumentException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPropertyNames1 */
      /* Details: "Method getPropertyNames(): Returns an Enumeration of all request */
      /* property names"                                                            */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES1);
         if(headerRequest.getPropertyNames().hasMoreElements()){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPropertyNames2 */
      /* Details: "Method getPropertyNames(): Returns an empty Enumeration if there */
      /* are no request properties defined"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPROPERTYNAMES2);
         result.setTcSuccess(true);
         result.appendTcDetail("Cannot be tested as there will always be HTTP Headers in request.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPortalContext */
      /* Details: "Method getPortalContext(): Returns the context of the portal"    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPORTALCONTEXT);
         if(headerRequest.getPortalContext()!=null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAuthType1 */
      /* Details: "Method getAuthType(): Returns a String indicating the            */
      /* authentication type if the request was authenticated"                      */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE1);
         String authType = headerRequest.getAuthType();
         if(authType!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Auth type is - "+authType);
         }
         result.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAuthType2 */
      /* Details: "Method getAuthType(): Returns null if the request was not        */
      /* authenticated"                                                             */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETAUTHTYPE2);
         result.appendTcDetail("Cannot be tested as there is no requirement that a portal has to support unauthenticated requests");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath1 */
      /* Details: "Method getContextPath(): Returns a String representing the       */
      /* context path associated with the portlet"                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH1);
         String contextPath = headerRequest.getContextPath();
         if(contextPath!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Context path is found to be - "+contextPath);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath2 */
      /* Details: "Method getContextPath(): Returns an empty String if the portlet  */
      /* is deployed in the default context"                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH2);
         result.setTcSuccess(true);
         result.appendTcDetail("Cannot be tested as portlet already has ContextPath rooted for this test portlet application.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getContextPath3 */
      /* Details: "Method getContextPath(): If the context path is not empty, it    */
      /* must start with \"/\" and may not end with \"/\""                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCONTEXTPATH3);
         String getcntxtpath=headerRequest.getContextPath();
         if(getcntxtpath!=null && getcntxtpath.startsWith("/") && !getcntxtpath.endsWith("/")) {
           result.setTcSuccess(true);
         } else {
           result.appendTcDetail("The getContextPath has an Empty Path / Invalid path" +getcntxtpath);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRemoteUser1 */
      /* Details: "Method getRemoteUser(): Returns a String representing the login  */
      /* of the user if the request is authenticated"                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER1);
         String loguser=headerRequest.getRemoteUser();
         if(loguser!=null) {
           result.setTcSuccess(true);
           result.appendTcDetail("Remote user is - "+loguser);
         } else {
           result.appendTcDetail("The user is not authenticated and has null value" +loguser);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRemoteUser2 */
      /* Details: "Method getRemoteUser(): Returns null if the request has not been */
      /* authenticated"                                                             */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREMOTEUSER2);
         result.appendTcDetail("Cannot be tested as there is no requirement that a portal has to support unauthenticated requests");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getUserPrincipal1 */
      /* Details: "Method getUserPrincipal(): Returns a java.security.Principal     */
      /* object representing the user if the request has been authenticated"        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL1);
         Principal getusrp=headerRequest.getUserPrincipal();
         if(getusrp!=null) {
           result.setTcSuccess(true);
         } else {
           result.appendTcDetail("The User has not been authenticated and method returned null value" );
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getUserPrincipal2 */
      /* Details: "Method getUserPrincipal(): Returns null if the request has not   */
      /* been authenticated"                                                        */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETUSERPRINCIPAL2);
         result.appendTcDetail("Cannot be tested as there is no requirement that a portal has to support unauthenticated requests");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole1 */
      /* Details: "Method isUserInRole(): Returns true if the authenticated user is */
      /* in the specified role"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE1);
         PortletContext portletContext = headerRequest.getPortletContext();
         String securityRole = portletContext.getInitParameter("javax.portlet.portal.SECURITY_ROLE");
         if(headerRequest.isUserInRole(securityRole)) {
            result.setTcSuccess(true);
            result.appendTcDetail("User is in \"" + securityRole + "\" role.");
         } else {
            result.appendTcDetail("Failed because user is not configured to be in \"" + securityRole + "\" role.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole2 */
      /* Details: "Method isUserInRole(): Returns false if the authenticated user   */
      /* is not in the specified role"                                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE2);
         result.setTcSuccess(!headerRequest.isUserInRole("TestRole"));
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isUserInRole3 */
      /* Details: "Method isUserInRole(): Returns false if the user is not          */
      /* authenticated"                                                             */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISUSERINROLE3);
         result.appendTcDetail("Cannot be tested as there is no requirement that a portal has to support unauthenticated requests");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute1 */
      /* Details: "Method getAttribute(String): Returns a java.lang.Object for the  */
      /* specified attribute name"                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE1);
         if(headerRequest.getAttribute("javax.portlet.lifecycle_phase")!=null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute2 */
      /* Details: "Method getAttribute(String): Returns null if no attribute with   */
      /* the specified name exists"                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE2);
         if(headerRequest.getAttribute("InvalidAttribute")==null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttribute3 */
      /* Details: "Method getAttribute(String): Throws IllegalArgumentException if  */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTE3);
         try{
            headerRequest.getAttribute(null);
            result.appendTcDetail("Failed because no exception is raised.");
         } catch(IllegalArgumentException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttributeNames1 */
      /* Details: "Method getAttributeNames(): Returns a                            */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available attribute   */
      /* names"                                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES1);
         Enumeration<String> attributes = headerRequest.getAttributeNames();
         if(attributes.hasMoreElements()){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getAttributeNames2 */
      /* Details: "Method getAttributeNames(): Returns an empty Enumeration if      */
      /* there are no attributes available"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETATTRIBUTENAMES2);
         result.setTcSuccess(true);
         result.appendTcDetail("This Method could not be tested for this Test Portlet which already has Enumeration of Attribute Names ");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter1 */
      /* Details: "Method getParameter(String): Returns String value of parameter   */
      /* specified by the name"                                                     */
      if(renderParams.getValue("trPara1")!=null && renderParams.getValue("trPara1").equals("true"))
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER1);
         if(headerRequest.getParameter("trPara1")!=null && headerRequest.getParameter("trPara1").equals("true")){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter2 */
      /* Details: "Method getParameter(String): Returns String value of a public    */
      /* render parameter specified by the name"                                    */
      if(renderParams.getValue("trPara2")!=null
            && renderParams.getValue("trPara2").equals("true")
            && renderParams.isPublic("trPara2")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER2);
         if(headerRequest.getParameter("trPara2")!=null && headerRequest.getParameter("trPara2").equals("true")){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter3 */
      /* Details: "Method getParameter(String): Returns null if no parameter exists */
      /* for the specified name"                                                    */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER3);
         if(headerRequest.getParameter("invalidParam")==null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter4 */
      /* Details: "Method getParameter(String): Returns first String value from     */
      /* values array if use with a multivalued parameter"                          */
      if(renderParams.getValue("trPara4")!=null
            && renderParams.getValue("trPara4").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER4);
         if(headerRequest.getParameter("trPara4")!=null && headerRequest.getParameter("trPara4").equals("true")){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER4, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameter5 */
      /* Details: "Method getParameter(String): Throws IllegalArgumentException if  */
      /* the name is null"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETER5);
         try{
            headerRequest.getParameter(null);
            result.appendTcDetail("Failed because no exception is raised");
         } catch (IllegalArgumentException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterNames1 */
      /* Details: "Method getParameterNames(): Returns a                            */
      /* java.util.Enumeration&lt;java.lang.String&gt; of the available parameter   */
      /* names"                                                                     */
      if(renderParams.getValue("trPara6")!=null
            && renderParams.getValue("trPara6").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES1);
         Enumeration<String> params = headerRequest.getParameterNames();
         if(params.hasMoreElements()){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERNAMES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues1 */
      /* Details: "Method getParameterValues(String): Returns String[] value of     */
      /* parameter specified by the name"                                           */
      if(renderParams.getValue("trPara7")!=null
            && renderParams.getValue("trPara7").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES1);
         String[] params = headerRequest.getParameterValues("trPara7");
         if(params.length==2 && params[0].equals("true") && params[1].equals("false")){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues2 */
      /* Details: "Method getParameterValues(String): Returns String[] value of a   */
      /* public render parameter specified by the name"                             */
      if(renderParams.getValue("trPara8")!=null
            && renderParams.getValue("trPara8").equals("true") && renderParams.isPublic("trPara8")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES2);
         String[] params = headerRequest.getParameterValues("trPara8");
         if(params.length==2 && params[0].equals("true") && params[1].equals("false")){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues3 */
      /* Details: "Method getParameterValues(String): Returns null if no parameter  */
      /* exists for the specified name"                                             */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES3);
         if(headerRequest.getParameterValues("invalidParam")==null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterValues4 */
      /* Details: "Method getParameterValues(String): Throws                        */
      /* IllegalArgumentException if the name is null"                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERVALUES4);
         try{
            headerRequest.getParameterValues(null);
            result.appendTcDetail("Failed because no exception is raised");
         } catch (IllegalArgumentException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap1 */
      /* Details: "Method getParameterMap(): Returns an                             */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the    */
      /* parameter names and values if parameters are available"                    */
      if(renderParams.getValue("trPara9")!=null
            && renderParams.getValue("trPara9").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP1);
         Map<String, String[]> params = headerRequest.getParameterMap();
         if(!params.isEmpty()){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getParameterMap2 */
      /* Details: "Method getParameterMap(): The returned map contains all public   */
      /* and private parameters for the request"                                    */
      if(renderParams.getValue("trPara10a")!=null
            && renderParams.getValue("trPara10a").equals("true") && renderParams.isPublic("trPara10a")
            && renderParams.getValue("trPara10b")!=null
                  && renderParams.getValue("trPara10b").equals("true")) {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP2);
         Map<String, String[]> params = headerRequest.getParameterMap();
         if(params.containsKey("trPara10a") && params.get("trPara10a")[0].equals("true")
               && params.containsKey("trPara10b") && params.get("trPara10b")[0].equals("true")){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPARAMETERMAP2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isSecure1   */
      /* Details: "Method isSecure(): Returns true if the request was made through  */
      /* a secure channel"                                                          */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE1);
         result.setTcSuccess(true);
         result.appendTcDetail("Not testable as it is implementation specific");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isSecure2   */
      /* Details: "Method isSecure(): Returns false if the request was not made     */
      /* through a secure channel"                                                  */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISSECURE2);
         result.setTcSuccess(true);
         result.appendTcDetail("Not testable as it is implementation specific");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute1 */
      /* Details: "Method setAttribute(String, Object): Stores an attribute object  */
      /* under the specified name in the request"                                   */
      {
         headerRequest.setAttribute("trAttr1", (String)"true");
         RenderURL rurl = headerResponse.createRenderURL();
         TestLink tb = new TestLink(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE1, rurl);
         tb.writeTo(writer);
      }
      
      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute2 */
      /* Details: "Method setAttribute(String, Object): Removes the attribute by    */
      /* the specified name if the object is null"                                  */
      {
         headerRequest.setAttribute("trAttr2", (String)"true");
         headerRequest.setAttribute("trAttr2", null);
         RenderURL rurl = headerResponse.createRenderURL();
         TestLink tb = new TestLink(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE2, rurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_setAttribute3 */
      /* Details: "Method setAttribute(String, Object): Throws                      */
      /* IllegalArgumentException if the name is null"                              */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_SETATTRIBUTE3);
         try{
            headerRequest.setAttribute(null, "true");
            result.appendTcDetail("Failed because no exception is raised");
         } catch (IllegalArgumentException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_removeAttribute1 */
      /* Details: "Method removeAttribute(String): Removes the attribute specified  */
      /* by the name from the request"                                              */
      {
         headerRequest.setAttribute("trAttr4", (String)"true");
         headerRequest.removeAttribute("trAttr4");
         RenderURL rurl = headerResponse.createRenderURL();
         TestLink tb = new TestLink(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE1, rurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_removeAttribute2 */
      /* Details: "Method removeAttribute(String): Throws IllegalArgumentException  */
      /* if the name is null"                                                       */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_REMOVEATTRIBUTE2);
         try{
            headerRequest.removeAttribute(null);
            result.appendTcDetail("Failed because no exception is raised");
         } catch (IllegalArgumentException e){
            result.setTcSuccess(true);
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRequestedSessionId1 */
      /* Details: "Method getRequestedSessionId(): Returns the session ID indicated */
      /* in the client request"                                                     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID1);
         String sesid=headerRequest.getRequestedSessionId();
         if(sesid!=null) {
            result.appendTcDetail("Session ID is - "+sesid);
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("The Session Id has Null Value ");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getRequestedSessionId2 */
      /* Details: "Method getRequestedSessionId(): Returns null if no session ID    */
      /* was indicated in the client request"                                       */
      {
         TestResult result = tcd.getTestResultSucceeded(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETREQUESTEDSESSIONID2);
         result.appendTcDetail("Cannot be tested as there should always be a session ID.");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_isRequestedSessionIdValid1 */
      /* Details: "Method isRequestedSessionIdValid(): Returns true if the session  */
      /* ID is valid"                                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_ISREQUESTEDSESSIONIDVALID1);
         if(headerRequest.isRequestedSessionIdValid()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because session ID is invalid.");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentType1 */
      /* Details: "Method getResponseContentType(): Returns a String representing   */
      /* the portal preferred content type for the response if the content type is  */
      /* defined in the portlet descriptor "                                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPE1);
         String contentType = headerRequest.getResponseContentType();
         if(contentType!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Response content type is found to be - "+contentType);
         } else {
            result.appendTcDetail("Failed because content type is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getResponseContentTypes1 */
      /* Details: "Method getResponseContentTypes(): Returns an                     */
      /* java.util.Enumeration&lt;java.lang.String&gt; object representing the      */
      /* portal preferred content types for the response if the content types are   */
      /* defined in the portlet descriptor"                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETRESPONSECONTENTTYPES1);
         if(headerRequest.getResponseContentTypes().hasMoreElements()){
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because empty enumeration is returned");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getLocale   */
      /* Details: "Method getLocale(): Returns an java.util.Locale object           */
      /* representing the preferred Locale for the response"                        */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALE);
         Locale lc = headerRequest.getLocale();
         if(lc!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Locale is - "+lc.toString());
         } else {
            result.appendTcDetail("Failed because Locale is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getLocales  */
      /* Details: "Method getLocales(): Returns an                                  */
      /* java.util.Enumeration&lt;java.util.Locale&gt; of the Locales in which the  */
      /* portal will accept content"                                                */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETLOCALES);
         if(headerRequest.getLocales().hasMoreElements()){
            result.setTcSuccess(true);
         } else {
            result.setTcDetail("Failed because the returned enumeration is empty");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getScheme   */
      /* Details: "Method getScheme(): Returns a String value representing the      */
      /* scheme name for the request"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSCHEME);
         String scheme=headerRequest.getScheme();
         if(scheme!=null) {
           result.setTcSuccess(true);
         } else {
           result.appendTcDetail("Failed because scheme is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getServerName */
      /* Details: "Method getServerName(): Returns a String value representing the  */
      /* host name for the request"                                                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERNAME);
         String servname=headerRequest.getServerName();
         if(servname!=null) {
            result.setTcSuccess(true);
         } else {
            result.appendTcDetail("Failed because ServerName is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getServerPort */
      /* Details: "Method getServerPort(): Returns an int value representing the    */
      /* port number for the request"                                               */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETSERVERPORT);
         try{
            int servport=headerRequest.getServerPort();
            result.appendTcDetail("Server Port is "+servport);
            result.setTcSuccess(true);
         } catch (Exception e){
            result.appendTcDetail(e.toString());
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getWindowID */
      /* Details: "Method getWindowID(): Returns a String value representing the    */
      /* portlet window ID"                                                         */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETWINDOWID);
         String windowId = headerRequest.getWindowID();
         if(windowId!=null){
            result.setTcSuccess(true);
            result.appendTcDetail("Window ID is - "+windowId);
         } else {
            result.appendTcDetail("Failed because window ID is null");
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getCookies1 */
      /* Details: "Method getCookies(): Returns a javax.servlet.http.Cookie[] array */
      /* containing the cookies for this request"                                   */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES1);
         if(headerRequest.getCookies()!=null){
            result.setTcSuccess(true);
         }
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getCookies2 */
      /* Details: "Method getCookies(): Returns null if no cookies are present"     */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETCOOKIES2);
         result.setTcSuccess(true);
         result.setTcDetail("Not possible to test as there will always be logged in user cookie");
         result.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap1 */
      /* Details: "Method getPrivateParameterMap(): Returns an                      */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the    */
      /* private parameter names and values if available"                           */
      if(renderParams.getValue("trPrivate1")!=null && renderParams.getValue("trPrivate1").equals("true")){
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP1);
         if (headerRequest.getParameterMap().containsKey("trPrivate1")
             && "true"
                 .equals(headerRequest.getParameterMap().get("trPrivate1")[0])) {
             result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPrivateParameterMap2 */
      /* Details: "Method getPrivateParameterMap(): The returned map is immutable"  */
      if(renderParams.getValue("trPrivate2")!=null && renderParams.getValue("trPrivate2").equals("true")){
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP2);
         if (headerRequest.getParameterMap().containsKey("trPrivate2")
             && "true"
                 .equals(headerRequest.getParameterMap().get("trPrivate2")[0])) {
           String trPrivate2[] = {"false"};
           try {
              headerRequest.getParameterMap().put("trPrivate2", trPrivate2);
              if ("true"
                  .equals(headerRequest.getParameterMap().get("trPrivate2")[0])) {
                 result.setTcSuccess(true);
              }
           } catch (UnsupportedOperationException e) {
              result.setTcSuccess(true);
           }
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPRIVATEPARAMETERMAP2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap1 */
      /* Details: "Method getPublicParameterMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object for the    */
      /* public parameter names and values if available"                            */
      if(renderParams.getValue("trPublic1")!=null && renderParams.getValue("trPublic1").equals("true") 
            && renderParams.isPublic("trPublic1")){
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP1);
         if (headerRequest.getPublicParameterMap().containsKey("trPublic1")
             && "true"
                 .equals(headerRequest.getPublicParameterMap().get("trPublic1")[0])) {
             result.setTcSuccess(true);
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP1, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_getPublicParameterMap2 */
      /* Details: "Method getPublicParameterMap(): The returned map is immutable"   */
      if(renderParams.getValue("trPublic2")!=null && renderParams.getValue("trPublic2").equals("true")){
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP2);
         if (headerRequest.getPublicParameterMap().containsKey("trPublic2")
             && "true"
                 .equals(headerRequest.getParameterMap().get("trPublic2")[0])) {
           String trPublic2[] = {"false"};
           try {
              headerRequest.getPublicParameterMap().put("trPublic2", trPublic2);
              if ("true"
                  .equals(
                      headerRequest.getPublicParameterMap().get("trPublic2")[0])) {
                 result.setTcSuccess(true);
              }
           }
           catch (UnsupportedOperationException e) {
              result.setTcSuccess(true);
           }
         }
         result.writeTo(writer);
      } else {
         ActionURL aurl = headerResponse.createActionURL();
         TestButton tb = new TestButton(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_GETPUBLICPARAMETERMAP2, aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V3HeaderPortletTests_SPEC14_PortletRequest_ApiHeader_exists      */
      /* Details: "The P3PUserInfos exists as a public static enum"                 */
      {
         TestResult result = tcd.getTestResultFailed(V3HEADERPORTLETTESTS_SPEC14_PORTLETREQUEST_APIHEADER_EXISTS);
         if(PortletRequest.P3PUserInfos.class.isEnum()) {
            result.setTcSuccess(true);
          } else {
            result.appendTcDetail("The P3PUserInfos Class is not an Enum ");;
          }
         result.writeTo(writer);
      }
      
      headerRequest.setAttribute(
            RESULT_ATTR_PREFIX + "HeaderPortletTests_SPEC14_PortletRequest_ApiHeader1",
            writer.toString());
      
   }

}
