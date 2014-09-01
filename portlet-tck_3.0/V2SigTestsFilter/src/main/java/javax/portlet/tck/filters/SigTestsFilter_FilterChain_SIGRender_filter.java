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

import java.io.IOException;

import java.io.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.*;
import static javax.portlet.tck.constants.Constants.*;

/**
 * Render filter for TCK signature tests
 * 
 * @author nick
 *
 */
public class SigTestsFilter_FilterChain_SIGRender_filter implements
      RenderFilter {
   private static final String LOG_CLASS = 
         SigTestsFilter_FilterChain_SIGRender_filter.class.getName();
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
   public void doFilter(RenderRequest request, RenderResponse response,
         FilterChain chain) throws IOException, PortletException {
      LOGGER.entering(LOG_CLASS, "doFilter");
      
      // first execute the chain
      
      chain.doFilter(request, response);

      // now do the tests and write output
      
      PrintWriter writer = response.getWriter();
      JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();
      ClassChecker cc = new ClassChecker(chain.getClass());

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilter         */
      /* Details: "FilterChain has a doFilter(ActionRequest,                  */
      /* ActionResponse) throws java.io.IOException, PortletException         */
      /* method "                                                             */
      TestResult tr0 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTER);
      try {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
         tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr0.appendTcDetail(e.toString());}
      tr0.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterA        */
      /* Details: "FilterChain has a doFilter(EventRequest, EventResponse)    */
      /* throws java.io.IOException, PortletException method "                */
      TestResult tr1 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERA);
      try {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {EventRequest.class, EventResponse.class};
         tr1.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr1.appendTcDetail(e.toString());}
      tr1.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterB        */
      /* Details: "FilterChain has a doFilter(RenderRequest,                  */
      /* RenderResponse) throws java.io.IOException, PortletException         */
      /* method "                                                             */
      TestResult tr2 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERB);
      try {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr2.appendTcDetail(e.toString());}
      tr2.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterC        */
      /* Details: "FilterChain has a doFilter(ResourceRequest,                */
      /* ResourceResponse) throws java.io.IOException, PortletException       */
      /* method "                                                             */
      TestResult tr3 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERC);
      try {
         String name = "doFilter";
         Class<?>[] exceptions = {java.io.IOException.class, PortletException.class};
         Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
         tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
      } catch(Exception e) {tr3.appendTcDetail(e.toString());}
      tr3.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturns  */
      /* Details: "FilterChain method doFilter(ActionRequest,                 */
      /* ActionResponse) returns void "                                       */
      TestResult tr4 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNS);
      try {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {ActionRequest.class, ActionResponse.class};
         tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturnsA */
      /* Details: "FilterChain method doFilter(EventRequest, EventResponse)   */
      /* returns void "                                                       */
      TestResult tr5 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSA);
      try {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {EventRequest.class, EventResponse.class};
         tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturnsB */
      /* Details: "FilterChain method doFilter(RenderRequest,                 */
      /* RenderResponse) returns void "                                       */
      TestResult tr6 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSB);
      try {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {RenderRequest.class, RenderResponse.class};
         tr6.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2SigTestsFilter_FilterChain_SIGRender_hasDoFilterReturnsC */
      /* Details: "FilterChain method doFilter(ResourceRequest,               */
      /* ResourceResponse) returns void "                                     */
      TestResult tr7 = tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCHAIN_SIGRENDER_HASDOFILTERRETURNSC);
      try {
         String name = "doFilter";
         Class<?> retType = void.class;
         Class<?>[] parms = {ResourceRequest.class, ResourceResponse.class};
         tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
      } catch(Exception e) {tr7.appendTcDetail(e.toString());}
      tr7.writeTo(writer);

   }

}
