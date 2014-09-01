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


package javax.portlet.tck.filters;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * Filter for JSR 362 request dispatcher testing.
 * Used by portlet: FilterTests_ActionFilter_ApiActionFilter
 *
 * @author nick
 *
 */
public class FilterTests_ActionFilter_ApiActionFilter_filter implements ActionFilter {
   private static final String LOG_CLASS = 
         FilterTests_ActionFilter_ApiActionFilter_filter.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

   private FilterConfig filterConfig;

   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
      this.filterConfig = filterConfig;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void doFilter(ActionRequest portletReq, ActionResponse portletResp,
         FilterChain chain) throws IOException, PortletException {
      LOGGER.entering(LOG_CLASS, "doFilter");

      StringWriter writer = new StringWriter();

      // first execute the chain

      chain.doFilter(portletReq, portletResp);

      // now do the tests and write output

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(ActionFilter.class);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured1 */
      /* Details: "An ActionFilter can be configured in the portlet           */
      /* descriptor"                                                          */
      TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_canBeConfigured2 */
      /* Details: "Multiple ActionFilter classes can be configured in the     */
      /* portlet descriptor"                                                  */
      TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_CANBECONFIGURED2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterIsCalled */
      /* Details: "The doFilter(ActionRequest, ActionResponse,                */
      /* FilterChain): method is called before the processAction method for   */
      /* the portlet"                                                         */
      TestResult tr2 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERISCALLED);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction1 */
      /* Details: "After the doFilter(ActionRequest, ActionResponse,          */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the processActionMethod is called"                      */
      TestResult tr3 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterProcessAction2 */
      /* Details: "After the doFilter(ActionRequest, ActionResponse,          */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the next filter in the chain is called if multiple      */
      /* filters are defined"                                                 */
      TestResult tr4 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERPROCESSACTION2);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterBlock   */
      /* Details: "If the doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): method does not invoke the next filter,                */
      /* processAction is not called"                                         */
      TestResult tr5 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTERBLOCK);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterException1 */
      /* Details: "If the doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): method throws an UnavailableException, processAction   */
      /* is not called"                                                       */
      TestResult tr6 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXCEPTION1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterException2 */
      /* Details: "If the doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): method throws an UnavailableException, no further      */
      /* filter is called"                                                    */
      TestResult tr7 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXCEPTION2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2FilterTests_ActionFilter_ApiActionFilter_doFilterExamine */
      /* Details: "Method doFilter(ActionRequest, ActionResponse,             */
      /* FilterChain): After the next filter has been successfully invoked,   */
      /* the ActionResponse may be examined"                                  */
      TestResult tr8 = tcd.getTestResultFailed(V2FILTERTESTS_ACTIONFILTER_APIACTIONFILTER_DOFILTEREXAMINE);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter",
                   writer.toString(), APPLICATION_SCOPE);

   }
}
