/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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

import org.apache.pluto.om.common.Icon;
import org.apache.pluto.om.servlet.Filter;

import java.util.List;

/**
 * Filter DD() uration as contained within the
 * web.xml Deployment Descriptor.
 *
 * @version $Id: FilterDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class FilterDD implements Filter {

    private String filterName;
    private String filterClass;
    private String displayName;

    private String description;
    private Icon icon;
    private List initParams;

    public FilterDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#getFilterName()
	 */
    public String getFilterName() {
        return filterName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#setFilterName(java.lang.String)
	 */
    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#getFilterClass()
	 */
    public String getFilterClass() {
        return filterClass;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#setFilterClass(java.lang.String)
	 */
    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#getDisplayName()
	 */
    public String getDisplayName() {
        return displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#setDisplayName(java.lang.String)
	 */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#getIcon()
	 */
    public Icon getIcon() {
        return icon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#setIcon(org.apache.pluto.om.common.Icon)
	 */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#getInitParams()
	 */
    public List getInitParams() {
        return initParams;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#setInitParams(java.util.List)
	 */
    public void setInitParams(List initParams) {
        this.initParams = initParams;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Filter#isValid()
	 */
    public boolean isValid() {
        return filterName != null && filterClass != null;
    }
}

