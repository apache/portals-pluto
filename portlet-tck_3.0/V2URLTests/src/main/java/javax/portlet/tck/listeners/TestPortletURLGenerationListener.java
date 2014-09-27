/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */


package javax.portlet.tck.listeners;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 *Test PortletURLGenerationListener
 * Used by portlet: URLTests_PortletURLGenerationListener_ApiRender
 *
 * @author nick
 *
 */
public class TestPortletURLGenerationListener implements PortletURLGenerationListener {
   private static final String LOG_CLASS = 
         TestPortletURLGenerationListener.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

      // set parameters on URLs to indicate test success

   public void filterActionURL(PortletURL url) {
      url.setParameter("PUGL", "Action");
   }

   public void filterRenderURL(PortletURL url) {
      url.setParameter("PUGL", "Render");
   }

   public void filterResourceURL(ResourceURL url) {
      url.setParameter("PUGL", "Resource");
   }


}
