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
package org.apache.pluto.factory;

import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.invoker.PortletInvoker;

/**
 * <p>
 * Portlet Invoker Factory creates portlet invokers based on the servlet context.
 * This class is part of the contract between Pluto and the portal implementations as defined
 * in the interfaces under <code>org.apache.pluto.factory</code>
 * The Pluto container uses portlet invokers to abstract access to portlets.
 * An invoker interfaces defines which actions are performed between the portal and container,
 * namely action, render and optionally load. Portlet invoker factories are implemented by
 * the portal implementation. The Pluto container uses pluggable portlet invoker factories
 * in order to get portlet invokers, and then invoke methods on portlets (render, action, load). 
 * </p>
 * <p>
 * The Portlet Invoker Factory is a Pluto factory. Pluto defines a basic lifecycle for Pluto
 * factory services in the <code>org.apach.pluto.factory.Factory</code> interface with
 * standard <code>init</code> and <code>destroy</code> methods.
 * </p>
 * 
 * @version $Id: PortletInvokerFactory.java,v 1.3 2004/03/02 14:48:55 cziegeler Exp $
 */

public interface PortletInvokerFactory extends Factory 
{
    /**
     * The container calls this method to get a portlet invoker from the portal.
     * With this abstraction, the portal should handle optional pooling of invokers.
     *  
     * @param portletDefinition The portlet definition describing the portlet to be invoked.
     * @return A portlet invoker ready to invoke portlets.
     */
    PortletInvoker getPortletInvoker(PortletDefinition portletDefinition);
    
    /**
     * The container calls this method to release a portlet invoker back to the portal, indicating
     * that the container is done with the invoker. At this time, the invoker could be released
     * to an object pool.
     * 
     * @param invoker The portlet invoker ready to be released.
     */
    void releasePortletInvoker(PortletInvoker invoker);
}
