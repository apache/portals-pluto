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
    public String icon = null;
    public String distributable = null;
    public String sessionConfig = null;
    public String mimeMapping = null;
    public String welcomeFileList = null;
    public String errorPage = null;
    public String taglib = null;
    public String resourceRef = null;
    public String securityConstraint = null;
    public String loginConfig = null;
    public String securityRole = null;
    public String envEntry = null;
    public String ejbRef = null;
    // </not used variables - only for castor>


    private String contextPath = null;        
    private DescriptionSet descriptions = new org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl();
    private DisplayNameSet displayNames =  new org.apache.pluto.portalImpl.om.common.impl.DisplayNameSetImpl();
    private String id = "";
    private ParameterSet initParams = new org.apache.pluto.portalImpl.om.common.impl.ParameterSetImpl();
    private ObjectID objectId = null;
    private Collection servletMappings = new ArrayList();
    private ServletDefinitionList servlets = new ServletDefinitionListImpl();
    private SecurityRoleSet securityRoles = new org.apache.pluto.portalImpl.om.common.impl.SecurityRoleSetImpl();
    private TagDefinition castorTagDefinition = new TagDefinition();

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
        if (Log.isDebugEnabled("org.apache.pluto.portalImpl")) {
            Log.debug("org.apache.pluto.portalImpl",
                      "Looking up ServletContext for path "+contextPath);
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
        String contextString = (String)structure.get(1);

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
        String contextString = (String)structure.get(1);

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

    /**
     * @return
     */
    public TagDefinition getCastorTagDefinition() {
        return castorTagDefinition;
    }

    /**
     * @param definition
     */
    public void setCastorTagDefinition(TagDefinition definition) {
        castorTagDefinition = definition;
    }
}
