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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.ParameterSet;

/**
 * <P>
 * This interface provides access to a servlet and its attributes.
 * A servlet is defined in the web.xml of a portlet application archive
 * file. Portlet information defined in the portlet.xml is also accessible
 * in this interface when the information is bound to the application code.<br>
 * Additionaly, this interface allows to retrieve all containing elements such
 * as content types. 
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 */
public interface ServletDefinition extends org.apache.pluto.om.Model
{


    /**
     * Returns the identifier of this servlet
     * The return value cannot be NULL.
     * 
     * @return the identifier
     */
    public org.apache.pluto.om.common.ObjectID getId();

    /**
     * Returns the servlet name
     * The return value cannot be NULL.
     * 
     * @return the servlet name
     */
    public String getServletName();

    /**
     * Returns the display name for the given locale of this servlet. 
     * The return value may be NULL.
     * 
     * @return the localized display name
     */
    public DisplayName getDisplayName(Locale locale);

    /**
     * Returns the description for the given locale
     * The return value may be NULL.
     * 
     * @return the description
     */
    public Description getDescription(Locale locale);

    /**
     * Returns the class name of this servlet
     * The return value may be NULL.
     * 
     * @return the class name
     */
    public String getServletClass();

    /**
     * Returns all parameters of this portlet
     * The return value cannot be NULL.
     * 
     * @return the parameter set
     */
    public ParameterSet getInitParameterSet();

    /**
     * Returns the WebApplication object in which this servlet resides
     * The return value cannot be NULL.
     * 
     * @return the WebApplication object of this servlet
     */
    public WebApplicationDefinition getWebApplicationDefinition();

    /**
     * Returns the request dispatcher pointing to this servlet
     * 
     * @param servletContext
     *               a servlet context
     * @return the request dispatcher of this portlet
     */
    public RequestDispatcher getRequestDispatcher(ServletContext servletContext);

    /**
     * Returns the available date/time for this servlet, in milliseconds since
     * the epoch.  If this date/time is in the future the servlet is unavailable.
     * If it is zero, the servlet is currently available. A value equal to Long.MAX_VALUE
     * is considered to mean that unavailability is permanent.
     * 
     * @return the available date/time for this servlet
     */
    public long getAvailable();
    
    /**
     * Returns if this servlet is currently unavailable.
     * 
     * @return <code>true</code> if this servlet is unavailable
     */
    public boolean isUnavailable();
}
