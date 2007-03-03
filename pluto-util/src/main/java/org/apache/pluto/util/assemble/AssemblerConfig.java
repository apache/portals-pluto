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

import java.io.File;

/**
 * The pluto assembler configuration.
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 */
public class AssemblerConfig {
	
	// Private Member Variables ------------------------------------------------
	
	/** The portlet app descriptor, which is usually WEB-INF/portlet.xml. */
    private File portletDescriptor = null;
    
    /** The webapp descriptor, which is usually WEB-INF/web.xml. */
    private File webappDescriptor = null;
    
    /** The assemble destination, which points to the assembled WAR file. */
    private File destination = null;

    /** The class of the servlet that will handle portlet requests */
    private String dispatchServletClass = null;
    
    /** A source WAR archive to assemble */
    private File warSource = null;
    
    // Public Methods ----------------------------------------------------------
    
    public File getPortletDescriptor() {
        return portletDescriptor;
    }
    
    public void setPortletDescriptor(File portletDescriptor) {
        this.portletDescriptor = portletDescriptor;
    }
    
    public File getWebappDescriptor() {
        return webappDescriptor;
    }
    
    public void setWebappDescriptor(File webappDescriptor) {
        this.webappDescriptor = webappDescriptor;
    }
    
    public File getDestination() {
        return destination;
    }
    
    public void setDestination(File destination) {
        this.destination = destination;
    }

    public String getDispatchServletClass() {
        return dispatchServletClass;
    }

    public void setDispatchServletClass(String dispatchServletClass) {
        this.dispatchServletClass = dispatchServletClass;
    }

    public File getWarSource() {
        return this.warSource;
    }

    public void setWarSource(File warSource) {
        this.warSource = warSource;
    }
}
