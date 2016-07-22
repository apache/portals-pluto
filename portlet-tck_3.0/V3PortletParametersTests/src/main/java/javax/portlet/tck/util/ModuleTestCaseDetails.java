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

   public final static String V3PORTLETPARAMETERSTESTS_SPEC11_1_GETNAMES = "V3PortletParametersTests_SPEC11_1_getNames";
   public final static String V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUE = "V3PortletParametersTests_SPEC11_1_getValue";
   public final static String V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUES = "V3PortletParametersTests_SPEC11_1_getValues";
   public final static String V3PORTLETPARAMETERSTESTS_SPEC11_1_SIZE = "V3PortletParametersTests_SPEC11_1_size";
   public final static String V3PORTLETPARAMETERSTESTS_SPEC11_1_CLONE = "V3PortletParametersTests_SPEC11_1_clone";

   
   private final static Map<String, String> tcd = new HashMap<String, String>();
   static {

      tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETNAMES, "Returns a set of strings representing the portlet parameter names");
      tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUE, "Returns a single portlet parameter value as a string for a given name");
      tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUES, "Returns all portlet parameter value as a string array for a given name");
      tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_SIZE, "Returns the number of portlet parameters available");
      tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_CLONE, "Clones the given portlet parameters returning a mutable copy of the parameters");

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
