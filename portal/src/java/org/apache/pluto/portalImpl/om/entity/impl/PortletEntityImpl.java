/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
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
    private PortletEntity modifiedObject;        
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
