package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class TravisBuildInfo implements BuildInfo {
    final Date buildTime
    final String buildId
    final String revision

    def TravisBuildInfo(BuildEnvironment environment) {
        buildTime = environment.currentTime
        buildId = environment.variables.TRAVIS_BUILD_NUMBER
        revision = environment.variables.TRAVIS_COMMIT
    }
}
