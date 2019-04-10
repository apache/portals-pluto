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

package javax.portlet.tck.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class to transport parameters as a Jaxb serializable event payload.
 * 
 * @author Scott Nicklous
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TckParameters implements Serializable {
   private static final long serialVersionUID = -2246579286366994330L;

   @XmlAccessorType(XmlAccessType.FIELD)
   public static class Parameter {
      private String   name;
      private String[] vals;

      public Parameter() {
      }

      public Parameter(String name, String[] vals) {
         this.setName(name);
         this.setVals(vals);
      }

      /**
       * @return the name
       */
      public String getName() {
         return name;
      }

      /**
       * @param name
       *           the name to set
       */
      public void setName(String name) {
         this.name = name;
      }

      /**
       * @return the vals
       */
      public String[] getVals() {
         return vals;
      }

      /**
       * @param vals
       *           the vals to set
       */
      public void setVals(String[] vals) {
         this.vals = vals;
      }
   }

   @XmlElement(name = "params")
   private Parameter[] params;

   public TckParameters() {
   }

   public TckParameters(Map<String, String[]> map) {
      List<Parameter> params = new ArrayList<Parameter>();
      for (String name : map.keySet()) {
         String[] vals = map.get(name);
         vals = (vals == null) ? null : vals.clone();
         params.add(new Parameter(name, vals));
      }
      this.params = params.toArray(new Parameter[0]);
   }

   /**
    * @return the params
    */
   public Parameter[] getParams() {
      return params;
   }

   /**
    * @param params
    *           the params to set
    */
   public void setParams(Parameter[] params) {
      this.params = params;
   }

}
