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
package org.apache.pluto.portalImpl.portlet;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

/**
 * @author <a href="ddewolf@apache.com">David H. DeWolf</a>
 *
 */
public class TestConfigFactory {

    private Digester digester = new Digester();

    public TestConfigFactory() {
        digester = new Digester();
        digester.addObjectCreate("testportlet-config",
                                 java.util.ArrayList.class);

        digester.addObjectCreate("testportlet-config/testsuite-config",
                                 TestConfig.class);

        digester.addBeanPropertySetter("testportlet-config/testsuite-config/name",
                                       "name");

        digester.addBeanPropertySetter("testportlet-config/testsuite-config/class",
                                       "testClassName");

        digester.addBeanPropertySetter("testportlet-config/testsuite-config/display-uri",
                                       "displayURI");

        digester.addSetRoot("testportlet-config/testsuite-config",
                            "add");

    }

    public List createTests(InputStream in)
    throws SAXException, IOException {
        return (List)digester.parse(in);
    }
}
