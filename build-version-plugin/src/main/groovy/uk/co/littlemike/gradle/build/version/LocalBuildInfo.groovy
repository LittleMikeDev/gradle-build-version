package uk.co.littlemike.gradle.build.version

class LocalBuildInfo extends BuildInfo {

    LocalBuildInfo() {
        buildId = "Local build"
        buildTime = new Date()
        revision = "Local copy"
    }
}
