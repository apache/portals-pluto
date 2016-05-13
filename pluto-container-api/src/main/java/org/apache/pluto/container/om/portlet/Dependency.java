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
    * @return the scope name
    */
   String getScope();
   
   /**
    * @param scope - the scope name
    */
   void setScope(String scope);

}