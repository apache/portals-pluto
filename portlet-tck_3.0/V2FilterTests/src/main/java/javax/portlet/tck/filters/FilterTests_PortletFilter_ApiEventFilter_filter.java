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
 * Used by portlet: FilterTests_PortletFilter_ApiEventFilter
 *
 * @author nick
 *
 */
public class FilterTests_PortletFilter_ApiEventFilter_filter implements EventFilter {
   private static final String LOG_CLASS = 
         FilterTests_PortletFilter_ApiEventFilter_filter.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

   private FilterConfig filterConfig;
   private boolean initCalled = false;

   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
      this.filterConfig = filterConfig;
      initCalled=true;
   }

   @Override
   public void destroy() {
   }

   @Override
   public void doFilter(EventRequest portletReq, EventResponse portletResp,
         FilterChain chain) throws IOException, PortletException {
      LOGGER.entering(LOG_CLASS, "doFilter");

      StringWriter writer = new StringWriter();

      // first execute the chain

      chain.doFilter(portletReq, portletResp);

      // now do the tests and write output

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(PortletFilter.class);

      /* TestCase: V2FilterTests_PortletFilter_ApiEventFilter_initEvent1      */
      /* Details: "The init(FilterConfig): method is called when an           */
      /* EventFilter is configured"                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT1);
      if(initCalled==true) {
    	  tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);

      /* TestCase: V2FilterTests_PortletFilter_ApiEventFilter_initEvent2      */
      /* Details: "The init(FilterConfig): method for an EventFilter is       */
      /* passed a FilterConfig object"                                        */
      TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT2);
      if(this.filterConfig==filterConfig) {
    	  tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      /* TestCase: V2FilterTests_PortletFilter_ApiEventFilter_initEvent3      */
      /* Details: "If the init(FilterConfig): method for an EventFilter       */
      /* throws a PortletException, the filter is not placed in service"      */
      TestResult tr2 = tcd.getTestResultSucceeded(V2FILTERTESTS_PORTLETFILTER_APIEVENTFILTER_INITEVENT3);
      tr2.appendTcDetail("This Method could not be Tested for Filter Portlet which is already placed in service");
      tr2.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "FilterTests_PortletFilter_ApiEventFilter",
                   writer.toString(), APPLICATION_SCOPE);

   }
}
