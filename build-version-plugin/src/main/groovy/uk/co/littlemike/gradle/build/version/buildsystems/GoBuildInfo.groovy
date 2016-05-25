package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

class GoBuildInfo extends BuildInfo {
    final Date buildTime
    final BuildEnvironment environment

    GoBuildInfo(BuildEnvironment environment) {
        buildTime = environment.currentTime
        this.environment = environment
        server = environment.variables.GO_SERVER_URL
    }

    @Override
    String getBuildLink() {
        def pipeline = environment.variables.GO_PIPELINE_NAME
        def pipelineCount = environment.variables.GO_PIPELINE_COUNTER
        def stage = environment.variables.GO_STAGE_NAME
        def stageCount = environment.variables.GO_STAGE_COUNTER
        "${server}pipelines/${pipeline}/${pipelineCount}/${stage}/${stageCount}"
    }

    String getBuildId() {
        environment.variables.GO_PIPELINE_LABEL
    }

    String getRevision() {
        environment.variables.entrySet().find() {
            it.key.startsWith "GO_REVISION"
        }?.value
    }
}
