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
 * Used by portlet: FilterTests_FilterConfig_ApiRenderFilter
 *
 * @author nick
 *
 */
public class FilterTests_FilterConfig_ApiRenderFilter_filter implements RenderFilter {
   private static final String LOG_CLASS = 
         FilterTests_FilterConfig_ApiRenderFilter_filter.class.getName();
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
   public void doFilter(RenderRequest portletReq, RenderResponse portletResp,
         FilterChain chain) throws IOException, PortletException {
      LOGGER.entering(LOG_CLASS, "doFilter");

      PrintWriter writer = portletResp.getWriter();

      // first execute the chain

      chain.doFilter(portletReq, portletResp);

      // now do the tests and write output

      JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2FilterTests_FilterConfig_ApiRenderFilter_getFilterName   */
      /* Details: "Method getFilterName(): getFilterName method returns       */
      /* filter name as defined in deployment descriptor"                     */
      TestResult tr0 = tcd.getTestResultFailed(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETFILTERNAME);
      String getFiltName=filterConfig.getFilterName();
      if(getFiltName.equals(this.getClass().getSimpleName())) {
    	  tr0.setTcSuccess(true);
      }
      tr0.writeTo(writer);

      /* TestCase: V2FilterTests_FilterConfig_ApiRenderFilter_getPortletContext */
      /* Details: "Method getPortletContext(): Returns reference to           */
      /* PortletContext object"                                               */
      TestResult tr1 = tcd.getTestResultFailed(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETPORTLETCONTEXT);
      PortletContext pc=filterConfig.getPortletContext();
      if(pc!=null){
    	  tr1.setTcSuccess(true);
      }
      tr1.writeTo(writer);

      /* TestCase: V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameter1 */
      /* Details: "Method getInitParameter(String): Returns null if           */
      /* initialization parameter does not exist"                             */
      TestResult tr2 = tcd.getTestResultFailed(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETER1);
      String getInit1=filterConfig.getInitParameter("TestParm3");
      if(getInit1==null) {
    	  tr2.setTcSuccess(true);
      }
      tr2.writeTo(writer);

      /* TestCase: V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameter2 */
      /* Details: "Method getInitParameter(String): Returns value of          */
      /* specified initialization parameter"                                  */
      TestResult tr3 = tcd.getTestResultSucceeded(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETER2);
      String getInit2=filterConfig.getInitParameter("TestParm1");
      if((getInit2==null) || !getInit2.equals("TestValue1")) {
    	  tr3.setTcSuccess(false);
    	  StringBuilder txt3 = new StringBuilder(128);
          txt3.append("Value for TestParm1 was not 'TestValue1' but ").append(getInit2);
          tr3.appendTcDetail(txt3.toString());
      }
      tr3.writeTo(writer);

      /* TestCase: V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameterNames1 */
      /* Details: "Method getInitParameterNames(): Returns empty              */
      /* Enumeration if no parameters defined"                                */
      TestResult tr4 = tcd.getTestResultSucceeded(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES1);
      tr4.appendTcDetail("This Method Could not be Tested Which already defined with Init Parameters");
      tr4.writeTo(writer);

      /* TestCase: V2FilterTests_FilterConfig_ApiRenderFilter_getInitParameterNames2 */
      /* Details: "Method getInitParameterNames(): Returns an Enumeration     */
      /* of initialization parameters defined in deployment descriptor"       */
      TestResult tr5 = tcd.getTestResultFailed(V2FILTERTESTS_FILTERCONFIG_APIRENDERFILTER_GETINITPARAMETERNAMES2);
      Enumeration<String> getNames2=filterConfig.getInitParameterNames();
      List<String> li5=Collections.list(getNames2);
      if(li5.size()==2){
    	  if (li5.contains("TestParm1") && li5.contains("TestParm2")) {
              tr5.setTcSuccess(true);
           } else {
              tr5.appendTcDetail("Parameter names don't match: " + li5.toString());
           }
        } else {
           tr5.appendTcDetail("Parameter name enumeration had invalid length: " + li5.size());
        }
      tr5.writeTo(writer);


   }
}
