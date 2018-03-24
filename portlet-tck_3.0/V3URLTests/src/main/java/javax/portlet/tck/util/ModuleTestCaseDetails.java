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

   public final static String V3URLTESTS_BASEURL_APPEND = "V3URLTests_BaseURL_append";
   public final static String V3URLTESTS_BASEURL_APPEND2 = "V3URLTests_BaseURL_append2";
   public final static String V3URLTESTS_BASEURL_APPEND3 = "V3URLTests_BaseURL_append3";
   public final static String V3URLTESTS_BASEURL_APPEND4 = "V3URLTests_BaseURL_append4";
   public final static String V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS = "V3URLTests_ActionURL_getActionParameters";
   public final static String V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS2 = "V3URLTests_ActionURL_getActionParameters2";
   public final static String V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS3 = "V3URLTests_ActionURL_getActionParameters3";
   public final static String V3URLTESTS_ACTIONURL_SETPARAMETERB7 = "V3URLTests_ActionURL_setParameterB7";
   public final static String V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS = "V3URLTests_ResourceURL_getResourceParameters";
   public final static String V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS2 = "V3URLTests_ResourceURL_getResourceParameters2";
   public final static String V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS3 = "V3URLTests_ResourceURL_getResourceParameters3";
   public final static String V3URLTESTS_RESOURCEURL_SETPARAMETERB7 = "V3URLTests_ResourceURL_setParameterB7";
   public final static String V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER = "V3URLTests_RenderURL_setFragmentIdentifier";
   public final static String V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER2 = "V3URLTests_RenderURL_setFragmentIdentifier2";
   public final static String V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER3 = "V3URLTests_RenderURL_setFragmentIdentifier3";
   public final static String V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER4 = "V3URLTests_RenderURL_setFragmentIdentifier4";
   public final static String V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER5 = "V3URLTests_RenderURL_setFragmentIdentifier5";
   public final static String V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER = "V3URLTests_RenderURL_getFragmentIdentifier";
   public final static String V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER2 = "V3URLTests_RenderURL_getFragmentIdentifier2";
   public final static String V3URLTESTS_RENDERURL_SETPARAMETERB7 = "V3URLTests_RenderURL_setParameterB7";
   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3URLTESTS_BASEURL_APPEND, "BaseURL.append(Appendable out) method appends the portlet URL to the appendable object.");
      tcd.put(V3URLTESTS_BASEURL_APPEND2, "BaseURL.append(Appendable out) - The appended URL is always XML escaped.");
      tcd.put(V3URLTESTS_BASEURL_APPEND3, "BaseURL.append(Appendable out, boolean escapeXML) - If the parameter escapeXML is set to true, the URL will be escaped to be valid XML characters. The manner in which escaping is performed is implementation specific.");
      tcd.put(V3URLTESTS_BASEURL_APPEND4, "BaseURL.append(Appendable out, boolean escapeXML) - If escapeXML is set to false, escaping the URL is left to the implementation.");
      tcd.put(V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS, "Initially the returned object is empty.");
      tcd.put(V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS2, "Modifying the parameter values encapsulated by the returned object directly modifies the action parameters applied to the URL.");
      tcd.put(V3URLTESTS_ACTIONURL_GETACTIONPARAMETERS3, "Gets the action parameter values set for this URL.");
      tcd.put(V3URLTESTS_ACTIONURL_SETPARAMETERB7, "setParameter(String, String[]): If the value is null, all values for the specified key are removed.");
      tcd.put(V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS, "Initially the returned object is empty.");
      tcd.put(V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS2, "Modifying the parameter values encapsulated by the returned object directly modifies the resource parameters applied to the URL.");
      tcd.put(V3URLTESTS_RESOURCEURL_GETRESOURCEPARAMETERS3, "Gets the resource parameter values set for this URL.");
      tcd.put(V3URLTESTS_RESOURCEURL_SETPARAMETERB7, "setParameter(String, String[]): If the value is null, all values for the specified key are removed.");
      tcd.put(V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER, "Sets a fragment identifier on the URL.");
      tcd.put(V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER2, "A URL can have only a single fragment identifier. Any previously set fragment identifier will be replaced.");
      tcd.put(V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER3, "The fragment identifier consists of additional information appended to the URL after a '#' character.");
      tcd.put(V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER4, "Setting the fragment identifier to null will remove a fragment identifier previously set through this method.");
      tcd.put(V3URLTESTS_RENDERURL_SETFRAGMENTIDENTIFIER5, "Setting the empty string as the fragment identifier will create an empty fragment identifier.");
      tcd.put(V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER, "Gets the fragment identifier previously set on the URL.");
      tcd.put(V3URLTESTS_RENDERURL_GETFRAGMENTIDENTIFIER2, "Returns null if no fragment identifier has been set.");
      tcd.put(V3URLTESTS_RENDERURL_SETPARAMETERB7, "setParameter(String, String[]): If the value is null, all values for the specified key are removed.");

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
