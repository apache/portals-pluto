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

package org.apache.pluto.portalImpl.factory;

import org.apache.pluto.portalImpl.services.factorymanager.FactoryManager;
import org.apache.pluto.services.information.DynamicInformationProvider;
import org.apache.pluto.services.information.InformationProviderService;
import org.apache.pluto.services.information.StaticInformationProvider;
import org.apache.pluto.services.title.DynamicTitleService;

public class FactoryAccess {

    public static StaticInformationProvider getStaticProvider()
    {
        return getProviderFactory().getStaticProvider();
    }

    public static DynamicInformationProvider getDynamicProvider(javax.servlet.http.HttpServletRequest request)
    {
        return getProviderFactory().getDynamicProvider(request);
    }

    public static InformationProviderService getInformationProviderContainerService()
    {
        return getProviderService();
    }
    
    public static DynamicTitleService getDynamicTitleContainerService()
    {
        return getDynTitleServiceFactory().getDynamicTitleService();
    }

    private static InformationProviderFactory getProviderFactory()
    { 
        return(InformationProviderFactory)FactoryManager.getFactory(org.apache.pluto.portalImpl.factory.InformationProviderFactory.class);
    }

    private static InformationProviderService getProviderService()
    { 
        return(InformationProviderService)FactoryManager.getFactory(org.apache.pluto.portalImpl.factory.InformationProviderFactory.class);
    }

    private static DynamicTitleServiceFactory getDynTitleServiceFactory()
    { 
        return(DynamicTitleServiceFactory)FactoryManager.getFactory(org.apache.pluto.portalImpl.factory.DynamicTitleServiceFactory.class);
    }

}                           
