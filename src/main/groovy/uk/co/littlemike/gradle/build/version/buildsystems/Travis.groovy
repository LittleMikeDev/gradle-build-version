package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class Travis extends BuildSystem {

    @Override
    boolean matches(BuildEnvironment environment) {
        environment.variables.TRAVIS == "true"
    }

    @Override
    BuildInfo getBuildInfo(BuildEnvironment environment) {
        new TravisBuildInfo(environment)
    }
}
