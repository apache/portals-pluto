/**
  * Copyright 2006 IBM Corporation.
  */

package javax.portlet;


/**
 * The <CODE>ActionResponse</CODE> interface represents the portlet
 * response to an action request.
 * It extends the <CODE>StateAwareResponse</CODE> interface to provide specific 
 * action response functionality to portlets.<br>
 * The portlet container creates an <CODE>ActionResponse</CODE> object and 
 * passes it as argument to the portlet's <CODE>processAction</CODE> method.
 * 
 * @see StateAwareResponse 
 * @see PortletResponse
 * @see ActionRequest
 */
public interface ActionResponse extends StateAwareResponse
{

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
   * The sendRedirect method can not be invoked after any of the 
   * following methods of the ActionResponse interface has been called:
   * <ul>
   * <li>setPortletMode</li>
   * <li>setWindowState</li>
   * <li>setRenderParameter</li>
   * <li>setRenderParameters</li>
   * <li>removePublicRenderParamter</li>
   * </ul>
   *
   * @param		location	the redirect location URL
   *
   * @exception	java.io.IOException	
   *                    if an input or output exception occurs.
   * @exception	java.lang.IllegalArgumentException	
   *                    if a relative path URL is given
   * @exception java.lang.IllegalStateException
   *                    if the method is invoked after any of above mentioned methods of 
   *                    the ActionResponse interface has been called.
   */

  public void sendRedirect(String location)
    throws java.io.IOException; 

  /**
   * Instructs the portlet container to send a redirect response 
   * to the client using the specified redirect location URL and
   * encode a render URL as parameter on the redirect URL.  
   * <p>
   * This method only accepts an absolute URL (e.g. 
   * <code>http://my.co/myportal/mywebap/myfolder/myresource.gif</code>)
   * or a full path URI (e.g. <code>/myportal/mywebap/myfolder/myresource.gif</code>).
   * If required, 
   * the portlet container may encode the given URL before the 
   * redirection is issued to the client.
   * <p>
   * The portlet container will attach a render URL with the currently set portlet mode, window state
   * and render parameters on the <code>ActionResponse</code> and the current public render parameters. 
   * The attached URL will be available as query parameter value under the key provided with the 
   * <code>renderUrlParamName</code> parameter.
   * <p>
   * New values for
   * <ul>
   * <li>setPortletMode
   * <li>setWindowState
   * <li>setRenderParameter
   * <li>setRenderParameters
   * </ul>
   * are only used for creating the render URL and not remembered after the redirect
   * is issued. 
   *
   * @param		location	the redirect location URL
   * @param     renderUrlParamName	name of the query parameter under which the portlet container should
   *                                store a render URL to this portlet
   *                                
   * @exception	java.io.IOException	
   *                    if an input or output exception occurs.
   * @exception	java.lang.IllegalArgumentException	
   *                    if a relative path URL is given
   *                    
   * @since 2.0
   */

  public void sendRedirect(String location, String renderUrlParamName)
    throws java.io.IOException; 
}




