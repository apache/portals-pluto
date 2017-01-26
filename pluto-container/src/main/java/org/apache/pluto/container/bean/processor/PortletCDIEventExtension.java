package org.apache.pluto.container.bean.processor;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AnnotatedCallable;
import javax.enterprise.inject.spi.AnnotatedConstructor;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedParameter;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ObserverMethod;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PortletCDIEventExtension implements Extension {
   
   private static final Logger LOG = LoggerFactory.getLogger(PortletCDIEventExtension.class);
   
   // To make reference to the original observers 
   private HashSet<ObserverMethod<?>> emptyObserverMethods = new HashSet<ObserverMethod<?>>();

   // Starting the scanning process 
   void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
      LOG.debug("PortletCDIEventExtension - scanning.");
   }

   // Scan all classes with javax.enterprise.event.Event field
   <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {

      final AnnotatedType<T> at = pat.getAnnotatedType();

      // Get all fields of the class
      Set<AnnotatedField<? super T>> fields = at.getFields();
      
      for (final AnnotatedField<? super T> field : fields) {
         
         if (isFieldCDIEventDefinition(field.getJavaMember())) {
            ObserverMethod<T> emptyObserverMethod = createEmptyObserverFor(field);
            emptyObserverMethods.add(emptyObserverMethod);
         }
      }      
      
      /* Scanner for observers at processing annotated types */
      
      // Get the class of annotated type
      Class<?> className = pat.getAnnotatedType().getJavaClass();
      
      // Ignore Observers from PortletCDIExtension class and PortletCDIEventExtension class only
      if(className!=null && !className.equals(PortletCDIEventExtension.class) && !className.equals(PortletCDIExtension.class)){
         
         // A set to add modified observer method
         final Set<AnnotatedMethod<? super T>> newMethods = new HashSet<AnnotatedMethod<? super T>>();
         
         // set of methods in the scanned class
         Set<AnnotatedMethod<? super T>> methods = at.getMethods();
         
         for (final AnnotatedMethod<? super T> method : methods) {
            
            // If the method contains @Observes annotation then it is an event observer
            if (method.toString().contains("@Observes")) {
               
               // A list to modify parameter of the observer method
               final List<AnnotatedParameter<T>> newParameters = new ArrayList<AnnotatedParameter<T>>();
               
               // A set to add @PortletEvent annotation in the set
               // of annotations of the parameter of Observer method
               final Set<Annotation> newAnnotations = new LinkedHashSet<Annotation>();
               
               // Making a linked list of new annotations because
               // above set doesn't keep the annotation in the original order 
               List<Annotation> newAnnotationsList = new ArrayList<Annotation>();
               List<?> parameters1 = method.getParameters();
               
               // Get the first parameter of the observer method which contains all annotations
               // TODO: Check if an observer can be defined with 2 parameters in which case this code will fail
               final AnnotatedParameter<?> firstParameter = (AnnotatedParameter<?>)parameters1.get(0);

               // Get all annotations of first parameter of observer method
               Set<Annotation> firstParameterAnnotations = firstParameter.getAnnotations();
               
               newAnnotations.addAll(firstParameterAnnotations);
               
               for(Annotation annotation : firstParameterAnnotations){
                  
                  // Add all original annotations in the same order in the linked list
                  newAnnotationsList.add(annotation);
               }
               
               // Make the @PortletEvent qualifier
               Annotation portletEventAnnotation = new PortletEventImpl();

               // Add @PortletEvent annotation as last qualifier in the linked list
               newAnnotationsList.add(portletEventAnnotation);

               // Add all the annotations from linked list to the new annotation set
               // again maintaining the same order of annotations
               for(int i=0;i<newAnnotationsList.size();i++){
                  newAnnotations.add(newAnnotationsList.get(i));
               }
               
               // Wrapper for first parameter of observer method
               AnnotatedParameter<T> annotatedParameter = new AnnotatedParameter<T>(){

                  @Override
                  public Type getBaseType() {
                     return firstParameter.getBaseType();
                  }

                  @Override
                  public Set<Type> getTypeClosure() {
                     return firstParameter.getTypeClosure();
                  }

                  @SuppressWarnings("hiding")
                  @Override
                  public <T extends Annotation> T getAnnotation(
                        Class<T> annotationType) {
                     return firstParameter.getAnnotation(annotationType);
                  }

                  @Override
                  public Set<Annotation> getAnnotations() {
                     // Only here we put the new annotation set which also include
                     // @PortletEvent annotation
                     return newAnnotations;
                  }

                  @Override
                  public boolean isAnnotationPresent(
                        Class<? extends Annotation> annotationType) {
                     return firstParameter.isAnnotationPresent(annotationType);
                  }

                  @Override
                  public int getPosition() {
                     return firstParameter.getPosition();
                  }

                  @SuppressWarnings("unchecked")
                  @Override
                  public AnnotatedCallable<T> getDeclaringCallable() {
                     return (AnnotatedCallable<T>) firstParameter.getDeclaringCallable();
                  }
                  
               };
               
               // We add the above wrapped parameter in the list of parameters
               // of observer method
               newParameters.add(annotatedParameter);
               
               // Wrapper for observer method
               AnnotatedMethod<T> annotatedMethod = new AnnotatedMethod<T>() {

                  @Override
                  public List<AnnotatedParameter<T>> getParameters() {
                     // Only here we the modified list of parameters
                     return newParameters;
                  }

                  @Override
                  public boolean isStatic() {
                     return method.isStatic();
                  }

                  @SuppressWarnings("unchecked")
                  @Override
                  public AnnotatedType<T> getDeclaringType() {
                     return (AnnotatedType<T>) method.getDeclaringType();
                  }

                  @Override
                  public Type getBaseType() {
                     return method.getBaseType();
                  }

                  @Override
                  public Set<Type> getTypeClosure() {
                     return method.getTypeClosure();
                  }

                  @SuppressWarnings("hiding")
                  @Override
                  public <T extends Annotation> T getAnnotation(
                        Class<T> annotationType) {
                     return method.getAnnotation(annotationType);
                  }

                  @Override
                  public Set<Annotation> getAnnotations() {
                     return method.getAnnotations();
                  }

                  @Override
                  public boolean isAnnotationPresent(
                        Class<? extends Annotation> annotationType) {
                     return method.isAnnotationPresent(annotationType);
                  }

                  @Override
                  public Method getJavaMember() {
                     return method.getJavaMember();
                  }
                  
               };
               
               // We add the above wrapped observer method in set of methods of this class
               newMethods.add(annotatedMethod);
            } else {
               
               // if the method is not observer method then we just add the original method
               // in set of methods of this class
               newMethods.add(method);
            }
         }
         
         // Wrapper for annotated type
         AnnotatedType<T> wrappedAnnotatedType = new AnnotatedType<T>() {
            @SuppressWarnings("hiding")
            @Override
            public <T extends Annotation> T getAnnotation(Class<T> arg0) {
               return at.getAnnotation(arg0);
            }

            @Override
            public Set<Annotation> getAnnotations() {
               return at.getAnnotations();
            }

            @Override
            public Type getBaseType() {
               return at.getBaseType();
            }

            @Override
            public Set<Type> getTypeClosure() {
               return at.getTypeClosure();
            }

            @Override
            public boolean isAnnotationPresent(Class<? extends Annotation> arg0) {
               return at.isAnnotationPresent(arg0);
            }

            @Override
            public Set<AnnotatedConstructor<T>> getConstructors() {
               return at.getConstructors();
            }

            @Override
            public Set<AnnotatedField<? super T>> getFields() {
               return at.getFields();
            }

            @Override
            public Class<T> getJavaClass() {
               return at.getJavaClass();
            }

            @Override
            public Set<AnnotatedMethod<? super T>> getMethods() {
               // Only here we return the new set of methods which
               // also include the modified observer method with @PortletEvent qualifier
               return newMethods;
            }
         };
         pat.setAnnotatedType(wrappedAnnotatedType);
         
      }
      
   }

   // Finish the scanning process
   void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
      
      for(ObserverMethod<?> observerMethod : emptyObserverMethods){
         abd.addObserverMethod(observerMethod);
      }
      
      emptyObserverMethods.clear();
      
      LOG.debug("Finished the scanning process");
   } 
   
   private <T> ObserverMethod<T> createEmptyObserverFor(final AnnotatedField<? super T> field) {
      
      final Set<Annotation> annotations = new HashSet<Annotation>();
      for(Annotation annotation : field.getAnnotations()){
         if(!(annotation instanceof javax.inject.Inject)){
            annotations.add(annotation);
         }
      }
      
      String genericType = field.getJavaMember().getGenericType().toString();
      String genericTypeClassName = genericType.substring(genericType.indexOf("<")+1, genericType.indexOf(">"));
      
      try {
         @SuppressWarnings("rawtypes")
         final Class genericTypeClass = Class.forName(genericTypeClassName);
         
         return new ObserverMethod<T>() {

            @Override
            public Class<?> getBeanClass() {
               return field.getJavaMember().getDeclaringClass();
            }

            @Override
            public Type getObservedType() {
               return genericTypeClass;
            }

            @Override
            public Set<Annotation> getObservedQualifiers() {
               return annotations;
            }

            @Override
            public Reception getReception() {
               return Reception.ALWAYS;
            }

            @Override
            public TransactionPhase getTransactionPhase() {
               return TransactionPhase.IN_PROGRESS;
            }

            @Override
            public void notify(T event) {
               if(!CDIEventsStore.firedFromBeanManager){
                  annotations.add(new PortletEventImpl());
                  CDIEventsStore.addEventToEventBus(new PortletCDIEvent(annotations, (Serializable) event, field.getJavaMember().getDeclaringClass()));
               }
            }
         }; 
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         return null;
      }
      
   }

   private <T> boolean isFieldCDIEventDefinition(Field field) {
      if(field.getType().equals(javax.enterprise.event.Event.class)){
         return true;
      } else {
         return false;
      }
   }

}
