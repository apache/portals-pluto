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
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;


/**
 * The <CODE>RenderRequest</CODE> represents the request sent to the portlet
 * to handle a render.
 * It extends the PortletRequest interface to provide render request
 * information to portlets.<br>
 * The portlet container creates a <CODE>RenderRequest</CODE> object and
 * passes it as argument to the portlet's <CODE>render</CODE> method.
 * 
 * @see PortletRequest
 * @see ActionRequest
 */
public interface RenderRequest extends PortletRequest
{

    /**
     * This property is set by the container if the portlet container
     * has a cached response for the given validation tag. The property can be
     * retrieved using the <code>getProperty</code> method. 
     * <P>
     * The value is <code>"portlet.ETag "</code>.
     * 
     * @since 2.0
     */
    public static final String ETAG = "portlet.ETag";

    
    /**
     * Returns the validation tag if the portlet container
     * has a cached response for this validation tag, or
     * <code>null</code> if no cached response exists.
     * <p>
     * This call returns the same value as 
     * <code>RenderRequest.getProperty(RenderRequest.ETAG)</code>.
     * 
     * @return  the validation tag if the portlet container
     *          has a cached response for this validation tag, or
     *          <code>null</code> if no cached response exists.
     *          
     * @since 2.0
     */
    public String getETag();
    


}
