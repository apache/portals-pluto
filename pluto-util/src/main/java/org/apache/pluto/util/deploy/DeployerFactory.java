/*
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.util.deploy;

/**
 * The pluto deployer factory that creates a deployer instance to deploy portlet
 * applications to pluto.
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Oct 28, 2004
 */
public class DeployerFactory {
	
    /** The property key to the deployer class name. */
    private static final String DEPLOYER_KEY = Deployer.class.getName();
    
    /** FIXME: abstract class! The default deployer class name. */
    private static final String DEFAULT_DEPLOYER_CLASS =
    		"org.apache.pluto.util.deploy.impl.FileSystemDeployer";
    
	/** The singleton factory instance. */
    private static final DeployerFactory FACTORY = new DeployerFactory();
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Private constructor that prevents external instantiation.
     */
    private DeployerFactory() {
    	// Do nothing.
    }
    
    /**
     * Returns the singleton factory instance.
     * @return the singleton factory instance.
     */
    public static DeployerFactory getFactory() {
        return FACTORY;
    }
    
    
    // Public Methods ----------------------------------------------------------
    
    /**
     * Creates a pluto deployer to deploy portlet applications to pluto.
     * @return a pluto deployer.
     */
    public Deployer createFactory() {
        String className = System.getProperty(DEPLOYER_KEY);
        if (className == null || className.trim().length() == 0) {
        	className = DEFAULT_DEPLOYER_CLASS;
        }
        try {
            Class clazz = Class.forName(className);
            return (Deployer) clazz.newInstance();
        } catch (Throwable th) {
        	System.err.println("Unable to create deployer from: " + className);
            th.printStackTrace();
            return null;
        }
    }

}

