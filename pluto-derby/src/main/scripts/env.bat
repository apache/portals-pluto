#Sets environmental variables for use to run scripts in this directory

set MAVEN_REPO="%M2_REPO%"
#derby.system.home
set SYSTEM_HOME="%HOME%\.pluto\derby"
set CLASSPATH=%MAVEN_REPO%\org\apache\derby\derby\10.1.1.0\derby-10.1.1.0.jar;%MAVEN_REPO%\org\apache\derby\derbytools\10.1.1.0\derbytools-10.1.1.0.jar
set DB_CONN=PlutoDB;create=true;name=container;password=container
set PROTOCOL=jdbc:derby: