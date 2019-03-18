package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class CircleCiBuildInfo extends BuildInfo {
    String buildId
    Date buildTime
    String revision
    String triggeredBy
    String buildLink

    CircleCiBuildInfo(BuildEnvironment environment) {
        buildTime = environment.currentTime
        buildId = environment.variables.CIRCLE_BUILD_NUM
        revision = environment.variables.CIRCLE_SHA1
        triggeredBy = environment.variables.CIRCLE_USERNAME
        buildLink = environment.variables.CIRCLE_BUILD_URL
    }
}
