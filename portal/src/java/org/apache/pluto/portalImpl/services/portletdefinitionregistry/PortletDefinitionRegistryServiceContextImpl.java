/**
 *
 * Copyright 2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.pluto.portalImpl.services.portletdefinitionregistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.UnavailableException;

import org.apache.pluto.om.common.ObjectID;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinitionList;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.portalImpl.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.portalImpl.om.portlet.impl.PortletApplicationDefinitionListImpl;
import org.apache.pluto.portalImpl.om.servlet.impl.WebApplicationDefinitionImpl;
import org.apache.pluto.portalImpl.util.Properties;
import org.apache.pluto.portalImpl.xml.Constants;
import org.apache.pluto.portalImpl.xml.XmlParser.EntityResolver;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

/**
 * A version of the registry service that obtains data from a ServletContext
 * rather than trying to scan for portlet applications.
 *
 * @version $Rev$ $Date$
 */
public class PortletDefinitionRegistryServiceContextImpl extends PortletDefinitionRegistryService {
    public static final String DEFAULT_CONTEXTS = "/WEB-INF/data/portletcontexts.txt";

    public final static String DEFAULT_MAPPING_PORTLETXML = "/WEB-INF/data/xml/portletdefinitionmapping.xml";
    public final static String DEFAULT_MAPPING_WEBXML = "/WEB-INF/data/xml/servletdefinitionmapping.xml";

    private static final String CONFIG_MAPPING_PORTLETXML = "mapping.portletxml.configfile";
    private static final String CONFIG_MAPPING_WEBXML = "mapping.webxml.configfile";

    private Mapping webXmlMapping;
    private Mapping portletXmlMapping;

    private PortletApplicationDefinitionListImpl registry;
    private Map definitions;

    public PortletApplicationDefinitionList getPortletApplicationDefinitionList() {
        return registry;
    }

    public PortletDefinition getPortletDefinition(ObjectID id) {
        return (PortletDefinition) definitions.get(id);
    }

    protected void init(ServletConfig config, Properties props) throws Exception {
        ServletContext context = config.getServletContext();
        portletXmlMapping = loadMapping(context, props.getString(CONFIG_MAPPING_PORTLETXML, DEFAULT_MAPPING_PORTLETXML));
        webXmlMapping = loadMapping(context, props.getString(CONFIG_MAPPING_WEBXML, DEFAULT_MAPPING_WEBXML));

        List contexts = loadDefinitionList(context, DEFAULT_CONTEXTS);
        registry = new PortletApplicationDefinitionListImpl();
        for (Iterator i = contexts.iterator(); i.hasNext();) {
            String contextRoot = (String) i.next();
            PortletApplicationDefinition portletApp = loadApplicationDefinition(context, contextRoot);
            registry.add(portletApp);
        }

        definitions = new HashMap();
        for (Iterator i = registry.iterator(); i.hasNext();) {
            PortletApplicationDefinition application = (PortletApplicationDefinition) i.next();

            for (Iterator j = application.getPortletDefinitionList().iterator(); j.hasNext();) {
                PortletDefinition portlet = (PortletDefinition) j.next();
                definitions.put(portlet.getId(), portlet);
            }
        }
    }

    private Mapping loadMapping(ServletContext context, String path) throws UnavailableException {
        InputSource source = new InputSource(context.getResourceAsStream(path));
        Mapping mapping = new Mapping();
        try {
            mapping.loadMapping(source);
        } catch (IOException e) {
            throw (UnavailableException) new UnavailableException("Error reading mapping " + path).initCause(e);
        } catch (MappingException e) {
            throw (UnavailableException) new UnavailableException("Invalid mapping " + path).initCause(e);
        }
        return mapping;
    }

    private List loadDefinitionList(ServletContext context, String path) throws UnavailableException {
        InputStream stream = context.getResourceAsStream(path);
        if (stream == null) {
            throw new UnavailableException("Unable to load registry " + path);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            try {
                String line;
                List contexts = new ArrayList();
                while ((line = reader.readLine()) != null) {
                    contexts.add(line.trim());
                }
                return contexts;
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw (UnavailableException) new UnavailableException("Error reading registry from " + path).initCause(e);
        }
    }

    private PortletApplicationDefinition loadApplicationDefinition(ServletContext context, String path) throws UnavailableException {
        // locate the portlet application's context
        ServletContext appContext = context.getContext(path);
        if (appContext == null) {
            throw new UnavailableException("Unable to access context for " + path);
        }

        // load its portlet.xml
        InputStream stream = appContext.getResourceAsStream("/WEB-INF/portlet.xml");
        if (stream == null) {
            throw new UnavailableException("No portlet.xml found in context " + appContext.getServletContextName());
        }
        InputSource source = new InputSource(stream);
        Unmarshaller unmarshaller;
        try {
            unmarshaller = new Unmarshaller(portletXmlMapping);
            unmarshaller.setEntityResolver(new EntityResolver(Constants.RES_PORTLET_DTDS, Constants.RES_PORTLET_DTD_NAMES));
        } catch (MappingException e) {
            throw (UnavailableException) new UnavailableException("Unable to construct unmarshaller for portlet.xml").initCause(e);
        }
        unmarshaller.setIgnoreExtraElements(true);
        PortletApplicationDefinitionImpl portletApp;
        try {
            portletApp = (PortletApplicationDefinitionImpl) unmarshaller.unmarshal(source);
        } catch (MarshalException e) {
            throw (UnavailableException) new UnavailableException("Unable to unmarshal portlet.xml from context " + appContext.getServletContextName()).initCause(e);
        } catch (ValidationException e) {
            throw (UnavailableException) new UnavailableException("Unable to validate portlet.xml from context " + appContext.getServletContextName()).initCause(e);
        }

        // load its web.xml
        stream = appContext.getResourceAsStream("/WEB-INF/web.xml");
        if (stream == null) {
            throw new UnavailableException("No web.xml found in context " + appContext.getServletContextName());
        }
        source = new InputSource(stream);
        try {
            unmarshaller = new Unmarshaller(webXmlMapping);
            unmarshaller.setEntityResolver(new EntityResolver(Constants.RES_WEB_PUBLIC_ID,
                                                       Constants.RES_WEB_DTD,
                                                       Constants.RES_WEB_DTD_NAME));
        } catch (MappingException e) {
            throw (UnavailableException) new UnavailableException("Unable to construct unmarshaller for web.xml").initCause(e);
        }
        unmarshaller.setIgnoreExtraElements(true);

        WebApplicationDefinitionImpl webApp;
        try {
            webApp = (WebApplicationDefinitionImpl) unmarshaller.unmarshal(source);
        } catch (MarshalException e) {
            throw (UnavailableException) new UnavailableException("Unable to unmarshal web.xml from context " + appContext.getServletContextName()).initCause(e);
        } catch (ValidationException e) {
            throw (UnavailableException) new UnavailableException("Unable to validate web.xml from context " + appContext.getServletContextName()).initCause(e);
        }

        Vector structure = new Vector();
        structure.add(portletApp);
        structure.add(path);

        try {
            webApp.postLoad(structure);
            webApp.preBuild(structure);
            webApp.postBuild(structure);
        } catch (Exception e) {
            throw (UnavailableException) new UnavailableException(e.getMessage()).initCause(e);
        }
        return portletApp;
    }
}

