package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildInfo

class LocalBuildInfo extends BuildInfo {
    final Date buildTime
    final String buildId = "Local build"
    final String revision = "Local copy"
    final String triggeredBy = "Local user"

    public LocalBuildInfo(Date buildTime) {
        this.buildTime = buildTime
    }
}