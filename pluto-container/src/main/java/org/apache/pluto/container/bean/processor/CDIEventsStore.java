package org.apache.pluto.container.bean.processor;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.ObserverMethod;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;

@ApplicationScoped
public class CDIEventsStore {
   
   public static Map<AnnotatedField<?>, HashSet<ObserverMethod<?>>> event_observers = Collections.synchronizedMap(new HashMap<AnnotatedField<?>, HashSet<ObserverMethod<?>>>());
   public static Map<ObserverMethod<?>, Object> observerInvocation = Collections.synchronizedMap(new HashMap<ObserverMethod<?>, Object>());
   public static Map<Object, Set<Annotation>> eventStore = Collections.synchronizedMap(new HashMap<Object, Set<Annotation>>());
   public static ArrayList<PortletCDIEvent> universalEventList = new ArrayList<PortletCDIEvent>();
   public static ArrayList<ObserverMethod<?>> universalObserverList = new ArrayList<ObserverMethod<?>>();
   public static boolean firedFromBeanManager = false; 
   public static Set<String> recieverPortlets = new HashSet<String>();
   public static Map<PortletApplicationDefinition, Set<PortletCDIEvent>> portletAppCDIEventList = Collections.synchronizedMap(new HashMap<PortletApplicationDefinition, Set<PortletCDIEvent>>());
   public static Map<PortletApplicationDefinition, String> portletAdded = Collections.synchronizedMap(new HashMap<PortletApplicationDefinition, String>());
   public static Stack<Map<PortletApplicationDefinition, String>> lifo = new Stack<Map<PortletApplicationDefinition, String>>();
   
   public static synchronized void addEventToUniversalList(PortletCDIEvent newPortletCDIEvent){
      boolean contains = false;
      for(PortletCDIEvent PortletCDIEvent : universalEventList){
         if(PortletCDIEvent.equals(newPortletCDIEvent)){
            if(!PortletCDIEvent.getObserverBeanClass().equals(newPortletCDIEvent.getObserverBeanClass())){
               contains = true;
               break;
            }
         }
      }
      if(!contains){
         universalEventList.add(newPortletCDIEvent);
      }
   }
   
   /*
   public static void printInvokedObservers(){
      Set<Entry<ObserverMethod<?>, Serializable>> observerInvokation = CDIEventsStore.observerInvocation.entrySet();
      for(Entry<ObserverMethod<?>, Serializable> hi : observerInvokation){
         System.out.println(hi.getValue().toString());
      }
   }
   */
}
