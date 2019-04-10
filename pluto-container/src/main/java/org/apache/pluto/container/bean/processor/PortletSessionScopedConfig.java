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
import java.util.Set;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.PortletSession;
import javax.portlet.annotations.PortletSessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration for PortletSessionScoped CDI beans.
 * 
 * @author Scott Nicklous
 *
 */
public class PortletSessionScopedConfig  implements Serializable {
   private static final long serialVersionUID = -5333145344722804837L;
   private final Logger LOG = LoggerFactory.getLogger(PortletSessionScopedConfig.class);
   private final boolean isTrace = LOG.isTraceEnabled();
   
   
   // Maps the bean contextual to the annotation. The bean contextual is obtained
   // during the activation process after all beans have been discovered.
   // Note that synchronization is not needed since the map is only changed during the
   // bean scanning phase.
   private final Map<Contextual<?>, PortletSessionScoped> context2Anno = 
         new HashMap<Contextual<?>, PortletSessionScoped>();

   // Maps the bean class to the corresponding annotation. The entries are set
   // while the extension is processing annotated types.
   // Note that synchronization is not needed since the map is only changed during the
   // bean scanning phase.
   private final Map<Class<?>, PortletSessionScoped> class2Anno = 
         new HashMap<Class<?>, PortletSessionScoped>();
   
   /**
    * Called by the CDI extension during the scanning phase to add information about 
    * a <code>{@literal @}PortletSessionScoped</code> bean.
    * 
    * @param beanClass     The bean class
    * @param anno          The annotation
    */
   public void addAnnotation(Class<?> beanClass, PortletSessionScoped anno) {
      class2Anno.put(beanClass, anno);
   }
   
   /** 
    * Gets the concrete contextual for the bean and puts it into the context map.
    * Called after bean discovery during the activation process.
    * Finishes up the configuration process and provides a debug summary.
    * 
    * @param bm      The bean manager
    */
   public void activate(BeanManager bm) {
      
      // Activate the beans
      
      for (Class<?> cls : class2Anno.keySet()) {
         Set<Bean<?>> beans = bm.getBeans(cls);
         Bean<?> bean = bm.resolve(beans);
         assert bean != null;
         context2Anno.put(bean, class2Anno.get(cls));
      }
      
      // dump configuration data to trace
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("PortletSessionScopedBeanHolder configuration. ");
         txt.append(" AnnotatedBeans: ");
         txt.append(getConfigAsString());
         LOG.debug(txt.toString());
      }
   }
   
   /**
    * Returns the portlet session scoped annotated classes.
    * <p>
    * Used for test / validation purposes.
    * 
    * @return  Set of annotated classes
    */
   public Set<Class<?>> getBeanClasses() {
      return class2Anno.keySet();
   }
   
   /**
    * Returns a portlet session scoped bean summary for display
    * 
    * @return  The configuration summary string
    * 
    */
   public String getConfigAsString() {
      StringBuilder txt = new StringBuilder(128);
      for (Class<?> c : class2Anno.keySet()) {
         txt.append("\n\tClass: ").append(c.getCanonicalName());
         boolean ps = (class2Anno.get(c).value() == PortletSession.PORTLET_SCOPE);
         txt.append(", Portlet scoped: ").append(ps);
      }
      return txt.toString();
   }
   
   /**
    * Determines whether the given bean class is portlet or application scoped.
    * 
    * @param bean    The bean class
    * @return        <code>true</code> if the bean is portlet scoped
    */
   public Boolean isPortletScoped(Class<?> beanClass) {
      Boolean ps = null;
      for (Contextual<?> b : context2Anno.keySet()) {
         if (b instanceof Bean) {
            Bean<?> bean = (Bean<?>)b;
            if (beanClass.isAssignableFrom(bean.getBeanClass())) {
               ps = (context2Anno.get(b).value() == PortletSession.PORTLET_SCOPE);
               break;
            }
         }
      }
      return ps;
   }
   
   /**
    * Determines whether the given bean is portlet or application scoped.
    * 
    * @param bean    The bean
    * @return        <code>true</code> if the bean is portlet scoped
    */
   public Boolean isPortletScoped(Contextual<?> bean) {
      PortletSessionScoped anno = context2Anno.get(bean);
      assert anno != null;
      boolean isPS = (anno.value() == PortletSession.PORTLET_SCOPE);
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Bean: ");
         if (bean instanceof Bean<?>) {
            Bean<?> b = (Bean<?>) bean;
            txt.append(b.getBeanClass().getSimpleName());
         } else {
            txt.append("Contextual");
         }
         txt.append(", isPortletScoped: ").append(isPS);
         LOG.debug(txt.toString());
      }
      
      return isPS;
   }

}
