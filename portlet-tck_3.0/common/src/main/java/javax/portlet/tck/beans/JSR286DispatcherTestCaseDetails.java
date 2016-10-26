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

package javax.portlet.tck.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines constants for the test case names and test case details for the JSR 286 API compatibility tests.
 * 
 * Note that the backing map is static and not threadsafe. Operations that change the map such as put, remove, etc.,
 * should not be used in portlets.
 * 
 * @author nick
 */
public class JSR286DispatcherTestCaseDetails extends TestCaseDetails {

   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH1             = "V2DispatcherTests_SPEC2_19_DispatchServletRender_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH2             = "V2DispatcherTests_SPEC2_19_DispatchServletRender_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH3             = "V2DispatcherTests_SPEC2_19_DispatchServletRender_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH4             = "V2DispatcherTests_SPEC2_19_DispatchServletRender_dispatch4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH5             = "V2DispatcherTests_SPEC2_19_DispatchServletRender_dispatch5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH6             = "V2DispatcherTests_SPEC2_19_DispatchServletRender_dispatch6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_INVOKE2               = "V2DispatcherTests_SPEC2_19_DispatchServletRender_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH1             = "V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH2             = "V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH3             = "V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH4             = "V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH5             = "V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH6             = "V2DispatcherTests_SPEC2_19_DispatchServletAction_dispatch6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH1              = "V2DispatcherTests_SPEC2_19_DispatchServletEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH2              = "V2DispatcherTests_SPEC2_19_DispatchServletEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH3              = "V2DispatcherTests_SPEC2_19_DispatchServletEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH4              = "V2DispatcherTests_SPEC2_19_DispatchServletEvent_dispatch4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH5              = "V2DispatcherTests_SPEC2_19_DispatchServletEvent_dispatch5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH6              = "V2DispatcherTests_SPEC2_19_DispatchServletEvent_dispatch6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH1           = "V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH2           = "V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH3           = "V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH4           = "V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH5           = "V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH6           = "V2DispatcherTests_SPEC2_19_DispatchServletResource_dispatch6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_INVOKE2             = "V2DispatcherTests_SPEC2_19_DispatchServletResource_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_DISPATCH1              = "V2DispatcherTests_SPEC2_19_IncludeServletAction_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_DISPATCH2              = "V2DispatcherTests_SPEC2_19_IncludeServletAction_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_DISPATCH3              = "V2DispatcherTests_SPEC2_19_IncludeServletAction_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE1                = "V2DispatcherTests_SPEC2_19_IncludeServletAction_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE2                = "V2DispatcherTests_SPEC2_19_IncludeServletAction_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE4                = "V2DispatcherTests_SPEC2_19_IncludeServletAction_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE7                = "V2DispatcherTests_SPEC2_19_IncludeServletAction_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1A           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1B           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1C           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2A           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2B           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2C           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3A           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3B           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3C           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4A           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4B           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4C           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5A           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5B           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5C           = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES6            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES7            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES8            = "V2DispatcherTests_SPEC2_19_IncludeServletAction_attributes8";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH1               = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH2               = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH3               = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE1                 = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE2                 = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE4                 = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE7                 = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1A            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1B            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1C            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2A            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2B            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2C            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3A            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3B            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3C            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4A            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4B            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4C            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5A            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5B            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5C            = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES6             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES7             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES8             = "V2DispatcherTests_SPEC2_19_IncludeServletEvent_attributes8";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH1              = "V2DispatcherTests_SPEC2_19_IncludeServletRender_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH2              = "V2DispatcherTests_SPEC2_19_IncludeServletRender_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH3              = "V2DispatcherTests_SPEC2_19_IncludeServletRender_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE1                = "V2DispatcherTests_SPEC2_19_IncludeServletRender_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE2                = "V2DispatcherTests_SPEC2_19_IncludeServletRender_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE4                = "V2DispatcherTests_SPEC2_19_IncludeServletRender_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE7                = "V2DispatcherTests_SPEC2_19_IncludeServletRender_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE9                = "V2DispatcherTests_SPEC2_19_IncludeServletRender_invoke9";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1A           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1B           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1C           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2A           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2B           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2C           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3A           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3B           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3C           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4A           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4B           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4C           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5A           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5B           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5C           = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES6            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES7            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES8            = "V2DispatcherTests_SPEC2_19_IncludeServletRender_attributes8";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH1            = "V2DispatcherTests_SPEC2_19_IncludeServletResource_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH2            = "V2DispatcherTests_SPEC2_19_IncludeServletResource_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH3            = "V2DispatcherTests_SPEC2_19_IncludeServletResource_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE1              = "V2DispatcherTests_SPEC2_19_IncludeServletResource_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE2              = "V2DispatcherTests_SPEC2_19_IncludeServletResource_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE4              = "V2DispatcherTests_SPEC2_19_IncludeServletResource_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE7              = "V2DispatcherTests_SPEC2_19_IncludeServletResource_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE9              = "V2DispatcherTests_SPEC2_19_IncludeServletResource_invoke9";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1A         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1B         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1C         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2A         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2B         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2C         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3A         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3B         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3C         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4A         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4B         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4C         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5A         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5B         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5C         = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES6          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES7          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES8          = "V2DispatcherTests_SPEC2_19_IncludeServletResource_attributes8";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_DISPATCH1              = "V2DispatcherTests_SPEC2_19_ForwardServletAction_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_DISPATCH2              = "V2DispatcherTests_SPEC2_19_ForwardServletAction_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_DISPATCH3              = "V2DispatcherTests_SPEC2_19_ForwardServletAction_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE1                = "V2DispatcherTests_SPEC2_19_ForwardServletAction_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE2                = "V2DispatcherTests_SPEC2_19_ForwardServletAction_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE4                = "V2DispatcherTests_SPEC2_19_ForwardServletAction_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE7                = "V2DispatcherTests_SPEC2_19_ForwardServletAction_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1A           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1B           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1C           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2A           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2B           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2C           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3A           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3B           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3C           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4A           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4B           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4C           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5A           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5B           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5C           = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES6            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES7            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES8            = "V2DispatcherTests_SPEC2_19_ForwardServletAction_attributes8";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH1               = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH2               = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH3               = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE1                 = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE2                 = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE4                 = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE7                 = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1A            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1B            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1C            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2A            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2B            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2C            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3A            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3B            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3C            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4A            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4B            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4C            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5A            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5B            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5C            = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES6             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES7             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES8             = "V2DispatcherTests_SPEC2_19_ForwardServletEvent_attributes8";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH1              = "V2DispatcherTests_SPEC2_19_ForwardServletRender_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH2              = "V2DispatcherTests_SPEC2_19_ForwardServletRender_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH3              = "V2DispatcherTests_SPEC2_19_ForwardServletRender_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE1                = "V2DispatcherTests_SPEC2_19_ForwardServletRender_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE2                = "V2DispatcherTests_SPEC2_19_ForwardServletRender_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE4                = "V2DispatcherTests_SPEC2_19_ForwardServletRender_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE7                = "V2DispatcherTests_SPEC2_19_ForwardServletRender_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1A           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1B           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1C           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2A           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2B           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2C           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3A           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3B           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3C           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4A           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4B           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4C           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5A           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5B           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5C           = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES6            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES7            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES8            = "V2DispatcherTests_SPEC2_19_ForwardServletRender_attributes8";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH1            = "V2DispatcherTests_SPEC2_19_ForwardServletResource_dispatch1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH2            = "V2DispatcherTests_SPEC2_19_ForwardServletResource_dispatch2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH3            = "V2DispatcherTests_SPEC2_19_ForwardServletResource_dispatch3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE1              = "V2DispatcherTests_SPEC2_19_ForwardServletResource_invoke1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE2              = "V2DispatcherTests_SPEC2_19_ForwardServletResource_invoke2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE4              = "V2DispatcherTests_SPEC2_19_ForwardServletResource_invoke4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE7              = "V2DispatcherTests_SPEC2_19_ForwardServletResource_invoke7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes1";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1A         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes1a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1B         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes1b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1C         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes1c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes2";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2A         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes2a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2B         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes2b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2C         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes2c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes3";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3A         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes3a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3B         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes3b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3C         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes3c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes4";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4A         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes4a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4B         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes4b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4C         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes4c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes5";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5A         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes5a";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5B         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes5b";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5C         = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes5c";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES6          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes6";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES7          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes7";
   public final static String               V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES8          = "V2DispatcherTests_SPEC2_19_ForwardServletResource_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_DISPATCH1                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_DISPATCH2                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_DISPATCH3                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE1                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE2                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE4                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE7                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES6               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES7               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES8               = "V2DispatcherTests2_SPEC2_19_IncludeJSPAction_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_DISPATCH1                  = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_DISPATCH2                  = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_DISPATCH3                  = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE1                    = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE2                    = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE4                    = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE7                    = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1A               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1B               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1C               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2A               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2B               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2C               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3A               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3B               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3C               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4A               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4B               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4C               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5A               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5B               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5C               = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES6                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES7                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES8                = "V2DispatcherTests2_SPEC2_19_IncludeJSPEvent_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_DISPATCH1                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_DISPATCH2                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_DISPATCH3                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE1                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE2                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE4                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE7                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE9                   = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_invoke9";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5A              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5B              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5C              = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES6               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES7               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES8               = "V2DispatcherTests2_SPEC2_19_IncludeJSPRender_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH1               = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH2               = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH3               = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE1                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE2                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE4                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE7                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE9                 = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_invoke9";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1A            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1B            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1C            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2A            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2B            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2C            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3A            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3B            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3C            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4A            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4B            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4C            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5A            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5B            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5C            = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES6             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES7             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES8             = "V2DispatcherTests2_SPEC2_19_IncludeJSPResource_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_DISPATCH1                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_DISPATCH2                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_DISPATCH3                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE1                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE2                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE4                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE7                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES6               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES7               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES8               = "V2DispatcherTests2_SPEC2_19_ForwardJSPAction_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_DISPATCH1                  = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_DISPATCH2                  = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_DISPATCH3                  = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE1                    = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE2                    = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE4                    = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE7                    = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1A               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1B               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1C               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2A               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2B               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2C               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3A               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3B               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3C               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4A               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4B               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4C               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5A               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5B               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5C               = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES6                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES7                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES8                = "V2DispatcherTests2_SPEC2_19_ForwardJSPEvent_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH1                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH2                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH3                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE1                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE2                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE4                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE7                   = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5A              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5B              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5C              = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES6               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES7               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES8               = "V2DispatcherTests2_SPEC2_19_ForwardJSPRender_attributes8";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH1               = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_dispatch1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH2               = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_dispatch2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH3               = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_dispatch3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE1                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_invoke1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE2                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_invoke2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE4                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_invoke4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE7                 = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_invoke7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes1";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1A            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes1a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1B            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes1b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1C            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes1c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes2";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2A            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes2a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2B            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes2b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2C            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes2c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes3";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3A            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes3a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3B            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes3b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3C            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes3c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes4";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4A            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes4a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4B            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes4b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4C            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes4c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes5";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5A            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes5a";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5B            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes5b";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5C            = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes5c";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES6             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes6";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES7             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes7";
   public final static String               V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES8             = "V2DispatcherTests2_SPEC2_19_ForwardJSPResource_attributes8";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETACTION_DISPATCH4            = "V2DispatcherTests3S_SPEC2_19_IncludeServletAction_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH4             = "V2DispatcherTests3S_SPEC2_19_IncludeServletEvent_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH4            = "V2DispatcherTests3S_SPEC2_19_IncludeServletRender_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH4          = "V2DispatcherTests3S_SPEC2_19_IncludeServletResource_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETACTION_DISPATCH4            = "V2DispatcherTests3S_SPEC2_19_ForwardServletAction_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH4             = "V2DispatcherTests3S_SPEC2_19_ForwardServletEvent_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH4            = "V2DispatcherTests3S_SPEC2_19_ForwardServletRender_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH4          = "V2DispatcherTests3S_SPEC2_19_ForwardServletResource_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4                = "V2DispatcherTests3S_SPEC2_19_IncludeJSPAction_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPEVENT_DISPATCH4                 = "V2DispatcherTests3S_SPEC2_19_IncludeJSPEvent_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPRENDER_DISPATCH4                = "V2DispatcherTests3S_SPEC2_19_IncludeJSPRender_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH4              = "V2DispatcherTests3S_SPEC2_19_IncludeJSPResource_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPACTION_DISPATCH4                = "V2DispatcherTests3S_SPEC2_19_ForwardJSPAction_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPEVENT_DISPATCH4                 = "V2DispatcherTests3S_SPEC2_19_ForwardJSPEvent_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPRENDER_DISPATCH4                = "V2DispatcherTests3S_SPEC2_19_ForwardJSPRender_dispatch4";
   public final static String               V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH4              = "V2DispatcherTests3S_SPEC2_19_ForwardJSPResource_dispatch4";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE3               = "V2DispatcherTests4_SPEC2_19_IncludeServletAction_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE8               = "V2DispatcherTests4_SPEC2_19_IncludeServletAction_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETEVENT_INVOKE3                = "V2DispatcherTests4_SPEC2_19_IncludeServletEvent_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETEVENT_INVOKE8                = "V2DispatcherTests4_SPEC2_19_IncludeServletEvent_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRENDER_INVOKE3               = "V2DispatcherTests4_SPEC2_19_IncludeServletRender_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRENDER_INVOKE8               = "V2DispatcherTests4_SPEC2_19_IncludeServletRender_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE3             = "V2DispatcherTests4_SPEC2_19_IncludeServletResource_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE8             = "V2DispatcherTests4_SPEC2_19_IncludeServletResource_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETACTION_INVOKE3               = "V2DispatcherTests4_SPEC2_19_ForwardServletAction_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETEVENT_INVOKE3                = "V2DispatcherTests4_SPEC2_19_ForwardServletEvent_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETRENDER_INVOKE3               = "V2DispatcherTests4_SPEC2_19_ForwardServletRender_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE3             = "V2DispatcherTests4_SPEC2_19_ForwardServletResource_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPACTION_INVOKE3                   = "V2DispatcherTests4_SPEC2_19_IncludeJSPAction_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPACTION_INVOKE8                   = "V2DispatcherTests4_SPEC2_19_IncludeJSPAction_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPEVENT_INVOKE3                    = "V2DispatcherTests4_SPEC2_19_IncludeJSPEvent_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPEVENT_INVOKE8                    = "V2DispatcherTests4_SPEC2_19_IncludeJSPEvent_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRENDER_INVOKE3                   = "V2DispatcherTests4_SPEC2_19_IncludeJSPRender_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRENDER_INVOKE8                   = "V2DispatcherTests4_SPEC2_19_IncludeJSPRender_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE3                 = "V2DispatcherTests4_SPEC2_19_IncludeJSPResource_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE8                 = "V2DispatcherTests4_SPEC2_19_IncludeJSPResource_invoke8";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPACTION_INVOKE3                   = "V2DispatcherTests4_SPEC2_19_ForwardJSPAction_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPEVENT_INVOKE3                    = "V2DispatcherTests4_SPEC2_19_ForwardJSPEvent_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPRENDER_INVOKE3                   = "V2DispatcherTests4_SPEC2_19_ForwardJSPRender_invoke3";
   public final static String               V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPRESOURCE_INVOKE3                 = "V2DispatcherTests4_SPEC2_19_ForwardJSPResource_invoke3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_DISPATCH1      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_DISPATCH2      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_DISPATCH3      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_INVOKE2        = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_INVOKE4        = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_INVOKE7        = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES6    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES7    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES8    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletAction_attributes8";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_DISPATCH1       = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_DISPATCH2       = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_DISPATCH3       = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_INVOKE2         = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_INVOKE4         = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_INVOKE7         = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1A    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1B    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1C    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2A    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2B    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2C    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3A    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3B    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3C    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4A    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4B    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4C    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5A    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5B    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5C    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES6     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES7     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES8     = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletEvent_attributes8";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_DISPATCH1      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_DISPATCH2      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_DISPATCH3      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE2        = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE4        = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE7        = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE9        = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_invoke9";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5A   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5B   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5C   = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES6    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES7    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES8    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletRender_attributes8";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_DISPATCH1    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_DISPATCH2    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_DISPATCH3    = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE2      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE4      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE7      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE9      = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_invoke9";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1A = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1B = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1C = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2A = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2B = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2C = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3A = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3B = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3C = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4A = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4B = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4C = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5A = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5B = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5C = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES6  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES7  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES8  = "V2DispatcherTests5_SPEC2_19_IncThenIncludeServletResource_attributes8";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_DISPATCH1      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_DISPATCH2      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_DISPATCH3      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_INVOKE2        = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_INVOKE4        = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_INVOKE7        = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES6    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES7    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES8    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletAction_attributes8";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_DISPATCH1       = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_DISPATCH2       = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_DISPATCH3       = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_INVOKE2         = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_INVOKE4         = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_INVOKE7         = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1A    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1B    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1C    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2A    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2B    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2C    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3A    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3B    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3C    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4A    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4B    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4C    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5A    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5B    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5C    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES6     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES7     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES8     = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletEvent_attributes8";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_DISPATCH1      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_DISPATCH2      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_DISPATCH3      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_INVOKE2        = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_INVOKE4        = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_INVOKE7        = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5A   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5B   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5C   = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES6    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES7    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES8    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletRender_attributes8";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_DISPATCH1    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_dispatch1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_DISPATCH2    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_dispatch2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_DISPATCH3    = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_dispatch3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_INVOKE2      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_invoke2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_INVOKE4      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_invoke4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_INVOKE7      = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_invoke7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes1";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1A = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes1a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1B = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes1b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1C = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes1c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes2";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2A = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes2a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2B = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes2b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2C = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes2c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes3";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3A = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes3a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3B = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes3b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3C = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes3c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes4";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4A = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes4a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4B = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes4b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4C = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes4c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes5";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5A = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes5a";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5B = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes5b";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5C = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes5c";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES6  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes6";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES7  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes7";
   public final static String               V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES8  = "V2DispatcherTests5_SPEC2_19_IncThenForwardServletResource_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_DISPATCH1      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_DISPATCH2      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_DISPATCH3      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_INVOKE2        = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_INVOKE4        = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_INVOKE7        = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES6    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES7    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES8    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletAction_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_DISPATCH1       = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_DISPATCH2       = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_DISPATCH3       = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_INVOKE2         = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_INVOKE4         = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_INVOKE7         = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1A    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1B    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1C    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2A    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2B    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2C    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3A    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3B    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3C    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4A    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4B    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4C    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5A    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5B    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5C    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES6     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES7     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES8     = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletEvent_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_DISPATCH1      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_DISPATCH2      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_DISPATCH3      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE2        = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE4        = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE7        = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE9        = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_invoke9";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5A   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5B   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5C   = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES6    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES7    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES8    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletRender_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_DISPATCH1    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_DISPATCH2    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_DISPATCH3    = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE2      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE4      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE7      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE9      = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_invoke9";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1A = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1B = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1C = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2A = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2B = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2C = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3A = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3B = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3C = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4A = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4B = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4C = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5A = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5B = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5C = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES6  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES7  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES8  = "V2DispatcherTests6_SPEC2_19_FwdThenIncludeServletResource_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH1      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH2      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH3      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE2        = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE4        = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE7        = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES6    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES7    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES8    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletAction_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_DISPATCH1       = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_DISPATCH2       = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_DISPATCH3       = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_INVOKE2         = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_INVOKE4         = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_INVOKE7         = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1A    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1B    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1C    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2A    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2B    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2C    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3A    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3B    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3C    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4A    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4B    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4C    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5A    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5B    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5C    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES6     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES7     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES8     = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletEvent_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_DISPATCH1      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_DISPATCH2      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_DISPATCH3      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_INVOKE2        = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_INVOKE4        = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_INVOKE7        = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5A   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5B   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5C   = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES6    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES7    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES8    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletRender_attributes8";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_DISPATCH1    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_dispatch1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_DISPATCH2    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_dispatch2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_DISPATCH3    = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_dispatch3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_INVOKE2      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_invoke2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_INVOKE4      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_invoke4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_INVOKE7      = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_invoke7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes1";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1A = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes1a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1B = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes1b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1C = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes1c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes2";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2A = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes2a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2B = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes2b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2C = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes2c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes3";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3A = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes3a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3B = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes3b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3C = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes3c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes4";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4A = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes4a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4B = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes4b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4C = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes4c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes5";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5A = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes5a";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5B = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes5b";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5C = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes5c";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES6  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes6";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES7  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes7";
   public final static String               V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES8  = "V2DispatcherTests6_SPEC2_19_FwdThenForwardServletResource_attributes8";

