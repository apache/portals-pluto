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

package org.apache.pluto.om.portlet;

import java.util.Locale;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.LanguageSet;
import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.common.ParameterSet;
import org.apache.pluto.om.common.PreferenceSet;
import org.apache.pluto.om.common.SecurityRoleRefSet;
import org.apache.pluto.om.servlet.ServletDefinition;

/**
 * <P>
 * This interface provides access to a portlet and its attributes.
 * A portlet is defined in the portlet.xml of a portlet application archive
 * file.
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 
 */
public interface PortletDefinition extends org.apache.pluto.om.Model
{


    /**
     * Returns the identifier of this portlet as object id.
     * The return value cannot be NULL.
     *
     * @return the object identifier
     */
    public ObjectID getId();

    /**
     * Returns the class name
     * 
     * @return the class name
     */
    public String getClassName();

    /**
     * Returns the administrative name
     * The return value cannot be NULL.
     * 
     * @return the administrative name
     */
    public String getName();

    /**
     * Returns the description for the given locale
     * The return value may be NULL.
     * 
     * @return the description
     */
    public Description getDescription(Locale locale);
      
    /**
     * Returns all resource information of this portlet
     * 
     * @return the portlet resources
     */
    public LanguageSet getLanguageSet();

    /**
     * Returns all parameters of this portlet
     * The return value cannot be NULL.
     * 
     * @return the parameter set
     */
    public ParameterSet getInitParameterSet();
    
    /**
     * Returns all SecurityRoleRefs of this portlet
     * 
     * @return the SecurityRoleRef set
     */
    public SecurityRoleRefSet getInitSecurityRoleRefSet();


    /**
     * Returns all preferences of this portlet
     * 
     * @return the preference set
     */
    public PreferenceSet getPreferenceSet();

    /**
     * Returns all supported content types of this portlet
     * 
     * @return the content type set
     */
    public ContentTypeSet getContentTypeSet();

    /**
     * Returns the PortletApplication object in which this portlet resides
     * The return value cannot be NULL.
     * 
     * @return the PortletApplication object of this portlet
     */
    public PortletApplicationDefinition getPortletApplicationDefinition();

    /**
     * Returns the corresponding servlet to this portlet
     * The return value cannot be NULL. 
     * 
     * @return a servlet object
     */
    public ServletDefinition getServletDefinition();


    /**
     * Returns the display name of this portlet for the given locale.
     * The return value may be NULL.
     * 
     * @return display name for the given locale
     */
    public DisplayName getDisplayName(Locale locale);

    /**
     * Returns duration (in seconds) of expiration cache
     * 
     * @return duration of expiration cache
     */
    public String getExpirationCache();

    /**
     * Returns the class loader of the portlet
     * The return value may be NULL 
     * if the class loader is not yet available.
     *
     * @return java.util.ClassLoader
     */
    public ClassLoader getPortletClassLoader();

}
