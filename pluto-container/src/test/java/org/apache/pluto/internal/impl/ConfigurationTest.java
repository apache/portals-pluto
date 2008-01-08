package org.apache.pluto.internal.impl;

import org.apache.pluto.util.PlutoTestCase;

public class ConfigurationTest extends PlutoTestCase {

	public void testGetSupportedContainerRuntimeOptions(){
		assertEquals(Configuration.getSupportedContainerRuntimeOptions().size(), 3);
		assertEquals(Configuration.getSupportedContainerRuntimeOptions().get(0),"test");
		assertEquals(Configuration.getSupportedContainerRuntimeOptions().get(1),"escapeXML");
		assertEquals(Configuration.getSupportedContainerRuntimeOptions().get(2),"value");
		
	}
	
}
