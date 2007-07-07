package org.apache.pluto.driver.url.impl;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParser;

/**
 * TestPortalURLParser.java
 * Unit Test for Defect PLUTO-361
 */
public class TestPortalURLParser extends TestCase
{
	private static final Log LOG = LogFactory.getLog( TestPortalURLParser.class );

	private PortalURLParser parser;
	private MockHttpServletRequest request;
	private Throwable throwable = null;

	public void test_DefectPLUTO_361()
	{
		// This is a well formed request.
    	this.request = new MockHttpServletRequest();
    	this.request.setContextPath( "/pluto" );
    	this.request.setRequestURI( "/pluto/portal//Test%20Page/__ac0x3testsuite0x2TestPortlet1!764587357|0" );
    	this.request.setRequestURL( "http://localhost:8080/pluto/portal//Test%20Page/__ac0x3testsuite0x2TestPortlet1!764587357|0" );
    	this.request.setQueryString( "testId=0&org.apache.pluto.testsuite.PARAM_ACTION_KEY=org.apache.pluto.testsuite.ACTION_VALUE" );
    	this.request.setPathInfo( "/Test Page/__ac0x3testsuite0x2TestPortlet1!764587357|0" );

    	try
    	{
    		PortalURL portalURL = this.parser.parse( this.request );
    	} catch( Throwable t ) {
    		this.throwable = t;
    		LOG.error( "ERROR:", t );
    	}
    	assertNull( "No exception should be thrown", this.throwable );
    	this.throwable = null;

		// Not so well formed request as per defect PLUTO-361
    	this.request = new MockHttpServletRequest();
    	this.request.setContextPath( "/pluto" );
    	this.request.setRequestURI( "/pluto/portal/__" );
    	this.request.setRequestURL( "http://localhost:8080/pluto/portal/__" );
    	this.request.setPathInfo( "/__" );

    	try
    	{
    		PortalURL portalURL = this.parser.parse( this.request );
    	} catch( Throwable t ) {
    		this.throwable = t;
    		LOG.error( "ERROR:", t );
    	}
    	assertNull( "No exception should be thrown", this.throwable );
    	this.throwable = null;
	}

    protected void setUp() throws Exception
    {
    	this.parser = PortalURLParserImpl.getParser();
    }
}
