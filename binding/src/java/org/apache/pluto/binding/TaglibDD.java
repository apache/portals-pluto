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

/**
 * Taglibrary definition as defined by the <code>web.xml</code>
 * deployment descriptor.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Feb 24, 2004 at 7:26:56 PM
 */
public interface TaglibDD {
    String getTaglibUri();

    String getTaglibLocation();

    void setTaglibUri(String uri);

    void setTaglibLocation(String location);
}
