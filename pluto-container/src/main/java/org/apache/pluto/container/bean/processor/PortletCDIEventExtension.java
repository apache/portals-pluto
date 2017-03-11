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
import javax.inject.Inject;
import javax.portlet.annotations.CrossContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PortletCDIEventExtension implements Extension {
   
   private static final Logger LOG = LoggerFactory.getLogger(PortletCDIEventExtension.class);
   
   /**
    * A set to save the observers of catcher event in the ProcessAnnotatedType phase.
    * Later we load all catcher event observers in AfterBeanDiscovery phase, set the observers
    * and empty out this set.
    */
   private HashSet<ObserverMethod<?>> catcherEventObservers = new HashSet<ObserverMethod<?>>();

   /**
    * Starting the scanning process 
    */
   void beforeBeanDiscovery(@Observes BeforeBeanDiscovery bbd) {
      LOG.debug("PortletCDIEventExtension - scanning.");
   }

   /** 
    * ProcessAnnotatedType phase is called for each bean (class) found in the scanned web app.
    * The PortletCDIEventExtension we wrote processes the fields and methods found in the bean
    * and change them in following way -<br><br>
    * 
    * Fields - Fields which are an instance of javax.enterprise.event.Event.class are scanned for qualifiers.<br>
    * 1. If they contain @CrossContext qualifiers, then it is replaced by @CatcherEvent. Also, we create a new 
    *    observer to catch the event which contains @CatcherEvent qualifier<br>
    * 2. If they do not contain @CrossContext qualifiers, then we add @NormalEvent<br><br>
    * 
    * Methods - Method which have @Observes in their name and are not in PortletCDIEventExtension or PortletCDIExtension<br>
    * 1. If the method name contains @CrossContext, then we don't touch them.<br>
    * 2. If the method name does not contain @CrossContext, then we add @NormalEvent
    */
   <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {
      
      final AnnotatedType<T> at = pat.getAnnotatedType();

      /*
       * 
       * 
       *  Scanner for fields
       *  
       *  Fields - Fields which are an instance of javax.enterprise.event.Event.class are scanned for qualifiers.
       *  1. If they contain @CrossContext qualifiers, then it is replaced by @CatcherEvent. Also, we create a new 
       *     observer to catch the event which contains @CatcherEvent qualifier
       *  2. If they do not contain @CrossContext qualifiers, then we add @NormalEvent
       *  
       *  
       */
      
      // Get all fields of the class
      Set<AnnotatedField<? super T>> fields = at.getFields();
      
      // A set to accomodate modified fields since the above one is immutable.
      final Set<AnnotatedField<? super T>> modifiedFields = new HashSet<AnnotatedField<? super T>>();
      
      for (final AnnotatedField<? super T> field : fields) {
         
         // If the field is instance of javax.enterprise.event.Event.class
         if (isFieldCDIEventDefinition(field.getJavaMember())) {
            
            boolean crossContextEvent = false;
            
            // A set to accomodate modified annotations for this field.
            final Set<Annotation> modifiedAnnotations = new HashSet<Annotation>();
            
            // Copy all original annotations except CrossContext
            for(Annotation annotation : field.getAnnotations()){
               if(!(annotation instanceof CrossContext)){
                  modifiedAnnotations.add(annotation);
               } else {
                  crossContextEvent = true;
               }
            }
            
            // If this field contains @CrossContext then we replace it by @CatcherEvent
            // else we add @NormalEvent
            if(crossContextEvent){
               CatcherEventImpl catcherEventAnnotation = new CatcherEventImpl();
               modifiedAnnotations.add(catcherEventAnnotation);
            } else {
               NormalEventImpl normalEventAnnotation = new NormalEventImpl();
               modifiedAnnotations.add(normalEventAnnotation);
            }
            
            // We make a new AnnotatedField object since the original one is immutable 
            AnnotatedField<T> modifiedCDIEvent = new AnnotatedField<T>(){

               @SuppressWarnings("unchecked")
               @Override
               public AnnotatedType<T> getDeclaringType() {
                  return (AnnotatedType<T>) field.getDeclaringType();
               }

               @Override
               public boolean isStatic() {
                  return field.isStatic();
               }

               @SuppressWarnings("hiding")
               @Override
               public <T extends Annotation> T getAnnotation(Class<T> arg0) {
                  return field.getAnnotation(arg0);
               }

               @Override
               public Set<Annotation> getAnnotations() {
                  // Here we give the modifiedAnnotation that we have made
                  return modifiedAnnotations;
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
               public boolean isAnnotationPresent(
                     Class<? extends Annotation> arg0) {
                  return field.isAnnotationPresent(arg0);
               }

               @Override
               public Field getJavaMember() {
                  return field.getJavaMember();
               }
            };
            
            // If this field was definition of CrossContext event and since we replaced
            // the @CrossContext qualifier with @CatcherEvent qualifier, now we need an 
            // observer to catch the @CatcherEvent invocation
            if(crossContextEvent){
               ObserverMethod<T> catcherEventObserver = createCatcherEventObserverFor(modifiedCDIEvent);
               catcherEventObservers.add(catcherEventObserver);
            }
            
            // Add this new AnnotatedField in the set of modified fields.
            modifiedFields.add(modifiedCDIEvent);
         } else {
            
            // if this field is not an instance of javax.enterprise.event.Event.class
            // then add it as it is in the set of modified fields.
            modifiedFields.add(field);
         }
      }      
      
      
      
      
      /*
       * 
       * 
       *  Scanner for methods
       *  
       *  Methods - Method which have @Observes in their name and are not in PortletCDIEventExtension or PortletCDIExtension
       *  1. If the method name contain @CrossContext, then we don't touch them.
       *  2. If the method name does not contain @CrossContext, then we add @NormalEvent
       *  
       */
      
      // Get the class of annotated type
      Class<?> className = pat.getAnnotatedType().getJavaClass();
      
      // Ignore Observers from PortletCDIExtension class and PortletCDIEventExtension class
      if(className!=null && !className.equals(PortletCDIEventExtension.class) && !className.equals(PortletCDIExtension.class)){
         
         // A set to add modified observer method since the original one is immutable
         final Set<AnnotatedMethod<? super T>> newMethods = new HashSet<AnnotatedMethod<? super T>>();
         
         Set<AnnotatedMethod<? super T>> methods = at.getMethods();
         
         for (final AnnotatedMethod<? super T> method : methods) {
            
            String methodName = method.toString();
            
            // If the method name contains @Observes annotation and does not contain @CrossContext
            if (methodName.contains("@Observes") && !methodName.contains("@CrossContext")) {
               
               // A list to modify parameter of the observer method
               final List<AnnotatedParameter<T>> newParameters = new ArrayList<AnnotatedParameter<T>>();
               
               // A set modify annotations of first parameter of observer method 
               final Set<Annotation> newAnnotations = new LinkedHashSet<Annotation>();

               List<?> parameters = method.getParameters();
               
               // Get the first parameter of the observer method
               final AnnotatedParameter<?> firstParameter = (AnnotatedParameter<?>)parameters.get(0);
               
               // Adds all original annotations in in the modified set of annotations 
               newAnnotations.addAll(firstParameter.getAnnotations());

               // Make the @NormalEvent qualifier
               Annotation normalCDIEventAnnotation = new NormalEventImpl();

               // Add @NormalEvent annotation too
               newAnnotations.add(normalCDIEventAnnotation);
               
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
                     // @NormalEvent annotation
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
               
               // if the method is cross context observer method or any other method 
               // then we just add the original method
               // in set of modified methods
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
               // Here we return the new set of fields
               return modifiedFields;
            }

            @Override
            public Class<T> getJavaClass() {
               return at.getJavaClass();
            }

            @Override
            public Set<AnnotatedMethod<? super T>> getMethods() {
               // Here we return the new set of methods
               return newMethods;
            }
         };
         pat.setAnnotatedType(wrappedAnnotatedType);
         
      }
      
   }

   /**
    * In AfterBeanDiscovery phase we add all the catcherEventObservers we made while scanning
    * the bean in ProcessAnnotatedType phase.<br>
    * Finish the scanning process.
    */
   void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
      
      // We add all the catcherEventObservers we made while scanning
      // the bean in ProcessAnnotatedType phase.
      for(ObserverMethod<?> observerMethod : catcherEventObservers){
         abd.addObserverMethod(observerMethod);
      }
      
      catcherEventObservers.clear();
      
      LOG.debug("Finished the scanning process");
   } 
   
   /**
    * A method to make catcher observer from its event definition.
    */
   private <T> ObserverMethod<T> createCatcherEventObserverFor(final AnnotatedField<? super T> field) {
      
      final Set<Annotation> catcherEventAnnotations = new HashSet<Annotation>();
      final Set<Annotation> crossContextAnnotations = new HashSet<Annotation>();
      
      // Add all annotations in catcherEventAnnotations excpet @Inject
      // Add all annotations in crossContextAnnotations except @Inject and @CatcherEvent
      for(Annotation annotation : field.getAnnotations()){
         if(!(annotation instanceof Inject)){
            catcherEventAnnotations.add(annotation);
            if(!(annotation instanceof CatcherEventImpl)){
               crossContextAnnotations.add(annotation);
            }
         }
      }
      
      // Add @CrossContext annotation in catcherEventAnnotations
      crossContextAnnotations.add(new CrossContextImpl());
      
      // Get the generic type of this event
      // For example - if CDI event is defined as javax.enterprise.event.Event<String> - Here we retrieve "<String>"
      String genericType = field.getJavaMember().getGenericType().toString();
      
      // Removes the "<>" from generic type name.
      // For example - <String> to just "String"
      String genericTypeClassName = genericType.substring(genericType.indexOf("<")+1, genericType.indexOf(">"));
      
      // Try to load the class of generic type. For above example we used String class 
      // which is available in pluto container.
      // However, if the user have used some custom class as event data, 
      // then it has to be loaded here, because pluto container do not know
      // its definition which is required to make catcher event observer.
      try {
         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
         @SuppressWarnings("rawtypes")
         final Class genericTypeClass = classLoader.loadClass(genericTypeClassName);
               
         return new ObserverMethod<T>() {

            @Override
            public Class<?> getBeanClass() {
               // The class in which this observer is located
               return field.getJavaMember().getDeclaringClass();
            }

            @Override
            public Type getObservedType() {
               // The data type observed by this observer
               return genericTypeClass;
            }

            @Override
            public Set<Annotation> getObservedQualifiers() {
               // The qualifiers this observer contains
               return catcherEventAnnotations;
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
               // What to do when @CatcherEvent is triggered?
               // We save the event invocation in CDIEventStore with enough data that 
               // it could be triggered again as @CrossContext event
               // See CrossContextCDIEvent data structure in order to see what is 
               // actually saved with the invocation.
               CDIEventStore.addEventToEventBus(new CrossContextCDIEvent(crossContextAnnotations, (Serializable) event, field.getJavaMember().getDeclaringClass()));
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
