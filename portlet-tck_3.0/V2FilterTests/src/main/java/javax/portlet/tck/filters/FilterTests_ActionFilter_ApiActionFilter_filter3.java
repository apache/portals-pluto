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


package javax.portlet.tck.filters;

import java.io.*;
import java.util.logging.*;
import javax.portlet.*;
import javax.portlet.filter.*;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_ActionFilter_ApiActionFilter2
 *
 * @author ahmed
 *
 */
public class FilterTests_ActionFilter_ApiActionFilter_filter3 implements ActionFilter {
  private static final String LOG_CLASS =
      FilterTests_ActionFilter_ApiActionFilter_filter3.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);


  @Override
  public void init(FilterConfig filterConfig) throws PortletException {}

  @Override
  public void destroy() {}

  @Override
  public void doFilter(ActionRequest portletReq, ActionResponse portletResp, FilterChain chain)
      throws IOException, PortletException {
    LOGGER.entering(LOG_CLASS, "doFilter");

    portletResp.setRenderParameter("tr5_success", "true");
  }
}
