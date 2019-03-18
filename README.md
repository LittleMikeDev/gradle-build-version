Gradle build version plugin
===========================

[![Build Status](https://travis-ci.org/LittleMikeDev/gradle-build-version.svg?branch=master)](https://travis-ci.org/LittleMikeDev/gradle-build-version)
[![codecov.io](http://codecov.io/github/LittleMikeDev/gradle-build-version/coverage.svg?branch=master)](http://codecov.io/github/LittleMikeDev/gradle-build-version?branch=master)

Need build information from your CI system, but don't want to end up coupled to it's specific environment variables?

This plugin provided standardized access to build information from multiple CI systems.

Supported CI systems
--------------------

* Circle-CI
* Travis-CI
* TeamCity
* Thoughtworks GO
* Local builds

How to use
----------

[Apply the plugin](https://plugins.gradle.org/plugin/uk.co.littlemike.build-version-plugin)

CI build information is now available on the project model as below

```
project.buildInfo.buildId       // Unique build ID, format depends on CI system, usually a sequential number
project.buildInfo.buildTime     // Time of build. More specifically, the time that the plugin was applied!
project.buildInfo.revision      // VCS revision (GIT hash, SVN revision number...)
```

Compatibility
-------------

Not all CI systems support all properties, check the table below for details:


| Build     | Build Id | Build time | Revision | Triggered by | Build link |
|-----------|----------|------------|----------|--------------|------------|
| Circle CI | Y        | Y          | Y        | Y            | Y          |
| Travis CI | Y        | Y          | Y        |              |            |
| TeamCity  | Y        | Y          | Y        |              |            |
| GO        | Y        | Y          | Y        | Y            | Y          |
| Local     | *        | Y          | *        | *            |            |

- Local properties marked with * have hard coded values