/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.deploy.impl;

import org.w3c.dom.Document;

import java.io.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

/**
 * Used to assemble a web application into a portlet application.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:heavyzheng@gmail.com">Zhong ZHENG</a>
 * @version 1.0
 * @since Oct 15, 2004
 */
public class ArchivedFileAssembler extends AbstractAssembler {

    private static final String SUFFIX = ".tmp";
    private static final int BUFFER_SIZE = 2048;

    private JarFile war;
    private File destination;

    private Map documents = new HashMap();
    private Map streams = new HashMap();


    public ArchivedFileAssembler(JarFile war, File destination) {
        this.war = war;
        this.destination = destination;
    }


    protected InputStream getWebResource(String name)
    throws IOException {
        JarEntry entry = war.getJarEntry(name);
        if(entry!=null) {
            return war.getInputStream(entry);
        }
        return null;
    }

    protected void setWebResource(String name, InputStream in)
    throws IOException {
        streams.put(name, in);
    }

    protected void setWebResource(String name, Document doc)
    throws IOException {
    	documents.put(name, doc);
    }


    protected void close() throws IOException  {

    	// ensure temporary directory.
        File tempDir = new File(destination + SUFFIX);
        long tempId = 0;
        while (tempDir.exists()) {
        	tempDir = new File(destination + SUFFIX + String.valueOf(tempId));
        	tempId++;
        }
        tempDir.mkdirs();

        // copy files from original WAR.
        for (Enumeration en = war.entries(); en.hasMoreElements(); ) {
            JarEntry entry = (JarEntry) en.nextElement();
            if (entry.isDirectory()) {
            	File dir = new File(tempDir, entry.getName());
            	dir.mkdirs();
            } else if (!documents.containsKey(entry.getName()) &&
            		!streams.containsKey(entry.getName())) {
                File destFile = new File(tempDir, entry.getName());
                destFile.getParentFile().mkdirs();
                FileOutputStream fout = new FileOutputStream(destFile);
            	InputStream is = war.getInputStream(entry);
            	save(is, fout);
            }
        }

        // copy updated files.
        for (Iterator it = documents.keySet().iterator(); it.hasNext(); ) {
            String name = it.next().toString();
            Document doc = (Document) documents.get(name);
            File destFile = new File(tempDir, name);
            destFile.getParentFile().mkdirs();
            OutputStream out = new FileOutputStream(destFile);
            save(doc, out);
        }

        for (Iterator it = streams.keySet().iterator(); it.hasNext(); ) {
            String name = it.next().toString();
            InputStream is = (InputStream) streams.get(name);
            File destFile = new File(tempDir, name);
            destFile.getParentFile().mkdirs();
            OutputStream out = new FileOutputStream(destFile);
            save(is, out);
        }

        // archive contents of the temporary directory to destination war.
        jar(tempDir, destination);
        deleteRecursive(tempDir);
    }

    /**
     * Archive the source directory to a WAR file.
     *
     * @param sourceDir  source directory to archive
     * @param warFile  destination WAR file
     * @throws IOException
     */
    private void jar(File sourceDir, File warFile)
    throws IOException {
    	if (warFile.exists()) {
    		deleteRecursive(warFile);
    	}
    	JarOutputStream jout = new JarOutputStream(new BufferedOutputStream(
    			new FileOutputStream(warFile)));
    	List fileList = listRecursive(sourceDir);
    	String[] fileNames = (String[]) fileList.toArray(
    			new String[fileList.size()]);

    	byte[] data = new byte[BUFFER_SIZE];
    	for (int i = 0; i < fileNames.length; i++) {
    		File sourceFile = new File(sourceDir, fileNames[i]);
    		if (sourceFile.isFile()) {
    			JarEntry entry = new JarEntry(fileNames[i]);
        		jout.putNextEntry(entry);
    			BufferedInputStream is = new BufferedInputStream(
    					new FileInputStream(sourceFile));
    			int count;
    			while ((count = is.read(data, 0, BUFFER_SIZE)) != -1) {
    				jout.write(data, 0, count);
    			}
    			is.close();
    		}
    	}
    	jout.close();
    }

    /**
     * List all files under the given directory recursively. This method's
     * behavior is different from <code>File.list()</list> in two aspects:
     * 1. All files are listed recursively; 2. sub directories are ignored.
     *
     * @param dir  directory whose files are to be listed
     * @return a list of String containing relative file paths to the directory
     */
    private List listRecursive(File dir) {
    	return listRecursive(dir, "");
    }


    private List listRecursive(File dir, String prefix) {
    	List fileNameList = new ArrayList();
    	String[] fileNames = dir.list();
    	for (int i = 0; i < fileNames.length; i++) {
    		File file = new File(dir, fileNames[i]);
    		if (file.isFile()) {
    			fileNameList.add(prefix + fileNames[i]);
    		} else {
    			String subDirName = file.getName();
    			List subList = listRecursive(file,
    					prefix + subDirName + File.separator);
    			fileNameList.addAll(subList);
    		}
    	}
    	return fileNameList;
    }

    /**
     * Delete file. If given file is a regular file, it is deleted. If it is
     * a directory, its all contents and itself are deleted recursively.
     *
     * @param file  file to delete
     */
    private void deleteRecursive(File file) {
    	if (file.isDirectory()) {
    		File[] files = file.listFiles();
    		for (int i = 0; i < files.length; i++) {
    			deleteRecursive(files[i]);
    		}
    	}
    	file.delete();
    }

}


