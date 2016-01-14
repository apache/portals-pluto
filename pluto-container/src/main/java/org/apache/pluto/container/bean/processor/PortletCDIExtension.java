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

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Scott
 *
 */
public class PortletCDIExtension implements Extension {
   private static final Logger LOG = LoggerFactory.getLogger(PortletCDIExtension.class);
  
   
   // Holds deployment error descriptions and other information for display.
   private final ConfigSummary summary = new ConfigSummary();

   private final AnnotatedMethodStore ams = new AnnotatedMethodStore(summary);
   private final PortletAnnotationRecognizer par = new PortletAnnotationRecognizer(ams, summary);
   
   private static AnnotatedConfigBean acb = null;
   
   public static AnnotatedConfigBean getConfig() {
      return acb;
   }


   public PortletCDIExtension() {
   }
   
   void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
      LOG.debug("PortletCDIExtension - scanning.");
   }

   /**
    * examine each annotated type for portlet annotations
    * @param pat
    * @throws InvalidAnnotationException
    */
   void processType(@Observes ProcessAnnotatedType<?> pat) throws InvalidAnnotationException {
      par.checkAnnotatedType(pat);
   }
   
   /**
    * Add the context for the custom scope implementations.
    * 
    * @param abd
    */
   void addPortletSessionScopeContext(@Observes AfterBeanDiscovery abd) {
      PortletSessionScopedContext pssc = new PortletSessionScopedContext();
      abd.addContext(pssc);
      
      PortletStateScopedContext pstsc = new PortletStateScopedContext();
      abd.addContext(pstsc);
   }

   /**
    * After the bean container has validated the deployment from its point of view,
    * do some checking from the portlet point of view. Activate the portlet deployment
    * by passing in a bean manager in order to create the required portlet bean instances.
    * 
    * @param adv
    * @param bm
    * @throws InvalidAnnotationException
    */
   void afterDeploymentValidation(@Observes AfterDeploymentValidation adv, BeanManager bm)
         throws InvalidAnnotationException {
      par.activateDeployment(bm);
      
      // Done processing the annotations, so put the resulting configuration in an
      // application scoped bean to pass it to the servlet
      
      LOG.trace("Now attempting to get the AnnotatedConfigBean ...");
      Set<Bean<?>> beans = bm.getBeans(AnnotatedConfigBean.class);
      @SuppressWarnings("unchecked")
      Bean<AnnotatedConfigBean> bean = (Bean<AnnotatedConfigBean>) bm.resolve(beans);
      if (bean != null) {
         LOG.trace("Got AnnotatedConfigBean bean: " + bean.getBeanClass().getCanonicalName());
         try {
            CreationalContext<AnnotatedConfigBean> cc = bm.createCreationalContext(bean);
            acb = (AnnotatedConfigBean) bm.getReference(bean, AnnotatedConfigBean.class, cc);
            LOG.trace("Got AnnotatedConfigBean instance.");
            acb.setMethodStore(ams);
            acb.setSummary(summary);
            acb.setStateScopedConfig(par.getStateScopedConfig());
            acb.setSessionScopedConfig(par.getSessionScopedConfig());
         } catch (Exception e) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Exception getting AnnotatedConfigBean bean instance: ");
            txt.append(e.toString());
            LOG.warn(txt.toString());
         }
      } else {
         LOG.warn("AnnotatedConfigBean bean was null.");
      }
      LOG.info("Portlet CDI Extension complete. Config bean: " + acb);
   }

}
