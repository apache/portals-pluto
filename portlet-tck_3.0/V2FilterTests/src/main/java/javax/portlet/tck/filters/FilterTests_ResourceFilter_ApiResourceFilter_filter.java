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
 * Used by portlet: FilterTests_ResourceFilter_ApiResourceFilter
 *
 * @author nick
 *
 */
public class FilterTests_ResourceFilter_ApiResourceFilter_filter implements ResourceFilter {
   private static final String LOG_CLASS = 
         FilterTests_ResourceFilter_ApiResourceFilter_filter.class.getName();
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

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_canBeConfigured1 */
      /* Details: "An ResourceFilter can be configured in the portlet         */
      /* descriptor"                                                          */
      TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_canBeConfigured2 */
      /* Details: "Multiple ResourceFilter classes can be configured in the   */
      /* portlet descriptor"                                                  */
      TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_CANBECONFIGURED2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterIsCalled */
      /* Details: "The doFilter(ResourceRequest, ResourceResponse,            */
      /* FilterChain): method is called before the processResource method     */
      /* for the portlet"                                                     */
      TestResult tr2 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERISCALLED);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterProcessResource1 */
      /* Details: "After the doFilter(ResourceRequest, ResourceResponse,      */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the processResourceMethod is called"                    */
      TestResult tr3 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterProcessResource2 */
      /* Details: "After the doFilter(ResourceRequest, ResourceResponse,      */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the next filter in the chain is called if multiple      */
      /* filters are defined"                                                 */
      TestResult tr4 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERPROCESSRESOURCE2);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterBlock */
      /* Details: "If the doFilter(ResourceRequest, ResourceResponse,         */
      /* FilterChain): method does not invoke the next filter,                */
      /* processResource is not called"                                       */
      TestResult tr5 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTERBLOCK);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterException1 */
      /* Details: "If the doFilter(ResourceRequest, ResourceResponse,         */
      /* FilterChain): method throws an UnavailableException,                 */
      /* processResource is not called"                                       */
      TestResult tr6 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXCEPTION1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterException2 */
      /* Details: "If the doFilter(ResourceRequest, ResourceResponse,         */
      /* FilterChain): method throws an UnavailableException, no further      */
      /* filter is called"                                                    */
      TestResult tr7 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXCEPTION2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2FilterTests_ResourceFilter_ApiResourceFilter_doFilterExamine */
      /* Details: "Method doFilter(ResourceRequest, ResourceResponse,         */
      /* FilterChain): After the next filter has been successfully invoked,   */
      /* the ResourceResponse may be examined"                                */
      TestResult tr8 = tcd.getTestResultFailed(V2FILTERTESTS_RESOURCEFILTER_APIRESOURCEFILTER_DOFILTEREXAMINE);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);


   }
}
