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

package org.apache.pluto.portalImpl.xml;

/**
 ** This class defines a bunch of constants, especially those needed to
 ** identify attributes for xml-creation and validation.
 **
 **/

public class Constants
{

    // attributes for the entity resolver and xml validation
    public final static String RES_PORTLET_PUBLIC_ID     = "-//Sun Microsystems, Inc.//DTD PortletApplication 1.0//EN";
    public final static String[] RES_PORTLET_DTDS        = {"/org/apache/pluto/portalImpl/xml/portlet-app_1_0.xsd", 
                                                            "/org/apache/pluto/portalImpl/xml/xml.xsd",
                                                            "/org/apache/pluto/portalImpl/xml/XMLSchema.dtd",
                                                            "/org/apache/pluto/portalImpl/xml/datatypes.dtd"};
    public final static String[] RES_PORTLET_DTD_NAMES   = {"portlet-app_1_0.xsd", "xml.xsd", "XMLSchema.dtd", "datatypes.dtd"};

    public final static String RES_WEB_PUBLIC_ID     = "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN";
    public final static String RES_WEB_DTD           = "/org/apache/pluto/portalImpl/xml/web-app_2_3.dtd";
    public final static String RES_WEB_DTD_NAME      = "web-app_2_3.dtd";

    //attributes for the web.xml creation for portlets
    public final static String WEB_PORTLET_PUBLIC_ID = "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN";
    public final static String WEB_PORTLET_DTD = "http://java.sun.com/dtd/web-app_2_3.dtd";

}
