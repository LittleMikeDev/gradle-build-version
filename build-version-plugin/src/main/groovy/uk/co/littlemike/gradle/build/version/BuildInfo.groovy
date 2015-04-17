package uk.co.littlemike.gradle.build.version

interface BuildInfo {
    String getBuildId()
    Date getBuildTime()
    String getRevision()
}