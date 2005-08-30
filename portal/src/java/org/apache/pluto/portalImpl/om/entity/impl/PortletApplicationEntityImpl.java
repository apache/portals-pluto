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

package org.apache.pluto.portalImpl.om.entity.impl;

import java.util.Collection;
import java.util.Iterator;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.entity.PortletApplicationEntity;
import org.apache.pluto.om.entity.PortletEntityList;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.portalImpl.services.portletdefinitionregistry.PortletDefinitionRegistry;
import org.apache.pluto.portalImpl.services.ConfigurationException;
import org.apache.pluto.util.StringUtils;

public class PortletApplicationEntityImpl 
implements PortletApplicationEntity, java.io.Serializable,
org.apache.pluto.portalImpl.om.common.Support {

    private String id = "";
    private String definitionId = ""; 
    private PortletEntityList portlets = new PortletEntityListImpl();

    private ObjectID objectId;    

    // PortletApplicationEntity implementation.

    public ObjectID getId()
    {
        if (objectId==null) {
            objectId = org.apache.pluto.portalImpl.util.ObjectID.createFromString(id);
        }
        return objectId;
    }    

    public PortletEntityList getPortletEntityList()
    {
        return portlets;
    }

    public PortletApplicationDefinition getPortletApplicationDefinition()
    {
        PortletApplicationDefinition definition =
            PortletDefinitionRegistry.getPortletApplicationDefinitionList()
                .get(org.apache.pluto.portalImpl.util.ObjectID.createFromString(definitionId));
        if(definition == null) {
            throw new ConfigurationException("Unable to find portlet application definition. "+
                    "Ensure that all portlets definied within the portlet registry are correct" +
                    "and have been deployed.");
        }
        return definition;
    }

    // additional methods.
    
    // additional internal methods

    public void setId(String id)
    {
        this.id = id;
        objectId= null;
    }

    public Collection getCastorPortlets()
    { 
        return(PortletEntityListImpl)portlets;
    }

    public void postLoad(Object parameter) throws Exception
    {
    }

    public void preBuild(Object parameter) throws Exception
    {
        Iterator iterator = portlets.iterator();
        while (iterator.hasNext()) {
            ((PortletEntityImpl)iterator.next()).preBuild(this);
        }
    }

    public void postBuild(Object parameter) throws Exception
    {
    }

    public void preStore(Object parameter) throws Exception
    {
    }

    public void postStore(Object parameter) throws Exception
    {
    }

    // internal methods used for castor only
    public String getCastorId() {                
        return getId().toString();        
    }

    public void setCastorId(String id) {        
        setId(id);
    }   

    public String getDefinitionId()
    {
        return definitionId;
    }

    public void setDefinitionId(String definitionId)
    {
        this.definitionId = definitionId;
    }

    // internal methods used for debugging purposes only

    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(1000);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString()); buffer.append(":");
        StringUtils.newLine(buffer,indent);
        buffer.append("{");
        StringUtils.newLine(buffer,indent);
        buffer.append("id='");
        buffer.append(id);
        buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("definition-id='");
        buffer.append(definitionId);
        buffer.append("'");

        StringUtils.newLine(buffer,indent);
        buffer.append(((org.apache.pluto.portalImpl.om.entity.impl.PortletEntityListImpl)portlets).toString(indent));

        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

}
