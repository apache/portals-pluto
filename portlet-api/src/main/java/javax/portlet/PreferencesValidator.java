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
 * The <CODE>PreferencesValidator</CODE> allows to validate the set of
 * preferences of the associated portlet just before they are
 * stored in the persistent store.
 * <p>
 * The portlet container invokes the <code>validate</code> method as 
 * part of the invocation of the <code>store</code> method of the
 * <code>PortletPreferences</code>.
 */
public interface PreferencesValidator
{

  /**
   * If the preferences values are successfully validated the call to this method
   * must finish gracefully. Otherwise it must throw a <code>ValidatorException</code>.
   *
   * @param  preferences   preferences to validate
   *
   * @throws  ValidatorException  if the given preferences contains invalid
   *                              settings
   *
   */

  public void validate(PortletPreferences preferences)
    throws ValidatorException;  
}
