package org.apache.pluto.container.bean.processor;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Set;

public class PortletCDIEvent {

   private Annotation[] qualifiers;
   private int          no_of_qualifiers;
   private Object data;
   private String dataType;
   @SuppressWarnings("rawtypes")
   private Class observerBeanClass;
   private boolean processing;

   public PortletCDIEvent(Set<Annotation> qualifiers, Object data, @SuppressWarnings("rawtypes") Class observerBeanClass) {
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
   
   // TODO: Maybe throw exceptions when equals return false
   // TODO: Check if we can set same CDI event 2 times  
   @Override
   public boolean equals(Object obj){
      if(obj instanceof PortletCDIEvent){
         PortletCDIEvent comparedObj = (PortletCDIEvent) obj;
         if(this.no_of_qualifiers != comparedObj.no_of_qualifiers){
            //System.out.println("Comparison returned false because no of qualifiers are different");
            return false;
         }
         for(int i=0; i<this.no_of_qualifiers;i++){
            if(!this.qualifiers[i].equals(comparedObj.qualifiers[i])){
               //System.out.println("Comparison returned false because qualifers are different. Particularly "+ this.qualifiers[i].toString());
               return false;
            }
         }
         /*if(!this.data.equals(comparedObj.data)){
            //System.out.println("Comparison returned false because data is different. "+this.data.toString()+" != "+comparedObj.data.toString());
            return false;
         }*/
         return true;
      } else {
         return false;
      }
      
   }
   
}
