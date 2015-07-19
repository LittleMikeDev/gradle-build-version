package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class LocalBuild extends BuildSystem {

    @Override
    boolean matches(BuildEnvironment environment) {
        return true
    }

    @Override
    BuildInfo getBuildInfo(BuildEnvironment environment) {
        new LocalBuildInfo(environment.currentTime)
    }
}
