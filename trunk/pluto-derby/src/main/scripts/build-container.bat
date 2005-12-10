#Runs builf-container.sql and insert-testsuite.sql
# to build the container schema and insert data from
# the testsuite portlet.	
call env.bat
java -cp %CLASSPATH% -Dij.protocol=%PROTOCOL% -Dij.connection.connectionName=%DB_CONN% -Dderby.system.home=%SYSTEM_HOME% org.apache.derby.tools.ij build-container.sql
java -cp %CLASSPATH% -Dij.protocol=%PROTOCOL% -Dij.connection.connectionName=%DB_CONN% -Dderby.system.home=%SYSTEM_HOME% org.apache.derby.tools.ij insert-testsuite.sql