/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */


package javax.portlet.tck.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.tck.beans.ClassChecker;
import javax.portlet.tck.beans.JSR286SignatureTestCaseDetails;
import javax.portlet.tck.beans.TestResult;

import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAME;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAMERETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETER;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXT;
import static javax.portlet.tck.beans.JSR286SignatureTestCaseDetails.V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS;

/**
 * Render filter for signature tests
 *
 * @author nick
 *
 */
public class SigTestsFilter_FilterConfig_SIGRender_filter implements RenderFilter {

  private FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws PortletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void destroy() {}

  @Override
  public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain)
      throws IOException, PortletException {

    chain.doFilter(request, response);

    PrintWriter writer = response.getWriter();
    JSR286SignatureTestCaseDetails tcd = new JSR286SignatureTestCaseDetails();
    ClassChecker cc = new ClassChecker(filterConfig.getClass());

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetFilterName */
    /* Details: "FilterConfig has a getFilterName()  method " */
    TestResult tr0 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAME);
    try {
      String name = "getFilterName";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr0.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr0.appendTcDetail(e.toString());
    }
    tr0.writeTo(writer);

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetFilterNameReturns */
    /* Details: "FilterConfig method getFilterName() returns String " */
    TestResult tr1 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETFILTERNAMERETURNS);
    try {
      String name = "getFilterName";
      Class<?> retType = String.class;
      Class<?>[] parms = null;
      tr1.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr1.appendTcDetail(e.toString());
    }
    tr1.writeTo(writer);

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameter */
    /* Details: "FilterConfig has a getInitParameter(String)  method " */
    TestResult tr2 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETER);
    try {
      String name = "getInitParameter";
      Class<?>[] exceptions = null;
      Class<?>[] parms = {String.class};
      tr2.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr2.appendTcDetail(e.toString());
    }
    tr2.writeTo(writer);

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterNames */
    /* Details: "FilterConfig has a getInitParameterNames()  method " */
    TestResult tr3 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMES);
    try {
      String name = "getInitParameterNames";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr3.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr3.appendTcDetail(e.toString());
    }
    tr3.writeTo(writer);

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterNamesReturns */
    /* Details: "FilterConfig method getInitParameterNames() returns */
    /* java.util.Enumeration " */
    TestResult tr4 = tcd.getTestResultFailed(
        V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERNAMESRETURNS);
    try {
      String name = "getInitParameterNames";
      Class<?> retType = java.util.Enumeration.class;
      Class<?>[] parms = null;
      tr4.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr4.appendTcDetail(e.toString());
    }
    tr4.writeTo(writer);

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetInitParameterReturns */
    /* Details: "FilterConfig method getInitParameter(String) returns */
    /* String " */
    TestResult tr5 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETINITPARAMETERRETURNS);
    try {
      String name = "getInitParameter";
      Class<?> retType = String.class;
      Class<?>[] parms = {String.class};
      tr5.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr5.appendTcDetail(e.toString());
    }
    tr5.writeTo(writer);

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetPortletContext */
    /* Details: "FilterConfig has a getPortletContext()  method " */
    TestResult tr6 =
        tcd.getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXT);
    try {
      String name = "getPortletContext";
      Class<?>[] exceptions = null;
      Class<?>[] parms = null;
      tr6.setTcSuccess(cc.hasMethod(name, parms, exceptions));
    } catch (Exception e) {
      tr6.appendTcDetail(e.toString());
    }
    tr6.writeTo(writer);

    /* TestCase: V2SigTestsFilter_FilterConfig_SIGRender_hasGetPortletContextReturns */
    /* Details: "FilterConfig method getPortletContext() returns */
    /* PortletContext " */
    TestResult tr7 = tcd
        .getTestResultFailed(V2SIGTESTSFILTER_FILTERCONFIG_SIGRENDER_HASGETPORTLETCONTEXTRETURNS);
    try {
      String name = "getPortletContext";
      Class<?> retType = PortletContext.class;
      Class<?>[] parms = null;
      tr7.setTcSuccess(cc.methodHasReturnType(name, retType, parms));
    } catch (Exception e) {
      tr7.appendTcDetail(e.toString());
    }
    tr7.writeTo(writer);

  }

}
