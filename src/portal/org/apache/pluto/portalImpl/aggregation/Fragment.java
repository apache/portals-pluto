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

package org.apache.pluto.portalImpl.aggregation;

import org.apache.pluto.portalImpl.aggregation.navigation.Navigation;
import org.apache.pluto.portalImpl.util.*;
import org.apache.pluto.portalImpl.core.*;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public interface Fragment
{


    /**
     * Is called to render the fragment. This may be a page, column or 
     * even a portlet.
     * 
     * @param request  the servlet request
     * @param response the servlet response
     * @exception ServletException
     * @exception IOException
     */
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException;

    /**
     * Returns the identifier of this fragment. Mostly this is a name visible
     * in the Portal URL.
     * 
     * @return the identifier of this fragment
     */
    public String getId();

    /**
     * Returns the parent fragment. If this fragment is the root fragment
     * the return value is NULL
     * 
     * @return the parent fragment or NULL if this is the root fragment
     */
    public Fragment getParent();

    /**
     * Returns the initialization parameters of this fragment
     * 
     * @return the init parameters
     */
    public Parameters getInitParameters();

    /**
     * Returns a collection of all child fragments
     * 
     * @return a collection containing objects implementing the interface fragment
     */
    public Collection getChildFragments();

    /**
     * Adds an child to the fragment
     * 
     * @param child  the child fragment
     */
    public void addChild(Fragment child);

    /**
     * Returns the navigational information linked with this fragment.
     * The return value may be NULL, if no navigational information is defined.
     * 
     * @return the navigational information
     */
    public Navigation getNavigation();

    /**
     * Creates an URL pointing to this fragment
     * 
     * @param url the PortalURL object used 
     */
    public void createURL(PortalURL url);

    /**
     * Returns true if the fragment is part of the URL
     * 
     * @param url    the PortalURL object used
     * @return true if the fragment is part of the URL
     */
    public boolean isPartOfURL(PortalURL url);

}
