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

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.TestCaseDetails;
import javax.portlet.tck.beans.JSR286ApiTestCaseDetails;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import javax.portlet.tck.beans.TestResult;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the 
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 */
public class AddlFilterTests_SPEC2_20_PortletFilter implements Portlet {
   private static final String LOG_CLASS = 
         AddlFilterTests_SPEC2_20_PortletFilter.class.getName();
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
   public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
         throws PortletException, IOException {
   }

   @Override
   public void render(RenderRequest renderRequest, RenderResponse renderResponse)
         throws PortletException, IOException {
      
      if (LOGGER.isLoggable(Level.FINE)) {
         LOGGER.logp(Level.FINE, LOG_CLASS, "render", "Entry");
      }

      PrintWriter writer = renderResponse.getWriter();
      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: SPEC2_20_PortletFilter_filter1                             */
      /* Details: "A filter declaration can be configured in the deployment   */
      /* descriptor"                                                          */
      TestResult tr0 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER1);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter2                             */
      /* Details: "If the filter declaration specifies the <lifecycle> tag    */
      /* value ACTION_PHASE, the ActionFilter.doFilter method is called"      */
      TestResult tr1 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER2);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter3                             */
      /* Details: "If the filter declaration specifies the <lifecycle> tag    */
      /* value RENDER_PHASE, the RenderFilter.doFilter method is called"      */
      TestResult tr2 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER3);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter4                             */
      /* Details: "If the filter declaration specifies the <lifecycle> tag    */
      /* value EVENT_PHASE, the EventFilter.doFilter method is called"        */
      TestResult tr3 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER4);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter5                             */
      /* Details: "If the filter declaration specifies the <lifecycle> tag    */
      /* value RESOURCE_PHASE, the ResourceFilter.doFilter method is          */
      /* called"                                                              */
      TestResult tr4 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER5);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter6                             */
      /* Details: "A filter declaration can contain multiple <lifecycle>      */
      /* tags for a single filter class"                                      */
      TestResult tr5 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER6);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter7                             */
      /* Details: "The filter declaration can contain initialization          */
      /* parameters which can be read by the filter through the               */
      /* FilterConfig object"                                                 */
      TestResult tr6 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER7);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter8                             */
      /* Details: "For each filter declaration, the filter instance must      */
      /* receive all initialization parameters defined in the filter          */
      /* declaration"                                                         */
      TestResult tr7 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER8);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter9                             */
      /* Details: "For each filter declaration, the filter instance must      */
      /* receive only initialization parameters defined in the filter         */
      /* declaration"                                                         */
      TestResult tr8 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER9);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter10                            */
      /* Details: "For multiple filter declarations for a single filter       */
      /* class, the filter instance must receive all initialization           */
      /* parameters defined in the filter declaration"                        */
      TestResult tr9 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER10);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter11                            */
      /* Details: "For multiple filter declarations for a single filter       */
      /* class, the filter instance must receive only initialization          */
      /* parameters defined in the filter declaration"                        */
      TestResult tr10 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER11);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter12                            */
      /* Details: "A filter class can appear in multiple filter               */
      /* declarations, and is instantiated once for each filter declaration   */
      /* in which it appears"                                                 */
      TestResult tr11 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER12);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter13                            */
      /* Details: "A filter declaration can be mapped to a portlet through    */
      /* the deployment descriptor <filter-mapping> element"                  */
      TestResult tr12 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER13);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter14                            */
      /* Details: "Filters can be associated with groups of portlets using    */
      /* the '*' character as a wildcard at the end of a string to indicate   */
      /* that the filter must be applied to any portlet whose name starts     */
      /* with the characters before the \"*\" character"                      */
      TestResult tr13 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER14);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filter15                            */
      /* Details: "The order the container uses in building the chain of      */
      /* filters to be applied for a particular request is the order in       */
      /* which the <portlet-name> matching filter mappings appear in the      */
      /* deployment descriptor"                                               */
      TestResult tr14 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTER15);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper1                      */
      /* Details: "An ACTION_PHASE filter can wrap the ActionRequest object   */
      /* with a custom wrapper"                                               */
      TestResult tr15 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER1);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper2                      */
      /* Details: "An ACTION_PHASE filter can wrap the ActionResponse         */
      /* object with a custom wrapper"                                        */
      TestResult tr16 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER2);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper3                      */
      /* Details: "An EVENT_PHASE filter can wrap the EventRequest object     */
      /* with a custom wrapper"                                               */
      TestResult tr17 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER3);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper4                      */
      /* Details: "An EVENT_PHASE filter can wrap the EventResponse object    */
      /* with a custom wrapper"                                               */
      TestResult tr18 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER4);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper5                      */
      /* Details: "An RENDER_PHASE filter can wrap the RenderRequest object   */
      /* with a custom wrapper"                                               */
      TestResult tr19 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER5);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper6                      */
      /* Details: "An RENDER_PHASE filter can wrap the RenderResponse         */
      /* object with a custom wrapper"                                        */
      TestResult tr20 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER6);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper7                      */
      /* Details: "An RESOURCE_PHASE filter can wrap the ResourceRequest      */
      /* object with a custom wrapper"                                        */
      TestResult tr21 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER7);
      /* TODO: implement test */

      /* TestCase: SPEC2_20_PortletFilter_filterWrapper8                      */
      /* Details: "An RESOURCE_PHASE filter can wrap the ResourceResponse     */
      /* object with a custom wrapper"                                        */
      TestResult tr22 = tcd.getTestResultFailed(SPEC2_20_PORTLETFILTER_FILTERWRAPPER8);
      /* TODO: implement test */



      // Write the results to the output stream

      tr0.writeTo(writer);
      tr1.writeTo(writer);
      tr2.writeTo(writer);
      tr3.writeTo(writer);
      tr4.writeTo(writer);
      tr5.writeTo(writer);
      tr6.writeTo(writer);
      tr7.writeTo(writer);
      tr8.writeTo(writer);
      tr9.writeTo(writer);
      tr10.writeTo(writer);
      tr11.writeTo(writer);
      tr12.writeTo(writer);
      tr13.writeTo(writer);
      tr14.writeTo(writer);
      tr15.writeTo(writer);
      tr16.writeTo(writer);
      tr17.writeTo(writer);
      tr18.writeTo(writer);
      tr19.writeTo(writer);
      tr20.writeTo(writer);
      tr21.writeTo(writer);
      tr22.writeTo(writer);


   }

}

