/*
 * Copyright 2006 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/*
 * Copyright 2006 IBM Corporation.
 */
package javax.portlet;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;




/**
 * The <CODE>GenericPortlet</CODE> class provides a default implementation
 * for the <CODE>Portlet</CODE> interface.
 * <p>
 * It provides an abstract class to be subclassed to create portlets. A 
 * subclass of <CODE>GenericPortlet</CODE> should override at least
 * one method, usually one of the following:
 * <ul>
 * <li>processAction, to handle action requests</li>
 * <li>doView, to handle render requests when in VIEW mode</li>
 * <li>doEdit, to handle render requests when in EDIT mode</li>
 * <li>doHelp, to handle render request when in HELP mode</li>
 * <li>init and destroy, to manage resources that are held for the life of 
 * the servlet</li>
 * </ul>
 * <p>
 * Normally there is no need to override the render or the doDispatch 
 * methods. Render handles render requests setting the title of the 
 * portlet in the response and invoking doDispatch. doDispatch dispatches 
 * the request to one of the doView, doEdit or doHelp method depending on 
 * the portlet mode indicated in the request.
 * <p>
 * Portlets typically run on multithreaded servers, so please note that a 
 * portlet must handle concurrent requests and be careful to synchronize 
 * access to shared resources.  Shared resources include in-memory data 
 * such as  instance or class variables and external objects  such as 
 * files, database connections, and network  connections.
 */
public abstract class GenericPortlet implements Portlet, PortletConfig, EventPortlet, ResourceServingPortlet
{

  private transient PortletConfig config;

  /**
   * Does nothing.
   */

  public GenericPortlet()
  {
  }


  /**
   * Called by the portlet container to indicate to a portlet that the 
   * portlet is being placed into service.
   * <p>
   * The default implementation just stores the <code>PortletConfig</code>
   * object.
   * <p>The portlet container calls the <code>init</code>
   * method exactly once after instantiating the portlet.
   * The <code>init</code> method must complete successfully
   * before the portlet can receive any requests.
   *
   * <p>The portlet container cannot place the portlet into service
   * if the <code>init</code> method does one of the following:
   * <ol>
   * <li>it throws a <code>PortletException</code>
   * <li>it does not return within a time period defined by the Web server
   * </ol>
   *
   *
   * @param config			a <code>PortletConfig</code> object 
   *					containing the portlet
   * 					configuration and initialization parameters
   *
   * @exception PortletException 	if an exception has occurred that
   *					interferes with the portlet normal
   *					operation.
   * @exception UnavailableException 	if the portlet cannot perform the initialization at this time.
   */

  public void init (PortletConfig config) throws PortletException
  {
    this.config = config;
    this.init();
  }

  
  /**
   *
   * A convenience method which can be overridden so that there's no need
   * to call <code>super.init(config)</code>.
   *
   * <p>Instead of overriding {@link #init(PortletConfig)}, simply override
   * this method and it will be called by
   * <code>GenericPortlet.init(PortletConfig config)</code>.
   * The <code>PortletConfig</code> object can still be retrieved via {@link
   * #getPortletConfig}. 
   *
   * @exception PortletException 	if an exception has occurred that
   *					interferes with the portlet normal
   *					operation.
   * @exception UnavailableException 	if the portlet is unavailable to perform init
   */
    
  public void init() throws PortletException
  {
  }


