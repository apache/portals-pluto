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

package org.apache.pluto.portalImpl.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.pluto.util.StringUtils;

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
     ** @return   the value of the pair
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
     ** @return   the value of the pair
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
     ** @return   the values of the pair
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
            iIterator = iPairs.getEntries().iterator();
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
                iIterator = iPairs.getEntries().iterator();
            }
            return true;
        }

    }
}
