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
 * portlet ResponseTests_PortletResponse_ApiEvent_event
 *
 */
public class ResponseTests_PortletResponse_ApiEvent implements Portlet, ResourceServingPortlet {
   private static final String LOG_CLASS = 
         ResponseTests_PortletResponse_ApiEvent.class.getName();
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

      portletResp.setRenderParameters(portletReq.getParameterMap());
      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      StringWriter writer = new StringWriter();

      QName eventQName = new QName(TCKNAMESPACE,
             "ResponseTests_PortletResponse_ApiEvent");
      portletResp.setEvent(eventQName, "Hi!");
   }

   @Override
   public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

   }

   @Override
   public void render(RenderRequest portletReq, RenderResponse portletResp)
         throws PortletException, IOException {

      long tid = Thread.currentThread().getId();
      portletReq.setAttribute(THREADID_ATTR, tid);

      PrintWriter writer = portletResp.getWriter();

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyA1     */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Adds the    */
      /* specified cookie property to the response"                           */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_addPropertyA1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyA2     */
      /* Details: "Method addProperty(javax.servlet.http.Cookie): Throws      */
      /* IllegalArgumentException if the specified cookie is null"            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_addPropertyA2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB1     */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Adds an   */
      /* XML DOM Element to the response for the specified key"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_addPropertyB1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB3     */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): If the    */
      /* specified DOM Element value is null, the key is removed from the     */
      /* response"                                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_addPropertyB3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyB4     */
      /* Details: "Method addProperty(String, org.w3c.dom.Element): Throws    */
      /* IllegalArgumentException if the specified key is null"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_addPropertyB4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyC1     */
      /* Details: "Method addProperty(String, String): A property can be      */
      /* added"                                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_addPropertyC1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_addPropertyC2     */
      /* Details: "Method addProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_addPropertyC2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_setProperty1      */
      /* Details: "Method setProperty(String, String): Sets a property        */
      /* value for the specified key"                                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_setProperty1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_setProperty3      */
      /* Details: "Method setProperty(String, String): Throws                 */
      /* IllegalArgumentException if the specified key is null"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_setProperty3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_encodeURL1        */
      /* Details: "Method encodeURL(String): Returns a String representing    */
      /* the encoded URL"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_encodeURL1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_encodeURL2        */
      /* Details: "Method encodeURL(String): Throws                           */
      /* IllegalArgumentException if the input string is not an absolute      */
      /* URL and does not start with at \"/\" character"                      */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_encodeURL2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_getNamespace1     */
      /* Details: "Method getNamespace(): Returns a String containing the     */
      /* namespace value"                                                     */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_getNamespace1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement1    */
      /* Details: "Method createElement(String): Returns an                   */
      /* org.w3c.dom.Element object for the specified tag name"               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_createElement1", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement2    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* nodeName set to the the specified tag name "                         */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_createElement2", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement3    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* localName set to null"                                               */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_createElement3", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement4    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* prefix set to null"                                                  */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_createElement4", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement5    */
      /* Details: "Method createElement(String): The returned Element has     */
      /* namespaceURI set to null"                                            */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_createElement5", aurl);
         tb.writeTo(writer);
      }

      /* TestCase: V2ResponseTests_PortletResponse_ApiEvent_createElement6    */
      /* Details: "Method createElement(String): Throws                       */
      /* org.w3c.dom.DOMException - INVALID_CHARACTER_ERR if the specified    */
      /* name contains an illegal character. "                                */
      {
         PortletURL aurl = portletResp.createActionURL();
         aurl.setParameters(portletReq.getPrivateParameterMap());
         TestButton tb = new TestButton("V2ResponseTests_PortletResponse_ApiEvent_createElement6", aurl);
         tb.writeTo(writer);
      }

   }

}
