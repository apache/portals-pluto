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

/** Implemented by the binding provider in order to
 *  represent a PortletDD Binding.
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Feb 24, 2004 at 7:52:06 PM
 */
public interface PortletDD {

    String getDescription();
    String getPortletName();
    String getDisplayName();
    String getPortletClass();
    InitParameterDD[] getInitParameters();

    int getExpirationCache();

    String[] getSupportedMimeTypes();
    String[] getSupportedPortletModes();
    String[] getSupportedLocales();

    PortletInfoDD getPortletInfo();
    PortletPreferenceDD[] getPortletPreferences();
    String getPreferenceValidator();

    // For now I don't care about the rest,
    // just make sure that anything that's loaded
    // gets spit back out.!!!

}
