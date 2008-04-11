package org.apache.pluto.descriptors.services.jaxb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
import org.apache.pluto.om.portlet.PortletApp;

/** 
 *  JAXB implementation of the xml2java binding
 *  @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 */

public class PortletAppDescriptorServiceImpl implements PortletAppDescriptorService{
	
	/**
     * Read the Web Application Deployment Descriptor.
     *
     * @return WebAppDD instance representing the descriptor.
     * @throws java.io.IOException
     */
    
    public PortletApp read(InputStream in) throws IOException {
    	JAXBElement<PortletApp> portletApp = null;
    	try {
    		JAXBContext jc = JAXBContext.newInstance( 
    				"org.apache.pluto.descriptors.portlet" + ":" +
    				"org.apache.pluto.descriptors.common");

    		Unmarshaller u = jc.createUnmarshaller();
    		u.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

    		portletApp = (JAXBElement<PortletApp>) u.unmarshal(in);	            
    	}catch (JAXBException jaxbEx){
    		jaxbEx.printStackTrace();
    		throw new IOException(jaxbEx.getMessage());
    	}
    	catch(Exception me) {
    		throw new IOException(me.getLocalizedMessage());
    	}

    	return portletApp.getValue();
    }
    
    /**
     * Write the deployment descriptor.
     * @param portlet
     * @throws java.io.IOException
     */
    public void write(PortletApp portlet, OutputStream out) throws IOException {
    	throw new UnsupportedOperationException("writing jaxb content not yet supported");
    }
}
