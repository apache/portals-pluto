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

import org.apache.pluto.binding.impl.digester.DigesterXMLBinding;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Feb 23, 2004 at 8:02:50 PM
 */
public abstract class XMLBinding {

    public static final int READ_ONLY = 0;
    public static final int READ_WRITE = 1;

    private static XMLBinding binding;
    public static XMLBinding getXMLBinding() {
        return getXMLBinding(READ_ONLY);
    }

    public static XMLBinding getXMLBinding(int mode) {
        if(binding==null) {
            String clName = System.getProperty(XMLBinding.class.getName());
            if(clName!=null) {
                try {
                    Class cl = Class.forName(clName);
                    binding = (XMLBinding)cl.newInstance();
                }
                catch(Throwable t) {
                    System.out.println("Unable to instantiate XMLBinding ["+
                                       clName+"] :"+t.getMessage());
                    System.out.println("Using default XMLBinding");
                }
            }
            if(binding==null)
                binding = new DigesterXMLBinding();
        }
        return binding;
    }

    public abstract boolean isMutableSupported();

    public abstract WebAppDD getWebAppDD(InputStream in)
        throws IOException;

    public abstract PortletAppDD getPortletAppDD(InputStream in)
        throws IOException;
}
