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

package org.apache.pluto.portalImpl.services.pageregistry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.portalImpl.aggregation.Fragment;
import org.apache.pluto.portalImpl.aggregation.RootFragment;
import org.apache.pluto.portalImpl.om.page.impl.PortalImpl;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.portalImpl.util.Properties;
import org.apache.pluto.services.log.Logger;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * A simple XML Castor file based implementation of the <code>PageRegistryService</config>
 * <p>This store persit the PageRegistry informations</p>
 *
 */

public class PageRegistryServiceFileImpl extends PageRegistryService
{


    // default configuration values
    public final static String CONFIG_FILE              = "WEB-INF/data/pageregistry.xml";
    public final static String DEFAULT_MAPPING          = "WEB-INF/data/xml/pageregistrymapping.xml";
    // configuration keys
    private final static String CONFIG_MAPPING          = "mapping.configfile";

    // Castor mapping file
    private Mapping mapping = null;
    // Servlet Context
    private ServletContext servletContext = null;
    // Root element
    private PortalImpl registry = null;
    private RootFragment root = null;
    private Logger log = null;

    private HashMap fragments = new HashMap();

    public void init (ServletConfig config, Properties properties) throws Exception
    {        
        servletContext = config.getServletContext();
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

        if (log.isDebugEnabled())
        {
            log.debug("Dumping complete object model description as it is read from the xml file...");
            log.debug(registry.toString());
        }        
    }

    public void postInit(ServletConfig config) throws Exception {
        
        root = registry.build(config);
             
        if (log.isDebugEnabled())
        {
            log.debug("Dumping complete navigation tree created of the object model...");
            log.debug(root.getNavigation().toString());
        }
    }

    public RootFragment getRootFragment()
    {
        return root;
    }

    public Fragment getFragment(String id) {
        return (Fragment)fragments.get(id);
    }

    public void addFragment(Fragment fragment) throws Exception {
        String id = fragment.getId();
        if(! fragments.containsKey(id)) {
            
            fragments.put(id, fragment);

        } else {

            String msg = "Fragment with this name "+id+" already exists in the pageregistry.xml.";
            log.error(msg);
            throw new Exception(msg);
        }

    }

    private void store() throws Exception
    {
        String filename = CONFIG_FILE;
        
        File f = new File(filename);
        if (!f.isAbsolute())
           filename = servletContext.getRealPath(filename);
        
        FileWriter writer = new FileWriter(filename);
        
        Marshaller marshaller = new Marshaller(writer);
        
        marshaller.setMapping(this.mapping);
        
        marshaller.marshal(registry);
    }

    private void load() throws Exception
    {
        String filename = CONFIG_FILE;
        
        File f = new File(filename);
        if (!f.isAbsolute())
           filename = servletContext.getRealPath(filename);

        Unmarshaller unmarshaller = new Unmarshaller(this.mapping);

        registry = (PortalImpl)unmarshaller.unmarshal(new FileReader(filename));
    }

}
