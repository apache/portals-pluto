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

package org.apache.pluto.portalImpl.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.portalImpl.aggregation.Fragment;
import org.apache.pluto.portalImpl.aggregation.PortletFragment;
import org.apache.pluto.util.StringUtils;

public class PortalControlParameter {

    static public final String ACTION = "ac";
    static public final String MODE = "md";
    static public final String PORTLET_ID = "pid";
    static public final String PREFIX = "_";
    static public final String PREV_MODE = "pm";
    static public final String PREV_STATE = "ps";
    static public final String RENDER_PARAM = "rp";
    static public final String STATE = "st";

    private Map requestParameter = new HashMap();

    /**
     * The map containing the encoded statefull control parameters.
     * They are encoded in the sense, that names and values of 
     * <i>render parameters</i> and render parameters only are encoded
     * using {{@link #encodeRenderParamName(PortletWindow, String)}}
     * and {{@link #encodeRenderParamValues(String[])}}.
     */
    private Map encodedStateFullControlParameter;
    
    private Map stateLessControlParameter;
    private PortalURL url;

    
    public PortalControlParameter(PortalURL url) {
        this.url = url;
        encodedStateFullControlParameter = this.url.getClonedEncodedStateFullControlParameter();
        stateLessControlParameter = this.url.getClonedStateLessControlParameter();
    }

    
    /**
     * Encodes the given String. Encoding means that all characters that might
     * interfere with the algorithm used to prefix parameters to associate them
     * with the correct portal window will be encoded. The reverse method is
     * {{@link #decodeString(String)}}.  
     * @param value The String to be encoded.
     * @return The encoded String.
     * @see #decodeParameterName(String)
     */
    private static String encodeString(String value) {
    	value = StringUtils.replace(value, "0x", "0xx");
        value = StringUtils.replace(value, "_", "0x1" );
        value = StringUtils.replace(value, ".", "0x2" );
        value = StringUtils.replace(value, "/", "0x3" );
        value = StringUtils.replace(value, "\r", "0x4" );
        value = StringUtils.replace(value, "\n", "0x5" );
        value = StringUtils.replace(value, "<", "0x6" );
        value = StringUtils.replace(value, ">", "0x7" );
        value = StringUtils.replace(value, " ", "0x8" );
        return value;
    }

    /**
     * Decodes the given String. This is the reverse method to
     * {{@link #encodeString(String)}}.
     * @param value The string to be decoded.
     * @return The decoded String.
     */
    private static String decodeString(String value) {
        value = StringUtils.replace(value, "0x1", "_" );
        value = StringUtils.replace(value, "0x2", "." );
        value = StringUtils.replace(value, "0x3", "/" );
        value = StringUtils.replace(value, "0x4", "\r" );
        value = StringUtils.replace(value, "0x5", "\n" );
        value = StringUtils.replace(value, "0x6", "<" );
        value = StringUtils.replace(value, "0x7", ">" );
        value = StringUtils.replace(value, "0x8", " " );
        value = StringUtils.replace(value, "0xx", "0x");
        return value;
    }
    
    /**
     * Each parameter is encoded by prefixing it with the String
     * {@link #PREFIX}. The reverse method is {{@link #decodeParameterName(String)}}.
     * Don't mistake this method for {{@link #encodeRenderParamName(PortletWindow, String)}}
     * or {{@link #encodeRenderParamValues(String[])}}.
     * @param param The parameter to be encoded / prefixed.
     * @return The encoded parameter.
     */
    public static String encodeParameterName(String param) {
        return PREFIX + param;
    }

    /**
     * Decodes a parameter by deleting the prefix, if the parameter
     * was prefixed. Reverse method to {{@link #encodeParameterName(String)}}.
     * Don't mistake this method for {{@link #decodeRenderParameterName(String)}}
     * or {{@link #decodeRenderParamValues(String)}}.
     * @param param The parameter to be decoded.
     * @return The decoded parameter.
     */
    public static String decodeParameterName(String param) {
    	if (param.startsWith(PREFIX)) {
    		return param.substring(PREFIX.length());
    	} else {
    		return param;
    	}
    }
    
    /**
     * Dummy method. Does nothing!
     */
    public static String decodeParameterValue(String paramName, String paramValue) {
        return paramValue;
    }

    /**
     * Encodes the given render parameter name. The name will be encoded using the
     * {{@link #encodeValue(String)}} method, meaning that characters that will 
     * interfere with plutos internal url encoding and decoding
     * mechanisms, like "/" or "_" will be encoded. The parameter name will then
     * be prefixed with a string that encodes the portlet window the parameter belongs to.
     * This prefix contains the characters ("/", "_", ...) that had to be encoded in
     * the parameter name to later allow for a safe parsing of the prefix.
     * @return A string encoding the given render parameter name to be used in portal urls.
     */
    public static String encodeRenderParamName(PortletWindow window, String paramName) {
    	String encodedParamName = encodeString(paramName);
        StringBuffer returnvalue = new StringBuffer(50);
        returnvalue.append(getRenderParamKey(window));
        returnvalue.append("_");
        returnvalue.append(encodedParamName);
        return returnvalue.toString();
    }

