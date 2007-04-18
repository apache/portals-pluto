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
package org.apache.pluto.internal.impl;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.FragmentRequest;
import javax.portlet.FragmentResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.internal.InternalRenderRequest;
import org.apache.pluto.internal.InternalRenderResponse;

/**
 * Implementation of the <code>PortletRequestDispatcher</code> interface.
 * The portlet request dispatcher is used to dispatch <b>RenderRequest</b> and
 * <b>RenderResponse</b> to a URI. Note that ActionRequest and ActionResponse
 * can never be dispatched.
 * 
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortletRequestDispatcherImpl implements PortletRequestDispatcher {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletRequestDispatcherImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    /** The nested servlet request dispatcher instance. */
    private RequestDispatcher requestDispatcher = null;
    
    /** The included query string. */
    private String queryString = null;
    
    
    // Constructors ------------------------------------------------------------
    
    /**
     * Creates an instance. This constructor should be called to construct a
     * named dispatcher.
     * @param requestDispatcher  the servlet request dispatcher.
     * @see javax.portlet.PortletContext#getNamedDispatcher(String)
     */
    public PortletRequestDispatcherImpl(RequestDispatcher requestDispatcher) {
        this.requestDispatcher = requestDispatcher;
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Named dispatcher created.");
        }
    }
    
    /**
     * Creates an instance. This constructor should be called to construct a
     * portlet request dispatcher.
     * @param requestDispatcher  the servlet request dispatcher.
     * @param queryString  the included query string.
     * @see javax.portlet.PortletContext#getRequestDispatcher(String)
     */
    public PortletRequestDispatcherImpl(RequestDispatcher requestDispatcher,
                                        String queryString) {
        this(requestDispatcher);
        this.queryString = queryString;
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Request dispatcher created.");
        }
    }
    
    
    // PortletRequestDispatcher Impl -------------------------------------------
    
    public void include(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {

        InternalRenderRequest internalRequest = (InternalRenderRequest)
                InternalImplConverter.getInternalRequest(request);
        InternalRenderResponse internalResponse = (InternalRenderResponse)
                InternalImplConverter.getInternalResponse(response);
        
        boolean isIncluded = (internalRequest.isIncluded()
        		|| internalResponse.isIncluded());
        try {
        	internalRequest.setIncluded(true);
        	internalRequest.setIncludedQueryString(queryString);
        	internalResponse.setIncluded(true);

            requestDispatcher.include(
            		(HttpServletRequest) internalRequest,
            		(HttpServletResponse) internalResponse);
        } catch (IOException ex) {
            throw ex;
        } catch (ServletException ex) {
            if (ex.getRootCause() != null) {
                throw new PortletException(ex.getRootCause());
            } else {
                throw new PortletException(ex);
            }
        } finally {
        	internalRequest.setIncluded(isIncluded);
        	internalResponse.setIncluded(isIncluded);
        }
    }
    
    public void include(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void include(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void include(EventRequest request, EventResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void forward(ResourceRequest request, ResourceResponse response) throws PortletException, IOException, IllegalStateException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void forward(FragmentRequest request, FragmentResponse response) throws PortletException, IOException, IllegalStateException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void include(FragmentRequest request, FragmentResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}
}
