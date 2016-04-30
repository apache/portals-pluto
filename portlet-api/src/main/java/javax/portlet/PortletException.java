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
 * The <CODE>PortletException</CODE> class defines a general exception
 * that a portlet can throw when it is unable to perform its operation
 * successfully.
 */

public class PortletException extends java.lang.Exception
{

  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new portlet exception.
   */

  public PortletException ()
  {
    super();
  }

  /**
   * Constructs a new portlet exception with the given text. The
   * portlet container may use the text write it to a log.
   *
   * @param   text
   *          the exception text
   */

  public PortletException (String text)
  {
    super (text);
  }

  /**
   * Constructs a new portlet exception when the portlet needs to do
   * the following:
   * <ul>
   * <li>throw an exception 
   * <li>include the "root cause" exception
   * <li>include a description message
   * </ul>
   *
   * @param   text
   *          the exception text
   * @param   cause
   *          the root cause
   */
  
  public PortletException (String text, Throwable cause)
  {
    super(text, cause);
  }

  /**
   * Constructs a new portlet exception when the portlet needs to throw an
   * exception. The exception's message is based on the localized message
   * of the underlying exception.
   *
   * @param   cause
   *          the root cause
   */

  public PortletException (Throwable cause)
  {
    super(cause);
  }


}
