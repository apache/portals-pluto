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

package org.apache.pluto.services;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PlutoException;
import org.apache.pluto.PlutoEnvironment;
import org.apache.pluto.core.PortletRegistry;

import javax.portlet.PortletResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import java.io.IOException;

/**
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 10:00:58 AM
 */
public interface PortletInvokerService {

    void init(PlutoEnvironment config, PortletRegistry registry);

    void doLoad(PortletWindow window, ServletRequest req, ServletResponse res)
    throws PlutoException, PortletException, IOException;
    
    void doAction(PortletWindow window, ServletRequest req, ServletResponse res)
    throws PlutoException, PortletException, IOException;

    void doRender(PortletWindow window, ServletRequest req, ServletResponse res)
    throws PlutoException, PortletException, IOException;

}
