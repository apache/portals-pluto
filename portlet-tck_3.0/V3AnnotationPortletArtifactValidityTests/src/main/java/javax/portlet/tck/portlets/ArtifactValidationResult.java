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

/**
 * A bean to hold result of injected artifact validity tests.
 * These tests are performed in different phases of portlet.
 * Initially the results are saved in portlet session attributes
 * Later, in resource phase (last phase) all tests are
 * recovered in this bean.
 */

public class ArtifactValidationResult {
   
   private boolean artifactInHeaderPhase;
   private boolean artifactInRenderPhase;
   private boolean artifactInActionPhase;
   private boolean artifactInResourcePhase;
   private boolean artifactInEventPhase;

   public ArtifactValidationResult(boolean artifactInHeaderPhase,
         boolean artifactInRenderPhase,
         boolean artifactInActionPhase,
         boolean artifactInEventPhase) {
      this.artifactInHeaderPhase = artifactInHeaderPhase;
      this.artifactInRenderPhase = artifactInRenderPhase;
      this.artifactInActionPhase = artifactInActionPhase;
      this.artifactInEventPhase = artifactInEventPhase;
   }

   public boolean isArtifactValidInHeaderPhase() {
      return artifactInHeaderPhase;
   }

   public boolean isArtifactValidInRenderPhase() {
      return artifactInRenderPhase;
   }

   public boolean isArtifactValidInActionPhase() {
      return artifactInActionPhase;
   }

   public boolean isArtifactValidInResourcePhase() {
      return artifactInResourcePhase;
   }

   public void setArtifactValidInResourcePhase(
         boolean artifactInResourcePhase) {
      this.artifactInResourcePhase = artifactInResourcePhase;
   }

   public boolean isArtifactValidInEventPhase() {
      return artifactInEventPhase;
   }

   public boolean isArtifactValidInAllPhase() {
      if(artifactInHeaderPhase && artifactInRenderPhase && artifactInActionPhase && artifactInResourcePhase && artifactInEventPhase){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean isArtifactValidInOnlyActionPhase() {
      if(!artifactInHeaderPhase && !artifactInRenderPhase && artifactInActionPhase && !artifactInResourcePhase && !artifactInEventPhase){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean isArtifactValidInOnlyRenderPhase() {
      if(!artifactInHeaderPhase && artifactInRenderPhase && !artifactInActionPhase && !artifactInResourcePhase && !artifactInEventPhase){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean isArtifactValidInOnlyEventPhase() {
      if(!artifactInHeaderPhase && !artifactInRenderPhase && !artifactInActionPhase && !artifactInResourcePhase && artifactInEventPhase){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean isArtifactValidInOnlyResourcePhase() {
      if(!artifactInHeaderPhase && !artifactInRenderPhase && !artifactInActionPhase && artifactInResourcePhase && !artifactInEventPhase){
         return true;
      } else {
         return false;
      }
   }
   
   public boolean isArtifactValidInOnlyHeaderPhase() {
      if(artifactInHeaderPhase && !artifactInRenderPhase && !artifactInActionPhase && !artifactInResourcePhase && !artifactInEventPhase){
         return true;
      } else {
         return false;
      }
   }
   
}
