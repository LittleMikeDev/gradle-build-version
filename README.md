Gradle build version plugin
===========================

This plugin provides information from the build system. This is not normally possible without coupling your build to the
CI build system being used, as different build systems expose these properties using different environment variables.

Supported CI systems
--------------------

* TeamCity

Requirements
------------

Compiled for use with Java 6+

How to use
----------

Apply the plugin (Gradle 2.1+)

```
plugins {
    id "uk.co.littlemike.build-version-plugin" version "0.3"
}
```

CI build information is now available on the project model as below

```
project.buildInfo.buildId       // Unique build ID, format depends on CI system, usually a sequential number
project.buildInfo.buildTime     // Time of build. More specifically, the time that the plugin was applied!
project.buildInfo.revision      // VCS revision (GIT hash, SVN revision number...)
```