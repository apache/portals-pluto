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

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * This interface defines the operations required by the Pluto container in order to invoke portlets.
 * Portlet invokers are defined by three operations: <code>action</code>, <code>render</code>, and optionally
 * <code>load</code>. The container delegates the actual implementation of these operations to the 
 * portal. The <code>action</code> method will invoke the <code>processAction</code> method on 
 * the <code>javax.portlet.Portlet</code> interface of a portlet. The <code>render</code> method 
 * will invoke the <code>render</code> method on the <code>javax.portlet.Portlet</code> interface of a portlet.
 * 
 * @version $Id: PortletInvoker.java,v 1.3 2004/03/02 14:49:02 cziegeler Exp $
 */
public interface PortletInvoker 
{

    /**
     * This method invokes the processAction method of a Java portlet (<code>javax.portlet.Portlet</code>).
     * 
     * @param request Represents the request sent to a portlet to handle an action. 
     * @param response Represents the response provide by a portlet in handling an action.
     * @throws PortletException
     * @throws IOException
     */
    public void action(ActionRequest request, ActionResponse response) throws PortletException,IOException;

    /**
     * This method invokes the render method of a Java portlet (<code>javax.portlet.Portlet</code>).
     * 
     * @param request Represents the request sent to a portlet to handle rendering the portlet.
     * @param response Represents the response provide by a portlet in rendering.
     * @throws PortletException
     * @throws IOException
     */
    public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException;
    
    /**
     * This method invokes the optional load method of a portlet if supported.
     * This method is not yet standardized.
     * 
     * @param request Represents the request sent to a portlet to handle initializing the portlet.
     * @param response Represents the response sent to a portlet to handle initializing the portlet.
     * @throws PortletException
     */
    public void load(PortletRequest request, RenderResponse response) throws PortletException;
}
