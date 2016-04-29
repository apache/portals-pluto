<%-- 
  - Author(s): ahmed
  --%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.portlet.PortletException" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286SpecTestCaseDetails.*" %>
<portlet:defineObjects/>
<%
      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      StringWriter writer = new StringWriter();

      JSR286SpecTestCaseDetails tcd = new JSR286SpecTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects1 */
      /* Details: "The portlet-container must provide an implementation of    */
      /* the Tag Lib"                                                         */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_DEFINEOBJECTS1);
      if(!portletConfig.equals(null)){
        tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      
      // For TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_defineObjects2
      // portlet:resourceURL tag is only defined for V2
      %>
      <portlet:resourceURL var="V2_URL" escapeXml="true">
      <portlet:param name="onlyForV2" value="V2_Variable" />
      </portlet:resourceURL>
      <P style="display:none;"><%=V2_URL%></P>
      <%

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace */
      /* Details: "The namespace tag produces a unique string value for the   */
      /* current portlet equal to the value returned by the                   */
      /* PortletResponse.getNamespace method"                                 */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_NAMESPACE);
      if(renderRequest.getParameter("namespace")!=null){
        if(portletResp.getNamespace().equals(renderRequest.getParameter("namespace"))){
          tr4.setTcSuccess(true);
          tr4.writeTo(writer);
        }
      } else {
      %>
      <DIV CLASS="portletTCKTestcase" name="V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace">
        <h4>V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace button (POST):</h4>
        <FORM METHOD="POST" ACTION="<portlet:actionURL/>">
          <INPUT NAME='namespace' VALUE='<portlet:namespace/>' TYPE="hidden">
          <INPUT VALUE="V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace" ID="V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_namespace-clickme" TYPE="submit">
        </FORM>
      </DIV>
      <% }
      
      /*
       * TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_escapeXML1
       * Details: The container runtime option \"javax.portlet.escapeXml\" 
       * can be used to set the default escapeXML setting to true
       */
      TestResult tr5 =
          tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML1);
      // TODO: Implement test when escapeXml problem is solved
      %>
      <portlet:resourceURL id="icons/he<&>llo" escapeXml="false"/>
      <portlet:resourceURL id="icons/he<&>llo" escapeXml="true"/>
      <%
      tr5.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests_SPEC2_26_IncludeJSPGeneral_escapeXML2 */
      /* Details: "The container runtime option \"javax.portlet.escapeXml\" */
      /* can be used to set the default escapeXML setting to false" */
      // TODO: Implement test when escapeXml problem is solved
      TestResult tr6 =
          tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS_SPEC2_26_INCLUDEJSPGENERAL_ESCAPEXML2);
      tr6.appendTcDetail(
          "Might not be possible to configure javax.portlet.escapeXml to false when the portlet is running.");
      tr6.writeTo(writer);

%>
<%=writer.toString()%>