/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 

 */

package org.apache.pluto.driver.services;

import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.core.PortalEnvironment;
import org.apache.pluto.driver.core.ResourceURLProviderImpl;
import org.apache.pluto.services.DynamicInformationProvider;
import org.apache.pluto.services.PortletURLProvider;
import org.apache.pluto.services.ResourceURLProvider;


public class DynamicInformationProviderImpl
    implements DynamicInformationProvider {

    /**
     * The number of known MimtTypes which may be added to the response content
     * type set.  This number is used to initialize the HashSets created here.
     */
    private final static int NUMBER_KNOWN_MIMETYPES = 15;


    private PortalEnvironment env;

    public DynamicInformationProviderImpl(HttpServletRequest request) {
        env = PortalEnvironment.getPortalEnvironment(request);
    }

    // DynamicInformationProviderImpl implementation.

    public PortletURLProvider getPortletURLProvider(
        PortletWindow internalPortletWindow) {
        return new PortletURLProviderImpl(env.getRequest(),
                                          internalPortletWindow);
    }

    public ResourceURLProvider getResourceURLProvider(
        PortletWindow internalPortletWindow) {
        return new ResourceURLProviderImpl(env.getRequest(),
                                           internalPortletWindow);
    }

    public String getResponseContentType() {
        return "text/html";
    }

    /**
     * @return
     * @todo not implemented properly.
     */
    public Iterator getResponseContentTypes() {
        HashSet responseMimeTypes = new HashSet(NUMBER_KNOWN_MIMETYPES);
        responseMimeTypes.add("text/html");

        return responseMimeTypes.iterator();
    }
}
