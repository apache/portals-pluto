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
 * <div class="changed_added_3_0">
 * The portlet programming interface provides a mechanism to assist portlets when 
 * the aggregated portal markup is an HTML or similar document that requires markup
 * for the document <code>HEAD</code> section to be written and HTTP headers to be 
 * set before the render markup for each individual portlet is aggregated.
 * This mechanism is represented in the portlet API by the {@link HeaderPortlet}, 
 * {@link HeaderRequest}, and {@link HeaderResponse} interfaces.
 * <p>  
 * The <CODE>HeaderResponse</CODE> defines an object to assist a portlet in
 * sending a response to the portal. It extends the
 * <CODE>MimeResponse</CODE> interface to provide specific header
 * response functionality to portlets.
 * <p>
 * The portlet container creates
 * a <CODE>HeaderResponse</CODE> object and passes it as argument to the
 * portlet's <CODE>renderHeaders</CODE> method in order to allow the portlet
 * to add response headers and generate markup for the overall portal 
 * response document <code>HEAD</code> section.
 * </div>
 * 
 * @see RenderResponse
 * @see HeaderRequest
 * @see HeaderPortlet
 * @see PortletResponse
 * @see MimeResponse
 * 
 * @since 3.0
 */
public interface HeaderResponse extends MimeResponse {

    /**
     * <div class="changed_added_3_0">
     * This method sets the title of the portlet.
     * <p>
     * The value can be a text String
     * </div>
     * 
     * @param title
     *            portlet title as text String or resource URI
     */
    public void setTitle(String title);

    /**
     * <div class="changed_added_3_0">
     * Sets the MIME type for the header response. The portlet should set the
     * content type before calling {@link #getWriter} or
     * {@link #getPortletOutputStream}.
     * <p>
     * Calling <code>setContentType</code> after <code>getWriter</code> or
     * <code>getOutputStream</code> does not change the content type.
     * <p>
     * The portlet container will ignore any character encoding
     * specified as part of the content type for <code>render</code>
     * calls.
     * </div>
     * 
     * @param type
     *            the content MIME type
     * 
     * @throws java.lang.IllegalArgumentException
     *             if the given type is not in the list 
     *             returned by <code>PortletRequest.getResponseContentTypes</code>
     * 
     * @see PortletRequest#getResponseContentTypes
     * @see #getContentType
     */
    public void setContentType(String type);

    /**
     * <div class="changed_added_3_0">
     * Data written to the <code>HeaderResponse</code> writer is added
     * to the aggregated portal document <code>HEAD</code> section.
     * <p>
     * {@inheritDoc}
     * </div>
     */
    public java.io.PrintWriter getWriter() throws java.io.IOException;

    /**
     * <div class="changed_added_3_0">
     * Data written to the <code>HeaderResponse</code> output stream is added
     * to the aggregated portal document <code>HEAD</code> section.
     * <p>
     * {@inheritDoc}
     * </div>
     */
    public java.io.OutputStream getPortletOutputStream() throws java.io.IOException;
    
    /**
     * <div class="changed_added_3_0">
     * Adds a dependency on a page-level resource that is managed by the portal.
     * <p>
     * When a portlet is aggregated onto a page, it may designate resources such as 
     * JavaScript files or style sheets
     * that it needs to have on the page in order to operate correctly.
     * These resources typically should be added to the aggregated document <code>head</code>
     * section. 
     * Such resources are known as portlet dependencies.
     * <p>
     * The portal implementation is responsible for adding the portlet dependencies to
     * the page during aggregation.
     * The resources declared as dependencies are typically such that they should be added 
     * to the page only a single time, but may be used by multiple portlets.
     * <p>
     * Portlet dependencies may be configured statically either through annotations or 
     * through the portlet deployment descriptor.
     * The resources to satisfy such dependencies will be made available on all pages on which
     * the portlet is rendered.
     * <p>
     * The dependency added dynamically through this method is added to the
     * statically declared dependencies for the portlet for the current rendering cycle 
     * only.
     * <p>
     * This method should only be used to add portlet dependencies that can potentially be 
     * required by or shared with other portlets as well.
     * Strictly private dependencies, such as JavaScript code needed by this portlet only,
     * should be added to to document head section using the  
     * <code>PortletResponse#addProperty(String, Element)</code> method or by using either the
     * <code>PrintWriter</code> or <code>OutputStream</code> object obtained 
     * through the <code>HeaderResponse</code>.
     * <p>
     * The manner in which the portal maps the specified name, scope, and version to 
     * specific resources is left to the portal implementation.
     * </div>
     * 
     * @param name      the resource name
     * @param scope     the resource scope, may be <code>null</code> or empty
     * @param version   the resource version, may be <code>null</code> or empty
     * 
     * @see PortletResponse#addProperty(String, org.w3c.dom.Element)
     * @see #getWriter()
     * @see #getPortletOutputStream()
     * 
     * @throws          java.lang.IllegalArgumentException 
     *                    if name is <code>null</code> or empty
     */
    public void addDependency(String name, String scope, String version);
    
    /**
     * <div class="changed_added_3_0">
     * Adds a dependency on a page-level resource that is managed by the portal
     * and adds a resource for addition to the page for the dependency.
     * <p>
     * See {@link #addDependency(String, String, String)} for a discussion of
     * dependencies.
     * <p>
     * The specified markup element representing the resource must be suitable for inclusion
     * in the aggregated portal document <code>HEAD</code> section.
     * It will generally be either a <code>LINK</code> or <code>SCRIPT</code> tag.
     * <p>
     * This method does not directly place markup into the aggregated page document. 
     * The aggregating portal will use the identifying information name, scope, and version
     * along with identifying information for other available page resources to determine
     * which resources will be added to the page.
     * <p>
     * For example, if a portlet provides a resource with a version of 2.0.0 but another 
     * portlet on the same page provides a resource with the same name and scope but 
     * a version of 2.1.0, the aggregating portal may choose to include the later
     * version of the resource on the page. 
     * </div>
     * 
     * @param name      the resource name
     * @param scope     the resource scope, may be <code>null</code> or empty
     * @param version   the resource version, may be <code>null</code> or empty
     * @param markup    the markup for adding the resource to the page
     * 
     * @throws          java.lang.IllegalArgumentException 
     *                    if name is <code>null</code> or empty
     *                    or if markup does not contain valid tags for the document <code>HEAD</code> section
     * 
     */
    public void addDependency(String name, String scope, String version, String markup);

    
}
