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

package org.apache.pluto;

/**
 ** The <CODE>PortletContainerException</CODE> class defines a general exception
 ** that the portlet container can throw when it encounters difficulty.
 **

 **/

public class PortletContainerException extends Exception
{

    private Throwable cause;

    /**
     ** Constructs a new portlet exception.
     **/

    public PortletContainerException ()
    {
    }

    /**
     ** Constructs a new portlet invoker exception with the given text. The
     ** layout system may use the text write it to a log.
     **
     ** @param   text
     **          the exception text
     **/

    public PortletContainerException (String text)
    {
        super (text);
    }

    /**
     ** Constructs a new portlet invoker exception when the invoker needs to throw an
     ** exception and include a message about the "root case" that interfered
     ** with its normal operation, including a description message.
     **
     ** @param   text
     **          the exception text
     ** @param   cause
     **          the root cause
     **/

    public PortletContainerException (String text, Throwable cause)
    {
        super (text); //, cause);

        this.cause = cause;
    }

    /**
     ** Constructs a new portlet invoker exception when the portlet needs to throw an
     ** exception. The exception's message is based on the localized message
     ** of the underlying exception.
     **
     ** @param   cause
     **          the root cause
     **/

    public PortletContainerException (Throwable cause)
    {
        super (cause.getLocalizedMessage ());

        this.cause = cause;
    }

    /**
     ** Returns the exception that cause this portlet exception.
     **
     ** @return   the <CODE>Throwable</CODE> that caused this portlet exception.
     **/

    public Throwable getRootCause ()
    {
        return (cause);
    }
}
