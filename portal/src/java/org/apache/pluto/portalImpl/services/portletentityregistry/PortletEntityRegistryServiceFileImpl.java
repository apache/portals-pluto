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
 * A simple XML Castor file based implementation of the <code>PortletEntityRegistryService</config>
 * <p>This store persit the PortletEntityRegistry informations</p>
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
