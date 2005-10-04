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

 */

package org.apache.pluto.portalImpl.om.common.impl;

import java.util.Iterator;
import java.util.Locale;

import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.portalImpl.om.common.AbstractSupportSet;
import org.apache.pluto.portalImpl.om.common.Support;
import org.apache.pluto.util.StringUtils;

public class DescriptionSetImpl extends AbstractSupportSet implements DescriptionSet, java.io.Serializable, Support {

    // DescriptionSet implemenation.
    public Description get(Locale locale)
    {        
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Description desc = (Description)iterator.next();
            if (desc.getLocale().equals(locale)) {
                return desc;
            }
        }
        return null;
    }

    // Support implementation.
    
    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#postBuild(Object)
     */
    public void postBuild(Object parameter) throws Exception {
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#postLoad(Object)
     */
    public void postLoad(Object parameter) throws Exception {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            ((DescriptionImpl)iterator.next()).postLoad(parameter);
        }
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#postStore(Object)
     */
    public void postStore(Object parameter) throws Exception {
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#preBuild(Object)
     */
    public void preBuild(Object parameter) throws Exception {
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.portalImpl.om.common.Support#preStore(Object)
     */
    public void preStore(Object parameter) throws Exception {
    }

    // additional methods


    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(50);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString());
        buffer.append(": ");
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            buffer.append(((DescriptionImpl)iterator.next()).toString(indent+2));
        }
        return buffer.toString();
    }

}
