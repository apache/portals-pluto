/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
/*
 * NOTE: this source code is based on an early draft version of JSR 286 and not intended for product
 * implementations. This file may change or vanish in the final version of the JSR 286 specification.
 */
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/*
 * Copyright 2006 IBM Corporation.
 *
 */
package javax.portlet;

/**
 * Lifecyle interface in order to allow the portlet
 * serving fragments of itself in an asychronous manner in
 * coordination with the portal application.
 * <p>
 * Calls to the <code>serveFragment</code> method are triggered
 * preferably by Fragment URLs or by any other Portlet URL passed
 * to a specific portal application provided ECMA script method.
 *
 * @since 2.0
 */
public interface FragmentServingPortlet {

    /**
     * @param request  the fragment request
     * @param response  the fragment response
     * @exception   PortletException
     *              if the portlet has problems fulfilling the
     *              fragment request
     * @exception  UnavailableException     
     *                   if the portlet is unavailable to perform the fragment 
     *                   serving at this time
     * @exception  PortletSecurityException  
     *                   if the portlet cannot fullfill this request because of security reasons
     * @exception  java.io.IOException
     *              if the streaming causes an I/O problem
     */
    public void serveFragment(FragmentRequest request, FragmentResponse response)
        throws PortletException, java.io.IOException;
}
