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
import java.util.Locale;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.common.PreferenceSet;
import org.apache.pluto.om.entity.PortletApplicationEntity;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.om.entity.PortletEntityCtrl;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.window.PortletWindowList;
import org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl;
import org.apache.pluto.portalImpl.services.portletentityregistry.PortletEntityRegistry;
import org.apache.pluto.util.StringUtils;

public class PortletEntityImpl
implements PortletEntity, PortletEntityCtrl, java.io.Serializable,
org.apache.pluto.portalImpl.om.common.Support {

    private String id;
    private String definitionId;

    protected PreferenceSet preferences;

    private PreferenceSet origPreferences;
    private PortletApplicationEntity applicationEntity;
    private PortletWindowList portletWindows;
    private ObjectID objectId;
    private DescriptionSet descriptions;

    public PortletEntityImpl()
    {
        id              = "";
        definitionId    = "";
        preferences     = new org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl();
        origPreferences = new org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl();
        portletWindows  = new org.apache.pluto.portalImpl.om.window.impl.PortletWindowListImpl();
        descriptions    = new org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl();
    }

    // PortletEntity implementation.

    public ObjectID getId()
    {
        if (objectId==null && applicationEntity != null) {
            objectId = org.apache.pluto.portalImpl.util.ObjectID.createFromString(applicationEntity.getId().toString()
                                                                                  + "." + id);
        }
        return objectId;
    }    

    public PreferenceSet getPreferenceSet()
    {
        return preferences;
    }

    public PortletDefinition getPortletDefinition()
    {
        return applicationEntity.getPortletApplicationDefinition().getPortletDefinitionList().get(org.apache.pluto.portalImpl.util.ObjectID.createFromString(definitionId));
    }

    public void setPortletDefinition(PortletDefinition portletDefinition)
    {
        this.definitionId = portletDefinition.getId().toString();
    }

    public PortletApplicationEntity getPortletApplicationEntity()
    {
        return applicationEntity;
    }

    public PortletWindowList getPortletWindowList() {
        return portletWindows;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.om.entity.PortletEntity#getDescriptionSet()
     */
    public Description getDescription(Locale locale) {
        return descriptions.get(locale);
    }

    // PortletEntityCtrl implementation.

    public void setId(String id)
    {
        this.id = id;
        objectId = null;
    }

    public void store() throws java.io.IOException
    {
        PortletEntityRegistry.store();

        //save preferences as original preferences
        origPreferences = new org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl();
        ((org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl)origPreferences).addAll((Collection)preferences);
    }

    public void reset() throws java.io.IOException
    {
        //reset by re-activating original preferences
        preferences = new org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl();
        ((org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl)preferences).clear();
        ((org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl)preferences).addAll((Collection)origPreferences);
    }

    // org.apache.pluto.portalImpl.om.common.Support implementation.

    public void postLoad(Object parameter) throws Exception
    {        
    }

    public void preBuild(Object parameter) throws Exception
    {        
        ((org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl)origPreferences).addAll((Collection)preferences);
        setPortletApplicationEntity((PortletApplicationEntity)parameter);
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

    // additional methods.
    
    // additional internal methods

    public Collection getCastorPreferences()
    {
        return(org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl)preferences;
    }

    protected void setPortletApplicationEntity(PortletApplicationEntity applicationEntity)
    {
        this.applicationEntity = applicationEntity;
    }

    protected void setPortletWindowList(PortletWindowList portletWindows)
    {
        this.portletWindows = portletWindows;
    }

    // internal methods used for castor only 
    public String getCastorId() {                
        //ObjectID oid = getId();        
        //if(oid == null) 
        //return null;

        //return  oid.toString();
        return id.length() > 0 ? id : null;
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
        buffer.append(((org.apache.pluto.portalImpl.om.common.impl.PreferenceSetImpl)preferences).toString(indent));
        StringUtils.newLine(buffer,indent);
        buffer.append(((DescriptionSetImpl) descriptions).toString(indent));

        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }
}
