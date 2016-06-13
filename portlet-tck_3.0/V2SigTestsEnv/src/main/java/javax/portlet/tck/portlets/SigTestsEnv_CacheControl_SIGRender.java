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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAG;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAGRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPE;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENTRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENTRETURNS;
import static javax.portlet.tck.constants.Constants.THREADID_ATTR;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet SigTestsEnv_CacheControl_SIGRender_event
 *
 */
public class SigTestsEnv_CacheControl_SIGRender implements Portlet {

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

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getCacheControl().getClass());

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasGetETag            */
      /* Details: "CacheControl has a getETag()  method "                     */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAG);
      try {
         String name = "getETag";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasGetETagReturns     */
      /* Details: "CacheControl method getETag() returns String "             */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETETAGRETURNS);
      try {
         String name = "getETag";
         Class<?> retType = String.class;
         Class<?>[] parms = null;
         tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasGetExpirationTime  */
      /* Details: "CacheControl has a getExpirationTime()  method "           */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIME);
      try {
         String name = "getExpirationTime";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasGetExpirationTimeReturns */
      /* Details: "CacheControl method getExpirationTime() returns int "      */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASGETEXPIRATIONTIMERETURNS);
      try {
         String name = "getExpirationTime";
         Class<?> retType = int.class;
         Class<?>[] parms = null;
         tr3.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasIsPublicScope      */
      /* Details: "CacheControl has a isPublicScope()  method "               */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPE);
      try {
         String name = "isPublicScope";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr4.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasIsPublicScopeReturns */
      /* Details: "CacheControl method isPublicScope() returns boolean "      */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASISPUBLICSCOPERETURNS);
      try {
         String name = "isPublicScope";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetETag            */
      /* Details: "CacheControl has a setETag(String)  method "               */
      TestResult tr6 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAG);
      try {
         String name = "setETag";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {String.class};
         tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetETagReturns     */
      /* Details: "CacheControl method setETag(String) returns void "         */
      TestResult tr7 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETETAGRETURNS);
      try {
         String name = "setETag";
         Class<?> retType = void.class;
         Class<?>[] parms = {String.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetExpirationTime  */
      /* Details: "CacheControl has a setExpirationTime(int)  method "        */
      TestResult tr8 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIME);
      try {
         String name = "setExpirationTime";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {int.class};
         tr8.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetExpirationTimeReturns */
      /* Details: "CacheControl method setExpirationTime(int) returns void    */
      /* "                                                                    */
      TestResult tr9 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETEXPIRATIONTIMERETURNS);
      try {
         String name = "setExpirationTime";
         Class<?> retType = void.class;
         Class<?>[] parms = {int.class};
         tr9.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetPublicScope     */
      /* Details: "CacheControl has a setPublicScope(boolean)  method "       */
      TestResult tr10 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPE);
      try {
         String name = "setPublicScope";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {boolean.class};
         tr10.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetPublicScopeReturns */
      /* Details: "CacheControl method setPublicScope(boolean) returns void   */
      /* "                                                                    */
      TestResult tr11 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETPUBLICSCOPERETURNS);
      try {
         String name = "setPublicScope";
         Class<?> retType = void.class;
         Class<?>[] parms = {boolean.class};
         tr11.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetUseCachedContent */
      /* Details: "CacheControl has a setUseCachedContent(boolean)  method    */
      /* "                                                                    */
      TestResult tr12 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENT);
      try {
         String name = "setUseCachedContent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = {boolean.class};
         tr12.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasSetUseCachedContentReturns */
      /* Details: "CacheControl method setUseCachedContent(boolean) returns   */
      /* void "                                                               */
      TestResult tr13 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASSETUSECACHEDCONTENTRETURNS);
      try {
         String name = "setUseCachedContent";
         Class<?> retType = void.class;
         Class<?>[] parms = {boolean.class};
         tr13.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasUseCachedContent   */
      /* Details: "CacheControl has a useCachedContent()  method "            */
      TestResult tr14 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENT);
      try {
         String name = "useCachedContent";
         Class<?>[] exceptions = null;
         Class<?>[] parms = null;
         tr14.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2SigTestsEnv_CacheControl_SIGRender_hasUseCachedContentReturns */
      /* Details: "CacheControl method useCachedContent() returns boolean "   */
      TestResult tr15 = tcd.getTestResultFailed(V2SIGTESTSENV_CACHECONTROL_SIGRENDER_HASUSECACHEDCONTENTRETURNS);
      try {
         String name = "useCachedContent";
         Class<?> retType = boolean.class;
         Class<?>[] parms = null;
         tr15.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

   }

}
