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

package org.apache.pluto.om.portlet;

import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.DisplayNameSet;

/**
 * <P>
 * The <CODE>PortletDefinitionCtrl</CODE> interface ...
 * </P>
 * <P>
 * This interface defines the controller as known from the MVC pattern.
 * Its purpose is to provide write access to the data stored in the model.
 * </P>
 * 

 */
public interface PortletDefinitionCtrl extends org.apache.pluto.om.Controller
{


    /**
     * Binds an identifier to this portlet
     * 
     * @param id the new identifier
     */
    public void setId(String id);

    /**
     * Sets the new class name
     * 
     * @param className the new class name
     */
    public void setClassName(String className);

    /**
     * Binds an administrative name
     * 
     * @param name the new administrative name
     */
    public void setName(String name);

    /**
     * Sets the descriptions
     * 
     * @param name the new description
     */
    public void setDescriptions(DescriptionSet descriptions);

    /**
     * Sets the display names
     * 
     * @param name the new display names
     */
    public void setDisplayNames(DisplayNameSet displayNames);


    /**
     * Sets the class loader of the portlet
     * 
     * @param ClassLoader
     */
    public void setPortletClassLoader(ClassLoader loader);

    /**
     * Stores the object persistently
     * 
     * @exception java.io.IOException
     *                   in case of trouble fulfilling the request
     */
    public void store() throws java.io.IOException;


}
