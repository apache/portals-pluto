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
public class CDIEventStore {

   /**
    * The Qname for portlet event which is reserved for transferring only cdi events.
    */
   public static final QName CDI_EVENT_QNAME = new QName("javax.portlet.cdi.event", "javax.portlet.cdi.event");
   
   /**
    * An Eventbus to save the invocation of cross-context CDI events. 
    * These events will be retrieved in action/event phase 
    * and convert into portlet event.<br>
    * This bus acts as a carrier from {@link PortletCDIEventExtension}
    * to {@link org.apache.pluto.container.driver.PortletServlet3}.
    */
   public static List<CrossContextCDIEvent>                CDIEventBus   = Collections.synchronizedList(new ArrayList<CrossContextCDIEvent>());
 
   /**
    * A set to keep track of whether a portlet in a PortletApplicationDefinition already subscribed to the cross-context CDI event.
    */
   public static Set<PortletApplicationDefinition> crossContextEventSubscriberPADList = Collections.synchronizedSet(new HashSet<PortletApplicationDefinition>());

   /**
    * Adds event to event bus
    * @param CrossContextEvent
    */
   public static synchronized void addEventToEventBus(
         CrossContextCDIEvent newCrossContextEvent) {
      boolean contains = false;
      for (CrossContextCDIEvent crossContextIEvent : CDIEventBus) {
         if (crossContextIEvent.equals(newCrossContextEvent)) {
            if (!crossContextIEvent.getObserverBeanClass()
                  .equals(newCrossContextEvent.getObserverBeanClass())) {
               contains = true;
               break;
            }
         }
      }
      if (!contains) {
         CDIEventBus.add(newCrossContextEvent);
      }
   }
}
