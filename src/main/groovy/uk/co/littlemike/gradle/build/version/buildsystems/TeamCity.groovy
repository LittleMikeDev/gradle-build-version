package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class TeamCity extends BuildSystem {
    @Override
    boolean matches(BuildEnvironment environment) {
        environment.variables.containsKey("BUILD_NUMBER")
    }

    @Override
    BuildInfo getBuildInfo(BuildEnvironment environment) {
        new TeamCityBuildInfo(environment)
    }
}
