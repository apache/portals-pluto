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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Iterator;

/**
 ** This class loads name/value pairs from a properties
 ** file. The properties file is specified as input stream
 ** and follows the usual convention for Java properties files.
 **/

public class Properties extends NameValuePairs
{

    /**
     ** Loads name/value pairs from the given input stream.
     **/

    public void load (InputStream aInputStream) throws IOException
    {
        if (aInputStream == null)
            return;

        BufferedReader reader = new BufferedReader (new InputStreamReader (aInputStream, "UTF-8"));

        String line;

        while ((line = reader.readLine ()) != null)
        {
            if (line.startsWith ("#") ||
                line.startsWith ("//"))
            {
                continue;
            }

            int index = line.indexOf ('=');

            if (index > 0)
            {
                String name  = line.substring (0, index).trim ();

                if (name.length () == 0)
                    name = null;

                String value = null;

                if (index + 1 < line.length ())
                {
                    value = line.substring (index + 1).trim ();

                    if (value.length () == 0)
                        value = null;
                }

                if (name != null && value != null)
                {
                    add (name, value);
                }
            }
        }
    }


    /**
     ** Returns a subset of the NameValuePairs where the names are starting with the specified prefix.
     ** As keys of the result set all start with the same prefix, this prfix is cut off.</br>
     ** E.g:</br>
     ** Given following set: {[A1,x], [A2,y], [A3,z], [B1,x], [B2,y]]}</br>
     ** getSubSet("A") returns {[1,x], [2,y], [3,z]}</p>
     **
     ** Please note: the implementation of this method is <b>slow</b>, to be used only for initialisation tasks or alike!
     **
     ** @param   aNamePrefix
     **          the prefix that all returned pair names have in common.
     **/

    public Properties getSubSet (String aNamePrefix)
    {
        Properties subset = new Properties();
        int prefixLength = aNamePrefix.length();
        String name;

        for (Iterator iter = this.names (); iter.hasNext () ; )
        {
            name = (String) iter.next ();

            if (name.startsWith(aNamePrefix))
            {
                subset.add( name.substring(prefixLength), getStrings(name));
            }
        }
        return (subset);
    }
}
