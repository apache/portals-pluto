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

package javax.portlet;

import java.io.IOException;

/**
 * <div class="changed_added_3_0">
 * The <code>HeaderPortlet</code> interface provides portlets
 * with the ability to add HTTP headers to the response, and
 * to generate markup for aggregation into the portal response document head section. 
 * <p>
 * </div>
 *
 * @see     HeaderRequest
 * @see     HeaderResponse
 * @since 3.0
 */

public interface HeaderPortlet {

    /**
     * <div class="changed_added_3_0">
     * Called by the portlet container to allow the portlet to set response
     * headers and generate markup for overall response document head section. 
     * </div>
     * 
     * @param request  the header request
     * @param response  the header response
     * @exception  PortletException
     *                   if the portlet has problems fulfilling the request
     * @exception  UnavailableException   
     *                   if the portlet is unavailable to process the request at this time
     * @exception  PortletSecurityException  
     *                   if the portlet cannot fulfill this request due to security reasons
     * @exception  IOException
     *                   if the streaming causes an I/O problem
     */
    public void renderHeaders (HeaderRequest request, HeaderResponse response) 
        throws PortletException, java.io.IOException;
}
