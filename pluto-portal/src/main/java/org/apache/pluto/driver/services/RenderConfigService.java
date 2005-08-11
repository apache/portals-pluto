/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.driver.services;

import org.apache.pluto.driver.services.impl.resource.PageConfig;

import java.util.List;

/**
 * Service interface defining methods necessary for
 * a provider wishing to manage page administration.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @since Aug 10, 2005
 */
public interface RenderConfigService extends DriverConfigurationService {

    /**
     * Retrieve an ordered list of all PageConfig instances.
     * @return list of all PageConfig instances.
     */
    List getPages();

    /**
     * Retrieve the PageConfig for the default
     * page.
     * @return PageConfig instance of the default page.
     */
    PageConfig getDefaultPage();

    /**
     * Retrieve the PageConfig for the given
     * page id.
     *
     * @param id
     * @return PageConfig instance for the specified id.
     */
    PageConfig getPage(String id);

}
