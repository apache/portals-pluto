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

package org.apache.pluto.portalImpl.xml;

/**
 ** The <CODE>XMLException</CODE> class defines a general exception
 ** that may occur during portlet.xml or web.xml handling
 **

 **/

public class XmlException extends java.lang.Exception
{

    private Throwable throwable = null;

    /**
     ** Constructs a new xml exception.
     **/

    public XmlException ()
    {
        super();
    }

    /**
     ** Constructs a new xml exception with the given text.
     **
     ** @param   text
     **          the exception text
     **/

    public XmlException (String text)
    {
        super(text);
    }

    /**
     ** Constructs a new xml exception to throw an
     ** exception and include a message about the "root case" that interfered
     ** with its normal operation, including a description message.
     **
     ** @param   text
     **          the exception text
     ** @param   cause
     **          the root cause
     **/

    public XmlException (String text, Throwable cause)
    {
        super (text);
        throwable = cause;
    }

    /**
     ** Constructs a new xml exception to throw an
     ** exception. The exception's message is based on the localized message
     ** of the underlying exception.
     **
     ** @param   cause
     **          the root cause
     **/

    public XmlException (Throwable cause)
    {
    super(cause.getLocalizedMessage());
        throwable = cause;
    }

    /**
     * Returns the exception that caused this xml exception.
     *
     *
     * @return			the <code>Throwable</code> 
     *				that caused this xml exception
     *
     */
    
    public Throwable getRootCause()
    {
    return throwable;
    }

    /**
     * Prints the stack trace of this exception to the standard error stream.
     */
    public void printStackTrace()
    {
        this.printStackTrace(System.err);
    }

    /**
     * Prints the stack trace of this exception to the specified print stream.
     *
     * @param out the <code>PrintStream</code> to use for output
     */
    public void printStackTrace(java.io.PrintStream out) 
    {
        this.printStackTrace(new java.io.PrintWriter(out, true));
    }

    /**
     * Prints the stack trace of this exception to the specified print writer.
     * 
     * @param out the <code>PrintWriter</code> to use for output.
     */
    public void printStackTrace(java.io.PrintWriter out)
    {
        super.printStackTrace(out);

        if( getRootCause () != null )
        {
            out.println();
            out.print("Nested Exception is ");
            getRootCause ().printStackTrace(out);
        }
    }

}
