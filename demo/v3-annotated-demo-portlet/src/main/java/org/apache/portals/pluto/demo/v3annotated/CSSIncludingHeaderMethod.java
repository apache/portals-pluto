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


package org.apache.portals.pluto.demo.v3annotated;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.annotations.HeaderMethod;

/**
 * Header method to include a css file.
 */
@ApplicationScoped
public class CSSIncludingHeaderMethod {
   
   // The header method can apply to a list of portlets. If the asterisk is specified 
   // as first portlet name, the header method is executed for all portlets in
   // the portlet application.
   @HeaderMethod(portletNames="*")
   public void header(HeaderRequest req, HeaderResponse resp) throws IOException {

      // Add link tag to head section to include the style sheet

      String contextRoot = req.getContextPath();
      StringBuilder txt = new StringBuilder(128);
      txt.append("<link href='").append(contextRoot);
      txt.append("/resources/css/infobox.css' rel='stylesheet' type='text/css'>");
      
      resp.addDependency("infobox", "org.apache.pluto", "0.3.0", txt.toString());

   }

}
