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

import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 9:43:57 PM
 */
public class PortletRequestDispatcherImpl
    implements PortletRequestDispatcher {

    private RequestDispatcher dispatcher;
    public PortletRequestDispatcherImpl(RequestDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void include(RenderRequest request,
                        RenderResponse response)
    throws PortletException, IOException {
        try {
            if(request instanceof RenderRequestImpl
             &&response instanceof RenderResponseImpl) {
                dispatcher.include((RenderRequestImpl)request,
                                   (RenderResponseImpl)response);
            }
            else {
                throw new IllegalStateException(
                    "Invalid request and response objects"
                );
            }
        }
        catch(ServletException se) {
            throw new PortletException(
                "Unable to dispatch render request",
                se
            );
        }
    }
}
