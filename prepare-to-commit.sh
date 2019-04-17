#!/usr/bin/env bash

abort() {
    echo >&2 '
*************************************************************************
*** You are not ready to commit! Fix the errors above and re-execute. ***
*************************************************************************
'
    echo "An error occurred. Exiting..." >&2
    exit 1
}

trap 'abort' 0

set -e

# SCRIPTS_START
#########################################

# Uncomment the line below if you want to include license information in your source files.
#./mvnw license:update-file-header

./mvnw fmt:format

# Add profile "validate-license" in the line below to validate license information.
./mvnw clean install -P validate-code-format,validate-code-style,validate-code-bugs,validate-code \
 -DskipTests=true -Dmaven.javadoc.skip=true -B -V

./mvnw test -B

#########################################
# SCRIPTS_END
#########################################

trap : 0

echo >&2 '
***********************************************
*** GOOD JOB! You are ready to commit now. ***
***********************************************
'
