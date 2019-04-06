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
            VERSION_PROPERTIES.getProperty("portals.portlet-api.version"));

    public static final InstallationDependency COMMONS_LANG3 =
        new InstallationDependency("org.apache.commons", "commons-lang3",
            VERSION_PROPERTIES.getProperty("commons-lang.version"));

    public static final InstallationDependency CLASSMATE =
        new InstallationDependency("com.fasterxml", "classmate",
            VERSION_PROPERTIES.getProperty("classmate.version"));

    public static final InstallationDependency HIBERNATE_VALIDATOR =
        new InstallationDependency("org.hibernate.validator", "hibernate-validator",
            VERSION_PROPERTIES.getProperty("hibernate-validator.version"));

    public static final InstallationDependency HIBERNATE_VALIDATOR_CDI =
        new InstallationDependency("org.hibernate.validator", "hibernate-validator-cdi",
            VERSION_PROPERTIES.getProperty("hibernate-validator.version"));

    public static final InstallationDependency JAXRS_API =
        new InstallationDependency("javax.ws.rs", "javax.ws.rs-api",
            VERSION_PROPERTIES.getProperty("jaxrs-api.version"));

    public static final InstallationDependency JBOSS_LOGGING =
        new InstallationDependency("org.jboss.logging", "jboss-logging",
            VERSION_PROPERTIES.getProperty("jboss-logging.version"));

    public static final InstallationDependency MVC_API =
        new InstallationDependency("javax.mvc", "javax.mvc-api",
            VERSION_PROPERTIES.getProperty("mvc-api.version"));

    public static final InstallationDependency VALIDATION_API =
        new InstallationDependency("javax.validation", "validation-api",
            VERSION_PROPERTIES.getProperty("validation-api.version"));

    public static final InstallationDependency CDI_IMPL =
        new InstallationDependency("org.jboss.weld.servlet", "weld-servlet",
                VERSION_PROPERTIES.getProperty("cdi.version"));

    public static final InstallationDependency ANNOTATION_DETECTOR =
        new InstallationDependency("eu.infomas", "annotation-detector",
                VERSION_PROPERTIES.getProperty("annotation-detector.version"));

    public static final InstallationDependency SLF4J_API =
        new InstallationDependency("org.slf4j", "slf4j-api", 
                VERSION_PROPERTIES.getProperty("slf4j.version"));

    public static final InstallationDependency SLF4J_IMPL =
        new InstallationDependency("org.slf4j", "slf4j-jdk14", 
                VERSION_PROPERTIES.getProperty("slf4j.version"));

    public static final InstallationDependency CONTAINER_API =
        new InstallationDependency("org.apache.portals.pluto", "pluto-container-api",
                VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency CONTAINER =
            new InstallationDependency("org.apache.portals.pluto", "pluto-container", 
                    VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency  TAGLIB =
            new InstallationDependency("org.apache.portals.pluto", "pluto-taglib", 
                    VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency CONTAINER_DRIVER_API =
        new InstallationDependency("org.apache.portals.pluto", "pluto-container-driver-api",
                VERSION_PROPERTIES.getProperty("pluto.version"));

    public static final InstallationDependency PORTAL =
            new InstallationDependency("org.apache.portals.pluto", "pluto-portal",
                    VERSION_PROPERTIES.getProperty("pluto.version"), "war");

    public static final InstallationDependency TESTSUITE =
            new InstallationDependency("org.apache.portals.pluto", "pluto-testsuite", 
                    VERSION_PROPERTIES.getProperty("pluto.version"), "war");

    public static final InstallationDependency CCPP_API =
		new InstallationDependency("javax.ccpp","ccpp",
				VERSION_PROPERTIES.getProperty("ccpp-api.version"));


    private static final List<InstallationDependency> ENDORSED = new ArrayList<InstallationDependency>();
    private static final List<InstallationDependency> SHARED = new ArrayList<InstallationDependency>();

    static {
        SHARED.add(PORTLET_API);
        SHARED.add(COMMONS_LANG3);
        SHARED.add(CLASSMATE);
        SHARED.add(HIBERNATE_VALIDATOR);
        SHARED.add(HIBERNATE_VALIDATOR_CDI);
        SHARED.add(JAXRS_API);
        SHARED.add(JBOSS_LOGGING);
        SHARED.add(MVC_API);
        SHARED.add(VALIDATION_API);
        SHARED.add(CONTAINER);
        SHARED.add(CONTAINER_API);
        SHARED.add(CONTAINER_DRIVER_API);
        SHARED.add(TAGLIB);
        SHARED.add(CCPP_API);
        SHARED.add(CDI_IMPL);
        SHARED.add(ANNOTATION_DETECTOR);
        SHARED.add(SLF4J_API);
        SHARED.add(SLF4J_IMPL);
    }


    public static Collection<InstallationDependency> getEndorsedDependencies() {
        return Collections.unmodifiableCollection(ENDORSED);
    }

    public static Collection<InstallationDependency> getSharedDependencies() {
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
