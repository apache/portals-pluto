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
/* 

 */

package org.apache.pluto.core.impl;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletResponse;
import org.apache.pluto.portlet.PortletRequestWrapper;
import org.apache.pluto.portlet.PortletResponseWrapper;

class InternalImplConverter {


    /**
     * The scary part about this is that there is not yet a
     * PortletRequestWrapper defined by the spec.  Because of this, there's a
     * chance someone might implement their own wrapper and we won't be able to
     * get the real internal one!
     * @param request
     * @return
     */
    public static InternalPortletRequest getInternalRequest(
        PortletRequest request) {
        while (!(request instanceof InternalPortletRequest)) {
            request = ((PortletRequestWrapper) request).getPortletRequest();
            if (request == null) {
                throw new IllegalStateException(
                    "The internal portlet request cannot be found.");
            }
        }
        return (InternalPortletRequest) request;
    }

    /**
     * The scary part about this is that there is not yet a
     * PortletRequestWrapper defined by the spec.  Because of this, there's a
     * chance someone might implement their own wrapper and we won't be able to
     * get the real internal one!
     * @param response
     * @return
     */
    public static InternalPortletResponse getInternalResponse(
        PortletResponse response) {
        while (!(response instanceof InternalPortletResponse)) {
            response = ((PortletResponseWrapper) response).getPortletResponse();
            if (response == null) {
                throw new IllegalStateException(
                    "The internal portlet response cannot be found.");
            }
        }
        return (InternalPortletResponse) response;
    }
}
