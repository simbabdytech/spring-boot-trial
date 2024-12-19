#!/usr/bin/env bash

CurrentDir=$(dirname $0)

find ${CurrentDir} -name "build" |  xargs rm -rf $(xargs)
find ${CurrentDir} -name "out" |  xargs rm -rf  $(xargs)
${CurrentDir}/gradlew clean build -x test --warning-mode all



