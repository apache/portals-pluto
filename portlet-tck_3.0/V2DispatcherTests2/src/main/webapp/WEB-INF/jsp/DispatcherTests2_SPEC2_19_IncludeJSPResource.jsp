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

      /* TestCase: SPEC2_19_IncludeJSPResource_dispatch1                      */
      /* Details: "If the path provided to getRequestDispatcher method        */
      /* contains query strings, parameters specified in the query strings    */
      /* must be passed to the target servlet during an include"              */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH1);
      try {
         String qparm1 = portletReq.getParameter("qparm1");
         String qparm2 = portletReq.getParameter("qparm2");
         boolean ok = ((qparm1 != null) && (qparm2 != null));
         if (ok) ok = (qparm1.equals("qvalue1") && qparm2.equals("qvalue2"));
         if (!ok) tr0.appendTcDetail("qparm1=" + qparm1 + ", qparm2=" + qparm2);
         tr0.setTcSuccess(ok);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_dispatch2                      */
      /* Details: "Parameters specified in the query strings must be          */
      /* aggregated with the portlet render parameters"                       */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH2);
      try {
         String[] qparm2 = portletReq.getParameterValues("qparm2");
         boolean ok = ((qparm2 != null) && (qparm2.length > 1));
         String str = "qparm2 " + ((qparm2==null)?("is null"):("length="+qparm2.length));
         if (!ok) tr1.appendTcDetail(str);
         tr1.setTcSuccess(ok);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_dispatch3                      */
      /* Details: "If query string parameters have the same names as render   */
      /* parameter names, the query string parameters appear in the           */
      /* parameter values array before the render parameter values"           */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH3);
      try {
         String qparm1 = portletReq.getParameter("qparm1");
         String qparm2 = portletReq.getParameter("qparm2");
         boolean ok = ((qparm1 != null) && (qparm2 != null));
         if (ok) ok = (qparm1.equals("qvalue1") && qparm2.equals("qvalue2"));
         if (!ok) tr2.appendTcDetail("qparm1=" + qparm1 + ", qparm2=" + qparm2);
         tr2.setTcSuccess(ok);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_dispatch4                      */
      /* Details: "The parameters associated with a request dispatcher are    */
      /* scoped only for the duration of the include or forward call"         */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH4);
      /* TODO: implement test */
      tr3.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke1                        */
      /* Details: "The PortletRequestDispatcher include method can target a   */
      /* servlet "                                                            */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE1);
      try {
         // If this gets executed, include worked.
         tr4.setTcSuccess(true);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke2                        */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be the request and response classes from the portlet lifecyle    */
      /* method initiating the include"                                       */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE2);
      try {
         // If this gets executed, include worked.
         tr5.setTcSuccess(true);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke3                        */
      /* Details: "Parameters to the include method for a target servlet      */
      /* can be wrapped request and response classes from the portlet         */
      /* lifecyle method initiating the include"                              */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE3);
      /* TODO: implement test */
      tr6.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke4                        */
      /* Details: "The portlet container must invoke the target servlet in    */
      /* the same thread as the PortletRequestDispatcher include              */
      /* invocation"                                                          */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE4);
      try {
         tr7.setTcSuccess(reqTid == svtTid);
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke5                        */
      /* Details: "Cookies set by the portlet before the include call         */
      /* remain valid"                                                        */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE5);
      try {
         Cookie[] cs = portletReq.getCookies();
         boolean ok = false;
         for (Cookie c : cs) {
            if (c.getName().equals(COOKIE_PREFIX + "DispatcherTests2_SPEC2_19_IncludeJSPResource")) {
               ok = true;
               c.setMaxAge(0);  // cookie only lives for this request
            }
         }
         tr8.setTcSuccess(ok);
      } catch(Exception e) {tr8.appendTcDetail(e.toString());}
      tr8.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke6                        */
      /* Details: "Properties set by the portlet before the include call      */
      /* remain valid"                                                        */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE6);
      try {
         String prop = portletReq.getProperty(PROP_PREFIX + "DispatcherTests2_SPEC2_19_IncludeJSPResource");
         tr9.setTcSuccess(prop != null);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke7                        */
      /* Details: "The path elements of the request object exposed to the     */
      /* target servlet must reflect the path used to obtain the              */
      /* RequestDispatcher"                                                   */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE7);
      try {
         String ctxpath= request.getContextPath();
         tr10.setTcSuccess(ctxpath.equals("/DispatcherTests2_SPEC2_19_IncludeJSPResource"));
      } catch(Exception e) {tr10.appendTcDetail(e.toString());}
      tr10.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke8                        */
      /* Details: "The portlet can include multiple servlets during the       */
      /* same lifecycle method"                                               */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE8);
      /* TODO: implement test */
      tr11.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_invoke9                        */
      /* Details: "The included servlet must be handled as an HTTP GET        */
      /* request"                                                             */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_INVOKE9);
      try {
         String meth = request.getMethod();
         tr12.setTcSuccess(meth.equals("GET"));
      } catch(Exception e) {tr12.appendTcDetail(e.toString());}
      tr12.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes1                    */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.request_uri will be set, and equals the        */
      /* value from HTTPServletRequest.getRequestURI for the first servlet    */
      /* in the include chain"                                                */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1);
      /* TODO: implement test */
      tr13.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes2                    */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.context_path will be set, and equals the       */
      /* value from HTTPServletRequest.getContestPath for the first servlet   */
      /* in the include chain"                                                */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2);
      /* TODO: implement test */
      tr14.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes3                    */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.servlet_path will be set, and equals the       */
      /* value from HTTPServletRequest.getServletPath for the first servlet   */
      /* in the include chain"                                                */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3);
      /* TODO: implement test */
      tr15.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes4                    */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.path_info will be set, and equals the value    */
      /* from HTTPServletRequest.getPathInfo for the first servlet in the     */
      /* include chain"                                                       */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4);
      /* TODO: implement test */
      tr16.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes5                    */
      /* Details: "If the request dispatcher is obtained through the          */
      /* getRequestDispatcher method, the request attribute                   */
      /* javax.servlet.include.query_string will be set, and equals the       */
      /* value from HTTPServletRequest.getQueryString for the first servlet   */
      /* in the include chain"                                                */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5);
      /* TODO: implement test */
      tr17.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes6                    */
      /* Details: "The request attribute javax.portlet.config must be set     */
      /* to the javax.portlet.PortletConfig object"                           */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES6);
      /* TODO: implement test */
      tr18.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes7                    */
      /* Details: "For includes from the serveResource method, The request    */
      /* attribute javax.portlet.request must be set to the                   */
      /* javax.portlet.ResourceRequest object"                                */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES7);
      /* TODO: implement test */
      tr19.writeTo(writer);

      /* TestCase: SPEC2_19_IncludeJSPResource_attributes8                    */
      /* Details: "For includes from the serveResource method, The request    */
      /* attribute javax.portlet.response must be set to the                  */
      /* javax.portlet.ResourceResponse object"                               */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES8);
      /* TODO: implement test */
      tr20.writeTo(writer);

%>
