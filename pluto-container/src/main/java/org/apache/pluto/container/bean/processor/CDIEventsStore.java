package org.apache.pluto.container.bean.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

@ApplicationScoped
public class CDIEventsStore {

   public static final QName CDI_EVENT_QNAME = new QName("javax.portlet.cdi.event", "javax.portlet.cdi.event");
   public static List<PortletCDIEvent>                CDIEventBus   = Collections.synchronizedList(new ArrayList<PortletCDIEvent>());
   public static Set<PortletApplicationDefinition> CDIPortletEventSubscriberPADList = Collections.synchronizedSet(new HashSet<PortletApplicationDefinition>());

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
