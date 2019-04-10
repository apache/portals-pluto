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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletActionResponseContext;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version $Id$
 * 
 */
public class PortletActionResponseContextImpl extends PortletStateAwareResponseContextImpl implements PortletActionResponseContext {

   /** Logger. */
   private static final Logger  LOG     = LoggerFactory.getLogger(PortletActionResponseContextImpl.class);
   private static final boolean isTrace = LOG.isTraceEnabled();

   private boolean              redirect;
   private String               redirectLocation;
   private String               renderURLParamName;

   public PortletActionResponseContextImpl(PortletContainer container, HttpServletRequest containerRequest, HttpServletResponse containerResponse,
         PortletWindow window, PortletRequestContext requestContext) {
      super(container, containerRequest, containerResponse, window, requestContext);
      setLifecycle(PortletRequest.ACTION_PHASE);
   }

   public String getResponseURL() {
      if (!isReleased()) {
         close();
         if (!redirect || renderURLParamName != null) {
            PortalURL url = PortalRequestContext.getContext(getServletRequest()).createPortalURL();
            if (redirect) {
               try {
                  
                  // properly handle redirect location, which may have a query string and a fragment identifier.
                  // first, extract info from redirect location -
                  
                  String fragment = redirectLocation.replaceFirst("^([^#]*)(#.*)$", "$2");
                  String base = redirectLocation.replaceFirst("^([^#]*)(#.*)$", "$1");

                  boolean hasFragment = !fragment.equals(redirectLocation);
                  boolean hasQuery = base.indexOf("?") >= 0;
                  
                  // Now build the overall URL

                  StringBuilder urlBuilder = new StringBuilder(128);
                  urlBuilder.append(base);
                  urlBuilder.append(hasQuery ? "&" : "?");
                  urlBuilder.append(URLEncoder.encode(renderURLParamName, "UTF-8")).append("=");
                  urlBuilder.append(URLEncoder.encode(url.toURL(true), "UTF-8"));
                  urlBuilder.append(hasFragment ? fragment : "");
                  
                  if (isTrace) {
                     StringBuilder txt = new StringBuilder();
                     txt.append("hasFragment: ").append(hasFragment);
                     txt.append(", fragment: ").append(hasFragment ? fragment : "n/a");
                     txt.append(", hasQuery: ").append(hasQuery);
                     txt.append(", paramName: ").append(renderURLParamName);
                     txt.append("\n   Original redirect location: ").append(redirectLocation);
                     txt.append("\n   Complete URL: ").append(urlBuilder.toString());
                     LOG.debug(txt.toString());
                  }
                  
                  return urlBuilder.toString();
               } catch (UnsupportedEncodingException e) {
                  // Cannot happen: UTF-8 is a buildin/required encoder
                  return null;
               }
            } else {
               return url.toURL(false);
            }
         } else {
            return redirectLocation;
         }
      }
      return null;
   }

   public boolean isRedirect() {
      return redirect;
   }

   public void setRedirect(String location) {
      setRedirect(location, null);
   }

   public void setRedirect(String location, String renderURLParamName) {
      if (!isClosed()) {
         this.redirectLocation = location;
         this.renderURLParamName = renderURLParamName;
         this.redirect = true;
      }
   }
}
