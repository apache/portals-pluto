#  Licensed to the Apache Software Foundation (ASF) under one or more
#  contributor license agreements.  See the NOTICE file distributed with
#  this work for additional information regarding copyright ownership.
#  The ASF licenses this file to You under the Apache License, Version 2.0
#  (the "License"); you may not use this file except in compliance with
#  the License.  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License

Running the JSR-286 TCK against Pluto 2.0+ Portal Driver

1) Setup the Portlet TCK and assemble Pluto TCK test wars (only needs to be done once)

  a) Download the Portlet TCK
  
     Go to http://jcp.org/aboutJava/communityprocess/final/jsr286/index.html
     The TCK download link is provided there, which (currently) is at: 
     
       http://hnsp.inf-bb.uni-jena.de/tck/

     Note: this is a license agreement click-through link
     
     Save the downloaded portlet-tck070508.zip at a location of your convenience.
     
  b) Create a directory for the TCK and extract the downloaded portlet-tck070508.zip *inside* that directory.

  c) Add an environment variable pointing to your TCK installation directory called TS_HOME
     For example on Linux, add the following to your ~/.bashrc:
     
     export TS_HOME=~/portlet-tck070508
     
     Note: the TCK itself requires this TS_HOME environment variable.

  d) If on Linux, make the extracted $TS_HOME/bin/tsant shell script executable:

     chmod +x $TS_HOME/bin/tsant
     
  e) Configure $TS_HOME/bin/build.properties:

     Set your local timezone in $TS_HOME/bin/build.properties (default is US/Eastern).
     For example, if you are in Amsterdam, use:
   
       tz=Europe/Amsterdam

     Replace:
     
       j2ee.home.ri=${env.J2EE_HOME}
       j2ee.classes.ri=${j2ee.home.ri}/lib/j2ee.jar

     with:
     
       j2ee.home.ri=${TS_HOME}
       j2ee.classes.ri=${j2ee.home.ri}/lib/j2ee_1_3.jar
       
  f) Copy the pluto-assemble-tck286-wars-pom.xml to $TS_HOME
  
  g) from $TS_HOME, run mvn -f pluto-assemble-tck286-wars-pom.xml
  
     This will run the maven-pluto-plugin against the tck test wars and write them out to $TS_HOME/pluto-assembled-wars

2) Build and setup a clean Pluto/Tomcat installation for testing

3) Running the TCK

  a) copy all wars from $TS_HOME/pluto-assembled-wars to your Pluto/Tomcat webapps folder

  b) Startup and stop Tomcat once to ensure the TCK portlet applications are predeployed

  c) Start Tomcat again
  
  d) Start the TCK gui:
  
     $TS_HOME/bin/tsant gui
     
  c) In the gui, create a new TCK work directory somewhere
  
       Menu: File|New Work Directory
       
     All test output will be stored there, you can later on reload it again to review the outcome.
  
  d) Finally, in the gui run the TCK
  
      Menu: Run Tests|Start
  
  As a shortcut for step c+d above right after starting the TCK gui you can just do step d.
  The gui will first ask where to create or reload a work directory and start executing right after.

