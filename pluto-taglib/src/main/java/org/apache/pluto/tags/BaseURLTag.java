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
package org.apache.pluto.tags;

import java.util.*;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.VariableInfo;
import javax.servlet.jsp.JspException;

import javax.portlet.BaseURL;


/**
 * Abstract supporting class for actionURL tag, renderURL tag and resourceURL tag.
 * 
 * @author <a href="mailto:olisp_jena@yahoo.de">Oliver Spindler</a> (since Nov 01, 2006)
 * @version 2.0
 * 
 */

public abstract class BaseURLTag extends TagSupport {
	
	/**
	 * TagExtraInfo class for BaseUrlTag.
	 */
	public static class TEI extends TagExtraInfo {
		
        public VariableInfo[] getVariableInfo(TagData tagData) {
            VariableInfo vi[] = null;
            String var = tagData.getAttributeString("var");
            if (var != null) {
                vi = new VariableInfo[1];
                vi[0] =
                new VariableInfo(var, "java.lang.String", true,
                                 VariableInfo.AT_BEGIN);
            }
            return vi;
        }

    }
	
	protected String secure;
	protected Boolean secureBoolean;
	protected String var;
	//TODO: not the default value (should be true)
	protected Boolean escapeXml=false;
		
	protected Map<String,List<String>> parameters=new HashMap<String,List<String>> (); 
	
	
	/**
	 * Process the start tag for this instance.
	 * @throws JspException
     * @return int
     */
	public abstract int doStartTag() throws JspException;
	
	
	/**
	 * Process the end tag for this instance.
	 * @throws JspException
     * @return int
     */
	public abstract int doEndTag() throws JspException;
	
	
	/**
	 * Releases state of the tag handler.
     * @return void
     */
	//Called at the end of the lifecycle.
	public void release()
	{
		super.release();
		parameters=null;
		secureBoolean=null;
	}
	
	
	/**
	 * Returns secure property as String.
     * @return String
     */
    public String getSecure() {
        return secure;
    }
    
    
    /**
     * Returns secure property as Boolean.
     * @return boolean
     */
    public boolean getSecureBoolean() {
        return this.secureBoolean.booleanValue();
    }  
    
    
    /**
     * Returns the var property.
     * @return String
     */
    public String getVar() {
        return var;
    }
    
    
    /**
     * Returns escapeXml property.
     * @return Boolean
     */
    public Boolean getEscapeXml() {
        return escapeXml;
    }
    
    
    /**
     * Sets secure property to boolean value of the string.
     * @param secure
     * @return void
     */
    public void setSecure(String secure) {
        this.secure = secure;
        this.secureBoolean = new Boolean(secure);
    }
     
    
    /**
     * Sets the var property.
     * @param var The var to set
     * @return void
     */
    public void setVar(String var) {
        this.var = var;
    }
    
    
    /**
     * Sets the escapeXml property.
     * @param escapeXml
     * @return void
     */
    public void setEscapeXml(Boolean escapeXml) {
        this.escapeXml = escapeXml;
    }
    
    
    /**
     * Adds a key,value pair to the parameter map. 
     * @param key String
     * @param value String
     * @return void
     */
    public void addParameter(String key,String value)
    {
    	/*if (escapeXml)
    	{
    		value=escapeXml(value);
    	}*/
    	List<String> values;
    	if(parameters.containsKey(key))
    	{
    		values=(List<String>)parameters.get(key);//get old value list    		    	
    	}
    	else
    	{
    		values=new ArrayList<String>();// create new value list    		    		
    	}
    	values.add(value);
    	parameters.put(key, values);
    }
    
    
    /**
     * Copies parameters from map to url.
     * @param url BaseURL
     * @return void
     */
    protected void setUrlParameters(BaseURL url)
    {
    	Set<String> keys=parameters.keySet();
		Iterator i=keys.iterator();
		while(i.hasNext())
		{
			String key=(String) i.next();
			List<String> values=parameters.get(key);
			String[] valarr=values.toArray(new String[0]);	
			url.setParameter(key, valarr);
		}
    }
    
    
    /**
     * Replaces in String str the characters &,>,<,",' 
     * with their corresponding character entity codes.
     * @param str - the String where to replace 
     * @return String 
     */
    protected String doEscapeXml(String str) {
        str = replace(str,"&","&amp;");
        str = replace(str,"<","&lt;");
        str = replace(str,">","&gt;");
        str = replace(str,"\"","&#034;");
        str = replace(str,"'","&#039;");
        return str;
    }
       
    
    /**
     * Checks if string is empty.
     * This method has been copied from <code>org.apache.commons.lang.StringUtils</code> class.
     * @param str String
     * @return boolean
     */
    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    
    
    /**
     * Replaces String repl with String with in String text.
     * This method has been copied from <code>org.apache.commons.lang.StringUtils</code> class.
     * @param text - the String where to replace 
     * @param repl - the sub-String what to replace
     * @param with - the sub-String what to replace repl with
     * @return String 
     */
    private String replace(String text, String repl, String with) {
    	int max=-1;
        if (isEmpty(text) || isEmpty(repl) || with == null || max == 0) {
            return text;
        }
        int start = 0;
        int end = text.indexOf(repl, start);
        if (end == -1) {
            return text;
        }
        int replLength = repl.length();
        int increase = with.length() - replLength;
        increase = (increase < 0 ? 0 : increase);
        increase *= (max < 0 ? 16 : (max > 64 ? 64 : max));
        StringBuffer buf = new StringBuffer(text.length() + increase);
        while (end != -1) {
            buf.append(text.substring(start, end)).append(with);
            start = end + replLength;
            if (--max == 0) {
                break;
            }
            end = text.indexOf(repl, start);
        }
        buf.append(text.substring(start));
        return buf.toString();
    }

}
