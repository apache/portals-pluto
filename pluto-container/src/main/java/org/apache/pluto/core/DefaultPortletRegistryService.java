package org.apache.pluto.core;

import org.apache.commons.collections.map.CompositeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.internal.PortletDescriptorRegistry;
import org.apache.pluto.spi.optional.PortletRegistryEvent;
import org.apache.pluto.spi.optional.PortletRegistryListener;
import org.apache.pluto.spi.optional.PortletRegistryService;

import javax.servlet.ServletContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultPortletRegistryService implements PortletRegistryService {

    private static final Log LOG =
        LogFactory.getLog(DefaultPortletRegistryService.class);

    private static final String CONTEXT_PATH =
        "org.apache.pluto.PORTLET_APP_CONTEXT_PATH";

    private static DefaultPortletRegistryService instance;
    private static Method contextPathGetter;

    static {
        try {
            contextPathGetter = ServletContext.class.getMethod("getContextPath", new Class[0]);
        }
        catch (NoSuchMethodException e) {
            LOG.warn("Servlet 2.4 or below detected.  Unable to find getContextPath on ServletContext.");
        }
    }

    public static DefaultPortletRegistryService getInstance() {
        if (instance == null) {
            instance = new DefaultPortletRegistryService();
        }
        return instance;
    }


    private MultiKeyedMap registeredApplications;
    private List listeners;

    private DefaultPortletRegistryService() {
        registeredApplications = new MultiKeyedMap();
        listeners = new ArrayList();
    }

    public Iterator getRegisteredPortletApplications() {
        return registeredApplications.values().iterator();
    }

    public void register(ServletContext context)
        throws PortletContainerException {

        String contextName = context.getServletContextName();
        String contextPath = resolvePath(context);

        if (contextName == null || registeredApplications.containsKey(contextName)) {
            throw new IllegalArgumentException("Unable to register context '" + contextName +
                "'. A context with this name has allready been registered.");
        }

        PortletAppDD descriptor =
            PortletDescriptorRegistry.getRegistry().getPortletAppDD(context);

        registeredApplications.put(contextName, contextPath, context, descriptor);

        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setContextPath(contextPath);
        event.setPortletApplicationDescriptor(descriptor);

        Iterator i = listeners.iterator();
        while (i.hasNext()) {
            ((PortletRegistryListener) i.next()).portletApplicationRegistered(event);
        }

    }

    public void remove(ServletContext context) {
        String contextName = context.getServletContextName();
        String contextPath = resolvePath(context);

        PortletAppDD descriptor = registeredApplications.remove(contextName, contextPath, context);

        PortletRegistryEvent event = new PortletRegistryEvent();
        event.setContextPath(contextPath);
        event.setPortletApplicationDescriptor(descriptor);

        Iterator i = listeners.iterator();
        while (i.hasNext()) {
            ((PortletRegistryListener) i.next()).portletApplicationRemoved(event);
        }
    }

    private String resolvePath(ServletContext context) {
        String contextPath = null;
        if (contextPathGetter != null) {
            try {
                contextPath = (String) contextPathGetter.invoke(context, new Class[0]);
            } catch (Exception e) {
                LOG.warn("Unable to get context path from ServletContext.  Using Portlet Name for registration.");
            }
        }

        if (contextPath == null) {
            contextPath = (String) context.getAttribute(CONTEXT_PATH);
        }

        return contextPath;
    }

    /**
     * Retrive the portlet application descriptor by name or context
     * path.
     *
     * @param name
     * @return
     */
    public PortletAppDD getPortletApplicationDescriptor(String name) {
        return (PortletAppDD) registeredApplications.get(name);
    }

    public void addPortletRegistryListener(PortletRegistryListener listener) {
        listeners.add(listener);
    }

    public void removePortletRegistryListener(PortletRegistryListener listener) {
        listeners.remove(listener);
    }

    class MultiKeyedMap extends CompositeMap {

        private Map named = new HashMap();
        private Map pathed = new HashMap();
        private Map contexted = new HashMap();

        public MultiKeyedMap() {
            addComposited(named);
            addComposited(pathed);
            addComposited(contexted);
        }

        public void put(String appName, String contextPath, ServletContext context, PortletAppDD descriptor) {
            named.put(appName, descriptor);
            contexted.put(context, descriptor);

            if (contextPath != null) {
                pathed.put(contextPath, descriptor);
            }
        }

        public PortletAppDD remove(String appName, String contextPath, ServletContext context) {
            pathed.remove(contextPath);
            contexted.remove(context);
            return (PortletAppDD)named.remove(appName);
        }


    }

}

