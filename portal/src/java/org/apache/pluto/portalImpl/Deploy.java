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

package org.apache.pluto.portalImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.pluto.om.common.DescriptionSet;
import org.apache.pluto.om.common.DisplayNameSet;
import org.apache.pluto.om.common.Parameter;
import org.apache.pluto.om.common.ParameterCtrl;
import org.apache.pluto.om.common.ParameterSet;
import org.apache.pluto.om.common.ParameterSetCtrl;
import org.apache.pluto.om.common.SecurityRoleRef;
import org.apache.pluto.om.common.SecurityRoleRefSet;
import org.apache.pluto.om.common.SecurityRoleRefSetCtrl;
import org.apache.pluto.om.common.SecurityRoleSet;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.servlet.ServletDefinition;
import org.apache.pluto.om.servlet.ServletDefinitionCtrl;
import org.apache.pluto.om.servlet.ServletDefinitionListCtrl;
import org.apache.pluto.portalImpl.om.common.impl.DescriptionImpl;
import org.apache.pluto.portalImpl.om.common.impl.DescriptionSetImpl;
import org.apache.pluto.portalImpl.om.common.impl.DisplayNameImpl;
import org.apache.pluto.portalImpl.om.common.impl.DisplayNameSetImpl;
import org.apache.pluto.portalImpl.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.portalImpl.om.servlet.impl.ServletMappingImpl;
import org.apache.pluto.portalImpl.om.servlet.impl.ServletDefinitionImpl;
import org.apache.pluto.portalImpl.om.servlet.impl.WebApplicationDefinitionImpl;
import org.apache.pluto.portalImpl.xml.Constants;
import org.apache.pluto.portalImpl.xml.XmlParser;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

public class Deploy {

    private static boolean debug = false;
    private static String dirDelim = System.getProperty("file.separator");
    private static String webInfDir = dirDelim + "WEB-INF" + dirDelim;
    private static String webAppsDir;
    private static String portalImplWebDir;
    private static String plutoHome;

    public static void deployArchive(String webAppsDir, String warFile)
        throws IOException {
        String warFileName = warFile;
        if (warFileName.indexOf("/") != -1)
            warFileName =
                warFileName.substring(warFileName.lastIndexOf("/") + 1);
        if (warFileName.indexOf(dirDelim) != -1)
            warFileName =
                warFileName.substring(warFileName.lastIndexOf(dirDelim) + 1);
        if (warFileName.endsWith(".war"))
            warFileName =
                warFileName.substring(0, warFileName.lastIndexOf("."));

        System.out.println("deploying '" + warFileName + "' ...");

        String destination = webAppsDir + warFileName;

        JarFile jarFile = new JarFile(warFile);
        Enumeration files = jarFile.entries();
        while (files.hasMoreElements()) {
            JarEntry entry = (JarEntry) files.nextElement();

            File file = new File(destination, entry.getName());
            File dirF = new File(file.getParent());
            dirF.mkdirs();
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                byte[] buffer = new byte[1024];
                int length = 0;
                InputStream fis = jarFile.getInputStream(entry);
                FileOutputStream fos = new FileOutputStream(file);
                while ((length = fis.read(buffer)) >= 0) {
                    fos.write(buffer, 0, length);
                }
                fos.close();
            }

        }

