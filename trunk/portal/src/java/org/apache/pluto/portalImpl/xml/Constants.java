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
/* 

 */

package org.apache.pluto.portalImpl.xml;

/**
 ** This class defines a bunch of constants, especially those needed to
 ** identify attributes for xml-creation and validation.
 **
 **/

public class Constants
{

    // attributes for the entity resolver and xml validation
    public final static String RES_PORTLET_PUBLIC_ID     = "-//Sun Microsystems, Inc.//DTD PortletApplication 1.0//EN";
    public final static String[] RES_PORTLET_DTDS        = {"/org/apache/pluto/portalImpl/xml/portlet-app_1_0.xsd", 
                                                            "/org/apache/pluto/portalImpl/xml/xml.xsd",
                                                            "/org/apache/pluto/portalImpl/xml/XMLSchema.dtd",
                                                            "/org/apache/pluto/portalImpl/xml/datatypes.dtd"};
    public final static String[] RES_PORTLET_DTD_NAMES   = {"portlet-app_1_0.xsd", "xml.xsd", "XMLSchema.dtd", "datatypes.dtd"};

    public final static String RES_WEB_PUBLIC_ID     = "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN";
    public final static String RES_WEB_DTD           = "/org/apache/pluto/portalImpl/xml/web-app_2_3.dtd";
    public final static String RES_WEB_DTD_NAME      = "web-app_2_3.dtd";

    //attributes for the web.xml creation for portlets
    public final static String WEB_PORTLET_PUBLIC_ID = "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN";
    public final static String WEB_PORTLET_DTD = "http://java.sun.com/dtd/web-app_2_3.dtd";

}
