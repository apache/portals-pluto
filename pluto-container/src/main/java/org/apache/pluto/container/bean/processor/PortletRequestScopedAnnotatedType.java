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
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.AnnotatedConstructor;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.portlet.annotations.PortletRequestScoped;

/**
 * A wrapper for a RequestScoped annotated type 
 * that replaces the <code>{@literal @}RequestScoped</code> annotation with
 * <code>{@literal @}PortletRequestScoped</code> in order to assure that the bean
 * is scoped to the portlet request rather than to the underlying servlet request.
 * 
 * @author Scott
 *
 */
public class PortletRequestScopedAnnotatedType implements AnnotatedType<RequestScoped> {

   // to obtain annotation instances
   @RequestScoped
   @PortletRequestScoped
   private class Dummy {}  
   
   // the wrapped type.
   private final AnnotatedType<RequestScoped> aType;
   
   // The set of annotations
   private final Set<Annotation> annos = new HashSet<Annotation>();
   
   /**
    * Construct the wrapper. 
    */
   public PortletRequestScopedAnnotatedType(AnnotatedType<RequestScoped> type) {
      aType = type;
      annos.addAll(type.getAnnotations());
      annos.remove(Dummy.class.getAnnotation(RequestScoped.class));
      annos.add(Dummy.class.getAnnotation(PortletRequestScoped.class));
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.Annotated#getAnnotation(java.lang.Class)
    */
   @SuppressWarnings({"unchecked"})
   @Override
   public <U extends Annotation> U getAnnotation(Class<U> type) {
      for (Annotation a : annos) {
         if (type.equals(a.annotationType())) {
            return (U) a;
         }
      }
      return null;
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.Annotated#getAnnotations()
    */
   @Override
   public Set<Annotation> getAnnotations() {
      return new HashSet<Annotation>(annos);
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.Annotated#getBaseType()
    */
   @Override
   public Type getBaseType() {
      return aType.getBaseType();
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.Annotated#getTypeClosure()
    */
   @Override
   public Set<Type> getTypeClosure() {
      return aType.getTypeClosure();
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.Annotated#isAnnotationPresent(java.lang.Class)
    */
   @Override
   public boolean isAnnotationPresent(Class<? extends Annotation> type) {
      for (Annotation a : annos) {
         if (type.equals(a.annotationType())) {
            return true;
         }
      }
      return false;
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.AnnotatedType#getConstructors()
    */
   @Override
   public Set<AnnotatedConstructor<RequestScoped>> getConstructors() {
      return aType.getConstructors();
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.AnnotatedType#getFields()
    */
   @Override
   public Set<AnnotatedField<? super RequestScoped>> getFields() {
      return aType.getFields();
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.AnnotatedType#getJavaClass()
    */
   @Override
   public Class<RequestScoped> getJavaClass() {
      return aType.getJavaClass();
   }

   /* (non-Javadoc)
    * @see javax.enterprise.inject.spi.AnnotatedType#getMethods()
    */
   @Override
   public Set<AnnotatedMethod<? super RequestScoped>> getMethods() {
      return aType.getMethods();
   }

}
