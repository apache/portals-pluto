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

package org.apache.pluto.portalImpl.om.window.impl;

import org.apache.pluto.om.window.*;
import org.apache.pluto.om.entity.*;
import org.apache.pluto.om.common.ObjectID;

public class PortletWindowImpl implements PortletWindow, PortletWindowCtrl {
        
    
    private ObjectID objectId;
    private String id;
    private PortletEntity portletEntity;

    //counter used to generate unique id's
    private static int counter; 

    public PortletWindowImpl(String id) {
        this.id = id;
    }

    // PortletWindow implementation.

     /**
     * Returns the identifier of this portlet instance window as object id
     *
     * @return the object identifier
     **/
    public ObjectID getId()
    {
        if (objectId==null)
        {
            objectId = org.apache.pluto.portalImpl.util.ObjectID.createFromString(id);
        }
        return objectId;
    }
    /**
     * Returns the portlet entity
     *
     * @return the portlet entity
     **/
    public PortletEntity getPortletEntity()
    {
        return portletEntity;
    }

    // PortletWindowCtrl implementation.
    /**
     * binds an identifier to this portlet window
     *
     * @param id the new identifier
     */
    public void setId(String id)
    {
        this.id = id;
        objectId = null;
    }
    
    /**
     * binds a portlet instance to this portlet window
     * 
     * @param portletEntity a portlet entity object
     **/
    public void setPortletEntity(PortletEntity portletEntity) {
        this.portletEntity = portletEntity;
    }

}