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

import org.apache.pluto.PortletContainer;
import org.apache.pluto.portalImpl.services.config.Config;

/**
 * 

 */
public class PortletContainerFactory
{

    public static final String ENTRANCE_IMPL = "portletcontainer.entrance.impl";
    public static final String ENTRANCE_WRAPPER_IMPL = "portletcontainer.entrance.wrapper.impl";
    
    private static PortletContainer portletContainer;
    private static PortletContainer portletContainerWrapper;

    static
    {
        try {
            portletContainer = (PortletContainer)Class.forName(
                Config.getParameters().getString(ENTRANCE_IMPL)).newInstance();
            portletContainerWrapper = (PortletContainer)Class.forName(
                Config.getParameters().getString(ENTRANCE_WRAPPER_IMPL)).newInstance();
        }
        catch (java.lang.IllegalAccessException e)
        {
            System.err.println("PortletContainerFactory.static constructor");
            e.printStackTrace(System.err);
        }
        catch (java.lang.InstantiationException e)
        {
            System.err.println("PortletContainerFactory.static constructor");
            e.printStackTrace(System.err);
        }
        catch (java.lang.ClassNotFoundException e)
        {
            System.err.println("PortletContainerFactory.static constructor");
            e.printStackTrace(System.err);
        }
    }

    static PortletContainer getPortletContainerOriginal()
    {
        return portletContainer;
    }

    public static PortletContainer getPortletContainer()
    {
        return portletContainerWrapper;
    }
}
