<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*" %>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects3 */
      /* Details: "The version 1.0 tag library may be referenced using        */
      /* &lt;%@ taglib uri=\"http://java.sun.com/portlet\"                    */
      /* prefix=\"portlet\" %&gt;"                                            */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS3);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects1 */
      /* Details: "The portlet-container must provide an implementation of    */
      /* the Tag Lib"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS1);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects2 */
      /* Details: "In order to obtain version 2 support, the tag library      */
      /* must be specified as &lt;%@ taglib                                   */
      /* uri=\"http://java.sun.com/portlet_2_0\" prefix=\"portlet\" %&gt;"    */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS2);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects4 */
      /* Details: "The defineObjects tag must not define any attribute and    */
      /* it must not contain any body content"                                */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace */
      /* Details: "The namespace tag produces a unique string value for the   */
      /* current portlet equal to the value returned by the                   */
      /* PortletResponse.getNamespace method"                                 */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_NAMESPACE);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_escapeXML1 */
      /* Details: "The container runtime option \"javax.portlet.escapeXml\"   */
      /* can be used to set the default escapeXML setting to true"            */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML1);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_escapeXML2 */
      /* Details: "The container runtime option \"javax.portlet.escapeXml\"   */
      /* can be used to set the default escapeXML setting to false"           */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML2);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

%>
