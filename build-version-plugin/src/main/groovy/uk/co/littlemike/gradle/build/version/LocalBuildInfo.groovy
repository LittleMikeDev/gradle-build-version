package uk.co.littlemike.gradle.build.version

class LocalBuildInfo implements BuildInfo {

    @Override
    String getBuildId() {
        "Local build"
    }

    @Override
    Date getBuildTime() {
        new Date()
    }

    @Override
    String getRevision() {
        "Local copy"
    }
}
