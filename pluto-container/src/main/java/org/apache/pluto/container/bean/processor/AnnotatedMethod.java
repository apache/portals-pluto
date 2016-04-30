package org.apache.pluto.container.bean.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

public class AnnotatedMethod {
   
   private final Class<?>           beanClass; 
   private final Method             meth;
   private final Annotation         annotation;
   private final MethodDescription  description;
   
   // Proxied methods of the same type and for the same portlet name as indicated
   // by the method identifier are stored by ordinal number. Methods that can appear more
   // than once have an ordinal number as annotation element, which lands here.
   private int                      ordinal = 0;
   private boolean                  ordinalSet = false;
   
   private BeanManager     beanMgr;
   
   // The specific bean we are using
   private Bean<?> bean;
   private Object beanInstance;
   private boolean isPortletClass = false;

   /**
    * Constructor.
    * 
    * @param anno          The annotation for this method
    * @param beanClass     The Class of the bean containing the method
    * @param meth          The method to be invoked
    * @param desc          The method description for this method
    */
   public AnnotatedMethod(Annotation anno, Class<?> beanClass, Method meth, MethodDescription desc) {
      this.beanClass = beanClass;
      this.meth = meth;
      this.annotation = anno;
      this.description = desc;
      
      try {
         Method ord = anno.getClass().getMethod("ordinal");
         ordinal = (Integer) ord.invoke(anno);
         ordinalSet = true;
      } catch(Exception e) {}
   }

   /**
    * Constructor for portlet class methods that don't have annotations. The classes 
    * containing these methods may only be instantiated once, so the bean instance is passed
    * in as well.
    * 
    * @param beanClass     The Class of the bean containing the method
    * @param beanInstance  The instance to be used for invocation
    * @param meth          The method to be invoked
    * @param desc          The method description for this method
    */
   public AnnotatedMethod(Class<?> beanClass, Object beanInstance, Method meth, MethodDescription desc) {
      this.beanClass = beanClass;
      this.beanInstance = beanInstance;
      this.meth = meth;
      this.annotation = null;
      this.description = desc;
      this.isPortletClass = true;
   }
   
   /**
    * @return the annotation
    */
   public Annotation getAnnotation() {
      return annotation;
   }

   /**
    * @return the description
    */
   public MethodDescription getDescription() {
      return description;
   }

   /**
    * The annotated method is activated by using the specified BeanManager to
    * obtain a reference to a bean that can be used for method invocation.
    * 
    * @param bm   The BeanManager
    */
   public void activate(BeanManager bm) {
      beanMgr = bm;
      Set<Bean<?>> beans = bm.getBeans(beanClass);
      bean = bm.resolve(beans);
      assert bean != null;
   }
   
   /**
    * Sets the bean instance. Used when the annotated method class is a configured portlet
    * class to ensure that all annotated methods of the portlet class use the same bean instance.
    * 
    * @param beanInstance
    */
   public void setPortletClassInstance(Object beanInstance) {
      this.beanInstance = beanInstance;
      this.isPortletClass = true;
   }
   
   /**
    * Invoke the method with the arguments provided. It is expected that this method is called 
    * is called by a proxy or facade for the method / class.
    * 
    * @param args    Arguments
    * @return        Object returned by method
    * @throws IllegalAccessException
    * @throws IllegalArgumentException
    * @throws InvocationTargetException
    */
   public Object invoke(Object... args) 
         throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      if (!isPortletClass) {
         // get the reference for beans other than portlet classes in order to respect the 
         // scope of the bean.
         beanInstance = beanMgr.getReference(bean, bean.getBeanClass(), beanMgr.createCreationalContext(bean));
      }
      return meth.invoke(beanInstance, args);
   }

   /**
    * returns string representation of the method.
    */
   public String toString() {
      StringBuilder txt = new StringBuilder(256);
      txt.append("Bean class=").append(beanClass.getCanonicalName());
      txt.append(", Method name=").append(meth.getName());
      if (ordinalSet) {
         txt.append(", Ordinal=").append(ordinal);
      }
      return txt.toString();
   }
   
   /**
    * Returns the method wrapped by this class.
    */
   public Method getJavaMethod() {
      return meth;
   }

   /**
    * @return the ordinal
    */
   public int getOrdinal() {
      return ordinal;
   }
   
   /**
    * one annotated method is equal to another if both represent 
    * the same method in the same class.
    */
   @Override
   public boolean equals(Object o) {
      if ((o != null) && (o instanceof AnnotatedMethod)) {
         AnnotatedMethod pm = (AnnotatedMethod) o;
         return meth.equals(pm.meth);
      }
      return false;  
   }
   
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((meth == null) ? 0 : meth.hashCode());
      return result;
   }
}
