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

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_containsHeader */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.containsHeader must return false"         */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr0.setTcSuccess(ok == false);
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeRedirectURL1 */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.encodeRedirectURL must return null"       */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr1);
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeRedirectUrl */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.encodeRedirectUrl must return null"       */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr2);
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeURL1 */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.encodeURL must provide the same           */
      /* functionality as ResourceResponse.encodeURL"                         */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEURL1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_encodeUrl */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.encodeUrl must provide the same           */
      /* functionality as ResourceResponse.encodeURL"                         */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ENCODEURL);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_flushBuffer */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.flushBuffer must provide the same         */
      /* functionality as ResourceResponse.flushBuffer"                       */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_FLUSHBUFFER);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getBufferSize */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.getBufferSize must provide the same       */
      /* functionality as ResourceResponse.getBufferSize"                     */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETBUFFERSIZE);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.getCharacterEncoding must provide the     */
      /* same functionality as ResourceResponse.getCharacterEncoding"         */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getContentType */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.getContentType must provide the same      */
      /* functionality as ResourceResponse.getContentType"                    */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETCONTENTTYPE);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getLocale */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.getLocale must provide the same           */
      /* functionality as ResourceResponse.getLocale"                         */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETLOCALE);
      try {
         Locale hl = response.getLocale();
         Locale pl = ((MimeResponse)portletResp).getLocale();
         CompareUtils.stringsEqual(hl.getDisplayName(), pl.getDisplayName(), tr9);
      } catch(Exception e) {tr9.appendTcDetail(e.toString());}
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getOutputStream */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.getOutputStream must provide the same     */
      /* functionality as ResourceResponse.getPortletOutputStream"            */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_getWriter */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.getWriter must provide the same           */
      /* functionality as ResourceResponse.getWriter"                         */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_GETWRITER);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_isCommitted */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.isCommitted must provide the same         */
      /* functionality as ResourceResponse.isCommitted"                       */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_ISCOMMITTED);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_reset */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.reset must provide the same               */
      /* functionality as ResourceResponse.reset"                             */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_RESET);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_resetBuffer */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.resetBuffer must provide the same         */
      /* functionality as ResourceResponse.resetBuffer"                       */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_RESETBUFFER);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_sendError */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.sendError does not perform any            */
      /* operation"                                                           */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SENDERROR);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_sendRedirect */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.sendRedirect does not perform any         */
      /* operation"                                                           */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_setBufferSize */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.setBufferSize must provide the same       */
      /* functionality as ResourceResponse.setBufferSize"                     */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETBUFFERSIZE);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_setCharacterEncoding */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.setCharacterEncoding must provide the     */
      /* same functionality as ResourceResponse.setCharacterEncoding"         */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_setContentLength */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.setContentLength must provide the same    */
      /* functionality as ResourceResponse.setContentLength"                  */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_setContentType */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.setContentType must provide the same      */
      /* functionality as ResourceResponse.setContentType"                    */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests1_SPEC2_19_ForwardJSPResourceResponse_setLocale */
      /* Details: "In a target jsp of a forward in the Resource phase, the    */
      /* method HttpServletResponse.setLocale must provide the same           */
      /* functionality as ResourceResponse.setLocale"                         */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS1_SPEC2_19_FORWARDJSPRESOURCERESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

%>
