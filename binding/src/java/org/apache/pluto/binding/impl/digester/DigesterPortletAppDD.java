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
package org.apache.pluto.binding.impl.digester;

import java.util.ArrayList;

import org.apache.pluto.binding.InitParameterDD;
import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.PortletDD;

/**
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 5:15:34 PM
 */
public class DigesterPortletAppDD implements PortletAppDD {

    private ArrayList portlets;
    private ArrayList params;

    public DigesterPortletAppDD() {
        portlets = new ArrayList();
        params = new ArrayList();
    }

    public PortletDD[] getPortlets() {
        return (PortletDD[]) portlets.toArray(new PortletDD[portlets.size()]);
    }

    public void addPortlet(PortletDD dd) {
        portlets.add(dd);
    }

    public InitParameterDD[] getInitParameters() {
        return (InitParameterDD[]) params.toArray(
            new InitParameterDD[params.size()]);
    }

    public void addInitParameter(InitParameterDD dd) {
        params.add(dd);
    }
}
