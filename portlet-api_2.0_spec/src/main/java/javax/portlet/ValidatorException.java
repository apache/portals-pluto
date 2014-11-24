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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

/**
 * The <CODE>ValidatorException</CODE> is thrown by the
 * <CODE>validate</CODE> method of a PreferencesValidator when 
 * the validation of a preference failed.
 */

public class ValidatorException extends PortletException
{

  private transient ArrayList<String> failedKeyVector = new ArrayList<String>();
  private static final long serialVersionUID = 1L;

  private ValidatorException ()
  {
  }

  /**
   * Constructs a new validator exception with the given text. The
   * portlet container may use the text write it to a log.
   * <p>
   * The collection of failed keys may contain all failed keys, only the
   * first key that failed validation, or may be <code>null</code>.
   *
   * @param   text
   *          the exception text
   * @param   failedKeys
   *          keys that failed the validation; may be <code>null</code>
   */

  public ValidatorException (String text, Collection<String> failedKeys)
  {
    super (text);
    if ( failedKeys != null )
	    failedKeyVector.addAll(failedKeys);
  }

  /**
   * Constructs a new portlet validator exception.
   * Used, when the portlet needs to do one of the following:
   * <ul>
   * <li>throw an exception 
   * <li>include a message about the "root cause" that interfered
   *     with its normal operation
   * <li>include a description message
   * </ul>
   * <p>
   * The Collection of failed keys may contain all failed keys, only the
   * first key that failed validation, or may be <code>null</code>.
   *
   * @param   text
   *          the exception text
   * @param   cause
   *          the root cause
   * @param   failedKeys
   *          keys that failed the validation; may be <code>null</code>
   */
  
  public ValidatorException (String text, Throwable cause, Collection<String> failedKeys)
  {
    super(text, cause);
    if ( failedKeys != null )
	    failedKeyVector.addAll(failedKeys);
  }

  /**
   * Constructs a new portlet validator exception when the portlet needs to throw an
   * exception. The exception message is based on the localized message
   * of the underlying exception.
   * <p>
   * The Collection of failed keys may contain all failed keys, only the
   * first key that failed validation, or may be <code>null</code>.
   *
   * @param   cause
   *          the root cause
   * @param   failedKeys
   *          keys that failed the validation; may be <code>null</code>
   */

  public ValidatorException (Throwable cause, Collection<String> failedKeys)
  {
    super(cause);
    if ( failedKeys != null )
	    failedKeyVector.addAll(failedKeys);
  }


  /**
   * Returns the keys that failed the validation.
   * <p>
   * The Enumeration of failed keys may contain all failed keys, only the
   * first key that failed validation, or an empty 
   * <code>Enumeration</code> if no failed keys are available.
   *
   * @return  the keys that failed validation, or an empty 
   *          <code>Enumeration</code> if no failed keys are available.
   */

  public Enumeration<String> getFailedKeys()
  {
    return Collections.enumeration(failedKeyVector);
  }
}
