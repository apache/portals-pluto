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


package org.apache.pluto.driver.services.impl.resource;

import java.util.logging.Logger;

import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PublicRenderParameterMapper;
import org.apache.pluto.driver.services.portal.PublicRenderParameterQNameMapper;
import org.apache.pluto.driver.services.portal.PublicRenderParameterService;
import org.apache.pluto.driver.services.portal.RenderConfigService;

/**
 * Provides public render parameter mappings for a specified page. 
 * 
 * @author msnicklous
 * @since  16/01/2015
 */
public class PublicRenderParameterServiceImpl implements PublicRenderParameterService {
   private static final String LOG_CLASS = PublicRenderParameterServiceImpl.class.getName();
   private final Logger        LOGGER    = Logger.getLogger(LOG_CLASS);
   
   private final RenderConfigService reco;
   private final PortletRegistryService pore;
   
   public PublicRenderParameterServiceImpl(RenderConfigService reco, PortletRegistryService pore) {
      String ok = ((reco != null) && (pore != null)) ? "initialized sucessfully." : "pore or reco is null.";
      LOGGER.fine("Constructor - " + ok);
      this.reco = reco;
      this.pore = pore;
   }


   /* (non-Javadoc)
    * @see org.apache.pluto.driver.services.portal.PublicRenderParameterService#getPRPMapper(java.lang.String)
    */
   public PublicRenderParameterMapper getPRPMapper(String page) {
      LOGGER.fine("Getting PRP mapper for page = " + page);
      PageConfig paco = reco.getPage(page);
      PublicRenderParameterMapper prpm = new PublicRenderParameterQNameMapper(paco, pore);
      return prpm;
   }

}
