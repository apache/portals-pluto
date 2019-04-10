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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.pluto.container.PageResourceId;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PageResources;
import org.apache.pluto.driver.services.portal.PropertyConfigService;
import org.apache.pluto.driver.services.portal.RenderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encapsulation of the Pluto Driver ResourceConfig Info.
 *
 * @version 1.0
 * @since Sep 23, 2004
 */
public class ResourceConfig implements PropertyConfigService
{

    /** Internal Logger. */
    private static final Logger LOG =
        LoggerFactory.getLogger(ResourceConfig.class);

    /** The name of the portal. */
    private String portalName;

    /** The Version of the Portal. */
    private String portalVersion;

    /** The name of the container wrapped by this portal. */
    private String containerName;

    /** The portlet modes we will support. */
    private final Set<String> supportedPortletModes = new HashSet<String>();

    /** The window states we will support. */
    private final Set<String> supportedWindowStates = new HashSet<String>();

    /** The portlet applications registered with us. */
//    private final Map portletApplications;
    
    /** The page level resources */
    private final PageResources pageResources = new PageResources();

    /** The default page resources */
    private List<PageResourceId> defaultPageResources = new ArrayList<PageResourceId>();

    /** Encapsulation of render configuration data. */
    private RenderConfig renderConfig;

    /**
     * Standard Getter.
     * @return the name of the portal.
     */
    public String getPortalName() {
        return portalName;
    }

    /**
     * Standard Getter.
     * @param portalName the name of the portal.
     */
    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    /**
     * Standard Getter.
     * @return the portal version.
     */
    public String getPortalVersion() {
        return portalVersion;
    }

    /**
     * Standard Setter.
     * @param portalVersion the portal version.
     */
    public void setPortalVersion(String portalVersion) {
        this.portalVersion = portalVersion;
    }

    /**
     * Standard Getter.
     * @return the name of the container.
     */
    public String getContainerName() {
        return containerName;
    }

    /**
     * Standard Setter.
     * @param containerName the name of the container.
     */
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * Standard Getter.
     * @return the names of the supported portlet modes.
     */
    public Set<String> getSupportedPortletModes() {
        return supportedPortletModes;
    }

    /**
     * Standard Setter.
     * @param supportedPortletModes the names of the supported portlet modes.
     */
    public void setSupportedPortletModes(Set<String> supportedPortletModes) {
        this.supportedPortletModes.clear();
        this.supportedPortletModes.addAll(supportedPortletModes);
    }

    /**
     * Add the named supported portlet mode to the list of supported modes.
     * @param mode a supported mode.
     */
    public void addSupportedPortletMode(String mode) {
        supportedPortletModes.add(mode);
    }

    /**
     * Standard Getter.
     * @return the names of the supported window states.
     */
    public Set<String> getSupportedWindowStates() {
        return supportedWindowStates;
    }

    /**
     * Standard Setter.
     * @param supportedWindowStates the names of the supported window states.
     */
    public void setSupportedWindowStates(Set<String> supportedWindowStates) {
        this.supportedWindowStates.clear();
        this.supportedWindowStates.addAll(supportedWindowStates);
    }

    /**
     * Add the named supported window state to the list of supported states.
     * @param state the name of the supported state.
     */
    public void addSupportedWindowState(String state) {
        this.supportedWindowStates.add(state);
    }
    
    public PageResources getResources() {
       return pageResources;
    }
    
    public void addResource(String name, String scope, String version, String sType, String source) {
       PageResourceId resid = new PageResourceId(name, scope, version);
       PageResources.Type type = null;
       try{
          type = PageResources.Type.valueOf(sType.toUpperCase());
       } catch(Exception e) {}
       pageResources.addResource(resid, type, source);
    }
    
    
    public List<PageResourceId> getDefaultPageDependencies() {
       return defaultPageResources;
    }
    
    public void addDefaultPageDependency(String name, String scope, String version) {
       if (name != null) {
          PageResourceId resid = new PageResourceId(name, scope, version);
          defaultPageResources.add(resid);
       } else {
          LOG.warn("Resource name cannot be null.");
       }

       if (LOG.isDebugEnabled()) {
          StringBuilder txt = new StringBuilder(128);
          txt.append("Adding resource dependency. # deps: ").append(defaultPageResources.size());
          txt.append(", name: ").append(name);
          txt.append(", scope: ").append(scope);
          txt.append(", version: ").append(version);
          LOG.debug(txt.toString());
       }
    }


    /**
     * Standard Getter.
     * @return the render configuration.
     */
    public RenderConfig getRenderConfig() {
        return renderConfig;
    }

    /**
     * Standard Setter.
     * @param renderConfig the render configuration.
     */
    public void setRenderConfig(RenderConfig renderConfig) {
        this.renderConfig = renderConfig;
    }
    
    /**
     * Makes sure that defaults are set for backward compatibility if the page def file 
     * had no page resource definitions. Writes config info to log depending on trace settings.
     */
    public void initialized() {
       
       // let the page resources set defaults
       pageResources.initialized();
       
       if (defaultPageResources.isEmpty()) {
          defaultPageResources.add(new PageResourceId("pluto.css", "org.apache.portals", "3.0.0"));
          defaultPageResources.add(new PageResourceId("portlet-spec-1.0.css", "org.apache.portals", "1.0.0"));
          defaultPageResources.add(new PageResourceId("portlet-spec-2.0.css", "org.apache.portals", "2.0.0"));
          defaultPageResources.add(new PageResourceId("pluto.js", "org.apache.portals", "3.0.0"));
       }
       
       if (LOG.isDebugEnabled()) {
          StringBuilder txt = new StringBuilder(128);
          txt.append("Logging config info.\n");
          txt.append(pageResources.toString());
          txt.append("\n\nDefault page dependencies:");
          for (PageResourceId id : defaultPageResources) {
             txt.append("\n   ").append(id.toString());
          }
          txt.append("\n\nDeclared page dependencies:");
          for (PageConfig pc : renderConfig.getPages()) {
             if (!pc.getPageResources().isEmpty()) {
                txt.append("\n   Page: ").append(pc.getName());
                for (PageResourceId id : pc.getPageResources()) {
                   txt.append("\n      ").append(id.toString());
                }
             }
          }
          LOG.debug(txt.toString());
       }
    }

}

