/*
 * Copyright 2003,2004 The Apache Software Foundation.
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

package org.apache.pluto.driver.impl.services;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.PortalConfig;
import org.apache.pluto.driver.Portal;
import org.apache.pluto.driver.impl.services.PortletURLImpl;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 14, 2004 at 6:37:43 PM
 */
public class PortletURLRenderImpl extends PortletURLImpl {

    public PortletURLRenderImpl(PortletWindow window,
                                HttpServletRequest request) {
        super(window, request);
    }

    protected String getResource() {
        return Portal.getPortal().getPortalConfig().getBaseRenderPath();
    }
}
