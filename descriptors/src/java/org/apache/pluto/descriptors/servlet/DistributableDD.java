package org.apache.pluto.descriptors.servlet;

/**
 * Simple bean which models the <code>&lt;distributable/&gt;</code> web.xml element.  
 * 
 * The <code>isDistributable()</code> method returns <code>Boolean.FALSE</code> 
 * by default.
 * 
 * 
 * @author <a href="mailto:esm@apache.org">Elliot Metsger</a>
 * @version $Id$
 * @since Jul 18, 2006
 */
public class DistributableDD {
    
    private boolean distributable = false;
    
    public DistributableDD() {
        
    }
   
    public Boolean isDistributable() {        
        return new Boolean(distributable);
    }    
    
    public void setDistributable(boolean distributable) {
        this.distributable = distributable;        
    }

}
