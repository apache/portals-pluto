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

package javax.portlet.filter;



import java.util.Enumeration;

import javax.portlet.PortletContext;

/**
 * A filter configuration object used by a portlet container 
 * to pass information to a filter during initialization.
 *
 * @since 2.0
 */
public interface FilterConfig {

    /**
     * Returns the filter-name of this filter as defined in the 
     * portlet deployment descriptor.
     * 
     * @return  the filter name
     */
    public String getFilterName();
    
    /**
     * Returns a reference to the <code>PortletContext</code> in which the caller is executing.
     * 
     * @return  the portlet context
     */
    public PortletContext getPortletContext();
    
    /**
     * Returns a String containing the value of the named 
     * initialization parameter, or <code>null</code> if the parameter does not exist.
     * <p>
     * Initialization parameters are defined in the portlet deployment descriptor.
     * 
     * @param name  the name of the initialization parameter to return
     * @return  initialization parameter, or <code>null</code> if the parameter does not exist.  
     */
    public String getInitParameter(String name);
    
    /**
     * Returns the names of the filter's initialization parameters 
     * as an Enumeration of String objects, or an empty Enumeration 
     * if the filter has no initialization parameters.
     * <p>
     * Initialization parameters are defined in the portlet deployment descriptor.
     * 
     * @return the names of the filter's initialization parameters, 
     *         or an empty Enumeration if the filter has no initialization parameters.
     */
    public Enumeration<String> getInitParameterNames();
}
