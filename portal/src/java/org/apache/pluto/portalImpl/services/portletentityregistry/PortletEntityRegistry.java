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

package org.apache.pluto.portalImpl.services.portletentityregistry;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.entity.PortletApplicationEntityList;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.portalImpl.services.ServiceManager;

/**
 * This class is a static accessor for a <code>PortletPoolService</code>
 * implementation.
 * 

 */
public class PortletEntityRegistry
{


    private final static PortletEntityRegistryService cService = 
        (PortletEntityRegistryService) ServiceManager.getService (PortletEntityRegistryService.class);

    /**
     * Returns the portlet application instance with the given id.
     * 
     * @param id   the identifier of the portlet application instance to be returned
     * @return the portlet application instance
     */
    public static PortletApplicationEntityList getPortletApplicationEntityList()
    {
        return cService.getPortletApplicationEntityList();
    }
    
    /**
     * Returns the portlet Entity with the given id.
     * 
     * @param id   the identifier of the portlet Entity to be returned
     * @return the portlet Entity
     */
    public static PortletEntity getPortletEntity(ObjectID id)
    {
        return cService.getPortletEntity(id);
    }

    public static void store() throws java.io.IOException
    {
        cService.store();
    }

    public static void load() throws java.io.IOException
    {
        cService.load();
    }
    
    public static void refresh(PortletEntity portletEntity) {
        cService.refresh(portletEntity);
    }
}
