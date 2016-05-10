package org.apache.pluto.container.om.portlet;

public interface Dependency {

   /**
    * @return the name
    */
   String getName();

   /**
    * @param name the name to set
    */
   void setName(String name);

   /**
    * @return the version
    */
   String getVersion();

   /**
    * @param version the version to set
    */
   void setVersion(String version);

   /**
    * @return the library name
    */
   String getLibrary();
   
   /**
    * @param library - the library name
    */
   void setLibrary(String library);

}