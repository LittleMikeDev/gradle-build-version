package uk.co.littlemike.gradle.build.version

abstract class BuildInfo {
    abstract String getBuildId()
    abstract Date getBuildTime()
    abstract String getRevision()
    abstract String getTriggeredBy()
    String getBuildLink() { "" }
    String server = ""
}
