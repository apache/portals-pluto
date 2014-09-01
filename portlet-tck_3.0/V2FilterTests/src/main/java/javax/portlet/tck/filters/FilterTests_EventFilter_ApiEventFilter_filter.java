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
 * Used by portlet: FilterTests_EventFilter_ApiEventFilter
 *
 * @author nick
 *
 */
public class FilterTests_EventFilter_ApiEventFilter_filter implements EventFilter {
   private static final String LOG_CLASS = 
         FilterTests_EventFilter_ApiEventFilter_filter.class.getName();
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
   public void doFilter(EventRequest portletReq, EventResponse portletResp,
         FilterChain chain) throws IOException, PortletException {
      LOGGER.entering(LOG_CLASS, "doFilter");

      StringWriter writer = new StringWriter();

      // first execute the chain

      chain.doFilter(portletReq, portletResp);

      // now do the tests and write output

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      ClassChecker cc = new ClassChecker(EventFilter.class);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_canBeConfigured1  */
      /* Details: "An EventFilter can be configured in the portlet            */
      /* descriptor"                                                          */
      TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED1);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_canBeConfigured2  */
      /* Details: "Multiple EventFilter classes can be configured in the      */
      /* portlet descriptor"                                                  */
      TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED2);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterIsCalled  */
      /* Details: "The doFilter(EventRequest, EventResponse, FilterChain):    */
      /* method is called before the processEvent method for the portlet"     */
      TestResult tr2 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERISCALLED);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent1 */
      /* Details: "After the doFilter(EventRequest, EventResponse,            */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the processEventMethod is called"                       */
      TestResult tr3 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT1);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent2 */
      /* Details: "After the doFilter(EventRequest, EventResponse,            */
      /* FilterChain): method has sucessfully completed and invokes the       */
      /* next filter, the next filter in the chain is called if multiple      */
      /* filters are defined"                                                 */
      TestResult tr4 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERPROCESSEVENT2);
      /* TODO: implement test */
      tr4.appendTcDetail("Not implemented.");
      tr4.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterBlock     */
      /* Details: "If the doFilter(EventRequest, EventResponse,               */
      /* FilterChain): method does not invoke the next filter, processEvent   */
      /* is not called"                                                       */
      TestResult tr5 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTERBLOCK);
      /* TODO: implement test */
      tr5.appendTcDetail("Not implemented.");
      tr5.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterException1 */
      /* Details: "If the doFilter(EventRequest, EventResponse,               */
      /* FilterChain): method throws an UnavailableException, processEvent    */
      /* is not called"                                                       */
      TestResult tr6 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXCEPTION1);
      /* TODO: implement test */
      tr6.appendTcDetail("Not implemented.");
      tr6.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterException2 */
      /* Details: "If the doFilter(EventRequest, EventResponse,               */
      /* FilterChain): method throws an UnavailableException, no further      */
      /* filter is called"                                                    */
      TestResult tr7 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXCEPTION2);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterExamine   */
      /* Details: "Method doFilter(EventRequest, EventResponse,               */
      /* FilterChain): After the next filter has been successfully invoked,   */
      /* the EventResponse may be examined"                                   */
      TestResult tr8 = tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_DOFILTEREXAMINE);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      portletReq.getPortletSession().setAttribute(
                   Constants.RESULT_ATTR_PREFIX + "FilterTests_EventFilter_ApiEventFilter",
                   writer.toString(), APPLICATION_SCOPE);

   }
}
