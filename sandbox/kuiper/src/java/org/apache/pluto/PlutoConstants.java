/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pluto;

/** Constant values used throughout the PlutoConatiner.
 *  Perhaps these contants belong in this core package?
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 11:33:47 PM
 */
public class PlutoConstants {

    //
    // Should the container info (name, version) be
    // refactored and loaded from properties?
    //

    /** This containers name. */
    public static String CONTAINER_NAME = "Pluto Kuiper";

    /** This containers major version. */
    public static int MAJOR_VERSION = 1;

    /** This containers minor version. */
    public static int MINOR_VERSION = 0;


    /** Attribute key with which portlet requests are bound. */
    public static final String PORTLET_REQUEST =
        "javax.portlet.request";

    /** Attribute key with which portlet responses are bound. */
    public static final String PORTLET_RESPONSE =
        "javax.portlet.response";

    /** Attribute key with which portlet configs are bound. */
    public static final String PORTLET_CONFIG =
        "javax.portlet.config";

    public static final String PORTLET_TITLE =
         "javax.portlet.title";

    public static final String PORTLET_SHORT_TITLE =
         "javax.portlet.short-title";

    public static final String PORTLET_KEYWORDS =
         "javax.portlet.keywords";

    // PLUTO

    /** Attribute key with which portlet registries are bound. */
    public static final String PORTLET_REGISTRY =
        "org.apache.pluto.PortletRegisrty";

    /** Attribute key with which portlet windows are bound. */
    public static final String PORTLET_WINDOW =
        "org.apache.pluto.PortletWindow";

    /** Attribute key with which the request method id is bound. */
    public static final String REQUEST_METHOD
        = "org.apache.pluto.core.request_method";

    /** Attribute value indicating an Action Request. */
    public static final String ACTION_REQUEST =
        "org.apache.pluto.core.request_method:action";
    
    /** Attribute value indicating an Render Request. */
    public static final String RENDER_REQUEST =
        "org.apache.pluto.core.request_method:render";
    
    /** Attribute value indicating an Load Request. */
    public static final String LOAD_REQUEST =
        "org.apache.pluto.core.request_method:load";

    /** Attribute key with which the service factory is bound. */
    public static final String SERVICE_FACTORY =
        "org.apache.pluto.core.service_factory";
    
    public static final String RENDER_PARAMETERS = 
        "org.apache.pluto.core.render_parameters";
}
