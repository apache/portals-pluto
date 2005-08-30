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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;

import javax.servlet.ServletContext;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.DisplayNameSet;
import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.common.ParameterSet;
import org.apache.pluto.om.common.SecurityRoleSet;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.servlet.ServletDefinitionList;
import org.apache.pluto.om.servlet.WebApplicationDefinition;
import org.apache.pluto.portalImpl.om.common.Support;
import org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl;
import org.apache.pluto.portalImpl.om.common.impl.DisplayNameSetImpl;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.util.StringUtils;

public class WebApplicationDefinitionImpl
implements WebApplicationDefinition, java.io.Serializable, Support {


    // <not used variables - only for castor>
    public String icon;
    public String distributable;
    public String sessionConfig;
    public String mimeMapping;
    public String welcomeFileList;
    public String errorPage;
    public String taglib;
    public String resourceRef;
    public String loginConfig;
    public String securityRole;
    public String envEntry;
    public String ejbRef;
    private Collection castorMimeMappings = new ArrayList();
    // </not used variables - only for castor>
    private Collection securityConstraints = new ArrayList();


    private String contextPath;        
    private DescriptionSet descriptions = new org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl();
    private DisplayNameSet displayNames =  new org.apache.pluto.portalImpl.om.common.impl.DisplayNameSetImpl();
    private String id = "";
    private ParameterSet initParams = new org.apache.pluto.portalImpl.om.common.impl.ParameterSetImpl();
    private ObjectID objectId;
    private Collection servletMappings = new ArrayList();
    private ServletDefinitionList servlets = new ServletDefinitionListImpl();
    private SecurityRoleSet securityRoles = new org.apache.pluto.portalImpl.om.common.impl.SecurityRoleSetImpl();

    // modified by YCLI: START :: to handle multiple taglib tags and resource-ref tag
    // private TagDefinition castorTagDefinition = new TagDefinition();
    private TagDefinitionSet taglibs = new TagDefinitionSet();
    private ResourceRefSet castorResourceRef = new ResourceRefSet();
    // modified by YCLI: END

    // WebApplicationDefinition implementation.
    
    public ObjectID getId() {
        if (objectId==null) {
            objectId = org.apache.pluto.portalImpl.util.ObjectID.createFromString(id);
        }
        return objectId;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.om.servlet.WebApplicationDefinition#getDisplayName(Locale)
     */
    public DisplayName getDisplayName(Locale locale) {
        return displayNames.get(locale);
    }

    public Description getDescription(Locale locale)
    {
        return descriptions.get(locale);
    }

    public ParameterSet getInitParameterSet()
    {
        return initParams;
    }

    public ServletDefinitionList getServletDefinitionList()
    {
        return servlets;
    }

    public ServletContext getServletContext(ServletContext servletContext)
    {
        if (Log.isDebugEnabled()) {
            Log.debug("Looking up ServletContext for path "+contextPath);
        }
        return servletContext.getContext(contextPath);
    }

    public String getContextRoot() {

        return contextPath;
    }

    // Support implementation.

    public void postBuild(Object parameter) throws Exception
    {
        // not needed in this implementation
    }

    public void postLoad(Object parameter) throws Exception
    {
        Vector structure = (Vector)parameter;
        PortletApplicationDefinition portletApplication = (PortletApplicationDefinition)structure.get(0);

        ((Support)portletApplication).postLoad(this);

        ((Support)servlets).postLoad(this);

        ((Support)descriptions).postLoad(parameter);
        ((Support)displayNames).postLoad(parameter);

    }

    public void postStore(Object parameter) throws Exception
    {
        ((Support)servlets).postStore(this);
    }

    public void preBuild(Object parameter) throws Exception
    {
        Vector structure = (Vector)parameter;
        PortletApplicationDefinition portletApplication = (PortletApplicationDefinition)structure.get(0);
        String contextString = (String)structure.get(1);

        setContextRoot(contextString);

        HashMap servletMap = new HashMap(1);
        Vector structure2 = new Vector();
        structure2.add(this);
        structure2.add(servletMappings);
        structure2.add(servletMap);

        ((Support)servlets).preBuild(structure2);

        Vector structure3 = new Vector();
        structure3.add(contextString);
        structure3.add(this);
        structure3.add(servletMap);
        ((Support)portletApplication).preBuild(structure3);
    }

    public void preStore(Object parameter) throws Exception
    {
        Vector structure = (Vector)parameter;
        PortletApplicationDefinition portletApplication = (PortletApplicationDefinition)structure.get(0);

        ((Support)portletApplication).preStore(null);

        ((Support)servlets).preStore(this);
    }
    
    // additional methods.
    
    public String getCastorId() {                
        if (id.length() > 0) {
            return getId().toString();
        } else {
            return null;
        }
    }

    public Collection getCastorInitParams()
    {
        return(org.apache.pluto.portalImpl.om.common.impl.ParameterSetImpl)initParams;
    }

    public Collection getCastorServlets()
    {
        return(ServletDefinitionListImpl)servlets;
    }

    public Collection getCastorDisplayNames()
    {
        return(DisplayNameSetImpl)displayNames;
    }

    public Collection getCastorDescriptions()
    {
        return(DescriptionSetImpl)descriptions;
    }

    public SecurityRoleSet getSecurityRoles()
    {
        return securityRoles;
    }

    public Collection getServletMappings()
    {
        return servletMappings;
    }
    public void setCastorId(String id) {        
        setId(id);
    }
    
    protected void setContextRoot(String contextPath)
    {
        // Test for IBM WebSphere 
        if (contextPath != null && contextPath.endsWith(".war"))
        {
            contextPath = contextPath.substring(0, contextPath.length()-4);
        }
        this.contextPath = contextPath;
    }    

    public void setDescriptions(DescriptionSet descriptions)
    {
        this.descriptions = descriptions;
    }

    public void setDisplayNames(DisplayNameSet displayNames)
    {
        this.displayNames = displayNames;
    }

    public void setCastorDescriptions(DescriptionSet castorDescriptions)
    {
        this.descriptions = castorDescriptions;
    }

    public void setCastorDisplayNames(DisplayNameSet castorDisplayNames)
    {
        this.displayNames = castorDisplayNames;
    }

    public void setId(String id)
    {
        this.id = id;
        objectId = null;
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
        buffer.append("id='"); buffer.append(id); buffer.append("'");

        StringUtils.newLine(buffer,indent);
        buffer.append(((DisplayNameSetImpl)displayNames).toString(indent));

        StringUtils.newLine(buffer,indent);
        buffer.append(((DescriptionSetImpl)descriptions).toString(indent));

        StringUtils.newLine(buffer,indent);
        buffer.append(((org.apache.pluto.portalImpl.om.common.impl.ParameterSetImpl)initParams).toString(indent));

        StringUtils.newLine(buffer,indent);
        buffer.append(((ServletDefinitionListImpl)servlets).toString(indent));

        Iterator iterator = servletMappings.iterator();
        if (iterator.hasNext()) {
            StringUtils.newLine(buffer,indent);
            buffer.append("ServletMappings:");
        }
        while (iterator.hasNext()) {
            buffer.append(((ServletMappingImpl)iterator.next()).toString(indent+2));
        }

        StringUtils.newLine(buffer,indent);
        buffer.append("contextPath='"); buffer.append(contextPath); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

    // modified by YCLI: START :: handling multiple taglib tags and resource-ref tag

    /**
     * @return Custom tag definitions configured in the webapp.
     */
    public TagDefinitionSet getTagDefinitionSet()
    {
        return taglibs;
    }

    public Collection getCastorTagDefinitions() {
        return taglibs;
    }

    public void setCastorTagDefinitions(TagDefinitionSet taglibs)
    {
        this.taglibs = taglibs;
    }

    public ResourceRefSet getCastorResourceRefSet() {
        return castorResourceRef;
    }

    public void setCastorResourceRefSet(ResourceRefSet resourceRefs) {
        castorResourceRef = resourceRefs;
    }
    // modified by YCLI: END

    /**
     * @return Returns the castorMimeMappings.
     */
    public Collection getCastorMimeMappings() 
    {
        return castorMimeMappings;
    }

    public Collection getSecurityConstraints() {
        return securityConstraints;
    }

    /**
     * @param castorMimeMappings The castorMimeMappings to set.
     */
    public void setCastorMimeMappings(Collection castorMimeMappings) 
    {
        this.castorMimeMappings = castorMimeMappings;
    }

    public void setSecurityConstraints(Collection securityConstraints) {
        this.securityConstraints = securityConstraints;
    }
}
