#!/bin/bash
find /Users/edalquist/tmp/webapps/ -name '*.war' -exec ant -f tck-deploy.xml deployPortletApp -DportletApp={} -DdestDir=/Users/edalquist/java/tomcat/apache-tomcat-pluto/webapps \;