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
