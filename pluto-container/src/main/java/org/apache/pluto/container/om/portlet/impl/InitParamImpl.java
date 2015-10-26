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
import java.util.Locale;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.InitParam;

/**
 * Init parameters for filters and portlets
 * 
 * @author Scott Nicklous
 *
 */
public class InitParamImpl implements InitParam {
   
   private String name;
   private String value;
   private final List<Description> descs = new ArrayList<Description>();
   
   /**
    * Copy Constructor
    * 
    * @param ipi
    */
   public InitParamImpl(InitParam ipi) {
      name = ipi.getParamName();
      value = ipi.getParamValue();
      for (Description desc : ipi.getDescriptions()) {
         descs.add(new DescriptionImpl(desc));
      }
   }
   
   /**
    * Constructor
    * @param name    init parameter name
    * @param value   init parameter value
    */
   public InitParamImpl(String name, String value) {
      this.name = name;
      this.value = value;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.InitParam#getParamName()
    */
   @Override
   public String getParamName() {
      return name;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.InitParam#getParamValue()
    */
   @Override
   public String getParamValue() {
      return value;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.InitParam#setParamValue(java.lang.String)
    */
   @Override
   public void setParamValue(String paramValue) {
      this.value = paramValue;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.InitParam#getDescription(java.util.Locale)
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
    * @see org.apache.pluto.container.om.portlet.InitParam#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.InitParam#addDescription(org.apache.pluto.container.om.portlet.Description)
    */
   @Override
   public void addDescription(Description desc) {
      descs.add(desc);
   }

}