    /**
     * Reverse method for method {{@link #encodeRenderParamName(PortletWindow, String)}}.
     */
    public static String decodeRenderParamName(PortletWindow window, String encodedRenderParamName) {
    	String prefix = getRenderParamKey(window);
    	String unprefixedRenderParamName = null;
    	if (encodedRenderParamName.startsWith(prefix)) {
    		unprefixedRenderParamName = encodedRenderParamName.substring(prefix.length());
    	} else {
    		unprefixedRenderParamName = encodedRenderParamName;
    	}
    	return decodeString(unprefixedRenderParamName);
    }
    
    /**
     * Encodes the given render parameter values. The values are encoded
     * in one single string that will be used in portal urls. 
     * @param paramValues The render parameter values to be encoded.
     * @return A string containing the encoded render parameter values.
     */
    public static String encodeRenderParamValues(String[] paramValues)
    {
        StringBuffer returnvalue = new StringBuffer(100);
        returnvalue.append(paramValues.length);
        for (int i=0; i<paramValues.length; i++) {
            returnvalue.append("_");
            if(paramValues[i]!=null) {
                returnvalue.append(encodeString(paramValues[i]));
            }
        }
        return returnvalue.toString();
    }

    /**
     * Reverse method for the method {{@link #encodeRenderParamValues(String[])}}.
     */
    private static String[] decodeRenderParamValues(String encodedParamValues) {
        StringTokenizer tokenizer = new StringTokenizer(encodedParamValues, "_");
        if (!tokenizer.hasMoreTokens()) {
        	return null;
        }
        String _count = tokenizer.nextToken();
        int count = Integer.valueOf(_count).intValue();
        String[] values = new String[count];
        for (int i = 0; i < count; i++) {
            if (!tokenizer.hasMoreTokens()) {
            	return null;
            }
            values[i] = decodeString(tokenizer.nextToken());
        }
        return values;
    }

    /**
     * Retrieve the key to use to prefix render parameters of the given
     * portlet window.
     * @param window
     * @return
     */
    public static String getRenderParamKey(PortletWindow window) {
        return RENDER_PARAM + "_" + window.getId().toString();
    }

    /**
     * Check whether the given string encodes a control parameter.
     */
    public static boolean isControlParameter(String param) {
        return param.startsWith(PREFIX);
    }

