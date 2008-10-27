package org.apache.pluto.descriptors.services.jaxb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.pluto.descriptors.portlet.PortletAppType;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.spi.optional.PortletAppDescriptorService;

/** 
 *  JAXB implementation of the xml2java binding
 *  @author <a href="mailto:chrisra@cs.uni-jena.de">Christian Raschka</a>
 */

public class PortletAppDescriptorServiceImpl implements PortletAppDescriptorService{
	
    public PortletApplicationDefinition createPortletApplicationDefinition()
    {
        return new PortletAppType();
    }
    
	/**
     * Read the Web Application Deployment Descriptor.
     *
     * @return WebAppDD instance representing the descriptor.
     * @throws java.io.IOException
     */
    
    @SuppressWarnings("unchecked")
    public PortletApplicationDefinition read(InputStream in) throws IOException {
    	JAXBElement app = null;
    	try {
    		JAXBContext jc = JAXBContext.newInstance( 
    				"org.apache.pluto.descriptors.portlet10" + ":" +
    				"org.apache.pluto.descriptors.portlet", PortletAppDescriptorServiceImpl.class.getClassLoader());

    		Unmarshaller u = jc.createUnmarshaller();
    		u.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());

    		app = (JAXBElement) u.unmarshal(in);	            
    	}catch (JAXBException jaxbEx){
    		jaxbEx.printStackTrace();
    		throw new IOException(jaxbEx.getMessage());
    	}
    	catch(Exception me) {
    		throw new IOException(me.getLocalizedMessage());
    	}
    	if (app.getValue() instanceof org.apache.pluto.descriptors.portlet10.PortletAppType)
    	{
    	    return ((org.apache.pluto.descriptors.portlet10.PortletAppType)app.getValue()).upgrade();
    	}    	
    	return (PortletApplicationDefinition)app.getValue();
    }
    
    /**
     * Write the deployment descriptor.
     * @param app
     * @throws java.io.IOException
     */
    public void write(PortletApplicationDefinition app, OutputStream out) throws IOException {
        try {
            JAXBContext jc = null;
            Object src = null;
            if (PortletApplicationDefinition.JSR_168_VERSION.equals(app.getVersion()))
            {                
                jc = JAXBContext.newInstance("org.apache.pluto.descriptors.portlet10");                
                src = new org.apache.pluto.descriptors.portlet10.PortletAppType(app);
            }
            else
            {
                jc = JAXBContext.newInstance("org.apache.pluto.descriptors.portlet");
                src = app;
            }
            Marshaller m = jc.createMarshaller();
            m.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            m.marshal(src,out);
        }catch (JAXBException jaxbEx){
            jaxbEx.printStackTrace();
            throw new IOException(jaxbEx.getMessage());
        }
        catch(Exception me) {
            throw new IOException(me.getLocalizedMessage());
        }
    }
}
