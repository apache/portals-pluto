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

import org.apache.pluto.util.StringUtils;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 ** This class collects name/value pairs and provides
 ** convenient methods to access them as different types.
 **
 ** @see   Properties
 ** @see   Parameters
 **/

public abstract class NameValuePairs
{

    /**
     ** Returns the number of name/value pairs. Names
     ** that have more than one value are counted as one name.
     **
     ** @return   the number of name/value pairs
     **/

    public int size ()
    {
        return (iEntries.size ());
    }

    /**
     ** Returns the value for the given name as string,
     ** or <CODE>null</CODE> if there is no pair with the given name.
     **
     ** @param   aName
     **          the name of a pair
     **
     ** @param   the value of the pair
     **/

    public String getString (String aName)
    {
        return (findString (aName));
    }

    /**
     ** Returns the value for the given name as string,
     ** or the given default if there is no pair with the given name.
     **
     ** @param   aName
     **          the name of a pair
     ** @param   aDefault
     **          the default value
     **
     ** @param   the value of the pair
     **/

    public String getString (String aName, String aDefault)
    {
        String result = findString (aName);

        if (result == null)
            result = aDefault;

        return (result);
    }

    /**
     ** Returns all values for the given name as a string array,
     ** or <CODE>null</CODE> if there is no pair with the given name.
     **
     ** @param   aName
     **          the name of a pair
     **
     ** @param   the values of the pair
     **/

    public String [] getStrings (String aName)
    {
        String [] result = null;

        Entry entry = findEntry (aName);

        if (entry != null)
            result = entry.iValues;

        return (result);

    }

    public Integer getInteger (String aName)
    {
        return (getInteger (aName, null));
    }

    public Integer getInteger (String aName, Integer aDefault)
    {
        Integer result = aDefault;

        String value = findString (aName);

        if (value != null)
            result = Integer.valueOf (value);

        return (result);
    }

    public int getInteger (String aName, int aDefault)
    {
        int result = aDefault;

        String value = findString (aName);

        if (value != null)
            result = Integer.parseInt (value);

        return (result);
    }

    public Boolean getBoolean (String aName)
    {
        return (getBoolean (aName, null));
    }

    public Boolean getBoolean (String aName, Boolean aDefault)
    {
        Boolean result = aDefault;

        String value = findString (aName);

        if (value != null)
        {
            result = StringUtils.booleanOf (value);
        }

        return (result);
    }

    public boolean getBoolean (String aName, boolean aDefault)
    {
        return (getBoolean (aName, aDefault ? Boolean.TRUE : Boolean.FALSE).booleanValue ());
    }

    public Iterator names ()
    {
        return (new EntryIterator (this));
    }

    public final Iterator keys ()
    {
        return (names ());
    }

    public void setParent (NameValuePairs aParent)
    {
        iParent = aParent;
    }

    public String toString ()
    {
        return (iEntries.toString ());
    }

    // --- PROTECTED MEMBERS --- //

    protected NameValuePairs ()
    {
    }

    protected void add (String aName, String aValue)
    {
        add (aName, new String [] { aValue });
    }

    protected void add (String aName, String [] aValues)
    {
        if (aName == null)
            throw (new IllegalArgumentException ("NameValuePairs: Argument \"aName\" cannot be null."));
        if (aValues == null)
            throw (new IllegalArgumentException ("NameValuePairs: Argument \"aValues\" cannot be null."));

        for (int i = 0; i < aValues.length; i++)
        {
            if (aValues [i] == null)
                throw (new IllegalArgumentException ("NameValuePairs: Argument \"aValues\" cannot contain null."));
        }

        Entry entry = findEntry (aName);

        if (entry == null)
        {
            entry = new Entry (aName, aValues);

            iEntries.add (entry);
        }
        else
        {
            String [] values = new String [entry.iValues.length + aValues.length];

            System.arraycopy (entry.iValues, 0, values, 0, entry.iValues.length);
            System.arraycopy (aValues, 0, values, entry.iValues.length, aValues.length);

            entry.iValues = values;
        }
    }

    protected Entry findEntry (String aName)
    {
        if (aName == null)
            throw (new IllegalArgumentException ("NameValuePairs: Argument \"aName\" cannot be null!"));

        Entry result = null;

        for (Iterator iter = iEntries.iterator (); iter.hasNext (); )
        {
            Entry entry = (Entry) iter.next ();

            if (entry.iName.equals (aName))
            {
                result = entry;
                break;
            }
        }

        if (result == null && iParent != null)
        {
            result = iParent.findEntry (aName);
        }

        return (result);
    }

    protected void removeEntry (String aName)
    {
        if (aName == null)
            throw (new IllegalArgumentException ("NameValuePairs: Argument \"aName\" cannot be null!"));

        boolean found = false;

        for (Iterator iter = iEntries.iterator (); iter.hasNext (); )
        {
            Entry entry = (Entry) iter.next ();

            if (entry.iName.equals (aName))
            {
                iter.remove ();

                found = true;
                break;
            }
        }

        if (! found && iParent != null)
        {
            iParent.removeEntry (aName);
        }
    }

    private NameValuePairs iParent;

    private List iEntries = new LinkedList ();

    private String findString (String aName)
    {
        String result = null;

        Entry entry = findEntry (aName);

        if (entry != null)
            result  = entry.iValues [0];

        return (result);
    }

    NameValuePairs getParent()
    {
        return iParent;
    }

    List getEntries()
    {
        return iEntries;
    }

    public static class Entry
    {

        String iName;
        String [] iValues;

        protected Entry (String aName, String [] aValues)
        {
            iName   = aName;
            iValues = aValues;
        }

        public String toString ()
        {
            StringBuffer result = new StringBuffer ();

            result.append (iName);
            result.append (" = ");

            for (int i = 0; i < iValues.length; i++)
            {
                if (i > 0)
                    result.append (", ");

                result.append (iValues [i]);
            }

            return (result.toString ());
        }
    }

    private static class EntryIterator implements Iterator
    {

        private NameValuePairs iPairs;
        private Iterator iIterator;

        private EntryIterator (NameValuePairs aPairs)
        {
            iPairs = aPairs;
            iIterator = iPairs.getEntries().iterator();;
        }

        // Iterator implementation.
        
        public boolean hasNext ()
        {
            if (!nextParent()) return false;
            return (iIterator.hasNext ());
        }

        public Object next ()
        {
            if (!nextParent()) return null;
            return (((Entry) iIterator.next ()).iName);
        }

        public void remove()
        {
            iIterator.remove ();
        }

        // additional methods.

        private boolean nextParent()
        {
            while (!iIterator.hasNext ())
            {
                iPairs = iPairs.getParent();
                if (iPairs==null) return false;
                iIterator = iPairs.getEntries().iterator();;
            }
            return true;
        }

    }
}
