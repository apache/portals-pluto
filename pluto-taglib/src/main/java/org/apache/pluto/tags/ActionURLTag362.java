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


package org.apache.pluto.tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionURL;
import javax.portlet.BaseURL;
import javax.portlet.MimeResponse;
import javax.portlet.MutableActionParameters;
import javax.portlet.MutableRenderParameters;
import javax.portlet.MimeResponse.Copy;
import javax.servlet.jsp.JspException;

/**
 * 
 * A tag handler for the <CODE>actionURL</CODE> tag as defined in the JSR 362,
 * which creates a url that points to the current Portlet and triggers 
 * an action request with the supplied parameters.
 * 
 * @author Scott Nicklous
 *
 * @version 3.0
 */
public class ActionURLTag362 extends ActionURLTag286 {
   private static final long serialVersionUID = 2255241022374994557L;
   
   MutableRenderParameters rparams;
   MutableActionParameters aparams;
   
   public ActionURLTag362() {
      super();
   }
   
   @Override
   public int doStartTag() throws JspException {

      Object obj = pageContext.getRequest().getAttribute(Constants.PORTLET_RESPONSE);
      if ((obj == null) || !(obj instanceof MimeResponse)) {
         throw new JspException("Could not obtain MimeResponse to create the URL.");
      }

      MimeResponse resp = (MimeResponse) obj;
      ActionURL aurl = null;
      if (isCopyCurrentRenderParameters() == true) {
         aurl = resp.createActionURL(Copy.ALL);
      } else {
         aurl = resp.createActionURL(Copy.NONE);
      }
      rparams = aurl.getRenderParameters();
      aparams = aurl.getActionParameters();
      setUrl(aurl);

      handlePMandWS();
      handleDefaultEscapeXML();
      handleSecureFlag();

      return EVAL_BODY_INCLUDE;
   }

   /**
    * add an action parameter
    */
   @Override
   protected void addParameter(String key, String value) {
      if ((key == null) || (key.length() == 0)) {
         throw new IllegalArgumentException("the argument key must not be null or empty!");
      }

      if (value == null || value.length() == 0) {
         aparams.removeParameter(key);
      } else {
         String[] arrayVals = aparams.getValues(key);
         if (arrayVals != null) {
            List<String> vals = new ArrayList<String>(Arrays.asList(arrayVals));
            vals.add(value);
            aparams.setValues(key, vals.toArray(new String[0]));
         } else {
            aparams.setValue(key, value);
         }
      }
   }
   
   protected void addRenderParameter(String key, String value) {
      if ((key == null) || (key.length() == 0)) {
         throw new IllegalArgumentException("the argument key must not be null or empty!");
      }

      if (value == null || value.length() == 0) {
         rparams.removeParameter(key);
      } else {
         String[] arrayVals = rparams.getValues(key);
         if (arrayVals != null) {
            List<String> vals = new ArrayList<String>(Arrays.asList(arrayVals));
            vals.add(value);
            rparams.setValues(key, vals.toArray(new String[0]));
         } else {
            rparams.setValue(key, value);
         }
      }
   }
   
   /**
    * prevent additional copying
    */
   @Override
   protected void doCopyCurrentRenderParameters() {
   }
   
   /**
    * prevent additional copying
    */
   @Override
   protected void setUrlParameters(BaseURL url) {
   }
}
