/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
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
 * @version $Id: PortletInvokerFactory.java,v 1.2 2004/01/08 02:20:16 taylor Exp $
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
