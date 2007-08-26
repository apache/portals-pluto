/*
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.pluto.descriptors.services;

/**
 * 
 * @version $Id: Constants.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Mar 7, 2005
 */
public class Constants {
	
	//For JSR-168 web.xml
    public static final String WEB_XML_PUBLIC_ID = "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN";
    public static final String WEB_XML_DTD = "http://java.sun.com/dtd/web-app_2_3.dtd";

    //For JSR-286 web.xml
    public static final String SCHEMA_PREFIX = "xsi";
    public static final String SCHEMA_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema-instance";
    public static final String SCHEMA_LOCATION = "http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd";
    
    public static final String PORLTET_XML_PUBLIC_ID = "-//Sun Microsystems, Inc.//DTD PortletApplication 1.0//EN";
    public static final String PORTLET_XML_DTD = "http://java.sun.com/dtd/portlet-app_1_0.dtd";

    private Constants() {

    }

}

