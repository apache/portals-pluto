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


package javax.portlet.annotations;

import javax.portlet.ActionURL;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.RenderURL;
import javax.portlet.ResourceURL;

/**
 * <div class='changed_added_3_0'>
 * Interface that allows URLs to be generated. 
 * The functionality is based on methods from <code>MimeResponse</code>.
 * <p>
 * A URLFactory object can only be obtained through injection.
 * <p>
 * Example:
 * <div class='codebox'>      
 * {@literal @}Inject<br/>   
 * private URLFactory urlFactory;
 * </div>                    
 * </div>
 * 
 * @see javax.portlet.MimeResponse MimeResponse
 */
public interface URLFactory {

   /**
    * Creates an action URL targeting the portlet.
    * Action URLs are used to create forms or links that, when triggered,
    * update the render state in a non-idempotent manner.
    * <p> 
    * If a request is triggered by the URL, it results in
    * an action request.
    * <p>
    * The <code>copyParameters</code> argument specifies whether render parameters
    * from the current request are to be copied to the URL.
    * <p>
    * The returned URL can be further extended by adding portlet-specific action
    * parameters, portlet mode, and window state.
    * If no additional portlet mode, window
    * state or security modifier is set on the URL, the values from the
    * current render or resource request are preserved.
    * <p>
    * Public render parameters do not need to be explicitly added to the returned 
    * action URL, unless the public render parameter value is to be changed. 
    * Any public render parameters associated with 
    * the portlet will automatically be available during action request 
    * processing resulting from activation of the URL. 
    * <p>
    * If a public render parameter value is set or removed on an action URL, 
    * then the public render parameter will be set to the new value or 
    * removed when the URL is activated.
    * 
    * @see javax.portlet.MimeResponse#createActionURL() createActionURL
    * @see javax.portlet.MimeResponse.Copy
    * 
    * @param   copyParameters    Specifies if parameters are to be copied to the URL
    * 
    * @return a portlet action URL, or <code>null</code> if the current request
    * is neither a <code>RenderRequest</code> nor a <code>ResourceRequest</code>
    */
   public ActionURL createActionURL(Copy copyParameters);

   
   /**
    * Creates a render URL targeting the portlet. 
    * Render URLs cause idempotent requests that move the portlet to a 
    * new view state, for example, to view a different page of data. 
    * <p> 
    * If a request is triggered by the URL, it results in
    * a render request.
    * <p>
    * The <code>copyParameters</code> argument specifies whether render parameters
    * from the current request are to be copied to the URL.
    * <p>
    * The returned URL can be further extended by adding portlet-specific render
    * parameters, portlet mode, and window state.
    * If no portlet mode, window
    * state or security modifier is set on the URL, the values from the
    * current render or resource request are preserved.
    * <p>
    * Public render parameters do not need to be explicitly added to the returned 
    * render URL, unless the public render parameter value is to be changed. 
    * Any public render parameters associated with 
    * the portlet will automatically be available during render request processing resulting
    * from activation of the URL.
    * <p>
    * If a public render parameter value is set or removed on a render URL, then the public 
    * render parameter will be set to the new value or removed when the URL is activated.
    * 
    * @see javax.portlet.MimeResponse#createRenderURL() createRenderURL
    * @see javax.portlet.MimeResponse.Copy
    * 
    * @param   copyParameters    Specifies if parameters are to be copied to the URL
    * 
    * @return a portlet render URL, or <code>null</code> if the current request
     * is neither a <code>RenderRequest</code> nor a <code>ResourceRequest</code>
    */
   public RenderURL createRenderURL(Copy copyParameters);
   
   
   /**
     * Creates a resource URL targeting the portlet. 
     * Resource URLs are used to trigger requests for content that applies
     * to the current portlet view state.
     * <p>
     * If a request is triggered by the <code>ResourceURL</code>, it results in a serve
     * resource request of the <code>ResourceServingPortlet</code> interface.
     * <p>
     * The security settings can be changed for the URL. If the security settings are
     * not explicitly set, the values governing the current request 
     * are preserved. 
     * The current
     * render parameters, portlet mode, and window state are preserved 
     * depending on the cacheability setting for the returned resource URL.
     * <p>
     * If cacheability is set to <code>PORTLET</code> or <code>PAGE</code>, the values of the render
     * parameters, portlet mode, and window state are preserved. 
     * Otherwise, they will not be preserved.
     * <p>
     * If allowed by the cacheability setting, public and private render 
     * parameters are added to the URL with their current values.
     * The render parameter values cannot be changed on the URL. 
     * <p>
     * The URL can be further extended by adding portlet-specific resource
     * parameters. 
     * <p>
     * The URL will contain the current 
     * cacheability setting of the parent resource by default. 
     * If no parent resource is available, <code>PAGE</code> is the default.
     * 
     * @see javax.portlet.MimeResponse#createResourceURL() createResourceURL
     * 
     * @return a portlet resource URL, or <code>null</code> if the current request
     * is neither a <code>RenderRequest</code> nor a <code>ResourceRequest</code>
     */
   public ResourceURL createResourceURL();

   /**
     * Returns the encoded URL of the resource, like servlets, JSPs, images and
     * other static files, at the given path.
     * <p>
     * Portlets should encode all resource URLs pointing to resources in the
     * portlet application via this method in order to ensure that they get
     * served via the portal application.
     * <p>
     * Some portal/portlet-container implementation may require those URLs to
     * contain implementation specific data encoded in it. Because of that,
     * portlets should use this method to create such URLs.
     * <p>
     * The <code>encodeURL</code> method may include the session ID and other
     * portal/portlet-container specific information into the URL. If encoding
     * is not needed, it returns the URL unchanged.
     * <p>
     * Portlet developer should be aware that the returned URL might not be a well formed
     * URL but a special token at the time the portlet is generating its content. 
     * Thus portlets should not add additional parameters on the resulting URL or 
     * expect to be able to parse the URL. As a result, the outcome of the encodeURL 
     * call may be different than calling encodeURL in the servlet world.
     * 
     * @param path
     *            the URI path to the resource. This must be either an absolute
     *            URL (e.g.
     *            <code>http://my.co/myportal/mywebap/myfolder/myresource.gif</code>)
     *            or a full path URI (e.g.
     *            <code>/myportal/mywebap/myfolder/myresource.gif</code>).
     * 
     * @exception java.lang.IllegalArgumentException
     *                if path doesn't have a leading slash or is not an absolute
     *                URL
     * 
     * @see javax.portlet.PortletResponse#encodeURL(String) encodeURL(String)
     * 
     * @return the encoded resource URL as string, may not be a valid URL
     */

   public String encodeURL(String path);

}
