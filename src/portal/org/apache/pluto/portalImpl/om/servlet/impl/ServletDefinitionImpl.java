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

import java.util.Collection;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.DisplayNameSet;
import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.common.ParameterSet;
import org.apache.pluto.om.common.SecurityRoleRefSet;
import org.apache.pluto.om.servlet.ServletDefinition;
import org.apache.pluto.om.servlet.ServletDefinitionCtrl;
import org.apache.pluto.om.servlet.WebApplicationDefinition;
import org.apache.pluto.portalImpl.om.common.Support;
import org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl;
import org.apache.pluto.portalImpl.om.common.impl.DisplayNameSetImpl;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.util.StringUtils;

public class ServletDefinitionImpl
implements ServletDefinition, ServletDefinitionCtrl, java.io.Serializable, Support {

    private DescriptionSet descriptions = new org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl();
    private DisplayNameSet displayNames = new org.apache.pluto.portalImpl.om.common.impl.DisplayNameSetImpl();

    // not used variables - only for castor
    public String icon = null;
    private String id = "";
    private ParameterSet initParams = new org.apache.pluto.portalImpl.om.common.impl.ParameterSetImpl();
    private SecurityRoleRefSet initSecurityRoleRefs = new org.apache.pluto.portalImpl.om.common.impl.SecurityRoleRefSetImpl();
    public String jspFile = null;
    public String loadOnStartup = null;
    private ObjectID objectId = null;
    public String securityRoleRef = null;
    private String servletClass = null;
    private ServletMappingImpl servletMapping = null;
    private String servletName = null;
    private long available = 0;

    private WebApplicationDefinition webApplication = null;

    // ServletDefinition implementation.

    public ObjectID getId()
    {
        if (objectId==null) {
            objectId = org.apache.pluto.portalImpl.util.ObjectID.createFromString(id);
        }
        return objectId;
    }

    public String getServletName()
    {
        return servletName;
    }

    public DisplayName getDisplayName(Locale locale)
    {
        return displayNames.get(locale);
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.om.servlet.ServletDefinition#getDescription(Locale)
     */
    public Description getDescription(Locale locale) {
        return descriptions.get(locale);
    }

    public String getServletClass()
    {
        return servletClass;
    }

    public ParameterSet getInitParameterSet()
    {
        return initParams;
    }

    public WebApplicationDefinition getWebApplicationDefinition()
    {
        return webApplication;
    }

    public RequestDispatcher getRequestDispatcher(ServletContext servletContext)
    {
        ServletContext newContext = webApplication.getServletContext(servletContext);
        if (newContext==null) {
            Log.error("org.apache.pluto.portalImpl",
                      "ServletContext '"+((WebApplicationDefinitionImpl)webApplication).getContextRoot()+"' not found!");
            return null;
        }
        if (Log.isDebugEnabled("org.apache.pluto.portalImpl")) {
            Log.debug("org.apache.pluto.portalImpl",
                      "Looking up RequestDispatcher for servlet mapping "+servletMapping.getUrlPattern());
        }
        return newContext.getRequestDispatcher(servletMapping.getUrlPattern());
    }

    public long getAvailable() {
        return available;
    }

    public boolean isUnavailable() {
        if (available == 0) {
            return false;
        } else if (available <= System.currentTimeMillis()) {
            available = 0;
            return false;
        } else {
            return true;
        }
    }

    // Support implementation.

    public void postBuild(Object parameter) throws Exception
    {
        setServletMapping((ServletMappingImpl)parameter);
    }


    public void postLoad(Object parameter) throws Exception
    {
        ((Support)descriptions).postLoad(parameter);
        ((Support)displayNames).postLoad(parameter);
    }
    public void postStore(Object parameter) throws Exception
    {
    }
    public void preBuild(Object parameter) throws Exception
    {
        setWebApplicationDefinition((WebApplicationDefinition)parameter);
    }
    public void preStore(Object parameter) throws Exception
    {
    }

    // additional methods.
    
    public String getCastorId() {                
        if (id.length() > 0)
            return getId().toString();
        else
            return null;
    }

    public Collection getCastorInitParams()
    {
        return(org.apache.pluto.portalImpl.om.common.impl.ParameterSetImpl)initParams;
    }

    public SecurityRoleRefSet getCastorInitSecurityRoleRefs()
    {
        return initSecurityRoleRefs;
    }

    public Collection getCastorDisplayNames()
    {
        return(DisplayNameSetImpl)displayNames;
    }

    public Collection getCastorDescriptions()
    {
        return(DescriptionSetImpl)descriptions;
    }

    public Collection getDescriptions()
    {
        return(DescriptionSetImpl)descriptions;
    }



    public SecurityRoleRefSet getInitSecurityRoleRefSet()
    {
        return initSecurityRoleRefs;
    }



    public String getJspFile()
    {
        return jspFile;
    }


    public void setCastorId(String id) {        
        setId(id);
    }

    public void setCastorInitSecurityRoleRefs(SecurityRoleRefSet castorInitSecurityRoleRefs)
    {
        this.initSecurityRoleRefs = castorInitSecurityRoleRefs;
    }

    public void setCastorDisplayNames(DisplayNameSet castorDisplayNames)
    {
        this.displayNames = castorDisplayNames;
    }

    public void setCastorDescriptions(DescriptionSet castorDescriptions)
    {
        this.descriptions = castorDescriptions;
    }

    public void setDisplayNames(DisplayNameSet displayNames)
    {
        this.displayNames = displayNames;
    }

    public void setDescriptions(DescriptionSet descriptions) {
        this.descriptions = descriptions;
    }

    public void setId(String id)
    {
        this.id = id;
        objectId = null;
    }

    public void setServletClass(String servletClass)
    {
        this.servletClass = servletClass;
    }

    public void setAvailable(long available) {
        if (available > System.currentTimeMillis()) {
            this.available = available;
        } else {
            this.available = 0;
        }
    }

    public void setJspFile(String jspFile)
    {
        this.jspFile = jspFile;
    }

    protected void setServletMapping(ServletMappingImpl servletMapping)
    {
        this.servletMapping = servletMapping;
    }

    public void setServletName(String servletName)
    {
        this.servletName = servletName;
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
        buffer.append("id='"); buffer.append(id); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append("servletName='"); buffer.append(servletName); buffer.append("'");
        StringUtils.newLine(buffer,indent);
        buffer.append(((DescriptionSetImpl)descriptions).toString(indent));

        StringUtils.newLine(buffer,indent);
        buffer.append(((DisplayNameSetImpl)displayNames).toString(indent));

        if (servletClass!=null) {
            buffer.append("servletClass='"); buffer.append(servletClass); buffer.append("'");
        } else if (jspFile!=null) {
            buffer.append("jspFile='"); buffer.append(jspFile); buffer.append("'");
        }
        StringUtils.newLine(buffer,indent);
        buffer.append(((org.apache.pluto.portalImpl.om.common.impl.ParameterSetImpl)initParams).toString(indent));

        StringUtils.newLine(buffer,indent);
        buffer.append(((org.apache.pluto.portalImpl.om.common.impl.SecurityRoleRefSetImpl)initSecurityRoleRefs).toString(indent));

        if (servletMapping!=null) {
            StringUtils.newLine(buffer,indent);
            buffer.append("Linked ServletMapping:");
            buffer.append(((ServletMappingImpl)servletMapping).toString(indent+2));
        }
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

}