        System.out.println("finished!");
    }

    public static void prepareWebArchive(String webAppsDir, String warFile)
        throws Exception, IOException {
        String webModule = warFile;
        if (webModule.indexOf("/") != -1)
            webModule = webModule.substring(webModule.lastIndexOf("/") + 1);
        if (webModule.indexOf(dirDelim) != -1)
            webModule =
                webModule.substring(webModule.lastIndexOf(dirDelim) + 1);
        if (webModule.endsWith(".war"))
            webModule = webModule.substring(0, webModule.lastIndexOf("."));

        System.out.println("prepare web archive '" + webModule + "' ...");

        Mapping mappingPortletXml = null;
        Mapping mappingWebXml = null;

        // get portlet xml mapping file
        String _portlet_mapping =
            webAppsDir + portalImplWebDir + "WEB-INF" + dirDelim + "data" + dirDelim + "xml" +dirDelim + "portletdefinitionmapping.xml";
        mappingPortletXml = new Mapping();
        try {
            mappingPortletXml.loadMapping(_portlet_mapping);
        } catch (Exception e) {
            System.out.println("CASTOR-Exception: " + e);
            throw new IOException(
                "Failed to load mapping file " + _portlet_mapping);
        }

        File portletXml =
            new File(webAppsDir + webModule + webInfDir + "portlet.xml");

        // get web xml mapping file
        String _web_mapping =
            webAppsDir
                + portalImplWebDir
                + "WEB-INF" + dirDelim + "data" + dirDelim + "xml" + dirDelim + "servletdefinitionmapping.xml";
        mappingWebXml = new Mapping();
        try {
            mappingWebXml.loadMapping(_web_mapping);
        } catch (Exception e) {
            throw new IOException(
                "Failed to load mapping file " + _web_mapping);
        }

        File webXml = new File(webAppsDir + webModule + webInfDir + "web.xml");

        try {
            org.w3c.dom.Document portletDocument =
                XmlParser.parsePortletXml(new FileInputStream(portletXml));

            Unmarshaller unmarshaller = new Unmarshaller(mappingPortletXml);
            PortletApplicationDefinitionImpl portletApp =
                (PortletApplicationDefinitionImpl) unmarshaller.unmarshal(
                    portletDocument);

            // refill structure with necessary information
            Vector structure = new Vector();
            structure.add(webModule);
            structure.add(null);
            structure.add(null);
            portletApp.preBuild(structure);

            if (debug) {
                System.out.println(portletApp);
            }

            // now generate web part

            WebApplicationDefinitionImpl webApp = null;

            if (webXml.exists()) {
                org.w3c.dom.Document webDocument =
                    XmlParser.parseWebXml(new FileInputStream(webXml));

                Unmarshaller unmarshallerWeb = new Unmarshaller(mappingWebXml);
                webApp =
                    (WebApplicationDefinitionImpl) unmarshallerWeb.unmarshal(
                        webDocument);
            } else {
                webApp = new WebApplicationDefinitionImpl();
                DisplayNameImpl dispName = new DisplayNameImpl();
                dispName.setDisplayName(webModule);
                dispName.setLocale(Locale.ENGLISH);
                DisplayNameSetImpl dispSet = new DisplayNameSetImpl();
                dispSet.add(dispName);
                webApp.setDisplayNames((DisplayNameSet) dispSet);
                DescriptionImpl desc = new DescriptionImpl();
                desc.setDescription("Automated generated Application Wrapper");
                desc.setLocale(Locale.ENGLISH);
                DescriptionSetImpl descSet = new DescriptionSetImpl();
                descSet.add(desc);
                webApp.setDescriptions((DescriptionSet) descSet);
            }

            org.apache.pluto.om.ControllerFactory controllerFactory =
                new org.apache.pluto.portalImpl.om.ControllerFactoryImpl();

            ServletDefinitionListCtrl servletDefinitionSetCtrl =
                (ServletDefinitionListCtrl) controllerFactory.get(
                    webApp.getServletDefinitionList());
            Collection servletMappings = webApp.getServletMappings();

            Iterator portlets =
                portletApp.getPortletDefinitionList().iterator();
            while (portlets.hasNext()) {

                PortletDefinition portlet = (PortletDefinition) portlets.next();

                // check if already exists
                ServletDefinition servlet =
                    webApp.getServletDefinitionList().get(portlet.getName());
                if (servlet != null) {
                    if (!servlet
                        .getServletClass()
                        .equals("org.apache.pluto.core.PortletServlet")) {
                        System.out.println(
                            "Note: Replaced already existing the servlet with the name '"
                                + portlet.getName()
                                + "' with the wrapper servlet.");
                    }
                    ServletDefinitionCtrl _servletCtrl =
                        (ServletDefinitionCtrl) controllerFactory.get(servlet);
                    _servletCtrl.setServletClass(
                        "org.apache.pluto.core.PortletServlet");
                } else {
                    servlet =
                        servletDefinitionSetCtrl.add(
                            portlet.getName(),
                            "org.apache.pluto.core.PortletServlet");
                }

                ServletDefinitionCtrl servletCtrl =
                    (ServletDefinitionCtrl) controllerFactory.get(servlet);

                DisplayNameImpl dispName = new DisplayNameImpl();
                dispName.setDisplayName(portlet.getName() + " Wrapper");
                dispName.setLocale(Locale.ENGLISH);
                DisplayNameSetImpl dispSet = new DisplayNameSetImpl();
                dispSet.add(dispName);
                servletCtrl.setDisplayNames((DisplayNameSet) dispSet);
                DescriptionImpl desc = new DescriptionImpl();
                desc.setDescription("Automated generated Portlet Wrapper");
                desc.setLocale(Locale.ENGLISH);
                DescriptionSetImpl descSet = new DescriptionSetImpl();
                descSet.add(desc);
                servletCtrl.setDescriptions(descSet);
                ParameterSet parameters = servlet.getInitParameterSet();

                ParameterSetCtrl parameterSetCtrl =
                    (ParameterSetCtrl) controllerFactory.get(parameters);

                Parameter parameter1 = parameters.get("portlet-class");
                if (parameter1 == null) {
                    parameterSetCtrl.add(
                        "portlet-class",
                        portlet.getClassName());
                } else {
                    ParameterCtrl parameterCtrl =
                        (ParameterCtrl) controllerFactory.get(parameter1);
                    parameterCtrl.setValue(portlet.getClassName());

                }
                Parameter parameter2 = parameters.get("portlet-guid");
                if (parameter2 == null) {
                    parameterSetCtrl.add(
                        "portlet-guid",
                        portlet.getId().toString());
                } else {
                    ParameterCtrl parameterCtrl =
                        (ParameterCtrl) controllerFactory.get(parameter2);
                    parameterCtrl.setValue(portlet.getId().toString());

                }

                boolean found = false;
                Iterator mappings = servletMappings.iterator();
                while (mappings.hasNext()) {
                    ServletMappingImpl servletMapping =
                        (ServletMappingImpl) mappings.next();
                    if (servletMapping
                        .getServletName()
                        .equals(portlet.getName())) {
                        found = true;
                        servletMapping.setUrlPattern(
                            "/" + portlet.getName().replace(' ', '_') + "/*");
                    }
                }
                if (!found) {
                    ServletMappingImpl servletMapping =
                        new ServletMappingImpl();
                    servletMapping.setServletName(portlet.getName());
                    servletMapping.setUrlPattern(
                        "/" + portlet.getName().replace(' ', '_') + "/*");
                    servletMappings.add(servletMapping);
                }

                SecurityRoleRefSet servletSecurityRoleRefs =
                    ((ServletDefinitionImpl)servlet).getInitSecurityRoleRefSet();

                SecurityRoleRefSetCtrl servletSecurityRoleRefSetCtrl =
                    (SecurityRoleRefSetCtrl) controllerFactory.get(
                        servletSecurityRoleRefs);

                SecurityRoleSet webAppSecurityRoles = webApp.getSecurityRoles();
                    
                SecurityRoleRefSet portletSecurityRoleRefs =
                    portlet.getInitSecurityRoleRefSet();

                SecurityRoleRefSetCtrl portletSecurityRoleRefSetCtrl =
                    (SecurityRoleRefSetCtrl) controllerFactory.get(
                        portletSecurityRoleRefs);

                Iterator p = portletSecurityRoleRefs.iterator();

                while (p.hasNext()) {
                    SecurityRoleRef portletSecurityRoleRef =
                        (SecurityRoleRef) p.next();
                    
                    if (	portletSecurityRoleRef.getRoleLink()== null
                        &&		
                            webAppSecurityRoles.get(portletSecurityRoleRef.getRoleName())==null
                    ){
                        System.out.println(
                            "Note: The web application has no security role defined which matches the role name \""
                                + portletSecurityRoleRef.getRoleName()
                                + "\" of the security-role-ref element defined for the wrapper-servlet with the name '"
                                + portlet.getName()
                                + "'.");
                        break;						
                    }
                    SecurityRoleRef servletSecurityRoleRef =
                        servletSecurityRoleRefs.get(
                            portletSecurityRoleRef.getRoleName());
                    if (null != servletSecurityRoleRef) {
                        System.out.println(
                            "Note: Replaced already existing element of type <security-role-ref> with value \""
                                + portletSecurityRoleRef.getRoleName()
                                + "\" for subelement of type <role-name> for the wrapper-servlet with the name '"
                                + portlet.getName()
                                + "'.");
                        servletSecurityRoleRefSetCtrl.remove(
                            servletSecurityRoleRef);
                    }
                    servletSecurityRoleRefSetCtrl.add(portletSecurityRoleRef);
                }

            }

            if (debug) {
                System.out.println(webApp);
            }

            OutputFormat of = new OutputFormat();
            of.setIndenting(true);
            of.setIndent(4); // 2-space indention
            of.setLineWidth(16384);
            // As large as needed to prevent linebreaks in text nodes
            of.setDoctype(
                Constants.WEB_PORTLET_PUBLIC_ID,
                Constants.WEB_PORTLET_DTD);

            FileWriter writer =
                new FileWriter(webAppsDir + webModule + 
                                               System.getProperty("file.separator") + "WEB-INF"+
                                               System.getProperty("file.separator") + "web.xml");
            XMLSerializer serializer = new XMLSerializer(writer, of);
            try {
            Marshaller marshaller =
                new Marshaller(serializer.asDocumentHandler());
            marshaller.setMapping(mappingWebXml);
            marshaller.marshal(webApp);
            } catch (Exception e) {
                writer.close();
                e.printStackTrace(System.out);
                throw new Exception();
            }
            String strTo = dirDelim + "WEB-INF" + dirDelim + "tld" + dirDelim + "portlet.tld";
            String strFrom = plutoHome + "portal" + dirDelim + "src" + 
                dirDelim + "webapp" + strTo;
             
            copy(strFrom, webAppsDir + webModule + strTo);
        } catch (Exception e) {
       
            e.printStackTrace(System.out);
            throw new Exception();
        }

        System.out.println("finished!");
    }

    public static void copy(String from, String to) throws IOException {
        File f = new File(to);
        f.getParentFile().mkdirs();
        
        byte[] buffer = new byte[1024];
        int length = 0;
        InputStream fis = new FileInputStream(from);
        FileOutputStream fos = new FileOutputStream(f);
        
        while ((length = fis.read(buffer)) >= 0) {
            fos.write(buffer, 0, length);
        }
        fos.close();
    }

    public static void main(String args[]) {
        String warFile;


        if (args.length < 4) {
            System.out.println(
                "No argument specified. This command hast to be issued as:");
            System.out.println(
                "deploy <TOMCAT-webapps-directory> <TOMCAT-pluto-webmodule-name> <web-archive> <pluto-home-dir> [-debug] [-addToEntityReg <app-id> [<portlet-id>:<portlet-name>]+]");
            return;
        }

        if (args.length > 4) {
            if ((args[4].equals("-debug")) || (args[4].equals("/debug"))) {
                debug = true;
            }
        }

        if(debug) {
            for(int i=0; i<args.length;i++) {
                System.out.println( "args["+ i +"]:" + args[i]);				
            }
        }
        
        webAppsDir = args[0];
        if (!webAppsDir.endsWith(dirDelim))
            webAppsDir += dirDelim;

        portalImplWebDir = args[1];
        if (!portalImplWebDir.endsWith(dirDelim))
            portalImplWebDir += dirDelim;

        warFile = args[2];

        plutoHome = args[3];
        if (!plutoHome.endsWith(dirDelim))
            plutoHome += dirDelim;

        if (args.length > 4) {
            if ((args[4].equals("-debug")) || (args[4].equals("/debug"))) {
                debug = true;
            }
            if (
                  (args[4].equals("-addToEntityReg"))
               || (  (args.length>5)
                  && (args[5].equals("-addToEntityReg"))
                  )
            ) {
                // parameters: app-id   portlet application id; must be unique in portletentityregistry.xml
                //             portlet-id   portlet id; must be unique inside the portlet application
                //             portlet-name the name of the portlet in portlet.xml   
                addToEntityReg(args);
            }
        }

        try {
            deployArchive(webAppsDir, warFile);

            prepareWebArchive(webAppsDir, warFile);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    static private void addToEntityReg(String[] args) {
        String pluto = args[1];
        File portletAppFile = new File(args[2]);
        String portletAppFileName = portletAppFile.getName();
        String portletApp =
            portletAppFileName.substring(0,	portletAppFileName.lastIndexOf(".war"));
        int o = (args[4].equals("-addToEntityReg") ? 5 : 6);
        String appId = args[o++];
        try {
            String entityMapping = webAppsDir + portalImplWebDir
  					               + "WEB-INF/data/portletentityregistry.xml";
            File file = new File(entityMapping);
            RandomAccessFile ras = new RandomAccessFile(file, "rw");
            long length = ras.length();
            byte[] contentByte = new byte[(int) length];
            ras.read(contentByte);
            String contentString = new String(contentByte);
            long pos = contentString.lastIndexOf("</portlet-entity-registry>");
            ras.seek(pos);
            ras.writeBytes("    <application id=\"" + appId + "\">\r\n");
            ras.writeBytes("        <definition-id>" + portletApp + "</definition-id>\r\n");

            StringTokenizer tokenizer;
            for (int i = o; i < args.length; ++i) {
                tokenizer = new StringTokenizer(args[i], ":");
                String portletId = tokenizer.nextToken();
                String portletName = tokenizer.nextToken();
                ras.writeBytes("        <portlet id=\"" + portletId + "\">\r\n");
                ras.writeBytes("            <definition-id>" + portletApp
                               + "." + portletName + "</definition-id>\r\n");
                ras.writeBytes("        </portlet>\r\n");
            }
            ras.writeBytes("    </application>\r\n");
            ras.writeBytes("</portlet-entity-registry>\r\n");
            ras.close();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
