/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.validator;

import java.util.ArrayList;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;
import javax.portlet.tck.portlets.EnvironmentTests_PortletPreferences_ApiAction;
import javax.portlet.tck.portlets.EnvironmentTests_PortletPreferences_ApiEvent_event;
import javax.portlet.tck.portlets.EnvironmentTests_PortletPreferences_ApiResource;

/**
 * Validator for JSR 362 portlet preferences testing.
 *
 * @author ahmed
 *
 */
public class V2EnvironmentTests_PortletPreferences_Validator
    implements PreferencesValidator {

  @Override
  public void validate(PortletPreferences preferences) throws ValidatorException {

    EnvironmentTests_PortletPreferences_ApiAction.tr32_success = true;
    EnvironmentTests_PortletPreferences_ApiEvent_event.tr32_success = true;
    EnvironmentTests_PortletPreferences_ApiResource.tr32_success = true;
    
    if (preferences.getValue("tr33", "true").equals("false")) {
      ArrayList<String> al = new ArrayList<String>();
      al.add("tr33");
      al.add("tr34");
      throw new ValidatorException("ValidatorException for tr33 and tr34", al);
    }
  }

}
