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
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class recognizes "interesting" classes and methods by their annotations and
 * verifies the method signatures. 
 * 
 * @author Scott Nicklous
 *
 */
public abstract class AnnotationRecognizer {
   private static final Logger LOG = LoggerFactory.getLogger(AnnotationRecognizer.class);
   private static final boolean isDebug = LOG.isDebugEnabled();
   private static final boolean isTrace = LOG.isTraceEnabled();
   

   protected final Set<Class<? extends Annotation>> classAnnotations;
   protected final Map<Class<? extends Annotation>, List<MethodDescription>> descriptions;
   
   // Holds deployment error descriptions and other information for display.
   protected final ConfigSummary summary;

   
   protected AnnotationRecognizer(Set<Class<? extends Annotation>> cla, 
         Map<Class<? extends Annotation>, List<MethodDescription>> descriptions,
         ConfigSummary summary) {
      this.classAnnotations = cla;
      this.descriptions = descriptions;
      this.summary = summary;
   }
   
   /**
    * Returns the annotation found if the specified annotation is in the specified Set
    * and <code>null</code> if not.
    * 
    * @param clsSet     Set containing candidate annotations
    * @param anno       Annotation to be checked
    * @return           the annotation, if annotation is contained in Set, otherwise null
    */
   private Class<? extends Annotation> setContains(Set<Class<? extends Annotation>> clsSet, Annotation anno) {
      for (Class<? extends Annotation> cls : clsSet) {
         if (anno.annotationType().isAssignableFrom(cls)) {
            return cls;
         }
      }
      return null;
   }
   
