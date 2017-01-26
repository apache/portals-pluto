package org.apache.pluto.container.bean.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

@ApplicationScoped
public class CDIEventsStore {

   public static ArrayList<PortletCDIEvent>                CDIEventBus   = new ArrayList<PortletCDIEvent>();
   public static boolean                                   firedFromBeanManager = false;
   public static Map<PortletApplicationDefinition, String> portletAdded         = Collections
         .synchronizedMap(new HashMap<PortletApplicationDefinition, String>());

   public static synchronized void addEventToEventBus(
         PortletCDIEvent newPortletCDIEvent) {
      boolean contains = false;
      for (PortletCDIEvent PortletCDIEvent : CDIEventBus) {
         if (PortletCDIEvent.equals(newPortletCDIEvent)) {
            if (!PortletCDIEvent.getObserverBeanClass()
                  .equals(newPortletCDIEvent.getObserverBeanClass())) {
               contains = true;
               break;
            }
         }
      }
      if (!contains) {
         CDIEventBus.add(newPortletCDIEvent);
      }
   }
}
