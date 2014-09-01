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
 * Used by portlet: FilterTests_PortletFilter_ApiResourceFilter
 *
 * @author nick
 *
 */
public class FilterTests_PortletFilter_ApiResourceFilter_filter implements ResourceFilter {
   private static final String LOG_CLASS = 
         FilterTests_PortletFilter_ApiResourceFilter_filter.class.getName();
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
   public void doFilter(ResourceRequest portletReq, ResourceResponse portletResp,
         FilterChain chain) throws IOException, PortletException {
      LOGGER.entering(LOG_CLASS, "doFilter");

      PrintWriter writer = portletResp.getWriter();

      // first execute the chain

      chain.doFilter(portletReq, portletResp);

      // now do the tests and write output

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(PortletFilter.class);

      /* TestCase: V2FilterTests_PortletFilter_ApiResourceFilter_initResource1 */
      /* Details: "The init(FilterConfig): method is called when an           */
      /* ResourceFilter is configured"                                        */
      TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2FilterTests_PortletFilter_ApiResourceFilter_initResource2 */
      /* Details: "The init(FilterConfig): method for an ResourceFilter is    */
      /* passed a FilterConfig object"                                        */
      TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2FilterTests_PortletFilter_ApiResourceFilter_initResource3 */
      /* Details: "If the init(FilterConfig): method for an ResourceFilter    */
      /* throws a PortletException, the filter is not placed in service"      */
      TestResult tr2 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_APIRESOURCEFILTER_INITRESOURCE3);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);


   }
}
