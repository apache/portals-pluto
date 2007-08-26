package org.apache.pluto.internal.impl;

import org.apache.pluto.spi.ResourceURLProvider;

/**
 * A ResourceURLProvider which returns the URL path in its <code>toString()</code> method.
 */
public class MockResourceUrlProviderImpl implements ResourceURLProvider
{    
    private String path = null;
    
    public void setAbsoluteURL( String path )
    {
        this.path = path;
    }

    public void setFullPath( String path )
    {
        this.path = "http://localhost/" + path;        
    }
    
    public String toString( )
    {
        return path;
    }
}
