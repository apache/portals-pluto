/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
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
