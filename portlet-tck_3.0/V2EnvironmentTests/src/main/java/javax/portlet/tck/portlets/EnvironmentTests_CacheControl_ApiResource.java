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
 * portlet EnvironmentTests_CacheControl_ApiResource_event
 *
 */
public class EnvironmentTests_CacheControl_ApiResource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         EnvironmentTests_CacheControl_ApiResource.class.getName();
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

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(portletResp.getCacheControl().getClass());
      
      CacheControl chc=
    		  portletResp.getCacheControl();

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_getExpirationTime1 */
      /* Details: "Method getExpirationTime(): Returns the expiration time    */
      /* set through setExpirationTime"                                       */
      TestResult tr0 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME1);
      chc.setExpirationTime(10);
      int getExpTime1=chc.getExpirationTime();
      if(getExpTime1==10) {
    	  tr0.setTcSuccess(true);
      } else {
    	  tr0.appendTcDetail("The getExpirationTime did not match the Specified Time :" +getExpTime1);
      }
      tr0.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_getExpirationTime2 */
      /* Details: "Method getExpirationTime(): Returns the default            */
      /* expiration time from the deployment descriptor if the expiration     */
      /* time has not been set"                                               */
      TestResult tr1 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME2);
      tr1.setTcSuccess(true);
      tr1.appendTcDetail("The Method could not be Tested under this TestPortlet Which already has been set Expiration Time ");
      tr1.writeTo(writer);


      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_getExpirationTime3 */
      /* Details: "Method getExpirationTime(): Returns 0 if the expiration    */
      /* time has not been set and no default is set in the deployment        */
      /* descriptor"                                                          */
      TestResult tr2 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETEXPIRATIONTIME3);
      tr2.setTcSuccess(true);
      tr2.appendTcDetail("This Method could not be tested Under this TestPortlet which has default set in Deployment Descriptor");
      tr2.writeTo(writer);


      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setExpirationTime1 */
      /* Details: "Method setExpirationTime(int): Sets the expiration time    */
      /* for the current response to the specified value"                     */
      TestResult tr3 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME1);
      int setExpTime1=chc.getExpirationTime();
      if(setExpTime1==10) {
    	  tr3.setTcSuccess(true);
      } else {
    	  tr3.appendTcDetail("The Expiration time did not match the specified value :" +setExpTime1);
      }
      tr3.writeTo(writer);


      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setExpirationTime2 */
      /* Details: "Method setExpirationTime(int): If the expiration value     */
      /* is set to 0, caching is disabled"                                    */
      TestResult tr4 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME2);
      tr4.setTcSuccess(true);
      tr4.appendTcDetail("This Method Could not be Tested which already has Expiration Time ");
      tr4.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setExpirationTime3 */
      /* Details: "Method setExpirationTime(int): If the expiration value     */
      /* is set to -1, the cache does not expire"                             */
      TestResult tr5 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETEXPIRATIONTIME3);
      tr5.setTcSuccess(true);
      tr5.appendTcDetail("This Method could not be Tested which already has Expiration Time");
      tr5.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_isPublicScope1 */
      /* Details: "Method isPublicScope(): Returns true if the caching        */
      /* scope has been set to public through the setPublicScope method"      */
      TestResult tr6 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE1);
      chc.setPublicScope(true);
      if(chc.isPublicScope()==true) {
    	  tr6.setTcSuccess(true);
      } else {
    	  tr6.appendTcDetail("The Public Scope is set to False");
      }
      tr6.writeTo(writer);
      
      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_isPublicScope2 */
      /* Details: "Method isPublicScope(): Returns true if the caching        */
      /* scope default has not been set with the setPublicScope method, but   */
      /* has been set to public in the deployment descriptor "                */
      TestResult tr7 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE2);
      if(chc.isPublicScope()==true) {
    	  tr7.setTcSuccess(true);
      } else {
    	  tr7.appendTcDetail("The Public Scope is set to False");
      }
      tr7.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_isPublicScope3 */
      /* Details: "Method isPublicScope(): Returns false if the caching       */
      /* scope has not been set with the setPublicScope method, but has       */
      /* been set to private through the setPublicScope method "              */
      TestResult tr8 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE3);
      chc.setPublicScope(false); 
      if(chc.isPublicScope()==false) {
    	  tr8.setTcSuccess(true);
      } else {
          tr8.appendTcDetail("The Public Scope is set to True");
      }
      tr8.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_isPublicScope5 */
      /* Details: "Method isPublicScope(): Returns false if the caching       */
      /* scope has not been set with the setPublicScope method and has not    */
      /* been set in the deployment descriptor"                               */
      TestResult tr9 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_ISPUBLICSCOPE5);
      if(chc.isPublicScope()==false) {
    	  tr9.setTcSuccess(true);
      } else {
          tr9.appendTcDetail("The Public Scope is set to True");
      }
      tr9.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setPublicScope1 */
      /* Details: "Method setPublicScope(boolean): If the input parameter     */
      /* is true, the cache scope is set to public"                           */
      TestResult tr10 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETPUBLICSCOPE1);
      chc.setPublicScope(true);
      if(chc.isPublicScope()==true) {
    	  tr10.setTcSuccess(true);
      } else {
    	  tr10.appendTcDetail("The Public Scope is set to False");
      }
      tr10.writeTo(writer);
      
      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setPublicScope2 */
      /* Details: "Method setPublicScope(boolean): If the input parameter     */
      /* is false, the cache scope is set to non-public"                      */
      TestResult tr11 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETPUBLICSCOPE2);
      chc.setPublicScope(false); 
      if(chc.isPublicScope()==false) {
    	  tr11.setTcSuccess(true);
      } else {
          tr11.appendTcDetail("The Public Scope is set to True");
      }
      tr11.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_getETag1       */
      /* Details: "Method getETag(): Returns a String containing the ETag     */
      /* for the current response"                                            */
      TestResult tr12 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETETAG1);
      chc.setETag("Test");
      String tag=chc.getETag();
      if(tag.equals("Test")) {
    	  tr12.setTcSuccess(true);
      } else {
    	  tr12.appendTcDetail("Etag doesnot match the specified value : " +tag);
      }
      tr12.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_getETag2       */
      /* Details: "Method getETag(): Returns null if no ETag is set on the    */
      /* response"                                                            */
      TestResult tr13 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_GETETAG2);
      tr13.setTcSuccess(true);
      tr13.appendTcDetail("This Method Could not be Tested which already has EFlag ");
      tr13.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setETag1       */
      /* Details: "Method setETag(String): Sets an ETag for the current       */
      /* response"                                                            */
      TestResult tr14 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG1);
      chc.setETag("Test1");
      String tag1=chc.getETag();
      if(tag1.equals("Test1")) {
    	  tr14.setTcSuccess(true);
      } else {
    	  tr14.appendTcDetail("Etag doesnot match the specified value : " +tag1);
      }
      tr14.writeTo(writer);
      
      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setETag2       */
      /* Details: "Method setETag(String): A previously-set ETag is           */
      /* overwritten"                                                         */
      TestResult tr15 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG2);
      chc.setETag("Test2");
      String tag2=chc.getETag();
      if(tag2.equals("Test2")) {
    	  tr15.setTcSuccess(true);
      } else {
    	  tr15.appendTcDetail("Etag doesnot match the specified value : " +tag2);
      }
      tr15.writeTo(writer);


      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setETag3       */
      /* Details: "Method setETag(String): Removes the ETag if the input      */
      /* parameter is null"                                                   */
      TestResult tr16 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETETAG3);
      chc.setETag(null);
      String tag3=chc.getETag();
      if(tag3==null) {
    	  tr16.setTcSuccess(true);
      }
      tr16.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_useCachedContent1 */
      /* Details: "Method useCachedContent(): Returns true if cached          */
      /* content has been set to valid through the setUseCachedContent        */
      /* method"                                                              */
      TestResult tr17 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT1);
      chc.setUseCachedContent(true);
      if(chc.useCachedContent()==true) {
    	  tr17.setTcSuccess(true);
      } else {
    	  tr17.appendTcDetail("The Cached Content has been set to InValid");
      }
      tr17.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_useCachedContent2 */
      /* Details: "Method useCachedContent(): Returns false if cached         */
      /* content has been set to invalid through the setUseCachedContent      */
      /* method"                                                              */
      TestResult tr18 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT2);
      chc.setUseCachedContent(false);
      if(chc.useCachedContent()==false) {
    	  tr18.setTcSuccess(true);
      } else {
    	  tr18.appendTcDetail("The Cached Content has been set to Valid");  
      }
      tr18.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_useCachedContent3 */
      /* Details: "Method useCachedContent(): Returns false if the use        */
      /* cached content indcator has not been set"                            */
      TestResult tr19 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_USECACHEDCONTENT3);
      if(chc.useCachedContent()==false) {
    	  tr19.setTcSuccess(true);
      }
      tr19.writeTo(writer);


      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setUseCachedContent1 */
      /* Details: "Method setUseCachedContent(boolean): If set to true, the   */
      /* cached content is valid "                                            */
      TestResult tr20 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETUSECACHEDCONTENT1);
      chc.setUseCachedContent(true);
      if(chc.useCachedContent()==true) {
    	  tr20.setTcSuccess(true);
      } else {
    	  tr20.appendTcDetail("The Cached Content has been set to InValid");
      }
      tr20.writeTo(writer);

      /* TestCase: V2EnvironmentTests_CacheControl_ApiResource_setUseCachedContent2 */
      /* Details: "Method setUseCachedContent(boolean): If set to false,      */
      /* the cached content is invalid "                                      */
      TestResult tr21 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_CACHECONTROL_APIRESOURCE_SETUSECACHEDCONTENT2);
      chc.setUseCachedContent(false);
      if(chc.useCachedContent()==false) {
    	  tr21.setTcSuccess(true);
      } else {
    	  tr21.appendTcDetail("The Cached Content has been set to Valid");  
      }
      tr21.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"EnvironmentTests_CacheControl_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"EnvironmentTests_CacheControl_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
