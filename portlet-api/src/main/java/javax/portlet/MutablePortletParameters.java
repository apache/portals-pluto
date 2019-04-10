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
 * The <CODE>MutablePortletParameters</CODE> provides methods that allow  
 * setting parameters to define a potential future render state.
 * <p>
 * {@link RenderState} provides a description of the render state.
 * {@link PortletParameters} provides a description of the parameter concept.
 * </div>
 * @see   RenderState
 * @see   PortletParameters
 * @see   MutableRenderState
 * @since 3.0
 */
public interface MutablePortletParameters extends PortletParameters, Mutable {


   /**
    * <div class="changed_added_3_0">
    * Returns a <code>Set</code> of <code>String</code>
    * objects containing the names of the parameters contained
    * in this object. 
    * <p>
    * A parameter cannot be added through use of the set.
    * However, removing a parameter from the set will remove the 
    * underlying parameter. 
    * <p>
    * Only parameter names targeted to the current portlet are returned.
    * </div>
    *
    *
    * @return      a <code>Set</code> of <code>String</code>
    *        objects, each <code>String</code> containing
    *        the name of a parameter; or an 
    *        empty <code>Set</code> if the
    *        MutablePortletParameters object has no parameters.
    */

   public Set<String> getNames();

   
    /**
     * <div class="changed_added_3_0">
     * Sets a String parameter.
     * <p> 
     * If the parameter already exists, this method replaces 
     * all existing values with the new value.
     * <p>
     * A parameter value of <code>null</code> is valid.
     * <p>
     * To remove a parameter, use {@link #removeParameter(String)}.
     * </div>
     *
     * @param   name
     *          the parameter name
     * @param   value
     *          the parameter value
     *
     * @return  The previous parameter value, or 
     *          <code>null</code> if there was no previous value.
     *
     * @exception  java.lang.IllegalArgumentException 
     *                            if name is <code>null</code>.
     */

    public String setValue (String name, String value);


    /**
     * <div class="changed_added_3_0">
     * Sets a multivalued String parameter.
     * <p> 
     * If the parameter already exists, this method replaces 
     * all existing values with the new value array.
     * <p>
     * An input value of null or an empty array is valid.
     * These values will be preserved when reading the parameter through 
     * {@link PortletParameters#getValues(String)}, but will be 
     * mapped to the value <code>null</code> when the parameter is read
     * through {@link PortletParameters#getValue(String)}.
     * <p> 
     * A parameter value of <code>null</code> within the array is valid.
     * <p>
     * To remove a parameter, use {@link #removeParameter(String)}.
     * </div>
     *
     * @param   name
     *          the parameter name
     * @param   values
     *          An array of parameter values
     *
     * @return  The previous parameter value array, or
     *          <code>null</code> if there was no previous value.
     *
     * @exception  java.lang.IllegalArgumentException 
     *                            if name is <code>null</code>
     */

    public String[] setValues (String name, String... values);

    
    /**
     * <div class="changed_added_3_0">
     * Removes the given public or private parameter. 
     * All values associated with the name are removed.
     * </div>
     *
     * @param        name
     *               the parameter name
     *
     * @exception    java.lang.IllegalArgumentException 
     *                            if name is <code>null</code>.
     * 
     * @return       <code>true</code> if the parameter name was present.
     */

    public boolean removeParameter (String name);
    
    
    /**
     * <div class="changed_added_3_0">
     * Makes the public and private parameters identical to 
     * those of the input PortletParameters object.
     * <p>
     * The parameters are copied so that after the operation completes, there 
     * is no linkage to the input object.
     * </div>
     *   
     * @param params - input portlet parameters
     *
     * @return  MutablePortletParameters object containing the previous values
     */
    
    public MutablePortletParameters set(PortletParameters params);
    
    
    /**
     * <div class="changed_added_3_0">
     * Adds the parameters from the input <code>PortletParameters</code> object 
     * if they are not already present. 
     * If a parameter from the input object is already present, its value 
     * will be updated with the input value.
     * <p>
     * The parameters are copied so that after the operation completes, there 
     * is no linkage to the input object.
     * </div>
     *   
     * @param params - input portlet parameters
     *
     * @return  MutablePortletParameters object containing the previous values
     */
    
    public MutablePortletParameters add(PortletParameters params);
    
    
    /**
     * <div class="changed_added_3_0">
     * Clears all parameters.
     * </div> 
     */
    
    public void clear();
}
