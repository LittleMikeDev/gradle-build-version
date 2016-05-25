package uk.co.littlemike.gradle.build.version

abstract class BuildInfo {
    abstract String getBuildId()
    abstract Date getBuildTime()
    abstract String getRevision()
    String getBuildLink() { "" }
    String server = ""
}
