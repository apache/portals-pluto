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
package org.apache.pluto.invoker;

import org.apache.pluto.factory.PortletInvokerFactory;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.services.factory.FactoryManager;

/**
 * PortletInvokerAccess is a static accessor for getting and releasing portlet invokers via
 * the portal's portlet invoker factory.
 *
 * @version $Id: PortletInvokerAccess.java,v 1.2 2004/01/08 02:20:16 taylor Exp $
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
