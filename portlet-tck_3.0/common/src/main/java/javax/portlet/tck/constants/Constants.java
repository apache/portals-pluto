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
   public static final String RESULT_ID = "-result";
   public static final String DETAIL_ID = "-detail";
   public static final String CLICK_ID = "-clickme";
   public static final String SETUP_ID = "-setup";
   public static final String SUCCESS = "Succeeded";
   public static final String FAILURE = "Failed";
   
   // for session attributes passing info between phases
   public static final String RESULT_ATTR_PREFIX = "attr.result.";
   
   // for several tests to servlet / jsp for comparison
   public static final String THREADID_ATTR = "req.attr.tid";
   public static final String ATTR_PREFIX = "req.attr.test.";
   public static final String PARM_PREFIX = "parm.test.";
   public static final String PARM_NAME = "TestParm";
   public static final String PARM_VALUE = "Value";
   
   // for cookie & property tests
   public static final String COOKIE_PREFIX = "Cookie_";
   public static final String COOKIE_VALUE = "CookieValue";
   public static final String PROP_PREFIX = "Property_";
   public static final String PROP_VALUE = "PropertyValue";
   
   // namespace for events, etc.
   public static final String TCKNAMESPACE = "http://www.apache.org/portals/pluto/portlet-tck_3.0";
}
