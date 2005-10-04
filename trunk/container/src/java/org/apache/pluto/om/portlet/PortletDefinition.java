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
