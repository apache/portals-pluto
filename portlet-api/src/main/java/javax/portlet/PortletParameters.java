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

import java.util.Set;


/**
 * <div class="changed_added_3_0">
 * The <CODE>PortletParameters</CODE> interface defines the API 
 * for accessing the parameters that are set for the portlet or on a portlet URL.
 * <p>
 * Portlet parameters store state information that the portlet needs to render itself,
 * generate content by serving resources, or make decisions when executing portlet
 * actions. Conceptually the portlet parameters correspond to query string parameters
 * that are stored in the URL used to access the portlet, although they are not
 * required to actually be present on the URL as visible parameters.
 * <p>
 * Private parameters parameters are available exclusively to a single portlet. 
 * Public parameters can be shared between portlets.
 * <p>
 * The portlet parameters governing the request can be read during all portlet
 * execution phases through the {@link PortletParameters} object available 
 * from the portlet request. Portlet parameters
 * can be set for subsequent or future portlet execution phases through
 * the {@link MutablePortletParameters} object available from the
 * portlet response object or from the portlet URL.
 * <p>
 * Different types of portlet parameters are distinguished 
 * according to their use. 
 * <dl>
 * <dt>Render Parameters</dt>
 * <dd>
 * Set on the response during the Action and Event phases to govern content
 * generation during the Render and Resource phases. Also set on render URLs
 * to move the portlet to a new render state when the URL is triggered.
 * <p>
 * Refer to {@link PortletRequest#getRenderParameters()},
 * {@link StateAwareResponse#getRenderParameters()}, and
 * {@link PortletURL#getRenderParameters()}.
 * <p>
 * Example: Render URLs with differing render parameters can be used to
 * implement tabbed navigation within a portlet.
 * </dd> 
 * <dt>Resource Parameters</dt>
 * <dd>
 * Provide additional information about the content to be generated when
 * serving a resource for the governing render state.
 * Set on resource URLs and made available to the portlet through the
 * resource request when the URL is triggered.
 * <p>
 * Refer to {@link ResourceRequest#getResourceParameters()} and
 * {@link ResourceURL#getResourceParameters()}.
 * <p>
 * Example: Portlets may require several different pieces of content 
 * to be served for the governing render state.
 * Resource URLs with differing resource parameters can be used to
 * determine which content is to be served for a specific request.
 * </dd> 
 * <dt>Action Parameters</dt>
 * <dd>
 * Provide additional information about the action to be executed
 * for the governing render state.
 * Set on action URLs and made available to the portlet through the
 * action request when the URL is triggered, or provided to the 
 * portlet by the client (form parameters).
 * <p>
 * Refer to {@link ActionRequest#getActionParameters()} and
 * {@link ActionURL#getActionParameters()}.
 * <p>
 * Example: Portlets may render a number of buttons or links
 * for the governing render state.
 * Action URLs with differing action parameters can be used to
 * determine which action is to be executed for a specific request.
 * <br>
 * Example: Portlets may render forms that, when submitted, may cause
 * parameters to be added to the portlet action request. 
 * During action request processing, these form parameters will be available as 
 * action parameters.
 * </dd> 
 * </dl>
 * </div>
 * @see     MutablePortletParameters
 * @since   3.0 
 */
public interface PortletParameters
{

  /**
   * <div class="changed_added_3_0">
   * Returns the value of a parameter as a <code>String</code>.
   * <p>
   * Note that <code>null</code> is a valid parameter value. 
   * To determine whether a
   * parameter is present, use the {@link java.util.Set#contains(Object)}
   * method on the set returned by {@link #getNames()}. 
   * <p>
   * Only parameters targeted to the current portlet are accessible.
   * <p>
   * This method should only be used if the 
   * parameter has only one value. If the parameter might have
   * more than one value, use {@link #getValues}.
   * <p>
   * If this method is used with a multivalued
   * parameter, the value returned is equal to the first value
   * in the array returned by <code>getValues</code>.
   * </div>
   *
   * @param name 	a <code>String</code> specifying the 
   *			name of the parameter
   *
   * @return		a <code>String</code> representing the 
   *			single value of the parameter, or <code>null</code>. 
   *
   * @see 		#getValues
   * @see      #getNames
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   *
   */
  
  public String getValue(String name);


  /**
   * <div class="changed_added_3_0">
   * Returns a <code>Set</code> of <code>String</code>
   * objects containing the names of the parameters contained
   * in this object. 
   * Changing the <code>Set</code> has no effect on the originating 
   * PortletParameters object. 
   * <p>
   * Only parameter names targeted to the current portlet are returned.
   * </div>
   *
   *
   * @return		a <code>Set</code> of <code>String</code>
   *			objects, each <code>String</code> containing
   * 			the name of a parameter; or an 
   *			empty <code>Set</code> if the
   *			PortletParameters object has no parameters.
   *
   */

  public Set<String> getNames();


  /**
   * <div class="changed_added_3_0">
   * Returns an array of <code>String</code> objects containing 
   * all of the values the given parameter, or 
   * <code>null</code> if the parameter does not exist.
   * <p>
   * If the parameter has a single value, the array has a length
   * of 1.
   * <p>
   * Note that individual parameter values in the returned array 
   * may be <code>null</code>.
   * </div>
   *
   * @param name	a <code>String</code> containing the name of 
   *			the parameter the value of which is requested
   *
   * @return		an array of <code>String</code> objects 
   *			containing the parameter values, or <code>null</code> 
   *        if the parameter does not exist.
   *
   * @see		#getValue
   *
   * @exception  java.lang.IllegalArgumentException 
   *                            if name is <code>null</code>.
   *
   */

  public String[] getValues(String name);

  
  /**
   * <div class="changed_added_3_0">
   * Returns a <code>true</code> if no parameters have been set.
   * </div> 
   *
   * @return  <code>true</code> if the object contains no parameters.
   *          <code>false</code> otherwise
   * 
   */

  public boolean isEmpty ();

  
  /**
   * <div class="changed_added_3_0">
   * Returns the number of parameters in this object.
   * </div> 
   *
   * @return  the number of parameters in this object
   * 
   */

  public int size();

  
  /**
   * <div class="changed_added_3_0">
   * Returns a <code>MutablePortletParameters</code> object encapsulating a copy of the same
   * parameters as the original object.
   * Changing a mutable copy will not influence the source object. 
   * </div>
   * 
   * @return Mutable clone of PortletParameters object
   * 
   */
  
  public MutablePortletParameters clone();

}
