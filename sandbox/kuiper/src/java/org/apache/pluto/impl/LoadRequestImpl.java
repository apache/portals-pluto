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

package org.apache.pluto.impl;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PlutoEnvironment;

import javax.servlet.http.HttpServletRequest;
import javax.portlet.PortletContext;
import javax.portlet.PortalContext;

/**
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 11:58:20 AM
 */
public class LoadRequestImpl extends PortletRequestImpl {
    
    public LoadRequestImpl(PlutoEnvironment environment,
                           PortletContext context,
                           PortletWindow window,
                           HttpServletRequest request) {
        super(environment, context, window, request);
    }
}
