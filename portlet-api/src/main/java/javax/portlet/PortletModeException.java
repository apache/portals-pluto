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
 * The <CODE>PortletModeException</CODE> is thrown when a portlet
 * tries to use or set a portlet mode that is not supported by the current
 * runtime environment or the portlet.
 */

public class PortletModeException extends PortletException
{

  private transient PortletMode _mode = null;

  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new portlet mode exception with the given text and the
   * portlet mode that caused this exception. The
   * portlet container may use the text and portlet mode write it to a log.
   *
   * @param   text
   *          the exception text
   * @param   mode
   *          the mode causing the exception
   */

  public PortletModeException (String text, PortletMode mode)
  {
    super (text);
    _mode = mode;
  }

  /**
   * Constructs a new portlet mode exception when the portlet needs to do
   * the following:
   * <ul>
   * <li>throw an exception 
   * <li>include a message about the "root cause" that interfered
   *     with its normal operation
   * <li>include a description message
   * <li>include the portlet mode that caused this exception
   * </ul>
   *
   * @param   text
   *          the exception text
   * @param   cause
   *          the root cause
   * @param   mode
   *          the mode causing the exception
   */
  
  public PortletModeException (String text, Throwable cause, PortletMode mode)
  {
    super(text, cause);
    _mode = mode;
  }

  /**
   * Constructs a new portlet mode exception when the portlet needs to throw an
   * exception. The exception message is based on the localized message
   * of the underlying exception and the portlet mode that caused this exception.
   *
   * @param   cause
   *          the root cause
   * @param   mode
   *          the mode causing the exception
   */

  public PortletModeException (Throwable cause, PortletMode mode)
  {
    super(cause);
    _mode = mode;
  }

  /**
   * Returns the unsupported portlet mode causing this exception.
   * 
   * @return  the portlet mode that caused this exception
   */

  public PortletMode getMode()
  {
    return _mode;
  }
}
