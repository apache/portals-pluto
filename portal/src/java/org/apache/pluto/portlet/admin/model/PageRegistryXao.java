/*
 * Copyright 2003,2004,2005 The Apache Software Foundation.
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
package org.apache.pluto.portlet.admin.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Iterator;

import org.apache.pluto.portalImpl.om.page.impl.FragmentImpl;
import org.apache.pluto.portalImpl.om.page.impl.PortalImpl;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

import org.apache.pluto.portlet.admin.BaseAdminObject;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.util.PlutoAdminContext;

/**
 *
 * This class is used to access and store data in the pageregistry.xml file.
 * It uses Castor and is loosely based on the
 * org.apache.services.pageregistry.PageRegistryServiceFileImpl
 * class in Pluto's 'portal' module.
 *
 * @author Craig Doremus
 */
public class PageRegistryXao extends BaseAdminObject {


    // default configuration values
    public final static String CONFIG_FILE              = "WEB-INF/data/pageregistry.xml";
    public final static String DEFAULT_MAPPING          = "WEB-INF/data/xml/pageregistrymapping.xml";
    private final static String CLASS_NAME = "PageRegistryXao";
    // Castor mapping file
    private Mapping mapping = null;

	/**
	 *
	 */
	public PageRegistryXao() throws Exception {
		super(CLASS_NAME);
		init();
	}
    public void init () throws Exception
    {
    	 final String METHOD_NAME = "init()";

        String _mapping = PlutoAdminContext.getInstance().getPlutoHome() + "/" + DEFAULT_MAPPING;

        this.mapping = new Mapping();
        try
        {
            this.mapping.loadMapping(_mapping);
        }
        catch (Exception e)
        {
            logError(METHOD_NAME, "Failed to load mapping file "+_mapping,e);
            throw e;
        }

    }


    public void save(PortalImpl page) throws Exception {
    	final String METHOD_NAME = "save(PortalImpl)";
      String filename = PlutoAdminContext.getInstance().getPlutoHome() + "/" + CONFIG_FILE;
    	logDebug(METHOD_NAME, "Registry file to save: " + filename);

        FileWriter writer = new FileWriter(filename);

        Marshaller marshaller = new Marshaller(writer);

        marshaller.setMapping(this.mapping);

        marshaller.marshal(page);
    }

    public PortalImpl load() throws Exception
    {
    	final String METHOD_NAME = "load()";

        String filename = PlutoAdminContext.getInstance().getPlutoHome() + "/" + CONFIG_FILE;
      	logDebug(METHOD_NAME, "File to load: " + filename);

        Unmarshaller unmarshaller = new Unmarshaller(this.mapping);
        unmarshaller.setMapping(this.mapping);

        PortalImpl pages = (PortalImpl)unmarshaller.unmarshal(new FileReader(filename));
        return pages;
    }

    public boolean pageExists(String page) {
    	final String METHOD_NAME = "pageExists(page)";
    	boolean exists = false;
    	Collection frags = null;
  		try {
      	PortalImpl portal = load();
      	frags = portal.getFragments();
			} catch (Exception e) {
	  		logError(METHOD_NAME, e);
				throw new PlutoAdminException(e);
			}
			Iterator iter = frags.iterator();
    	while (iter.hasNext()) {
    		FragmentImpl frag = (FragmentImpl) iter.next();
    		String type = null;
    		String name = null;
    		if (frag != null) {
				type = frag.getType();
				name = frag.getName();
			}
    		if(type != null && type.equalsIgnoreCase("page") && name != null && name.equalsIgnoreCase(page)) {
    			exists = true;
    			break;
    		}
    	}
    	return exists;
    }
}
