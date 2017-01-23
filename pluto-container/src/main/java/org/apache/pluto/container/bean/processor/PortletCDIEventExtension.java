package org.apache.pluto.container.bean.processor;

import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
import javax.enterprise.inject.spi.ProcessObserverMethod;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PortletCDIEventExtension implements Extension {
   
   private static final Logger LOG = LoggerFactory.getLogger(PortletCDIEventExtension.class);
   
   // To make reference to class fields which are currently examined
   private HashSet<AnnotatedField<?>> fieldsInCurrentScope = new HashSet<AnnotatedField<?>>();
   
   // To make reference to the original observers 
   private HashSet<ObserverMethod<?>> originalObserverMethods = new HashSet<ObserverMethod<?>>();

   // Starting the scanning process 
   void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
      LOG.debug("PortletCDIEventExtension - scanning.");
   }

   // Scan all classes with javax.enterprise.event.Event field
   <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {

      final AnnotatedType<T> at = pat.getAnnotatedType();

      // Get all fields of the class
      Set<AnnotatedField<? super T>> fields = at.getFields();
      
      final Set<AnnotatedField<? super T>> modifiedFields = new HashSet<AnnotatedField<? super T>>();
      
      //TODO: See if I am only getting annotated field else use reflection API
      
      // Iterate through all fields
      for (final AnnotatedField<? super T> field : fields) {
         
         // Get full name of field with modifiers, annotations and type
         String fieldFullName = field.toString();
         
         // Short-listing fields with @Inject annotation
         if (fieldFullName.contains("@Inject")) {
            // Get the full class name of field type
            // check if its equal to javax.enterprise.event.Event
            if (field.getBaseType().toString()
                  .contains("javax.enterprise.event.Event")) {
               
               // Add the CDI event declaration in event_observers map
               // For now, just put an empty HashSet of observers for this event
               // Later, in processObserverMethod we will try to find 
               // all observers associated with this event
               
               
               final Set<Annotation> newAnnotations = new LinkedHashSet<Annotation>();
               List<Annotation> newAnnotationsList = new ArrayList<Annotation>();
               
               System.out.println("\nBefore adding @EmptyEvent - \n");
               for(Annotation annotation : field.getAnnotations()){
                  System.out.println(annotation.toString());
                  // Add all original annotations in the same order in the linked list
                  newAnnotationsList.add(annotation);
               }
               
               // Make the @PortletEvent qualifier
               Annotation emptyEventAnnotation = new MyEmptyEvent();

               // Add @PortletEvent annotation as last qualifier in the linked list
               newAnnotationsList.add(emptyEventAnnotation);

               // Add all the annotations from linked list to the new annotation set
               // again maintaining the same order of annotations
               for(int i=0;i<newAnnotationsList.size();i++){
                  newAnnotations.add(newAnnotationsList.get(i));
               }
               
               // Print the modified annotations
               System.out.println("\nAfter adding @EmptyEvent - \n");
               for(Annotation annotation : newAnnotations){
                  System.out.println(annotation.toString());
               }
               
               AnnotatedField<T> annotatedField = new AnnotatedField<T>(){

                  @Override
                  public boolean isStatic() {
                     return field.isStatic();
                  }

                  @Override
                  public AnnotatedType<T> getDeclaringType() {
                     return (AnnotatedType<T>) field.getDeclaringType();
                  }

                  @Override
                  public Type getBaseType() {
                     return field.getBaseType();
                  }

                  @Override
                  public Set<Type> getTypeClosure() {
                     return field.getTypeClosure();
                  }

                  @Override
                  public <T extends Annotation> T getAnnotation(
                        Class<T> annotationType) {
                     return field.getAnnotation(annotationType);
                  }

                  @Override
                  public Set<Annotation> getAnnotations() {
                     return newAnnotations;
                  }

                  @Override
                  public boolean isAnnotationPresent(
                        Class<? extends Annotation> annotationType) {
                     return field.isAnnotationPresent(annotationType);
                  }

                  @Override
                  public Field getJavaMember() {
                     return field.getJavaMember();
                  }
                  
               };
               
               modifiedFields.add(annotatedField);
               
               CDIEventsStore.event_observers.put(annotatedField, new HashSet<ObserverMethod<?>>());
               fieldsInCurrentScope.add(annotatedField);
               
               // Commenting out the code to match event and observers of different web apps
               for (Map.Entry<AnnotatedField<?>, HashSet<ObserverMethod<?>>> entry : CDIEventsStore.event_observers.entrySet())
               {
                  HashSet<ObserverMethod<?>> observerMethods = entry.getValue();
                  for (ObserverMethod<?> observer : observerMethods) {
                     if(compareEventAndObserver(annotatedField, observer)){
                        CDIEventsStore.event_observers.get(annotatedField).add(observer);
                     }
                  }
               }
            } else {
               modifiedFields.add(field);
            }
         } else {
            modifiedFields.add(field);
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
               
               System.out.println("\n\nBefore adding @PortletEvent - \n");
               for(Annotation annotation : firstParameterAnnotations){
                  System.out.println(annotation.toString());
                  
                  // Add all original annotations in the same order in the linked list
                  newAnnotationsList.add(annotation);
               }
               
               // Make the @PortletEvent qualifier
               Annotation portletEventAnnotation = new MyPortletEvent();

               // Add @PortletEvent annotation as last qualifier in the linked list
               newAnnotationsList.add(portletEventAnnotation);

               // Add all the annotations from linked list to the new annotation set
               // again maintaining the same order of annotations
               for(int i=0;i<newAnnotationsList.size();i++){
                  newAnnotations.add(newAnnotationsList.get(i));
               }
               
               // Print the modified annotations
               System.out.println("\nAfter adding @PortletEvent - \n");
               for(Annotation annotation : newAnnotations){
                  System.out.println(annotation.toString());
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
   
   // Scan all @Observes methods in the app one at a time
   <T, X> void processObserverMethod(@Observes ProcessObserverMethod<T, X> pom){
      final ObserverMethod<T> observer = pom.getObserverMethod();
      
      
      Set<Annotation> modifiedQualifiers = observer.getObservedQualifiers();
      final Set<Annotation> originalQualifiers = new HashSet<Annotation>();
      
      for(Annotation qualifier : modifiedQualifiers){
         if(!qualifier.annotationType().equals(PortletEvent.class)){
            originalQualifiers.add(qualifier);
         } /*else {
            Annotation emptyEventAnnotation = new MyEmptyEvent();
            originalQualifiers.add(emptyEventAnnotation);
         }*/
      }
      
      ObserverMethod<T> orginalObserverMethod = new ObserverMethod<T>() {

         @Override
         public Class<?> getBeanClass() {
            return observer.getBeanClass();
         }

         @Override
         public Type getObservedType() {
            return observer.getObservedType();
         }

         @Override
         public Set<Annotation> getObservedQualifiers() {
            return originalQualifiers;
         }

         @Override
         public Reception getReception() {
            return observer.getReception();
         }

         @Override
         public TransactionPhase getTransactionPhase() {
            return observer.getTransactionPhase();
         }

         @Override
         public void notify(T event) {
            // Here we catch the original event
            
            // but do not let it reach the original observer
            //observer.notify(event);
            
            // Code for firing all observers (including cross context) for this event
            /*
            boolean observerFound = false;
            Set<Entry<AnnotatedField<?>, HashSet<ObserverMethod<?>>>> allEventsAndObservers = CDIEventsStore.event_observers.entrySet();
            for(Entry<AnnotatedField<?>, HashSet<ObserverMethod<?>>> eventAndObservers : allEventsAndObservers){
               HashSet<ObserverMethod<?>> eventObservers = eventAndObservers.getValue();
               for(ObserverMethod<?> eventObserver : eventObservers){
                  if(eventObserver.equals(observer)){
                     for(ObserverMethod<?> allObserver : eventObservers){
                        allObserver.notify(event);
                     }
                     observerFound=true;
                     break;
                  }
               }
               if(observerFound){
                  break;
               }
            }
            */
            
            // Try to save it here for later invocation
            // We might also need to serialize the event here
            /*
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            Writer out = new StringWriter();
            @SuppressWarnings("rawtypes")
            Class clazz = event.getClass();
            try {
               System.setProperty( "com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize", "true");
               JAXBContext jc = JAXBContext.newInstance(clazz);
               Marshaller marshaller = jc.createMarshaller();
               JAXBElement<Serializable> element = new JAXBElement<Serializable>(new QName("http:eventexample.com/events",
                     "portlet.api.event"), clazz, (Serializable) event);
               marshaller.marshal(element, out);
            } catch(Exception e) {
               System.out.println("Error while serializing cdi event data "+e.toString());
               e.printStackTrace();
            } finally {
               Thread.currentThread().setContextClassLoader(cl);
               System.getProperties().remove("com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize");
            }
            CDIEventsStore.observerInvocation.put(observer, (Serializable) out.toString());
            */
            CDIEventsStore.observerInvocation.put(observer, event);
            CDIEventsStore.eventStore.put(event, observer.getObservedQualifiers());
            if(!CDIEventsStore.firedFromBeanManager){
               CDIEventsStore.addEventToUniversalList(new PortletCDIEvent(observer.getObservedQualifiers(), (Serializable) event, observer.getBeanClass()));
               CDIEventsStore.universalObserverList.add(observer);
            }
            //CDIEventsStore.universalEventList.add(new PortletCDIEvent(observer.getObservedQualifiers(), (Serializable) event));
            //CDIEventsStore.printInvokedObservers();
         }
      };
      
      originalObserverMethods.add(orginalObserverMethod);
      
      // This is an alternate (more simpler) way of doing what we did above. 
      // We could have let the original observers as it is 
      // and made a new @PortletEvent qualified observer for each
      // original observer. We wouldn't even need to touch the 
      // original observers in ProcessAnnotatedType phase 
      // BUT!!!
      // The problem here is if we do it this way then how can we
      // block the task being done by original observer??
      /*
      Set<Annotation> originalQualifiers = observer.getObservedQualifiers();
      final Set<Annotation> modifiedQualifiers = new HashSet<Annotation>();
      
      for(Annotation qualifier : originalQualifiers){
         modifiedQualifiers.add(qualifier);
      }
      
      // Make the @PortletEvent qualifier
      Annotation portletEventAnnotation = new MyPortletEvent();

      // Add @PortletEvent annotation as last qualifier in the linked list
      modifiedQualifiers.add(portletEventAnnotation);
      
      ObserverMethod<T> modifiedObserverMethod = new ObserverMethod<T>() {

         @Override
         public Class<?> getBeanClass() {
            return observer.getBeanClass();
         }

         @Override
         public Type getObservedType() {
            return observer.getObservedType();
         }

         @Override
         public Set<Annotation> getObservedQualifiers() {
            return modifiedQualifiers;
         }

         @Override
         public Reception getReception() {
            return observer.getReception();
         }

         @Override
         public TransactionPhase getTransactionPhase() {
            return observer.getTransactionPhase();
         }

         @Override
         public void notify(T event) {
            System.out.println("Original event fired.");
         }
      };
      
      originalObserverMethods.add(modifiedObserverMethod);
      */
      
      // Commenting out the code to match events and observers of different app
      // Iterate through each event in event_observers map
      
      for (Map.Entry<AnnotatedField<?>, HashSet<ObserverMethod<?>>> entry : CDIEventsStore.event_observers.entrySet())
      {
         // See if this @Observes method belongs to this event
         if(compareEventAndObserver(entry.getKey(), observer)){
            // Add this @Observes method in HashSet of observers
            // for this event
            HashSet<ObserverMethod<?>> eventObservers = entry.getValue();
            eventObservers.add(observer);
         }
      }
      
      
      // Temporary code to match event and observers in the same app
      // Iterate through each event in event_observers map
      /*
      for (AnnotatedField<?> field : fieldsInCurrentScope)
      {
         // See if this @Observes method belongs to this event
         if(compareEventAndObserver(field, observer)){
            // Add this @Observes method in HashSet of observers
            // for this event
            
            HashSet<ObserverMethod<?>> eventObservers = CDIEventsStore.event_observers.get(field);
            eventObservers.add(observer);
         }
      }
      */
   }

   // Finish the scanning process
   void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
      
      for(ObserverMethod<?> observerMethod : originalObserverMethods){
         abd.addObserverMethod(observerMethod);
      }
      
      originalObserverMethods.clear();
      
      LOG.debug("Found these events and observers - ");
      System.out.println("Found these events and observers - ");
      for (Map.Entry<AnnotatedField<?>, HashSet<ObserverMethod<?>>> entry : CDIEventsStore.event_observers.entrySet())
      {
         System.out.println(entry.getKey().toString() + "/" + entry.getValue().toString());
         LOG.debug(entry.getKey().toString() + "/" + entry.getValue().toString());
      }
      /*
      for(AnnotatedField<?> field : fieldsInCurrentScope){
         HashSet<ObserverMethod<?>> observerMethods = CDIEventsStore.event_observers.get(field);
         for (ObserverMethod<?> observer : observerMethods) {
            CrossContextObserver crossContextObserver = new CrossContextObserver();
            crossContextObserver.setBeanClass(observer.getBeanClass());
            crossContextObserver.setObservedQualifiers(observer.getObservedQualifiers());
            crossContextObserver.setObservedType(observer.getObservedType());
            crossContextObserver.setReception(observer.getReception());
            abd.addObserverMethod(crossContextObserver);
            break;
         }
      }
      
      */
      fieldsInCurrentScope.clear();
      System.out.println("Finished the scanning process");
      LOG.debug("Finished the scanning process");
   }
   
   // Method to compare event with an observer
   // returns true if the observer belongs to the same event
   // else false
   private boolean compareEventAndObserver(AnnotatedField<?> event,
         ObserverMethod<?> observer) {
      
      // Gets the qualifier from full event name
      //String qualifierNameFromEvent = event.toString().split(" ")[2];
      Annotation qualifierFromEvent = null;
      for(Annotation eventAnnotation : event.getAnnotations()){
         if (!eventAnnotation.annotationType().equals(EmptyEvent.class) && !eventAnnotation.annotationType().equals(Inject.class)){
            qualifierFromEvent = eventAnnotation;
         }
      }
      
      // Initialize qualifier name from event to be empty
      // in case there is none
      //String qualifierFromEvent = "";
      
      // remove @ from qualifier name. This also checks whether 
      // there is a qualifier for this event or not
      /*if(qualifierNameFromEvent.contains("@")){
         qualifierFromEvent = qualifierNameFromEvent.replace("@", "");
      }*/
      
      // Initialize the qualifier name from observer 
      // to be empty in case there is none 
      Annotation qualifierFromObserver = null;
      
      // Get all qualifiers from @Observes method
      Set<Annotation> qualifiers = observer.getObservedQualifiers();
      
      System.out.println("\n");
      
      // Get the qualifier name from @Observes method
      for(Annotation annotation : qualifiers){
         String observerType = annotation.toString();
         System.out.println("Observer annotation: "+observerType);
         String observerQualifier = observerType.substring(observerType.lastIndexOf(".")+1).replace("()", "");
         
         // Ignore @PortletEvent qualifier of observer while matching
         // with qualifiers of event because we artificially added 
         // @PortletEvent in observer
         if(annotation.annotationType().equals(PortletEvent.class) || annotation.annotationType().equals(EmptyEvent.class)){
            continue;
         } else {
            qualifierFromObserver = annotation;
         }
      }
      
      // Get the type of event value from event declaration
      String eventValueType = event.getBaseType().toString();
      
      // Parse the type of event value
      String eventValueTypeFromEvent = eventValueType.split("<")[1].replace(">", "");
      
      // Get the type of event value from @Observes method
      String eventValueTypeFromObserver = observer.getObservedType().toString().split(" ")[1];    
      
      // Check if qualifiers and event value type matches
      // for event declaration and observer declaration
      
      System.out.println("Qualifier from event: "+qualifierFromEvent);
      System.out.println("Qualifier from observer: "+qualifierFromObserver);
      System.out.println("Value type from event: "+eventValueTypeFromEvent);
      System.out.println("Value type from observer: "+eventValueTypeFromObserver);
      
      if(eventValueTypeFromEvent.equals(eventValueTypeFromObserver)){
         if(qualifierFromEvent == null && qualifierFromObserver == null){
            return true;
         } else if (qualifierFromEvent!=null && qualifierFromObserver!=null &&
               qualifierFromEvent.equals(qualifierFromObserver)) {
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
      
   }

}
