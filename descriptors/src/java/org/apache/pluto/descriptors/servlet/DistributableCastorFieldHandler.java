package org.apache.pluto.descriptors.servlet;
import org.exolab.castor.mapping.AbstractFieldHandler;

/**
 * Intercepts Castor's access the DistributableDD field.  
 * 
 * The handler always returns <code>null</code> when the <code>getValue(Object)</code> 
 * method is called, ensuring that an empty &lt;distributable/&gt; is placed in
 * the web deployment descriptor per Servlet 2.3 specifications.
 * 
 * @author <a href="mailto:esm@apache.org">Elliot Metsger</a>
 * @version $Id$
 * @since Jul 18, 2006
 * @see org.apache.pluto.descriptors.servlet.DistributableDD
 * @see <a href="http://www.castor.org/api/org/exolab/castor/mapping/FieldHandler.html">org.exolab.castor.mapping.FieldHandler</a>
 */ 
public class DistributableCastorFieldHandler extends AbstractFieldHandler {

    public DistributableCastorFieldHandler( ) {        

    }
    
    public void setValue( Object object, Object value )
            throws IllegalStateException, IllegalArgumentException {
        DistributableDD distDD = null;
        Boolean isDistributable = null;
        
        if (! (object instanceof DistributableDD)) {
            throw new IllegalArgumentException( "Supplied object should be of type DistributableDD" );
        } else {
            distDD = (DistributableDD)object;
        }
        
        if (! (value instanceof Boolean)) {
            throw new IllegalArgumentException( "Supplied value should be of type Boolean" );
        } else {
            isDistributable = (Boolean)value;
            distDD.setDistributable(isDistributable.booleanValue());
        }                
    }
    
    public Object getValue( Object object ) throws IllegalStateException {
        // we always return null.  A null return value will have the
        // effect of placing an empty <distributable/> element in the
        // deployment descriptor.
        return null;
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