  /**
   * Called by the portlet container to allow the portlet to process
   * an action request. This method is called if the client request was
   * originated by a URL created (by the portlet) with the 
   * <code>RenderResponse.createActionURL()</code> method.
   * <p>
   * The default implementation throws an exception.
   *
   * @param request
   *                 the action request
   * @param response
   *                 the action response
   * @exception PortletException
   *                   if the portlet cannot fulfilling the request
   * @exception  UnavailableException 	
   *                   if the portlet is unavailable to process the action at this time
   * @exception  PortletSecurityException  
   *                   if the portlet cannot fullfill this request because of security reasons
   * @exception  java.io.IOException
   *                   if the streaming causes an I/O problem
   */
  public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
    throw new PortletException("processAction method not implemented");
  }


  /**
   * The default implementation of this method sets the title 
   * using the <code>getTitle</code> method and invokes the
   * <code>doDispatch</code> method.
   * 
   * @param request
   *                 the render request
   * @param response
   *                 the render response
   *
   * @exception PortletException
   *                   if the portlet cannot fulfilling the request
   * @exception  UnavailableException 	
   *                   if the portlet is unavailable to perform render at this time
   * @exception  PortletSecurityException  
   *                   if the portlet cannot fullfill this request because of security reasons
   * @exception java.io.IOException
   *                   if the streaming causes an I/O problem
   *
   */
  public void render (RenderRequest request,
		      RenderResponse response)
    throws PortletException, java.io.IOException
  {
    response.setTitle(getTitle(request));
    doDispatch(request, response);
  }
  


  /**
   * Used by the render method to get the title.
   * <p>
   * The default implementation gets the title from the ResourceBundle
   * of the PortletConfig of the portlet. The title is retrieved
   * using the 'javax.portlet.title' resource name.
   * <p>
   * Portlets can overwrite this method to provide dynamic
   * titles (e.g. based on locale, client, and session information).
   * Examples are:
   * <UL>
   * <LI>language-dependant titles for multi-lingual portals
   * <LI>shorter titles for WAP phones
   * <LI>the number of messages in a mailbox portlet
   * </UL>
   * 
   * @return the portlet title for this window
   */

  protected java.lang.String getTitle(RenderRequest request) {
    return config.getResourceBundle(request.getLocale()).getString("javax.portlet.title");
  }


  /**
   * The default implementation of this method routes the render request
   * to a set of helper methods depending on the current portlet mode the
   * portlet is currently in.
   * These methods are:
   * <ul>
   * <li><code>doView</code> for handling <code>view</code> requests
   * <li><code>doEdit</code> for handling <code>edit</code> requests
   * <li><code>doHelp</code> for handling <code>help</code> requests
   * </ul>
   * <P>
   * If the window state of this portlet is <code>minimized</code>, this
   * method does not invoke any of the portlet mode rendering methods.
   * <p>
   * For handling custom portlet modes the portlet should override this
   * method.
   *
   * @param request
   *                 the render request
   * @param response
   *                 the render response
   *
   * @exception PortletException
   *                   if the portlet cannot fulfilling the request
   * @exception  UnavailableException 	
   *                   if the portlet is unavailable to perform render at this time
   * @exception  PortletSecurityException  
   *                   if the portlet cannot fullfill this request because of security reasons
   * @exception java.io.IOException
   *                   if the streaming causes an I/O problem
   *
   * @see #doView(RenderRequest, RenderResponse)
   * @see #doEdit(RenderRequest, RenderResponse)
   * @see #doHelp(RenderRequest, RenderResponse)
   */
  protected void doDispatch (RenderRequest request,
			  RenderResponse response) throws PortletException,java.io.IOException
  {
    WindowState state = request.getWindowState();
    
    if ( ! state.equals(WindowState.MINIMIZED)) {
      PortletMode mode = request.getPortletMode();
      if (mode.equals(PortletMode.VIEW)) {
	doView (request, response);
      }
      else if (mode.equals(PortletMode.EDIT)) {
	doEdit (request, response);
      }
      else if (mode.equals(PortletMode.HELP)) {
	doHelp (request, response);
      }
      else {
	throw new PortletException("unknown portlet mode: " + mode);
      }
    }

  }


  /**
   * Helper method to serve up the mandatory <code>view</code> mode.
   * <p>
   * The default implementation throws an exception.
   *
   * @param    request
   *           the portlet request
   * @param    response
   *           the render response
   *
   * @exception PortletException
   *                   if the portlet cannot fulfilling the request
   * @exception  UnavailableException 	
   *                   if the portlet is unavailable to perform render at this time
   * @exception  PortletSecurityException  
   *                   if the portlet cannot fullfill this request because of security reasons
   * @exception java.io.IOException
   *                   if the streaming causes an I/O problem
   *
   */

  protected void doView (RenderRequest request,
		      RenderResponse response)
    throws PortletException, java.io.IOException
  {
    throw new PortletException("doView method not implemented");
  }


  /**
   * Helper method to serve up the <code>edit</code> mode.
   * <p>
   * The default implementation throws an exception.
   *
   * @param    request
   *           the portlet request
   * @param    response
   *           the render response
   *
   * @exception PortletException
   *                   if the portlet cannot fulfilling the request
   * @exception  UnavailableException 	
   *                   if the portlet is unavailable to perform render at this time
   * @exception  PortletSecurityException  
   *                   if the portlet cannot fullfill this request because of security reasons
   * @exception java.io.IOException
   *                   if the streaming causes an I/O problem
   *
   */

  protected void doEdit (RenderRequest request,
		      RenderResponse response)
    throws PortletException, java.io.IOException
  {
    throw new PortletException("doEdit method not implemented");
  }

  /**
   * Helper method to serve up the <code>help</code> mode.
   * <p>
   * The default implementation throws an exception.
   *
   * @param    request
   *           the portlet request
   * @param    response
   *           the render response
   *
   * @exception PortletException
   *                   if the portlet cannot fulfilling the request
   * @exception  UnavailableException 	
   *                   if the portlet is unavailable to perform render at this time
   * @exception  PortletSecurityException  
   *                   if the portlet cannot fullfill this request because of security reasons
   * @exception java.io.IOException
   *                   if the streaming causes an I/O problem
   */

  protected void doHelp (RenderRequest request,
		      RenderResponse response)
    throws PortletException, java.io.IOException
  {
    throw new PortletException("doHelp method not implemented");

  }



  /**
   * Returns the PortletConfig object of this portlet.
   *
   * @return   the PortletConfig object of this portlet
   */

  public PortletConfig getPortletConfig ()
  {
    return config;
  }

  
  /**
   * Called by the portlet container to indicate to a portlet that the portlet 
   * is being taken out of service.
   * <p>
   * The default implementation does nothing.
   *
   */
  
  public void destroy ()
  {
    // do nothing
  }

  //-------------------------------------------------------------------------
  // implement PortletConfig
  //-------------------------------------------------------------------------


  /**
   * Returns the name of this portlet.
   * 
   * @return the portlet name
   * 
   * @see PortletConfig#getPortletName()
   */

  public String getPortletName ()
  {
  	return config.getPortletName();
  }


  /**
   * Returns the <code>PortletContext</code> of the portlet application 
   * the portlet is in.
   *
   * @return   the portlet application context
   */

  public PortletContext getPortletContext ()
  {
  	return config.getPortletContext();
  }



  /**
   * Gets the resource bundle for the given locale based on the
   * resource bundle defined in the deployment descriptor
   * with <code>resource-bundle</code> tag or the inlined resources
   * defined in the deployment descriptor.
   * 
   * @return   the resource bundle for the given locale
   */

  public java.util.ResourceBundle getResourceBundle(java.util.Locale locale)
  {
  	return config.getResourceBundle(locale);
  }

  
  /**
   * Returns a String containing the value of the named initialization parameter, 
   * or null if the parameter does not exist.
   *
   * @param name	a <code>String</code> specifying the name
   *			of the initialization parameter
   *
   * @return		a <code>String</code> containing the value 
   *			of the initialization parameter
   *
   * @exception	java.lang.IllegalArgumentException	
   *                      if name is <code>null</code>.
   */

  public String getInitParameter(java.lang.String name)
  {
  	return config.getInitParameter(name);
  }


  /**
   * Returns the names of the portlet initialization parameters as an 
   * Enumeration of String objects, or an empty Enumeration if the 
   * portlet has no initialization parameters.    
   * 
   * @return		an <code>Enumeration</code> of <code>String</code> 
   *			objects containing the names of the portlet 
   *			initialization parameters, or an empty Enumeration if the 
   *                    portlet has no initialization parameters. 
   */

  public java.util.Enumeration getInitParameterNames()
  {
  	return config.getInitParameterNames();
  }


  /**
   * Default resource serving.
   * <p> 
   * The default implemention of this method is emtpy.
   * 
   * @since 2.0
   */
  public void serveResource(ResourceRequest request, RenderResponse response) throws PortletException, IOException {
    return;
  }



  /** Default event processing. Tries to dispatch to an event method with 
   * annotation  @ProcessEvent(name=<event name>) and the signature<br>
   * <code>public void <methodname> (EventRequest, EventResponse) throws PortletException, java.io.IOException</code>.
   * 
   * @see javax.portlet.EventPortlet#processEvent(javax.portlet.EventRequest, javax.portlet.EventResponse)
   * @since 2.0
   */
  public void processEvent(EventRequest request, EventResponse response) throws PortletException, IOException {
      Method[] methods = this.getClass().getMethods();
      String eventName = request.getEvent().getName();
      final String targetMethodAnnotation = "@javax.portlet.ProcessEvent(name="+eventName+")";
      for (Method method : methods) {
          Annotation[] annotations = method.getAnnotations();
          for (Annotation annotation : annotations) {
              if (annotation.toString().equals(targetMethodAnnotation)) {
                  try {
                      method.invoke(this, request, response);
                      return;
                  } catch (Exception e) {
                      throw new PortletException(e);
                  } 
              }
          }
      }
    // if no event processing method was found just keep render params
    response.setRenderParameters(request.getParameterMap());
    
  }
}
