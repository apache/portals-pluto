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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PortletDefinitionList;
import org.apache.pluto.om.servlet.WebApplicationDefinition;
import org.apache.pluto.portalImpl.om.common.Support;
import org.apache.pluto.portalImpl.om.servlet.impl.WebApplicationDefinitionImpl;
import org.apache.pluto.util.StringUtils;

public class PortletApplicationDefinitionImpl 
implements PortletApplicationDefinition, java.io.Serializable, Support {

    private String GUID = null;

    private String appId = null;
    private String version = null;

    private ArrayList customPortletMode = new ArrayList();
    private ArrayList customPortletState = new ArrayList();
    private ArrayList userAttribute = new ArrayList();
    private ArrayList securityConstraint = new ArrayList();

    private PortletDefinitionList portlets = new PortletDefinitionListImpl();

    private WebApplicationDefinition webApplication = null;

    private ObjectID objectId = null;

    private String contextPath = null;

    // PortletApplicationDefinition implementation.

    public ObjectID getId()
    {
        if (objectId==null) {
            objectId = org.apache.pluto.portalImpl.util.ObjectID.createFromString(getGUID());                        
        }
        return objectId;
    }

    public String getVersion()
    {
        return version;
    }

    public PortletDefinitionList getPortletDefinitionList()
    {
        return portlets;
    }

    public WebApplicationDefinition getWebApplicationDefinition()
    {
        return webApplication;
    }

    // Support implementation.

    public void postLoad(Object parameter) throws Exception
    {
        ((Support)portlets).postLoad(parameter);
    }

    public void preBuild(Object parameter) throws Exception
    {
        Vector structure = (Vector)parameter;
        String contextRoot = (String)structure.get(0);
        WebApplicationDefinition webApplication = (WebApplicationDefinition)structure.get(1);
        Map servletMap = (Map)structure.get(2);

        setContextRoot(contextRoot);

        setWebApplicationDefinition(webApplication);       

        Vector structure2 = new Vector();
        structure2.add(this);
        structure2.add(servletMap);

        ((Support)portlets).preBuild(structure2);

    }
    
    public void postBuild(Object parameter) throws Exception
    {
    }

    public void preStore(Object parameter) throws Exception
    {
        ((Support)portlets).preStore(parameter);
    }

    public void postStore(Object parameter) throws Exception
    {
        ((Support)portlets).postStore(parameter);
    }

    // internal methods.

    private String getGUID()
    {
        if (GUID == null) {
            GUID = "";            
            String id = "";

            if (webApplication != null) {
                id = webApplication.getContextRoot();
            } else {
                id = contextPath;
            }

            if (id!=null) {
                if (id.startsWith("/")) {
                    id = id.substring(id.indexOf("/")+1);
                }

                GUID += id;
            }
        }

        return GUID;
    }

    private void setContextRoot(String contextRoot)
    {
        this.contextPath = contextRoot;                
    }

    // additional methods.

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }


    // not yet fully supported:
    public Collection getCustomPortletMode()
    {
        return customPortletMode;
    }

    public void setCustomPortletMode(Collection customPortletMode)
    {
        this.customPortletMode = (ArrayList)customPortletMode;
    }

    public Collection getCustomPortletState()
    {
        return customPortletState;
    }

    public void setCustomPortletState(Collection customPortletState)
    {
        this.customPortletState = (ArrayList)customPortletState;
    }

    public Collection getUserAttribute()
    {
        return userAttribute;
    }

    public void setUserAttribute(Collection userAttribute)
    {
        this.userAttribute = (ArrayList)userAttribute;
    }

    public Collection getSecurityConstraint()
    {
        return securityConstraint;
    }

    public void setSecurityConstraint(Collection securityConstraint)
    {
        this.securityConstraint = (ArrayList)securityConstraint;
    }

    // additional internal methods

    public Collection getCastorPortlets()
    {
        return(PortletDefinitionListImpl)portlets;
    }

    protected void setWebApplicationDefinition(WebApplicationDefinition webApplication)
    {
        this.webApplication = webApplication;
    }

    // internal methods used for debugging purposes only

    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(50);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString()); buffer.append(":");
        StringUtils.newLine(buffer,indent);
        buffer.append("{");
        StringUtils.newLine(buffer,indent);
        buffer.append("objectID='"); buffer.append(getId().toString()); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("GUID='"); buffer.append(GUID); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("version='"); buffer.append(version); buffer.append("'");

        Iterator iterator = portlets.iterator();
        if (iterator.hasNext()) {
            StringUtils.newLine(buffer,indent);
            buffer.append("Portlets:");
        }
        while (iterator.hasNext()) {
            buffer.append(((PortletDefinitionImpl)iterator.next()).toString(indent+2));
        }
        if (webApplication!=null) {
            StringUtils.newLine(buffer,indent);
            buffer.append("webApplication:");
            buffer.append(((WebApplicationDefinitionImpl)webApplication).toString(indent+2));
        }
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

}
