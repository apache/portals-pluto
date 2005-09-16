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

package org.apache.pluto.portalImpl.services.portletdefinitionregistry;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.portlet.PortletApplicationDefinitionList;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.portalImpl.services.ServiceManager;

/**
 * This class is a static accessor for a <code>PortletRegistryService</code>
 * implementation.
 * 

 */
public class PortletDefinitionRegistry
{

	//removed final modifier for hot deploy
    private static PortletDefinitionRegistryService cService = 
        (PortletDefinitionRegistryService) ServiceManager.getService (PortletDefinitionRegistryService.class);

    /**
     * Returns a set containg all portlet application definitions
     * 
     * @return the portlet application definition set
     */
    public static PortletApplicationDefinitionList getPortletApplicationDefinitionList()
    {
        return cService.getPortletApplicationDefinitionList();
    }

    /**
     * Returns the portlet definition to the given object id
     * 
     * @return the portlet definition
     */
    public static PortletDefinition getPortletDefinition(ObjectID id)
    {
        return cService.getPortletDefinition(id);
    }

    //method added for hot deploy
     public static void setPortletDefinitionRegistryService()
     {
         PortletDefinitionRegistryService cService = (PortletDefinitionRegistryService) ServiceManager.getService(PortletDefinitionRegistryService.class);
     }    
}
