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

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.entity.*;
import org.apache.pluto.util.StringUtils;
import java.util.*;

import org.apache.pluto.portalImpl.om.common.AbstractSupportSet;

public class PortletEntityListImpl extends AbstractSupportSet
    implements PortletEntityList, PortletEntityListCtrl, java.io.Serializable {

    // PortletEntityList implementation.

    public PortletEntity get(ObjectID objectId)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            PortletEntity portletEntity = (PortletEntity)iterator.next();
            if (portletEntity.getId().equals(objectId)) {
                return portletEntity;
            }
        }
        return null;
    }


    // PortletEntityListCtrl implementation.

    public PortletEntity add(PortletApplicationEntity appEntity, String definitionId) {
        PortletEntityImpl entity = new PortletEntityImpl();

        int id = -1;
        for (Iterator iter = iterator(); iter.hasNext();) {
            PortletEntityImpl ent = (PortletEntityImpl)iter.next();
            try {
                id = Math.max(id, Integer.parseInt(ent.getCastorId()));
            } catch (NumberFormatException e) {
                //don't care
            }
        }
        entity.setId(Integer.toString(++id));
        entity.setDefinitionId(definitionId);
        entity.setPortletApplicationEntity(appEntity);

        add(entity);

        return entity;
    }

    // additional methods.
    
    public PortletEntity get(String objectId)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            PortletEntity portletEntity = (PortletEntity)iterator.next();
            if (portletEntity.getId().equals(objectId)) {
                return portletEntity;
            }
        }
        return null;
    }

    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(50);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString());
        buffer.append(": ");
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            buffer.append(((PortletEntityImpl)iterator.next()).toString(indent+2));
        }
        return buffer.toString();
    }
}
