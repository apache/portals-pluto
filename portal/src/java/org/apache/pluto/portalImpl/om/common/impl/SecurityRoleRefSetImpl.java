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

import java.util.HashSet;
import java.util.Iterator;

import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.SecurityRoleRef;
import org.apache.pluto.om.common.SecurityRoleRefSet;
import org.apache.pluto.om.common.SecurityRoleRefSetCtrl;
import org.apache.pluto.util.StringUtils;

public class SecurityRoleRefSetImpl extends HashSet implements SecurityRoleRefSet, SecurityRoleRefSetCtrl, java.io.Serializable {

    public SecurityRoleRefSetImpl()
    {
    }

    // SecurityRoleRefSet implementation.

    public SecurityRoleRef get(String roleName)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            SecurityRoleRef securityRoleRef = (SecurityRoleRef)iterator.next();
            if (securityRoleRef.getRoleName().equals(roleName)) {
                return securityRoleRef;
            }
        }
        return null;
    }

    // SecurityRoleRefSetCtrl implementation.

    public SecurityRoleRef add(SecurityRoleRef securityRoleRef)
    {
        SecurityRoleRefImpl newSecurityRoleRef = new SecurityRoleRefImpl();
        newSecurityRoleRef.setRoleName(securityRoleRef.getRoleName());
        newSecurityRoleRef.setRoleLink(securityRoleRef.getRoleLink());
        newSecurityRoleRef.setDescriptionSet(((SecurityRoleRefImpl)securityRoleRef).getDescriptionSet());

        super.add(newSecurityRoleRef);

        return newSecurityRoleRef;
    }

    public SecurityRoleRef remove(String roleName)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            SecurityRoleRef securityRoleRef = (SecurityRoleRef)iterator.next();
            if (securityRoleRef.getRoleName().equals(roleName)) {
                super.remove(securityRoleRef);
                return securityRoleRef;
            }
        }
        return null;
    }

    public void remove(SecurityRoleRef securityRoleRef)
    {
        super.remove(securityRoleRef);
    }

    // additional methods.
    
    public SecurityRoleRef add(String roleName, String roleLink, DescriptionSet descriptions)
    {
        SecurityRoleRefImpl securityRoleRef = new SecurityRoleRefImpl();
        securityRoleRef.setRoleName(roleName);
        securityRoleRef.setRoleLink(roleLink);
        securityRoleRef.setDescriptionSet(descriptions);

        super.add(securityRoleRef);

        return securityRoleRef;
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
            buffer.append(((SecurityRoleRefImpl)iterator.next()).toString(indent+2));
        }
        return buffer.toString();
    }

    // unmodifiable part

    public static class Unmodifiable extends org.apache.pluto.portalImpl.om.common.impl.UnmodifiableSet
            implements SecurityRoleRefSet {

        public Unmodifiable(SecurityRoleRefSet c)
        {
            super(c);
        }

        // additional methods.

        public SecurityRoleRef get(String roleName)
        {
            return((SecurityRoleRefSet)c).get(roleName);
        }

    }

}
