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


package org.apache.pluto.portalImpl.om.common.impl;

import java.util.Collection;
import java.util.Locale;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.SecurityRoleRef;
import org.apache.pluto.util.StringUtils;

public class SecurityRoleRefImpl implements SecurityRoleRef, java.io.Serializable
{

    private String roleName;
    private String roleLink;
    private DescriptionSet descriptions;

    public SecurityRoleRefImpl()
    {
        descriptions = new org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl();
    }

    // SecurityRoleRef implementation.

    public String getRoleName()
    {
        return roleName;
    }

    public String getRoleLink()
    {
        return roleLink;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.om.common.SecurityRoleRef#getDescription(Locale)
     */
    public Description getDescription(Locale locale)
    {
        return descriptions.get(locale);
    }


    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    // additional methods.

    public void setRoleLink(String roleLink)
    {
        this.roleLink = roleLink;
    }

    public DescriptionSet getDescriptionSet()
    {
        return descriptions;
    }

    public void setDescriptionSet(DescriptionSet descriptions)
    {
        this.descriptions = descriptions;
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
        buffer.append(": role-name='");
        buffer.append(roleName);
        buffer.append("', role-link='");
        buffer.append(roleLink);
        buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append(((DescriptionSetImpl)descriptions).toString(indent));
        return buffer.toString();
    }

    public Collection getCastorDescriptions()
    {
        return(DescriptionSetImpl)descriptions;
    }

    public void setCastorDescriptions(DescriptionSet castorDescriptions)
    {
        this.descriptions = castorDescriptions;
    }


}
