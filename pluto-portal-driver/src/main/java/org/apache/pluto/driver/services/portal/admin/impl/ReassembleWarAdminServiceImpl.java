package org.apache.pluto.driver.services.portal.admin.impl;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.services.portal.admin.ReassembleWarAdminService;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.assemble.ReassemblerConfig;
import org.apache.pluto.util.assemble.WarReassembler;

public class ReassembleWarAdminServiceImpl implements ReassembleWarAdminService {

	private static final Log LOG = LogFactory.getLog(ReassembleWarAdminService.class);
	private WarReassembler reassembler = null;//reassembly utility
	/**
	 * Base directory to do the unzipping for reassembly
	 */
	private String unzipBaseDir = System.getProperty("user.home") + "/pluto";
	/** 
	 * Destination directory of the reassembled war
	 */
	private String destination = System.getProperty("user.home") + "/pluto/war";
	
	public ReassembleWarAdminServiceImpl() {
		super();
	}

	public File reassembleWar(File warFilePath) throws UtilityException {
		ReassemblerConfig config = new ReassemblerConfig();
		config.setRootUnassemblyDir(new File(unzipBaseDir));
		config.setWarFilePath(warFilePath);
		File dest = new File(destination);
		if (!dest.exists()) {
			dest.mkdirs();
		}
		config.setWarDestination(dest);
		return reassembler.reassemble(config);
	}

	private String getWarBaseName(File warFilePath) {
		String baseName = null;
		String name = warFilePath.getName();
		baseName = name.substring(0, name.lastIndexOf('.'));
		if (LOG.isDebugEnabled()) {
			LOG.debug("Base file name: " + baseName);
		}
		return baseName;
	}
	public WarReassembler getReassembler() {
		return reassembler;
	}

	public void setReassembler(WarReassembler reassembler) {
		this.reassembler = reassembler;
	}

	public String getUnzipBaseDir() {
		return unzipBaseDir;
	}

	public void setUnzipBaseDir(String unzipBaseDir) {
		this.unzipBaseDir = unzipBaseDir;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
