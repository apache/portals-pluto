<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.util.*,java.util.logging.*" %>
<%@ page import="static java.util.logging.Logger.*" %>
<%@ page import="javax.portlet.*,javax.portlet.filter.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="javax.portlet.tck.beans.*,javax.portlet.tck.constants.*" %>
<%@ page import="static javax.portlet.tck.constants.Constants.*" %>
<%@ page import="static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*" %>
<%

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttribute */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getAttribute must provide the same         */
      /* functionality as ResourceRequest.getAttribute"                       */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETATTRIBUTE);
      try {
         String ha = (String)request.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttribute");
         String pa = (String)portletReq.getAttribute(ATTR_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttribute");
         CompareUtils.stringsEqual(ha, pa, tr0);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAttributeNames */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getAttributeNames must provide the same    */
      /* functionality as ResourceRequest.getAttributeNames"                  */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETATTRIBUTENAMES);
      try {
         Enumeration<String> he = request.getAttributeNames();
         Enumeration<String> pe = portletReq.getAttributeNames();
         CompareUtils.enumsEqual("HttpServletRequest attribute names", he, "ResourceRequest attribute names", pe,tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getAuthType */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getAuthType must provide the same          */
      /* functionality as ResourceRequest.getAuthType"                        */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETAUTHTYPE);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getCharacterEncoding must provide the      */
      /* same functionality as ResourceRequest.getCharacterEncoding"          */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getContentLength */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getContentLength must provide the same     */
      /* functionality as ResourceRequest.getContentLength"                   */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTENTLENGTH);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getContentType */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getContentType must provide the same       */
      /* functionality as ResourceRequest.getContentType"                     */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTENTTYPE);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getContextPath */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getContextPath must provide the same       */
      /* functionality as ResourceRequest.getContextPath"                     */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCONTEXTPATH);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getCookies */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getCookies must provide the same           */
      /* functionality as ResourceRequest.getCookies"                         */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETCOOKIES);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getDateHeader */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getDateHeader must return a value          */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETDATEHEADER);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getHeader */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getHeader must return a value              */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADER);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getHeaderNames */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* Enumeration returned by HttpServletRequest.getHeaderNames must be    */
      /* contained in the Enumeration returned by                             */
      /* ResourceRequest.getPropertyNames"                                    */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADERNAMES);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getHeaders */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getHeaders must return a value             */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETHEADERS);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getInputStream */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getInputStream must provide the same       */
      /* functionality as ResourceRequest.getPortletInputStream"              */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETINPUTSTREAM);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getIntHeader */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getIntHeader must return a value           */
      /* corresponding to that returned by ResourceRequest.getProperty for    */
      /* the corresponding header name"                                       */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETINTHEADER);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocalAddr */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getLocalAddr must return null"             */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALADDR);
      try {
         String isval = request.getLocalAddr();
         CompareUtils.stringsEqual(isval, null, tr14);
      } catch(Exception e) {tr14.appendTcDetail(e.toString());}
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocalName */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getLocalName must return null"             */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALNAME);
      try {
         String isval = request.getLocalName();
         CompareUtils.stringsEqual(isval, null, tr15);
      } catch(Exception e) {tr15.appendTcDetail(e.toString());}
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocalPort */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getLocalPort must return 0"                */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALPORT);
      try {
         int isval = request.getLocalPort();
         if (isval != 0) tr16.appendTcDetail("Returned value was: " + isval);
         tr16.setTcSuccess(isval == 0);
      } catch(Exception e) {tr16.appendTcDetail(e.toString());}
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocale */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getLocale must provide the same            */
      /* functionality as ResourceRequest.getLocale"                          */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALE);
      try {
         Locale hl = request.getLocale();
         Locale pl = portletReq.getLocale();
         CompareUtils.stringsEqual(hl.getDisplayName(), pl.getDisplayName(), tr17);
      } catch(Exception e) {tr17.appendTcDetail(e.toString());}
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getLocales */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getLocales must provide the same           */
      /* functionality as ResourceRequest.getLocales"                         */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETLOCALES);
      try {
         Enumeration<Locale> he = request.getLocales();
         Enumeration<Locale> pe = portletReq.getLocales();
         CompareUtils.enumsEqual("HttpServletRequest locales", he, "ResourceRequest locales", pe,tr18);
      } catch(Exception e) {tr18.appendTcDetail(e.toString());}
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getMethod */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getMethod must provide the same            */
      /* functionality as ResourceRequest.getMethod"                          */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETMETHOD);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getParameter must provide the same         */
      /* functionality as ResourceRequest.getParameter"                       */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETER);
      try {
         // TestLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter");
         if (val != null) {
            String hval = request.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter");
            String pval = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameter");
            CompareUtils.stringsEqual(hval, pval, tr20);
            tr20.writeTo(writer);
         }
      } catch(Exception e) {tr20.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterMap */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getParameterMap must provide the same      */
      /* functionality as ResourceRequest.getParameterMap"                    */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERMAP);
      try {
         // TestLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterMap");
         if (val != null) {
            Map<String, String[]> hmap = request.getParameterMap();
            Map<String, String[]> pmap = portletReq.getParameterMap();
            CompareUtils.mapsEqual("map from HttpServletRequest", hmap, "map from ResourceRequest", pmap, tr21);
            tr21.writeTo(writer);
         }
      } catch(Exception e) {tr21.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterNames */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getParameterNames must provide the same    */
      /* functionality as ResourceRequest.getParameterNames"                  */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERNAMES);
      try {
         // TestLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterNames");
         if (val != null) {
            Enumeration<String> he = request.getParameterNames();
            Enumeration<String> pe = portletReq.getParameterNames();
            CompareUtils.enumsEqual("HttpServletRequest parameter names", he, "ResourceRequest parameter names", pe,tr22);
            tr22.writeTo(writer);
         }
      } catch(Exception e) {tr22.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getParameterValues must provide the same   */
      /* functionality as ResourceRequest.getParameterValues"                 */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPARAMETERVALUES);
      try {
         // TestLink
         String val = portletReq.getParameter(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues");
         if (val != null) {
            String[] hvals = request.getParameterValues(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues");
            String[] pvals = portletReq.getParameterValues(PARM_PREFIX + "V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getParameterValues");
            CompareUtils.stringsEqual(hvals[0], pvals[0], tr23);
            tr23.writeTo(writer);
         }
      } catch(Exception e) {tr23.appendTcDetail(e.toString());}

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getPathInfo */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getPathInfo must a value corresponding     */
      /* to the path used to obtain the PortletRequestDispatcher"             */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPATHINFO);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getPathTranslated */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getPathTranslated must a value             */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPATHTRANSLATED);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getProtocol */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getProtocol must return \"HTTP/1.1\""      */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETPROTOCOL);
      try {
         String isval = request.getProtocol();
         CompareUtils.stringsEqual(isval, "HTTP/1.1", tr26);
      } catch(Exception e) {tr26.appendTcDetail(e.toString());}
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getQueryString */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getQueryString must a value                */
      /* corresponding to the query string information used to obtain the     */
      /* PortletRequestDispatcher"                                            */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETQUERYSTRING);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getReader */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getReader must provide the same            */
      /* functionality as ResourceRequest.getReader"                          */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREADER);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRealPath */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRealPath must return null"              */
      TestResult tr29 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREALPATH);
      try {
         String isval = request.getRealPath("/WEB-INF/portlet.xml");
         CompareUtils.stringsEqual(isval, null, tr29);
      } catch(Exception e) {tr29.appendTcDetail(e.toString());}
      tr29.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemoteAddr */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRemoteAddr must return null"            */
      TestResult tr30 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEADDR);
      try {
         String isval = request.getRemoteAddr();
         CompareUtils.stringsEqual(isval, null, tr30);
      } catch(Exception e) {tr30.appendTcDetail(e.toString());}
      tr30.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemoteHost */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRemoteHost must return null"            */
      TestResult tr31 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEHOST);
      try {
         String isval = request.getRemoteHost();
         CompareUtils.stringsEqual(isval, null, tr31);
      } catch(Exception e) {tr31.appendTcDetail(e.toString());}
      tr31.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemotePort */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRemotePort must return 0"               */
      TestResult tr32 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEPORT);
      try {
         int isval = request.getRemotePort();
         if (isval != 0) tr32.appendTcDetail("Returned value was: " + isval);
         tr32.setTcSuccess(isval == 0);
      } catch(Exception e) {tr32.appendTcDetail(e.toString());}
      tr32.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRemoteUser */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRemoteUser must provide the same        */
      /* functionality as ResourceRequest.getRemoteUser"                      */
      TestResult tr33 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREMOTEUSER);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestDispatcher */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRequestDispatcher must provide          */
      /* functionality as defined in the servlet specification"               */
      TestResult tr34 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTDISPATCHER);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestURI */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRequestURI must a value corresponding   */
      /* to the path and query string information used to obtain the          */
      /* PortletRequestDispatcher"                                            */
      TestResult tr35 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTURI);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestURL */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRequestURL must return null"            */
      TestResult tr36 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTURL);
      try {
         StringBuffer isval = request.getRequestURL();
         if (isval != null) tr36.appendTcDetail("Request URL is " + isval.toString());
         tr36.setTcSuccess(isval == null);
      } catch(Exception e) {tr36.appendTcDetail(e.toString());}
      tr36.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getRequestedSessionId */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getRequestedSessionId must provide the     */
      /* same functionality as ResourceRequest.getRequestedSessionId"         */
      TestResult tr37 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETREQUESTEDSESSIONID);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getScheme */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getScheme must provide the same            */
      /* functionality as ResourceRequest.getScheme"                          */
      TestResult tr38 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSCHEME);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getServerName */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getServerName must provide the same        */
      /* functionality as ResourceRequest.getServerName"                      */
      TestResult tr39 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVERNAME);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getServerPort */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getServerPort must provide the same        */
      /* functionality as ResourceRequest.getServerPort"                      */
      TestResult tr40 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVERPORT);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getServletPath */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getServletPath must a value                */
      /* corresponding to the path used to obtain the                         */
      /* PortletRequestDispatcher"                                            */
      TestResult tr41 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSERVLETPATH);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getSession */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getSession must provide the same           */
      /* functionality as                                                     */
      /* ResourceRequest.getPortletSession(APPLICATION_SCOPE)"                */
      TestResult tr42 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETSESSION);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_getUserPrincipal */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.getUserPrincipal must provide the same     */
      /* functionality as ResourceRequest.getUserPrincipal"                   */
      TestResult tr43 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_GETUSERPRINCIPAL);
      /* TODO: implement test */
      tr43.appendTcDetail("Not implemented.");
      tr43.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isRequestedSessionIdFromCookie */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.isRequestedSessionIdFromCookie must        */
      /* provide functionality as defined in the servlet specification"       */
      TestResult tr44 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDFROMCOOKIE);
      /* TODO: implement test */
      tr44.appendTcDetail("Not implemented.");
      tr44.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isRequestedSessionIdFromURL1 */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.isRequestedSessionIdFromURL must provide   */
      /* functionality as defined in the servlet specification"               */
      TestResult tr45 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDFROMURL1);
      /* TODO: implement test */
      tr45.appendTcDetail("Not implemented.");
      tr45.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isRequestedSessionIdFromUrl */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.isRequestedSessionIdFromUrl must provide   */
      /* functionality as defined in the servlet specification"               */
      TestResult tr46 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDFROMURL);
      /* TODO: implement test */
      tr46.appendTcDetail("Not implemented.");
      tr46.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isRequestedSessionIdValid */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.isRequestedSessionIdValid must provide     */
      /* the same functionality as                                            */
      /* ResourceRequest.isRequestedSessionIdValid"                           */
      TestResult tr47 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISREQUESTEDSESSIONIDVALID);
      /* TODO: implement test */
      tr47.appendTcDetail("Not implemented.");
      tr47.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isSecure */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.isSecure must provide the same             */
      /* functionality as ResourceRequest.isSecure"                           */
      TestResult tr48 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISSECURE);
      /* TODO: implement test */
      tr48.appendTcDetail("Not implemented.");
      tr48.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_isUserInRole */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.isUserInRole must provide the same         */
      /* functionality as ResourceRequest.isUserInRole"                       */
      TestResult tr49 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_ISUSERINROLE);
      /* TODO: implement test */
      tr49.appendTcDetail("Not implemented.");
      tr49.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_removeAttribute */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.removeAttribute must provide the same      */
      /* functionality as ResourceRequest.removeAttribute"                    */
      TestResult tr50 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_REMOVEATTRIBUTE);
      /* TODO: implement test */
      tr50.appendTcDetail("Not implemented.");
      tr50.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_setAttribute */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.setAttribute must provide the same         */
      /* functionality as ResourceRequest.setAttribute"                       */
      TestResult tr51 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_SETATTRIBUTE);
      /* TODO: implement test */
      tr51.appendTcDetail("Not implemented.");
      tr51.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceRequest_setCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletRequest.setCharacterEncoding must provide the      */
      /* same functionality as ResourceRequest.setCharacterEncoding"          */
      TestResult tr52 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCEREQUEST_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr52.appendTcDetail("Not implemented.");
      tr52.writeTo(writer);

%>
