package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class Go extends BuildSystem {
    @Override
    boolean matches(BuildEnvironment environment) {
        return environment.variables.containsKey("GO_PIPELINE_LABEL")
    }

    @Override
    BuildInfo getBuildInfo(BuildEnvironment environment) {
        new GoBuildInfo(environment)
    }
}
