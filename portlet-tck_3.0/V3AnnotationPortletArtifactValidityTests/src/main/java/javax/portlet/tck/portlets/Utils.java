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

package javax.portlet.tck.portlets;

import java.util.Set;

import javax.portlet.PortletParameters;

/**
 * Utils hold all common constants and test functions
 * specific to V2AnnotationPortletArtifactValidityTests module
 */

public class Utils {

   public static final String ACTIONPARAMETERSARTIFACTKEY        = "_actionParametersArtifact_";
   public static final String MUTABLERENDERPARAMETERSARTIFACTKEY = "_mutableRenderParametersArtifact_";
   public static final String RENDERPARAMETERSARTIFACTKEY        = "_renderParametersArtifact_";
   public static final String RESOURCEPARAMETERSARTIFACTKEY      = "_resourceParametersArtifact_";
   public static final String ACTIONPHASE                        = "action";
   public static final String RENDERPHASE                        = "render";
   public static final String HEADERPHASE                        = "header";
   public static final String EVENTPHASE                         = "event";

   public boolean isValid(Object injectedPortletArtifact) {
      if (injectedPortletArtifact == null) {
         return false;
      } else {
         return true;
      }
   }

   public boolean checkEqualParameters(
         PortletParameters injectedPortletArtifact,
         PortletParameters requestParameters) {
      String injectedValue;
      String requestValue;
      if (injectedPortletArtifact == null) {
         return false;
      }
      if (injectedPortletArtifact.size() == requestParameters.size()) {
         Set<? extends String> parameters = injectedPortletArtifact.getNames();
         for (String paramName : parameters) {
            injectedValue = injectedPortletArtifact.getValue(paramName);
            requestValue = requestParameters.getValue(paramName);
            if (!injectedValue.equals(requestValue)) {
               return false;
            }
         }
      } else {
         return false;
      }
      return true;
   }

   public String createTestDebug(ArtifactValidationResult validationResult) {
      StringBuilder txt = new StringBuilder();
      txt.append("<p>Debug Info: ");
      txt.append("<table>");
      txt.append("   <tr>");
      txt.append("      <td>Action</td>");
      txt.append("      <td>Event</td>");
      txt.append("      <td>Header</td>");
      txt.append("      <td>Render</td>");
      txt.append("      <td>Resource</td>");
      txt.append("   </tr>");
      txt.append("   <tr>");
      txt.append("      <td>" + validationResult.isArtifactValidInActionPhase()
            + "</td>");
      txt.append("      <td>" + validationResult.isArtifactValidInEventPhase()
            + "</td>");
      txt.append("      <td>" + validationResult.isArtifactValidInHeaderPhase()
            + "</td>");
      txt.append("      <td>" + validationResult.isArtifactValidInRenderPhase()
            + "</td>");
      txt.append("      <td>"
            + validationResult.isArtifactValidInResourcePhase() + "</td>");
      txt.append("   </tr>");
      txt.append("</table>");
      txt.append("</p>");
      return txt.toString();
   }

}
