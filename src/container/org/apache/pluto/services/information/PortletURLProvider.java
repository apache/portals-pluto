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

package org.apache.pluto.services.information;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.services.ContainerService;

public interface PortletURLProvider
{


     /**
      * Sets the new portlet mode at the URL. If no
      * mode is set at the URL the currently active
      * mode is used.
      * 
      * @param mode   the new portlet mode
      */
     public void setPortletMode(PortletMode mode);

     /**
      * Sets the new window state at the URL. If no
      * state is set at the URL the currently active
      * state is used.
      * 
      * @param state   the new window state
      */
     public void setWindowState(WindowState state);

     /**
      * By calling this method the URL is defined as
      * an action URL. If this URL is execute the
      * action() method will be called at the
      * portlet entity linked with the URL.
      */
     public void setAction();

     /**
      * By calling this method the URL is defined as
      * a secure URL. 
      */
     public void setSecure();

     /**
      * Removes all pre-existing parameters in this URL
      */
     public void clearParameters();

     /**
      * Sets the given parameters as parameters into the URL,
      * Removes all previously set parameters.
      * 
      * @param parameters a map containing the name [java.lang.String] and value [java.lang.String] of the parameters.
      */
     public void setParameters(Map parameters);


     /**
      * Returns the URL in string format. This method should only be called once.
      * 
      * @return the URL
      */
     public String toString();
}
