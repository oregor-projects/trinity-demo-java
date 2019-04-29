#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
  openssl aes-256-cbc -K $encrypted_51ce0c2af94b_key -iv $encrypted_51ce0c2af94b_iv -in .travis/codesigning.asc.enc -out .travis/codesigning.asc -d
  gpg --fast-import .travis/codesigning.asc
fi
