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
 * portlet URLTests_BaseURL_ApiRenderResurl_event
 *
 */
public class URLTests_BaseURL_ApiRenderResurl implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         URLTests_BaseURL_ApiRenderResurl.class.getName();
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

      ResourceURL url = portletResp.createResourceURL();
      ClassChecker cc = new ClassChecker(url.getClass());

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA1          */
      /* Details: "Method setParameter(String, String): Sets the parameter    */
      /* value for the specified name"                                        */
      TestResult tr0 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterA1");
         turl.setParameter("parm1", "val1");
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA5          */
      /* Details: "Method setParameter(String, String): A resource            */
      /* parameter can be set"                                                */
      TestResult tr1 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA5);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterA5");
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA6          */
      /* Details: "Method setParameter(String, String): All previously        */
      /* existing values for the specified key are removed"                   */
      TestResult tr2 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterA6");
         turl.setParameter("parm1", "oldVal");
         turl.setParameter("parm1", "newVal");
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA7          */
      /* Details: "Method setParameter(String, String): If the value is       */
      /* null, all values for the specified key are removed"                  */
      TestResult tr3 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA7);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterA7");
         turl.setParameter("parm1", "val1");
         turl.setParameter("parm1", (String)null);
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterA8          */
      /* Details: "Method setParameter(String, String): Throws                */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr4 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERA8);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            turl.setParameter(null, "value");
            tr4.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr4.setTcSuccess(true);
         } catch (Exception e) {
            tr4.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB1          */
      /* Details: "Method setParameter(String, String[]): Sets the            */
      /* parameter value array for the specified name"                        */
      TestResult tr5 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterB1");
         turl.setParameter("parm1", new String[]{"val1", "val2"});
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB5          */
      /* Details: "Method setParameter(String, String[]): A resource          */
      /* parameter can be set"                                                */
      TestResult tr6 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB5);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterB5");
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB6          */
      /* Details: "Method setParameter(String, String[]): All previously      */
      /* existing values for the specified key are removed"                   */
      TestResult tr7 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterB6");
         turl.setParameter("parm1", new String[]{"val1", "val2", "val3"});
         turl.setParameter("parm1", new String[]{"newVal"});
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB7          */
      /* Details: "Method setParameter(String, String[]): If the value is     */
      /* null, all values for the specified key are removed"                  */
      TestResult tr8 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB7);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         turl.setParameter("tc", "V2URLTests_BaseURL_ApiRenderResurl_setParameterB7");
         turl.setParameter("parm1", new String[]{"val1", "val2", "val3"});
         turl.setParameter("parm1", (String[])null);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameterB8          */
      /* Details: "Method setParameter(String, String[]): Throws              */
      /* IllegalArgumentException if the name is null"                        */
      TestResult tr9 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERB8);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            turl.setParameter(null, new String[]{"val1-1", "val1-2"});
            tr9.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr9.setTcSuccess(true);
         } catch (Exception e) {
            tr9.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters1          */
      /* Details: "Method setParameters(java.util.Map): Sets the parameter    */
      /* map to the specified value"                                          */
      TestResult tr10 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderResurl_setParameters1"});
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters5          */
      /* Details: "Method setParameters(java.util.Map): Resource parameters   */
      /* can be set through the map"                                          */
      TestResult tr11 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS5);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderResurl_setParameters5"});
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters6          */
      /* Details: "Method setParameters(java.util.Map): Previously existing   */
      /* private parameters not contained in the specified input map are      */
      /* removed"                                                             */
      TestResult tr12 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderResurl_setParameters6"});
         turl.setParameter("parm1", "oldVal");
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters7          */
      /* Details: "Method setParameters(java.util.Map): Previously existing   */
      /* public parameters not contained in the specified input map remain    */
      /* unchanged"                                                           */
      TestResult tr13 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS7);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderResurl_setParameters7"});
         turl.setParameter("parm1", "oldVal");
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters8          */
      /* Details: "Method setParameters(java.util.Map): Parameters that are   */
      /* set are available in requests initiated through the URL"             */
      TestResult tr14 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS8);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = new HashMap<String, String[]>();
         parms.put("tc", new String[]{"V2URLTests_BaseURL_ApiRenderResurl_setParameters8"});
         parms.put("parm1", new String[]{"val1", "val2"});
         turl.setParameters(parms);
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters9          */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if the input map is null"                   */
      TestResult tr15 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS9);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            turl.setParameters((Map<String, String[]>)null);
            tr15.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr15.setTcSuccess(true);
         } catch (Exception e) {
            tr15.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters10         */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if any key in the map is null"              */
      TestResult tr16 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS10);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            tr16.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr16.setTcSuccess(true);
         } catch (Exception e) {
            tr16.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters12         */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if the values array for any key is null "   */
      TestResult tr17 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS12);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            tr17.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr17.setTcSuccess(true);
         } catch (Exception e) {
            tr17.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setParameters13         */
      /* Details: "Method setParameters(java.util.Map): Throws                */
      /* IllegalArgumentException if any element in any values array is       */
      /* null "                                                               */
      TestResult tr18 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPARAMETERS13);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            tr18.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr18.setTcSuccess(true);
         } catch (Exception e) {
            tr18.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setSecure2              */
      /* Details: "Method setSecure(boolean): If the input parameter is       */
      /* true, the resulting URL uses a secure connection (HTTPS)"            */
      TestResult tr19 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETSECURE2);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_toString                */
      /* Details: "Method toString(): Returns a String containing the         */
      /* portlet URL representation to be included in the markup"             */
      TestResult tr20 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_TOSTRING);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap1        */
      /* Details: "Method getParameterMap(): Returns an                       */
      /* java.util.Map&lt;java.lang.String,java.lang.String[]&gt; object      */
      /* for the parameter names and values if parameters are available"      */
      TestResult tr21 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP1);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr21.appendTcDetail("Returned map is null."); 
         } else {
            tr21.setTcSuccess(true);
         }
      } catch(Exception e) {tr21.appendTcDetail(e.toString());}
      tr21.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap4        */
      /* Details: "Method getParameterMap(): The returned map contains all    */
      /* resource parameters for the request"                                 */
      TestResult tr22 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP4);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> testparms = new HashMap<String, String[]>();
         turl.setParameter("parm1", "val1");
         testparms.put("parm1", new String[]{"val1"});
         turl.setParameter("tckPRP1", "PRPval1");
         testparms.put("tckPRP1", new String[]{"PRPval1"});
         Map<String, String[]> parms = turl.getParameterMap();
         CompareUtils.mapsEqual("Test parameters", testparms, "Parameters from URL", parms, tr22);
      } catch(Exception e) {tr22.appendTcDetail(e.toString());}
      tr22.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap5        */
      /* Details: "Method getParameterMap(): The returned map does not        */
      /* contain any render parameters for the request"                       */
      TestResult tr23 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP5);
      try {
         // set render parameter for test. The driver will click the link before collecting results.
         PortletURL rurl = portletResp.createRenderURL();
         rurl.setParameter(PARM_NAME, PARM_VALUE);
         TestLink tl = new TestLink("V2URLTests_BaseURL_ApiRenderResurl_getParameterMap5", rurl);
         tl.writeTo(writer);
         
         // Test result only valid after link has been clicked.
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr23.appendTcDetail("Returned map is null."); 
         } else {
            tr23.setTcSuccess(parms.isEmpty());
         }
      } catch(Exception e) {tr23.appendTcDetail(e.toString());}
      tr23.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_getParameterMap6        */
      /* Details: "Method getParameterMap(): Returns an empty map if no       */
      /* parameters exist"                                                    */
      TestResult tr24 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_GETPARAMETERMAP6);
      try {
         ResourceURL turl = portletResp.createResourceURL();
         Map<String, String[]> parms = turl.getParameterMap();
         if (parms == null) {
            tr24.appendTcDetail("Returned map is null."); 
         } else {
            tr24.setTcSuccess(parms.isEmpty());
         }
      } catch(Exception e) {tr24.appendTcDetail(e.toString());}
      tr24.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_writeA1                 */
      /* Details: "Method write(): Writes the URL to the output stream        */
      /* through the provided Writer"                                         */
      TestResult tr25 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEA1);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_writeB1                 */
      /* Details: "Method write(): Writes the URL to the output stream        */
      /* through the provided Writer"                                         */
      TestResult tr26 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_WRITEB1);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_addProperty1            */
      /* Details: "Method addProperty(String, String): A property can be      */
      /* added"                                                               */
      TestResult tr27 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting property values.
         ResourceURL turl = portletResp.createResourceURL();
         turl.addProperty("prop1", "val1");
         tr27.setTcSuccess(true);
      } catch(Exception e) {tr27.appendTcDetail(e.toString());}
      tr27.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_addProperty3            */
      /* Details: "Method addProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr28 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_ADDPROPERTY3);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            turl.addProperty(null, "value");
            tr28.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr28.setTcSuccess(true);
         } catch (Exception e) {
            tr28.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr28.appendTcDetail(e.toString());}
      tr28.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setProperty1            */
      /* Details: "Method setProperty(String, String): Sets a property        */
      /* value for the specified key"                                         */
      TestResult tr29 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY1);
      try {
         // Test if method can be called. Not possible to check resulting property values.
         ResourceURL turl = portletResp.createResourceURL();
         turl.setProperty("prop1", "val1");
         tr29.setTcSuccess(true);
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2URLTests_BaseURL_ApiRenderResurl_setProperty3            */
      /* Details: "Method setProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      TestResult tr30 = tcd.getTestResultFailed(V2URLTESTS_BASEURL_APIRENDERRESURL_SETPROPERTY3);
      try {
         try {
            ResourceURL turl = portletResp.createResourceURL();
            turl.setProperty(null, "value");
            tr30.appendTcDetail("Method did not throw an exception.");
         } catch (IllegalArgumentException iae) {
            tr30.setTcSuccess(true);
         } catch (Exception e) {
            tr30.appendTcDetail(e.toString());
         }
      } catch(Exception e) {tr30.appendTcDetail(e.toString());}
      tr30.writeTo(writer);

   }

}
