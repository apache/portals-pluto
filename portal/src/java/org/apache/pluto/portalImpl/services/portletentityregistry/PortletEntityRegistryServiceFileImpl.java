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

package org.apache.pluto.portalImpl.services.portletentityregistry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.entity.PortletApplicationEntity;
import org.apache.pluto.om.entity.PortletApplicationEntityList;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityListImpl;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.portalImpl.util.Properties;
import org.apache.pluto.services.log.Logger;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * A simple XML Castor file based implementation of the
 * <code>PortletEntityRegistryService</config>.
 *
 * <p>This store persit the PortletEntityRegistry informations.</p>
 *
 */

public class PortletEntityRegistryServiceFileImpl extends PortletEntityRegistryService
{


    // default configuration values
    public final static String CONFIG_FILE              = "WEB-INF/data/portletentityregistry.xml";
    public final static String DEFAULT_MAPPING          = "WEB-INF/data/xml/portletentitymapping.xml";
    // configuration keys
    protected final static String CONFIG_MAPPING          = "mapping.configfile";

    // Castor mapping file
    protected Mapping mapping = null;
    // Servlet Context
    protected ServletContext servletContext = null;
    private Logger log = null;
    // Registry
    protected PortletApplicationEntityListImpl registry = null;
    
    // Helper lists and hashtables to access the data as fast as possible
    protected Map portletEntitiesKeyObjectID = new HashMap();

    public void init (ServletConfig servletConfig, Properties properties) throws Exception
    {
        servletContext = servletConfig.getServletContext();
        log = Log.getService().getLogger(getClass());

        String _mapping = properties.getString(CONFIG_MAPPING, DEFAULT_MAPPING);
        File f = new File(_mapping);
        if (!f.isAbsolute())
            _mapping = servletContext.getRealPath(_mapping);

        this.mapping = new Mapping();
        try
        {
            this.mapping.loadMapping(_mapping);
        }
        catch (Exception e)
        {
            log.error("Failed to load mapping file "+_mapping,e);
            throw e;
        }
    
        load();
    }

    public PortletApplicationEntityList getPortletApplicationEntityList()
    {
        return registry;
    }

    public PortletEntity getPortletEntity(ObjectID id)
    {
        return (PortletEntity)portletEntitiesKeyObjectID.get(id.toString());
    }

    public void store() throws IOException
    {
        String filename = CONFIG_FILE;
        
        File f = new File(filename);
        if (!f.isAbsolute())
           filename = servletContext.getRealPath(filename);
        
        FileWriter writer = new FileWriter(filename);
        
        try {
            Marshaller marshaller = new Marshaller(writer);

            marshaller.setMapping(this.mapping);

            registry.preStore(null);

            marshaller.marshal(registry);

            registry.postStore(null);
        }
        catch (org.exolab.castor.mapping.MappingException e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }
        catch (org.exolab.castor.xml.ValidationException e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }
        catch (org.exolab.castor.xml.MarshalException e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }
    }

    public void load() throws IOException
    {
        _load();

        if (log.isDebugEnabled())
        {
            log.debug("Dumping complete object model description as it is read from the xml file...");
            log.debug(registry.toString());
        }

        fill();
    }

    public void refresh(PortletEntity portletEntity) {
        portletEntitiesKeyObjectID.put(portletEntity.getId().toString(), portletEntity);
    }

    private void _load() throws IOException
    {
        String filename = CONFIG_FILE;
        
        File f = new File(filename);
        if (!f.isAbsolute())
           filename = servletContext.getRealPath(filename);

        try {            

            Unmarshaller unmarshaller = new Unmarshaller(this.mapping);            

            registry = (PortletApplicationEntityListImpl)unmarshaller.unmarshal(new FileReader(filename));

            registry.postLoad(null);

            registry.preBuild(null);

            registry.postBuild(null);
        }
        catch (org.exolab.castor.mapping.MappingException e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }
        catch (org.exolab.castor.xml.ValidationException e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }
        catch (org.exolab.castor.xml.MarshalException e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new IOException(e.toString());
        }

    }

    private void fill()
    {
        Iterator iterator = registry.iterator();
        while (iterator.hasNext())
        {
            PortletApplicationEntity appInst = (PortletApplicationEntity)iterator.next();

            // fill portletEntitiesKeyObjectID
            Iterator portlets = appInst.getPortletEntityList().iterator();
            while (portlets.hasNext())
            {
                PortletEntity portletInst = (PortletEntity)portlets.next();                                
                portletEntitiesKeyObjectID.put(portletInst.getId().toString(), portletInst);

            }

        }

    }

    //additional methods

    public Map getPortletEntities()
    {
        return portletEntitiesKeyObjectID;
    }
}
