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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.portlet.MutablePortletParameters;
import javax.portlet.PortletParameters;

import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletURLProvider.ParamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Scott Nicklous
 *
 */
public abstract class PortletParametersImpl implements PortletParameters {
   private static final Logger   LOGGER     = LoggerFactory.getLogger(PortletParametersImpl.class);
   //private static final boolean  isDebug    = LOGGER.isDebugEnabled();
   private static final boolean  isTrace    = LOGGER.isTraceEnabled();
   
   protected final PortletURLProvider  urlProvider;
   protected final String              windowId;
   protected final ParamType           type;

   protected final Map<String, String[]>  params;
   
   /**
    * Regular constructor used by extending classes for instantiation.
    * @param urlProvider
    * @param windowId
    * @param type
    */
   protected PortletParametersImpl(PortletURLProvider urlProvider, String windowId, ParamType type) {
      this.urlProvider = urlProvider;
      this.windowId = windowId;
      this.type = type;
      this.params = this.urlProvider.getParameterMap(windowId, type);
      if (isTrace) {
         LOGGER.debug("Created PortletParameters object for window: " + windowId + ", Type: " + type);
      }
   }
   
   /**
    * Copy constructor used when cloning. Use of this constructor disconnects the 
    * object from the underlying URL provider.
    * 
    * @param params
    * @param windowId
    * @param type
    */
   protected PortletParametersImpl(Map<String, String[]> params, String windowId, ParamType type) {
      this.urlProvider = null;
      this.type = type;
      this.windowId = windowId;
      
      this.params = new HashMap<String, String[]>();
      for (String name : params.keySet()) {
         this.params.put(name, params.get(name).clone());
      }
   }
   
   /**
    * Throws exception if argument is null.
    * @param msg
    * @param val
    */
   protected void checkNull(String msg, Object val) {
      if (val == null) {
         throw new IllegalArgumentException("Argument " + msg + " cannot be null.");
      }
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#getValue(java.lang.String)
    */
   public String getValue(String name) {
      checkNull("name", name);
      String[] vals = params.get(name);
      String val = (vals == null || vals.length == 0) ? null : vals[0];
      if (isTrace) {
         LOGGER.debug("Name: " + name + ", Value: " + val);
      }
      return val;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#getNames()
    */
   public Set<String> getNames() {
      HashSet<String> names = new HashSet<String>();
      for (String name : params.keySet()) {
         names.add(name);
      }
      if (isTrace) {
         LOGGER.debug("Parameter Names: " + names.toString());
      }
      return names;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#getValues(java.lang.String)
    */
   public String[] getValues(String name) {
      checkNull("name", name);
      String[] vals = (params.get(name) == null) ? null : params.get(name).clone();
      if (isTrace) {
         LOGGER.debug("Name: " + name + ", Values: " + Arrays.toString(vals));
      }
      return vals;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#isEmpty()
    */
   public boolean isEmpty() {
      boolean e = params.isEmpty();
      if (isTrace) {
         LOGGER.debug("Parameters is empty: " + e);
      }
      return e;
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#size()
    */
   public int size() {
      return params.size();
   }

   /* (non-Javadoc)
    * @see javax.portlet.PortletParameters#mutableClone()
    */
   public MutablePortletParameters clone() {
      if (isTrace) {
         LOGGER.debug("Window ID: " + windowId + ", ParameterType: " + type);
      }

      // create a mutable clone, breaking link to the underlying URL provider.
      MutablePortletParametersImpl mpp = new MutablePortletParametersImpl(params, windowId, type);
      
      return mpp;
   }

}