    /**
     * Check whether the given string encodes a stateful parameter,
     * i.e. mode, previous mode, window state, previous window state or 
     * render parameter.
     */
    public static boolean isStateFullParameter(String param) {
        if (isControlParameter(param)) {
            if ((param.startsWith(PREFIX + MODE)) ||
                (param.startsWith(PREFIX + PREV_MODE)) ||
                (param.startsWith(PREFIX + STATE)) ||
                (param.startsWith(PREFIX + PREV_STATE)) ||
                (param.startsWith(PREFIX + RENDER_PARAM))) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Deletes all render parameter that belong to the given window.
     */
    public void clearRenderParameters(PortletWindow portletWindow) {
        String prefix = getRenderParamKey(portletWindow);
        Iterator keyIterator = encodedStateFullControlParameter.keySet().iterator();
        while (keyIterator.hasNext()) {
            String encodedName = (String)keyIterator.next();
            if (encodedName.startsWith(prefix)) {
                keyIterator.remove();
            }
        }
    }

    private String getActionKey(PortletWindow window)
    {
        return ACTION+"_"+window.getId().toString();
    }

    public String[] getActionParameter(PortletWindow window, String paramName) {
        String encodedValues = (String)encodedStateFullControlParameter.get(encodeRenderParamName(window, paramName));
        String[] decodedValues = decodeRenderParamValues(encodedValues);
        return decodedValues;
    }

    public PortletMode getMode(PortletWindow window) {
        String mode = (String)encodedStateFullControlParameter.get(getModeKey(window));
        if (mode != null) {
            return new PortletMode(mode);
        } else {
            return PortletMode.VIEW;
        }
    }

    private String getModeKey(PortletWindow window) {
        return MODE + "_" + window.getId().toString();
    }

    public String getPIDValue() {
        String value = (String)stateLessControlParameter.get(getPortletIdKey());
        return value == null ? "" : value;
    }

    private String getPortletIdKey() {
        return PORTLET_ID;
    }

    public PortletWindow getPortletWindowOfAction() {
        Iterator iterator = getStateLessControlParameter().keySet().iterator();
        while (iterator.hasNext()) {
            String name = (String)iterator.next();
            if (name.startsWith(ACTION)) {
                String id = name.substring(ACTION.length()+1);
                Fragment fragment = org.apache.pluto.portalImpl.services.pageregistry.PageRegistry.getFragment(id);
                if (fragment instanceof PortletFragment) {
                    return((PortletFragment)fragment).getPortletWindow();
                }
            }
        }
        return null;
    }

    public PortletMode getPrevMode(PortletWindow window) {
        String mode = (String)encodedStateFullControlParameter.get(getPrevModeKey(window));
        if (mode != null) {
            return new PortletMode(mode);
        } else {
            return null;
        }
    }
    
    private String getPrevModeKey(PortletWindow window) {
        return PREV_MODE + "_" + window.getId().toString();
    }

    public WindowState getPrevState(PortletWindow window) {
        String state = (String)encodedStateFullControlParameter.get(getPrevStateKey(window));
        if (state!=null)
            return new WindowState(state);
        else
            return null;
    }
    
    private String getPrevStateKey(PortletWindow window) {
        return PREV_STATE + "_" + window.getId().toString();
    }

    public Iterator getRenderParamNames(PortletWindow window) {
        ArrayList returnvalue = new ArrayList();
        String prefix = getRenderParamKey(window);
        Iterator keyIterator = encodedStateFullControlParameter.keySet().iterator();
        while (keyIterator.hasNext()) {
            String encodedName = (String)keyIterator.next();
            if (encodedName.startsWith(prefix)) {
            	// remove specific render parameter name encoding
            	String decodedName = decodeRenderParamName(window, encodedName);
            	// remove general parameter encoding
            	String unprefixedName = decodeParameterName(decodedName);
            	returnvalue.add(unprefixedName);
            }
        }
        return returnvalue.iterator();
    }

    public String[] getRenderParamValues(PortletWindow window, String paramName) {
        String encodedValues = (String)encodedStateFullControlParameter.get(encodeRenderParamName(window, paramName));
        String[] decodedValues = decodeRenderParamValues(encodedValues);
        return decodedValues;
    }

    public Map getRequestParameter() {
        return requestParameter;
    }

    public WindowState getState(PortletWindow window) {
        String state = (String)encodedStateFullControlParameter.get(getStateKey(window));
        if (state!=null)
            return new WindowState(state);
        else
            return WindowState.NORMAL;
    }

    public Map getEncodedStateFullControlParameter() {
        return encodedStateFullControlParameter;
    }

    private String getStateKey(PortletWindow window) {
        return STATE+"_"+window.getId().toString();
    }

    public Map getStateLessControlParameter() {
        return stateLessControlParameter;
    }

    public boolean isOnePortletWindowMaximized() {
        Iterator iterator = encodedStateFullControlParameter.keySet().iterator();
        while (iterator.hasNext()) {
            String encodedName = (String)iterator.next();
            if (encodedName.startsWith(STATE)) {
                if (encodedStateFullControlParameter.get(encodedName).equals(WindowState.MAXIMIZED.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setAction(PortletWindow window) {
        getEncodedStateFullControlParameter().put(getActionKey(window),ACTION.toUpperCase());
    }

    public void setMode(PortletWindow window, PortletMode mode) {
        Object prevMode = encodedStateFullControlParameter.get(getModeKey(window));
        if (prevMode!=null)
            encodedStateFullControlParameter.put(getPrevModeKey(window), prevMode);
        // set current mode
        encodedStateFullControlParameter.put(getModeKey(window), mode.toString());
    }

    public void setPortletId(PortletWindow window) {
        getEncodedStateFullControlParameter().put(getPortletIdKey(),window.getId().toString());
        //getStateLessControlParameter().put(getPortletIdKey(),window.getId().toString());
    }

    /**
     * Sets the given render parameter. Note that its name as well as its values will
     * be encoded for storage using {{@link #encodeRenderParamName(PortletWindow, String)}}
     * and {{@link #encodeRenderParamValues(String[])}.
     */
    public void setRenderParam(PortletWindow window, String name, String[] values) {
        encodedStateFullControlParameter.put(encodeRenderParamName(window, name), 
                                      encodeRenderParamValues(values) );
    }

    public void setRequestParam(String name, String[] values ) {
        requestParameter.put(name, values );
    }


    public void setState(PortletWindow window, WindowState state) {
        Object prevState = encodedStateFullControlParameter.get(getStateKey(window));
        if (prevState != null) {
            encodedStateFullControlParameter.put(getPrevStateKey(window), prevState);
        }
        encodedStateFullControlParameter.put(getStateKey(window), state.toString());
    }

}
