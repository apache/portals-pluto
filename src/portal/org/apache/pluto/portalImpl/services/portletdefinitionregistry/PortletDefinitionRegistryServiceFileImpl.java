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

package org.apache.pluto.portalImpl.services.portletdefinitionregistry;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinitionList;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.portalImpl.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.portalImpl.om.portlet.impl.PortletApplicationDefinitionListImpl;
import org.apache.pluto.portalImpl.om.servlet.impl.WebApplicationDefinitionImpl;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.portalImpl.util.Properties;
import org.apache.pluto.portalImpl.xml.XmlParser;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Unmarshaller;

/**
 * A simple XML Castor file based implementation of the <code>PortletRegistryService</config>
 * <p>This store persit the PortletRegistry informations</p>
 *
 */

public class PortletDefinitionRegistryServiceFileImpl extends PortletDefinitionRegistryService
{

    private static String fileSeparator = System.getProperty("file.separator");

    // default configuration values
    public final static String DEFAULT_MAPPING_PORTLETXML = "WEB-INF/data/xml/portletdefinitionmapping.xml";
    public final static String DEFAULT_MAPPING_WEBXML     = "WEB-INF/data/xml/servletdefinitionmapping.xml";
    // configuration keys
    private final static String CONFIG_MAPPING_PORTLETXML = "mapping.portletxml.configfile";
    private final static String CONFIG_MAPPING_WEBXML     = "mapping.webxml.configfile";

    // Castor mapping file
    private Mapping mappingPortletXml = null;
    private Mapping mappingWebXml = null;
    // Servlet Context
    private ServletContext servletContext = null;
    // Base Dir where all web modules are located
    private String baseWMDir = null;

    // Helper lists and hashtables to access the data as fast as possible
    // List containing all portlet applications available in the system
    protected PortletApplicationDefinitionListImpl registry = 
        new PortletApplicationDefinitionListImpl();
    protected Map portletsKeyObjectId = new HashMap();

    public void init (ServletConfig config, Properties properties) throws Exception
    {
        servletContext = config.getServletContext();

        if (properties.getBoolean("non-servlet")==Boolean.TRUE)
        {
            String root = config.getServletContext().getRealPath("/"); //root
            baseWMDir = root + fileSeparator + 
		"WEB-INF" + fileSeparator + 
		"portletapps" + fileSeparator; //org.apache.pluto.portalImpl.services.deploy.DeployServiceFileImpl.DEFAULT_PROTECTED;
            Log.debug("org.apache.pluto.portalImpl.services.Portletregistry", "baseWMDir = " + baseWMDir + " fileSeparator = " + fileSeparator);
        }
        else
        {
            baseWMDir = servletContext.getRealPath("");
            baseWMDir = baseWMDir.substring(0,
                                            baseWMDir.lastIndexOf(fileSeparator))+fileSeparator;
        }

        // get portlet xml mapping file
        String _mapping = properties.getString(CONFIG_MAPPING_PORTLETXML, DEFAULT_MAPPING_PORTLETXML);
        File f = new File(_mapping);
        if (!f.isAbsolute()) _mapping = servletContext.getRealPath(_mapping);
        this.mappingPortletXml = new Mapping();
        try
        {
            this.mappingPortletXml.loadMapping(_mapping);
        }
        catch (Exception e)
        {
            Log.error("org.apache.pluto.portalImpl.services", 
                      "Failed to load mapping file "+_mapping,e);
            throw e;
        }
        // get web xml mapping file
        _mapping = properties.getString(CONFIG_MAPPING_WEBXML, DEFAULT_MAPPING_WEBXML);
        f = new File(_mapping);
        if (!f.isAbsolute()) _mapping = servletContext.getRealPath(_mapping);
        this.mappingWebXml = new Mapping();
        try
        {
            this.mappingWebXml.loadMapping(_mapping);
        }
        catch (Exception e)
        {
            Log.error("org.apache.pluto.portalImpl.services", 
                      "Failed to load mapping file "+_mapping,e);
            throw e;
        }

        load();

        fill();
    }

