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

package org.apache.pluto.om.portlet;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.servlet.WebApplicationDefinition;

/**
 * <P>
 * This interface provides access to a portlet application and its attributes.
 * A portlet application is defined in the portlet.xml of a portlet application
 * archive file.<br>
 * Additionally, this interface allows to retrieve containing elements such
 * as portlets. 
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 
 */
public interface PortletApplicationDefinition extends org.apache.pluto.om.Model
{


    /**
     * Returns the identifier of this portlet as object id.
     * The return value cannot be NULL.
     * 
     * @return the object identifier
     */
    public ObjectID getId();

    /**
     * Returns the version of this portlet application.
     * The return value may be NULL.
     * 
     * @return the version
     */
    public String getVersion();
    

    /**
     * Returns all portlets contained in this portlet application.
     * The return value cannot be NULL.
     * 
     * @return a collection containing PortletDefinition objects
     */
    public PortletDefinitionList getPortletDefinitionList();

    /**
     * Returns the corresponding web application to this portlet application.
     * The return value cannot be NULL.
     * 
     * @return a web application
     */
    public WebApplicationDefinition getWebApplicationDefinition();
    
}
