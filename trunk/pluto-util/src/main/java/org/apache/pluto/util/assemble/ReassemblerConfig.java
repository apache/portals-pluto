package org.apache.pluto.util.assemble;

import java.io.File;

/**
 * Holds configuration for a <code>Reassembler</code>.
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class ReassemblerConfig {
	
	/**
	 * Full path to the war file before unassembly.
	 */
	private File warFilePath = null;

	/**
	 * War file name
	 */
	private String strWarFileName = null;

	/**
	 * Root of the war file name without the .war
	 */
	private String strRootWarFileName = null;
	
	/**
	 * Root directory where file will unassemble war file.
	 */
	private File rootUnassemblyDir = null;
	
	/**
	 * Directory to unassemble war file.
	 */
	private File unassemblyDir = null;
	
	/**
	 * The destination of the reassembled war.
	 */
	private File warDestination = null;
	
	/**
	 * List of files in the archive
	 */
	private String[] fileList = null;
	
	/**
	 * @return the warFilePath
	 */
	public File getWarFilePath() {
		return warFilePath;
	}

	/**
	 * @param warFilePath the warFilePath to set
	 */
	public void setWarFilePath(File warFilePath) {
		this.warFilePath = warFilePath;
	   String strWarFilePath = warFilePath.getAbsolutePath();
	   //parse out the war file name
       int index = strWarFilePath.lastIndexOf(File.separator);
       //get file name
       if (strWarFilePath == null) {
    	   throw new IllegalArgumentException("War file path has not been set.");
       }
       if (strWarFileName == null) {
		   strWarFileName = strWarFilePath.substring(index + 1);
		     System.out.println("FileName: " + strWarFileName);
	       //Get root of file name (minus extension)
	       strRootWarFileName = strWarFileName.substring(0, strWarFileName.lastIndexOf("."));
       }
     System.out.println("rootFileName: " + strRootWarFileName);
	}

//	public void setUnassemblyDir(File dir){
//		unassemblyDir = dir;
//	}
	
	public File getUnassemblyDir(){
		if (rootUnassemblyDir == null) {
	    	   throw new IllegalArgumentException("Parent directory to unassemble the war files so their web.xml file can be updated has not been set.");			
		}
		if (unassemblyDir == null) {
			unassemblyDir = new File(rootUnassemblyDir, strRootWarFileName); 
		}
		return unassemblyDir;
	}

	/**
	 * @return the fileList
	 */
	public String[] getFileList() {
		return fileList;
	}

	/**
	 * @param fileList the fileList to set
	 */
	public void setFileList(String[] fileList) {
		this.fileList = fileList;
	}

	/**
	 * @return the warDestination
	 */
	public File getWarDestination() {
		return warDestination;
	}

	/**
	 * @param warDestination the warDestination to set
	 */
	public void setWarDestination(File warDestination) {
		this.warDestination = warDestination;
	}

	/**
	 * @return the rootUnassemblyDir
	 */
	public File getRootUnassemblyDir() {
		return rootUnassemblyDir;
	}

	/**
	 * @param rootUnassemblyDir the rootUnassemblyDir to set
	 */
	public void setRootUnassemblyDir(File rootUnassemblyDir) {
		this.rootUnassemblyDir = rootUnassemblyDir;
	}
	

}
