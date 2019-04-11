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

package org.apache.portals.pluto.demo.v3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {

   // maps the names of the images to the paths to the images -
   public final static Map<String, String> IMG_MAP;
   
   static {
      Map<String, String> imgMap = new HashMap<String, String>();
      imgMap.put("baseball", "/resources/images/baseball-trans.gif");
      imgMap.put("golfball", "/resources/images/golfball-trans.gif");
      imgMap.put("fussball", "/resources/images/fussball-trans.gif");
      IMG_MAP = Collections.unmodifiableMap(imgMap);
   }

   public final static String DEFAULT_IMAGE = "/resources/images/FullMoon.gif";

   public final static String PARAM_SELTYPE = "selType";
   public final static String PARAM_SELTYPE_RADIO = "radio";
   public final static String PARAM_SELTYPE_DROPDOWN = "dropdown";
   
   // privae parameter for color selection portlet
   public final static String PARAM_SUBTYPE = "subType";
   public final static String PARAM_SUBTYPE_URL = "URL";
   public final static String PARAM_SUBTYPE_FORM = "form";
   
   public final static String PARAM_IMGNAME = "photo";
   public final static String PARAM_COLOR = "color";
   public final static String PARAM_ERRMSG = "errmsg";
   public final static String PARAM_BORDER = "bo";
   public final static String PARAM_BORDER_COLOR = "border";
   public final static String PARAM_CACHE = "ca";
   public final static String PARAM_CACHE_PAGE = "pa";
   public final static String PARAM_CACHE_PORTLET = "po";
   public final static String PARAM_CACHE_FULL = "fu";
   
   public final static String PARAM_FG_COLOR = "fgcolor";
   public final static String PARAM_FG_RED = "red";
   public final static String PARAM_FG_GREEN = "green";
   public final static String PARAM_FG_BLUE = "blue";
   public final static String PARAM_MSG_INPUT = "imsg";
   public final static String PARAM_URL_INPUT = "url";
   
   public final static String PARAM_NUM_ACTIONS = "numActions";

   public final static String PARAM_NUM_MSGS = "numMsgs";
   public final static String ATTRIB_MSGS = "msgs";
   
   public final static String EVENT_NAMESPACE = "http://www.apache.org/portals/pluto/pub-render-params/ResourcePortlet";
   public final static String EVENT_NAME = "Message";
   
   public final static String DELIM = ";%;";
   
   // For header portlet
   public final static String ATTRIB_PROPS = "properties";

   // For PortletConfig portlet
   public final static String ATTRIB_PRPS = "prps";
   public final static String ATTRIB_PMS = "portletModes";
   public final static String ATTRIB_WS = "windowStates";
   public final static String ATTRIB_CTX = "portletContext";

   // For parameter & URL test portlets

   public final static String PARAM_NAME = "pName";
   public final static String PARAM_VALUES = "pValues";
   public final static String PARAM_REMTYPE = "remType";
   public final static String PARAM_REMTYPE_REM = "remPRP";
   public final static String PARAM_REMTYPE_SET = "setRP";
   public final static String PARAM_SETTYPE = "setType";
   public final static String PARAM_SETTYPE_VAL = "setVal";
   public final static String PARAM_SETTYPE_VARRAY = "setVals";
   public final static String PARAM_AURLCOPY = "acopy";
   public final static String PARAM_AURLCOPY_NONE = "acopy_none";
   public final static String PARAM_AURLCOPY_PUBLIC = "acopy_public";
   public final static String PARAM_AURLCOPY_ALL = "acopy_all";
   public final static String ATTRIB_PARAMS = "params";
   public final static String ATTRIB_RENURLS = "renurls";
   public final static String ATTRIB_RESURLS = "resurls";
   public final static String ATTRIB_ACTURLS = "acturls";
   public final static String ATTRIB_ACTURL = "aurl";
   public final static String ATTRIB_ACTPARAMS = "actParams";
   
   // For Fragment ID test portlet (LongPortlet)
   
   public final static String PARAM_FRAG = "frag";
   public final static String PARAM_LINE = "line";
   public final static String ATTRIB_LONGLINES = "longlines";
   
   // For Auth & Status Code portlet
   
   public final static String PARAM_STATUSCODE = "statusCode";

}
