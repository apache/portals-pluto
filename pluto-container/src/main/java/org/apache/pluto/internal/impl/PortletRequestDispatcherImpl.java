/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.internal.InternalPortletRequest;
import org.apache.pluto.internal.InternalPortletResponse;

/**
 * Implementation of the <code>PortletRequestDispatcher</code> interface.
 * The portlet request dispatcher is used to dispatch <b>RenderRequest</b> and
 * <b>RenderResponse</b> to a URI. Note that ActionRequest and ActionResponse
 * can never be dispatched.
 * 
 */
public class PortletRequestDispatcherImpl implements PortletRequestDispatcher {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletRequestDispatcherImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    /** The nested servlet request dispatcher instance. */
    private RequestDispatcher requestDispatcher;
    
    /** The included/forwarded query string. */
    private String queryString;
    private String servlet_path;
    private String path_info;
    private boolean namedDispatcher = true;
    
    
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
                                        String path) {
    	this(requestDispatcher);
    	namedDispatcher = false;
    	
    	//Extract servlet_path
        int index1 = path.indexOf("/", 1);
        if (index1 > 0 && index1 < path.length() - 1) {
        	servlet_path = path.substring(0, index1);
        }
    	
    	//Extract query string which contains appended parameters.
    	queryString = null;
        int index2 = path.indexOf("?");
        if (index2 > 0 && index2 < path.length() - 1) {
        	queryString = path.substring(index2 + 1);
        }
        
        //Extract path_info        
        if (index1 > 0 && index1 < index2 && index2 > 0 && index2 < path.length() - 1) {
        	path_info = path.substring(index1, index2);
        }
        
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Request dispatcher created.");
        }
    }
    
    
    // PortletRequestDispatcher Impl -------------------------------------------
   
	public void include(PortletRequest request, PortletResponse response) throws PortletException, IOException {
		InternalPortletRequest internalRequest = InternalImplConverter.getInternalRequest(request);
		InternalPortletResponse internalResponse = InternalImplConverter.getInternalResponse(response);
		internalInclude(internalRequest,internalResponse);
	}


	
	public void include(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {
		InternalPortletRequest internalRequest = InternalImplConverter.getInternalRequest(request);
		InternalPortletResponse internalResponse = InternalImplConverter.getInternalResponse(response);
		internalInclude(internalRequest,internalResponse);
    }
	
	public void forward(PortletRequest request, PortletResponse response) throws PortletException, IOException, IllegalStateException {
		InternalPortletRequest internalRequest = InternalImplConverter.getInternalRequest(request);
		InternalPortletResponse internalResponse = InternalImplConverter.getInternalResponse(response);
		if (!internalResponse.isForwardedAllowed()){
			throw new IllegalStateException("Response has been committed, this isn't allowed before forward" +
				" method. Content must delete before service from servlet is called.");
		}
		boolean isForwarded = (internalRequest.isForwarded()||internalResponse.isForwarded());
        try {
        	internalRequest.setForwarded(true);
        	internalRequest.setForwardedQueryString(queryString);
        	if (!namedDispatcher){
        		setAttributesForward(internalRequest);
        		internalRequest.setNamedRequestDispatcher(false);
        	}
        	else{
        		internalRequest.setNamedRequestDispatcher(true);
        	}
        	internalResponse.setForwarded(true);

            requestDispatcher.forward((HttpServletRequest) internalRequest,
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
        	internalRequest.setForwarded(isForwarded);
        	internalResponse.setForwarded(isForwarded);
        	internalResponse.setRequestForwarded();
        }
	}
	
	private void internalInclude(InternalPortletRequest internalRequest, InternalPortletResponse internalResponse)
    throws PortletException, IOException {
    	boolean isIncluded = (internalRequest.isIncluded()
        		|| internalResponse.isIncluded());
        try {
        	internalRequest.setIncluded(true);
        	internalRequest.setIncludedQueryString(queryString);
        	if (!namedDispatcher){
        		setAttributesInclude(internalRequest);
        	}
        	else{
        		
                internalRequest.setNamedRequestDispatcher(true);
        	}
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
	private void setAttributesForward(InternalPortletRequest internalRequest){
		String context_path = internalRequest.getContextPath();
		String request_uri = context_path + servlet_path + path_info;
		internalRequest.setAttribute("javax.servlet.forward.request_uri", request_uri);
		internalRequest.setAttribute("javax.servlet.forward.context_path", context_path);
		internalRequest.setAttribute("javax.servlet.forward.servlet_path", servlet_path);
		internalRequest.setAttribute("javax.servlet.forward.path_info", path_info);
		internalRequest.setAttribute("javax.servlet.forward.query_string", queryString);
	}
	
	private void setAttributesInclude(InternalPortletRequest internalRequest){
		String context_path = internalRequest.getContextPath();
		String request_uri = context_path + servlet_path + path_info;
		internalRequest.setAttribute("javax.servlet.include.request_uri", request_uri);
		internalRequest.setAttribute("javax.servlet.include.context_path", context_path);
		internalRequest.setAttribute("javax.servlet.include.servlet_path", servlet_path);
		internalRequest.setAttribute("javax.servlet.include.path_info", path_info);
		internalRequest.setAttribute("javax.servlet.include.query_string", queryString);
	}
}
