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
import org.apache.pluto.services.log.Logger;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Unmarshaller;
import org.xml.sax.InputSource;

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
    private Logger log = null;

    // Helper lists and hashtables to access the data as fast as possible
    // List containing all portlet applications available in the system
    protected PortletApplicationDefinitionListImpl registry = 
        new PortletApplicationDefinitionListImpl();
    protected Map portletsKeyObjectId = new HashMap();

    public void init (ServletConfig config, Properties properties) throws Exception
    {
        log = Log.getService().getLogger(getClass());
        servletContext = config.getServletContext();

        if (properties.getBoolean("non-servlet")==Boolean.TRUE)
        {
            String root = config.getServletContext().getRealPath("/"); //root
            baseWMDir = root + fileSeparator + 
		"WEB-INF" + fileSeparator + 
		"portletapps" + fileSeparator; //org.apache.pluto.portalImpl.services.deploy.DeployServiceFileImpl.DEFAULT_PROTECTED;
            if(log.isDebugEnabled())
                log.debug("baseWMDir = " + baseWMDir + " fileSeparator = " + fileSeparator);
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
            log.error("Failed to load mapping file "+_mapping,e);
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
            log.error("Failed to load mapping file "+_mapping,e);
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
            if (log.isDebugEnabled())
            {
                log.debug("Loading the following Portlet Applications XML files..."+portletXml+", "+webXml);
            }

            InputSource source = new InputSource(new FileInputStream(portletXml));
            source.setSystemId(portletXml.toURL().toExternalForm());
            
            Unmarshaller unmarshaller = new Unmarshaller(this.mappingPortletXml);
			unmarshaller.setIgnoreExtraElements(true);
            PortletApplicationDefinitionImpl portletApp = 
                (PortletApplicationDefinitionImpl)unmarshaller.unmarshal( source );

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

                if (log.isDebugEnabled())
                {
                    log.debug(webApp.toString());
                }
            }
            else
            {
                if (log.isDebugEnabled())
                {
                    log.debug("no web.xml...");
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

            if (log.isDebugEnabled())
            {
                if (webApp!=null)
                {
                    log.debug("Dumping content of web.xml...");
                    log.debug(webApp.toString());
                }
                log.debug("Dumping content of portlet.xml...");
                log.debug(portletApp.toString());
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
