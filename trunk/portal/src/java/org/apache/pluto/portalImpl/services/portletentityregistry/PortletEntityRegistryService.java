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
import org.apache.pluto.portalImpl.services.Service;

/**
 * <P>
 * The <CODE>PortletPoolService</CODE> interface represents all
 * portlet and portlet application instances available in the portal, such as a
 * Portlet and Application Pool. It is accessed by the datastore layer to get
 * information about the portlets and portlet applications.
 * </P>
 * <P>
 * The interfaces defined in this package represent an abstract object
 * model (OM) that is applicable for different implementations.
 * The abstract OM defines only how the data is stored and accessed
 * in the memory. Each implementation can store the data in different ways.
 * </P>
 * <P>
 * This abstraction layer helps to generalize the portlet container from
 * special implementations like data storage and moreover it is not bound
 * to a special Application Server.
 * </P>
 * 

 */
public abstract class PortletEntityRegistryService extends Service
{


    /**
     * Returns the portlet application instance with the given id.
     * 
     * @return the portlet application instance
     */
    public abstract PortletApplicationEntityList getPortletApplicationEntityList();
    
    /**
     * Returns the portlet Entity with the given id.
     * 
     * @param id   the identifier of the portlet Entity to be returned
     * @return the portlet Entity
     */
    public abstract PortletEntity getPortletEntity(ObjectID id);

    public abstract void store() throws java.io.IOException;
    
    public abstract void load() throws java.io.IOException;
    
    public abstract void refresh(PortletEntity portletEntity);
}
