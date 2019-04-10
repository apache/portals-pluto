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

import java.util.List;
import java.util.Set;

import org.apache.pluto.container.PageResourceId;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PageResources;
import org.apache.pluto.driver.services.portal.RenderConfigService;
import org.apache.pluto.driver.services.portal.admin.RenderConfigAdminService;

/**
 * Default implementation of all of the portal Services.
 * Utilizes resource configuration from
 * <code>pluto-portal-driver-config.xml</code>
 *
 * @since Aug 10, 2005
 */
public class RenderConfigServiceImpl
    implements RenderConfigService, RenderConfigAdminService {


    private final ResourceConfig config;

    public RenderConfigServiceImpl(ResourceConfig config) {
        this.config = config;
    }

    public String getPortalName() {
        return config.getPortalName();
    }

    public String getPortalVersion() {
        return config.getPortalVersion();
    }

    public String getContainerName() {
        return config.getContainerName();
    }

    public Set<String> getSupportedPortletModes() {
        return config.getSupportedPortletModes();
    }

    public Set<String> getSupportedWindowStates() {
        return config.getSupportedWindowStates();
    }

    @Override
    public List<PageConfig> getPages() {
        return config.getRenderConfig().getPages();
    }

    @Override
    public PageConfig getDefaultPage() {
        return config.getRenderConfig().getPageConfig(null);
    }

    @Override
    public PageConfig getPage(String id) {
        return config.getRenderConfig().getPageConfig(id);
    }

    @Override
    public void addPage(PageConfig pageConfig) {
        config.getRenderConfig().addPage(pageConfig);
    }
    
    @Override
    public void removePage(PageConfig pageConfig){
        config.getRenderConfig().removePage(pageConfig);
    }
    
    @Override
    public PageResources getPageResources() {
       return config.getResources();
    }
    
    @Override
    public List<PageResourceId> getDefaultPageDependencies() {
       return config.getDefaultPageDependencies();
    }
}
