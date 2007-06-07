/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.internal.impl;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.rmi.MarshalException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.portlet.Event;
import javax.portlet.PortalContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.SchemaFactoryLoader;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.EventDefinitionDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.spi.EventProvider;
import org.apache.pluto.spi.PortalCallbackService;
import org.apache.pluto.spi.ResourceURLProvider;
import org.apache.pluto.util.StringUtils;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.jaxp.validation.xs.SchemaFactoryImpl;

/**
 * Implementation of JSR-286 <code>StateAwareResponse</code>.
 *
 * @since 2.0
 */
public class StateAwareResponseImpl extends PortletResponseImpl implements
		StateAwareResponse {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(StateAwareResponseImpl.class);

	boolean redirectAllowed = true;
	private boolean redirected;
	private String redirectLocation;
    

    private Map renderParameters = new HashMap();
    private WindowState windowState = null;
    private PortletMode portletMode = null;
	private PortalCallbackService callback;
    private PortalContext context;
    
	public StateAwareResponseImpl(PortletContainer container,
			            InternalPortletWindow internalPortletWindow,
			            HttpServletRequest servletRequest,
			            HttpServletResponse servletResponse) {
		super(container, internalPortletWindow, servletRequest,
		servletResponse);
		context = container.getRequiredContainerServices().getPortalContext();
		callback = container.getRequiredContainerServices().getPortalCallbackService();
	}
	
	/* (non-Javadoc)
	 * @see javax.portlet.StateAwareResponse#setEvent(javax.xml.namespace.QName, java.lang.Object)
	 */
	public void setEvent(QName qname, Object value) {
		EventProvider provider = callback.getEventProvider(
				getHttpServletRequest(),getHttpServletResponse());
		
		XMLStreamReader xml = null;
		try {
			
			EventDefinitionDD eventDefinitionDD = provider.getEventDefinition(qname);
			if (value != null && eventDefinitionDD == null) {
				// TODO: throw the right exception
				throw new PortletException("No Event Defintion!");
			} if (eventDefinitionDD == null) {
				// TODO: throw the right exception
				throw new PortletException("No Event Defintion!");
			}
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Class clazz = loader.loadClass(eventDefinitionDD.getJavaClass());

			JAXBContext jc = JAXBContext.newInstance(clazz);

			Marshaller marshaller  = jc.createMarshaller();
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, 
					Boolean.TRUE );

			Writer out = new StringWriter();

			marshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

			marshaller.marshal(new JAXBElement(
					eventDefinitionDD.getName(),clazz,value), out);

			Reader in = new StringReader(out.toString());

			xml = XMLInputFactory.newInstance().createXMLStreamReader(in);

			if (xml != null) {
				provider.registerToFireEvent(new EventImpl(qname,xml));
			} else { 
				provider.registerToFireEvent(new EventImpl(qname,value));
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortletContainerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MarshalException e) {
			// there is no valid jaxb binding
			e.printStackTrace();
		} catch (JAXBException e) {
			// maybe there is no valid jaxb binding
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/* (non-Javadoc)
	 * @see javax.portlet.StateAwareResponse#setEvents(java.util.Map)
	 */
	public void setEvents(Map events) {
		Set keys = events.keySet();
		for (Object key : keys) {
			setEvent((QName)key,events.get(key));
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServletResponseWrapper#sendRedirect(java.lang.String)
	 */
	public void sendRedirect(String location) throws java.io.IOException {
        if (redirectAllowed) {
            if (location != null) {
                HttpServletResponse redirectResponse = getHttpServletResponse();
                while (redirectResponse instanceof HttpServletResponseWrapper) {
                    redirectResponse = (HttpServletResponse)
                        ((HttpServletResponseWrapper)redirectResponse).getResponse();
                }

                ResourceURLProvider provider = callback.getResourceURLProvider(
                                getHttpServletRequest(),
                                getInternalPortletWindow()
                );

                if (location.indexOf("://") != -1) {
                    provider.setAbsoluteURL(location);
                } else {
                    provider.setFullPath(location);
                }
                location =
                redirectResponse.encodeRedirectURL(provider.toString());
                //redirectResponse.sendRedirect(location);
                redirectLocation = location;
                redirected = true;
            }
        } else {
            throw new java.lang.IllegalStateException(
                "Can't invoke sendRedirect() after certain methods have been called");
        }

    }

    

    public String getRedirectLocation() {
        return redirectLocation;
    }
	//
//	 javax.portlet.ActionResponse
	//
    public void setWindowState(WindowState windowState)
        throws WindowStateException {
        if (redirected) {
            throw new IllegalStateException(
                "it is not allowed to invoke setWindowState after sendRedirect has been called");
        }

        if (isWindowStateAllowed(windowState)) {
            this.windowState = windowState;
        } else {
            throw new WindowStateException("Can't set this WindowState",
                                           windowState);
        }
        redirectAllowed = false;
    }
	    
    public void setPortletMode(PortletMode portletMode)
        throws PortletModeException {
        if (redirected) {
            throw new IllegalStateException(
                "it is not allowed to invoke setPortletMode after sendRedirect has been called");
        }

        // check if portal supports portlet mode
        boolean supported = isPortletModeAllowed(portletMode);


        // if porlet mode is allowed
        if (supported) {
            this.portletMode = portletMode;
        } else {
            throw new PortletModeException("Can't set this PortletMode",
                                           portletMode);
        }

        redirectAllowed = false;

    }
    
    public void setRenderParameters(Map parameters) {
        if (redirected) {
            throw new IllegalStateException(
                "Can't invoke setRenderParameters() after sendRedirect() has been called");
        }
        if (parameters == null) {
            throw new IllegalArgumentException(
                "Render parameters must not be null.");
        }
        for (Iterator iter = parameters.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException(
                    "Key must not be null and of type java.lang.String.");
            }
            if (!(entry.getValue() instanceof String[])) {
                throw new IllegalArgumentException(
                    "Value must not be null and of type java.lang.String[].");
            }
        }

        renderParameters = StringUtils.copyParameters(parameters);

        redirectAllowed = false;
    }
    
    public void setRenderParameter(String key, String value) {
        if (redirected) {
            throw new IllegalStateException(
                "Can't invoke setRenderParameter() after sendRedirect() has been called");
        }

        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException(
                "Render parameter key or value must not be null.");
        }

        renderParameters.put(key, new String[]{value});

        redirectAllowed = false;
    }
    
    public void setRenderParameter(String key, String[] values) {
        if (redirected) {
            throw new IllegalStateException(
                "Can't invoke setRenderParameter() after sendRedirect() has been called");
        }

        if (key == null || values == null || values.length == 0) {
            throw new IllegalArgumentException(
                "Render parameter key or value must not be null or values be an empty array.");
        }

        renderParameters.put(key, StringUtils.copy(values));

        redirectAllowed = false;
    }
    // --------------------------------------------------------------------------------------------
    
    // org.apache.pluto.core.InternalActionResponse implementation --------------------------------
    public Map getRenderParameters() {
        return renderParameters;
    }
    
    public Map getRenderParameterMap() {
		return renderParameters;
	}

    public PortletMode getChangedPortletMode() {
        return this.portletMode;
    }
    
    public PortletMode getPortletMode() {
		return getChangedPortletMode();
	}

    public WindowState getChangedWindowState() {
        return this.windowState;
    }
    
    public WindowState getWindowState() {
		return getChangedWindowState();
	}
    
    private boolean isPortletModeAllowed(PortletMode mode) {
        return isPortletModeAllowedByPortlet(mode)
               && isPortletModeAllowedByPortal(mode);
    }

    private boolean isPortletModeAllowedByPortlet(PortletMode mode) {
        PortletDD dd = getInternalPortletWindow().getPortletEntity()
            .getPortletDefinition();

        Iterator supports = dd.getSupports().iterator();
        while(supports.hasNext()) {
            SupportsDD sup = (SupportsDD)supports.next();
            Iterator modes = sup.getPortletModes().iterator();
            while(modes.hasNext()) {
                if (modes.next().toString().equalsIgnoreCase(mode.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPortletModeAllowedByPortal(PortletMode mode) {
        Enumeration supportedModes = context.getSupportedPortletModes();
        while (supportedModes.hasMoreElements()) {
            if (supportedModes.nextElement().toString().equalsIgnoreCase(
                (mode.toString()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isWindowStateAllowed(WindowState state) {
        Enumeration supportedStates = context.getSupportedWindowStates();
        while (supportedStates.hasMoreElements()) {
            if (supportedStates.nextElement().toString().equalsIgnoreCase(
                (state.toString()))) {
                return true;
            }
        }
        return false;
    }

	public void setNextPossiblePortletModes(Enumeration portletModes) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void setDefaultNamspacedEvents(Map<String, Object> events) {
		// TODO Auto-generated method stub
		
	}

	public void setEvent(String name, Object value) {
		// TODO Auto-generated method stub
		
	}
}
