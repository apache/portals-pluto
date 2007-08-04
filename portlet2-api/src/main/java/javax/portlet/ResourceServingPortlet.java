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
 * NOTE: this source code is based on an early draft version of JSR 286 and not intended for product
 * implementations. This file may change or vanish in the final version of the JSR 286 specification.
 */
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/**
  * Copyright 2006 IBM Corporation.
  */
package javax.portlet;

/**
 * The <code>ResourceServingPortlet</code> interface allows
 * serving resources through the portlet.
 * <p>
 * The portlet container must call this method for links created by
 * the <code>RenderResponse.createResouceURL()</code> call.
 * If the portlet creates resource URLs with <code>RenderResponse.createResouceURL()</code> 
 * it must implement this lifecycle method.
 * 
 * @since 2.0
 */
public interface ResourceServingPortlet {

    /**
     * Called by the portlet container to allow the portlet to generate
     * the resouce content based on its current state.
     * The portal / portlet container must not render any output in addition 
     * to the content returned by the portlet. The portal / portlet container 
     * should expect that the portlet may return binary content for a 
     * <code>renderResource</code> call.
     *
     * @param   request
     *          the resource request
     * @param   response
     *          the resource response
     *
     * @exception   PortletException
     *              if the portlet has problems fulfilling the
     *              rendering request
     * @exception  UnavailableException     
     *                   if the portlet is unavailable to perform render at this time
     * @exception  PortletSecurityException  
     *                   if the portlet cannot fullfill this request because of security reasons
     * @exception  java.io.IOException
     *              if the streaming causes an I/O problem
     */


    public void serveResource(ResourceRequest request, ResourceResponse response)
        throws PortletException, java.io.IOException;
}
