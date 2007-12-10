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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.VariableInfo;
import javax.servlet.jsp.JspException;

import javax.portlet.BaseURL;


/**
 * Abstract supporting class for actionURL tag, renderURL tag and resourceURL tag.
 * 
 * @version 2.0
 * 
 */

public abstract class BaseURLTag extends TagSupport {
	
	protected String secure = null;
	
	protected Boolean secureBoolean = null;
	
	protected String var = null;
	
	//Attention: for JSR 286 Tags the default value is true
	protected Boolean escapeXml = false;
		
	protected Map<String, List<String>> parametersMap = 
		new HashMap<String, List<String>>();
	
	protected Map<String, List<String>> propertiesMap = 
		new HashMap<String, List<String>>();
	
	

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public abstract int doStartTag() throws JspException;
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	@Override
	public abstract int doEndTag() throws JspException;
	
	

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#release()
	 */
	@Override
	public void release(){
		super.release();
		secureBoolean = null;
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
    	if(this.secureBoolean != null){
    		return this.secureBoolean.booleanValue();
    	}
    	else{
    		return false;
    	}
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
    protected void addParameter(String key,String value) {
    	if(key == null){
    		throw new NullPointerException();
    	}
    	
    	if((value == null) || (value.length() == 0)){//remove parameter
    		if(parametersMap.containsKey(key)){
    			parametersMap.remove(key);
    		}
    	}
    	else{//add value
    	   	List<String> valueList = null;
    	
    	   	if(parametersMap.containsKey(key)){
    	   		valueList = parametersMap.get(key);//get old value list    		    	
    	   	}
    	   	else{
    	   		valueList = new ArrayList<String>();// create new value list    		    		
    	   	}
    	
    	   	valueList.add(value);
    	
    	   	parametersMap.put(key, valueList);
    	}
    }
    
    /**
     * Adds a key,value pair to the property map. 
     * @param key String
     * @param value String
     * @return void
     */
    protected void addProperty(String key,String value) {
    	if(key == null){
    		throw new NullPointerException();
    	}
    	
    	List<String> valueList = null;
    	
    	if(propertiesMap.containsKey(key)){
    		valueList = propertiesMap.get(key);//get old value list    		    	
    	}
    	else{
    		valueList = new ArrayList<String>();// create new value list    		    		
    	}

    	valueList.add(value);

    	propertiesMap.put(key, valueList);
    	
    }
    
    
    /**
     * Copies the parameters from map to the BaseURL.
     * @param url BaseURL
     * @return void
     */
    protected void setUrlParameters(BaseURL url) {
    	
    	Set<String> keySet = parametersMap.keySet();
    			
		for(String key : keySet){
			
			List<String> valueList = parametersMap.get(key);
		
			String[] valueArray = valueList.toArray(new String[0]);
			
			url.setParameter(key, valueArray);
		}
    }
    
    /**
     * Copies the properties from map to the BaseURL.
     * @param url BaseURL
     * @return void
     */
    protected void setUrlProperties(BaseURL url) {
    	Set<String> keySet = propertiesMap.keySet();
		
		for(String key : keySet){
			
			List<String> valueList = propertiesMap.get(key);
			
			for(String value:valueList){
				url.addProperty(key, value);
			}
		}
    }
    
    
    /**
     * Replaces in String str the characters &,>,<,",' 
     * with their corresponding character entity codes.
     * @param str - the String where to replace 
     * @return String 
     */
    protected String doEscapeXml(String str) {
    	if(!isEmpty(str)){
    		str = str.replaceAll("&", "&amp;");
    		str = str.replaceAll("<", "&lt;");
    		str = str.replaceAll(">", "&gt;");
    		str = str.replaceAll("\"", "&#034;");
    		str = str.replaceAll("'", "&#039;");
    	}
        return str;
    }
       
    
    /**
     * Checks if string is empty.
     * This method is a copy from <code>org.apache.commons.lang.StringUtils</code> class.
     * @param str String
     * @return boolean
     */
    private boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }
    
        
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
}
