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

package org.apache.maven.tomcat;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.zip.ZipException;
import java.util.Properties;

public class TomcatServerInfo {

    private String home;

	public void setHome(String home) {
	    this.home = home;
	}

	public String getHome() {
		return home;
	}

	public String getMajorVersion()
    throws IOException, ZipException {
        String info = getServerInfo();
		int idx = info.indexOf("/");
		info = info.substring(idx+1,idx+2);
		return info;
	}

	public String getServerInfo()
    throws IOException, ZipException {
	    if(home==null)
            throw new NullPointerException("Tomcat home directory not specified");

        File file = new File(home);
		if(!file.isDirectory())
		    throw new IOException("Invalid home directory specified");

		file = new File(file, "server/lib/catalina.jar");

		JarFile jar = new JarFile(file);
		JarEntry info = jar.getJarEntry("org/apache/catalina/util/ServerInfo.properties");
		InputStream in = jar.getInputStream(info);
		
		Properties props = new Properties();
		props.load(in);

		return props.getProperty("server.info");
	}

}
