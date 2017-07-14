/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

import java.io.IOException;
import java.io.PrintWriter;

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
import javax.portlet.UnavailableException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the event processing portlet for the test cases. This portlet processes events, but does
 * not publish them. Events are published in the main portlet for the test cases.
 * 
 * @author ahmed
 */
public class AddlPortletTests_SPEC2_15_EventEventHandling_unavailableException
    implements Portlet, EventPortlet, ResourceServingPortlet {

  private final Logger LOGGER = LoggerFactory.getLogger(AddlPortletTests_SPEC2_15_EventEventHandling_unavailableException.class);


  @Override
  public void init(PortletConfig config) throws PortletException {}

  @Override
  public void destroy() {
    AddlPortletTests_SPEC2_15_EventEventHandling_event.tr8 = true;
  }

  @Override
  public void processAction(ActionRequest portletReq, ActionResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion processAction - ERROR!!");
  }

  @Override
  public void serveResource(ResourceRequest portletReq, ResourceResponse portletResp)
      throws PortletException, IOException {
    LOGGER.trace("event companion serveResource - ERROR!!");
  }

  @Override
  public void processEvent(EventRequest portletReq, EventResponse portletResp)
      throws PortletException, IOException {
    /* TestCase: V2AddlPortletTests_SPEC2_15_EventEventHandling_event16 */
    /* Details: "If a portlet throws a permanent UnavailableException */
    /* during event processing, the portlet container must remove the */
    /* portlet from service immediately, call the portlet's destroy */
    /* method, and release the portlet object" */
    throw new UnavailableException(
        "UnavailableException from V2AddlPortletTests_SPEC2_15_EventEventHandling_event16");
  }

  @Override
  public void render(RenderRequest request, RenderResponse portletResp)
      throws PortletException, IOException {
    portletResp.setContentType("text/html");
    PrintWriter writer = portletResp.getWriter();
    writer.write("<h3>Event Companion Portlet </h3>\n");
    writer.write("<p>AddlPortletTests_SPEC2_15_EventEventHandling_unavailableException</p>\n");
  }
}
