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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityImpl;
import org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityListImpl;
import org.apache.pluto.portalImpl.om.entity.impl.PortletEntityImpl;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.BaseAdminObject;
import org.apache.pluto.portlet.admin.util.PlutoAdminContext;
import org.apache.pluto.util.StringUtils;

/**
 * This class is used to access and store data in the portletentityregistry.xml file.
 * It uses Castor and is loosely based on the
 * org.apache.services.portletentityregistry.PortletEntityRegistryServiceFileImpl
 * class in Pluto's 'portal' module.
 *
 * @author Craig Doremus
 *
 */
public class PortletEntityRegistryXao extends BaseAdminObject {


    // default configuration values
    public final static String CONFIG_FILE              = "WEB-INF/data/portletentityregistry.xml";
    public final static String DEFAULT_MAPPING          = "WEB-INF/data/xml/portletentitymapping.xml";
    private final static String CLASS_NAME = "PortletEntityRegistryXao";
    //Application elements within the registry
    private Collection castorApplications = new ArrayList();

    // Castor mapping file
    private Mapping mapping = null;

	/**
	 *
	 */
	public PortletEntityRegistryXao() throws Exception {
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



    public void save(PortletApplicationEntityListImpl apps) throws Exception
    {
    	final String METHOD_NAME = "save(AdminPortalImpl)";
      String filename = PlutoAdminContext.getInstance().getPlutoHome() + "/" + CONFIG_FILE;
    	logDebug(METHOD_NAME, "Registry file to save: " + filename);

        FileWriter writer = new FileWriter(filename);

        Marshaller marshaller = new Marshaller(writer);

        marshaller.setMapping(this.mapping);

        marshaller.marshal(apps);
    }

    public PortletApplicationEntityListImpl load() throws Exception
    {
    	final String METHOD_NAME = "load()";

        String filename = PlutoAdminContext.getInstance().getPlutoHome() + "/" + CONFIG_FILE;
      	logDebug(METHOD_NAME, "Registry file to load: " + filename);

        Unmarshaller unmarshaller = new Unmarshaller(this.mapping);
        unmarshaller.setMapping(this.mapping);

        PortletApplicationEntityListImpl apps = (PortletApplicationEntityListImpl)unmarshaller.unmarshal(new FileReader(filename));
        castorApplications = apps.getCastorApplications();
        return apps;
    }

    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(1000);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString());
        buffer.append(":");
        StringUtils.newLine(buffer,indent);
        buffer.append("{");
        Iterator iterator = castorApplications.iterator();
        if (iterator.hasNext()) {
            StringUtils.newLine(buffer,indent);
            buffer.append("Portlet Application Entities");
            int count = castorApplications.size();
            buffer.append("(");
            buffer.append(count);
            buffer.append("):");
        }
        while (iterator.hasNext()) {
            buffer.append(((PortletApplicationEntityImpl)iterator.next()).toString(indent+2));
        }
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

    public Collection getApplications() throws Exception {
  		String METHOD_NAME = "getApplications()";
  		logMethodStart(METHOD_NAME);
  		Collection elist = null;
  		PortletApplicationEntityListImpl per = load();
  		logDebug(METHOD_NAME, "PER: " + per);
  		if (per != null) {
  			elist = per.getCastorApplications();
  		}
  		logMethodEnd(METHOD_NAME, elist);
  		return elist;
  	}

    public PortletApplicationEntityImpl getApplication(String castorId) throws Exception {
    	PortletApplicationEntityImpl app = null;
  		Collection apps = getApplications();
  		Iterator iter = apps.iterator();
  		while(iter.hasNext()) {
  			PortletApplicationEntityImpl currApp = (PortletApplicationEntityImpl)iter.next();
  			if (currApp.getCastorId().equalsIgnoreCase(castorId)) {
  				app = currApp;
  				break;
  			}
  		}
  		return app;
    }

    public Collection getPortletPreferences(String appId, String portletId) throws Exception {
    	Collection list = null;
    	PortletApplicationEntityImpl app = getApplication(appId);
    	Collection plets = app.getCastorPortlets();
    	Iterator iter = plets.iterator();
    	while(iter.hasNext()) {
    		PortletEntityImpl plet = (PortletEntityImpl)iter.next();
    		if (plet.getCastorId().equalsIgnoreCase(portletId)) {
    			list = plet.getCastorPreferences();
    			break;
    		}
    	}
    	return list;
    }

    public boolean applicationExists(String appContext) {
    	final String METHOD_NAME = "applicationExists(appContext)";
    	boolean exists = false;
    	Collection apps = null;
		try {
			apps = getApplications();
		} catch (Exception e) {
  		logError(METHOD_NAME, e);
			throw new PlutoAdminException(e);
		}
		Iterator iter = apps.iterator();
    	while (iter.hasNext()) {
    		PortletApplicationEntityImpl app = (PortletApplicationEntityImpl) iter.next();
    		if (app.getDefinitionId().equalsIgnoreCase(appContext)) {
    			exists = true;
    			break;
    		}
    	}
    	return exists;
    }
}
