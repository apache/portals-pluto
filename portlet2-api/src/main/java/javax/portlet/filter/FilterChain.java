/*
 * Copyright 2006 The Apache Software Foundation
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
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/*
 * Copyright 2006 IBM Corporation.
 */
package javax.portlet.filter;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * A <code>FilterChain</code> is an object provided by the portlet container 
 * to the developer giving a view into the invocation chain of a 
 * filtered request for a portlet. Filters use the <code>FilterChain</code> 
 * to invoke the next filter in the chain, or if the calling filter is the 
 * last filter in the chain, to invoke the portlet at the end of the chain.
 *
 * @since 2.0
 */
public interface FilterChain {

    /**
     * Causes the next filter in the chain to be invoked, 
     * or if the calling filter is the last filter in the chain, 
     * causes the portlet at the end of the chain to be invoked.
     * 
     * @param request  the current request, must be of type
     *                 <code>ActionRequest</code>, 
     *                 <code>EventRequest</code>, 
     *                 <code>RenderRequest</code>, or 
     *                 <code>ResourceRequest.</code> 
     * @param response  the current response, nust be of type
     *                 <code>ActionResponse</code>, 
     *                 <code>EventReaponse</code>, or 
     *                 <code>RenderResponse</code>. 
     * @throws IOException  if an IO error occured in the filter processing
     * @throws PortletException  if a portlet exception occured in the filter processing
     */
    public void doFilter(PortletRequest request, PortletResponse response)
     throws IOException, PortletException;
    
}
