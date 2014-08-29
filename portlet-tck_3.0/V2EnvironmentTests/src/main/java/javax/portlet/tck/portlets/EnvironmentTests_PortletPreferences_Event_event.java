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
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.PortletSession.*;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, 
 * but does not publish them. Events are published in the main portlet for the test cases. 
 */
public class EnvironmentTests_PortletPreferences_Event_event implements Portlet, EventPortlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         EnvironmentTests_PortletPreferences_Event_event.class.getName();
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
      LOGGER.entering(LOG_CLASS, "event companion processAction - ERROR!!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion serveResource - ERROR!!");
   }

   @Override
   public void processEvent(EventRequest portletReq, EventResponse portletResp)
         throws PortletException, IOException {
      LOGGER.entering(LOG_CLASS, "event companion processEvent");


      portletResp.setRenderParameters(portletReq);

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_isReadOnly1    */
      /* Details: "Method isReadOnly(): Returns true if the preference        */
      /* specified by the key is defined to be read-only in the deployment    */
      /* descriptor"                                                          */
      TestResult tr0 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_ISREADONLY1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_isReadOnly2    */
      /* Details: "Method isReadOnly(): Returns false if the preference       */
      /* specified by the key is not defined to be read-only in the           */
      /* deployment descriptor"                                               */
      TestResult tr1 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_ISREADONLY2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_isReadOnly3    */
      /* Details: "Method isReadOnly(): Returns false if the preference       */
      /* specified by the key is undefined"                                   */
      TestResult tr2 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_ISREADONLY3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_isReadOnly4    */
      /* Details: "Method isReadOnly(): Throws IllegalArgumentException if    */
      /* the key is null"                                                     */
      TestResult tr3 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_ISREADONLY4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValue1      */
      /* Details: "Method getValue(String, String): Returns the first         */
      /* String value for the specified key"                                  */
      TestResult tr4 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUE1);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValue2      */
      /* Details: "Method getValue(String, String): Returns the specified     */
      /* default value if there is no value for the specified key "           */
      TestResult tr5 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUE2);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValue3      */
      /* Details: "Method getValue(String, String): Returns the specified     */
      /* default value if the existing value for the specified key is null    */
      /* "                                                                    */
      TestResult tr6 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUE3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValue4      */
      /* Details: "Method getValue(String, String): Throws                    */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr7 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUE4);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValues1     */
      /* Details: "Method getValues(String, String[]): Returns the values     */
      /* String[] for the specified key"                                      */
      TestResult tr8 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUES1);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValues2     */
      /* Details: "Method getValues(String, String[]): Returns the            */
      /* specified default String[] if there is no Values for the specified   */
      /* key "                                                                */
      TestResult tr9 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUES2);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValues3     */
      /* Details: "Method getValues(String, String[]): Returns the            */
      /* specified default String[] if the existing String[] for the          */
      /* specified key is null "                                              */
      TestResult tr10 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUES3);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getValues4     */
      /* Details: "Method getValues(String, String[]): Throws                 */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr11 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETVALUES4);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValue1      */
      /* Details: "Method setValue(String, String): Sets the specified        */
      /* value for the specified key"                                         */
      TestResult tr12 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUE1);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValue2      */
      /* Details: "Method setValue(String, String): Any existing String or    */
      /* String[] value for the specified key is replaced"                    */
      TestResult tr13 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUE2);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValue3      */
      /* Details: "Method setValue(String, String): The value may be set to   */
      /* null"                                                                */
      TestResult tr14 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUE3);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValue4      */
      /* Details: "Method setValue(String, String): Throws                    */
      /* ReadOnlyException if the preference cannot be modified for this      */
      /* request"                                                             */
      TestResult tr15 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUE4);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValue5      */
      /* Details: "Method setValue(String, String): Throws                    */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr16 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUE5);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValues1     */
      /* Details: "Method setValues(String, String[]): Sets the specified     */
      /* value array for the specified key"                                   */
      TestResult tr17 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUES1);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValues2     */
      /* Details: "Method setValues(String, String[]): Any existing String    */
      /* or String[] Values for the specified key is replaced"                */
      TestResult tr18 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUES2);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValues3     */
      /* Details: "Method setValues(String, String[]): The value array may    */
      /* be set to null"                                                      */
      TestResult tr19 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUES3);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValues4     */
      /* Details: "Method setValues(String, String[]): The value array may    */
      /* contain null members"                                                */
      TestResult tr20 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUES4);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValues5     */
      /* Details: "Method setValues(String, String[]): Throws                 */
      /* ReadOnlyException if the preference cannot be modified for this      */
      /* request"                                                             */
      TestResult tr21 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUES5);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_setValues6     */
      /* Details: "Method setValues(String, String[]): Throws                 */
      /* IllegalArgumentException if the key is null"                         */
      TestResult tr22 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_SETVALUES6);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getNames1      */
      /* Details: "Method getNames(): Returns an                              */
      /* java.util.Enumeration&lt;java.lang.String&gt; containing the         */
      /* available preference keys"                                           */
      TestResult tr23 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETNAMES1);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getNames2      */
      /* Details: "Method getNames(): Returns an empty Enumeration if no      */
      /* preference keys are available"                                       */
      TestResult tr24 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETNAMES2);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getMap1        */
      /* Details: "Method getMap(): Returns an                                */
      /* java.util.Map&lt;java.lang.String&gt; containing the available       */
      /* preferences"                                                         */
      TestResult tr25 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETMAP1);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_getMap2        */
      /* Details: "Method getMap(): Returns an empty Map if no preferences    */
      /* are available"                                                       */
      TestResult tr26 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_GETMAP2);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_reset1         */
      /* Details: "Method reset(): Removes the value associated with the      */
      /* specified key"                                                       */
      TestResult tr27 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_RESET1);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_reset2         */
      /* Details: "Method reset(): Throws ReadOnlyException if the            */
      /* preference cannot be modified for this request"                      */
      TestResult tr28 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_RESET2);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_reset3         */
      /* Details: "Method reset(): Throws IllegalArgumentException if the     */
      /* key is null"                                                         */
      TestResult tr29 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_RESET3);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_store1         */
      /* Details: "Method store(): Commits changes made to the preferences    */
      /* to the persistent store "                                            */
      TestResult tr30 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_STORE1);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_store2         */
      /* Details: "Method store(): If the store(): method is not called,      */
      /* changes made are discarded"                                          */
      TestResult tr31 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_STORE2);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_store3         */
      /* Details: "Method store(): If a validator is defined, it is called    */
      /* before the actual store is performed"                                */
      TestResult tr32 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_STORE3);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_store4         */
      /* Details: "Method store(): If validation fails, the store is not      */
      /* performed"                                                           */
      TestResult tr33 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_STORE4);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_store5         */
      /* Details: "Method store(): Throws IllegalStateException if store():   */
      /* is called in the render method  "                                    */
      TestResult tr34 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_STORE5);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2EnvironmentTests_PortletPreferences_Event_store6         */
      /* Details: "Method store(): Throws ValidatorException if the           */
      /* validation performed by the associated validator fails "             */
      TestResult tr35 = tcd.getTestResultFailed(V2ENVIRONMENTTESTS_PORTLETPREFERENCES_EVENT_STORE6);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "EnvironmentTests_PortletPreferences_Event",
                   writer.toString(), APPLICATION_SCOPE);

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {
      
      LOGGER.entering(LOG_CLASS, "event companion render");

      portletResp.setContentType("text/html");
      PrintWriter writer = portletResp.getWriter();
      writer.write("<h3>Event Companion Portlet </h3>\n");
      writer.write("<p>EnvironmentTests_PortletPreferences_Event_event</p>\n");

      String msg = (String) portletReq.getPortletSession()
            .getAttribute(RESULT_ATTR_PREFIX + "EnvironmentTests_PortletPreferences_Event", APPLICATION_SCOPE);
      msg = (msg==null) ? "Not ready. click test case link." : msg;
      writer.write("<p>" + msg + "</p>\n");

   }

}