   /**
    * Checks annotations on an input AnnotatedType. Any portlet-related annotation
    * data found is stored as configuration data.
    * 
    * The methods on the annotated type are scanned for relevant annotations as well. If a 
    * portlet-related method annotation is found, the method and bean instance is stored.
    * 
    * A class can have multiple portlet annotations, but they all must be for the same portlet.
    *  
    * @param   aType    The type to check
    * @throws  InvalidAnnotationException    If multiple portlet annotations don't have 
    *                                        the same portlet names.   
    */
   @SuppressWarnings({ "unchecked", "rawtypes" })
   public void checkAnnotatedType(ProcessAnnotatedType pat) throws InvalidAnnotationException {
      AnnotatedType<?> aType = pat.getAnnotatedType();
      try {
         
         // Process the class annotations
         
         Set<Annotation> annos = aType.getAnnotations();
         for (Annotation anno : annos) {
            if (setContains(classAnnotations, anno) != null) {
               if (isDebug) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Found Annotation: ").append(anno.toString());
                  txt.append(", portlet name: ").append(getDisplayNames(anno));
                  LOG.debug(txt.toString());
               }
               AnnotatedType<?> ret = handleClassAnnotation(anno, aType);
               if (ret != null) {
                  pat.setAnnotatedType(ret);
               }
            }
         }
         
      } catch (Exception e) {
         
         // The rest of the possible exceptions are unexpected, so someone will
         // have to analyze a stack trace.
         
         StringBuilder txt = new StringBuilder("Error processing annotations for ");
         txt.append(aType.toString());
         throw new InvalidAnnotationException(txt.toString(), e); 
      }
   }
   
   /**
    * recognizes and registers all portlet method annotations for the given class.
    * 
    * @param aClass  the annotated class 
    */
   protected void checkForMethodAnnotations(Class<?> aClass) {
      String typeName = aClass.getCanonicalName();
      
      // Get the annotated methods and handle them
      
      for (Method meth : aClass.getMethods()) {
         for (Annotation anno : meth.getAnnotations()) {
            Class<? extends Annotation> keyAnno = 
                  setContains(descriptions.keySet(), anno);
            if (keyAnno != null) {
               
               // Get the valid method descriptions for this annotation
               
               List<MethodDescription> descs = descriptions.get(keyAnno);
               assert descs != null;
               assert descs.size() > 0;
               
               // try to find the matching method description
               
               MethodDescription matchingDesc = null;
               StringBuilder errtxt = new StringBuilder(128);
               String sep = "   ";
               for (MethodDescription desc : descs) {
                  if (desc.isMethodMatched(meth)) {
                     matchingDesc = desc;
                     break;
                  } else {
                     errtxt.append(sep).append(desc.getExpectedSignature(true));
                     sep = "\n   ";
                  }
               }

               if (isTrace) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("For method annotation: ").append(anno.annotationType().getSimpleName());
                  txt.append(" on class: ").append(typeName);
                  txt.append(", method: ").append(meth.getName());
                  if (matchingDesc != null) {
                     txt.append(", recognized type: ").append(matchingDesc.getType());
                     txt.append(", signature variant: ").append(matchingDesc.getVariant());
                  } else {
                     txt.append(", No match found. Error string:\n");
                     txt.append(errtxt);
                  }
                  LOG.trace(txt.toString());
               }

               if (matchingDesc != null) {
                  
                  // Found a matching method, so handle.
                  
                  handleMethod(anno, aClass, meth, matchingDesc);
               } else {
                  
                  // Method doesn't match any of the descriptions. 
                  // this might occur when someone makes a mistake with configuration,
                  // so handle gracefully.
                  
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Unrecognized method annotation: ")
                     .append(anno.annotationType().getSimpleName());
                  txt.append(", Class: ").append(typeName);
                  txt.append(", Method: ").append(meth.getName());
                  txt.append("\n").append(errtxt);
                  LOG.debug(txt.toString());
                  
                  // Store the error for each portlet name in array 
                  for (String n : getDisplayNames(anno)) {
                     summary.addErrorString(n, txt.toString());
                  }
               }
            }
         }
      }

   }

   /**
    * extracts array of portlet names from the annotation
    * 
    * @param anno    the annotation
    * @return        array of names
    */
   protected String[] getDisplayNames(Annotation anno) {
      String[] portletNames = {"unknown"};
      try {
         Method getPN = anno.getClass().getMethod("portletName");
         String[] annoNames = new String[] {(String)getPN.invoke(anno)};
         if (annoNames[0] != null && annoNames[0].length() > 0) {
            portletNames = annoNames;
         }
      } catch(Exception e) {
         try {
            Method getPN = anno.getClass().getMethod("portletNames");
            String[] names = (String[])getPN.invoke(anno);
            if (names != null && names.length > 0) {
               portletNames = names;
            }
         } catch(Exception e2) {
            try {
               Method getPN = anno.getClass().getMethod("value");
               String[] annoNames = new String[] {(String)getPN.invoke(anno)};
               if (annoNames[0] != null && annoNames[0].length() > 0) {
                  portletNames = annoNames;
               }
            } catch (Exception e3) {}
         }
      }
      return portletNames;
   }

   /**
    * Extracts data from the class annotation and stores it for later use.
    * 
    * @param anno
    * @throws InvalidAnnotationException
    */
   protected abstract AnnotatedType<?> handleClassAnnotation(Annotation anno, AnnotatedType<?> aType) 
         throws InvalidAnnotationException;

   /**
    * Extracts and stores relevant information from the specified annotation, bean
    * class, and Method.
    *  
    * @param anno
    * @param beanClass
    * @param meth
    * @throws InvalidAnnotationException  If the specified information is inconsistent
    *                                     or if a duplicate method has already been stored.
    */
   protected abstract void handleMethod(Annotation anno, Class<?> beanClass,
         Method meth, MethodDescription desc);

   /**
    * To be called by the CDI extension afterDeploymentValidation method to
    * activate the custom scoped beans by providing a bean manager.
    *  
    * @param bm      BeanManager needed to activate the beans.
    */
   protected abstract void activateCustomScopes(BeanManager bm);
}
