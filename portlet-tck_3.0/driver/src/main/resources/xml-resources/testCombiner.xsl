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
   Each test case module produces as output an xml file containing a list of test cases
   defined in that module. This stylesheet combines the test case files listed in the input 
   file into a single output test list.
   
   When a new test case module is added, the filelist XML file must be updated in order
   to add the new test cases to the complete list of test cases.
-->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fl="http://www.apache.org/2014/javax/portlet/tck/filelist">
	<xsl:output method="xml" indent="yes" doctype-system="http://java.sun.com/dtd/properties.dtd" />
   <xsl:strip-space elements="*" />
   
	<xsl:template match="/">
      <xsl:element name="properties">
			<xsl:apply-templates />
		</xsl:element>
	</xsl:template>

   <xsl:template match="fl:filelist/fl:file">
      <xsl:copy-of select="document(.)/properties/entry"/>
   </xsl:template>

</xsl:stylesheet>
