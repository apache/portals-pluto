/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet.filter;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;

/**
 * <div class="changed_added_3_0">
 * A <code>HeaderFilterChain</code> object is provided by the portlet container 
 * to give a view into the invocation chain of a 
 * filtered header request for a portlet. Filters use the <code>HeaderFilterChain</code> 
 * to invoke the next filter in the chain, or if the calling filter is the 
 * last filter in the chain, to invoke the portlet at the end of the chain.
 * </div>
 *
 * @since 3.0
 */
public interface HeaderFilterChain {
    
    /**
     * <div class="changed_added_3_0">
     * Causes the next filter in the chain to be invoked, 
     * or if the calling filter is the last filter in the chain, 
     * causes the portlet at the end of the chain to be invoked.
     * </div>
     * 
     * @param request  the current header request. 
     * @param response  the current header response.
     *  
     * @throws IOException  if an IO error occurred in the filter processing
     * @throws PortletException  if a portlet exception occurred in the filter processing
     */
    public void doFilter(HeaderRequest request, HeaderResponse response)
     throws IOException, PortletException;


}
