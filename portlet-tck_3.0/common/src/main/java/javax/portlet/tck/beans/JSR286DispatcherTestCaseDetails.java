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

package javax.portlet.tck.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines constants for the test case names and test case details 
 * for the JSR 286 API compatibility tests.
 * 
 * Note that the backing map is static and not threadsafe. Operations
 * that change the map such as put, remove, etc., should not be used
 * in portlets.
 * 
 * @author nick
 */
public class JSR286DispatcherTestCaseDetails extends TestCaseDetails {

   public final static String SPEC2_19_DISPATCH_GETDISPATCHER1 = "SPEC2_19_Dispatch_getDispatcher1";
   public final static String SPEC2_19_DISPATCH_GETDISPATCHER2 = "SPEC2_19_Dispatch_getDispatcher2";
   public final static String SPEC2_19_DISPATCH_GETDISPATCHER3 = "SPEC2_19_Dispatch_getDispatcher3";
   public final static String SPEC2_19_DISPATCH_GETDISPATCHER4 = "SPEC2_19_Dispatch_getDispatcher4";
   public final static String SPEC2_19_DISPATCH_GETDISPATCHER5 = "SPEC2_19_Dispatch_getDispatcher5";
   public final static String SPEC2_19_DISPATCH_GETDISPATCHER6 = "SPEC2_19_Dispatch_getDispatcher6";
   public final static String SPEC2_19_RENDER_GETDISPATCHER7 = "SPEC2_19_Render_getDispatcher7";
   public final static String SPEC2_19_RENDER_GETDISPATCHER8 = "SPEC2_19_Render_getDispatcher8";
   public final static String SPEC2_19_RENDER_GETDISPATCHER9 = "SPEC2_19_Render_getDispatcher9";
   public final static String SPEC2_19_RENDER_GETDISPATCHER10 = "SPEC2_19_Render_getDispatcher10";
   public final static String SPEC2_19_RENDER_GETDISPATCHER11 = "SPEC2_19_Render_getDispatcher11";
   public final static String SPEC2_19_INCLUDESERVLET_INVOKE1 = "SPEC2_19_IncludeServlet_invoke1";
   public final static String SPEC2_19_INCLUDESERVLET_INVOKE2 = "SPEC2_19_IncludeServlet_invoke2";
   public final static String SPEC2_19_INCLUDESERVLET_INVOKE3 = "SPEC2_19_IncludeServlet_invoke3";
   public final static String SPEC2_19_INCLUDESERVLET_INVOKE4 = "SPEC2_19_IncludeServlet_invoke4";
   public final static String SPEC2_19_INCLUDESERVLET_INVOKE5 = "SPEC2_19_IncludeServlet_invoke5";
   public final static String SPEC2_19_INCLUDESERVLET_INVOKE6 = "SPEC2_19_IncludeServlet_invoke6";
   public final static String SPEC2_19_INCLUDESERVLET_INVOKE7 = "SPEC2_19_IncludeServlet_invoke7";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1 = "SPEC2_19_IncludeServletAction_attributes1";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2 = "SPEC2_19_IncludeServletAction_attributes2";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3 = "SPEC2_19_IncludeServletAction_attributes3";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4 = "SPEC2_19_IncludeServletAction_attributes4";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5 = "SPEC2_19_IncludeServletAction_attributes5";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES6 = "SPEC2_19_IncludeServletAction_attributes6";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES7 = "SPEC2_19_IncludeServletAction_attributes7";
   public final static String SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES8 = "SPEC2_19_IncludeServletAction_attributes8";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1 = "SPEC2_19_IncludeServletEvent_attributes1";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2 = "SPEC2_19_IncludeServletEvent_attributes2";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3 = "SPEC2_19_IncludeServletEvent_attributes3";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4 = "SPEC2_19_IncludeServletEvent_attributes4";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5 = "SPEC2_19_IncludeServletEvent_attributes5";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES6 = "SPEC2_19_IncludeServletEvent_attributes6";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES7 = "SPEC2_19_IncludeServletEvent_attributes7";
   public final static String SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES8 = "SPEC2_19_IncludeServletEvent_attributes8";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1 = "SPEC2_19_IncludeServletRender_attributes1";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2 = "SPEC2_19_IncludeServletRender_attributes2";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3 = "SPEC2_19_IncludeServletRender_attributes3";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4 = "SPEC2_19_IncludeServletRender_attributes4";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5 = "SPEC2_19_IncludeServletRender_attributes5";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES6 = "SPEC2_19_IncludeServletRender_attributes6";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES7 = "SPEC2_19_IncludeServletRender_attributes7";
   public final static String SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES8 = "SPEC2_19_IncludeServletRender_attributes8";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1 = "SPEC2_19_IncludeServletResource_attributes1";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2 = "SPEC2_19_IncludeServletResource_attributes2";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3 = "SPEC2_19_IncludeServletResource_attributes3";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4 = "SPEC2_19_IncludeServletResource_attributes4";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5 = "SPEC2_19_IncludeServletResource_attributes5";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES6 = "SPEC2_19_IncludeServletResource_attributes6";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES7 = "SPEC2_19_IncludeServletResource_attributes7";
   public final static String SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES8 = "SPEC2_19_IncludeServletResource_attributes8";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE1 = "SPEC2_19_ForwardServlet_invoke1";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE2 = "SPEC2_19_ForwardServlet_invoke2";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE3 = "SPEC2_19_ForwardServlet_invoke3";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE4 = "SPEC2_19_ForwardServlet_invoke4";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE5 = "SPEC2_19_ForwardServlet_invoke5";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE6 = "SPEC2_19_ForwardServlet_invoke6";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE7 = "SPEC2_19_ForwardServlet_invoke7";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE8 = "SPEC2_19_ForwardServlet_invoke8";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE9 = "SPEC2_19_ForwardServlet_invoke9";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE10 = "SPEC2_19_ForwardServlet_invoke10";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE11 = "SPEC2_19_ForwardServlet_invoke11";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE12 = "SPEC2_19_ForwardServlet_invoke12";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE13 = "SPEC2_19_ForwardServlet_invoke13";
   public final static String SPEC2_19_FORWARDSERVLET_INVOKE14 = "SPEC2_19_ForwardServlet_invoke14";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1 = "SPEC2_19_ForwardServletAction_attributes1";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2 = "SPEC2_19_ForwardServletAction_attributes2";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3 = "SPEC2_19_ForwardServletAction_attributes3";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4 = "SPEC2_19_ForwardServletAction_attributes4";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5 = "SPEC2_19_ForwardServletAction_attributes5";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES6 = "SPEC2_19_ForwardServletAction_attributes6";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES7 = "SPEC2_19_ForwardServletAction_attributes7";
   public final static String SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES8 = "SPEC2_19_ForwardServletAction_attributes8";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1 = "SPEC2_19_ForwardServletEvent_attributes1";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2 = "SPEC2_19_ForwardServletEvent_attributes2";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3 = "SPEC2_19_ForwardServletEvent_attributes3";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4 = "SPEC2_19_ForwardServletEvent_attributes4";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5 = "SPEC2_19_ForwardServletEvent_attributes5";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES6 = "SPEC2_19_ForwardServletEvent_attributes6";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES7 = "SPEC2_19_ForwardServletEvent_attributes7";
   public final static String SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES8 = "SPEC2_19_ForwardServletEvent_attributes8";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1 = "SPEC2_19_ForwardServletRender_attributes1";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2 = "SPEC2_19_ForwardServletRender_attributes2";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3 = "SPEC2_19_ForwardServletRender_attributes3";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4 = "SPEC2_19_ForwardServletRender_attributes4";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5 = "SPEC2_19_ForwardServletRender_attributes5";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES6 = "SPEC2_19_ForwardServletRender_attributes6";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES7 = "SPEC2_19_ForwardServletRender_attributes7";
   public final static String SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES8 = "SPEC2_19_ForwardServletRender_attributes8";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1 = "SPEC2_19_ForwardServletResource_attributes1";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2 = "SPEC2_19_ForwardServletResource_attributes2";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3 = "SPEC2_19_ForwardServletResource_attributes3";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4 = "SPEC2_19_ForwardServletResource_attributes4";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5 = "SPEC2_19_ForwardServletResource_attributes5";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES6 = "SPEC2_19_ForwardServletResource_attributes6";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES7 = "SPEC2_19_ForwardServletResource_attributes7";
   public final static String SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES8 = "SPEC2_19_ForwardServletResource_attributes8";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(SPEC2_19_DISPATCH_GETDISPATCHER1, "The PortletContext getRequestDispatcher method returns a PortletRequestDispatcher for a path within the portlet application");
      tcd.put(SPEC2_19_DISPATCH_GETDISPATCHER2, "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the included servlet");
      tcd.put(SPEC2_19_DISPATCH_GETDISPATCHER3, "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the forwarded servlet");
      tcd.put(SPEC2_19_DISPATCH_GETDISPATCHER4, "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(SPEC2_19_DISPATCH_GETDISPATCHER5, "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(SPEC2_19_DISPATCH_GETDISPATCHER6, "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(SPEC2_19_RENDER_GETDISPATCHER7, "If the path provided to getRequestDispatcher method does not start with \"/\", the method returns null");
      tcd.put(SPEC2_19_RENDER_GETDISPATCHER8, "If the path provided to getRequestDispatcher method ends with \"/\", the method returns null");
      tcd.put(SPEC2_19_RENDER_GETDISPATCHER9, "If the path provided to getRequestDispatcher method does not specify a valid path, the method returns null");
      tcd.put(SPEC2_19_RENDER_GETDISPATCHER10, "The PortletContext getNamedDispatcher method returns a PortletRequestDispatcher for a servlet within the portlet application");
      tcd.put(SPEC2_19_RENDER_GETDISPATCHER11, "If the name provided to getNamedDispatcher method is not valid, the method returns null");
      tcd.put(SPEC2_19_INCLUDESERVLET_INVOKE1, "The PortletRequestDispatcher include method can include a target servlet ");
      tcd.put(SPEC2_19_INCLUDESERVLET_INVOKE2, "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(SPEC2_19_INCLUDESERVLET_INVOKE3, "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(SPEC2_19_INCLUDESERVLET_INVOKE4, "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(SPEC2_19_INCLUDESERVLET_INVOKE5, "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(SPEC2_19_INCLUDESERVLET_INVOKE6, "The included servlet must be handled as an HTTP GET request");
      tcd.put(SPEC2_19_INCLUDESERVLET_INVOKE7, "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES7, "For includes from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES8, "For includes from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES7, "For includes from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES8, "For includes from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES7, "For includes from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES8, "For includes from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES7, "For includes from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES8, "For includes from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE1, "The PortletRequestDispatcher include method can include a target servlet ");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE2, "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE3, "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE4, "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE5, "If output data exists in the response buffer that has not been committed, the content must be cleared before the target servlet's service method is called");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE6, "If the forward method is called after the response has been committed, an IllegalStateException exception is thrown");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE7, "Cookies set by the portlet before the forward call remain valid");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE8, "A window state set by the portlet before the forward call remains valid");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE9, "A portlet mode set by the portlet before the forward call remains valid");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE10, "Properties set by the portlet before the forward call remain valid");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE11, "Render parameters set by the portlet before the forward call remain valid");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE12, "A portlet title set by the portlet before the forward call remains valid");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE13, "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(SPEC2_19_FORWARDSERVLET_INVOKE14, "Before the forward method of the RequestDispatcher interface returns, the response content must be sent and committed, and closed by the portlet container");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES7, "For forwards from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES8, "For forwards from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES7, "For forwards from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES8, "For forwards from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES7, "For forwards from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES8, "For forwards from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContestPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5, "If the request dispatcher is obtained through the getRequestDispatcher method, the request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES6, "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES7, "For forwards from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES8, "For forwards from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations
    * that change the map such as put, remove, etc., should not be used
    * in portlets.
    */
   public JSR286DispatcherTestCaseDetails() {
     super(tcd); 
   }

}
