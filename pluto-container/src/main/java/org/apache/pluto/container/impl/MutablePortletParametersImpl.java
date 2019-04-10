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

package org.apache.pluto.container.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import javax.portlet.MutablePortletParameters;
import javax.portlet.PortletParameters;

import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletURLProvider.ParamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nick
 * 
 */
public class MutablePortletParametersImpl extends
      PortletParametersImpl implements MutablePortletParameters {
   private static final Logger   LOGGER     = LoggerFactory.getLogger(MutablePortletParametersImpl.class);
   private static final boolean  isTrace    = LOGGER.isTraceEnabled();

   /**
    * Constructor used by extending classes for instantiation
    * 
    * @param urlProvider
    * @param windowId
    * @param type
    */
   protected MutablePortletParametersImpl(PortletURLProvider urlProvider,
         String windowId, ParamType type) {
      super(urlProvider, windowId, type);
   }
   
   /**
    * Copy constructor used during cloning
    * 
    * @param params
    * @param windowId
    * @param type
    */
   protected MutablePortletParametersImpl(Map<String, String[]> params, String windowId, ParamType type) {
      super(params, windowId, type);
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.MutablePortletParameters#setValue(java.lang.String,
    * java.lang.String)
    */
   public String setValue(String name, String value) {
      checkNull("name", name);
      String[] vals = params.get(name);
      String val = (vals == null) ? null : vals[0];
      
      params.put(name, new String[]{value});
      
      // If we're not a clone, update source URL 
      if (urlProvider != null) {
         urlProvider.setParameter(windowId, name, type, new String[]{value});
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(windowId)
            .append(", Name: ").append(name)
            .append(", Type: ").append(type)
            .append(", Old Value: ").append(val)
            .append(", New Value: ").append(value);
         LOGGER.debug(txt.toString());
      }
      
      return val;
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.MutablePortletParameters#setValues(java.lang.String,
    * java.lang.String[])
    */
   public String[] setValues(String name, String... values) {
      checkNull("name", name);
      String[] vals = params.get(name);
      
      if (values == null) {
         values = new String[]{null};
      }
      
      params.put(name, values.clone());
      
      // If we're not a clone, update source URL 
      if (urlProvider != null) {
         urlProvider.setParameter(windowId, name, type, values.clone());
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(windowId)
            .append(", Name: ").append(name)
            .append(", Type: ").append(type)
            .append(", Old Values: ").append(Arrays.toString(vals))
            .append(", New Values: ").append(Arrays.toString(values));
         LOGGER.debug(txt.toString());
      }
      
      return vals;
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * javax.portlet.MutablePortletParameters#removeParameter(java.lang.String)
    */
   public boolean removeParameter(String name) {
      checkNull("name", name);
      boolean isContains = params.containsKey(name);
      
      if (isContains) {
         params.remove(name);

         // If we're not a clone, update source URL 
         if (urlProvider != null) {
            urlProvider.removeParameter(windowId, name, type);
         }
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(windowId)
            .append(", Name: ").append(name)
            .append(", Type: ").append(type)
            .append(", Removed: ").append(isContains);
         LOGGER.debug(txt.toString());
      }
      
      return isContains;
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * javax.portlet.MutablePortletParameters#set(javax.portlet.PortletParameters
    * )
    */
   public MutablePortletParameters set(PortletParameters inParams) {
      checkNull("params", inParams);
      MutablePortletParameters oldparms = this.clone();
      int ctr = 0;
      
      // delete all parameters from this map not contained in input map
      HashSet<String> remNames = new HashSet<String>(params.keySet());
      boolean removed = params.keySet().retainAll(inParams.getNames());
      
      if (removed && urlProvider != null) {
         remNames.removeAll(inParams.getNames());
         for(String name : remNames) {
            urlProvider.removeParameter(windowId, name, type);
         }
      }
      
      for (String name : inParams.getNames()) {
         String[] vals = inParams.getValues(name).clone();
         ctr++;
         params.put(name, vals);

         if (urlProvider != null) {
            urlProvider.setParameter(windowId, name, type, vals);
         }
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(windowId)
            .append(", Removed values from old map:  ").append(removed)
            .append(", set ").append(ctr).append(" values.");
         LOGGER.debug(txt.toString());
      }
 
      return oldparms;
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * javax.portlet.MutablePortletParameters#add(javax.portlet.PortletParameters
    * )
    */
   public MutablePortletParameters add(PortletParameters inParams) {
      checkNull("params", inParams);
      MutablePortletParameters oldparms = this.clone();
      int ctr = 0;
      
      for (String name : inParams.getNames()) {
         String[] vals = inParams.getValues(name).clone();
         ctr++;
         params.put(name, vals);

         if (urlProvider != null) {
            urlProvider.setParameter(windowId, name, type, vals);
         }
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(windowId)
            .append(", added ").append(ctr).append(" values.");
         LOGGER.debug(txt.toString());
      }
 
      return oldparms;
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.portlet.MutablePortletParameters#clear()
    */
   public void clear() {
      int ctr = params.size();

      if (urlProvider != null) {
         for (String name : params.keySet()) {
            urlProvider.removeParameter(windowId, name, type);
         }
      }
      params.clear();

      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(windowId)
            .append(", removed ").append(ctr).append(" values.");
         LOGGER.debug(txt.toString());
      }
   }

}
