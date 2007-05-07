package org.apache.pluto.ant;

import java.io.File;
import java.io.FileInputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class ExamineArchiveTask extends Task {
    
    private File archive = null;
    
    public void execute() throws BuildException {
        try {
        
            JarInputStream jarIn = new JarInputStream( new FileInputStream( archive ) );
            JarEntry entry;
            while ( ( entry = jarIn.getNextJarEntry() ) != null ) {
                String name = entry.getName();
                long crc = entry.getCrc();
                long size = entry.getSize();
                long compressedSize = entry.getCompressedSize();
                int compressMethod = entry.getMethod();
                long timeStamp = entry.getTime();
                int hashCode = entry.hashCode();
                
                StringBuffer out = new StringBuffer();
                
                out.append( "Name: " + name + "\n" );
                out.append( "  Size: "                  + Long.toHexString( size ) + " " );
                out.append( "  Compressed Size: "       + Long.toHexString( compressedSize ) + " " );
                out.append( "  Compression Method: "    + compressMethod + " " );
                out.append( "  Timestamp: "             + Long.toHexString( timeStamp ) + " " );
                out.append( "  HashCode: "              + Integer.toHexString( hashCode ) + " " );
                out.append( "  CRC: "                   + Long.toHexString( crc ) + " " );
                
                System.out.println( out.toString() );
                
            }
        
        } catch ( Exception e ) {
            throw new BuildException( e.getMessage(), e );
        }
        
    }
    
    public void setArchive( File archive ) {
        this.archive = archive;
    }
    
    public File getArchive( ) {
        return this.archive;
    }

}
