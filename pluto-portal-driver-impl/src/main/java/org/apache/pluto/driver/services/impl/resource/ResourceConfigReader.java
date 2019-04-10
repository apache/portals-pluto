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
package org.apache.pluto.driver.services.impl.resource;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.RenderConfig;
import org.xml.sax.SAXException;

/**
 * @version 1.0
 * @since Sep 23, 2004
 */
public class ResourceConfigReader {

    private static final Logger LOG = LoggerFactory.getLogger(
        ResourceConfigReader.class
    );

    public static final String CONFIG_FILE =
        "/WEB-INF/pluto-portal-driver-config.xml";


    private static ResourceConfigReader factory;

    public static ResourceConfigReader getFactory() {
        if (factory == null) {
            factory = new ResourceConfigReader();
        }
        return factory;
    }

    private Digester digester;

    private ResourceConfigReader() {
        digester = new Digester();
        // digester.setLogger(LOG);  // Too many log messages.
        digester.setClassLoader(Thread.currentThread().getContextClassLoader());
        init();
    }

    public ResourceConfig parse(InputStream in)
        throws IOException, SAXException {
        return (ResourceConfig) digester.parse(in);
    }

// Digester Setup

    private void init() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Setting up digester...");
        }
        digester.addObjectCreate(
            "pluto-portal-driver",
            ResourceConfig.class
        );
        digester.addBeanPropertySetter(
            "pluto-portal-driver/portal-name",
            "portalName"
        );
        digester.addBeanPropertySetter(
            "pluto-portal-driver/portal-version",
            "portalVersion"
        );
        digester.addBeanPropertySetter(
            "pluto-portal-driver/container-name",
            "containerName"
        );

        digester.addCallMethod(
            "pluto-portal-driver/supports/portlet-mode",
            "addSupportedPortletMode", 0
        );
        digester.addCallMethod(
            "pluto-portal-driver/supports/window-state",
            "addSupportedWindowState", 0
        );
        
        // Page resources
        digester.addCallMethod(
              "pluto-portal-driver/page-resources/page-resource",
              "addResource", 5);
        digester.addCallParam(
             "pluto-portal-driver/page-resources/page-resource/identifier/name", 0);
        digester.addCallParam(
              "pluto-portal-driver/page-resources/page-resource/identifier/scope", 1);
        digester.addCallParam(
              "pluto-portal-driver/page-resources/page-resource/identifier/version", 2);
        digester.addCallParam(
              "pluto-portal-driver/page-resources/page-resource/source", 3, "type");
        digester.addCallParam(
              "pluto-portal-driver/page-resources/page-resource/source", 4);

        
        // Default resources for each page
        digester.addCallMethod(
              "pluto-portal-driver/page-resources/default-resource",
              "addDefaultPageDependency", 3);
        digester.addCallParam(
             "pluto-portal-driver/page-resources/default-resource/name", 0);
        digester.addCallParam(
              "pluto-portal-driver/page-resources/default-resource/scope", 1);
        digester.addCallParam(
              "pluto-portal-driver/page-resources/default-resource/version", 2);

        
        // render configuration 
        digester.addObjectCreate(
            "pluto-portal-driver/render-config",
            RenderConfig.class
        );
        digester.addSetProperties(
            "pluto-portal-driver/render-config",
            "default", "defaultPageId"
        );
        
        // handle individual pages with portlets
        digester.addObjectCreate(
            "pluto-portal-driver/render-config/page",
            PageConfig.class
        );
        digester.addSetProperties("pluto-portal-driver/render-config/page");
        digester.addCallMethod(
            "pluto-portal-driver/render-config/page/portlet", "addPortlet", 2
        );
        digester.addCallParam(
            "pluto-portal-driver/render-config/page/portlet",
            0, "context"
        );
        digester.addCallParam(
            "pluto-portal-driver/render-config/page/portlet",
            1, "name"
        );
        
        // Process any page-level dependencies
        digester.addCallMethod(
              "pluto-portal-driver/render-config/page/dependency",
              "addPageDependency", 3);
        digester.addCallParam(
             "pluto-portal-driver/render-config/page/dependency/name", 0);
        digester.addCallParam(
              "pluto-portal-driver/render-config/page/dependency/scope", 1);
        digester.addCallParam(
              "pluto-portal-driver/render-config/page/dependency/version", 2);
        
        digester.addSetNext(
            "pluto-portal-driver/render-config/page",
            "addPage"
        );
        digester.addSetNext(
            "pluto-portal-driver/render-config",
            "setRenderConfig"
        );
    }

}

