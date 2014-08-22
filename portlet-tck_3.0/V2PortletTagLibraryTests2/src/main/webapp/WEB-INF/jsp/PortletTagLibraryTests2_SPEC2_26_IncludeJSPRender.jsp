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

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender1 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable RenderRequest renderRequest to the              */
      /* corresponding object"                                                */
      TestResult tr0 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender2 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ResourceRequest resourceRequest to be null or   */
      /* undefined"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender3 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ActionRequest actionRequest to be null or       */
      /* undefined"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender4 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable EventRequest eventRequest to be null or         */
      /* undefined"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER4);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender5 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable RenderResponse renderResponse to the            */
      /* corresponding object"                                                */
      TestResult tr4 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER5);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender6 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ResourceResponse resourceResponse to be null    */
      /* or undefined"                                                        */
      TestResult tr5 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER6);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender7 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable ActionResponse actionResponse to be null or     */
      /* undefined"                                                           */
      TestResult tr6 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER7);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender8 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable EventResponse eventResponse to be null or       */
      /* undefined"                                                           */
      TestResult tr7 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER8);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender9 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable PortletConfig portletConfig"                    */
      TestResult tr8 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER9);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender10 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable PortletSession portletSession, providing        */
      /* access to the portletSession, does not create a new session, only    */
      /* returns an existing session or null if no session exists."           */
      TestResult tr9 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER10);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender11 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable Map<String, Object> portletSessionScope,        */
      /* providing access to the portletSession attributes as a Map           */
      /* equivalent to the PortletSession.getAttributeMap() call, does not    */
      /* create a new session, only returns an existing session. If no        */
      /* session attributes exist this method returns an empty Map."          */
      TestResult tr10 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER11);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender12 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable PortletPreferences portletPreferences,          */
      /* providing access to the portlet preferences."                        */
      TestResult tr11 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER12);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_defineObjectsRender13 */
      /* Details: "When included in the Render phase, the defineObjects tag   */
      /* defines the variable Map<String, String[]>                           */
      /* portletPreferencesValues, providing access to the portlet            */
      /* preferences as a Map, equivalent to the                              */
      /* PortletPreferences.getMap() call. If no portlet preferences exist,   */
      /* the Map is empty."                                                   */
      TestResult tr12 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_DEFINEOBJECTSRENDER13);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL1 */
      /* Details: "The portlet actionURL tag creates a URL that must point    */
      /* to the current portlet and must trigger an action request with the   */
      /* supplied parameters"                                                 */
      TestResult tr13 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL1);
      /* TODO: implement test */
      tr13.appendTcDetail("Not implemented.");
      tr13.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL2 */
      /* Details: "Parameters may be added to the URL by including the        */
      /* param tag between the actionURL start and end tags"                  */
      TestResult tr14 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL2);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL3 */
      /* Details: "The optional actionURL \"windowState\" attribute can       */
      /* specify the desired window state after the URL is triggered"         */
      TestResult tr15 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL3);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL4 */
      /* Details: "If the \"windowState\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr16 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL4);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL5 */
      /* Details: "The \"windowState\" attribute is not case sensitive"       */
      TestResult tr17 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL5);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL6 */
      /* Details: "The \"windowState\" attribute is not specified, the        */
      /* current window state is retained when the URL is triggered"          */
      TestResult tr18 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL6);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL7 */
      /* Details: "The optional actionURL \"portletMode\" attribute can       */
      /* specify the desired portlet mode after the URL is triggered"         */
      TestResult tr19 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL7);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL8 */
      /* Details: "If the \"portletMode\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr20 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL8);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL9 */
      /* Details: "The \"portletMode\" attribute is not case sensitive"       */
      TestResult tr21 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL9);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL10 */
      /* Details: "The \"portletMode\" attribute is not specified, the        */
      /* current portlet mode is retained when the URL is triggered"          */
      TestResult tr22 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL10);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL11 */
      /* Details: "The optional actionURL \"var\" attribute can specify a     */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr23 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL11);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL12 */
      /* Details: "If the actionURL \"var\" attribute is specified, the URL   */
      /* is not written to the JspWriter"                                     */
      TestResult tr24 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL12);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL13 */
      /* Details: "If the actionURL \"var\" attribute is not specified, the   */
      /* URL is written to the JspWriter"                                     */
      TestResult tr25 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL13);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL14 */
      /* Details: "If the optional actionURL \"secure\" attribute is set to   */
      /* true, the resulting URL should require a secure connection"          */
      TestResult tr26 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL14);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL15 */
      /* Details: "If the optional actionURL \"secure\" attribute is set to   */
      /* false, the resulting URL does not need to require a secure           */
      /* connection"                                                          */
      TestResult tr27 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL15);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL17 */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr28 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL17);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL18 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr29 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL18);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL19 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* are merged with the render parameters"                               */
      TestResult tr30 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL19);
      /* TODO: implement test */
      tr30.appendTcDetail("Not implemented.");
      tr30.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL20 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* appear in the values array before the render parameter values if     */
      /* there is a name conflict"                                            */
      TestResult tr31 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL20);
      /* TODO: implement test */
      tr31.appendTcDetail("Not implemented.");
      tr31.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL21 */
      /* Details: "If the optional actionURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr32 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL21);
      /* TODO: implement test */
      tr32.appendTcDetail("Not implemented.");
      tr32.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL22 */
      /* Details: "If the \"copyCurrentRenderParameters\" attribute           */
      /* specifies an invalid value, a JspException is thrown"                */
      TestResult tr33 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL22);
      /* TODO: implement test */
      tr33.appendTcDetail("Not implemented.");
      tr33.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL23 */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr34 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL23);
      /* TODO: implement test */
      tr34.appendTcDetail("Not implemented.");
      tr34.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL25 */
      /* Details: "If the optional actionURL \"escapeXML\" attribute is set   */
      /* to false, the characters \"<>&'\\\"\" are not converted to their     */
      /* entity codes"                                                        */
      TestResult tr35 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL25);
      /* TODO: implement test */
      tr35.appendTcDetail("Not implemented.");
      tr35.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL26 */
      /* Details: "The \"escapeXML\" attribute default value is true"         */
      TestResult tr36 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL26);
      /* TODO: implement test */
      tr36.appendTcDetail("Not implemented.");
      tr36.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL27 */
      /* Details: "If the optional actionURL \"name\" attribute is set, the   */
      /* provided name string is used by GenericPortlet to dispatch the       */
      /* request to the coresponding annotated method"                        */
      TestResult tr37 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL27);
      /* TODO: implement test */
      tr37.appendTcDetail("Not implemented.");
      tr37.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL28 */
      /* Details: "Setting the \"name\" attribute will add a parameter to     */
      /* the action URL with the name of \"javax.portlet.action\""            */
      TestResult tr38 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL28);
      /* TODO: implement test */
      tr38.appendTcDetail("Not implemented.");
      tr38.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL29 */
      /* Details: "If this tag is used in markup provided by a                */
      /* serveResource call that was directly or indirectly triggered via a   */
      /* resource URL of type FULL, a JspException with the                   */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr39 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL29);
      /* TODO: implement test */
      tr39.appendTcDetail("Not implemented.");
      tr39.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_actionURL30 */
      /* Details: "If this tag is used in markup provided by a                */
      /* serveResource call that was directly or indirectly triggered via a   */
      /* resource URL of type PORTLET, a JspException with the                */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr40 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_ACTIONURL30);
      /* TODO: implement test */
      tr40.appendTcDetail("Not implemented.");
      tr40.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL1 */
      /* Details: "The portlet renderURL tag creates a URL that must point    */
      /* to the current portlet and must trigger an render request with the   */
      /* supplied parameters"                                                 */
      TestResult tr41 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL1);
      /* TODO: implement test */
      tr41.appendTcDetail("Not implemented.");
      tr41.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL2 */
      /* Details: "Parameters may be added to the URL by including the        */
      /* param tag between the renderURL start and end tags"                  */
      TestResult tr42 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL2);
      /* TODO: implement test */
      tr42.appendTcDetail("Not implemented.");
      tr42.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL3 */
      /* Details: "The optional renderURL \"windowState\" attribute can       */
      /* specify the desired window state after the URL is triggered"         */
      TestResult tr43 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL3);
      /* TODO: implement test */
      tr43.appendTcDetail("Not implemented.");
      tr43.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL4 */
      /* Details: "If the \"windowState\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr44 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL4);
      /* TODO: implement test */
      tr44.appendTcDetail("Not implemented.");
      tr44.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL5 */
      /* Details: "The \"windowState\" attribute is not case sensitive"       */
      TestResult tr45 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL5);
      /* TODO: implement test */
      tr45.appendTcDetail("Not implemented.");
      tr45.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL6 */
      /* Details: "The \"windowState\" attribute is not specified, the        */
      /* current window state is retained when the URL is triggered"          */
      TestResult tr46 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL6);
      /* TODO: implement test */
      tr46.appendTcDetail("Not implemented.");
      tr46.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL7 */
      /* Details: "The optional renderURL \"portletMode\" attribute can       */
      /* specify the desired portlet mode after the URL is triggered"         */
      TestResult tr47 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL7);
      /* TODO: implement test */
      tr47.appendTcDetail("Not implemented.");
      tr47.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL8 */
      /* Details: "If the \"portletMode\" attribute specifies an invalid      */
      /* value, a JspException with the PortletException that caused this     */
      /* error as root cause is thrown"                                       */
      TestResult tr48 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL8);
      /* TODO: implement test */
      tr48.appendTcDetail("Not implemented.");
      tr48.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL9 */
      /* Details: "The \"portletMode\" attribute is not case sensitive"       */
      TestResult tr49 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL9);
      /* TODO: implement test */
      tr49.appendTcDetail("Not implemented.");
      tr49.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL10 */
      /* Details: "The \"portletMode\" attribute is not specified, the        */
      /* current portlet mode is retained when the URL is triggered"          */
      TestResult tr50 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL10);
      /* TODO: implement test */
      tr50.appendTcDetail("Not implemented.");
      tr50.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL11 */
      /* Details: "The optional renderURL \"var\" attribute can specify a     */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr51 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL11);
      /* TODO: implement test */
      tr51.appendTcDetail("Not implemented.");
      tr51.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL12 */
      /* Details: "If the renderURL \"var\" attribute is specified, the URL   */
      /* is not written to the JspWriter"                                     */
      TestResult tr52 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL12);
      /* TODO: implement test */
      tr52.appendTcDetail("Not implemented.");
      tr52.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL13 */
      /* Details: "If the renderURL \"var\" attribute is not specified, the   */
      /* URL is written to the JspWriter"                                     */
      TestResult tr53 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL13);
      /* TODO: implement test */
      tr53.appendTcDetail("Not implemented.");
      tr53.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL14 */
      /* Details: "If the optional renderURL \"secure\" attribute is set to   */
      /* true, the resulting URL should require a secure connection"          */
      TestResult tr54 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL14);
      /* TODO: implement test */
      tr54.appendTcDetail("Not implemented.");
      tr54.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL15 */
      /* Details: "If the optional renderURL \"secure\" attribute is set to   */
      /* false, the resulting URL does not need to require a secure           */
      /* connection"                                                          */
      TestResult tr55 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL15);
      /* TODO: implement test */
      tr55.appendTcDetail("Not implemented.");
      tr55.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL17 */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr56 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL17);
      /* TODO: implement test */
      tr56.appendTcDetail("Not implemented.");
      tr56.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL18 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr57 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL18);
      /* TODO: implement test */
      tr57.appendTcDetail("Not implemented.");
      tr57.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL19 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* are merged with the render parameters"                               */
      TestResult tr58 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL19);
      /* TODO: implement test */
      tr58.appendTcDetail("Not implemented.");
      tr58.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL20 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* appear in the values array before the render parameter values if     */
      /* there is a name conflict"                                            */
      TestResult tr59 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL20);
      /* TODO: implement test */
      tr59.appendTcDetail("Not implemented.");
      tr59.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL21 */
      /* Details: "If the optional renderURL                                  */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr60 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL21);
      /* TODO: implement test */
      tr60.appendTcDetail("Not implemented.");
      tr60.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL22 */
      /* Details: "If the \"copyCurrentRenderParameters\" attribute           */
      /* specifies an invalid value, a JspException is thrown"                */
      TestResult tr61 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL22);
      /* TODO: implement test */
      tr61.appendTcDetail("Not implemented.");
      tr61.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL23 */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr62 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL23);
      /* TODO: implement test */
      tr62.appendTcDetail("Not implemented.");
      tr62.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL25 */
      /* Details: "If the optional renderURL \"escapeXML\" attribute is set   */
      /* to false, the characters \"<>&'\\\"\" are not converted to their     */
      /* entity codes"                                                        */
      TestResult tr63 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL25);
      /* TODO: implement test */
      tr63.appendTcDetail("Not implemented.");
      tr63.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_renderURL26 */
      /* Details: "The \"escapeXML\" attribute default value is true"         */
      TestResult tr64 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RENDERURL26);
      /* TODO: implement test */
      tr64.appendTcDetail("Not implemented.");
      tr64.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL1 */
      /* Details: "The portlet resourceURL tag creates a URL that must        */
      /* point to the current portlet and must trigger an resource request    */
      /* with the supplied parameters"                                        */
      TestResult tr65 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL1);
      /* TODO: implement test */
      tr65.appendTcDetail("Not implemented.");
      tr65.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL2 */
      /* Details: "The resourceURL must preserve the current portlet mode,    */
      /* window state and render parameters"                                  */
      TestResult tr66 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL2);
      /* TODO: implement test */
      tr66.appendTcDetail("Not implemented.");
      tr66.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL3 */
      /* Details: "Resource parameters may be added to the URL by including   */
      /* the param tag between the resourceURL start and end tags"            */
      TestResult tr67 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL3);
      /* TODO: implement test */
      tr67.appendTcDetail("Not implemented.");
      tr67.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL4 */
      /* Details: "The resource parameters specified with the                 */
      /* <portlet:param> element appear in the values array before the        */
      /* render parameter values if there is a name conflict"                 */
      TestResult tr68 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL4);
      /* TODO: implement test */
      tr68.appendTcDetail("Not implemented.");
      tr68.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL5 */
      /* Details: "The optional resourceURL \"var\" attribute can specify a   */
      /* scoped variable for exporting the action URL"                        */
      TestResult tr69 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL5);
      /* TODO: implement test */
      tr69.appendTcDetail("Not implemented.");
      tr69.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL6 */
      /* Details: "If the resourceURL \"var\" attribute is specified, the     */
      /* URL is not written to the JspWriter"                                 */
      TestResult tr70 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL6);
      /* TODO: implement test */
      tr70.appendTcDetail("Not implemented.");
      tr70.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL7 */
      /* Details: "If the resourceURL \"var\" attribute is not specified,     */
      /* the URL is written to the JspWriter"                                 */
      TestResult tr71 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL7);
      /* TODO: implement test */
      tr71.appendTcDetail("Not implemented.");
      tr71.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL8 */
      /* Details: "If the optional resourceURL \"secure\" attribute is set    */
      /* to true, the resulting URL should require a secure connection"       */
      TestResult tr72 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL8);
      /* TODO: implement test */
      tr72.appendTcDetail("Not implemented.");
      tr72.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL9 */
      /* Details: "If the optional resourceURL \"secure\" attribute is set    */
      /* to false, the resulting URL does not need to require a secure        */
      /* connection"                                                          */
      TestResult tr73 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL9);
      /* TODO: implement test */
      tr73.appendTcDetail("Not implemented.");
      tr73.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL11 */
      /* Details: "The \"secure\" attribute is not specified, the security    */
      /* setting is retained"                                                 */
      TestResult tr74 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL11);
      /* TODO: implement test */
      tr74.appendTcDetail("Not implemented.");
      tr74.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL12 */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to true, the        */
      /* current private render parameters are attached to the URL"           */
      TestResult tr75 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL12);
      /* TODO: implement test */
      tr75.appendTcDetail("Not implemented.");
      tr75.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL13 */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* are merged with the render parameters"                               */
      TestResult tr76 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL13);
      /* TODO: implement test */
      tr76.appendTcDetail("Not implemented.");
      tr76.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL14 */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to true,            */
      /* additional parameters specified with the <portlet:param> element     */
      /* appear in the values array before the render parameter values if     */
      /* there is a name conflict"                                            */
      TestResult tr77 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL14);
      /* TODO: implement test */
      tr77.appendTcDetail("Not implemented.");
      tr77.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL15 */
      /* Details: "If the optional resourceURL                                */
      /* \"copyCurrentRenderParameters\" attribute is set to false, the       */
      /* current render parameters are not attached to the URL"               */
      TestResult tr78 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL15);
      /* TODO: implement test */
      tr78.appendTcDetail("Not implemented.");
      tr78.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL16 */
      /* Details: "If the \"copyCurrentRenderParameters\" attribute           */
      /* specifies an invalid value, a JspException is thrown"                */
      TestResult tr79 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL16);
      /* TODO: implement test */
      tr79.appendTcDetail("Not implemented.");
      tr79.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL17 */
      /* Details: "The \"copyCurrentRenderParameters\" attribute is not       */
      /* specified, the security setting is retained"                         */
      TestResult tr80 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL17);
      /* TODO: implement test */
      tr80.appendTcDetail("Not implemented.");
      tr80.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL19 */
      /* Details: "If the optional resourceURL \"escapeXML\" attribute is     */
      /* set to false, the characters \"<>&'\\\"\" are not converted to       */
      /* their entity codes"                                                  */
      TestResult tr81 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL19);
      /* TODO: implement test */
      tr81.appendTcDetail("Not implemented.");
      tr81.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL20 */
      /* Details: "The \"escapeXML\" attribute default value is true"         */
      TestResult tr82 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL20);
      /* TODO: implement test */
      tr82.appendTcDetail("Not implemented.");
      tr82.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL21 */
      /* Details: "If the optional resourceURL \"id\" attribute is set, the   */
      /* provided id string is used by GenericPortlet to dispatch the         */
      /* request to the coresponding annotated method"                        */
      TestResult tr83 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL21);
      /* TODO: implement test */
      tr83.appendTcDetail("Not implemented.");
      tr83.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL22 */
      /* Details: "Setting the \"id\" attribute will add a parameter to the   */
      /* action URL with the id of \"javax.portlet.action\""                  */
      TestResult tr84 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL22);
      /* TODO: implement test */
      tr84.appendTcDetail("Not implemented.");
      tr84.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL23 */
      /* Details: "If the optional resourceURL \"cacheability\" attribute     */
      /* is set, the cacheability is set accordingly"                         */
      TestResult tr85 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL23);
      /* TODO: implement test */
      tr85.appendTcDetail("Not implemented.");
      tr85.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL24 */
      /* Details: "If the optional resourceURL \"cacheability\" attribute     */
      /* is not set, the current cacheability setting is retained"            */
      TestResult tr86 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL24);
      /* TODO: implement test */
      tr86.appendTcDetail("Not implemented.");
      tr86.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL25 */
      /* Details: "If the cacheability is set to PAGE in a Resource phase     */
      /* include with cacheability = FULL, a JspException with the            */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr87 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL25);
      /* TODO: implement test */
      tr87.appendTcDetail("Not implemented.");
      tr87.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL26 */
      /* Details: "If the cacheability is set to PORTLET in a Resource        */
      /* phase include with cacheability = FULL, a JspException with the      */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr88 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL26);
      /* TODO: implement test */
      tr88.appendTcDetail("Not implemented.");
      tr88.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_resourceURL27 */
      /* Details: "If the cacheability is set to PAGE in a Resource phase     */
      /* include with cacheability = PORTLET, a JspException with the         */
      /* IllegalStateException that caused this error is thrown"              */
      TestResult tr89 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_RESOURCEURL27);
      /* TODO: implement test */
      tr89.appendTcDetail("Not implemented.");
      tr89.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction1 */
      /* Details: "The param tag can be used within the actionURL tag to      */
      /* add a parameter"                                                     */
      TestResult tr90 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION1);
      /* TODO: implement test */
      tr90.appendTcDetail("Not implemented.");
      tr90.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction2 */
      /* Details: "The param tag required attribute \"name\" defines the      */
      /* parameter name"                                                      */
      TestResult tr91 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION2);
      /* TODO: implement test */
      tr91.appendTcDetail("Not implemented.");
      tr91.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction3 */
      /* Details: "If more than one tags appear in the actionURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the actionURL tag"                                 */
      TestResult tr92 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION3);
      /* TODO: implement test */
      tr92.appendTcDetail("Not implemented.");
      tr92.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr93 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION4);
      /* TODO: implement test */
      tr93.appendTcDetail("Not implemented.");
      tr93.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction5 */
      /* Details: "The param tag required attribute \"value\" defines the     */
      /* parameter value"                                                     */
      TestResult tr94 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION5);
      /* TODO: implement test */
      tr94.appendTcDetail("Not implemented.");
      tr94.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramAction6 */
      /* Details: "If the \"value\" attribute is null or empty, the           */
      /* parameter is removed"                                                */
      TestResult tr95 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMACTION6);
      /* TODO: implement test */
      tr95.appendTcDetail("Not implemented.");
      tr95.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender1 */
      /* Details: "The param tag can be used within the renderURL tag to      */
      /* add a parameter"                                                     */
      TestResult tr96 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER1);
      /* TODO: implement test */
      tr96.appendTcDetail("Not implemented.");
      tr96.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender2 */
      /* Details: "The param tag required attribute \"name\" defines the      */
      /* parameter name"                                                      */
      TestResult tr97 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER2);
      /* TODO: implement test */
      tr97.appendTcDetail("Not implemented.");
      tr97.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender3 */
      /* Details: "If more than one tags appear in the renderURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the renderURL tag"                                 */
      TestResult tr98 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER3);
      /* TODO: implement test */
      tr98.appendTcDetail("Not implemented.");
      tr98.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr99 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER4);
      /* TODO: implement test */
      tr99.appendTcDetail("Not implemented.");
      tr99.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender5 */
      /* Details: "The param tag required attribute \"value\" defines the     */
      /* parameter value"                                                     */
      TestResult tr100 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER5);
      /* TODO: implement test */
      tr100.appendTcDetail("Not implemented.");
      tr100.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramRender6 */
      /* Details: "If the \"value\" attribute is null or empty, the           */
      /* parameter is removed"                                                */
      TestResult tr101 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRENDER6);
      /* TODO: implement test */
      tr101.appendTcDetail("Not implemented.");
      tr101.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource1 */
      /* Details: "The param tag can be used within the resourceURL tag to    */
      /* add a parameter"                                                     */
      TestResult tr102 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE1);
      /* TODO: implement test */
      tr102.appendTcDetail("Not implemented.");
      tr102.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource2 */
      /* Details: "The param tag required attribute \"name\" defines the      */
      /* parameter name"                                                      */
      TestResult tr103 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE2);
      /* TODO: implement test */
      tr103.appendTcDetail("Not implemented.");
      tr103.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource3 */
      /* Details: "If more than one tags appear in the resourceURL tag, the   */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the resourceURL tag"                               */
      TestResult tr104 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE3);
      /* TODO: implement test */
      tr104.appendTcDetail("Not implemented.");
      tr104.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr105 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE4);
      /* TODO: implement test */
      tr105.appendTcDetail("Not implemented.");
      tr105.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource5 */
      /* Details: "The param tag required attribute \"value\" defines the     */
      /* parameter value"                                                     */
      TestResult tr106 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE5);
      /* TODO: implement test */
      tr106.appendTcDetail("Not implemented.");
      tr106.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_paramResource6 */
      /* Details: "If the \"value\" attribute is null or empty, no action     */
      /* is performed"                                                        */
      TestResult tr107 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PARAMRESOURCE6);
      /* TODO: implement test */
      tr107.appendTcDetail("Not implemented.");
      tr107.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction1 */
      /* Details: "The property tag can be used within the actionURL tag to   */
      /* add a property"                                                      */
      TestResult tr108 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION1);
      /* TODO: implement test */
      tr108.appendTcDetail("Not implemented.");
      tr108.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction2 */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr109 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION2);
      /* TODO: implement test */
      tr109.appendTcDetail("Not implemented.");
      tr109.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction3 */
      /* Details: "If more than one tags appear in the actionURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the actionURL tag"                                 */
      TestResult tr110 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION3);
      /* TODO: implement test */
      tr110.appendTcDetail("Not implemented.");
      tr110.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr111 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION4);
      /* TODO: implement test */
      tr111.appendTcDetail("Not implemented.");
      tr111.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction5 */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr112 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION5);
      /* TODO: implement test */
      tr112.appendTcDetail("Not implemented.");
      tr112.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyAction6 */
      /* Details: "If the \"value\" attribute is null or empty,  the          */
      /* property value is set to null"                                       */
      TestResult tr113 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYACTION6);
      /* TODO: implement test */
      tr113.appendTcDetail("Not implemented.");
      tr113.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender1 */
      /* Details: "The property tag can be used within the renderURL tag to   */
      /* add a property"                                                      */
      TestResult tr114 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER1);
      /* TODO: implement test */
      tr114.appendTcDetail("Not implemented.");
      tr114.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender2 */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr115 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER2);
      /* TODO: implement test */
      tr115.appendTcDetail("Not implemented.");
      tr115.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender3 */
      /* Details: "If more than one tags appear in the renderURL tag, the     */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the renderURL tag"                                 */
      TestResult tr116 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER3);
      /* TODO: implement test */
      tr116.appendTcDetail("Not implemented.");
      tr116.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr117 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER4);
      /* TODO: implement test */
      tr117.appendTcDetail("Not implemented.");
      tr117.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender5 */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr118 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER5);
      /* TODO: implement test */
      tr118.appendTcDetail("Not implemented.");
      tr118.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyRender6 */
      /* Details: "If the \"value\" attribute is null or empty,  the          */
      /* property value is set to null"                                       */
      TestResult tr119 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRENDER6);
      /* TODO: implement test */
      tr119.appendTcDetail("Not implemented.");
      tr119.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource1 */
      /* Details: "The property tag can be used within the resourceURL tag    */
      /* to add a property"                                                   */
      TestResult tr120 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE1);
      /* TODO: implement test */
      tr120.appendTcDetail("Not implemented.");
      tr120.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource2 */
      /* Details: "The property tag required attribute \"name\" defines the   */
      /* property name"                                                       */
      TestResult tr121 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE2);
      /* TODO: implement test */
      tr121.appendTcDetail("Not implemented.");
      tr121.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource3 */
      /* Details: "If more than one tags appear in the resourceURL tag, the   */
      /* values must be stored as a multivalued array in order of             */
      /* appearance within the resourceURL tag"                               */
      TestResult tr122 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE3);
      /* TODO: implement test */
      tr122.appendTcDetail("Not implemented.");
      tr122.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource4 */
      /* Details: "If the \"name\" attribute is null or empty, no action is   */
      /* performed"                                                           */
      TestResult tr123 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE4);
      /* TODO: implement test */
      tr123.appendTcDetail("Not implemented.");
      tr123.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource5 */
      /* Details: "The property tag required attribute \"value\" defines      */
      /* the property value"                                                  */
      TestResult tr124 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE5);
      /* TODO: implement test */
      tr124.appendTcDetail("Not implemented.");
      tr124.writeTo(writer);

      /* TestCase: V2PortletTagLibraryTests2_SPEC2_26_IncludeJSPRender_propertyResource6 */
      /* Details: "If the \"value\" attribute is null or empty, the           */
      /* property value is set to null"                                       */
      TestResult tr125 = tcd.getTestResultFailed(V2PORTLETTAGLIBRARYTESTS2_SPEC2_26_INCLUDEJSPRENDER_PROPERTYRESOURCE6);
      /* TODO: implement test */
      tr125.appendTcDetail("Not implemented.");
      tr125.writeTo(writer);

%>
