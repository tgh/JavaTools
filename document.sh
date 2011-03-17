#!/bin/bash

src_path=~/Projects/JavaTools/src/tylerhayes/tools

javadoc -d ./doc/ $src_path/Log.java $src_path/GracefulShutdown.java $src_path/DatabaseConnector.java $src_path/PostgreSQLConsole.java $src_path/TerminationInterceptor.java
