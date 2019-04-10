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


package javax.portlet.tck.portlets;

import java.io.IOException;

import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.annotations.HeaderMethod;

/**
 * Contains header method for all portlets in this portlet app
 * 
 * @author Scott Nicklous
 *
 */
public class HeaderSetter {

   @HeaderMethod(portletNames="*")
   public void header(HeaderRequest req, HeaderResponse resp) throws IOException {
      
      // Adds a promise polyfill (can be removed when driver supports promises natively)
      // and the portlet hub dependency
      
      String contextRoot = req.getContextPath();
      StringBuilder txt = new StringBuilder(128);
      txt.append("<script type='text/javascript' src='");
      txt.append(contextRoot);
      txt.append("/javascript/promise.js'></script>\n");
      resp.addDependency("promise", "org.apache.pluto", "0.3.0", txt.toString());
   }

}
