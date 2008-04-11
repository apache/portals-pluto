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
package org.apache.pluto.internal;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletContainer;

/**
 * The internal portlet request interface extends PortletRequest and adds
 * some methods used by Pluto.
 *
 */
public interface InternalPortletRequest extends PortletRequest {

    /**
     * Initializes the portlet request for use within the target context.
     * This method ensures that the portlet utilizes resources from the
     * <b>included</b> context, and not those from the intiating (portal)
     * context.
     *
     * @param context  the target portlet context.
     * @param request  the servlet request.
     */
    public void init(PortletContext context, HttpServletRequest request);

    /**
     * Recycle the request by rolling the underlying request
     * back to the originating request.
     */
    public void release();

    public InternalPortletWindow getInternalPortletWindow();

    public PortletContainer getPortletContainer();

    public HttpServletRequest getHttpServletRequest();
    
    /**
     * Is set true when a jsp, servlet is included.
     * @param included true when included
     */
    public void setIncluded(boolean included);
    
    /**
     * Returns true if a jsp or servlet is included.
     * @return true if a jsp or servlet is included.
     */
    public boolean isIncluded();
    
    public void setIncludedQueryString(String queryString);

    public void setForwarded(boolean forwarded);
    
    public boolean isForwarded();

    public void setForwardedQueryString(String queryString);
    
    public void setAttribute(String name, Object object);
    
    public String getLifecyclePhase();
    
    public void setNamedRequestDispatcher(boolean named);
}


