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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Map for portlet session scoped beans that allows for two keys: the window ID, and the 
 * contextual object whose instance is to be obtained. This map is stored in the portlet
 * session with application scope and contains PortletSessionScoped beans of both portlet
 * scope and application scope.
 * 
 * @author Scott Nicklous
 *
 */
public class PortletSessionScopedBeanMap implements HttpSessionBindingListener, Serializable {
   private static final long serialVersionUID = -4770245090803443972L;
   
   private static final Logger LOG = LoggerFactory.getLogger(PortletSessionScopedBeanMap.class);
   private static final boolean isDebug = LOG.isDebugEnabled();
   private static final boolean isTrace = LOG.isTraceEnabled();
   
   // Used in the bean map to designate application scoped beans.
   private static final String WINDOW_ID_APPLICATION = "application";
   

   private class BeanInstance<T> implements Serializable {
      private static final long serialVersionUID = -2094530892049932082L;
      CreationalContext<T>    crco;
      T                       instance;
   }
   
   // Map of window ID to map of contextuals to instances
   private final Map<String, Map<Contextual<?>, BeanInstance<?>>> beans = 
         new HashMap<String, Map<Contextual<?>, BeanInstance<?>>>();

   
   /**
    * Adds a bean instance with associated creational context to the store for the
    * given contextual object (bean).
    * 
    * @param id            The window ID
    * @param bean          The bean type
    * @param crco          The creational context
    * @param instance      The bean instance
    */
   public <T> void putBeanInstance(String id, Contextual<T> bean, CreationalContext<T> crco, T instance) {
      
      BeanInstance<T> bi = new BeanInstance<T>();
      bi.crco = crco;
      bi.instance = instance;
      
      if (id == null) {
         id = WINDOW_ID_APPLICATION;
      }

      boolean addedMap = false;
      synchronized (beans) {
         Map<Contextual<?>, BeanInstance<?>> beanMap = beans.get(id);
         if (beanMap == null) {
            beanMap = new HashMap<Contextual<?>, BeanInstance<?>>();
            beans.put(id, beanMap);
            addedMap = true;
         }
         beanMap.put(bean, bi);
      }
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Added bean: ");
         if (bean instanceof Bean<?>) {
            Bean<?> b = (Bean<?>) bean;
            txt.append(b.getBeanClass().getSimpleName());
         } else {
            txt.append("Contextual");
         }
         txt.append(", window ID: ").append(id);
         txt.append(", added new map: ").append(addedMap);
         LOG.debug(txt.toString());
      }
   }
   
   @SuppressWarnings("unchecked")
   public <T> T getBeanInstance(String id, Contextual<T> bean) {
      T instance = null;
      
      if (id == null) {
         id = WINDOW_ID_APPLICATION;
      }

      boolean gotMap = false;
      synchronized(beans) {
         Map<Contextual<?>, BeanInstance<?>> beanMap = beans.get(id);
         if (beanMap != null) {
            gotMap = true;
            BeanInstance<?> bi = beanMap.get(bean);
            if (bi != null) {
               instance = (T) bi.instance;
            }
         }
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Window ID: ").append(id);
         txt.append(", retrieved map: ").append(gotMap);
         txt.append(", instance null: ").append(instance == null);
         LOG.debug(txt.toString());
      }
      
      return instance;
   }
   
   /**
    * Removes & destroys the given bean from the given bean map
    * @param bean
    */
   @SuppressWarnings("unchecked")
   private <T> void remove(String id, Map<Contextual<?>, BeanInstance<?>> beanMap, Contextual<T> bean) {
      BeanInstance<?> bi = beanMap.get(bean);
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Removing bean: ");
         if (bean instanceof Bean<?>) {
            Bean<?> b = (Bean<?>) bean;
            txt.append(b.getBeanClass().getSimpleName());
         }
         txt.append(", window ID: ").append(id);
         if (bi == null) {
            txt.append(", instance is null.");
         }
         LOG.debug(txt.toString());
      }

      if (bi != null) {
         beans.remove(id);
         bi.crco.release();
         bean.destroy((T)bi.instance, (CreationalContext<T>)bi.crco);
      }
   }

   /**
    * Session binding listener method - binding to session
    * 
    * @param evt
    */
   @Override
   public void valueBound(HttpSessionBindingEvent evt) {
   }

   /**
    * Session binding listener method - unbinding from session. 
    * This occurs only when the session times out or is destroyed (in our case).
    * 
    * @param evt
    */
   @Override
   public void valueUnbound(HttpSessionBindingEvent evt) {
      if (isTrace) {
         LOG.trace("PortletSessionBeanHolder unbound from session. ID=" + evt.getName());
      }
      
      synchronized(beans) {
         for (String id : beans.keySet()) {
            Map<Contextual<?>, BeanInstance<?>> beanMap = beans.get(id);
            for (Contextual<?> bean : beanMap.keySet()) {
               remove(id, beanMap, bean);
            }
         }
         beans.clear();
      }
   }

   public void removeByWindowId(String windowId) {

      if (isTrace) {
         LOG.trace("Removing beans associated with windowId=" + windowId);
      }

      synchronized(beans) {
         for (String curWindowId : beans.keySet()) {
         	if (curWindowId.equals(windowId)) {
               Map<Contextual<?>, BeanInstance<?>> beanMap =
                   beans.get(curWindowId);
               for (Contextual<?> bean : beanMap.keySet()) {
                  remove(curWindowId, beanMap, bean);
               }
            }
         }
      }
   }
}
