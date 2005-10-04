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

package org.apache.pluto.portalImpl.om.portlet.impl;

import java.util.HashSet;
import java.util.Iterator;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinitionList;
import org.apache.pluto.util.StringUtils;

public class PortletApplicationDefinitionListImpl extends HashSet
implements PortletApplicationDefinitionList, java.io.Serializable {

    public PortletApplicationDefinitionListImpl()
    {
    }

    // PortletApplicationDefinitionList implementation.

    public PortletApplicationDefinition get(ObjectID objectId)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            PortletApplicationDefinition portletApplicationDefinition = (PortletApplicationDefinition)iterator.next();
            if (portletApplicationDefinition.getId().equals(objectId)) {
                return portletApplicationDefinition;
            }
        }
        return null;
    }

    // additional internal methods

    public PortletApplicationDefinition get(String objectId)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            PortletApplicationDefinition portletApplicationDefinition = (PortletApplicationDefinition)iterator.next();
            if (portletApplicationDefinition.getId().toString().equals(objectId)) {
                return portletApplicationDefinition;
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
            buffer.append(((PortletApplicationDefinitionImpl)iterator.next()).toString(indent+2));
        }
        return buffer.toString();
    }
}
