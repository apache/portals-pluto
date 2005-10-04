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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.entity.PortletApplicationEntity;
import org.apache.pluto.om.entity.PortletApplicationEntityList;
import org.apache.pluto.om.entity.PortletApplicationEntityListCtrl;
import org.apache.pluto.portalImpl.om.common.AbstractSupportSet;
import org.apache.pluto.util.StringUtils;

public class PortletApplicationEntityListImpl extends AbstractSupportSet
implements PortletApplicationEntityList, PortletApplicationEntityListCtrl, java.io.Serializable,
org.apache.pluto.portalImpl.om.common.Support {

    // PortletApplicationEntityList implementation.

    public PortletApplicationEntity get(ObjectID objectId)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            PortletApplicationEntity portletApplicationEntity = (PortletApplicationEntity)iterator.next();
            if (portletApplicationEntity.getId().equals(objectId)) {
                return portletApplicationEntity;
            }
        }
        return null;
    }

    // PortletApplicationEntityListCtrl implementation.

    public PortletApplicationEntity add(String definitionId) {
        PortletApplicationEntityImpl entity = new PortletApplicationEntityImpl();

        int id = -1;
        for (Iterator iter = iterator(); iter.hasNext();) {
            PortletApplicationEntityImpl ent = (PortletApplicationEntityImpl)iter.next();
            try {
                id = Math.max(id, Integer.parseInt(ent.getCastorId()));
            } catch (NumberFormatException e) {
                //don't care
            }
        }
        entity.setId(Integer.toString(++id)); 
        entity.setDefinitionId(definitionId);

        add(entity);

        return entity;
    }

    // org.apache.pluto.portalImpl.om.common.Support implemenatation.

    public void postLoad(Object parameter) throws Exception
    {
        this.clear();
        this.addAll(castorApplications);
    }

    public void preBuild(Object parameter) throws Exception
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ((PortletApplicationEntityImpl)iterator.next()).preBuild(this);
        }
    }

    public void postBuild(Object parameter) throws Exception
    {
    }

    public void preStore(Object parameter) throws Exception
    {
        castorApplications.clear();
        castorApplications.addAll(this);
    }

    public void postStore(Object parameter) throws Exception
    {
    }

    // additional methods.

    // additional internal methods

    public PortletApplicationEntity get(String objectId)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            PortletApplicationEntity portletApplicationEntity = (PortletApplicationEntity)iterator.next();
            if (portletApplicationEntity.getId().toString().equals(objectId)) {
                return portletApplicationEntity;
            }
        }
        return null;
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
        Iterator iterator = this.iterator();
        if (iterator.hasNext()) {
            StringUtils.newLine(buffer,indent);
            buffer.append("Portlet Application Entities:");
        }
        while (iterator.hasNext()) {
            buffer.append(((PortletApplicationEntityImpl)iterator.next()).toString(indent+2));
        }
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

    // Castor related methods and attributes

    private Collection castorApplications = new ArrayList();

    public Collection getCastorApplications()
    {        
        return castorApplications;
    }
}