   private final static Map<String, String> tcd                                                                    = new HashMap<String, String>();
   static {

      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH1,
            "The PortletContext getRequestDispatcher method returns a PortletRequestDispatcher for a path within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH2,
            "If the path provided to getRequestDispatcher method does not start with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH3,
            "If the path provided to getRequestDispatcher method ends with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH4,
            "If the path provided to getRequestDispatcher method does not specify a valid path, the method returns null");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH5,
            "The PortletContext getNamedDispatcher method returns a PortletRequestDispatcher for a servlet within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_DISPATCH6,
            "If the name provided to getNamedDispatcher method is not valid, the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRENDER_INVOKE2,
            "If the forward method is called after the response has been committed, an IllegalStateException exception is thrown");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH1,
            "The PortletContext getRequestDispatcher method returns a PortletRequestDispatcher for a path within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH2,
            "If the path provided to getRequestDispatcher method does not start with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH3,
            "If the path provided to getRequestDispatcher method ends with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH4,
            "If the path provided to getRequestDispatcher method does not specify a valid path, the method returns null");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH5,
            "The PortletContext getNamedDispatcher method returns a PortletRequestDispatcher for a servlet within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETACTION_DISPATCH6,
            "If the name provided to getNamedDispatcher method is not valid, the method returns null");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH1,
            "The PortletContext getRequestDispatcher method returns a PortletRequestDispatcher for a path within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH2,
            "If the path provided to getRequestDispatcher method does not start with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH3,
            "If the path provided to getRequestDispatcher method ends with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH4,
            "If the path provided to getRequestDispatcher method does not specify a valid path, the method returns null");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH5,
            "The PortletContext getNamedDispatcher method returns a PortletRequestDispatcher for a servlet within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETEVENT_DISPATCH6,
            "If the name provided to getNamedDispatcher method is not valid, the method returns null");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH1,
            "The PortletContext getRequestDispatcher method returns a PortletRequestDispatcher for a path within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH2,
            "If the path provided to getRequestDispatcher method does not start with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH3,
            "If the path provided to getRequestDispatcher method ends with \"/\", the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH4,
            "If the path provided to getRequestDispatcher method does not specify a valid path, the method returns null");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH5,
            "The PortletContext getNamedDispatcher method returns a PortletRequestDispatcher for a servlet within the portlet application");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_DISPATCH6,
            "If the name provided to getNamedDispatcher method is not valid, the method returns null");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_DISPATCHSERVLETRESOURCE_INVOKE2,
            "If the forward method is called after the response has been committed, an IllegalStateException exception is thrown");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES7,
            "For includes from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETACTION_ATTRIBUTES8,
            "For includes from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES7,
            "For includes from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETEVENT_ATTRIBUTES8,
            "For includes from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_INVOKE9,
            "The included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES7,
            "For includes from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRENDER_ATTRIBUTES8,
            "For includes from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE9,
            "The included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES7,
            "For includes from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_INCLUDESERVLETRESOURCE_ATTRIBUTES8,
            "For includes from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES7,
            "For forwards from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETACTION_ATTRIBUTES8,
            "For forwards from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES7,
            "For forwards from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETEVENT_ATTRIBUTES8,
            "For forwards from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES7,
            "For forwards from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRENDER_ATTRIBUTES8,
            "For forwards from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES7,
            "For forwards from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS_SPEC2_19_FORWARDSERVLETRESOURCE_ATTRIBUTES8,
            "For forwards from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES7,
            "For includes from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPACTION_ATTRIBUTES8,
            "For includes from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES7,
            "For includes from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPEVENT_ATTRIBUTES8,
            "For includes from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_INVOKE9,
            "The included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES7,
            "For includes from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRENDER_ATTRIBUTES8,
            "For includes from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE1,
            "The PortletRequestDispatcher include method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE2,
            "Parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE9,
            "The included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the include chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES7,
            "For includes from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_INCLUDEJSPRESOURCE_ATTRIBUTES8,
            "For includes from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES7,
            "For forwards from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPACTION_ATTRIBUTES8,
            "For forwards from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES7,
            "For forwards from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPEVENT_ATTRIBUTES8,
            "For forwards from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES7,
            "For forwards from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRENDER_ATTRIBUTES8,
            "For forwards from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH1,
            "If the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH2,
            "Parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH3,
            "If query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE1,
            "The PortletRequestDispatcher forward method can target a servlet");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE2,
            "Parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE4,
            "The portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_INVOKE7,
            "The path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES1C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES2C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES3C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES4C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5A,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5B,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES5C,
            "If the request dispatcher is obtained through the getRequestDispatcher method, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES6,
            "The request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES7,
            "For forwards from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS2_SPEC2_19_FORWARDJSPRESOURCE_ATTRIBUTES8,
            "For forwards from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETACTION_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETEVENT_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETRENDER_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDESERVLETRESOURCE_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETACTION_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETEVENT_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRENDER_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDSERVLETRESOURCE_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPACTION_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPEVENT_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPRENDER_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_INCLUDEJSPRESOURCE_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPACTION_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPEVENT_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPRENDER_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(V2DISPATCHERTESTS3S_SPEC2_19_FORWARDJSPRESOURCE_DISPATCH4,
            "The parameters associated with a request dispatcher are scoped only for the duration of the include or forward call");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETACTION_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETEVENT_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETEVENT_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRENDER_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRENDER_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDESERVLETRESOURCE_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETACTION_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETEVENT_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETRENDER_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDSERVLETRESOURCE_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPACTION_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPACTION_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPEVENT_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPEVENT_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRENDER_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRENDER_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE3,
            "Parameters to the include method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(V2DISPATCHERTESTS4_SPEC2_19_INCLUDEJSPRESOURCE_INVOKE8,
            "The portlet can include multiple servlets during the same lifecycle method");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPACTION_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPEVENT_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPRENDER_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS4_SPEC2_19_FORWARDJSPRESOURCE_INVOKE3,
            "Parameters to the forward method for a target servlet can be wrapped request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_DISPATCH1,
            "In a servlet included by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_DISPATCH2,
            "In a servlet included by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_DISPATCH3,
            "In a servlet included by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_INVOKE2,
            "In a servlet included by the target of an include, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_INVOKE4,
            "In a servlet included by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_INVOKE7,
            "In a servlet included by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES1C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES2C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES3C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES4C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES5C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES6,
            "In a servlet included by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES7,
            "In a servlet included by the target of an include, for includes from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETACTION_ATTRIBUTES8,
            "In a servlet included by the target of an include, for includes from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_DISPATCH1,
            "In a servlet included by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_DISPATCH2,
            "In a servlet included by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_DISPATCH3,
            "In a servlet included by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_INVOKE2,
            "In a servlet included by the target of an include, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_INVOKE4,
            "In a servlet included by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_INVOKE7,
            "In a servlet included by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES1C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES2C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES3C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES4C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES5C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES6,
            "In a servlet included by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES7,
            "In a servlet included by the target of an include, for includes from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETEVENT_ATTRIBUTES8,
            "In a servlet included by the target of an include, for includes from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_DISPATCH1,
            "In a servlet included by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_DISPATCH2,
            "In a servlet included by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_DISPATCH3,
            "In a servlet included by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE2,
            "In a servlet included by the target of an include, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE4,
            "In a servlet included by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE7,
            "In a servlet included by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_INVOKE9,
            "In a servlet included by the target of an include, the included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES1C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES2C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES3C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES4C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES5C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES6,
            "In a servlet included by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES7,
            "In a servlet included by the target of an include, for includes from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRENDER_ATTRIBUTES8,
            "In a servlet included by the target of an include, for includes from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_DISPATCH1,
            "In a servlet included by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_DISPATCH2,
            "In a servlet included by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_DISPATCH3,
            "In a servlet included by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE2,
            "In a servlet included by the target of an include, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE4,
            "In a servlet included by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE7,
            "In a servlet included by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_INVOKE9,
            "In a servlet included by the target of an include, the included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5A,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5B,
            "In a servlet included by the target of an include, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5C,
            "In a servlet included by the target of an include, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES6,
            "In a servlet included by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES7,
            "In a servlet included by the target of an include, for includes from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENINCLUDESERVLETRESOURCE_ATTRIBUTES8,
            "In a servlet included by the target of an include, for includes from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_DISPATCH1,
            "In a servlet forwarded to by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_DISPATCH2,
            "In a servlet forwarded to by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_DISPATCH3,
            "In a servlet forwarded to by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_INVOKE2,
            "In a servlet forwarded to by the target of an include, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_INVOKE4,
            "In a servlet forwarded to by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_INVOKE7,
            "In a servlet forwarded to by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES6,
            "In a servlet forwarded to by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES7,
            "In a servlet forwarded to by the target of an include, for forwards from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETACTION_ATTRIBUTES8,
            "In a servlet forwarded to by the target of an include, for forwards from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_DISPATCH1,
            "In a servlet forwarded to by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_DISPATCH2,
            "In a servlet forwarded to by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_DISPATCH3,
            "In a servlet forwarded to by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_INVOKE2,
            "In a servlet forwarded to by the target of an include, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_INVOKE4,
            "In a servlet forwarded to by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_INVOKE7,
            "In a servlet forwarded to by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES6,
            "In a servlet forwarded to by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES7,
            "In a servlet forwarded to by the target of an include, for forwards from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETEVENT_ATTRIBUTES8,
            "In a servlet forwarded to by the target of an include, for forwards from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_DISPATCH1,
            "In a servlet forwarded to by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_DISPATCH2,
            "In a servlet forwarded to by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_DISPATCH3,
            "In a servlet forwarded to by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_INVOKE2,
            "In a servlet forwarded to by the target of an include, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_INVOKE4,
            "In a servlet forwarded to by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_INVOKE7,
            "In a servlet forwarded to by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES6,
            "In a servlet forwarded to by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES7,
            "In a servlet forwarded to by the target of an include, for forwards from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRENDER_ATTRIBUTES8,
            "In a servlet forwarded to by the target of an include, for forwards from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_DISPATCH1,
            "In a servlet forwarded to by the target of an include, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_DISPATCH2,
            "In a servlet forwarded to by the target of an include, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_DISPATCH3,
            "In a servlet forwarded to by the target of an include, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_INVOKE2,
            "In a servlet forwarded to by the target of an include, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_INVOKE4,
            "In a servlet forwarded to by the target of an include, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_INVOKE7,
            "In a servlet forwarded to by the target of an include, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of an include, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of an include, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES6,
            "In a servlet forwarded to by the target of an include, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES7,
            "In a servlet forwarded to by the target of an include, for forwards from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS5_SPEC2_19_INCTHENFORWARDSERVLETRESOURCE_ATTRIBUTES8,
            "In a servlet forwarded to by the target of an include, for forwards from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_DISPATCH1,
            "In a servlet included by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during a forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_DISPATCH2,
            "In a servlet included by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_DISPATCH3,
            "In a servlet included by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_INVOKE2,
            "In a servlet included by the target of a forward, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_INVOKE4,
            "In a servlet included by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_INVOKE7,
            "In a servlet included by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES1C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES2C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES3C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES4C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES5C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES6,
            "In a servlet included by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES7,
            "In a servlet included by the target of a forward, for includes from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETACTION_ATTRIBUTES8,
            "In a servlet included by the target of a forward, for includes from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_DISPATCH1,
            "In a servlet included by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during a forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_DISPATCH2,
            "In a servlet included by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_DISPATCH3,
            "In a servlet included by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_INVOKE2,
            "In a servlet included by the target of a forward, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_INVOKE4,
            "In a servlet included by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_INVOKE7,
            "In a servlet included by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES1C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES2C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES3C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES4C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES5C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES6,
            "In a servlet included by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES7,
            "In a servlet included by the target of a forward, for includes from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETEVENT_ATTRIBUTES8,
            "In a servlet included by the target of a forward, for includes from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_DISPATCH1,
            "In a servlet included by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during a forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_DISPATCH2,
            "In a servlet included by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_DISPATCH3,
            "In a servlet included by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE2,
            "In a servlet included by the target of a forward, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE4,
            "In a servlet included by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE7,
            "In a servlet included by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_INVOKE9,
            "In a servlet included by the target of a forward, the included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES1C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES2C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES3C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES4C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES5C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES6,
            "In a servlet included by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES7,
            "In a servlet included by the target of a forward, for includes from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRENDER_ATTRIBUTES8,
            "In a servlet included by the target of a forward, for includes from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_DISPATCH1,
            "In a servlet included by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during a forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_DISPATCH2,
            "In a servlet included by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_DISPATCH3,
            "In a servlet included by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE2,
            "In a servlet included by the target of a forward, parameters to the include method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE4,
            "In a servlet included by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE7,
            "In a servlet included by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_INVOKE9,
            "In a servlet included by the target of a forward, the included servlet must be handled as an HTTP GET request");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES1C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.context_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES2C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES3C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.path_info will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES4C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5A,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.include.query_string will be set, and reflects the path values of the included servlet.");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5B,
            "In a servlet included by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES5C,
            "In a servlet included by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES6,
            "In a servlet included by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES7,
            "In a servlet included by the target of a forward, for includes from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENINCLUDESERVLETRESOURCE_ATTRIBUTES8,
            "In a servlet included by the target of a forward, for includes from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH1,
            "In a servlet forwarded to by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH2,
            "In a servlet forwarded to by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_DISPATCH3,
            "In a servlet forwarded to by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE2,
            "In a servlet forwarded to by the target of a forward, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE4,
            "In a servlet forwarded to by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_INVOKE7,
            "In a servlet forwarded to by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES6,
            "In a servlet forwarded to by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES7,
            "In a servlet forwarded to by the target of a forward, for forwards from the processAction method, The request attribute javax.portlet.request must be set to the javax.portlet.ActionRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETACTION_ATTRIBUTES8,
            "In a servlet forwarded to by the target of a forward, for forwards from the processAction method, The request attribute javax.portlet.response must be set to the javax.portlet.ActionResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_DISPATCH1,
            "In a servlet forwarded to by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_DISPATCH2,
            "In a servlet forwarded to by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_DISPATCH3,
            "In a servlet forwarded to by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_INVOKE2,
            "In a servlet forwarded to by the target of a forward, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_INVOKE4,
            "In a servlet forwarded to by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_INVOKE7,
            "In a servlet forwarded to by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES6,
            "In a servlet forwarded to by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES7,
            "In a servlet forwarded to by the target of a forward, for forwards from the processEvent method, The request attribute javax.portlet.request must be set to the javax.portlet.EventRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETEVENT_ATTRIBUTES8,
            "In a servlet forwarded to by the target of a forward, for forwards from the processEvent method, The request attribute javax.portlet.response must be set to the javax.portlet.EventResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_DISPATCH1,
            "In a servlet forwarded to by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_DISPATCH2,
            "In a servlet forwarded to by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_DISPATCH3,
            "In a servlet forwarded to by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_INVOKE2,
            "In a servlet forwarded to by the target of a forward, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_INVOKE4,
            "In a servlet forwarded to by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_INVOKE7,
            "In a servlet forwarded to by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES6,
            "In a servlet forwarded to by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES7,
            "In a servlet forwarded to by the target of a forward, for forwards from the render method, The request attribute javax.portlet.request must be set to the javax.portlet.RenderRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRENDER_ATTRIBUTES8,
            "In a servlet forwarded to by the target of a forward, for forwards from the render method, The request attribute javax.portlet.response must be set to the javax.portlet.RenderResponse object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_DISPATCH1,
            "In a servlet forwarded to by the target of a forward, if the path provided to getRequestDispatcher method contains query strings, parameters specified in the query strings must be passed to the target servlet during an forward");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_DISPATCH2,
            "In a servlet forwarded to by the target of a forward, parameters specified in the query strings must be aggregated with the portlet render parameters");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_DISPATCH3,
            "In a servlet forwarded to by the target of a forward, if query string parameters have the same names as render parameter names, the query string parameters appear in the parameter values array before the render parameter values");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_INVOKE2,
            "In a servlet forwarded to by the target of a forward, parameters to the forward method for a target servlet can be the request and response classes from the portlet lifecyle method initiating the include");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_INVOKE4,
            "In a servlet forwarded to by the target of a forward, the portlet container must invoke the target servlet in the same thread as the PortletRequestDispatcher include invocation");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_INVOKE7,
            "In a servlet forwarded to by the target of a forward, the path elements of the request object exposed to the target servlet must reflect the path used to obtain the RequestDispatcher");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.request_uri will be set, and equals the value from HTTPServletRequest.getRequestURI for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES1C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.request_uri will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.context_path will be set, and equals the value from HTTPServletRequest.getContextPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES2C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.context_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.servlet_path will be set, and equals the value from HTTPServletRequest.getServletPath for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES3C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.servlet_path will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.path_info will be set, and equals the value from HTTPServletRequest.getPathInfo for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES4C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.path_info will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5A,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.forward.query_string will be set, and equals the value from HTTPServletRequest.getQueryString for the first servlet in the forward chain");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5B,
            "In a servlet forwarded to by the target of a forward, the portlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES5C,
            "In a servlet forwarded to by the target of a forward, the servlet request attribute javax.servlet.include.query_string will not be set");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES6,
            "In a servlet forwarded to by the target of a forward, the request attribute javax.portlet.config must be set to the javax.portlet.PortletConfig object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES7,
            "In a servlet forwarded to by the target of a forward, for forwards from the serveResource method, The request attribute javax.portlet.request must be set to the javax.portlet.ResourceRequest object");
      tcd.put(
            V2DISPATCHERTESTS6_SPEC2_19_FWDTHENFORWARDSERVLETRESOURCE_ATTRIBUTES8,
            "In a servlet forwarded to by the target of a forward, for forwards from the serveResource method, The request attribute javax.portlet.response must be set to the javax.portlet.ResourceResponse object");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations that change the map such as put, remove, etc.,
    * should not be used in portlets.
    */
   public JSR286DispatcherTestCaseDetails() {
      super(tcd);
   }

}
