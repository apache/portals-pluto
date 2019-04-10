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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Contains a summary of the configuration along with configuration errors
 * and warnings for display purposes only.
 * 
 * @author Scott
 *
 */
public class ConfigSummary {
   
   // List of PortletSessionScoped beans with APPLICATION_SCOPE
   List<PortletSessionScopedAnnotatedType> appScopedTypes = new ArrayList<PortletSessionScopedAnnotatedType>();
   
   // List of RequestScoped beans
   List<PortletRequestScopedAnnotatedType> reqScopedTypes = new ArrayList<PortletRequestScopedAnnotatedType>();

   // Per-class error messages for portlet session scoped bean deployment problems
   private final Map<Class<?>, String> badSessionBeans = new HashMap<Class<?>, String>();

   // Per-class error messages for render state scoped bean deployment problems
   private final Map<Class<?>, String> badStateBeans = new HashMap<Class<?>, String>();
   
   // Per-portlet error messages for deployment problems. Key is the portlet name.
   private final Map<String, List<String>> errors = new TreeMap<String, List<String>>();
   
   /**
    * Stores an error string to document deployment problems.
    * 
    * @param portletName
    * @param msg
    */
   public void addErrorString(String portletName, String msg) {
      assert portletName != null && portletName.length() > 0;
      if (!errors.containsKey(portletName)) {
         errors.put(portletName, new ArrayList<String>());
      }
      errors.get(portletName).add(msg);
   }
   
   /**
    * Returns the error strings associated with the given portlet name.
    * 
    * @param portletName
    * @return
    */
   public List<String> getErrorStrings(String portletName) {
      assert portletName != null && portletName.length() > 0;
      List<String> errs = new ArrayList<String>();
      List<String> perrs = errors.get(portletName);
      if (perrs != null) {
         errs.addAll(perrs);
      }
      return errs;
   }
   
   /**
    * Returns a list of all portlet names with deployment problems.
    * 
    * @return
    */
   public List<String> getPortletsWithErrors() {
      return new ArrayList<String>(errors.keySet());
   }
   
   /**
    * Stores an error string to document render state scoped bean deployment problems.
    * 
    * @param portletName
    * @param msg
    */
   public void addStateBeanErrorString(Class<?> cls, String msg) {
      badStateBeans.put(cls, msg);
   }
   
   /**
    * Returns the error strings associated with the given state scoped bean.
    * 
    * @param portletName
    * @return
    */
   public String getStateBeanErrorString(Class<?> bean) {
      return badStateBeans.get(bean);
   }
   
   /**
    * Returns a list of all render state scoped bean classes with deployment problems.
    * 
    * @return
    */
   public List<Class<?>> getStateBeansWithErrors() {
      return new ArrayList<Class<?>>(badStateBeans.keySet());
   }
   
   /**
    * Stores an error string to document portlet session scoped bean deployment problems.
    * 
    * @param portletName
    * @param msg
    */
   public void addSessionBeanErrorString(Class<?> cls, String msg) {
      badSessionBeans.put(cls, msg);
   }
   
   /**
    * Returns the error strings associated with the given session scoped bean.
    * 
    * @param portletName
    * @return
    */
   public String getSessionBeanErrorString(Class<?> bean) {
      return badSessionBeans.get(bean);
   }
   
   /**
    * Returns a list of all portlet session scoped bean classes with deployment problems.
    * 
    * @return
    */
   public List<Class<?>> getSessionBeansWithErrors() {
      return new ArrayList<Class<?>>(badSessionBeans.keySet());
   }
   
   /**
    * Adds a PortletSessionScoped bean with APPLICATION_SCOPE to list
    * for test / display purposes. These annotated types have been
    * modified by deleting the PortletSessionScoped annotation and adding 
    * a SessionScoped annotation. 
    * 
    * @param type
    */
   public void addAppScopedType(PortletSessionScopedAnnotatedType type) {
      appScopedTypes.add(type);
   }
   
   /**
    * Returns list of all portlet session Scoped beans with APPLICATION_SCOPE
    * @return
    */
   public List<PortletSessionScopedAnnotatedType> getAppScopedTypes() {
      return appScopedTypes;
   }

   /**
    * Returns list of all request scoped beans
    * @return the reqScopedTypes
    */
   public List<PortletRequestScopedAnnotatedType> getReqScopedTypes() {
      return reqScopedTypes;
   }

   /**
    * Adds a request scoped bean to the summary list
    * @param reqScopedTypes the reqScopedTypes to set
    */
   public void addReqScopedType(PortletRequestScopedAnnotatedType type) {
      reqScopedTypes.add(type);
   }

}
