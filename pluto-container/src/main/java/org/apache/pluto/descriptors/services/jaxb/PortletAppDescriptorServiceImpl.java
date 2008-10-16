package org.apache.pluto.descriptors.services.jaxb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.pluto.descriptors.services.jaxb.PortletAppDescriptorService;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;

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
    
    @SuppressWarnings("unchecked")
    public PortletApplicationDefinition read(InputStream in) throws IOException {
    	JAXBElement<PortletApplicationDefinition> portletApp = null;
    	try {
    		JAXBContext jc = JAXBContext.newInstance( 
    				"org.apache.pluto.descriptors.portlet10" + ":" +
    				"org.apache.pluto.descriptors.portlet20", PortletAppDescriptorServiceImpl.class.getClassLoader());

    		Unmarshaller u = jc.createUnmarshaller();
    		u.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

    		portletApp = (JAXBElement<PortletApplicationDefinition>) u.unmarshal(in);	            
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
    public void write(PortletApplicationDefinition portlet, OutputStream out) throws IOException {
        try {
            JAXBContext jc = null;
            if (portlet.getVersion().equals("1.0"))
            {
                jc = JAXBContext.newInstance("org.apache.pluto.descriptors.portlet10");
            }
            else
            {
                jc = JAXBContext.newInstance("org.apache.pluto.descriptors.portlet20");
            }
            Marshaller m = jc.createMarshaller();
            m.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            m.marshal(portlet,out);
        }catch (JAXBException jaxbEx){
            jaxbEx.printStackTrace();
            throw new IOException(jaxbEx.getMessage());
        }
        catch(Exception me) {
            throw new IOException(me.getLocalizedMessage());
        }
    }
}
