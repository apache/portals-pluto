/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;

import org.apache.pluto.container.om.portlet.PortletDefinition;

/**
 * Portlet preferences service that should be implemented by the portal.
 * This is an optional container service.
 *
 */
public interface PortletPreferencesService {

    /**
     * Returns the default portlet preferences.
     * @param portletWindow  the portlet window.
     * @param request  the portlet request.
     * @return the default portlet preferences.
     * @throws PortletContainerException  if fail to get default preferences.
     */
    Map<String, PortletPreference> getDefaultPreferences(
            PortletWindow portletWindow,
            PortletRequest request)
            throws PortletContainerException;

    /**
     * Returns the stored portlet preferences.
     * @param portletWindow  the portlet window.
     * @param request  the portlet request.
     * @return the stored portlet preferences.
     * @throws PortletContainerException  if fail to get stored preferences.
     */
    Map<String, PortletPreference> getStoredPreferences(
            PortletWindow portletWindow,
            PortletRequest request)
            throws PortletContainerException;

    /**
     * Stores the portlet references to the persistent storage.
     * @param portletWindow  the portlet window.
     * @param request  the portlet request.
     * @param preferences  the portlet preferences to store.
     * @throws PortletContainerException  if fail to store preferences.
     */
    void store(PortletWindow portletWindow,
            PortletRequest request,
            Map<String, PortletPreference> preferences)
    throws PortletContainerException;

    /**
     * Returns the preferences validator instance for the given portlet
     * definition. If no preferences validator class is defined for the portlet
     * definition, null is returned. This method caches the validator instances
     * in the cache to ensure that only one validator instance is created per
     * portlet definition.
     * @param portletDefinition  the portlet definition.
     * @return the preferences validator if defined for the portlet definition.
     * @throw ValidatorException  if fail to instantiate validator instance.
     */
    PreferencesValidator getPreferencesValidator(PortletDefinition portletDefinition)
    throws ValidatorException;

}
