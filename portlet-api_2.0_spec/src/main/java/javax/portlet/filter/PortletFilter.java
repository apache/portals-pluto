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

import javax.portlet.PortletException;

/**
 * The <code>PortletFilter</code> is the base interface for all portlet filters.
 * It provides the lifecycle methods <code>init</code> and <code>destroy</code>
 * for putting a portlet filter into and out of service.
 *
 * @since 2.0
 */
public interface PortletFilter {

    /**
     * Called by the portlet container to indicate to a filter
     * that it is being placed into service. The portlet container 
     * calls the init method exactly once after instantiating the filter. 
     * The init method must complete successfully before the filter 
     * is asked to do any filtering work.
     * <p>
     * The portlet container cannot place the filter into service if the init method either
     * <ul>
     *   <li>throws a PortletException</li>
     *   <li>does not return within a time period defined by the portlet container</li>
     * </ul>
     * 
     * @param filterConfig    the filter configuration data defined 
     *                        in the portlet deployment descriptor
     * @throws PortletException  if an error occurs in the filter initialization
     */
    public void init(FilterConfig filterConfig) throws PortletException;

    
    /**
     * Called by the portlet container to indicate to a filter that it is 
     * being taken out of service. This method is only called once all threads 
     * within the filter's <code>doFilter</code> method have exited or 
     * after a timeout period has passed. 
     * <p>
     * After the portlet container calls this method, it will not call the 
     * <code>doFilter</code> method again on this instance of the filter.
     * <p>
     * This method gives the filter an opportunity to clean up any resources 
     * that are being held (for example, memory, file handles, threads) and 
     * make sure that any persistent state is synchronized with the 
     * filter's current state in memory.
     */
    public void destroy();

}
