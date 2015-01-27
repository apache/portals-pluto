/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

/*
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

    private static final long serialVersionUID = 1L;

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
