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

   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GENERAL = "V3RenderStateTests_SPEC1_12_RenderState_general";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS = "V3RenderStateTests_SPEC1_12_RenderState_getRenderParameters";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS2 = "V3RenderStateTests_SPEC1_12_RenderState_getRenderParameters2";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS3 = "V3RenderStateTests_SPEC1_12_RenderState_getRenderParameters3";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE = "V3RenderStateTests_SPEC1_12_RenderState_getPortletMode";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE2 = "V3RenderStateTests_SPEC1_12_RenderState_getPortletMode2";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE = "V3RenderStateTests_SPEC1_12_RenderState_getWindowState";
   public final static String V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE2 = "V3RenderStateTests_SPEC1_12_RenderState_getWindowState2";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS = "V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS2 = "V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters2";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS3 = "V3RenderStateTests_SPEC2_12_MutableRenderState_getRenderParameters3";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE = "V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE2 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode2";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE3 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode3";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE4 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode4";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE5 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode5";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE6 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setPortletMode6";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE = "V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE2 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState2";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE3 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState3";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE4 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState4";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE5 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState5";
   public final static String V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE6 = "V3RenderStateTests_SPEC2_12_MutableRenderState_setWindowState6";
   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GENERAL, "RenderState interface provides read-only access to the render state.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS, "Returns an RenderParameters object representing the private and public render parameters.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS2, "The RenderParameters object return by this method is immutable.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETRENDERPARAMETERS3, "If no render parameters are available, the object will be empty.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE, "Returns the current portlet mode of the portlet.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETPORTLETMODE2, "If the portlet mode is not available, PortletMode.UNDEFINED is returned. The portlet mode would not be available in a resource request invoked with a resource URL having FULL cacheability.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE, "Returns the current window state of the portlet.");
      tcd.put(V3RENDERSTATETESTS_SPEC1_12_RENDERSTATE_GETWINDOWSTATE2, "If the window state is not available, WindowState.UNDEFINED is returned. The window state would not be available in a resource request invoked with a resource URL having FULL cacheability.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS, "Returns an MutableRenderParameters object representing the private and public render parameters.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS2, "The MutableRenderParameters object return by this method is mutable.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_GETRENDERPARAMETERS3, "If no render parameters are available, the object will be empty.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE, "Sets the portlet mode of a portlet to the given portlet mode.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE2, "A custom portlet mode declared in deployment descriptor could be set.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE3, "Not more than one portlet mode can be set. If more than one portlet mode is set, only the last one set is valid.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE4, "Throws PortletModeException if the portlet cannot switch to this mode.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE5, "Throws IllegalStateException if the method is invoked after sendRedirect has been called.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETPORTLETMODE6, "Throws IllegalArgumentException if the input parameter is null.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE, "Sets the window state of a portlet to the given window state.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE2, "A custom window state declared in deployment descriptor could be set.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE3, "Not more than one window state can be set. If more than one window state is set, only the last one set is valid.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE4, "Throws WindowStateException if the portlet cannot switch to this state.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE5, "Throws IllegalStateException if the method is invoked after sendRedirect has been called.");
      tcd.put(V3RENDERSTATETESTS_SPEC2_12_MUTABLERENDERSTATE_SETWINDOWSTATE6, "Throws IllegalArgumentException if the input parameter is null.");
      
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
