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
package org.apache.pluto.invoker;

import org.apache.pluto.factory.PortletInvokerFactory;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.services.factory.FactoryManager;

/**
 * PortletInvokerAccess is a static accessor for getting and releasing portlet invokers via
 * the portal's portlet invoker factory.
 *
 * @version $Id: PortletInvokerAccess.java,v 1.3 2004/03/02 14:49:02 cziegeler Exp $
 */
public class PortletInvokerAccess 
{
    private static PortletInvokerFactory invokerFactory = 
            (PortletInvokerFactory)FactoryManager.getFactory(org.apache.pluto.invoker.PortletInvoker.class);
    
    /* (non-Javadoc)
     * @see org.apache.pluto.factory.PortletInvokerFactory#getPortletInvoker(org.apache.pluto.om.portlet.PortletDefinition)
     */
    public static PortletInvoker getPortletInvoker(PortletDefinition portletDefinition)
    {
        return invokerFactory.getPortletInvoker(portletDefinition);
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.factory.PortletInvokerFactory#releasePortletInvoker(org.apache.pluto.invoker.PortletInvoker)
     */
    public static void releasePortletInvoker(PortletInvoker invoker)
    {
        invokerFactory.releasePortletInvoker(invoker);
    }
}
