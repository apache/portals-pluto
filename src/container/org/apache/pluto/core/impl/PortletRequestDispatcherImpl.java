/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
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
