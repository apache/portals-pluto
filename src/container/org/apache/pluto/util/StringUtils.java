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

package org.apache.pluto.util;

/**
 ** <CODE>StringUtils</CODE> hosts a couple of utility methods around
 ** strings.
 **/

public class StringUtils
{

    static java.util.BitSet dontNeedEncoding;
    static final int caseDiff = ('a' - 'A');

    /* The list of characters that are not encoded have been determined by
       referencing O'Reilly's "HTML: The Definitive Guide" (page 164). */

    static {
        dontNeedEncoding = new java.util.BitSet(256);
        int i;
        for (i = 'a'; i <= 'z'; i++)
        {
            dontNeedEncoding.set(i);
        }
        for (i = 'A'; i <= 'Z'; i++)
        {
            dontNeedEncoding.set(i);
        }
        for (i = '0'; i <= '9'; i++)
        {
            dontNeedEncoding.set(i);
        }
        dontNeedEncoding.set('-');
        dontNeedEncoding.set('_');
        dontNeedEncoding.set('.');
        dontNeedEncoding.set('*');
    }

    /**
     ** The operating system's line separator ('\n' on UNIX, '\r\n' on Windows)
     **/

    public static final String lineSeparator = System.getProperty("line.separator");

    /**
     ** Returns the package of a class, ie. without class name and
     ** and .class suffix.
     **
     ** @param   aClass
     **          a class object
     **
     ** @return   its package
     **/

    public static String packageOf (Class aClass)
    {
        if (aClass == null)
        {
            throw (new IllegalArgumentException ("StringUtils: Argument \"aClass\" cannot be null."));
        }

        String result = "";

        int index = aClass.getName ().lastIndexOf (".");

        if (index >= 0)
        {
            result = aClass.getName ().substring (0, index);
        }

        return(result);
    }

    /**
     * Returns the name of a class, ie. without package name and
     * and .class suffix.
     *
     * @param   aClass
     *          a class object
     *
     * @return   its name
     */

    public static String nameOf (Class aClass)
    {
        if (aClass == null)
        {
            throw new IllegalArgumentException ("StringUtils: Argument \"aClass\" cannot be null.");
        }

        String className = aClass.getName ();

        int index = className.lastIndexOf (".");

        if (index >= 0)
        {
            className = className.substring (index + 1);
        }

        return(className);
    }

    /**
     * Returns a combination of two paths, inserting slashes as appropriate.
     *
     * @param   aRoot
     *          a root path
     * @param   aPath
     *          a path
     *
     * @return   the path
     */

    public static String pathOf (String aRoot, String aPath)
    {
        if (aPath == null)
        {
            throw new IllegalArgumentException ("StringUtils: Argument \"aPath\" cannot be null.");
        }

        String result = null;

        if (aPath.startsWith ("/")  ||
            aPath.startsWith ("\\") ||
            (aPath.length () >= 2 && aPath.charAt (1) == ':'))
        {
            result = aPath;
        }
        else
        {
            if (aRoot == null)
            {
                throw new IllegalArgumentException ("StringUtils: Argument \"aRoot\" cannot be null.");
            }

            StringBuffer temp = new StringBuffer (aRoot);

            if (! aRoot.endsWith ("/") &&
                ! aRoot.endsWith ("\\"))
            {
                temp.append ('/');
            }

            temp.append (aPath);

            result = temp.toString ();
        }

        return result.toString();
    }

    /**
     * Returns a <CODE>Boolean</CODE> object that corresponds the given value.
     * A value of <CODE>true</CODE> or <CODE>yes</CODE> corresponds to
     * <CODE>Boolean.TRUE</CODE> and a value of <CODE>false</CODE> or
     * <CODE>no</CODE> corresponds to <CODE>Boolean.FALSE</CODE>.
     * The comparions is case-insensitive, but for performance reasons,
     * lower-case values of <CODE>true</CODE> and <CODE>false</CODE>
     * should be used.
     *
     * @param   aValue
     *          to value to convert
     *
     * @return   the boolean value
     */
    public static Boolean booleanOf (String aValue)
    {
        Boolean result = null;

        if (aValue != null)
        {
            if (aValue == "true" ||
                aValue == "yes" ||
                aValue.equalsIgnoreCase ("true") ||
                aValue.equalsIgnoreCase ("yes"))
            {
                result = Boolean.TRUE;
            }
            else if (aValue == "false" ||
                     aValue == "no" ||
                     aValue.equalsIgnoreCase ("false") ||
                     aValue.equalsIgnoreCase ("no"))
            {
                result = Boolean.FALSE;
            }
        }

        return(result);
    }

