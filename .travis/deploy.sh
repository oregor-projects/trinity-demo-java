#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    ./mvnw deploy -P sources,javadocs,codesign,nexus --settings ./.m2/settings.xml
fi
