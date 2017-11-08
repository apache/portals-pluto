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
 * for the JSR 362 TCK.
 * <p>
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

    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_3_GETNAMES = "V3PortletParametersTests_SPEC11_3_getNames";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUE = "V3PortletParametersTests_SPEC11_3_getValue";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUES = "V3PortletParametersTests_SPEC11_3_getValues";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_3_SIZE = "V3PortletParametersTests_SPEC11_3_size";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_3_CLONE = "V3PortletParametersTests_SPEC11_3_clone";

    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4_GETNAMES = "V3PortletParametersTests_SPEC11_4_getNames";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUE = "V3PortletParametersTests_SPEC11_4_getValue";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUES = "V3PortletParametersTests_SPEC11_4_getValues";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4_SIZE = "V3PortletParametersTests_SPEC11_4_size";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4_CLONE = "V3PortletParametersTests_SPEC11_4_clone";

    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETNAMES = "V3PortletParametersTests_SPEC11_4A_actionPhaseGetNames";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETVALUES = "V3PortletParametersTests_SPEC11_4A_actionPhaseGetValues";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_SIZE = "V3PortletParametersTests_SPEC11_4A_actionPhaseSize";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETNAMES = "V3PortletParametersTests_SPEC11_4A_headerPhaseGetNames";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETVALUES = "V3PortletParametersTests_SPEC11_4A_headerPhaseGetValues";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_SIZE = "V3PortletParametersTests_SPEC11_4A_headerPhaseSize";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETNAMES = "V3PortletParametersTests_SPEC11_4A_renderPhaseGetNames";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETVALUES = "V3PortletParametersTests_SPEC11_4A_renderPhaseGetValues";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_SIZE = "V3PortletParametersTests_SPEC11_4A_renderPhaseSize";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETNAMES = "V3PortletParametersTests_SPEC11_4A_resourcePhaseGetNames";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETVALUES = "V3PortletParametersTests_SPEC11_4A_resourcePhaseGetValues";
    public final static String V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_SIZE = "V3PortletParametersTests_SPEC11_4A_resourcePhaseSize";

    private final static Map<String, String> tcd = new HashMap<String, String>();

    static {

        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETNAMES, "Returns a set of strings representing the portlet parameter names");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUE, "Returns a single portlet parameter value as a string for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_GETVALUES, "Returns all portlet parameter value as a string array for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_SIZE, "Returns the number of portlet parameters available");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_1_CLONE, "Clones the given portlet parameters returning a mutable copy of the parameters");

        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETNAMES, "Returns a set of strings representing the action parameter names");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUE, "Returns a single action parameter value as a string for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_3_GETVALUES, "Returns all action parameter value as a string array for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_3_SIZE, "Returns the number of action parameters available");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_3_CLONE, "Clones the given action parameters returning a mutable copy of the parameters");

        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETNAMES, "Returns a set of strings representing the resource parameter names");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUE, "Returns a single action resource value as a string for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4_GETVALUES, "Returns all resource parameter value as a string array for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4_SIZE, "Returns the number of resource parameters available");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4_CLONE, "Clones the given resource parameters returning a mutable copy of the parameters");

        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETNAMES, "Returns one set of strings containing the action parameter names and another containing the render parameter names");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_GETVALUES, "Returns one string array of action parameter values for a given name, and another with render parameter values for a different name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_ACTION_PHASE_SIZE, "Returns the number of action and render parameters available");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETNAMES, "Returns a set of strings containing the render parameter names");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_GETVALUES, "Returns a string array of render parameter values for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_HEADER_PHASE_SIZE, "Returns the number of action and render parameters available");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETNAMES, "Returns a set of strings containing the render parameter names");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_GETVALUES, "Returns a string array of render parameter values for a given name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RENDER_PHASE_SIZE, "Returns the number of action and render parameters available");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETNAMES, "Returns one set of strings containing the resource parameter names and another containing the render parameter names");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_GETVALUES, "Returns one string array of resource parameter values for a given name, and another with render parameter values for a different name");
        tcd.put(V3PORTLETPARAMETERSTESTS_SPEC11_4A_RESOURCE_PHASE_SIZE, "Returns the number of resource and render parameters available");
    }

    /**
     * Constructor.
     * <p>
     * Passes the static test case names - details map to the superclass
     * <p>
     * Note that the backing map is static and not threadsafe. Operations
     * that change the map such as put, remove, etc., should not be used
     * in portlets.
     */
    public ModuleTestCaseDetails() {
        super(tcd);
    }

}
