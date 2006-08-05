/*
 * Created on Feb 27, 2006
 */
package org.apache.pluto.descriptors.servlet;

import org.exolab.castor.mapping.AbstractFieldHandler;

public class ServletVersionCastorFieldHandler extends AbstractFieldHandler {

    public Object getValue( Object webAppDD ) throws IllegalStateException {
        if (! (webAppDD instanceof WebAppDD)) {
            throw new ClassCastException("Error: the passed in type must be a org.apache.pluto.descriptors.servlet.WebAppDD");
        }        
        WebAppDD webApp = (WebAppDD)webAppDD;
        if (webApp.getServletVersion().equals("2.3")) {
            return null;
        } else {
            return webApp.getServletVersion();
        }
    }

    public Object newInstance( Object arg0 ) throws IllegalStateException {
        // Do nothing.
        return null;
    }

    public Object newInstance( Object arg0, Object[] arg1 )
            throws IllegalStateException {
        // Do nothing.
        return null;
    }

    public void resetValue( Object arg0 ) throws IllegalStateException,
            IllegalArgumentException {
        // Do nothing.

    }

    public void setValue( Object webAppDD, Object servletVersionValue )
            throws IllegalStateException, IllegalArgumentException {
        if (! (webAppDD instanceof WebAppDD)) {
            throw new ClassCastException("Error: the passed in type must be a org.apache.pluto.descriptors.servlet.WebAppDD");
        }
        
        if (! (servletVersionValue instanceof String)) {
            throw new ClassCastException("Error: the passed in type must be a java.lang.String");
        }

        ((WebAppDD) webAppDD).setServletVersion((String) servletVersionValue);
    }

}
