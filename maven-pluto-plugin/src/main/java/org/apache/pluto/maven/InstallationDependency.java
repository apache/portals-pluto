/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.maven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

//import sun.security.provider.SHA;

//import com.sun.corba.se.impl.protocol.SharedCDRClientRequestDispatcherImpl;

/**
 *
 */
class InstallationDependency {    
    
    private static final Properties VERSION_PROPERTIES = new Properties();
    private static final String PROPERTIES_FILE = "/versions.properties";
    static
    {
        try 
        {
            VERSION_PROPERTIES.load(InstallationDependency.class.getResourceAsStream(PROPERTIES_FILE));
        } 
        catch (IOException e) 
        {
            throw new RuntimeException("Cannot load " + PROPERTIES_FILE + " from the classpath!", e);
        }
    }

    public static final InstallationDependency PORTLET_API =
        new InstallationDependency("javax.portlet", "portlet-api", 
                VERSION_PROPERTIES.getProperty("portlet-api.version"));

    public static final InstallationDependency CONTAINER_API =
        new InstallationDependency("org.apache.pluto", "pluto-container-api", 
                VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency  DESCRIPTOR_API =
        new InstallationDependency("org.apache.pluto", "pluto-descriptor-api", 
                VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency  DESCRIPTOR_IMPL =
            new InstallationDependency("org.apache.pluto", "pluto-descriptor-impl", 
                    VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency  CONTAINER =
            new InstallationDependency("org.apache.pluto", "pluto-container", 
                    VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency  TAGLIB =
            new InstallationDependency("org.apache.pluto", "pluto-taglib", 
                    VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency  PORTAL =
            new InstallationDependency("org.apache.pluto", "pluto-portal", 
                    VERSION_PROPERTIES.getProperty("pluto.version"), "war");

    public static final InstallationDependency  TESTSUITE =
            new InstallationDependency("org.apache.pluto", "pluto-testsuite", 
                    VERSION_PROPERTIES.getProperty("pluto.version"), "war");

    public static final InstallationDependency  CASTOR =
            new InstallationDependency("org.codehaus.castor", "castor", 
                    VERSION_PROPERTIES.getProperty("castor.version"));

    public static final InstallationDependency  COMMONS_LOGGING_API =
            new InstallationDependency("commons-logging", "commons-logging-api",
                    VERSION_PROPERTIES.getProperty("commons-logging.version"));

    public static final InstallationDependency  XERCES =
            new InstallationDependency("xerces", "xercesImpl", 
                    VERSION_PROPERTIES.getProperty("xercesImpl.version"));

    public static final InstallationDependency  XML_PARSER_APIS =
            new InstallationDependency("xerces", "xmlParserAPIs", 
                    VERSION_PROPERTIES.getProperty("xmlParserAPIs.version"));
    
    
    public static final InstallationDependency JAXB_API =
		new InstallationDependency("javax.xml.bind","jaxb-api",
				VERSION_PROPERTIES.getProperty("jaxb.version"));
    public static final InstallationDependency JAXB_IMPL =
		new InstallationDependency("com.sun.xml.bind","jaxb-impl",
				VERSION_PROPERTIES.getProperty("jaxb-impl.version"));
    
    public static final InstallationDependency STAX_API =
		new InstallationDependency("stax","stax-api",
				VERSION_PROPERTIES.getProperty("stax.api.version"));
    public static final InstallationDependency STAX_IMPL =
		new InstallationDependency("stax","stax",
				VERSION_PROPERTIES.getProperty("stax.impl.version"));
    
    public static final InstallationDependency XALAN =
		new InstallationDependency("xalan","xalan",
				VERSION_PROPERTIES.getProperty("xalan.version"));
    public static final InstallationDependency ACTIVATION =
		new InstallationDependency("javax.activation","activation",
				VERSION_PROPERTIES.getProperty("activation.version"));

    public static final InstallationDependency CCPP_API =
		new InstallationDependency("javax.ccpp","ccpp",
				VERSION_PROPERTIES.getProperty("ccpp-api.version"));
//    public static final InstallationDependency CCPP_IMPL=
//		new InstallationDependency("com.sun.ccpp","ccpp-ri",
//				VERSION_PROPERTIES.getProperty("ccpp-ri.version"));
//    public static final InstallationDependency RDF_FILTER =
//		new InstallationDependency("com.megginson.sax.rdf.rdffilter","rdffilter",
//				VERSION_PROPERTIES.getProperty("rdffilter.version"));
//    public static final InstallationDependency JENA =
//		new InstallationDependency("com.hp.hpl.jena","jena",
//				VERSION_PROPERTIES.getProperty("jena.version"));
 
    

    private static final List ENDORSED = new ArrayList();
    private static final List SHARED = new ArrayList();

    static {
//        ENDORSED.add(XERCES);
//        ENDORSED.add(XML_PARSER_APIS);
        SHARED.add(XERCES);
        SHARED.add(XML_PARSER_APIS);

        SHARED.add(PORTLET_API);
        SHARED.add(CONTAINER_API);
        SHARED.add(DESCRIPTOR_API);
        SHARED.add(DESCRIPTOR_IMPL);
        SHARED.add(CONTAINER);
        SHARED.add(TAGLIB);
        SHARED.add(CASTOR);
        
        SHARED.add(JAXB_API);
        SHARED.add(JAXB_IMPL);
        
        SHARED.add(STAX_API);
        SHARED.add(STAX_IMPL);
        
        SHARED.add(ACTIVATION);

        SHARED.add(CCPP_API);

    }


    public static Collection getEndorsedDependencies() {
        return Collections.unmodifiableCollection(ENDORSED);
    }

    public static Collection getSharedDependencies() {
        return Collections.unmodifiableCollection(SHARED);
    }

    private String groupId;
    private String artifactId;
    private String version;
    private String type;

    public InstallationDependency(String groupId, String artifactId, String version) {
        this(groupId, artifactId, version, "jar");
    }

    public InstallationDependency(String groupId, String artifactId, String version, String type) {
        if (version == null || version.trim().equalsIgnoreCase(""))
        {
            throw new RuntimeException("Missing or invalid property for artifact " + 
                    artifactId + " in " + PROPERTIES_FILE + "!");
        }
        
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.type = type;
    }


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
