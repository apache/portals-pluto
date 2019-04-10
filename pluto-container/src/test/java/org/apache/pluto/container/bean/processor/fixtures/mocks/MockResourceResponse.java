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

import java.util.Locale;

import javax.portlet.ResourceResponse;

/**
 * @author Scott Nicklous
 *
 */
public class MockResourceResponse extends MockMimeResponse implements ResourceResponse {

   /* (non-Javadoc)
    * @see javax.portlet.ResourceResponse#setCharacterEncoding(java.lang.String)
    */
   @Override
   public void setCharacterEncoding(String arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceResponse#setContentLength(int)
    */
   @Override
   public void setContentLength(int arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceResponse#setLocale(java.util.Locale)
    */
   @Override
   public void setLocale(Locale arg0) {
   }

   /* (non-Javadoc)
    * @see javax.portlet.ResourceResponse#setStatus(int)
    */
   @Override
   public void setStatus(int arg0) {
   }

   @Override
   public int getStatus() {
      return 0;
   }

   @Override
   public void setContentLengthLong(long len) {
   }

}
