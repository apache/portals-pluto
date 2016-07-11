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

import java.util.HashMap;
import java.util.Map;
import javax.portlet.tck.beans.TestCaseDetails;

/**
 * Defines constants for the test case names and test case details 
 * for the JSR 362 TCK.
 * 
 * Note that the backing map is static and not threadsafe. Operations
 * that change the map such as put, remove, etc., should not be used
 * in portlets.
 * 
 * @author nick
 */
public class ModuleTestCaseDetails extends TestCaseDetails {

   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS = "V3RenderStateTests_SPEC1_12_RenderState_getRenderParameters";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS2 = "V3RenderStateTests_SPEC1_12_RenderState_getRenderParameters2";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE = "V3RenderStateTests_SPEC1_12_RenderState_getPortletMode";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE2 = "V3RenderStateTests_SPEC1_12_RenderState_getPortletMode2";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE = "V3RenderStateTests_SPEC1_12_RenderState_getWindowState";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE2 = "V3RenderStateTests_SPEC1_12_RenderState_getWindowState2";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS, "Returns an RenderParameters object representing the private and public render parameters.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS2, "The RenderParameters object return by this method is immutable.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE, "Returns the current portlet mode of the portlet.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE2, "If the portlet mode is not available, PortletMode.UNDEFINED is returned.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE, "Returns the current window state of the portlet.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE2, "If the window state is not available, WindowState.UNDEFINED is returned.");

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