    /**
     * Replace all occurrences of a pattern within a string by a replacement
     *
     * @param source  The string that should be searched
     * @param pattern  The pattern that should be replaced
     * @param replace  The replacement that should be inserted instead of the pattern
     *
     * @return  The updated source string
     */
    public static String replace(String source, String pattern, String replace)
    {
        if (source == null || source.length() == 0 ||
            pattern == null || pattern.length() == 0)
        {
            return source;
        }

        int k = source.indexOf(pattern);

        if (k == -1)
        {
            return source;
        }

        StringBuffer out = new StringBuffer();
        int i=0, l=pattern.length();

        while (k != -1)
        {
            out.append(source.substring(i,k));

            if (replace != null) {
                out.append(replace);
            }

            i = k+l;
            k = source.indexOf(pattern, i);
        }
        out.append(source.substring(i));
        return out.toString();
    }

    public static void newLine(StringBuffer buffer, int indent)
    {
        buffer.append(StringUtils.lineSeparator);
        indent(buffer, indent);
    }

    public static void indent(StringBuffer buffer, int indent)
    {
        for (int i=0; i<indent; i++) buffer.append(' ');
    }

    public static String encode(String s)
    {
        int maxBytesPerChar = 10;
        StringBuffer out = new StringBuffer(s.length());
        java.io.ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream(maxBytesPerChar);
        java.io.OutputStreamWriter writer = new java.io.OutputStreamWriter(buf);

        for (int i = 0; i < s.length(); i++)
        {
            int c = (int)s.charAt(i);
            if (dontNeedEncoding.get(c))
            {
                out.append((char)c);
            }
            else
            {
                // convert to external encoding before hex conversion
                try
                {
                    writer.write(c);
                    writer.flush();
                }
                catch (java.io.IOException e)
                {
                    buf.reset();
                    continue;
                }
                byte[] ba = buf.toByteArray();
                for (int j = 0; j < ba.length; j++)
                {
                    out.append('x');
                    char ch = Character.forDigit((ba[j] >> 4) & 0xF, 16);
                    // converting to use uppercase letter as part of
                    // the hex value if ch is a letter.
                    if (Character.isLetter(ch))
                    {
                        ch -= caseDiff;
                    }
                    out.append(ch);
                    ch = Character.forDigit(ba[j] & 0xF, 16);
                    if (Character.isLetter(ch))
                    {
                        ch -= caseDiff;
                    }
                    out.append(ch);
                }
                buf.reset();
            }
        }

        return out.toString();
    }

    public static String decode(String s)
    {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
                case '%':
                    if (((s.charAt(i+1)>='0') && (s.charAt(i+1)<='9')) &&
                        ((s.charAt(i+2)>='0') && (s.charAt(i+2)<='9')))
                    {
                        try
                        {
                            sb.append((char)Integer.parseInt(s.substring(i+1, i+3), 16));
                        }
                        catch (java.lang.NumberFormatException e)
                        {
                            throw new java.lang.IllegalArgumentException();
                        }
                        i += 2;
                        break;
                    }
                default:
                    sb.append(c);
                    break;
            }
        }
        // Undo conversion to external encoding
        String result = sb.toString();
        try
        {
            byte[] inputBytes = result.getBytes("8859_1");
            result = new String(inputBytes);
        }
        catch (java.io.UnsupportedEncodingException e)
        {
            // The system should always have 8859_1
        }
        return result;
    }
}
