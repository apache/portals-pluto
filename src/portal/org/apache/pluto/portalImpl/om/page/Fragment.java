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

package org.apache.pluto.portalImpl.om.page;

import java.util.*;

/**
 * <P>
 * The <CODE>Fragment</CODE> interface represents a single fragment on a site,
 * such as a page, a row, or even a portlet fragment
 * </P>
 * <P>
 * The interfaces defined in this package represent an abstract object
 * model (OM) that is applicable for different implementations.
 * The abstract OM defines only how the data is stored and accessed
 * in the memory. Each implementation can store the data in different ways.
 * </P>
 * <P>
 * This abstraction layer helps to generalize the portlet container from
 * special implementations like data storage and moreover it is not bound
 * to a special Application Server.
 * </P>
 * 

 */
public interface Fragment
{


    /**
     * Returns the administrative name of this fragment
     * 
     * @return the administrative name
     */
    public String getName();

    /**
     * binds an administrative name to this fragment
     * 
     * @param name the administrative name
     */
    public void setName(String name);

    /**
     * Returns the type of the class bound to this fragment
     * 
     * @return the type
     */
    public String getType();

    /**
     * binds a type to this fragment
     * 
     * @param type the type
     */
    public void setType(String type);

    /**
     * Returns the classname of the class bound to this fragment
     * 
     * @return the classname
     */
    public String getClassname();

    /**
     * binds a classname to this fragment
     * 
     * @param classname the classname
     */
    public void setClassname(String classname);

    /**
     * Returns the navigational information linked with this fragment.
     * The return value may be NULL, if no navigational information is defined.
     * 
     * @return the navigational information
     */
    public Navigation getNavigation();

    /**
     * binds navigational information to this fragment
     * 
     * @param navigation the navigational information
     */
    public void setNavigation(Navigation navigation);

    /**
     * Returns all fragments used in this node. This may be
     * a page fragment or even directly a portlet fragment
     * 
     * @return a collection containing Fragment objects
     */
    public Collection getFragments();

    /**
     * Returns all properties describing this fragment. Only the
     * implementation of the "classname" knows how to handle the
     * properties
     * 
     * @return a collection containing Property objects
     */
    public Collection getProperties();

}
