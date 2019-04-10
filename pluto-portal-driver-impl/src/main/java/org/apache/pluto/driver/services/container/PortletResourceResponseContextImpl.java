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

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletResourceResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version $Id$
 *
 */
public class PortletResourceResponseContextImpl extends PortletMimeResponseContextImpl implements
                PortletResourceResponseContext
{
   private static final Logger    LOGGER  = LoggerFactory.getLogger(PortletResourceResponseContextImpl.class);
   private static final boolean   isTrace = LOGGER.isTraceEnabled();
    
    public PortletResourceResponseContextImpl(PortletContainer container, HttpServletRequest containerRequest,
          HttpServletResponse containerResponse, PortletWindow window, PortletRequestContext requestContext)
    {        
        super(container, containerRequest, containerResponse, window, requestContext);
        setLifecycle(PortletRequest.RESOURCE_PHASE);
    }

    public void setCharacterEncoding(String charset)
    {
        if (isTrace) {
           StringBuilder txt = new StringBuilder("Setting character encoding.");
           txt.append(" charset: ").append(charset);
           txt.append(" isClosed: ").append(isClosed());
           LOGGER.trace(txt.toString());
        }
        if (!isClosed())
        {
            getServletResponse().setCharacterEncoding(charset);
        }
    }

    public void setContentLength(int len)
    {
        if (!isClosed())
        {
            getServletResponse().setContentLength(len);
        }
    }

    @Override
    public void setContentLengthLong(long len)
    {
        if (!isClosed())
        {
            getServletResponse().setContentLengthLong(len);
        }
    }

    public void setLocale(Locale locale)
    {
        if (!isClosed())
        {
            getServletResponse().setLocale(locale);
        }
    }

   public void setStatus(int sc) {
      if (isTrace) {
         StringBuilder txt = new StringBuilder("Setting character encoding.");
         txt.append(" status code: ").append(sc);
         txt.append(" isClosed: ").append(isClosed());
         LOGGER.trace(txt.toString());
      }
      if (!isClosed()) {
         getServletResponse().setStatus(sc);
      }
   }

   @Override
   public int getStatus() {
      return getServletResponse().getStatus();
   }
}
