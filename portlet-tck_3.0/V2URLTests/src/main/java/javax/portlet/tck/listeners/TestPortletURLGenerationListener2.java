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

import javax.portlet.BaseURL;
import javax.portlet.PortletURL;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.ResourceURL;

/**
 *Test PortletURLGenerationListener
 * Used by portlet: URLTests_PortletURLGenerationListener_ApiRenderResurl
 *
 * @author nick
 *
 */
public class TestPortletURLGenerationListener2 implements PortletURLGenerationListener {

      // set parameters on URLs to indicate test success

   public void filterActionURL(PortletURL url) {
      if (isURLGenTc(url)) url.setParameter("PUGL2", "Action");
   }

   public void filterRenderURL(PortletURL url) {
      if (isURLGenTc(url)) url.setParameter("PUGL2", "Render");
   }

   public void filterResourceURL(ResourceURL url) {
      if (isURLGenTc(url)) url.setParameter("PUGL2", "Resource");
   }

   // only set parm for PortletURLGenerationListener test cases.
   // This is the second registered listener, so the parameter set by
   // the first listener should be set. If it isn't, it's an error,
   // so refrain from setting the "PUGL2" parameter.
   private boolean isURLGenTc(BaseURL url) {
      boolean ok = false;
      String[] vals = (String[]) url.getParameterMap().get("tc");
      if ((vals != null) && (vals.length > 0) && vals[0].contains("PortletURLGenerationListener")) {
         vals = (String[]) url.getParameterMap().get("PUGL");
         if ((vals != null) && (vals.length > 0) && vals[0].matches("^(?:Action|Render|Resource)$")) {
            ok = true;
         }
      }
      return ok;
   }


}
