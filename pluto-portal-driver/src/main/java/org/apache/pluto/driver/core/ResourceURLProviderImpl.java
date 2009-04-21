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
package org.apache.pluto.driver.core;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.ResourceURLProvider;

public class ResourceURLProviderImpl implements ResourceURLProvider {

    private static final Logger LOG =
        LoggerFactory.getLogger(ResourceURLProviderImpl.class);

    private String stringUrl = "";
    private String base = "";

    public ResourceURLProviderImpl(HttpServletRequest req,
                                   PortletWindow portletWindow) {
        PortalRequestContext ctx = PortalRequestContext.getContext(req);

        this.base = ctx.createPortalURL().getServerURI();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Resource URL Created with base: " + base);
        }
    }

    public void setAbsoluteURL(String path) {
        stringUrl = path;
    }

    public void setFullPath(String path) {
        stringUrl = base + path;
    }

    public String toString() {
        URL url = null;

        if (!"".equals(stringUrl)) {
            try {
                url = new URL(stringUrl);
            } catch (MalformedURLException e) {
                throw new java.lang.IllegalArgumentException(
                    "A malformed URL has occured");
            }
        }

        return ((url == null) ? "" : url.toString());

    }
}
