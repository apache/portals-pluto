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
 * portlet EnvironmentTests_PortletPreferences_ApiResource_event
 *
 */
public class EnvironmentTests_PortletPreferences_ApiResource implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         EnvironmentTests_PortletPreferences_ApiResource.class.getName();
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

      ClassChecker cc = new ClassChecker(portletReq.getPreferences().getClass());

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly1 */
      /* Details: "Method isReadOnly(String): Returns true if the             */
      /* preference specified by the key is defined to be read-only in the    */
      /* deployment descriptor"                                               */
      TestResult tr0 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly2 */
      /* Details: "Method isReadOnly(String): Returns false if the            */
      /* preference specified by the key is not defined to be read-only in    */
      /* the deployment descriptor"                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly3 */
      /* Details: "Method isReadOnly(String): Returns false if the            */
      /* preference specified by the key is undefined"                        */
      TestResult tr2 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_isReadOnly4 */
      /* Details: "Method isReadOnly(String): Throws                          */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr3 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_ISREADONLY4);
      try {
         try {
            PortletPreferences prefs = portletReq.getPreferences();
            prefs.isReadOnly(null);
            tr3.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr3.setTcSuccess(true);
         } catch (Exception e) {
            tr3.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue1 */
      /* Details: "Method getValue(String, String): Returns the first         */
      /* String value for the specified key"                                  */
      TestResult tr4 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE1);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue2 */
      /* Details: "Method getValue(String, String): Returns the specified     */
      /* default value if there is no value for the specified key "           */
      TestResult tr5 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE2);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue3 */
      /* Details: "Method getValue(String, String): Returns the specified     */
      /* default value if the existing value for the specified key is null    */
      /* "                                                                    */
      TestResult tr6 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValue4 */
      /* Details: "Method getValue(String, String): Throws                    */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr7 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUE4);
      try {
         try {
            PortletPreferences prefs = portletReq.getPreferences();
            tr7.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr7.setTcSuccess(true);
         } catch (Exception e) {
            tr7.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues1 */
      /* Details: "Method getValues(String, String[]): Returns the values     */
      /* String[] for the specified key"                                      */
      TestResult tr8 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues2 */
      /* Details: "Method getValues(String, String[]): Returns the            */
      /* specified default String[] if there is no Values for the specified   */
      /* key "                                                                */
      TestResult tr9 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES2);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues3 */
      /* Details: "Method getValues(String, String[]): Returns the            */
      /* specified default String[] if the existing String[] for the          */
      /* specified key is null "                                              */
      TestResult tr10 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES3);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getValues4 */
      /* Details: "Method getValues(String, String[]): Throws                 */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr11 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETVALUES4);
      try {
         try {
            PortletPreferences prefs = portletReq.getPreferences();
            String[] vals = prefs.getValues(null, new String[]{"val1-1", "val1-2"});
            tr11.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr11.setTcSuccess(true);
         } catch (Exception e) {
            tr11.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue1 */
      /* Details: "Method setValue(String, String): Sets the specified        */
      /* value for the specified key"                                         */
      TestResult tr12 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue2 */
      /* Details: "Method setValue(String, String): Any existing String or    */
      /* String[] value for the specified key is replaced"                    */
      TestResult tr13 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue3 */
      /* Details: "Method setValue(String, String): The value may be set to   */
      /* null"                                                                */
      TestResult tr14 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE3);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue4 */
      /* Details: "Method setValue(String, String): Throws                    */
      /* ReadOnlyException if the preference cannot be modified for this      */
      /* request"                                                             */
      TestResult tr15 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE4);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValue5 */
      /* Details: "Method setValue(String, String): Throws                    */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr16 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUE5);
      try {
         try {
            PortletPreferences prefs = portletReq.getPreferences();
            prefs.setValue(null, "value");
            tr16.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr16.setTcSuccess(true);
         } catch (Exception e) {
            tr16.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues1 */
      /* Details: "Method setValues(String, String[]): Sets the specified     */
      /* value array for the specified key"                                   */
      TestResult tr17 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES1);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues2 */
      /* Details: "Method setValues(String, String[]): Any existing String    */
      /* or String[] Values for the specified key is replaced"                */
      TestResult tr18 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES2);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues3 */
      /* Details: "Method setValues(String, String[]): The value array may    */
      /* be set to null"                                                      */
      TestResult tr19 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES3);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues4 */
      /* Details: "Method setValues(String, String[]): The value array may    */
      /* contain null members"                                                */
      TestResult tr20 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES4);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues5 */
      /* Details: "Method setValues(String, String[]): Throws                 */
      /* ReadOnlyException if the preference cannot be modified for this      */
      /* request"                                                             */
      TestResult tr21 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES5);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_setValues6 */
      /* Details: "Method setValues(String, String[]): Throws                 */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr22 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_SETVALUES6);
      try {
         try {
            PortletPreferences prefs = portletReq.getPreferences();
            prefs.setValues(null, new String[]{"val1-1", "val1-2"});
            tr22.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr22.setTcSuccess(true);
         } catch (Exception e) {
            tr22.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr22.appendTcDetail(e.toString());}
      tr22.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getNames1 */
      /* Details: "Method getNames(): Returns an                              */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the         */
      /* available preference keys"                                           */
      TestResult tr23 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES1);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getNames2 */
      /* Details: "Method getNames(): Returns an empty Enumeration if no      */
      /* preference keys are available"                                       */
      TestResult tr24 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETNAMES2);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getMap1  */
      /* Details: "Method getMap(): Returns an                                */
      /* java.util.Map&lt;java.lang.String&gt; containing the available       */
      /* preferences"                                                         */
      TestResult tr25 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP1);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_getMap2  */
      /* Details: "Method getMap(): Returns an empty Map if no preferences    */
      /* are available"                                                       */
      TestResult tr26 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_GETMAP2);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_reset1   */
      /* Details: "Method reset(String): Removes the value associated with    */
      /* the specified key"                                                   */
      TestResult tr27 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET1);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_reset2   */
      /* Details: "Method reset(String): Throws ReadOnlyException if the      */
      /* preference cannot be modified for this request"                      */
      TestResult tr28 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET2);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_reset3   */
      /* Details: "Method reset(String): Throws IllegalArgumentException if   */
      /* the key is null"                                                     */
      TestResult tr29 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_RESET3);
      try {
         try {
            PortletPreferences prefs = portletReq.getPreferences();
            prefs.reset(null);
            tr29.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr29.setTcSuccess(true);
         } catch (Exception e) {
            tr29.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store1   */
      /* Details: "Method store(): Commits changes made to the preferences    */
      /* to the persistent store "                                            */
      TestResult tr30 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE1);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store2   */
      /* Details: "Method store(): If the store(): method is not called,      */
      /* changes made are discarded"                                          */
      TestResult tr31 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE2);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store3   */
      /* Details: "Method store(): If a validator is defined, it is called    */
      /* before the actual store is performed"                                */
      TestResult tr32 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE3);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store4   */
      /* Details: "Method store(): If validation fails, the store is not      */
      /* performed"                                                           */
      TestResult tr33 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE4);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store5   */
      /* Details: "Method store(): Throws IllegalStateException if store():   */
      /* is called in the render method  "                                    */
      TestResult tr34 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE5);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_ApiResource_store6   */
      /* Details: "Method store(): Throws ValidatorException if the           */
      /* validation performed by the associated validator fails "             */
      TestResult tr35 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_APIRESOURCE_STORE6);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "main portlet render entry");

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      writer.write("<div id=\"EnvironmentTests_PortletPreferences_ApiResource\">no resource output.</div>\n");
      ResourceURL resurl = portletResp.createResourceURL();
      resurl.setCacheability(PAGE);
      writer.write("<script>\n");
      writer.write("(function () {\n");
      writer.write("   var xhr = new XMLHttpRequest();\n");
      writer.write("   xhr.onreadystatechange=function() {\n");
      writer.write("      if (xhr.readyState==4 && xhr.status==200) {\n");
      writer.write("         document.getElementById(\"EnvironmentTests_PortletPreferences_ApiResource\").innerHTML=xhr.responseText;\n");
      writer.write("      }\n");
      writer.write("   };\n");
      writer.write("   xhr.open(\"GET\",\"" + resurl.toString() + "\",true);\n");
      writer.write("   xhr.send();\n");
      writer.write("})();\n");
      writer.write("</script>\n");
   }

}
