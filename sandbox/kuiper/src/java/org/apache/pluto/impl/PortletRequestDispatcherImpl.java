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

/** PortletRequestDispatcher implementation. This implementation
 *  leverages the RequestDispatcher which it decorates.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 9:43:57 PM
 */
public class PortletRequestDispatcherImpl
    implements PortletRequestDispatcher {

    /** Underlying/Decorated dispatcher. */
    private RequestDispatcher dispatcher;

    /** Default Constructor. */
    public PortletRequestDispatcherImpl(RequestDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    /** Include the given resources. */
    public void include(RenderRequest request,
                        RenderResponse response)
    throws PortletException, IOException {
        try {
            //@TODO when the OptionalServiceFactory
            //      is implemented, we'll need to take
            //      a hard look at this! We *may* be
            //      ok though since it's the request
            //      which manages out lifecycle.
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
