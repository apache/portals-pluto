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

package org.apache.pluto.impl;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import java.util.Properties;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 11:18:22 AM
 */
public class PortletConfigImpl implements PortletConfig {

    private String name;
    private PortletContext context;
    private Map initParameters;
    private ResourceBundle resourceBundle;

    public PortletConfigImpl(String name,
                             PortletContext context,
                             ResourceBundle bundle,
                             Map initParameters) {
        this.name = name;
        this.context = context;
        this.resourceBundle = bundle;
        this.initParameters = initParameters;
    }
    
    public String getPortletName() {
        return name;
    }

    public PortletContext getPortletContext() {
        return context;
    }

    /** TODO: Implement Spec PLT6.2 */
    public ResourceBundle getResourceBundle(Locale locale) {
         return resourceBundle;
    }

    public String getInitParameter(String s) {
        return (String)initParameters.get(s);
    }

    public Enumeration getInitParameterNames() {
        return new Vector(initParameters.values()).elements();
    }

}
