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

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.pluto.core.InternalPortletRequest;

public class PortletRequestDispatcherImpl implements PortletRequestDispatcher
{

    private javax.servlet.RequestDispatcher requestDispatcher;

    public PortletRequestDispatcherImpl(javax.servlet.RequestDispatcher requestDispatcher)
    {
        this.requestDispatcher = requestDispatcher;
    }

    // javax.portlet.PortletRequestDispatcher implementation --------------------------------------
    public void include(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException
    {
        InternalPortletRequest internalRequest = (InternalPortletRequest)request;
        try
        {
            internalRequest.setIncluded(true);
            this.requestDispatcher.include((javax.servlet.http.HttpServletRequest)request, 
                                           (javax.servlet.http.HttpServletResponse)response);

        }
        catch (java.io.IOException e)
        {
            throw e;
        }
        catch (javax.servlet.ServletException e)
        {
            if (e.getRootCause()!=null)
            {
                throw new PortletException(e.getRootCause());
            }
            else
            {
                throw new PortletException(e);
            }
        }
        finally
        {
            internalRequest.setIncluded(false);
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
