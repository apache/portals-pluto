#Starts ij SQL command-line utility
call env.bat
java -cp "%CLASSPATH%" -Dij.protocol=%PROTOCOL% -Dij.connection.connectionName=%DB_CONN% -Dderby.system.home=%SYSTEM_HOME% org.apache.derby.tools.ij
