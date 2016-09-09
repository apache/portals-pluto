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

package javax.portlet.tck.util;

import javax.portlet.tck.beans.TestCaseDetails;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines constants for the test case names and test case details 
 * for the JSR 286 API compatibility tests.
 * 
 * Note that the backing map is static and not threadsafe. Operations
 * that change the map such as put, remove, etc., should not be used
 * in portlets.
 * 
 * @author nick
 */
public class ModuleTestCaseDetails extends TestCaseDetails {

   public final static String V3PORTLETCONFIGTESTS_CONFIG_INIT  = "V3PortletConfigTests_Config_init";
   public final static String V3PORTLETCONFIGTESTS_CONFIG_GETPORTLETMODES = "V3PortletConfigTests_Config_getPortletModes";
   public final static String V3PORTLETCONFIGTESTS_CONFIG_GETWINDOWSTATES = "V3PortletConfigTests_Config_getWindowStates";
   public final static String V3PORTLETCONFIGTESTS_CONFIG_GETPUBLICRENDERPARAMETERDEFINITIONS = "V3PortletConfigTests_Config_getPublicRenderParameterDefinitions";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3PORTLETCONFIGTESTS_CONFIG_INIT, "The PortletConfig object is passed to an annotated init method.");
      tcd.put(V3PORTLETCONFIGTESTS_CONFIG_GETPORTLETMODES, "The PortletConfig.getPortletModes method returns the a list of supported portlet modes for this portlet for a given mimetype.");
      tcd.put(V3PORTLETCONFIGTESTS_CONFIG_GETWINDOWSTATES, "The PortletConfig.getWindowStates method returns the a list of supported window states for this portlet for a given mimetype.");
      tcd.put(V3PORTLETCONFIGTESTS_CONFIG_GETPUBLICRENDERPARAMETERDEFINITIONS, "The PortletConfig.getPublicRenderParameterDefinitions method returns the a list of supported public render parameter definitions for this portlet.");

   }

   /**
    * Constructor.
    * 
    * Passes the static test case names - details map to the superclass
    * 
    * Note that the backing map is static and not threadsafe. Operations
    * that change the map such as put, remove, etc., should not be used
    * in portlets.
    */
   public ModuleTestCaseDetails() {
     super(tcd); 
   }

}
