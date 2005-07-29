/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 23, 2004
 */
public class DriverConfigurationFactory {

    private static final Log LOG =
        LogFactory.getLog(DriverConfigurationFactory.class);

    private static DriverConfigurationFactory factory;

    public static DriverConfigurationFactory getFactory() {
        if (factory == null) {
            factory = new DriverConfigurationFactory();
        }
        return factory;
    }

    private Digester digester;

    private DriverConfigurationFactory() {
        digester = new Digester();
        digester.setLogger(LOG);
        digester.setClassLoader(Thread.currentThread().getContextClassLoader());
        init();
    }

    public DriverConfiguration parse(InputStream in)
        throws IOException, SAXException {
        return (DriverConfiguration) digester.parse(in);
    }


// Digester Setup

    private void init() {
        digester.addObjectCreate("pluto-portal-driver",
                                 DriverConfiguration.class);
        digester.addBeanPropertySetter("pluto-portal-driver/portal-name",
                                       "portalName");
        digester.addBeanPropertySetter("pluto-portal-driver/portal-version",
                                       "portalVersion");
        digester.addBeanPropertySetter("pluto-portal-driver/container-name",
                                       "containerName");

        digester.addCallMethod("pluto-portal-driver/supports/portlet-mode",
                               "addSupportedPortletMode", 0);
        digester.addCallMethod("pluto-portal-driver/supports/window-state",
                               "addSupportedWindowState", 0);

        digester.addObjectCreate("pluto-portal-driver/portlet-app",
                                 PortletApplicationConfig.class);
        digester.addBeanPropertySetter(
            "pluto-portal-driver/portlet-app/context-path", "contextPath");

        digester.addObjectCreate(
            "pluto-portal-driver/portlet-app/portlets/portlet",
            PortletWindowConfig.class);
        digester.addSetProperties(
            "pluto-portal-driver/portlet-app/portlets/portlet", "name",
            "portletName");
        digester.addSetNext("pluto-portal-driver/portlet-app/portlets/portlet",
                            "addPortlet");
        digester.addSetNext("pluto-portal-driver/portlet-app", "addPortletApp");

        digester.addObjectCreate("pluto-portal-driver/render-config",
                                 RenderConfig.class);
        digester.addSetProperties("pluto-portal-driver/render-config",
                                  "default", "defaultPageId");
        digester.addObjectCreate("pluto-portal-driver/render-config/page",
                                 PageConfig.class);
        digester.addSetProperties("pluto-portal-driver/render-config/page");
        digester.addCallMethod(
            "pluto-portal-driver/render-config/page/portlet", "addPortlet", 2);
        digester.addCallParam("pluto-portal-driver/render-config/page/portlet",
                              0, "context");
        digester.addCallParam("pluto-portal-driver/render-config/page/portlet",
                              1, "name");
        digester.addSetNext("pluto-portal-driver/render-config/page",
                            "addPage");
        digester.addSetNext("pluto-portal-driver/render-config",
                            "setRenderConfig");


    }


}

