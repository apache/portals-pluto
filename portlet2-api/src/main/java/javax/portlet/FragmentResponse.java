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
 * The <CODE>FragmentResponse</CODE> defines an object to assist a portlet 
 * for serving a fragment.
 * <p>
 * It combines action and render semantics and allows the portlet to change
 * state and return the fragment markup. It extends the <code>StateAwareResponse</code>
 * and <CODE>RenderResponse</CODE> interfaces.
 * <p>
 * A portlet can set HTTP headers for the response via the setProperty or 
 * addProperty call in the <CODE>FragmenteResponse</CODE>. 
 * To be successfully transmitted back to the client, headers must be set 
 * before the response is committed. Headers set after the response is 
 * committed will be ignored by the portlet container.
 * <p>
 * The portlet container creates a <CODE>FragmentResponse</CODE> object and 
 * passes it as argument to the portlet's <CODE>serveFragment</CODE> method.
 * 
 * @see RenderResponse
 * @see StateAwareResponse
 * @see FragmentServingPortlet
 * @since 2.0
 */
public interface FragmentResponse extends StateAwareResponse, RenderResponse {

    /**
     * Sets the locale of the response, setting the headers 
     * (including the Content-Type's charset) as appropriate. 
     * This method should be called before a call to getWriter(). 
     * By default, the response locale is the default locale provided
     * by the portlet container.
     * 
     * @param loc  the new locale of the response
     */
    public void setLocale(java.util.Locale loc);
    
  /**
   * Instructs the portlet container to send a redirect response 
   * to the client using the specified redirect location URL.  
   * <p>
   * This method only accepts an absolute URL (e.g. 
   * <code>http://my.co/myportal/mywebap/myfolder/myresource.gif</code>)
   * or a full path URI (e.g. <code>/myportal/mywebap/myfolder/myresource.gif</code>).
   * If required, 
   * the portlet container may encode the given URL before the 
   * redirection is issued to the client.
   * <p>
   * It is valid to provide a portlet URL as parameter on the redirect URL. The portlet 
   * container will translate the portlet URL to a valid URL that can be used for
   * invoking the portlet again.  
   * <p>
   * The sendRedirect method can not be invoked after any of the 
   * following methods of the ActionResponse interface has been called:
   * <ul>
   * <li>setPortletMode
   * <li>setWindowState
   * <li>setRenderParameter
   * <li>setRenderParameters
   * </ul>
   *
   * @param     location    the redirect location URL
   *
   * @exception java.io.IOException 
   *                    if an input or output exception occurs.
   * @exception java.lang.IllegalArgumentException  
   *                    if a relative path URL is given
   * @exception java.lang.IllegalStateException
   *                    if the method is invoked after any of above mentioned methods of 
   *                    the ActionResponse interface has been called.
   */

  public void sendRedirect(String location)
    throws java.io.IOException;
  
  
  /**
   * Maintain the current render parameters of the request for
   * the response.
   * <p>
   * All previously set render parameters are cleared.
   * <p>
   * These parameters will be accessible in all
   * sub-sequent render calls via the
   * <code>PortletRequest.getParameter</code> call until
   * a new request is targeted to the portlet.
   * <p>
   * The given parameters do not need to be encoded
   * prior to calling this method.
   *
   * @param  request   The request the portlet has been provided
   *                   with by the portlet container for the current
   *                   <code>serveFragment</code> call.
   */
  public void setRenderParameters(FragmentRequest request);
  
  
  /**
   * Sets the character encoding (MIME charset) of the response being 
   * sent to the client, for example, to UTF-8. If the character encoding 
   * has already been set by either the portlet container,
   * <code>setContentType(java.lang.String)</code> or 
   * <code>setLocale(java.util.Locale)</code>, this method overrides it. Calling 
   * <code>setContentType(java.lang.String)</code> with the String  of 
   * <code>text/html</code> and calling this method with the String of 
   * <code>UTF-8</code> is equivalent with calling <code>setContentType</code> 
   * with the String of <code>text/html; charset=UTF-8</code>.
   * <p>
   * This method can be called repeatedly to change the character encoding. 
   * This method has no effect if it is called after getWriter has been called 
   * or after the response has been committed.
   * 
   * @param charset a String specifying only the character set defined by 
   *                IANA Character Sets (http://www.iana.org/assignments/character-sets)
   */
  public void setCharacterEncoding(java.lang.String charset);
  
  

}
