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

package org.apache.pluto.testsuite.impl;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

public class PreferencesValidatorImpl implements PreferencesValidator
{

    private static final Log LOG =
        LogFactory.getLog(PreferencesValidatorImpl.class);
	
    public PreferencesValidatorImpl()
    {
    }

    public void validate(PortletPreferences preferences)
        throws ValidatorException
    {
      Collection failedKeys = new ArrayList();
      Enumeration names = preferences.getNames();

      String[] defValues = {"no values"};
      // TODO: Determine why we use this - I seem to remember it's a
      // spec requirement, and fix it so that we don't have issues
      // anymore.  When enabled, all preferences fail in testsuite


      String[] values = null;
      String key = null;

      while (names.hasMoreElements())
      {
          key = names.nextElement().toString();
          values = preferences.getValues(key, defValues);

          if (values != null) // null values are allowed
          {
              for (int i=0; i<values.length;i++)
              {
                  if (values[i] != null) // null values are allowed
                  {
                      //validates that the preferences do not start or end with white space
                      if (!values[i].equalsIgnoreCase(values[i].trim()))
                      {
                    	  if (LOG.isDebugEnabled()) {
                    		  LOG.debug("Value has white space (validation fails): key=" + key + " value=" + values[i]);
                    	  }
                          failedKeys.add(key);
                          i=values.length;
                      }
                  }
              }
          }
      }

      if (!failedKeys.isEmpty())
      {
          throw new ValidatorException("One or more preferences do not comply with the validation criteria",failedKeys);
      }
    }
}
