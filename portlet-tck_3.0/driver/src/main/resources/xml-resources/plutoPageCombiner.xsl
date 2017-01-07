<!-- Licensed to the Apache Software Foundation (ASF) under one or more contributor 
	license agreements. See the NOTICE file distributed with this work for additional 
	information regarding copyright ownership. The ASF licenses this file to 
	you under the Apache License, Version 2.0 (the "License"); you may not use 
	this file except in compliance with the License. You may obtain a copy of 
	the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required 
	by applicable law or agreed to in writing, software distributed under the 
	License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS 
	OF ANY KIND, either express or implied. See the License for the specific 
	language governing permissions and limitations under the License. -->

<!--
   Each test case module produces as output an xml file containing a list of portal pages
   to be accessed for the test cases defined in that module. This stylesheet combines the 
   page files listed in the input file into a single output page file.
   
   When a new test case module is added, the filelist XML file must be updated in order
   to add the new pages to the complete list of portal pages.
   
   This stylesheet produces a pluto-portal-driver-config.xml file containing all of the 
   test pages.
-->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fl="http://www.apache.org/2014/javax/portlet/tck/filelist">
	<xsl:output method="xml" indent="yes" />
   <xsl:strip-space elements="*" />

  <xsl:template match="/">
  <pluto-portal-driver
    xmlns="http://portals.apache.org/pluto/xsd/pluto-portal-driver-config.xsd"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://portals.apache.org/pluto/xsd/pluto-portal-driver-config.xsd
                        http://portals.apache.org/pluto/pluto-portal/1.1/pluto-portal-driver-config.xsd"
    version="1.1">


    <portal-name>pluto-portal-driver</portal-name>
    <portal-version>3.0.0</portal-version>
    <container-name>Pluto Portal Driver</container-name>

    <supports>
      <portlet-mode>view</portlet-mode>
      <portlet-mode>edit</portlet-mode>
      <portlet-mode>help</portlet-mode>
      <portlet-mode>config</portlet-mode>

      <window-state>normal</window-state>
      <window-state>maximized</window-state>
      <window-state>minimized</window-state>
    </supports>
    <xsl:element name="render-config">
      <xsl:attribute name="default">About Apache Pluto</xsl:attribute>
    <page name="About Apache Pluto" uri="/WEB-INF/themes/pluto-default-theme.jsp">
      <portlet context="/pluto" name="AboutPortlet"/>
    </page>
      <xsl:apply-templates/>
    </xsl:element>
    </pluto-portal-driver>
  </xsl:template>

   <xsl:template match="fl:filelist/fl:file">
      <xsl:copy-of select="document(.)//page"/>
   </xsl:template>

</xsl:stylesheet>
