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

package org.apache.pluto.portalImpl.core;

import java.util.HashMap;

import org.apache.pluto.services.ContainerService;

public class PortletContainerEnvironment 
implements org.apache.pluto.services.PortletContainerEnvironment {

    private HashMap services = new HashMap();

    public PortletContainerEnvironment()
    {
    }

    // org.apache.pluto.services.PortletContainerEnvironment implementation.

    public ContainerService getContainerService(Class service)
    {
        return(ContainerService)services.get(service);
    }

    // additional methods.

    public void addContainerService(ContainerService service)
    {
        Class serviceClass = service.getClass();
        while (serviceClass!=null) {
            Class[] interfaces = serviceClass.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                Class[] interfaces2 = interfaces[i].getInterfaces();
                for (int ii = 0; ii < interfaces2.length; ii++) {
                    if (interfaces2[ii].equals(ContainerService.class)) {
                        services.put(interfaces[i], service);
                    }
                }
            }
            serviceClass = serviceClass.getSuperclass();
        }
    }

}
