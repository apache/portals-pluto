package org.apache.pluto.util.install.file.tomcat6;

import java.io.File;

import org.apache.pluto.util.install.InstallationConfig;
import org.apache.pluto.util.install.file.tomcat5.Tomcat5FileSystemInstaller;

public class Tomcat6FileSystemInstaller extends Tomcat5FileSystemInstaller
{

    public boolean isValidInstallationDirectory( File installDir )
    {
        // Tomcat 6 - by default - does away with the classloader
        // directories <tomcat>/server, <tomcat>/common, and <tomcat>/shared.  
        // Everything by default is installed under <tomcat>/lib.
        File libDir = new File( installDir, "lib" );
        File serverConf = new File( installDir, "conf/server.xml" );
        File catalinaProps = new File( installDir, "conf/catalina.properties" );
        
        return libDir.exists() && serverConf.exists() && catalinaProps.exists();
    }
    
    protected File getEndorsedDir( InstallationConfig config )
    {
        // Tomcat 6 uses <tomcat>/endorsed
        return new File( config.getInstallationDirectory(), "endorsed" );
    }

    protected File getSharedDir( InstallationConfig config )
    {
        // Tomcat 6, by default, uses <tomcat>/lib
        return new File( config.getInstallationDirectory(), "lib" );
    }

}
