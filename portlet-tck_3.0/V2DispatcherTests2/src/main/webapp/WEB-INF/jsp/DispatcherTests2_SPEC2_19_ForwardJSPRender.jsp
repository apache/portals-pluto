<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286DispatcherTestCaseDetails.*" %>
<P>-- start jsp DispatcherTests2_SPEC2_19_ForwardJSPRender for module DispatcherTests2 --</P>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute("void");

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_19_ForwardJSPRender_dispatch1                        */
      /* Details: "If the path provided to getRequestDispatcher method        */
      /* contains query strings, parameters specified in the query strings    */
      /* must be passed to the target servlet during an forward"              */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_DISPATCH1);
      /* TODO: implement test */
      tr0.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_dispatch2                        */
      /* Details: "Parameters specified in the query strings must be          */
      /* aggregated with the portlet render parameters"                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_DISPATCH2);
      /* TODO: implement test */
      tr1.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_dispatch3                        */
      /* Details: "If query string parameters have the same names as render   */
      /* parameter names, the query string parameters appear in the           */
      /* parameter values array before the render parameter values"           */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_DISPATCH3);
      /* TODO: implement test */
      tr2.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_dispatch4                        */
      /* Details: "The parameters associated with a request dispatcher are    */
      /* scoped only for the duration of the forward or forward call"         */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_DISPATCH4);
      /* TODO: implement test */
      tr3.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_invoke1                          */
      /* Details: "The PortletRequestDispatcher include method can include    */
      /* a target servlet "                                                   */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_INVOKE1);
      /* TODO: implement test */
      tr4.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_invoke2                          */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be the request and response classes from the portlet lifecyle    */
      /* method initiating the include"                                       */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_INVOKE2);
      /* TODO: implement test */
      tr5.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_invoke3                          */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_INVOKE3);
      /* TODO: implement test */
      tr6.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_invoke4                          */
      /* Details: "The portlet container must invoke the target servlet in    */
      /* the same thread as the PortletRequestDispatcher include              */
      /* invocation"                                                          */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_INVOKE4);
      /* TODO: implement test */
      tr7.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_invoke5                          */
      /* Details: "Cookies set by the portlet before the forward call         */
      /* remain valid"                                                        */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_INVOKE5);
      /* TODO: implement test */
      tr8.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_invoke6                          */
      /* Details: "Properties set by the portlet before the forward call      */
      /* remain valid"                                                        */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_INVOKE6);
      /* TODO: implement test */
      tr9.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_invoke7                          */
      /* Details: "The path elements of the request object exposed to the     */
      /* target servlet must reflect the path used to obtain the              */
      /* RequestDispatcher"                                                   */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_INVOKE7);
      /* TODO: implement test */
      tr10.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_commit1                          */
      /* Details: "Before the forward method of the RequestDispatcher         */
      /* interface returns, the response content must be sent and             */
      /* committed, and closed by the portlet container"                      */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_COMMIT1);
      /* TODO: implement test */
      tr11.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_title1                           */
      /* Details: "A portlet title set by the portlet before the forward      */
      /* call remains valid"                                                  */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_TITLE1);
      /* TODO: implement test */
      tr12.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes1                      */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.request_uri will be set, and equals the        */
      /* value from HTTPServletRequest.getRequestURI for the first servlet    */
      /* in the forward chain"                                                */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1);
      /* TODO: implement test */
      tr13.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes2                      */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.context_path will be set, and equals the       */
      /* value from HTTPServletRequest.getContestPath for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2);
      /* TODO: implement test */
      tr14.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes3                      */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.servlet_path will be set, and equals the       */
      /* value from HTTPServletRequest.getServletPath for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3);
      /* TODO: implement test */
      tr15.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes4                      */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.path_info will be set, and equals the value    */
      /* from HTTPServletRequest.getPathInfo for the first servlet in the     */
      /* forward chain"                                                       */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4);
      /* TODO: implement test */
      tr16.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes5                      */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.query_string will be set, and equals the       */
      /* value from HTTPServletRequest.getQueryString for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5);
      /* TODO: implement test */
      tr17.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes6                      */
      /* Details: "The request attribute javax.portlet.config must be set     */
      /* to the javax.portlet.PortletConfig object"                           */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES6);
      /* TODO: implement test */
      tr18.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes7                      */
      /* Details: "For forwards from the render method, The request           */
      /* attribute javax.portlet.request must be set to the                   */
      /* javax.portlet.RenderRequest object"                                  */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES7);
      /* TODO: implement test */
      tr19.writeTo(writer);

      /* TestCase: SPEC2_19_ForwardJSPRender_attributes8                      */
      /* Details: "For forwards from the render method, The request           */
      /* attribute javax.portlet.response must be set to the                  */
      /* javax.portlet.RenderResponse object"                                 */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES8);
      /* TODO: implement test */
      tr20.writeTo(writer);

%>
<P>-- end of jsp DispatcherTests2_SPEC2_19_ForwardJSPRender --</P>
