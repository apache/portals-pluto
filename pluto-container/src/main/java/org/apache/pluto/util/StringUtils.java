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

package org.apache.pluto.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <CODE>StringUtils</CODE> hosts a couple of utility methods around
 * strings.
 */
public class StringUtils {


    /**
     * Replace all occurrences of a pattern within a string by a replacement
     * @param source  The string that should be searched
     * @param pattern The pattern that should be replaced
     * @param replace The replacement that should be inserted instead of the
     *                pattern
     * @return The updated source string
     */
    public static String replace(String source, String pattern, String replace) {
        if (source == null || source.length() == 0 ||
            pattern == null || pattern.length() == 0) {
            return source;
        }

        int k = source.indexOf(pattern);

        if (k == -1) {
            return source;
        }

        StringBuffer out = new StringBuffer();
        int i = 0, l = pattern.length();

        while (k != -1) {
            out.append(source.substring(i, k));

            if (replace != null) {
                out.append(replace);
            }

            i = k + l;
            k = source.indexOf(pattern, i);
        }
        out.append(source.substring(i));
        return out.toString();
    }

    public static String[] copy(String[] source) {
        if (source == null) {
            return null;
        }
        int length = source.length;
        String[] result = new String[length];
        System.arraycopy(source, 0, result, 0, length);
        return result;
    }

    public static Map copyParameters(Map parameters) {
        Map result = new HashMap(parameters);
        for (Iterator iter = result.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException(
                    "Parameter map keys must not be null and of type java.lang.String.");
            }
            try {
                entry.setValue(copy((String[]) entry.getValue()));
            } catch (ClassCastException ex) {
                throw new IllegalArgumentException(
                    "Parameter map values must not be null and of type java.lang.String[].");
            }
        }
        return result;
    }

    public static String stringCharacterEncoding(String mimeType) {
        int xs = mimeType.indexOf(';');
        String strippedType;
        if (xs == -1) {
            strippedType = mimeType;
        } else {
            strippedType = mimeType.substring(0,xs);
        }
        return strippedType.trim();
    }

}
