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
package org.apache.pluto.driver.services.container;

import static javax.portlet.PortletRequest.HEADER_PHASE;
import static javax.portlet.PortletRequest.RENDER_PHASE;

import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.pluto.container.HeaderData;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletURLProvider.TYPE;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.ResourceURLProvider;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @version $Id$
 * 
 */
public abstract class PortletResponseContextImpl implements PortletResponseContext {

   /** Logger. */
   private static final Logger      LOG               = LoggerFactory.getLogger(PortletResponseContextImpl.class);
   private static final boolean     isDebug           = LOG.isDebugEnabled();

   private PortletContainer         container;
   private HttpServletRequest       containerRequest;
   private HttpServletResponse      containerResponse;
   private HttpServletRequest       servletRequest;
   private HttpServletResponse      servletResponse;
   private PortletWindow            window;
   private PortalURL                portalURL;
   private boolean                  closed;
   private boolean                  released;

   // needed for processing of properties based on request type
   private String                   lifecycle;
   private boolean                  isSetPropsAllowed = false;

   private Document                 doc               = null;
   private Element                  root              = null;
   private static final String      ROOT_ELEMENT      = "rootElement";
   private static final Set<String> allowedTags       = new HashSet<String>();
   static {
      allowedTags.add("META");
      allowedTags.add("LINK");
      allowedTags.add("STYLE");
      allowedTags.add("SCRIPT");
      allowedTags.add("NOSCRIPT");
   }
   
   // holder for the header data
   protected HeaderData headerData = new HeaderData();

   public PortletResponseContextImpl(PortletContainer container, HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window) {
      this.container = container;
      this.containerRequest = containerRequest;
      this.containerResponse = containerResponse;
      this.window = window;
      this.portalURL = PortalRequestContext.getContext(containerRequest).createPortalURL();
   }

   public String getLifecycle() {
      return lifecycle;
   }

   public void setLifecycle(String lifecycle) {
      this.lifecycle = lifecycle;
   }

   public boolean isSetPropsAllowed() {
      return isSetPropsAllowed;
   }

   public void setPropsAllowed(boolean isSetPropsAllowed) {
      this.isSetPropsAllowed = isSetPropsAllowed;
   }
   
   /**
    * returns the header data provided by the portlet during header phase execution.
    */
   @Override
   public HeaderData getHeaderData() {
      headerData.setHeadSectionMarkup(getTags());
      return headerData;
   }

   /**
    * returns a string containing any tags that should go into the document head section.
    * 
    * @return String containing the tags, or the empty string if no tags are available.
    */
   private String getTags() {
      String tags = "";
      if (doc != null) {
         DOMSource src = new DOMSource(doc);
         StringWriter sw = new StringWriter();
         StreamResult res = new StreamResult(sw);
         try {

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.METHOD, "html");

            trans.transform(src, res);

            String regex = "(?:\\s*)</{0,1}" + ROOT_ELEMENT + ">(?:\\s*)";
            tags = sw.toString().replaceAll(regex, "");

         } catch (Exception e) {
            StringBuilder txt = new StringBuilder();
            txt.append("Error converting tags to string. Exception: ");
            txt.append(e.toString());
            LOG.warn(txt.toString());
         }
      }

      if (isDebug) {
         StringBuilder sb = new StringBuilder();
         sb.append("returning tags: ");
         sb.append((tags.length()>0) ? "\n" + tags : "");
         LOG.debug(sb.toString());
      }

      return tags;
   }

   protected PortalURL getPortalURL() {
      return portalURL;
   }

   protected boolean isClosed() {
      return closed;
   }

   protected boolean isReleased() {
      return released;
   }

   public void init(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
      this.servletRequest = servletRequest;
      this.servletResponse = servletResponse;
   }

   public void addProperty(Cookie cookie) {
      if (!isClosed()) {
         servletResponse.addCookie(cookie);
      }
   }

   /**
    * saves elements for adding to the head section markup if header request or render request
    */
   public void addProperty(String key, Element element) {
      if (!isClosed() && isSetPropsAllowed && element != null && root != null) {
         if (lifecycle.equals(RENDER_PHASE) || lifecycle.equals(HEADER_PHASE)) {
            String tag = element.getTagName().toUpperCase();
            if (allowedTags.contains(tag)) {
               root.appendChild(element);
            }
         }
      }
   }

   public void addProperty(String key, String value) {
      // not supported
   }

   public Element createElement(String tagName) throws DOMException {

      try {
         if (doc == null) {
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            doc = docBuilder.newDocument();
            root = doc.createElement(ROOT_ELEMENT);
            doc.appendChild(root);
         }
         return doc.createElement(tagName);
      } catch (ParserConfigurationException e) {
         throw new DOMException((short) 0, "Initialization failure");
      }
   }

   public void close() {
      closed = true;
   }

   public PortletContainer getContainer() {
      return container;
   }

   public PortletWindow getPortletWindow() {
      return window;
   }

   public HttpServletRequest getContainerRequest() {
      return containerRequest;
   }

   public HttpServletResponse getContainerResponse() {
      return containerResponse;
   }

   public HttpServletRequest getServletRequest() {
      return servletRequest;
   }

   public HttpServletResponse getServletResponse() {
      return servletResponse;
   }

   public void release() {
      closed = true;
      released = true;
      container = null;
      servletRequest = null;
      servletResponse = null;
      window = null;
   }

   public void setProperty(String key, String value) {
      // not supported
   }

   public ResourceURLProvider getResourceURLProvider() {
      return isReleased() ? null : new ResourceURLProviderImpl(servletRequest, window);
   }

   public PortletURLProvider getPortletURLProvider(TYPE type) {
      return isClosed() ? null : new PortletURLProviderImpl(getPortalURL(), type, getPortletWindow());
   }
}
