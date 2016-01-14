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


package org.apache.pluto.container.bean.processor;

import javax.portlet.ActionURL;
import javax.portlet.MimeResponse;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.PortletResponse;
import javax.portlet.RenderURL;
import javax.portlet.ResourceURL;
import javax.portlet.annotations.URLFactory;

/**
 * @author Scott Nicklous
 *
 */
public class URLFactoryImpl implements URLFactory {
   
   private final MimeResponse    mimeResp;
   
   public URLFactoryImpl(PortletResponse resp) {
      assert (resp instanceof MimeResponse);
      mimeResp = (MimeResponse) resp;
   }

   /* (non-Javadoc)
    * @see javax.portlet.annotations.URLFactory#createActionURL()
    */
   @Override
   public ActionURL createActionURL(Copy copyOpt) {
      return mimeResp.createActionURL(copyOpt);
   }

   /* (non-Javadoc)
    * @see javax.portlet.annotations.URLFactory#createRenderURL()
    */
   @Override
   public RenderURL createRenderURL(Copy copyOpt) {
      return mimeResp.createRenderURL(copyOpt);
   }

   /* (non-Javadoc)
    * @see javax.portlet.annotations.URLFactory#createResourceURL()
    */
   @Override
   public ResourceURL createResourceURL() {
      return mimeResp.createResourceURL();
   }

   /* (non-Javadoc)
    * @see javax.portlet.annotations.URLFactory#encodeURL(java.lang.String)
    */
   @Override
   public String encodeURL(String path) {
      return mimeResp.encodeURL(path);
   }

}
