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

package org.apache.pluto.driver.deploy;

import java.io.File;
import java.util.ArrayList;

import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.services.impl.FilePortletAppDescriptorServiceImpl;
import org.apache.pluto.descriptors.services.impl.FileWebAppDescriptorServiceImpl;
import org.apache.pluto.driver.deploy.impl.PortletEntityRegistryRegistrarService;
import org.apache.pluto.driver.deploy.impl.ContextRegistryRegistrarService;

public class CLI {

    /**
     * Private Constructor used to prevent instantiation.
     */
    private CLI() {

    }

    /**
     * Command Line Interface for the Pluto Deploy tool.
     * <pre>
  Usage: deploy [options] [<portlet-webapp-dir> | <portlet-war-file>]"
  Options:
    -destination, -d       destination to which the app should be deployed
    -portal, -p            specify the portal location
    -version,              print versioning information
    -verbose, -v           be extra verbose
    -help, -h              print this messagae</pre>
  Possible Future Options
    -regsitrar, -r         class name of the registrar which should be used
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        CLIArgs cli = parseArgs(args);
        // cli will be null if the -version or -help flags
        // have been turned on.
        if(cli!=null) {
            Deploy deploy = createDeployer(cli);
            deploy.deploy(cli.portletApplication);
        }
    }

    /**
     * Create a deployer from the parsed arguments.
     * @param args CLIArgs parsed from the command line.
     * @return an instance of the Deployer.
     */
    private static Deploy createDeployer(CLIArgs args) {
        ArrayList registrars = new ArrayList();
        PortletApplicationExploder exploder = null;
        WebAppDescriptorService webAppDescriptorService = null;
        PortletAppDescriptorService portletAppDescriptorService = null;

        args.destinationDirectory.mkdirs();
        if(!args.portletApplication.isDirectory()) {
            exploder = new PortletApplicationExploder(args.destinationDirectory);
        }

        if(args.portalApplication!=null) {
            registrars.add(new PortletEntityRegistryRegistrarService(args.portalApplication));
            registrars.add(new ContextRegistryRegistrarService(args.portalApplication));
        }
        if(args.debug) {
            System.out.println("<VERBOSE> Portal WebApp: "+ args.portalApplication.getAbsolutePath());
        }


        int extLocation = args.portletApplication.getName().indexOf(".");
        if(extLocation > 0) {
            args.destinationDirectory = new File(args.destinationDirectory, args.portletApplication.getName().substring(0, extLocation));
        }
        else {
            args.destinationDirectory = new File(args.destinationDirectory, args.portletApplication.getName());
        }

        if(args.debug) {
            System.out.println("<VERBOSE> Portlet Context: "+ args.destinationDirectory.getAbsolutePath());
        }

        webAppDescriptorService = new FileWebAppDescriptorServiceImpl(args.destinationDirectory);
        portletAppDescriptorService = new FilePortletAppDescriptorServiceImpl(args.destinationDirectory);

        Deploy deploy = new Deploy(webAppDescriptorService, portletAppDescriptorService);
        deploy.setDebug(args.debug);
        deploy.setExploder(exploder);
        deploy.setRegistrars(registrars);
        return deploy;
    }

    /**
     * Parse the command line arguments into the appropriate
     * File objects.
     * @param args
     * @return
     */
    private static CLIArgs parseArgs(String[] args) {
        CLIArgs result = new CLIArgs();

        for (int i=0;i<args.length;i++) {
            String arg = args[i];

            if("-help".equals(arg) || "-h".equals(arg)) {
                printUsage();
                return null;
            }
            else if("-version".equals(arg)) {
                printVersion();
                return null;
            }
            else if("-verbose".equals(arg) || "-v".equals(arg)) {
                result.debug = true;
            }
            else if("-portal".equals(arg) || "-p".equals(arg)) {
                try {
                    result.portalApplication = new File(args[++i]);
                    if(!result.portalApplication.exists()) {
                        throw new IllegalArgumentException(
                            "'"+result.portalApplication.getAbsolutePath()+
                            "' is not a valid portal path"
                        );
                    }
                }
                catch(ArrayIndexOutOfBoundsException ai) {
                    throw new IllegalArgumentException(
                        "-portal must be followed by the location of the portal"
                    );
                }
            }
            else if("-destination".equals(arg) || "-d".equals(arg)) {
                result.destinationDirectory = new File(args[++i]);
            }
            else if (arg.startsWith("-")) {
                throw new IllegalArgumentException("Illegal Option: "+arg);
            }
            else {
                result.portletApplication = new File(args[i]);
            }
        }

        if(result.portletApplication == null) {
            throw new IllegalArgumentException(
                "Portlet Application must be specified"
            );
        }

        if(result.debug) {
            System.out.println("<VERBOSE> Source WebApp: "+ result.portletApplication.getAbsolutePath());
        }

        if(result.destinationDirectory == null) {
            result.destinationDirectory = result.portletApplication.getParentFile();
        }

        if(result.debug) {
            System.out.println("<VERBOSE> Destination:   "+ result.destinationDirectory.getAbsolutePath());
        }
        return result;
    }

    /**
     * Print command usage information.
     */
    private static void printUsage() {
        String sep = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer(sep);
        sb.append("deploy [options] [<portlet-webapp-dir> | <portlet-war-file>]"+sep);
        sb.append("Options: "+sep);
        sb.append("  -destination, -d       destination to which the app should be deployed"+sep);
        sb.append("  -portal, -p            specify the portal location"+sep);
        sb.append("  -version,              print versioning information"+sep);
        sb.append("  -verbose, -v           be extra verbose"+sep);
        sb.append("  -help, -h              print this messagae"+sep);
        sb.append("Future Options: "+sep);
        sb.append("  -registrar, -r         the class name of the registrar used to register the portlets with the portal"+sep);
        System.out.println(sb);
    }

    /**
     * Print version informaiton.
     */
    private static void printVersion() {
        System.out.println("Apache Pluto Deploy / 1.0");
    }

    /**
     * Parged and converted Command Line arguments.
     */
    static class CLIArgs {
        private File portletApplication;
        private File portalApplication;
        private File destinationDirectory;
        private boolean debug;
    }

}
