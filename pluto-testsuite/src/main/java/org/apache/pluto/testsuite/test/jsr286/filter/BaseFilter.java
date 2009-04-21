/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.apache.pluto.testsuite.test.jsr286.filter;

import javax.portlet.PortletException;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides simple implementations of the PortletFilter callback methods.
 * 
 * @author bgould
 * @since 2.0
 */
public abstract class BaseFilter implements PortletFilter {

    private FilterConfig filterConfig;

    private Logger LOG = LoggerFactory.getLogger(getClass());
    
    public void destroy() {
        LOG.debug("destroy called on " + 
                filterConfig.getFilterName() + "(" + getClass() + ")");
    }

    /**
     * Stores the FilterConfig instance to be retrieved with getFilterConfig()
     */
    public void init(FilterConfig filterConfig) throws PortletException {
        LOG.debug("Initializing " + filterConfig.getFilterName() 
                + "(" + getClass() + ")");
        this.filterConfig = filterConfig;
        this.init();
    }
    
    /**
     * Called after the standard lifecycle initialization method.
     * Subclasses should override this method instead of init(FilterConfig)
     */
    protected void init() throws PortletException {
    }
    
    /**
     * Returns the FilterConfig instance.
     */
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }
}
