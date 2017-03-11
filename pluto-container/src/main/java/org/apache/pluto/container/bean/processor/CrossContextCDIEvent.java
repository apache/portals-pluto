package org.apache.pluto.container.bean.processor;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Set;

public class CrossContextCDIEvent {

   private Annotation[] qualifiers;
   private int          no_of_qualifiers;
   private Object data;
   private String dataType;
   @SuppressWarnings("rawtypes")
   private Class observerBeanClass;
   private boolean processing;

   public CrossContextCDIEvent(Set<Annotation> qualifiers, Object data, @SuppressWarnings("rawtypes") Class observerBeanClass) {
      this.qualifiers = new Annotation[qualifiers.size()];
      int count = 0;
      for(Annotation qualifier : qualifiers){
         this.qualifiers[count]=qualifier;
         count++;
      }
      this.no_of_qualifiers = qualifiers.size();
      this.data = data;
      this.dataType = data.getClass().getCanonicalName();
      this.observerBeanClass=observerBeanClass;
      this.processing=false;
   }

   public Annotation[] getQualifiers() {
      return qualifiers;
   }

   public int get_no_of_qualifiers() {
      return no_of_qualifiers;
   }

   public Object getData() {
      return data;
   }
   
   public void setSerializedData(Serializable data) {
      this.data = data;
   }
   
   public String getDataType() {
      return dataType;
   }
   
   @SuppressWarnings("rawtypes")
   public Class getObserverBeanClass() {
      return observerBeanClass;
   }
   
   public boolean isProcessing() {
      return processing;
   }

   public void setProcessing(boolean processing) {
      this.processing = processing;
   }
   
   @Override
   public boolean equals(Object obj){
      if(obj instanceof CrossContextCDIEvent){
         CrossContextCDIEvent comparedObj = (CrossContextCDIEvent) obj;
         if(this.no_of_qualifiers != comparedObj.no_of_qualifiers){
            return false;
         }
         for(int i=0; i<this.no_of_qualifiers;i++){
            if(!this.qualifiers[i].equals(comparedObj.qualifiers[i])){
               return false;
            }
         }
         return true;
      } else {
         return false;
      }
      
   }
   
}
