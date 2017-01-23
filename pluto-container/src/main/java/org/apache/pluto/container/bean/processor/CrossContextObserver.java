package org.apache.pluto.container.bean.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.ObserverMethod;

public class CrossContextObserver implements ObserverMethod<Object>{

   private Type type;
   private Class<?> clas;
   private Set<Annotation> annotations;
   private Reception reception;
   //private TransactionPhase transaction;
   
   @Override
   public Class<?> getBeanClass() {
      return clas;
   }
   
   public void setBeanClass(Class<?> clas) {
      this.clas = clas;
   }

   @Override
   public Type getObservedType() {
      return type;
   }
   
   public void setObservedType(Type type) {
      this.type = type;
   }

   @Override
   public Set<Annotation> getObservedQualifiers() {
      return annotations;
   }
   
   public void setObservedQualifiers(Set<Annotation> annotations) {
      this.annotations = annotations;
   }

   @Override
   public Reception getReception() {
      return reception;
   }
   
   public void setReception(Reception reception) {
      this.reception = reception;
   }

   @Override
   public TransactionPhase getTransactionPhase() {
      return TransactionPhase.BEFORE_COMPLETION;
   }
   
   /*
   public void setTransactionPhase(TransactionPhase transaction) {
      this.transaction = transaction;
   }
   */

   @Override
   public void notify(Object data) {
      System.out.println("CrossContextObserver recieved = " + data.toString());
      throw new IllegalArgumentException("Cross Context Eventing Mechanism caught the event and blocked it");
   }

}
