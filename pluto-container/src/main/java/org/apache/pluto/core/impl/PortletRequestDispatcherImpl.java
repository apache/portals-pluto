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

import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalPortletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.RequestDispatcher;
import java.util.Map;

public class PortletRequestDispatcherImpl implements PortletRequestDispatcher {
    private static final Log LOG =
        LogFactory.getLog(PortletRequestDispatcherImpl.class);

    private javax.servlet.RequestDispatcher requestDispatcher;
    private Map queryParams;

    public PortletRequestDispatcherImpl(RequestDispatcher requestDispatcher) {
        this.requestDispatcher = requestDispatcher;
    }

    public PortletRequestDispatcherImpl(RequestDispatcher requestDispatcher, Map queryParams) {
        this(requestDispatcher);
        this.queryParams = queryParams;
    }

    public void include(RenderRequest request, RenderResponse response)
        throws PortletException, java.io.IOException {

        InternalPortletRequest internalRequest =
            InternalImplConverter.getInternalRequest(request);

        InternalPortletResponse internalResponse =
            InternalImplConverter.getInternalResponse(response);

        if(queryParams != null) {
            if(LOG.isDebugEnabled()) {
                LOG.debug("Creating Included Render Request to override query parameters.");
            }
            internalRequest = new IncludedRenderRequestImpl(internalRequest, queryParams);
        }
        boolean isIncluded = internalRequest.isIncluded() ||
                             internalResponse.isIncluded();
        try {
            internalRequest.setIncluded(true);
            internalResponse.setIncluded(true);

            this.requestDispatcher.include(
                (javax.servlet.http.HttpServletRequest) internalRequest,
                (javax.servlet.http.HttpServletResponse) internalResponse);
        } catch (java.io.IOException e) {
            throw e;
        } catch (javax.servlet.ServletException e) {
            if (e.getRootCause() != null) {
                throw new PortletException(e.getRootCause());
            } else {
                throw new PortletException(e);
            }
        } finally {
            internalRequest.setIncluded(isIncluded);
            internalResponse.setIncluded(isIncluded);
        }
    }
    // --------------------------------------------------------------------------------------------

    // portlet-servlet implementation
    /*
        public void include(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response)
        throws javax.servlet.ServletException, java.io.IOException
        {
        }
    
        public void forward(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response)
        throws javax.servlet.ServletException, java.io.IOException
        {
        }
    */
}
