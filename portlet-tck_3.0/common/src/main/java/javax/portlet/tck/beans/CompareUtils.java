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

import java.text.Format;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Map;


/** Contains some useful comparison methods 
 * 
 * @author nick
 */
public class CompareUtils {

   /**
    * Compares two strings and sets the test result accordingly. 
    * If both strings are null, comparison is successful.
    * 
    * @param a    1st string to compare
    * @param b    2nd string to compare
    * @param tr   test result to be updated
    */
   static public void stringsEqual(String a, String b, TestResult tr) {
      boolean ok = (a==null) && (b == null);
      if (!ok) {
         if ((a != null) && (b != null)) {
            ok = a.equals(b);
         }
         if (!ok) {
            String str = "Error: " + a + " does not equal " + b + ".";
            tr.appendTcDetail(str);
         }
      }
      tr.setTcSuccess(ok);
   }

   /**
    * Compares two Enumerations and sets the test result accordingly. 
    * If both strings are empty, comparison is successful.
    * 
    * @param aname   Name of 1st Enumeration to compare
    * @param a       1st Enumeration to compare
    * @param bname   Name of 2nd Enumeration to compare
    * @param b       2nd Enumeration to compare
    * @param tr      test result to be updated
    */
   @SuppressWarnings({ "rawtypes", "unchecked" })
   static public void enumsEqual(String aname, Enumeration<? extends Object> a, String bname, Enumeration<? extends Object> b, TestResult tr) {

      HashSet ha = new HashSet();
      while (a.hasMoreElements()) {
         ha.add(a.nextElement());
      }
      HashSet hb = new HashSet();
      while (b.hasMoreElements()) {
         hb.add(b.nextElement());
      }

      boolean ok = ha.equals(hb);
      // if not OK, write debug output:
      if (!ok) {
         StringBuffer sb = new StringBuffer(256);
         Formatter fmtr = new Formatter(sb);
         String str = "<br/>In %1$s but not in %2$s: <br/>\n";
         fmtr.format(str, aname, bname);
         HashSet diffs = (HashSet) ha.clone();
         diffs.removeAll(hb);
         for (Object diff : diffs) {
            sb.append(diff.toString() + "<br/>\n");
         }
         fmtr.format(str, bname, aname);
         diffs = (HashSet) hb.clone();
         diffs.removeAll(ha);
         for (Object diff : diffs) {
            sb.append(diff.toString() + "<br/>\n");
         }
         fmtr.close();
         tr.appendTcDetail(sb.toString());
      }
      tr.setTcSuccess(ok);
   }

   /**
    * Compares two Map<String, String[]>s and sets the test result accordingly. 
    * If both strings are empty, comparison is successful.
    * 
    * @param aname   Name of 1st Map<String, String[]> to compare
    * @param a       1st Map<String, String[]> to compare
    * @param bname   Name of 2nd Map<String, String[]> to compare
    * @param b       2nd Map<String, String[]> to compare
    * @param tr      test result to be updated
    */
   @SuppressWarnings({ "rawtypes", "unchecked" })
   static public void mapsEqual(String aname, Map<String, String[]> a, String bname, Map<String, String[]> b, TestResult tr) {

      boolean ok = a.equals(b);     // compares the mappings
      // if not OK, write debug output:
      if (!ok) {
         StringBuffer sb = new StringBuffer(256);
         Formatter fmtr = new Formatter(sb);
         String str = "<br/>In %1$s but not in %2$s: <br/>\n";
         fmtr.format(str, aname, bname);
         HashSet diffs = new HashSet();
         diffs.addAll(a.keySet());
         diffs.removeAll(b.keySet());
         for (Object key : diffs) {
            sb.append((String)key + "<br/>\n");
         }
         fmtr.format(str, bname, aname);
         diffs.clear();
         diffs.addAll(b.keySet());
         diffs.removeAll(a.keySet());
         for (Object key : diffs) {
            sb.append((String)key + "<br/>\n");
         }
         fmtr.close();
         tr.appendTcDetail(sb.toString());
      }
      tr.setTcSuccess(ok);
   }
}
