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

import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTLENGTH;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTTYPE;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETPORTLETINPUTSTREAM;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREADER;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETCHARACTERENCODING;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETREQUEST;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETMETHOD;
import static javax.portlet.PortletSession.APPLICATION_SCOPE;
import static javax.portlet.tck.constants.Constants.RESULT_ATTR_PREFIX;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.ActionRequestWrapper;
import javax.portlet.tck.beans.ActionRequestWrapperChecker;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import javax.portlet.tck.beans.TestButton;
import javax.portlet.tck.beans.TestResult;
import javax.portlet.tck.constants.Constants;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case
 * names are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for
 * execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for
 * events, this portlet will initiate the events, but not process them. The
 * processing is done in the companion portlet
 * WrapperTests_ActionRequestWrapper_ApiAction_event
 *
 */
public class WrapperTests_ActionRequestWrapper_ApiAction implements Portlet {

   @Override
   public void init(PortletConfig config) throws PortletException {
   }

   @Override
   public void destroy() {
   }

   @Override
   public void processAction(ActionRequest portletReq,
         ActionResponse portletResp) throws PortletException, IOException {

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      ActionRequestWrapperChecker wc = new ActionRequestWrapperChecker(
            portletReq);
      ActionRequestWrapper wpr = new ActionRequestWrapper(portletReq);
      wpr.setRequest(wc);
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_getCharacterEncoding
       */
      /* Details: "Method getCharacterEncoding(): Calls wrapped method" */
      TestResult tr0 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCHARACTERENCODING);
      try {
         Object[] args = {};
         wc.prepare(tr0, "getCharacterEncoding", args);
         wc.checkRetval(wpr.getCharacterEncoding());
      } catch (Exception e) {
         tr0.appendTcDetail(e.toString());
      }
      tr0.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_getContentLength
       */
      /* Details: "Method getContentLength(): Calls wrapped method" */
      TestResult tr1 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTLENGTH);
      try {
         Object[] args = {};
         wc.prepare(tr1, "getContentLength", args);
         wc.checkRetval(wpr.getContentLength());
      } catch (Exception e) {
         tr1.appendTcDetail(e.toString());
      }
      tr1.writeTo(writer);

      /*
       * TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getContentType
       */
      /* Details: "Method getContentType(): Calls wrapped method" */
      TestResult tr2 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETCONTENTTYPE);
      try {
         Object[] args = {};
         wc.prepare(tr2, "getContentType", args);
         wc.checkRetval(wpr.getContentType());
      } catch (Exception e) {
         tr2.appendTcDetail(e.toString());
      }
      tr2.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_getPortletInputStream
       */
      /* Details: "Method getPortletInputStream(): Calls wrapped method" */
      TestResult tr3 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETPORTLETINPUTSTREAM);
      try {
         Object[] args = {};
         wc.prepare(tr3, "getPortletInputStream", args);
         wc.checkRetval(wpr.getPortletInputStream());
      } catch (Exception e) {
         tr3.appendTcDetail(e.toString());
      }
      tr3.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getReader */
      /* Details: "Method getReader(): Calls wrapped method" */
      TestResult tr4 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREADER);
      try {
         Object[] args = {};
         wc.prepare(tr4, "getReader", args);
         wc.checkRetval(wpr.getReader());
      } catch (Exception e) {
         tr4.appendTcDetail(e.toString());
      }
      tr4.writeTo(writer);

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_setCharacterEncoding
       */
      /* Details: "Method setCharacterEncoding(String): Calls wrapped */
      /* method" */
      TestResult tr5 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETCHARACTERENCODING);
      try {
         String parm1 = "val1";
         Object[] args = { parm1 };
         wc.prepare(tr5, "setCharacterEncoding", args);
         wpr.setCharacterEncoding(parm1);
      } catch (Exception e) {
         tr5.appendTcDetail(e.toString());
      }
      tr5.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getRequest */
      /* Details: "Method getRequest(): Returns wrapped ActionRequest */
      /* object" */
      TestResult tr6 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETREQUEST);
      try {
         // The retrieved request / response object should be the wrapper
         // checker instance
         ActionRequest r = wpr.getRequest();
         tr6.setTcSuccess(r == wc);
      } catch (Exception e) {
         tr6.appendTcDetail(e.toString());
      }
      tr6.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_setRequest */
      /* Details: "Method setRequest(ActionRequest): Allows wrapped */
      /* ActionRequest object to be set" */
      TestResult tr7 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_SETREQUEST);
      try {
         // tested by method set up
         tr7.setTcSuccess(true);
      } catch (Exception e) {
         tr7.appendTcDetail(e.toString());
      }
      tr7.writeTo(writer);

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getMethod */
      /* Details: "Method getMethod(): Calls wrapped method" */
      TestResult tr8 = tcd.getTestResultFailed(
            V2WRAPPERTESTS_ACTIONREQUESTWRAPPER_APIACTION_GETMETHOD);
      try {
         Object[] args = {};
         wc.prepare(tr8, "getMethod", args);
         wc.checkRetval(wpr.getMethod());
      } catch (Exception e) {
         tr8.appendTcDetail(e.toString());
      }
      tr8.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
            Constants.RESULT_ATTR_PREFIX
                  + "WrapperTests_ActionRequestWrapper_ApiAction",
            writer.toString(), APPLICATION_SCOPE);
   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      PortletSession ps = portletReq.getPortletSession();
      String msg = (String) ps.getAttribute(
            RESULT_ATTR_PREFIX + "WrapperTests_ActionRequestWrapper_ApiAction",
            APPLICATION_SCOPE);
      if (msg != null) {
         writer.write("<p>" + msg + "</p><br/>\n");
         ps.removeAttribute(
               RESULT_ATTR_PREFIX
                     + "WrapperTests_ActionRequestWrapper_ApiAction",
               APPLICATION_SCOPE);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_getCharacterEncoding
       */
      /* Details: "Method getCharacterEncoding(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_getCharacterEncoding",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_getContentLength
       */
      /* Details: "Method getContentLength(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_getContentLength",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getContentType
       */
      /* Details: "Method getContentType(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_getContentType",
               aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_getPortletInputStream
       */
      /* Details: "Method getPortletInputStream(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_getPortletInputStream",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getReader */
      /* Details: "Method getReader(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_getReader", aurl);
         tb.writeTo(writer);
      }

      /*
       * TestCase:
       * V2WrapperTests_ActionRequestWrapper_ApiAction_setCharacterEncoding
       */
      /* Details: "Method setCharacterEncoding(String): Calls wrapped */
      /* method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_setCharacterEncoding",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getRequest */
      /* Details: "Method getRequest(): Returns wrapped ActionRequest */
      /* object" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_getRequest",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_setRequest */
      /* Details: "Method setRequest(ActionRequest): Allows wrapped */
      /* ActionRequest object to be set" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_setRequest",
               aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2WrapperTests_ActionRequestWrapper_ApiAction_getMethod */
      /* Details: "Method getMethod(): Calls wrapped method" */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton(
               "V2WrapperTests_ActionRequestWrapper_ApiAction_getMethod", aurl);
         tb.writeTo(writer);
      }

   }

}
