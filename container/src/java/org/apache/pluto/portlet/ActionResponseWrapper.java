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

package org.apache.pluto.portlet;

import java.util.Map;

import javax.portlet.*;

public class ActionResponseWrapper extends PortletResponseWrapper 
implements ActionResponse 
{

    /**
    * Creates a ServletResponse adaptor wrapping the given response object.
    * @throws java.lang.IllegalArgumentException if the response is null.
    */
    public ActionResponseWrapper(ActionResponse actionResponse)
    {
        super(actionResponse);

        if (actionResponse == null) 
        {
            throw new IllegalArgumentException("Response cannot be null");
        }
    }

    // javax.portlet.ActionResponse implementation ------------------------------------------------
    public void setWindowState(WindowState windowState) throws WindowStateException
    {
        this.getActionResponse().setWindowState(windowState);
    }

    public void setPortletMode(PortletMode portletMode) throws PortletModeException
    {
        this.getActionResponse().setPortletMode(portletMode); 
    }

    public void sendRedirect(String location) throws java.io.IOException
    { 
        this.getActionResponse().sendRedirect(location);
    }

    public void setRenderParameters(Map parameters)
    {
        this.getActionResponse().setRenderParameters(parameters);
    }

    public void setRenderParameter(String key, String value)
    {
        this.getActionResponse().setRenderParameter(key, value);
    }

    public void setRenderParameter(String key, String[] values)
    {
        this.getActionResponse().setRenderParameter(key, values);
    }

    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    /**
     * Return the wrapped ServletResponse object.
     */
    public ActionResponse getActionResponse()
    {
        return (ActionResponse) getPortletResponse();
    }

    // --------------------------------------------------------------------------------------------
}

