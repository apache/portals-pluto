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
package org.apache.pluto.driver.tags;

import java.util.ResourceBundle;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A class encapsulating access to portlet mode and windowstate tooltips.
 * 
 * @author Elliot Metsger (emetsger@jhu.edu)
 * @since Feb 23, 2007
 * @version $Id$
 * @todo Provide access to tooltips for custom modes and states.
 */
class ToolTips
{
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("ToolTips");
    private static final Log LOG = LogFactory.getLog(ToolTips.class);
    
    static final ToolTips MAXIMIZE = new ToolTips(BUNDLE.getString("tooltip.windowstate.maximize"));
    static final ToolTips MINIMIZE = new ToolTips(BUNDLE.getString("tooltip.windowstate.minimize"));
    static final ToolTips NORMAL = new ToolTips(BUNDLE.getString("tooltip.windowstate.normal"));
    
    static final ToolTips VIEW = new ToolTips(BUNDLE.getString("tooltip.mode.view"));
    static final ToolTips EDIT = new ToolTips(BUNDLE.getString("tooltip.mode.edit"));
    static final ToolTips HELP = new ToolTips(BUNDLE.getString("tooltip.mode.help"));
    
    static final String CSS_CLASS_NAME = BUNDLE.getString("tooltip.css.classname");

    private String tooltip = null;
    
    private ToolTips(String tooltip)
    {
        this.tooltip = tooltip;
    }
    
    static ToolTips forMode(PortletMode mode)
    {
        if (PortletMode.VIEW.equals(mode))
        {
            return VIEW;
        }
        
        if (PortletMode.HELP.equals(mode))
        {
            return HELP;
        }
        
        if (PortletMode.EDIT.equals(mode))
        {
            return EDIT;
        }
        
        LOG.debug("No tooltip found for portlet mode [" + mode + "]");
        return null;
    }
    
    static ToolTips forWindowState(WindowState state)
    {
        if (WindowState.MAXIMIZED.equals(state))
        {
            return MAXIMIZE;
        }
        
        if (WindowState.MINIMIZED.equals(state))
        {
            return MINIMIZE;
        }
        
        if (WindowState.NORMAL.equals(state))
        {
            return NORMAL;
        }
        
        LOG.debug("No tooltip found for window state [" + state + "]");
        return null;
    }
    
    public String toString()
    {
        return tooltip;
    }
}
