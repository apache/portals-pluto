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
 *
 * ====================================================================
 *
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;

/**
 * The portlet should throw the <CODE>UnavailableException</CODE> when 
 * the portlet is either temporarily or permanently unavailable to handle requests.
 *
 **/

public class UnavailableException extends PortletException
{


    private boolean     permanent;         // needs admin action?
    private int         seconds;           // unavailability estimate


    /**
     * 
     * Constructs a new exception with a descriptive
     * message indicating that the portlet is permanently
     * unavailable.
     *
     * @param text 	a <code>String</code> specifying the
     *                  descriptive message
     *
     */

    public UnavailableException(String text) {
	super(text);

	permanent = true;
    }

    /**
     * Constructs a new exception with a descriptive message
     * indicating that the portlet is temporarily unavailable
     * and giving an estimate of how long it will be unavailable.
     * 
     * <p>In some cases, the portlet cannot make an estimate. For
     * example, the portlet might know that a server it needs is
     * not running, but it might not be able to report how long it will take
     * to be restored to functionality. This can be indicated with
     * a negative or zero value for the <code>seconds</code> argument.
     *
     * @param text	a <code>String</code> specifying the
     *                  descriptive message. This message can be written
     *                  to a log file or displayed for the user.
     *
     * @param seconds	an integer specifying the number of seconds
     * 			for which the portlet expects to be unavailable; if
     *			this is zero or negative, it indicates that the portlet
     *			cannot make an estimate.
     *
     */
    
    public UnavailableException(String text, int seconds) {
	super(text);

	if (seconds <= 0)
	    this.seconds = -1;
	else
	    this.seconds = seconds;

	permanent = false;
    }

    /**
     *
     * Returns a <code>boolean</code> indicating
     * whether the portlet is permanently unavailable.
     * If so, something is wrong with the portlet, and the
     * system administrator must take some corrective action.
     *
     * @return		<code>true</code> if the portlet is
     *			permanently unavailable; <code>false</code>
     *			if the portlet is temporarily
     *			unavailable.
     *
     */
     
    public boolean isPermanent() {
	return permanent;
    }
  

    /**
     * Returns the time in seconds for which the portlet can be expected to 
     * be unavailable.  
     * <p>
     * If the portlet is called again while it is still unavailable, it
     * indicates the same time estimate. No effort is
     * made to correct for the time elapsed since the exception was
     * first reported.
     * <p>
     * If this method returns zero or a negative number, the portlet
     * is permanently unavailable or cannot provide an estimate of
     * how long it will be unavailable. 
     *
     * @return		an integer specifying the number of seconds
     *			the portlet will be temporarily unavailable,
     *			or zero or a negative number if the portlet is permanently
     *			unavailable or cannot make an estimate.
     *
     */
     
    public int getUnavailableSeconds() {
	return permanent ? -1 : seconds;
    }


}
