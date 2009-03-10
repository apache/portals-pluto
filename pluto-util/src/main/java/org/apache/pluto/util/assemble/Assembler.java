/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.util.assemble;

import org.apache.pluto.util.UtilityException;

/**
 * The pluto assembler is used to assemble a portlet application which is
 * deployable to pluto.
 *
 * @version 1.0
 * @since Oct 15, 2004
 */
public interface Assembler {

    /**
     * Name of the Portlet Application descriptor file relative
     * to the web application root, normally <code>WEB-INF/portlet.xml</code>.
     */
    String PORTLET_XML = "WEB-INF/portlet.xml";

    /**
     * Name of the Web Application descriptor file relative
     * to the web application root, normally <code>WEB-INF/web.xml</code>.
     */
    String SERVLET_XML = "WEB-INF/web.xml";

    /**
     * The fully qualified name of the class responsible for
     * dispatching requests from the Pluto container to portlets. 
     */
    String DISPATCH_SERVLET_CLASS =
        	"org.apache.pluto.container.driver.PortletServlet";

    /**
     * Assemble a web application into a portlet web application which is
     * deployable into the pluto-1.1 portlet container. The specified web
     * application will be overwritten with the new application.
     */
    void assemble(AssemblerConfig config) throws UtilityException;

}

