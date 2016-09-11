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

   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER1 = "V3PortletHubTests_SPEC_23_JS_register1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER2 = "V3PortletHubTests_SPEC_23_JS_register2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER3 = "V3PortletHubTests_SPEC_23_JS_register3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER4 = "V3PortletHubTests_SPEC_23_JS_register4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER5 = "V3PortletHubTests_SPEC_23_JS_register5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER6 = "V3PortletHubTests_SPEC_23_JS_register6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER7 = "V3PortletHubTests_SPEC_23_JS_register7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER8 = "V3PortletHubTests_SPEC_23_JS_register8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER9 = "V3PortletHubTests_SPEC_23_JS_register9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_REGISTERA = "V3PortletHubTests_SPEC_23_JS_registerA";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT1 = "V3PortletHubTests_SPEC_23_JS_PortletInit1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT2 = "V3PortletHubTests_SPEC_23_JS_PortletInit2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT3 = "V3PortletHubTests_SPEC_23_JS_PortletInit3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT4 = "V3PortletHubTests_SPEC_23_JS_PortletInit4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT5 = "V3PortletHubTests_SPEC_23_JS_PortletInit5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT6 = "V3PortletHubTests_SPEC_23_JS_PortletInit6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT7 = "V3PortletHubTests_SPEC_23_JS_PortletInit7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT8 = "V3PortletHubTests_SPEC_23_JS_PortletInit8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT9 = "V3PortletHubTests_SPEC_23_JS_PortletInit9";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITA = "V3PortletHubTests_SPEC_23_JS_PortletInitA";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITB = "V3PortletHubTests_SPEC_23_JS_PortletInitB";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITC = "V3PortletHubTests_SPEC_23_JS_PortletInitC";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITD = "V3PortletHubTests_SPEC_23_JS_PortletInitD";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS1 = "V3PortletHubTests_SPEC_23_JS_Constants1";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS2 = "V3PortletHubTests_SPEC_23_JS_Constants2";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS3 = "V3PortletHubTests_SPEC_23_JS_Constants3";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS4 = "V3PortletHubTests_SPEC_23_JS_Constants4";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS5 = "V3PortletHubTests_SPEC_23_JS_Constants5";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS6 = "V3PortletHubTests_SPEC_23_JS_Constants6";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS7 = "V3PortletHubTests_SPEC_23_JS_Constants7";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS8 = "V3PortletHubTests_SPEC_23_JS_Constants8";
   public final static String V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS9 = "V3PortletHubTests_SPEC_23_JS_Constants9";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER1, "The portlet hub provides a global namespace var portlet of type object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER2, "The global portlet object register property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER3, "The portlet hub register function throws an IllegalArgumentException if no portlet ID argument is provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER4, "The portlet hub register function throws an IllegalArgumentException if too many (&gt;1) arguments are provided");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER5, "The portlet hub register function throws an IllegalArgumentException if the portlet ID is not a string");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER6, "The portlet hub register function throws an IllegalArgumentException if the portlet ID is undefined");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER7, "The portlet hub register function throws an IllegalArgumentException if the portlet ID is null");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER8, "The portlet hub register function The promise fails if the portlet ID is not defined for the portlet hub");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTER9, "The portlet hub register function does not throw an exception if the portlet ID is valid");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_REGISTERA, "The portlet hub register function returns an object when provided with a valid portlet ID");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT1, "The PortletInit object portletModes property is an array");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT2, "The PortletInit object windowStates property is an array");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT3, "The PortletInit object action property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT4, "The PortletInit object addEventListener property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT5, "The PortletInit object createResourceUrl property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT6, "The PortletInit object dispatchClientEvent property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT7, "The PortletInit object isInProgress property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT8, "The PortletInit object newParameters property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINIT9, "The PortletInit object newState property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITA, "The PortletInit object removeEventListener property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITB, "The PortletInit object setRenderState property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITC, "The PortletInit object startPartialAction property is type function");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_PORTLETINITD, "The PortletInit object constants property is type object");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS1, "The Constants object VIEW property is type string and equal to 'VIEW'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS2, "The Constants object EDIT property is type string and equal to 'EDIT'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS3, "The Constants object HELP property is type string and equal to 'HELP'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS4, "The Constants object NORMAL property is type string and equal to 'NORMAL'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS5, "The Constants object MINIMIZED property is type string and equal to 'MINIMIZED'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS6, "The Constants object MAXIMIZED property is type string and equal to 'MAXIMIZED'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS7, "The Constants object FULL property is type string and equal to 'cacheLevelFull'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS8, "The Constants object PORTLET property is type string and equal to 'cacheLevelPortlet'");
      tcd.put(V3PORTLETHUBTESTS_SPEC_23_JS_CONSTANTS9, "The Constants object PAGE property is type string and equal to 'cacheLevelPage'");

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
