package org.apache.pluto.descriptors.servlet;

import org.exolab.castor.mapping.AbstractFieldHandler;

/**
 * Intercepts Castor's access the Distributable field.  
 * 
 * The handler returns a {@link DistributableDD} object if the application 
 * is marked as distributable in its web deployment descriptor.  If the application 
 * is not marked as distributable, then <code>null</code> is returned.
 *  
 * 
 * @author <a href="mailto:esm@apache.org">Elliot Metsger</a>
 * @version $Id$
 * @since Jul 18, 2006
 * @see org.apache.pluto.descriptors.servlet.DistributableDD
 * @see <a href="http://www.castor.org/api/org/exolab/castor/mapping/FieldHandler.html">org.exolab.castor.mapping.FieldHandler</a>
 */
public class DistributableDDCastorFieldHandler extends AbstractFieldHandler {

    public DistributableDDCastorFieldHandler( ) {        

    }
    
    public Object getValue( Object object ) throws IllegalStateException {
        WebAppDD webDD = null;
        
        if ( object == null ) {
            return null;
        }
        
        if ( object instanceof WebAppDD ) {
            webDD = (WebAppDD)object;
        } else {
            throw new IllegalStateException( "Supplied object should be of type WebAppDD" );
        }
         
        // check the underlying field value (a DistributeableDD object) 
        // to see if the web-app is distributable
        if ( webDD.getDistributable().isDistributable().equals(Boolean.FALSE)) {
            // since it is not distributable, return null.  That way
            // Castor won't place a <distributable/> element in the web.xml
            return null;
        } else {
            // it is distributable, so return the
            // DistributableDD object.
            return webDD.getDistributable();
        }                
    }

    public void setValue( Object object, Object value )
            throws IllegalStateException, IllegalArgumentException {
        WebAppDD webDD = null;
        DistributableDD distDD = null;
        
        if (! (object instanceof WebAppDD)) {
            throw new IllegalArgumentException( "Supplied object should be of type WebAppDD" );
        } else {
            webDD = (WebAppDD)object;
        }
        
        if (! (value instanceof DistributableDD)) {
            throw new IllegalArgumentException( "Supplied value should be of type DistributableDD" );
        } else {
            distDD = (DistributableDD)value;
            distDD.setDistributable(true);
        }
        
        webDD.setDistributable(distDD);
    }
    
    public Object newInstance( Object arg0 ) throws IllegalStateException {
        // do nothing
        return null;
    }

    public Object newInstance( Object arg0, Object[] arg1 )
            throws IllegalStateException {
        // do nothing
        return null;
    }

    public void resetValue( Object arg0 ) throws IllegalStateException,
            IllegalArgumentException {
        // do nothing
    }
}