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
