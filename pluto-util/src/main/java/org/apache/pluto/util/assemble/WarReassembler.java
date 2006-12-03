package org.apache.pluto.util.assemble;

import java.io.File;

import org.apache.pluto.util.UtilityException;

/**
 * <code>Assembler</code> that reassembles an existing
 * war file by, decompressing it, updating the web.xml file via
 * the <code>Assembler</code> and rebuilding the war. 
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 *
 */
public interface WarReassembler extends Assembler {
	
	public File reassemble(ReassemblerConfig config) throws UtilityException;
}
