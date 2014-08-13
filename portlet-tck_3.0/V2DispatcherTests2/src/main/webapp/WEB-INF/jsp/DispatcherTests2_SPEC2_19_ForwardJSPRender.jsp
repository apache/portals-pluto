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
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute("void");

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherTestCaseDetails tcd = new JSR286DispatcherTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_dispatch1     */
      /* Details: "If the path provided to getRequestDispatcher method        */
      /* contains query strings, parameters specified in the query strings    */
      /* must be passed to the target servlet during an forward"              */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH1);
      try {
         String qparm1 = portletReq.getParameter("qparm1");
         String qparm2 = portletReq.getParameter("qparm2");
         boolean ok = ((qparm1 != null) && (qparm2 != null));
         if (ok) ok = (qparm1.equals("qvalue1") && qparm2.equals("qvalue2"));
         if (!ok) tr0.appendTcDetail("qparm1=" + qparm1 + ", qparm2=" + qparm2);
         tr0.setTcSuccess(ok);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_dispatch2     */
      /* Details: "Parameters specified in the query strings must be          */
      /* aggregated with the portlet render parameters"                       */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH2);
      try {
         String[] qparm2 = portletReq.getParameterValues("qparm2");
         boolean ok = ((qparm2 != null) && (qparm2.length > 1));
         String str = "qparm2 " + ((qparm2==null)?("is null"):("length="+qparm2.length));
         if (!ok) tr1.appendTcDetail(str);
         tr1.setTcSuccess(ok);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_dispatch3     */
      /* Details: "If query string parameters have the same names as render   */
      /* parameter names, the query string parameters appear in the           */
      /* parameter values array before the render parameter values"           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH3);
      try {
         String qparm1 = portletReq.getParameter("qparm1");
         String qparm2 = portletReq.getParameter("qparm2");
         boolean ok = ((qparm1 != null) && (qparm2 != null));
         if (ok) ok = (qparm1.equals("qvalue1") && qparm2.equals("qvalue2"));
         if (!ok) tr2.appendTcDetail("qparm1=" + qparm1 + ", qparm2=" + qparm2);
         tr2.setTcSuccess(ok);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_dispatch4     */
      /* Details: "The parameters associated with a request dispatcher are    */
      /* scoped only for the duration of the forward or forward call"         */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke1       */
      /* Details: "The PortletRequestDispatcher forward method can target a   */
      /* servlet "                                                            */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE1);
      try {
         // If this gets executed, include worked.
         tr4.setTcSuccess(true);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke2       */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be the request and response classes from the portlet lifecyle    */
      /* method initiating the include"                                       */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE2);
      try {
         // If this gets executed, include worked.
         tr5.setTcSuccess(true);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke3       */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE3);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke4       */
      /* Details: "The portlet container must invoke the target servlet in    */
      /* the same thread as the PortletRequestDispatcher include              */
      /* invocation"                                                          */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE4);
      try {
         tr7.setTcSuccess(reqTid == svtTid);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke7       */
      /* Details: "The path elements of the request object exposed to the     */
      /* target servlet must reflect the path used to obtain the              */
      /* RequestDispatcher"                                                   */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE7);
      try {
         String ctxPath= request.getContextPath();
         CompareUtils.stringsEqual(ctxPath, "/DispatcherTests2_SPEC2_19_ForwardJSPRender", tr8);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_commit1       */
      /* Details: "Before the forward method of the RequestDispatcher         */
      /* interface returns, the response content must be sent and             */
      /* committed, and closed by the portlet container"                      */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_COMMIT1);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes1   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.request_uri will be set, and equals the        */
      /* value from HTTPServletRequest.getRequestURI for the first servlet    */
      /* in the forward chain"                                                */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1);
      try {
         String name = "javax.servlet.forward.req.uri";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getRequestURI();
         CompareUtils.stringsEqual(attrVal, currVal, tr10);
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes2   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.context_path will be set, and equals the       */
      /* value from HTTPServletRequest.getContestPath for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2);
      try {
         String name = "javax.servlet.forward.context_path";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getContextPath();
         CompareUtils.stringsEqual(attrVal, currVal, tr11);
      } catch(Exception e) {tr11.appendTcDetail(e.toString());}
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes3   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.servlet_path will be set, and equals the       */
      /* value from HTTPServletRequest.getServletPath for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3);
      try {
         String name = "javax.servlet.forward.servlet_path";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getServletPath();
         CompareUtils.stringsEqual(attrVal, currVal, tr12);
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes4   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.path_info will be set, and equals the value    */
      /* from HTTPServletRequest.getPathInfo for the first servlet in the     */
      /* forward chain"                                                       */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4);
      try {
         String name = "javax.servlet.forward.path_info";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getPathInfo();
         CompareUtils.stringsEqual(attrVal, currVal, tr13);
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes5   */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.forward.query_string will be set, and equals the       */
      /* value from HTTPServletRequest.getQueryString for the first servlet   */
      /* in the forward chain"                                                */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5);
      try {
         String name = "javax.servlet.forward.query_string";
         String attrVal = (String) portletReq.getAttribute(name);
         String currVal =  request.getQueryString();
         CompareUtils.stringsEqual(attrVal, currVal, tr14);
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes6   */
      /* Details: "The request attribute javax.portlet.config must be set     */
      /* to the javax.portlet.PortletConfig object"                           */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES6);
      try {
         ClassChecker cc = new ClassChecker(portletConfig.getClass());
         boolean ok = cc.implementsInterface(PortletConfig.class);
         tr15.setTcSuccess(ok);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes7   */
      /* Details: "For forwards from the render method, The request           */
      /* attribute javax.portlet.request must be set to the                   */
      /* javax.portlet.RenderRequest object"                                  */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES7);
      try {
         ClassChecker cc = new ClassChecker(portletReq.getClass());
         boolean ok = cc.implementsInterface(RenderRequest.class);
         tr16.setTcSuccess(ok);
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes8   */
      /* Details: "For forwards from the render method, The request           */
      /* attribute javax.portlet.response must be set to the                  */
      /* javax.portlet.RenderResponse object"                                 */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES8);
      try {
         ClassChecker cc = new ClassChecker(portletResp.getClass());
         boolean ok = cc.implementsInterface(RenderResponse.class);
         tr17.setTcSuccess(ok);
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

%>
