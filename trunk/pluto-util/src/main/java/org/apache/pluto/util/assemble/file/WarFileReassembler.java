package org.apache.pluto.util.assemble.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.services.castor.PortletAppDescriptorServiceImpl;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.assemble.ReassemblerConfig;
import org.apache.pluto.util.assemble.WarReassembler;

/**
 * This implementation of <code>WarReassemler</code> rebuilds an existing war 
 * file with an updated web.xml file so it can be deployed to Pluto.
 * 
 * This file would be called after an <code>FileUploader</code> has uploaded
 * a file to a directory that is the argument for the reassemble() method.
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class WarFileReassembler extends FileAssembler implements WarReassembler {
	private static final Log LOG = LogFactory.getLog(WarFileReassembler.class);
	private static final int BUFFER = 256;
	
	/**
	 *  Does the reassembly by decompressing the war, assembling the new web.xml file, 
	 *  and rebuilding the war.
	 *   
	 * @see org.apache.pluto.driver.services.portal.admin.services.ReassembleWarAdminService#reassemble(java.lang.String)
	 */
	public File reassemble(ReassemblerConfig config) throws UtilityException {
		List portlets = null;
		ReassemblerConfig config2 = null;
		File newWar = null;
		try {
			//first, unzip war, returning a new config with file list and unassembly dir added
			config2 = decompressWar(config);
			//second, update web.xml using Assembler, checking for portlet.xml and web.xml before it does so
			// returning a list of portlets from portlet.xml
			portlets = updateWebXml(config2);
			//third, create new war
			newWar = createNewWar(config2);
		} finally {
			//cleanup
//			File dir = config2.getUnassemblyDir();
//			if (dir != null && dir.exists()) {
//				LOG.debug("Deleting dir: " + dir);
//				try {
//					FileUtils.forceDelete(dir);
//				} catch (IOException e) {
//					String msg = "Problem deleting unzipped directory structure";
//					UtilityException ue = new UtilityException(msg);
//			    	ue.initCause(e);
//			    	throw ue;
//				}							
//			}
		}
		return newWar;
	}
	
	/**
	 * Unzips a war file into the file system into a directory that
	 * the parent directory plus a subdirectory that is the same
	 * name as the file name (without its extension).
	 *  
	 * @param config Holds the path to the file to decompress.
	 * @return
	 */
	ReassemblerConfig decompressWar(ReassemblerConfig config) throws UtilityException {
//		ReassemblerConfig retConfig = config;
		ArrayList fileList = new ArrayList();
        BufferedInputStream is = null;
        FileOutputStream fos = null;
        ZipFile zipFile = null;
		try
	     {
	       // Specify file to decompress
		   File warFile = config.getWarFilePath();

	       //get the unzipping directory
	       File fUnzipDirectory = config.getUnassemblyDir();
	       //create the directory if necessary
	       if (!fUnzipDirectory.exists()) {
	    	   fUnzipDirectory.mkdir();
	       }

	       if (LOG.isDebugEnabled()) {
		       LOG.debug("Directory to unzip war for manipulating the web.xml : " + fUnzipDirectory.getAbsolutePath());	    	   
	       }
	       
	       // Open Zip file for reading
	       zipFile = new ZipFile(warFile, ZipFile.OPEN_READ);

	       // Create an enumeration of the entries in the zip file
	       Enumeration zipFileEntries = zipFile.entries();

	       // Process each entry
	       while (zipFileEntries.hasMoreElements())
	       {
	         //grab a war file entry
	         ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();

	         String currentEntry = entry.getName();
	         fileList.add(currentEntry);	        	 
//	         System.out.println("Extracting: " + entry);

	         //Create a file representing the destination of the unwared file
	         File destDir =
	           new File(fUnzipDirectory, currentEntry);

	         //grab file's parent directory structure
	         File destinationParent = destDir.getParentFile();

	         //create the parent directory structure if needed
	         destinationParent.mkdirs();

	         //extract file from war if not a directory
	         if (!entry.isDirectory())
	         {
//	        	 LOG.debug("Zip entry: " + entry.getName());
	           is = new BufferedInputStream(zipFile.getInputStream(entry));
	           // establish buffer for writing file into new location
	           byte data[] = new byte[BUFFER];

	           // read and write the current file to disk
	           fos = new FileOutputStream(destDir);
	           //read and write the file to disk until last byte is encountered
	           synchronized (is) {
		           synchronized (fos) {
			           while (true){
			        	 int bytesRead =  is.read(data);
			        	 if (bytesRead == -1) {
			        		 break;
			        	 }
			             fos.write(data, 0, bytesRead);
			           }
		           }
	           }
	         }
	       }
	     }
	     catch (IOException e) {
	    	 String msg = "Problem decompressing war";
	    	 LOG.error(msg, e);
	    	 UtilityException ue = new UtilityException(msg);
	    	 ue.initCause(e);
	 		throw ue;
	     } finally {
	    	 if (zipFile != null) {
	    		 try {
					zipFile.close();
				} catch (IOException e) {
					LOG.warn("Problem closing zip file output stream in decompressWar()", e);
				}
	    	 }
	    	 if (fos != null) {
	    		 try {
					fos.flush();
					fos.close();
				} catch (IOException e) {
					LOG.warn("Problem flushing/closing file output stream in decompressWar()", e);
				}
	    	 }
	    	 if (is != null) {
		           try {
					is.close();
				} catch (IOException e) {
					LOG.warn("Problem closing input stream in decompressWar()", e);
				}	    		 
	    	 }
	     }
	     config.setFileList((String[])fileList.toArray(new String[fileList.size()]));
	     return config;
	   }		

		/**
		 * Uses the <code>assemble()</code> method to update the web.xml file.
		 *
		 */
		List updateWebXml(ReassemblerConfig rconfig) throws UtilityException {
			File fUnassembleDir = rconfig.getUnassemblyDir();
			if (!fUnassembleDir.exists()) {
				throw new UtilityException("The unzippling directory does not exist. Please check your configuration.");
			}
			String unassembledDir = fUnassembleDir.getAbsolutePath();
			LOG.debug("Unassemble Dir in updateWebXml:" + unassembledDir);
			File portletXmlFile = new File(unassembledDir + "/WEB-INF/portlet.xml");
			//Check that portlet.xml and web.xml exists
			if (!portletXmlFile.exists()) {
				throw new UtilityException("The portlet.xml file does not exist in the archive.");
			}
			//get portlet list from portlet.xml
			List portlets = getPortletList(portletXmlFile);
			File webXmlFile = new File(unassembledDir + "/WEB-INF/web.xml");
			if (!webXmlFile.exists()) {
				throw new UtilityException("The web.xml file does not exist in the archive.");
			}
			//new file will replace the old one
			File newWebXmlFile = new File(unassembledDir + "/WEB-INF/web.xml");
			//Use assemble method to modify web.xml
			//	and replace it in unzipped war
            AssemblerConfig config = new AssemblerConfig();
            config.setPortletDescriptor(portletXmlFile);
            config.setWebappDescriptor(webXmlFile);
            config.setDestination(newWebXmlFile);

       	   assemble(config);
       	   
			return portlets;
		}

		/**
		 * Creates the fully assembled new war file.
		 * @param fileList
		 * @param warFilePath
		 */
		File createNewWar(ReassemblerConfig config) throws UtilityException {

		     byte[] buffer = new byte[BUFFER];
		     //list of files in the war
		     String[] fileList = config.getFileList();
		     File file = config.getWarFilePath();
		     String warName = file.getName();
		     //there needs to be at least a web.xml, portlet.xml and portlet class file in the archive
		     if (fileList.length < 3) {
		    	 throw new UtilityException("There needs to be at least a web.xml, portlet.xml and portlet class file in the war file.");
		     }
		     File warFilePath = config.getWarDestination();
		     File newWar = new File(warFilePath + File.separator + warName);
		     if (LOG.isDebugEnabled()) {
		    	 LOG.debug("Creating new war:" + newWar);
		     }
		     ZipOutputStream out = null;
		     try {
//		       out = new ZipOutputStream(new FileOutputStream(warFilePath));
		       out = new ZipOutputStream(new FileOutputStream(newWar));
		       // Set the compression ratio
		       out.setLevel(Deflater.DEFAULT_COMPRESSION);

		       // iterate through the array of files, adding each to the zip file
		       for (int i = 0; i < fileList.length; i++) {
		         System.out.println("File to add to new zip: " + fileList[i]);
		         // Associate a file input stream for the current file
		         String entryFilePath = config.getUnassemblyDir() + File.separator + fileList[i];
		         // Create a file object for the entry
		         File entryFile = new File(entryFilePath);
		         LOG.debug("Path of file to add to new zip: " + entryFile.getAbsolutePath());
//		         System.out.println("Does this file exist?: " + entryFile.exists());
//		         System.out.println("Is this a file?: " + entryFile.isFile());
		         if (entryFile.isFile()) {
			         FileInputStream in = new FileInputStream(entryFile);
	
			         // Add ZIP entry to output stream.
			         out.putNextEntry(new ZipEntry(fileList[i]));
	
			        int len;
			        while ((len = in.read(buffer)) > 0) {
			        	out.write(buffer, 0, len);
			        }
	
			         // Close the current entry
			         out.closeEntry();
	
			         // Close the current file input stream
			         in.close();
		         }
		       }
		     } catch (IllegalArgumentException e) {
		    	 String msg = "Problem creating new war";
		    	 LOG.error(msg, e);
		    	 UtilityException ue = new UtilityException(msg);
		    	 ue.initCause(e);
		 		throw ue;
		     } catch (FileNotFoundException e) {
		    	 String msg = "Problem creating new war";
		    	 LOG.error(msg, e);
		    	 UtilityException ue = new UtilityException(msg);
		    	 ue.initCause(e);
		 		throw ue;
		     } catch (IOException e) {
		    	 String msg = "Problem creating new war";
		    	 LOG.error(msg, e);
		    	 UtilityException ue = new UtilityException(msg);
		    	 ue.initCause(e);
		 		throw ue;
		     } finally {
		       // Close the ZipOutPutStream
		    	 if (out != null) {
				       try {
						out.close();
					} catch (IOException e) {
						LOG.warn("Problem closing output stream to write a new war", e);
					}		    		 
		    	 }
		     }
		     
			return newWar;
		}
	
		/**
		 * File list of portlet names in portlet.xml.
		 * 
		 * @param portletXml The portlet.xml
		 * @return A <code>List</code> of portlet names.
		 */
		List getPortletList(File portletXml) throws UtilityException {
			List portlets = null;
			//find portlets in portlet.xml
			PortletAppDD dd = null;
			try {
				InputStream is = new FileInputStream(portletXml);
				PortletAppDescriptorServiceImpl pappdesc = new PortletAppDescriptorServiceImpl();
				dd = pappdesc.read(is);
			} catch (FileNotFoundException e) {
		    	 String msg = "File cannot be found creating portlet list";
		    	 LOG.error(msg, e);
		    	 UtilityException ue = new UtilityException(msg);
		    	 ue.initCause(e);
		    	 throw ue;
			} catch (IOException e) {
		    	 String msg = "I/O problem creating portlet list";
		    	 LOG.error(msg, e);
		    	 UtilityException ue = new UtilityException(msg);
		    	 ue.initCause(e);
		    	 throw ue;
			}
			if (dd != null) {
				portlets = dd.getPortlets();
			}
			return portlets;
		}
}
