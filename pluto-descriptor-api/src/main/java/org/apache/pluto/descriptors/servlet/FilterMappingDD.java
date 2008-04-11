/*
 * Copyright 2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.descriptors.servlet;

import java.util.List;

import org.apache.pluto.om.servlet.FilterMapping;

/**
 * FilterMapping configuration as contained within the
 * web.xml Deployment Descriptor.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id: FilterMappingDD.java 157475 2005-03-14 22:13:18Z ddewolf $
 * @since Feb 28, 2005
 */
public class FilterMappingDD implements FilterMapping {

    private String filterName;
    private String servletName;
    private List urlPattern;
    private List dispatchers;

    public FilterMappingDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#getFilterName()
	 */
    public String getFilterName() {
        return filterName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#setFilterName(java.lang.String)
	 */
    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#getUrlPatterns()
	 */
    public List getUrlPatterns() {
        return urlPattern;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#setUrlPatterns(java.util.List)
	 */
    public void setUrlPatterns(List urlPattern) {
        this.urlPattern = urlPattern;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#getServletName()
	 */
    public String getServletName() {
        return servletName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#setServletName(java.lang.String)
	 */
    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#getDispatchers()
	 */
    public List getDispatchers() {
        return dispatchers;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.FilterMapping#setDispatchers(java.util.List)
	 */
    public void setDispatchers(List dispatchers) {
        this.dispatchers = dispatchers;
    }

}

