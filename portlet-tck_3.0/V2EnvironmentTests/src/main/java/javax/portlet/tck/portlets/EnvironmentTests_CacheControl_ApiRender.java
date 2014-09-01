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
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.xml.namespace.QName;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet
 * will initiate the events, but not process them. The processing is done in the companion 
 * portlet EnvironmentTests_CacheControl_ApiRender_event
 *
 */
public class EnvironmentTests_CacheControl_ApiRender implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         EnvironmentTests_CacheControl_ApiRender.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
   
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
      LOGGER.entering(LOG_CLASS, "main portlet processAction entry");

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet serveResource entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getCacheControl().getClass());

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_getExpirationTime1 */
      /* Details: "Method getExpirationTime(): Returns the expiration time    */
      /* set through setExpirationTime"                                       */
      TestResult tr0 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_getExpirationTime2 */
      /* Details: "Method getExpirationTime(): Returns the default            */
      /* expiration time from the deployment descriptor if the expiration     */
      /* time has not been set"                                               */
      TestResult tr1 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_getExpirationTime3 */
      /* Details: "Method getExpirationTime(): Returns 0 if the expiration    */
      /* time has not been set and no default is set in the deployment        */
      /* descriptor"                                                          */
      TestResult tr2 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETEXPIRATIONTIME3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setExpirationTime1 */
      /* Details: "Method setExpirationTime(int): Sets the expiration time    */
      /* for the current response to the specified value"                     */
      TestResult tr3 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setExpirationTime2 */
      /* Details: "Method setExpirationTime(int): If the expiration value     */
      /* is set to 0, caching is disabled"                                    */
      TestResult tr4 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME2);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setExpirationTime3 */
      /* Details: "Method setExpirationTime(int): If the expiration value     */
      /* is set to -1, the cache does not expire"                             */
      TestResult tr5 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETEXPIRATIONTIME3);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_isPublicScope1   */
      /* Details: "Method isPublicScope(): Returns true if the caching        */
      /* scope has been set to public through the setPublicScope method"      */
      TestResult tr6 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_isPublicScope2   */
      /* Details: "Method isPublicScope(): Returns true if the caching        */
      /* scope default has not been set with the setPublicScope method, but   */
      /* has been set to public in the deployment descriptor "                */
      TestResult tr7 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_isPublicScope3   */
      /* Details: "Method isPublicScope(): Returns false if the caching       */
      /* scope has not been set with the setPublicScope method, but has       */
      /* been set to private through the setPublicScope method "              */
      TestResult tr8 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE3);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_isPublicScope5   */
      /* Details: "Method isPublicScope(): Returns false if the caching       */
      /* scope has not been set with the setPublicScope method and has not    */
      /* been set in the deployment descriptor"                               */
      TestResult tr9 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_ISPUBLICSCOPE5);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setPublicScope1  */
      /* Details: "Method setPublicScope(boolean): If the input parameter     */
      /* is true, the cache scope is set to public"                           */
      TestResult tr10 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETPUBLICSCOPE1);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setPublicScope2  */
      /* Details: "Method setPublicScope(boolean): If the input parameter     */
      /* is false, the cache scope is set to non-public"                      */
      TestResult tr11 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETPUBLICSCOPE2);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_getETag1         */
      /* Details: "Method getETag(): Returns a String containing the ETag     */
      /* for the current response"                                            */
      TestResult tr12 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETETAG1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_getETag2         */
      /* Details: "Method getETag(): Returns null if no ETag is set on the    */
      /* response"                                                            */
      TestResult tr13 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_GETETAG2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setETag1         */
      /* Details: "Method setETag(String): Sets an ETag for the current       */
      /* response"                                                            */
      TestResult tr14 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG1);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setETag2         */
      /* Details: "Method setETag(String): A previously-set ETag is           */
      /* overwritten"                                                         */
      TestResult tr15 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG2);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setETag3         */
      /* Details: "Method setETag(String): Removes the ETag if the input      */
      /* parameter is null"                                                   */
      TestResult tr16 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETETAG3);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_useCachedContent1 */
      /* Details: "Method useCachedContent(): Returns true if cached          */
      /* content has been set to valid through the setUseCachedContent        */
      /* method"                                                              */
      TestResult tr17 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT1);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_useCachedContent2 */
      /* Details: "Method useCachedContent(): Returns false if cached         */
      /* content has been set to invalid through the setUseCachedContent      */
      /* method"                                                              */
      TestResult tr18 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT2);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_useCachedContent3 */
      /* Details: "Method useCachedContent(): Returns false if the use        */
      /* cached content indcator has not been set"                            */
      TestResult tr19 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_USECACHEDCONTENT3);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setUseCachedContent1 */
      /* Details: "Method setUseCachedContent(boolean): If set to true, the   */
      /* cached content is valid "                                            */
      TestResult tr20 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETUSECACHEDCONTENT1);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiRender_setUseCachedContent2 */
      /* Details: "Method setUseCachedContent(boolean): If set to false,      */
      /* the cached content is invalid "                                      */
      TestResult tr21 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRENDER_SETUSECACHEDCONTENT2);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

   }

}
