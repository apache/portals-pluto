/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 

 */

package org.apache.pluto.tags;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Hashtable;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.VariableInfo;

/**
 * Supporting class for the <CODE>actionURL</CODE> and <CODE>renderURL</CODE> tag.
 * Creates a url that points to the current Portlet and triggers an action request
 * with the supplied parameters.
 *
 */
public abstract class BasicURLTag extends TagSupport
{

    public static class TEI extends TagExtraInfo
    {
        public final static Hashtable definedWindowStates = getDefinedWindowStates();
        public final static Hashtable portletModes        = getDefinedPortletModes();

        /**
         * Provides a list of all static PortletMode available in the specifications by
         * using introspection
         * @return Hashtable
         */
        private static Hashtable getDefinedPortletModes()
        {
            Hashtable portletModes = new Hashtable();
            Field[] f = PortletMode.class.getDeclaredFields();

            for (int i = 0; i < f.length; i++)
            {
                if (f[i].getType().isAssignableFrom(javax.portlet.PortletMode.class))
                {
                    try
                    {
                        portletModes.put(f[i].get(f[i]).toString().toUpperCase(), f[i].get(f[i]));
                    }
                    catch (IllegalAccessException e)
                    {
                    }
                }
            }

            return portletModes;
        }

        /**
         * Provides a list of all static WindowsStates available in the specifications by
         * using introspection
         * @return Hashtable
         */
        private static Hashtable getDefinedWindowStates()
        {
            Hashtable definedWindowStates = new Hashtable();
            Field[] f = WindowState.class.getDeclaredFields();

            for (int i = 0; i < f.length; i++)
            {
                if (f[i].getType().isAssignableFrom(javax.portlet.WindowState.class))
                {
                    try
                    {
                        definedWindowStates.put(f[i].get(f[i]).toString().toUpperCase(), f[i].get(f[i]));
                    }
                    catch (IllegalAccessException e)
                    {
                        ;
                    }
                }
            }
            return definedWindowStates;
        }

        public VariableInfo[] getVariableInfo(TagData tagData)
        {
            VariableInfo vi[] = null;
            String var = tagData.getAttributeString("var");
            if (var != null)
            {
                vi = new VariableInfo[1];
                vi[0] = new VariableInfo(var, "java.lang.String", true, VariableInfo.AT_BEGIN);
            }
            return vi;
        }

    }

    protected String portletMode;
    protected String secure;
    protected Boolean secureBoolean;
    protected String windowState;
    protected PortletURL url;
    protected String var;

    /**
     * Processes the <CODE>actionURL</CODE> or <CODE>renderURL</CODE> tag.
     * @return int
     */
    public abstract int doStartTag() throws JspException;

    /**
     *
     * @return int
     */
    public int doEndTag() throws JspException {
        if (var == null)
        {
            try
            {
                JspWriter writer = pageContext.getOut();
                writer.print(url); 
                writer.flush();
            }
            catch (IOException ioe)
            {
                throw new JspException("actionURL/renderURL Tag Exception: cannot write to the output writer.");
            }
        } else {
                pageContext.setAttribute (var, url.toString(), PageContext.PAGE_SCOPE);
        }
        return EVAL_PAGE;
    }

    /**
     * Returns the portletMode.
     * @return String
     */
    public String getPortletMode()
    {
        return portletMode;
    }

    /**
     * @return secure as String
     */
    public String getSecure()
    {
        return secure;
    }

    /**
     * @return secure as Boolean
     */
    public boolean getSecureBoolean()
    {
        return this.secureBoolean.booleanValue();
    }

    /**
     * Returns the windowState.
     * @return String
     */
    public String getWindowState()
    {
        return windowState;
    }

    /**
     * @return PortletURL
     */
    public PortletURL getUrl()
    {
        return url;
    }

    /**
     * Returns the var.
     * @return String
     */
    public String getVar()
    {
        return var;
    }

    /**
     * Sets the portletMode.
     * @param portletMode The portletMode to set
     */
    public void setPortletMode(String portletMode)
    {
        this.portletMode = portletMode;
    }

    /**
     * Sets secure to boolean value of the string
     * @param secure
     */
    public void setSecure(String secure)
    {
        this.secure = secure;
        this.secureBoolean = new Boolean(secure);
    }

    /**
     * Sets the windowState.
     * @param windowState The windowState to set
     */
    public void setWindowState(String windowState)
    {
        this.windowState = windowState;
    }

    /**
     * Sets the url.
     * @param url The url to set
     */
    public void setUrl(PortletURL url)
    {
        this.url = url;
    }

    /**
     * Sets the var.
     * @param var The var to set
     */
    public void setVar(String var)
    {
        this.var = var;
    }
}
