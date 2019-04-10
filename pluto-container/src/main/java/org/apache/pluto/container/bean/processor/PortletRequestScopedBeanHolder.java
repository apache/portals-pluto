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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a container for PortletRequestScoped CDI beans.
 * 
 * @author Scott Nicklous
 *
 */
public class PortletRequestScopedBeanHolder implements Serializable {
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortletRequestScopedBeanHolder.class);
   private static final boolean isTrace = LOG.isTraceEnabled();
   
   private static final long serialVersionUID = 6014843414216617217L;
   
   // The ThreadLocal manages the holders so that there is one holder per thread.
   private static final ThreadLocal<PortletRequestScopedBeanHolder> holders =
         new ThreadLocal<PortletRequestScopedBeanHolder>();

   private class BeanInstance<T> implements Serializable {
      private static final long serialVersionUID = -4173708394115905180L;
      CreationalContext<T>    crco;
      T                       instance;
   }
   
   // Each instance of the bean holder gets its own map.
   // Key: Bean Type, Value: Structure containing CreationalContext and the specific
   // bean instance.
   private Map<Contextual<?>, BeanInstance<?>> beans = 
         new ConcurrentHashMap<Contextual<?>, BeanInstance<?>>();
   
   /**
    * private constructor
    */
   private PortletRequestScopedBeanHolder() {
   }

   /**
    * Sets the portlet request bean holder in a ThreadLocal object for the given 
    * portlet session. If no bean holder exists in the session, a new one is created.
    */
   public static void setBeanHolder() {
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Setting portlet request bean holder.");
         txt.append(" ThreadId=").append(Thread.currentThread().getId());
         LOG.trace(txt.toString());
      }

      PortletRequestScopedBeanHolder holder = new PortletRequestScopedBeanHolder();
      holders.set(holder);
   }
   
   /**
    * Removes the bean holder for the current request. Deletes all beans contained therein.
    * If response is provided, the beans are deserialized and stored.
    * 
    */
   public static void removeBeanHolder() {
      
      PortletRequestScopedBeanHolder bh = getBeanHolder();
      if (bh != null) {
         bh.removeAll();
      }
      holders.remove();

      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Removed portlet request bean holder.");
         txt.append(" ThreadId=").append(Thread.currentThread().getId());
         LOG.trace(txt.toString());
      }
   }
   
   /**
    * Returns the portlet session bean holder that was set for the thread.
    * 
    * @return
    */
   public static PortletRequestScopedBeanHolder getBeanHolder() {
      return holders.get();
   }
   
   /**
    * Removes the bean holder for the current thread and
    * returns the removed instance to the caller.
    * 
    * @return  the removed bean holder
    */
   public static PortletRequestScopedBeanHolder deregister() {
      PortletRequestScopedBeanHolder holder = holders.get();
      holders.remove();
      return holder;
   }
   
   /**
    * Registers the provided bean holder for the current thread.
    * 
    * @param holder the bean holder to register
    */
   public static void register(PortletRequestScopedBeanHolder holder) {
      holders.set(holder);
   }

   /**
    * Returns existing instance of object, or null if no instance exists.
    * 
    * @param bean    The bean type
    * @return        The bean instance
    */
   @SuppressWarnings("unchecked")
   public <T> T getBean(Contextual<T> bean) {
      BeanInstance<?> bi = beans.get(bean);
      return (bi == null) ? null : (T) bi.instance;
   }
   
   /**
    * Returns an instance for the contextual type. If no existing bean is available,
    * a new instance is created.
    * 
    * @param bean       Contextual type (Bean) for which an instance is desired
    * @return           The instance, or null if none exists
    */
   @SuppressWarnings("unchecked")
   public <T> T getBean(Contextual<T> bean, CreationalContext<T> crco) {
      BeanInstance<?> bi = beans.get(bean);
      
      if (bi == null) {
         
         // No bean available, so create one.
         
         BeanInstance<T> newbi = new BeanInstance<T>();
         newbi.crco = crco;
         newbi.instance = bean.create(crco);
         bi = newbi;
         beans.put(bean, newbi);

         if (isTrace) {
            StringBuilder txt = new StringBuilder(80);
            txt.append("Created bean: ");
            txt.append(((Bean<?>) bean).getBeanClass().getSimpleName());
            LOG.trace(txt.toString());
         }

      }
  
      return (T) bi.instance;
   }
   
   /**
    * Removes & destroys the given bean
    * @param bean
    */
   @SuppressWarnings("unchecked")
   protected <T> void remove(Contextual<T> bean) {
      BeanInstance<?> bi = beans.get(bean);
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder(80);
         txt.append("Removing portlet request scoped bean: ");
         if (bean instanceof Bean<?>) {
            Bean<?> b = (Bean<?>) bean;
            txt.append(b.getBeanClass().getSimpleName());
         }
         if (bi == null) {
            txt.append(", instance is null.");
         }
         LOG.trace(txt.toString());
      }

      if (bi != null) {
         beans.remove(bean);
         bi.crco.release();
         bean.destroy((T)bi.instance, (CreationalContext<T>)bi.crco);
      }
   }
   
   /**
    * Remove & destroy all beans. 
    * 
    * @param   resp     The state aware response
    */
   protected void removeAll() {
      for (Contextual<?> bean : beans.keySet()) {
         remove(bean);
      }
   }
}
