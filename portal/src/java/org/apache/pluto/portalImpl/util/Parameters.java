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

package org.apache.pluto.portalImpl.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class Parameters extends NameValuePairs
{

    private final static String RAW_ENCODING     = "8859_1";
    private final static String DEFAULT_ENCODING = "UTF-8";

    public Parameters (Map params)
    {
        Iterator iterator = params.keySet().iterator();

        while (iterator.hasNext())
        {
            String name = (String)iterator.next();

            super.add (name, (String)params.get(name));
        }
    }

    public Parameters (ServletConfig aConfig)
    {
        for (Enumeration e = aConfig.getInitParameterNames (); e.hasMoreElements ();)
        {
            String name = (String) e.nextElement ();

            super.add (name, aConfig.getInitParameter (name));
        }
    }

    public Parameters (ServletContext aContext)
    {
        for (Enumeration e = aContext.getInitParameterNames (); e.hasMoreElements ();)
        {
            String name = (String) e.nextElement ();

            super.add (name, aContext.getInitParameter (name));
        }
    }

    public void setString(String aKey, String aValue)
    {
        if (aKey == null)
            throw (new IllegalArgumentException("Parameters: Argument \"aKey\" cannot be null."));
        if (aValue == null)
            throw (new IllegalArgumentException("Parameters: Argument \"aValue\" cannot be null."));

        super.add(aKey, aValue);
    }

    /**
     ** Removes all values with the given name.
     **
     ** @param   aName
     **          the name of a pair
     **/

    public void remove (String aName)
    {
        super.removeEntry (aName);
    }

    /**
     ** Removes all values with names that start with the given prefix.
     **
     ** @param   aPrefix
     **          the name prefix
     **/

    public void removeWithPrefix (String aPrefix)
    {
        List deletables = new ArrayList ();

        for (Iterator iter = names (); iter.hasNext (); )
        {
            String name = (String) iter.next ();

            if (name.startsWith (aPrefix))
            {
                deletables.add (name);
            }
        }

        for (Iterator iter = deletables.iterator (); iter.hasNext (); )
        {
            super.removeEntry ((String) iter.next ());
        }
    }
}
