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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.InitParam;

/**
 * A single event declaration
 * 
 * @author Scott Nicklous
 */
public class FilterImpl implements Filter {
   
   private final String filterName;
   private final ArrayList<String> lifecycles = new ArrayList<String>();
   private final List<Description> descs = new ArrayList<Description>();
   private final List<DisplayName> dispNames = new ArrayList<DisplayName>();
   private final Map<String, InitParam> initParams = new LinkedHashMap<String, InitParam>();
   private String fclass = "";
   private int ordinal;
   private boolean ordinalSet = false;
   
   
   /**
    * Copy constructor
    * @param fi
    */
   public FilterImpl(Filter fi) {
      this.filterName = fi.getFilterName();
      this.fclass = fi.getFilterClass();
      
      for (String lc : fi.getLifecycles()) {
         this.lifecycles.add(new String(lc));
      }
      for (Description desc : fi.getDescriptions()) {
         descs.add(new DescriptionImpl(desc));
      }
      for (DisplayName disp : fi.getDisplayNames()) {
         dispNames.add(new DisplayNameImpl(disp));
      }
      for (InitParam ip : fi.getInitParams()) {
         this.initParams.put(ip.getParamName(), new InitParamImpl(ip));
      }
      this.ordinal = fi.getOrdinal();
      this.ordinalSet = fi.isOrdinalSet();

   }

   /**
    * Constructor
    * @param fn   Filter name
    */
   public FilterImpl(String fn) {
      this.filterName = fn;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#getFilterName()
    */
   @Override
   public String getFilterName() {
      return filterName;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#getLifecycles()
    */
   @Override
   public List<String> getLifecycles() {
      return new ArrayList<String>(lifecycles);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#addAlias(javax.xml.namespace.QName)
    */
   @Override
   public void addLifecycle(String lc) {
      lifecycles.add(lc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#getDescription(java.util.Locale)
    */
   @Override
   public Description getDescription(Locale locale) {
      Description ret = null;
      for (Description item : descs) {
         if (item.getLocale().equals(locale)) {
            ret = new DescriptionImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#addDescription(org.apache.pluto.container.om.portlet.Description)
    */
   @Override
   public void addDescription(Description desc) {
      descs.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#getDisplayName(java.util.Locale)
    */
   @Override
   public DisplayName getDisplayName(Locale locale) {
      DisplayName ret = null;
      for (DisplayName item : dispNames) {
         if (item.getLocale().equals(locale)) {
            ret = new DisplayNameImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#getDisplayNames()
    */
   @Override
   public List<DisplayName> getDisplayNames() {
      return new ArrayList<DisplayName>(dispNames);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#addDisplayName(org.apache.pluto.container.om.portlet.DisplayName)
    */
   @Override
   public void addDisplayName(DisplayName desc) {
      dispNames.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#getFilterClass()
    */
   @Override
   public String getFilterClass() {
      return fclass;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Filter#setFilterClass(java.lang.String)
    */
   @Override
   public void setFilterClass(String filterClass) {
      fclass = filterClass;
   }

   @Override
   public InitParam getInitParam(String paramName) {
      return initParams.get(paramName);
   }

   @Override
   public List<InitParam> getInitParams() {
      return new ArrayList<InitParam>(initParams.values());
   }

   @Override
   public void addInitParam(InitParam ip) {
      initParams.put(ip.getParamName(),  ip);
   }

   /**
    * @return the ordinal
    */
   @Override
   public int getOrdinal() {
      return ordinal;
   }

   /**
    * @param ordinal the ordinal to set
    */
   @Override
   public void setOrdinal(int ordinal) {
      this.ordinal = ordinal;
      this.ordinalSet = true;
   }

   /**
    * @return the ordinalSet
    */
   @Override
   public boolean isOrdinalSet() {
      return ordinalSet;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((filterName == null) ? 0 : filterName.hashCode());
      return result;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      FilterImpl other = (FilterImpl) obj;
      if (filterName == null) {
         if (other.filterName != null) {
            return false;
         }
      } else if (!filterName.equals(other.filterName)) {
         return false;
      }
      return true;
   }

}
