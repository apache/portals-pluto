/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.tags;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.core.PortalServletResponse;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.tags.el.ExpressionEvaluatorProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The portlet tag is used to render a portlet specified by the portlet ID.
 * 
 * @see javax.portlet.Portlet#render(javax.portlet.RenderRequest,javax.portlet.RenderResponse)
 * @see org.apache.pluto.container.PortletContainer#doRender(PortletWindow, HttpServletRequest, HttpServletResponse)
 * 
 */
public class PortletTag extends BodyTagSupport {
   private static final long     serialVersionUID = 7369029503826395301L;

   /** Logger. */
   private static final Logger   LOG              = LoggerFactory.getLogger(PortletTag.class);

   /** Status constant for failed rendering. */
   public static final int       FAILED           = 0;

   /** Status constant for successful rendering. */
   public static final int       SUCCESS          = 1;

   // Private Member Variables ------------------------------------------------

   /** The portlet ID attribute passed into this tag. */
   private String                portletId;

   /** The evaluated value of the portlet ID attribute. */
   private String                evaluatedPortletId;
   
   /** The portlet window being processed */
   private PortletWindow window;

   /** The cached portal servlet response holding rendering result. */
   private PortalServletResponse response;

   /** The cached rendering status: SUCCESS or FAILED. */
   private int                   status;

   // Error messages to display if something goes wrong
   private List<String>          messages;

   // Tag Attribute Accessors -------------------------------------------------

   /**
    * Returns the portlet ID attribute.
    * 
    * @return the portlet ID attribute.
    */
   public String getPortletId() {
      return portletId;
   }

   /**
    * Sets the portlet ID attribute.
    * 
    * @param portletId
    *           the portlet ID attribute.
    */
   public void setPortletId(String portletId) {
      this.portletId = portletId;
   }

   // BodyTagSupport Impl -----------------------------------------------------

   /**
    * Method invoked when the start tag is encountered.
    * 
    * @throws JspException
    *            if an error occurs.
    */
   @Override
   public int doStartTag() throws JspException {
      
      messages = new ArrayList<String>();

      // Evaluate portlet ID attribute.
      evaluatePortletId();

      // Retrieve the portlet window config for the evaluated portlet ID.
      ServletContext servletContext = pageContext.getServletContext();

      PortletWindowConfig windowConfig = PortletWindowConfig.fromId(evaluatedPortletId);

      if (LOG.isDebugEnabled()) {
         LOG.debug("Rendering Portlet Window: " + windowConfig);
      }

      // Retrieve the current portal URL.
      PortalRequestContext portalEnv = PortalRequestContext.getContext((HttpServletRequest) pageContext.getRequest());
      PortalURL portalURL = portalEnv.getRequestedPortalURL();

      // Retrieve the portlet container from servlet context.
      PortletContainer container = (PortletContainer) servletContext.getAttribute(AttributeKeys.PORTLET_CONTAINER);

      // Create the portlet window to render.
      window = null;

      try {
         window = new PortletWindowImpl(container, windowConfig, portalURL);
      } catch (Throwable e) {

         status = FAILED;

         StringBuilder txt = new StringBuilder(128);
         txt.append("The portlet '");
         txt.append(windowConfig.getPortletName());
         txt.append("' is not available.");
         txt.append(" Configuration could not be found.");

         messages.add(txt.toString());

         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         e.printStackTrace(pw);
         pw.flush();
         txt.append("\n");
         txt.append(sw.toString());
         LOG.warn(txt.toString());
      }

      // Create portal servlet response to wrap the original HTTP servlet response.

      PortalServletResponse portalResponse = new PortalServletResponse((HttpServletResponse) pageContext.getResponse());

      if (window != null) {

         // Check if someone else is maximized. If yes, don't show content.

         Map<String, WindowState> windowStates = portalURL.getWindowStates();
         for (Iterator<String> it = windowStates.keySet().iterator(); it.hasNext();) {
            String windowId = it.next();
            WindowState windowState = windowStates.get(windowId);
            if (WindowState.MAXIMIZED.equals(windowState) && !window.getId().getStringId().equals(windowId)) {
               return SKIP_BODY;
            }
         }
         
         DriverConfiguration driverConfig = (DriverConfiguration)
               servletContext.getAttribute(AttributeKeys.DRIVER_CONFIG);
         PortletDefinition pd = window.getPortletDefinition();

         String mode = window.getPortletMode().toString();
         boolean supported = driverConfig.isPortletModeSupported(evaluatedPortletId, mode);
                  
         if (supported) {

            // Render the portlet and cache the response.
            try {
               String renderHeaders = null;
               if (portalURL.getVersion(evaluatedPortletId).equalsIgnoreCase("2.0")) {

                  ContainerRuntimeOption crt = pd.getContainerRuntimeOption("javax.portlet.renderHeaders");
                  if (crt != null) {
                     List<String> headers = crt.getValues();
                     if (headers.size() == 1 && headers.get(0).equalsIgnoreCase("true")) {
                        renderHeaders = PortletRequest.RENDER_MARKUP;
                     }
                  }
               }

               container.doRender(window, (HttpServletRequest) pageContext.getRequest(), portalResponse, renderHeaders);
               response = portalResponse;
               status = SUCCESS;
            } catch (Throwable th) {
               status = FAILED;
               messages.add("Portlet not available. Exception: " + th.getMessage());
            }
         } else {
            status = FAILED;
            messages.add("Portlet not available. Portlet mode not supported: " + mode);
         }
      }

      // Continue to evaluate the tag body.
      return EVAL_BODY_INCLUDE;
   }

   // Package Methods ---------------------------------------------------------

   /**
    * Returns the rendering status.
    * 
    * @return the rendering status.
    */
   int getStatus() {
      return status;
   }

   /**
    * Returns the portal servlet response holding rendering result.
    * 
    * @return the portal servlet response holding rendering result.
    */
   PortalServletResponse getPortalServletResponse() {
      return response;
   }

   /**
    * Returns the error that has occurred when rendering portlet.
    * 
    * @return the error that has occurred when rendering portlet.
    */
   List<String> getMessages() {
      return messages;
   }

   /**
    * Returns the evaluated portlet ID.
    * 
    * @return the evaluated portlet ID.
    */
   String getEvaluatedPortletId() {
      return evaluatedPortletId;
   }

   // Private Methods ---------------------------------------------------------

   /**
    * @return the window
    */
   public PortletWindow getWindow() {
      return window;
   }

   /**
    * Evaluates the portlet ID attribute passed into this tag. This method evaluates the member variable
    * <code>portletId</code> and saves the evaluated result to <code>evaluatedPortletId</code>
    * 
    * @throws JspException
    *            if an error occurs.
    */
   private void evaluatePortletId() throws JspException {
      ExpressionEvaluatorProxy proxy = ExpressionEvaluatorProxy.getProxy();
      Object obj = proxy.evaluate(portletId, pageContext);
      if (LOG.isDebugEnabled()) {
         LOG.debug("Evaluated portletId to: " + obj);
      }
      evaluatedPortletId = (String) obj;
   }

}
