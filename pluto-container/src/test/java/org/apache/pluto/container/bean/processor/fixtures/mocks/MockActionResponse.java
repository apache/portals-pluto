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


package org.apache.pluto.container.bean.processor.fixtures.mocks;

import java.io.IOException;

import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.RenderURL;

/**
 * @author Scott
 *
 */
public class MockActionResponse extends MockStateAwareResponse implements ActionResponse {

   /* (non-Javadoc)
    * @see javax.portlet.ActionResponse#getRedirectURL(javax.portlet.MimeResponse.Copy)
    */
   @Override
   public RenderURL createRedirectURL(Copy arg0) throws IllegalStateException {
      return null;
   }

   /* (non-Javadoc)
    * @see javax.portlet.ActionResponse#sendRedirect(java.lang.String)
    */
   @Override
   public void sendRedirect(String arg0) throws IOException {
   }

   /* (non-Javadoc)
    * @see javax.portlet.ActionResponse#sendRedirect(java.lang.String, java.lang.String)
    */
   @Override
   public void sendRedirect(String arg0, String arg1) throws IOException {
   }

}
