package uk.co.littlemike.gradle.build.version

class BuildEnvironment {

    private static Map<String, String> environmentVariables = new LinkedHashMap<>(System.getenv())
    private static Optional<Date> currentTimeOverride = Optional.empty()

    static void overrideCurrentTime(Date date) {
        currentTimeOverride = Optional.of(date)
    }

    static void overrideEnvironmentVariables(Map<String, String> variableOverrides) {
        environmentVariables.putAll(variableOverrides)
    }

    static void clearEnvironmentVariables() {
        environmentVariables.clear()
    }

    static BuildInfo getBuildInfo() {
        def info = CIBuildSystem.getBuildSystemInfo(environmentVariables)
        info.buildTime = currentTimeOverride.orElse(new Date())
        info
    }
}
