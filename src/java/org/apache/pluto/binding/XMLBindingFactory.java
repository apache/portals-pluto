/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.pluto.binding;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pluto.binding.impl.digester.DigesterXMLBindingFactory;

/**
 * <P>Factory used to read (and potentially) write deployment descriptors,
 * specifically Portlet Application (<code>portlet.xml</code>) and Web
 * application (<code>web.xml</code> descriptors.</P>
 *
 * <P>These bindingFactory functions have been abstracted from the container because
 * of the frequency with which they are needed externally.  Tools such as the
 * pluto deployer depend on the ability to read these descriptors but rarely
 * need the remainder of the container during runtime.</P>
 *
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Feb 23, 2004 at 8:02:50 PM
 */
public abstract class XMLBindingFactory {

    /** Mode flag identifying the bindingFactory factory as read only. */
    public static final int READ_ONLY = 0;

    /** Mode flag identifying the bindingFactory factory as read/write. */
    public static final int READ_WRITE = 1;

    private static XMLBindingFactory bindingFactory;

    /**
     * Create an instance of the default <code>XMLBindingFactory</code>.
     */
    public static XMLBindingFactory createXMLBinding() {
        return createXMLBinding(READ_ONLY);
    }

    /**
     * Create an instance of the <code>XMLBindingFactory</code>
     * which supports the given mode.
     *
     * @param mode
     * @return an XMLBindingFactory instance which supports the given mode.
     */
    public static XMLBindingFactory createXMLBinding(int mode) {
        if (bindingFactory == null) {
            String clName = System.getProperty(XMLBindingFactory.class.getName());
            if (clName != null) {
                try {
                    Class cl = Class.forName(clName);
                    bindingFactory = (XMLBindingFactory) cl.newInstance();
                } catch (Throwable t) {
                    System.out.println("Unable to instantiate XMLBindingFactory [" +
                                       clName + "] :" + t.getMessage());
                    System.out.println("Using default XMLBindingFactory");
                }
            }
            if (bindingFactory == null) {
                bindingFactory = new DigesterXMLBindingFactory();
            }
        }
        return bindingFactory;
    }

    /**
     * Retrieve the mode this factory supports.
     * @return
     */
    public abstract int getMode();

    /**
     * Retrieve the Web Application deployment descriptor
     * (<code>web.xml</code>) read from the given <code>InputStream</code>
     *
     * @param in the <code>InputStream<code> from which the descriptor should be parsed.
     * @return an object representation of the descriptor.
     * @throws IOException if a read error occurs.
     *
     */
    public abstract WebAppDD getWebAppDD(InputStream in)
        throws IOException;

    /**
     * Retrieve the Portlet Application deployment descriptor
     * (<code>portlet.xml</code>) read from the given <code>InputStream</code>
     *
     * @param in
     * @return
     * @throws IOException
     */
    public abstract PortletAppDD getPortletAppDD(InputStream in)
        throws IOException;
}
