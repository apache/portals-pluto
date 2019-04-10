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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.mvc.RedirectScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Configuration for RedirectScoped CDI beans.
 * 
 * @author Scott Nicklous
 * @author Neil Griffin
 *
 */
public class RedirectScopedConfig implements Serializable {
   private static final long serialVersionUID = 4387223464722335532L;
   private final Logger LOG = LoggerFactory.getLogger(RedirectScopedConfig.class);
   private final boolean isTrace = LOG.isTraceEnabled();
   
   
   // Contains a sorted list of RedirectScoped annotated class names. The sorted list
   // is used to generate indexes for the assigned render parameter names.
   private final List<String> sortedAnnotatedClassNames = new ArrayList<>();
   
   // Description for the RedirectScoped bean
   private class PSSDescription implements Serializable {
      private static final long serialVersionUID = 3289471768384711112L;
      RedirectScoped          pssAnno;
   }
   
   // Maps the bean contextual to the annotation. The bean contextual is obtained
   // during the activation process after all beans have been discovered.
   // Note that synchronization is not needed since the map is only changed during the
   // bean scanning phase.
   private final Map<Contextual<?>, PSSDescription> context2Anno = new HashMap<>();

   // Maps the bean class to the corresponding annotation. The entries are set
   // while the extension is processing annotated types.
   // Note that synchronization is not needed since the map is only changed during the
   // bean scanning phase.
   private final Map<Class<?>, PSSDescription> class2Anno = new HashMap<>();
   
   /**
    * Called by the CDI extension during the scanning phase to add information about 
    * a <code>{@literal @}RedirectScoped</code> bean.
    * 
    * @param beanClass     The bean class
    * @param anno          The annotation
    */
   public void addAnnotation(Class<?> beanClass, RedirectScoped anno) {
      PSSDescription desc = new PSSDescription();
      desc.pssAnno = anno;
      class2Anno.put(beanClass, desc);
   }
   
   /** 
    * Gets the concrete contextual for the bean and puts it into the context map.
    * Called after bean discovery during the activation process.
    * Finishes up the configuration process and provides a debug summary.
    * 
    * @param bm      The bean manager
    */
   public void activate(BeanManager bm) {
      
      // The assigned render parameters are based on the alphabetic order of the PSS bean 
      // class names, so generate such a list.
      
      for (Class<?> c : class2Anno.keySet()) {
         sortedAnnotatedClassNames.add(c.getCanonicalName());
      }
      Collections.sort(sortedAnnotatedClassNames);
      
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
         txt.append("RedirectScopedBeanHolder configuration.");
         txt.append(" Annotated Beans: ");
         txt.append(getConfigAsString());
         LOG.debug(txt.toString());
      }
   }
   
   /**
    * Returns the redirect scoped annotated classes.
    * <p>
    * Used for test / validation purposes.
    * 
    * @return  Set of annotated classes
    */
   public Set<Class<?>> getBeanClasses() {
      return class2Anno.keySet();
   }
   
   /**
    * Returns a redirect scoped bean summary for display
    * 
    * @return  The configuration summary string
    * 
    */
   public String getConfigAsString() {
      StringBuilder txt = new StringBuilder(128);
      for (Class<?> c : class2Anno.keySet()) {
         txt.append("\n\tClass: ").append(c.getCanonicalName());
      }
      return txt.toString();
   }
}
