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

package org.apache.pluto.services.property;

import org.apache.pluto.services.ContainerService;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pluto.om.window.PortletWindow;

/**
 * The <code>PropertyManagerService</code> interface is a container service
 * providing the portlet container with external defined properties.
 * This interface allows to associate properties with the portlet request
 * and portlet response.
 * <br> 
 * This service represents an abstract layer to make the property 
 * management independent of the portlet container and to allow
 * diverse special implementations. 
 * 
 * <p>This SPI interface can be implemented by the portal.</p>
 **/
public interface PropertyManagerService extends ContainerService 
{

    /**
     * Sets the given property map defined by the portlet window in its response.  
     * <br>
     * The purpose of this method is to provide the portal framework
     * with a new map of properties set by the portlet. The map can be empty, but not NULL
     * <br>
     * This method can be called multiple times during one request by the portlet container
     * 
     * @param window the portlet window of this property
     * @param request the servlet request
     * @param response the servlet response
     * @param properties the String/String array map containing the
     *                  properties to be set.
     **/
    public void setResponseProperties(PortletWindow window,
                                      HttpServletRequest request,
                                      HttpServletResponse response,
                                      Map properties);

    /**
     * Returns all properties for the given portlet window 
     * defined in the portal as String/String array map.
     * They will be made available to the portlet through the
     * portlet request.
     * <br>
     * The purpose of this method is to allow the portal framework
     * to create a map of properties and make it available to the portlet container.
     * <br>
     * This method can be called multiple times during one request by the portlet container
     * <br>
     * The return value cannot be null.
     *
     * @param window the portlet window of this property
     * @param request the servlet request
     * @param response the servlet response
     * 
     * @return		a <code>Map</code> containing
     *                  all properties. If there are no properties of
     *                  that name returns an empty <code>Map</code>.    
     **/          
    public Map getRequestProperties(PortletWindow window,
                                    HttpServletRequest request);

}
