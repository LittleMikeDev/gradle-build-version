package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class TeamCityBuildInfo extends BuildInfo {
    final Date buildTime
    final String buildId
    final String revision
    final String triggeredBy = ""

    TeamCityBuildInfo(BuildEnvironment environment) {
        buildTime = environment.currentTime
        buildId = environment.variables.BUILD_NUMBER
        revision = environment.variables.BUILD_VCS_NUMBER
    }
}
