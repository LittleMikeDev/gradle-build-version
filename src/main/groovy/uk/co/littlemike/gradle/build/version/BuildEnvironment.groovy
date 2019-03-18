package uk.co.littlemike.gradle.build.version

class BuildEnvironment {
    static BuildEnvironment environment = new BuildEnvironment()

    Map<String, String> variables = new LinkedHashMap<>(System.getenv())
    Date currentTime = new Date()
}
