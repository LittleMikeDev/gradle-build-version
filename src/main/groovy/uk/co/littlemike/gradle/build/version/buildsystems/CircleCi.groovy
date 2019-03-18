package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class CircleCi extends BuildSystem {

    @Override
    boolean matches(BuildEnvironment environment) {
        return environment.variables.containsKey("CIRCLE_BUILD_NUM")
    }

    @Override
    BuildInfo getBuildInfo(BuildEnvironment environment) {
        return new CircleCiBuildInfo(environment)
    }
}
