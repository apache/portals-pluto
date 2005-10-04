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

package org.apache.pluto.om.servlet;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.ParameterSet;
import org.apache.pluto.om.common.SecurityRoleSet;

/**
 * <P>
 * This interface provides access to a web application and its attributes.
 * A web application is defined in the web.xml of a portlet application
 * archive file. Portlet application information defined in the portlet.xml
 * is also accessible in this interface when the information is bound
 * to the application code.<br>
 * Additionally, this interface allows to retrieve containing elements such
 * as servlets. 
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 */
public interface WebApplicationDefinition extends org.apache.pluto.om.Model
{


    /**
     * Returns the identifier of this web application.
     * The return value cannot be NULL.
     * 
     * @return the identifier
     */
    public org.apache.pluto.om.common.ObjectID getId();

    /**
     * Returns the display name for the given locale of this web application. 
     * The return value may be NULL.
     * 
     * @return the localized display name
     */
    public DisplayName getDisplayName(Locale locale);

    /**
     * Returns the description of this web application for the given locale. 
     * The return value may be NULL.
     * 
     * @return the localized description
     */
    public Description getDescription(Locale locale);

    /**
     * Returns all parameters of this web application.
     * The return value cannot be NULL.
     * 
     * @return the parameter set
     */
    public ParameterSet getInitParameterSet();

    /**
     * Returns all servlets contained in this web application.
     * The return value cannot be NULL.
     * 
     * @return a collection containing ServletModel objects
     */
    public ServletDefinitionList getServletDefinitionList();

    /**
     * Returns the servlet context of this web application.
     * The return value cannot be NULL.
     * 
     * @param servletContext
     *               a servlet context
     * 
     * @return the servlet context of this web application
     */
    public ServletContext getServletContext(ServletContext servletContext);

    /**
     * Returns the context root of the web application.
     * The return value cannot be NULL.
     * 
     * @return the context root
     */
    public String getContextRoot();
    
    /**
     * Returns the security roles defined for the web application.
     * The returned value cannot be NULL.
     * 
     * @return a set containing SecurityRole objects 
     */
    public SecurityRoleSet getSecurityRoles();
    
}