    public PortletApplicationDefinitionList getPortletApplicationDefinitionList()
    {
        return registry;
    }

    public PortletDefinition getPortletDefinition(ObjectID id)
    {
        return (PortletDefinition)portletsKeyObjectId.get(id);
    }

    private void load() throws Exception
    {
        File f = new File(baseWMDir);
        String[] entries = f.list();
        for (int i=0; i<entries.length; i++)
        {
            File entry = new File(baseWMDir+entries[i]);
            if (entry.isDirectory())
            {
                load(baseWMDir, entries[i]);
            }
        }
    }

    private void load(String baseDir, String webModule) throws Exception
    {
        String directory = baseDir+webModule+fileSeparator+"WEB-INF"+fileSeparator;

        File portletXml = new File(directory+"portlet.xml");
        File webXml = new File(directory+"web.xml");

        // check for the porlet.xml. If there is no portlet.xml this is not a
        // portlet application web module
        if (portletXml.exists()) // && (webXml.exists()))
        {
            if (Log.isDebugEnabled("org.apache.pluto.portalImpl.services"))
            {
                Log.debug("org.apache.pluto.portalImpl.services", 
                          "Loading the following Portlet Applications XML files..."+portletXml+", "+webXml);
            }

            org.w3c.dom.Document portletDocument = 
            XmlParser.parsePortletXml(new FileInputStream(portletXml));

            Unmarshaller unmarshaller = new Unmarshaller(this.mappingPortletXml);
			unmarshaller.setIgnoreExtraElements(true);
            PortletApplicationDefinitionImpl portletApp = 
                (PortletApplicationDefinitionImpl)unmarshaller.unmarshal( portletDocument );

            WebApplicationDefinitionImpl webApp = null;

            if (webXml.exists())
            {
                org.w3c.dom.Document webDocument = 
                XmlParser.parseWebXml(new FileInputStream(webXml));

                unmarshaller = new Unmarshaller(this.mappingWebXml);
				unmarshaller.setIgnoreExtraElements(true);
                webApp = 
                    (WebApplicationDefinitionImpl)unmarshaller.unmarshal(webDocument);

                Vector structure = new Vector();
                structure.add(portletApp);
                structure.add("/"+webModule);

                webApp.postLoad(structure);

                // refill structure with necessary information
                webApp.preBuild(structure);

                webApp.postBuild(structure);

                if (Log.isDebugEnabled("org.apache.pluto.portalImpl.services"))
                {
                    Log.debug("org.apache.pluto.portalImpl.services", webApp.toString());
                }
            }
            else
            {
                if (Log.isDebugEnabled("org.apache.pluto.portalImpl.services"))
                {
                    Log.debug("org.apache.pluto.portalImpl.services", "no web.xml...");
                }
                Vector structure = new Vector();
                structure.add("/" + webModule);
                structure.add(null);
                structure.add(null);

                portletApp.postLoad(structure);
                
                portletApp.preBuild(structure);
                
                portletApp.postBuild(structure);
            }

            registry.add( portletApp );

            if (Log.isDebugEnabled("org.apache.pluto.portalImpl.services"))
            {
                if (webApp!=null)
                {
                    Log.debug("org.apache.pluto.portalImpl.services", 
                              "Dumping content of web.xml...");
                    Log.debug("org.apache.pluto.portalImpl.services", 
                              webApp.toString());
                }
                Log.debug("org.apache.pluto.portalImpl.services", 
                          "Dumping content of portlet.xml...");
                Log.debug("org.apache.pluto.portalImpl.services", 
                          portletApp.toString());
            }
        }

    }

    private void fill()
    {

        Iterator iterator = registry.iterator();
        while (iterator.hasNext())
        {
            PortletApplicationDefinition papp = (PortletApplicationDefinition)iterator.next();

            // fill portletsKeyObjectId
            Iterator portlets = papp.getPortletDefinitionList().iterator();
            while (portlets.hasNext())
            {
                PortletDefinition portlet = (PortletDefinition)portlets.next();

                portletsKeyObjectId.put(portlet.getId(), portlet);

            }

        }

    }

}
