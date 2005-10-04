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

package org.apache.pluto.portalImpl.om.servlet.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.apache.pluto.om.servlet.ServletDefinition;
import org.apache.pluto.om.servlet.ServletDefinitionList;
import org.apache.pluto.om.servlet.ServletDefinitionListCtrl;
import org.apache.pluto.om.servlet.WebApplicationDefinition;
import org.apache.pluto.portalImpl.om.common.AbstractSupportSet;
import org.apache.pluto.portalImpl.om.common.Support;
import org.apache.pluto.portalImpl.xml.XmlException;
import org.apache.pluto.util.StringUtils;

public class ServletDefinitionListImpl extends AbstractSupportSet
implements ServletDefinitionList, ServletDefinitionListCtrl, java.io.Serializable, Support {

    // ServletDefinitionList implementation.

    public ServletDefinition get(String name)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ServletDefinition servletDefinition = (ServletDefinition)iterator.next();
            if (servletDefinition.getServletName().equals(name)) {
                return servletDefinition;
            }
        }
        return null;
    }

    // ServletDefinitionListCtrl implementation.

    public ServletDefinition add(String name, String className)
    {
        ServletDefinitionImpl servletDefinition = new ServletDefinitionImpl();
        servletDefinition.setServletName(name);
        servletDefinition.setServletClass(className);

        super.add(servletDefinition);

        return servletDefinition;
    }

    public ServletDefinition remove(String name)
    {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ServletDefinition servletDefinition = (ServletDefinition)iterator.next();
            if (servletDefinition.getServletName().equals(name)) {
                super.remove(servletDefinition);
                return servletDefinition;
            }
        }
        return null;
    }

    public void remove(ServletDefinition servletDefinition)
    {
        super.remove(servletDefinition);
    }

    // Support implementation.

    public void preBuild(Object parameter) throws Exception
    {
        Vector structure = (Vector)parameter;
        WebApplicationDefinition webApplicationDefinition =  (WebApplicationDefinition)structure.get(0);
        Collection servletMappings = (Collection)structure.get(1);
        HashMap servletMap = (HashMap)structure.get(2);

        // build internal hashtable to cross link mappings with servlets
        HashMap mappings = new HashMap(servletMappings.size());
        Iterator iterator = servletMappings.iterator();
        while (iterator.hasNext()) {
            ServletMappingImpl servletMapping = (ServletMappingImpl)iterator.next();
            mappings.put(servletMapping.getServletName(),servletMapping);
        }
        // update servlets
        iterator = this.iterator();
        while (iterator.hasNext()) {
            ServletDefinition servlet = (ServletDefinition)iterator.next();
            ((Support)servlet).preBuild(webApplicationDefinition);

            if (servlet.getInitParameterSet() != null) {
                if (servlet.getInitParameterSet().get("portlet-guid") != null) {
                    String guid = servlet.getInitParameterSet().get("portlet-guid").getValue();
                    servletMap.put(guid, servlet);

                    ServletMappingImpl servletMapping = (ServletMappingImpl)mappings.get(servlet.getServletName());
                    if (mappings==null) {
                        throw new XmlException("No corresponding servlet mapping found for servlet name '"+servlet.getServletName()+"'");
                    }
                    ((Support)servlet).postBuild(servletMapping);

                }
            }
        }

    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#postBuild(Object)
     */
    public void postBuild(Object parameter) throws Exception {
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#postLoad(Object)
     */
    public void postLoad(Object parameter) throws Exception {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ((ServletDefinitionImpl)iterator.next()).postLoad(parameter);
        }

    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#postStore(Object)
     */
    public void postStore(Object parameter) throws Exception {
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#preStore(Object)
     */
    public void preStore(Object parameter) throws Exception {
    }
    
    // additional methods.

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
            buffer.append(((ServletDefinitionImpl)iterator.next()).toString(indent+2));
        }
        return buffer.toString();
    }
}
