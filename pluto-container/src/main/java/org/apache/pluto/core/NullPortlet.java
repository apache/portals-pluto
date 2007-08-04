/*
 * Copyright 2006 The Apache Software Foundation.
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
package org.apache.pluto.core;

/**
 * Implements the Null Object Pattern
 * 
 * @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 *
 */

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventPortlet;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceServingPortlet;

public class NullPortlet implements EventPortlet, ResourceServingPortlet,
               Portlet {

       public void processEvent(EventRequest arg0, EventResponse arg1)
                       throws PortletException, IOException {
               // TODO Auto-generated method stub

       }

       public void serveResource(ResourceRequest arg0, ResourceResponse arg1)
                       throws PortletException, IOException {
               // TODO Auto-generated method stub

       }

       public void destroy() {
               // TODO Auto-generated method stub

       }

       public void init(PortletConfig arg0) throws PortletException {
               // TODO Auto-generated method stub

       }

       public void processAction(ActionRequest arg0, ActionResponse arg1)
                       throws PortletException, IOException {
               // TODO Auto-generated method stub

       }

       public void render(RenderRequest arg0, RenderResponse arg1)
                       throws PortletException, IOException {
               // TODO Auto-generated method stub

       }

}
