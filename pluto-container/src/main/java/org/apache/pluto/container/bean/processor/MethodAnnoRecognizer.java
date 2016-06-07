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

import java.lang.annotation.Annotation;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;

import eu.infomas.annotation.AnnotationDetector;

/**
 * Uses the annotation detector to find the portlet method annotations.
 * 
 * @author Scott Nicklous
 * 
 */
public class MethodAnnoRecognizer implements AnnotationDetector.MethodReporter {
   private static final Logger  LOGGER  = Logger.getLogger(MethodAnnoRecognizer.class.getName());
   private static final boolean isDebug = LOGGER.isLoggable(Level.FINE);
   private static final boolean isTrace = LOGGER.isLoggable(Level.FINEST);
   
   AnnotationDetector ad;


   public MethodAnnoRecognizer() {
      ad = new AnnotationDetector(this);
   }

   @SuppressWarnings("unchecked")
   @Override
   public Class<? extends Annotation>[] annotations() {
      return new Class[] { HeaderMethod.class, ActionMethod.class, EventMethod.class, RenderMethod.class,
            ServeResourceMethod.class };
   }

   @Override
   public void reportMethodAnnotation(Class<? extends Annotation> anno, String className, String methName) {
      if (isDebug) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Found: ").append(anno.getSimpleName());
         txt.append(", class name: ").append(className);
         txt.append(", method name: ").append(methName);
         LOGGER.fine(txt.toString());
      }
   }

}
