/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.services;

import java.util.Collection;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.portlet.PortletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.services.PortletPreferencesFactory;
import org.apache.commons.digester.Digester;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.xml.sax.SAXException;

/**
 * The Portal Driver's PortletPreferencesFactory implementation. This
 * implementation makes use of the filesystem for writing portlet preferences.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortletPreferencesProviderImpl
    implements PortletPreferencesFactory {
    private static final Log LOG =
        LogFactory.getLog(PortletPreferencesProviderImpl.class);

    private File storage = new File(System.getProperty("user.home")+File.separator+".pluto");

    public PortletPreferencesProviderImpl() {

    }

    public PortletPreference[] getStoredPreferences(PortletWindow window,
                                                    PortletRequest req)
    throws PortletContainerException {
        /* For testing purposes, we'll assume that all
           null users share prefs.
        if(req.getRemoteUser() == null) {
            return new PortletPreference[0];
        }
        */

        Digester dig = new Digester();
        dig.setClassLoader(getClass().getClassLoader());
        dig.addObjectCreate("portlet-preferences", ArrayList.class);
        dig.addObjectCreate("portlet-preferences/portlet-preference", PortletPreferenceImpl.class);
        dig.addBeanPropertySetter("portlet-preferences/portlet-preference/name");
        dig.addCallMethod("portlet-preferences/portlet-preference/value", "addValue", 0);

        File xmlFile = getFileFor(req, window);

        Collection col = null;
        try {
            if(xmlFile.exists()) {
                col = (Collection)dig.parse(xmlFile);
            }
            else {
                col = new ArrayList();
            }
        }
        catch(IOException io) {
            throw new PortletContainerException(io);
        }
        catch (SAXException e) {
            throw new PortletContainerException(e);
        }

        return (PortletPreference[])col.toArray(new PortletPreference[col.size()]);
    }

    public void store(PortletWindow window,
                      PortletRequest request,
                      PortletPreference[] preferences)
        throws PortletContainerException {
        /* For testing purposes, we'll assume that all
        null users share prefs.
        if(req.getRemoteUser() == null) {
        return;
        }
        */

        File file = getFileFor(request, window);
        try {
            FileWriter writer = new FileWriter(file);
            PrintWriter out = new PrintWriter(writer);

            if(LOG.isDebugEnabled()) {
                LOG.debug("Saving Preferences to file: "+file.getAbsolutePath());
            }
            out.println("<portlet-preferences>");
            for(int i=0;i<preferences.length;i++) {
                out.println("  <portlet-preference>");
                out.println("    <name>"+preferences[i].getName()+"</name>");
                String[] values = preferences[i].getValues();
                for(int j=0;j<values.length;j++) {
                    out.println("    <value>"+values[j]+"</value>");
                }
                out.println("  </portlet-preference>");
            }
            out.println("</portlet-preferences>");
            out.flush();
            out.close();
        }
        catch(IOException io) {
            throw new PortletContainerException(io);
        }
    }


    private File getFileFor(PortletRequest req, PortletWindow window) {

        String userId = req.getRemoteUser();

        StringBuffer windowDirectoryPath = new StringBuffer();
        String sep = File.separator;
        windowDirectoryPath.append(req.getServerName()).append(sep);
        windowDirectoryPath.append(req.getContextPath()).append(sep);
        windowDirectoryPath.append(window.getId().toString());

        File windowDir = new File(storage, windowDirectoryPath.toString());
        windowDir.mkdirs();

        return new File(windowDir, userId+".prefs");
    }


}

