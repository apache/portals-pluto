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

/**
 * Defines constants used by portlets, test beans, and the test driver. 
 */
package javax.portlet.tck.constants;

public class Constants {
   public static final String BR = "<br/>";
   public static final String HR = "<hr/>";
   public static final String ASYNC_ID = "-async";
   public static final String RESULT_ID = "-result";
   public static final String DETAIL_ID = "-detail";
   public static final String CLICK_ID = "-clickme";
   public static final String SETUP_ID = "-setup";
   public static final String NOTREADY_ID = "-notready";
   public static final String RESOURCE_LINK_ID = "-reslink";
   public static final String RESOURCE_DIV_ID = "-resdiv";
   public static final String WAITING = "Waiting for results";
   public static final String SUCCESS = "Succeeded";
   public static final String FAILURE = "Failed";
   public static final String BUTTON_PARAM_NAME="inputval";
   
   // Render parameter name for redirect testing
   public static final String TCKPAGE = "tckPage";
   
   // for session attributes passing info between phases
   public static final String RESULT_ATTR_PREFIX = "attr.result.";
   
   // For generating the target for the getRequestDispatcher call
   // target = <prefix> + <servlet/jsp name> + <suffix> + ? + <query string> 
   public static final String SERVLET_INCFWD = "/IncluderForwarderServlet";
   public static final String SERVLET_PREFIX = "/";
   public static final String SERVLET_SUFFIX = "";
   public static final String JSP_PREFIX = "/WEB-INF/jsp/";
   public static final String JSP_SUFFIX = ".jsp";
   public static final String EXTRA_PATH = "/extra/path";
   public static final String EXTRA_QUERY_STRING = "eqparm1=eqvalue1";
   public static final String QUERY_STRING = "qparm1=qvalue1&qparm2=qvalue2";
   
   // for several tests to servlet / jsp for comparison
   public static final String ATTR_DISPATCH_TARGET = "req.attr.dispatch.target";
   public static final String ATTR_DISPATCH_ACTION = "req.attr.dispatch.action";
   public static final String ATTR_DISPATCH_REQUEST_URI  = "req.attr.dispatch.request_uri ";
   public static final String ATTR_DISPATCH_CONTEXT_PATH = "req.attr.dispatch.context_path";
   public static final String ATTR_DISPATCH_SERVLET_PATH = "req.attr.dispatch.servlet_path";
   public static final String ATTR_DISPATCH_PATH_INFO    = "req.attr.dispatch.path_info";
   public static final String ATTR_DISPATCH_QUERY_STRING = "req.attr.dispatch.query_string";
   public static final String ATTR_DISPATCH_COMMITTED = "req.attr.dispatch.committed";
   public static final String MULTIPLE_INCLUDE_ATTR = "req.attr.multi";
   public static final String MULTIPLE_INCLUDE_VAL = "Included counter=";
   public static final String THREADID_ATTR = "req.attr.tid";
   public static final String ATTR_PREFIX = "req.attr.test.";
   public static final String PARM_PREFIX = "parm.test.";
   public static final String PARM_NAME = "TestParm";
   public static final String PARM_VALUE = "Value";
   
   // Some defined header names for testing properties
   public static final String ACCEPT_HEADER = "Accept";
   public static final String ACCEPT_LANG_HEADER = "Accept-Language";
   public static final String ACCEPT_ENC_HEADER = "Accept-Encoding";
   public static final String CONTENT_TYPE_HEADER = "Content-Type";
   public static final String CONTENT_LENGTH_HEADER = "Content-Length";
   public static final String DATE_HEADER = "Date";
   public static final String MOD_HEADER = "If-Modified-Since";
   
   // security role name
   public static final String ROLE_NAME  = "admin";   
   
   // for cookie & property tests
   public static final String COOKIE_PREFIX = "Cookie_";
   public static final String COOKIE_VALUE = "CookieValue";
   public static final String PROP_PREFIX = "Property_";
   public static final String PROP_VALUE = "PropertyValue";
   
   // namespace for events, etc.
   public static final String TCKNAMESPACE = "http://www.apache.org/portals/pluto/portlet-tck_3.0";
}
