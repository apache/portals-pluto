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

/**
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 11:33:47 PM
 */
public class PlutoConstants {

    public static String CONTAINER_NAME = "Pluto Kuiper";
    public static int MAJOR_VERSION = 1;
    public static int MINOR_VERSION = 0;
    
    public static final String PORTLET_REQUEST =
        "javax.portlet.request";
    
    public static final String PORTLET_RESPONSE =
        "javax.portlet.response";
    
    public static final String PORTLET_CONFIG =
        "javax.portlet.config";
    
    
    
    

    public static final String PORTLET_REGISTRY =
        "org.apache.pluto.PortletRegisrty";
    
    public static final String PORTLET_WINDOW =
            "org.apache.pluto.PortletWindow";

    public static final String REQUEST_METHOD
        = "org.apache.pluto.core.request_method";
    
    public static final String ACTION_REQUEST =
        "org.apache.pluto.core.request_method:action";
    
    public static final String RENDER_REQUEST =
        "org.apache.pluto.core.request_method:render";
    
    public static final String LOAD_REQUEST =
        "org.apache.pluto.core.request_method:load";

    public static final String PORTLET_TITLE = "javax.portlet.title";

    public static final String PORTLET_SHORT_TITLE = "javax.portlet.short-title";

    public static final String PORTLET_KEYWORDS = "javax.portlet.keywords";

    public static final String PLUTO_ENVIRONMENT =
        "org.apache.pluto.core.pluto_config";

    public static String LOGGER_SERVICE =
        "org.apache.pluto.core.logger_service";

    public static final String PORTLET_URL_SERVICE =
        "org.apache.pluto.core.portlet_url_service";

}
