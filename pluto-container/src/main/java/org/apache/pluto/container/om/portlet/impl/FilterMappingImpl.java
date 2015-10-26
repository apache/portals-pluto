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


package org.apache.pluto.container.om.portlet.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.pluto.container.om.portlet.FilterMapping;

/**
 * @author Scott Nicklous
 *
 */
public class FilterMappingImpl implements FilterMapping {
   
   private String filterName;
   
   ArrayList<String> portletNames = new ArrayList<String>();
   
   /**
    * Copy constructor
    * @param fm
    */
   public FilterMappingImpl(FilterMapping fm) {
      this.filterName = fm.getFilterName();
      this.portletNames.addAll(fm.getPortletNames());
   }
   
   /**
    * Constructor
    * @param filterName the filter name
    */
   public FilterMappingImpl(String filterName) {
      this.filterName = filterName;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.FilterMapping#getFilterName()
    */
   @Override
   public String getFilterName() {
      return filterName;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.FilterMapping#getPortletNames()
    */
   @Override
   public List<String> getPortletNames() {
      return new ArrayList<String>(portletNames);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.FilterMapping#addPortletName(java.lang.String)
    */
   @Override
   public void addPortletName(String portletName) {
      portletNames.add(portletName);
   }

}
