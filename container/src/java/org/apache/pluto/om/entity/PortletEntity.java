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

package org.apache.pluto.om.entity;

import java.util.Locale;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.common.PreferenceSet;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.window.PortletWindowList;

/**
 * <P>
 * The <CODE>PortletEntity</CODE> interface represents a single portlet occurance,
 * that can be shown on a single page or on multiple pages.
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 */
public interface PortletEntity extends org.apache.pluto.om.Model
{


    /**
     * Returns the identifier of this portlet instance as object id.
     * The return value cannot be NULL.
     * 
     * @return the object identifier
     */
    public ObjectID getId();

    /**
     * Returns all preferences of this portlet
     * The return value cannot be NULL.
     * 
     * @return the preference set
     */
    public PreferenceSet getPreferenceSet();

    /**
     * Returns the portlet description
     * The return value cannot be NULL.
     * 
     * @return the portlet description
     */
    public PortletDefinition getPortletDefinition();

    /**
     * Returns the parent application instance of this portlet instance
     * The return value cannot be NULL.
     * 
     * @return the parent application instance
     */
    public PortletApplicationEntity getPortletApplicationEntity();

    /**
     * Get a list with all windows which belong to this portlet instance
     * The return value cannot be NULL.
     * 
     * @return <code>PortletWindowList<code> with all windows
     **/
    public PortletWindowList getPortletWindowList();
    
    /**
     * Returns the description of this portlet entity for the given locale. 
     * The return value may be NULL.
     * 
     * @return the description for the given locale
     */
    public Description getDescription(Locale locale);

}
