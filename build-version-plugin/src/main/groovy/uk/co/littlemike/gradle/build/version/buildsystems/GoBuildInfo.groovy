package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class GoBuildInfo implements BuildInfo {
    final Date buildTime
    final String buildId
    final String revision

    GoBuildInfo(BuildEnvironment environment) {
        buildTime = environment.currentTime
        buildId = environment.variables.GO_PIPELINE_LABEL
        revision = environment.variables.entrySet().find() {
            it.key.startsWith "GO_REVISION"
        }?.value
    }
}
