/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.portalImpl.om.common.impl;

import java.util.Iterator;
import java.util.Locale;

import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.DisplayNameSet;
import org.apache.pluto.portalImpl.om.common.AbstractSupportSet;
import org.apache.pluto.portalImpl.om.common.Support;
import org.apache.pluto.util.StringUtils;

public class DisplayNameSetImpl extends AbstractSupportSet implements DisplayNameSet, java.io.Serializable, Support {

    // DisplayNameSet implementation.
    
    public DisplayName get(Locale locale)
    {        
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            DisplayName displayName = (DisplayName)iterator.next();
            if (displayName.getLocale().equals(locale)) {
                return displayName;
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
            ((DisplayNameImpl) iterator.next()).postLoad(parameter);
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

    // additional methods.

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
            buffer.append(((DisplayNameImpl)iterator.next()).toString(indent+2));
        }
        return buffer.toString();
    }


}
