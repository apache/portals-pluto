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

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;

/**
 * <P>
 * The <CODE>PortletApplicationEntity</CODE> interface represents an instance of the
 * application/context describing the portlets. The application instance may only
 * contain one instance of each portlet of the corresponding application description.
 * </P>
 * <P>
 * This interface defines the model as known from the MVC pattern.
 * Its purpose is to provide read access to the data stored in the model.
 * </P>
 * 

 */
public interface PortletApplicationEntity extends org.apache.pluto.om.Model
{


    /**
     * Returns the identifier of this portlet application instance as object id.
     * The return value cannot be NULL.
     * 
     * @return the object identifier
     */
    public ObjectID getId();

    /**
     * Returns all portlet entities contained in the application entity.
     * 
     * @return a collection of <CODE>PortletEntity</CODE> objects
     */
    public PortletEntityList getPortletEntityList();

    /**
     * Returns the portlet application definition.
     * The return value cannot be NULL.
     * 
     * @return the portlet application definition
     */
    public PortletApplicationDefinition getPortletApplicationDefinition();

}
