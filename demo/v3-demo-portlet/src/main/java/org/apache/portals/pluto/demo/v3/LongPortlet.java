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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.portals.pluto.demo.v3.Constants.ATTRIB_LONGLINES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;
import javax.portlet.ActionParameters;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


/**
 * A portlet that allows render parameter names & values to be entered and set.
 * 
 * @author Scott Nicklous
 */
public class LongPortlet extends GenericPortlet {

   // Set up logging
   private static final Logger logger = LoggerFactory.getLogger(LongPortlet.class);
   private static final boolean isDebug = logger.isDebugEnabled();
   
   private static final ArrayList<String> lines = new ArrayList<String>();
   static {
      lines.add("");
      lines.add("");
      lines.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus mi orci,");
      lines.add("eleifend eu molestie id, tincidunt nec sem. Etiam volutpat justo id egestas");
      lines.add("auctor. Morbi malesuada dictum ultricies. Mauris vestibulum diam ut eleifend");
      lines.add("malesuada. Quisque ornare mi quis auctor dapibus. Praesent ut maximus nibh.");
      lines.add("Donec aliquet consequat luctus.");
      lines.add("");
      lines.add("Vivamus et porttitor ipsum, non feugiat mi. Phasellus eu turpis iaculis,");
      lines.add("scelerisque sem in, faucibus eros. Ut sed lectus id turpis egestas congue non");
      lines.add("cursus lorem. Vestibulum viverra porttitor sem, eget imperdiet turpis dignissim");
      lines.add("vel. Curabitur ultrices non erat a lobortis. Nam mollis laoreet diam, sit amet");
      lines.add("dictum mauris bibendum in. Curabitur a risus nec purus varius consequat. Sed");
      lines.add("mattis sit amet turpis in bibendum. Phasellus congue risus risus, at porta ex");
      lines.add("mollis fermentum. Morbi tincidunt nulla tellus, vel eleifend ex maximus eget. In");
      lines.add("eget porta sapien. Integer viverra mauris ac massa porta aliquet. Fusce nisl");
      lines.add("purus, ultrices non metus non, dignissim viverra augue.");
      lines.add("");
      lines.add("Donec eget eros sollicitudin, semper quam vel, pulvinar nulla. Nam sed elit nec");
      lines.add("lacus finibus consequat in sed tortor. Lorem ipsum dolor sit amet, consectetur");
      lines.add("adipiscing elit. Suspendisse laoreet arcu a magna euismod, malesuada interdum");
      lines.add("diam venenatis. Nulla bibendum viverra leo, nec aliquam mauris. In viverra");
      lines.add("mauris in ipsum porta imperdiet. Morbi sapien mi, convallis sit amet tempus vel,");
      lines.add("pretium ac mi. Praesent risus eros, interdum quis faucibus nec, scelerisque non");
      lines.add("diam. Nam mi turpis, dignissim sed ligula a, fringilla consectetur elit.");
      lines.add("");
      lines.add("Integer semper eros ut lorem finibus placerat. Praesent id magna auctor, pretium");
      lines.add("ex eu, suscipit diam. Nunc felis tortor, luctus a pharetra sit amet, placerat");
      lines.add("nec ante. Interdum et malesuada fames ac ante ipsum primis in faucibus.");
      lines.add("Curabitur urna risus, gravida in justo id, sollicitudin pulvinar felis. Lorem");
      lines.add("ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec arcu semper,");
      lines.add("ullamcorper libero vel, consectetur nulla. Donec at tincidunt est. Donec a");
      lines.add("tempor urna, ac molestie neque. Suspendisse malesuada lacus et ligula gravida,");
      lines.add("ut ullamcorper orci malesuada.");
      lines.add("");
      lines.add("Praesent tincidunt malesuada lectus eu lobortis. Nunc sit amet est non nibh");
      lines.add("malesuada feugiat quis venenatis odio. Donec consectetur arcu eget odio");
      lines.add("bibendum, a semper sem finibus. Nam ac orci sit amet libero eleifend cursus.");
      lines.add("Curabitur faucibus lorem ut velit dignissim, luctus tristique mauris");
      lines.add("consectetur. Nunc nec pellentesque ex, in porta lorem. Nullam sit amet justo");
      lines.add("hendrerit, congue arcu eget, fringilla elit. Nunc vehicula sagittis orci, ut");
      lines.add("auctor neque accumsan ac.");
      lines.add("");
      lines.add("Morbi porttitor sem id vestibulum tempor. Sed auctor condimentum dolor vel");
      lines.add("laoreet. Suspendisse viverra dignissim lorem at tristique. Integer vel erat quis");
      lines.add("diam porta tempus et consequat lectus. Mauris sagittis mattis nulla quis");
      lines.add("rhoncus. Sed vel iaculis justo. Vivamus fermentum lectus et nunc congue, non");
      lines.add("efficitur nisl gravida. Suspendisse bibendum nisl vel augue feugiat, et dapibus");
      lines.add("sapien mollis. Praesent eleifend blandit porta. Vestibulum pulvinar libero est,");
      lines.add("id lacinia ipsum facilisis at. Donec volutpat, nisi sed efficitur rhoncus, mi");
      lines.add("purus bibendum nisi, et elementum elit orci aliquam sapien. Suspendisse sit amet");
      lines.add("viverra sem, sed consequat magna. Nulla eget purus sed massa mollis hendrerit.");
      lines.add("");
      lines.add("Quisque velit ipsum, consectetur vel laoreet non, efficitur vitae metus.");
      lines.add("Pellentesque enim ipsum, sagittis et gravida quis, vehicula nec elit. Aliquam");
      lines.add("erat volutpat. Nulla facilisi. Vestibulum eu sem nec neque efficitur lacinia nec");
      lines.add("maximus turpis. Sed iaculis libero tristique volutpat lacinia. Duis tellus");
      lines.add("mauris, luctus eget semper nec, luctus vitae sem. Proin vitae odio lectus.");
      lines.add("Vestibulum non felis sit amet elit porttitor fermentum at in urna. Integer sed");
      lines.add("scelerisque lacus. Etiam facilisis diam non mi tempor efficitur. Ut nunc nisi,");
      lines.add("porta non volutpat sed, ullamcorper a urna. Quisque sagittis blandit lacinia.");
      lines.add("Suspendisse aliquam, est molestie pharetra tempor, mi justo luctus odio, non");
      lines.add("efficitur turpis risus id sem.");
      lines.add("");
      lines.add("Nulla fringilla egestas magna vel scelerisque. Nunc at lacinia nisi. In eget");
      lines.add("aliquet orci. Donec maximus tristique dignissim. Proin eu porttitor risus. Etiam");
      lines.add("placerat sem justo, at lacinia risus sagittis vel. Praesent a dapibus velit.");
      lines.add("Donec viverra risus eget pulvinar hendrerit.");
      lines.add("");
      lines.add("Aliquam sagittis consequat mi eu tincidunt. Proin lacinia hendrerit purus at");
      lines.add("fringilla. Suspendisse aliquet eu turpis nec vulputate. Nunc tempor enim ut");
      lines.add("facilisis fringilla. Morbi pharetra vestibulum pulvinar. Duis quis ex quis");
      lines.add("ligula elementum molestie non a odio. Aenean gravida neque eu tincidunt commodo.");
      lines.add("Donec purus nisi, auctor et elit non, venenatis gravida ex. Praesent sodales");
      lines.add("fermentum nunc. Mauris feugiat et tellus id tempor.");
      lines.add("");
      lines.add("Ut finibus nisl et vestibulum efficitur. Curabitur ultrices lorem tellus, sed");
      lines.add("tristique nulla feugiat eget. Donec vulputate mollis ligula id commodo. Donec");
      lines.add("tempor, nulla vitae pellentesque hendrerit, sapien dui imperdiet lacus, vel");
      lines.add("blandit lorem erat ac urna. Pellentesque volutpat pulvinar commodo. Sed");
      lines.add("malesuada consequat dolor, id feugiat elit consequat dictum. Aenean est massa,");
      lines.add("blandit consectetur arcu a, placerat volutpat tortor. Quisque semper scelerisque");
      lines.add("vestibulum. Proin mattis malesuada viverra.");
   }

   @Override
   public void init() throws PortletException {
      super.init();
   }

   protected void doView(RenderRequest req, RenderResponse resp)
         throws PortletException, IOException {

      resp.setContentType("text/html");
      
      req.setAttribute(ATTRIB_LONGLINES, lines);

      PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(
            "/WEB-INF/jsp/view-long.jsp");
      rd.include(req, resp);

   }
   
   /* (non-Javadoc)
    * @see javax.portlet.GenericPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
    */
   @Override
   public void serveResource(ResourceRequest req, ResourceResponse resp)
         throws PortletException, IOException {
   }

   @Inject private ActionParameters ap;
   @Inject private MutableRenderParameters mrp;

   public void processAction(ActionRequest req, ActionResponse resp)
         throws PortletException, IOException {
      
      mrp.set(ap);

      if (isDebug) {
         StringBuffer sb = new StringBuffer();
         sb.append("Long portlet action parameters:");
         for (String k : ap.getNames()) {
            sb.append("\nName: ").append(k);
            sb.append(", Values: ").append(Arrays.toString(ap.getValues(k)));
         }
         logger.debug(sb.toString());
      }

   }

}
