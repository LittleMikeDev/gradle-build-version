package uk.co.littlemike.gradle.build.version

class BuildEnvironment {

    private static Map<String, String> environmentVariables = new LinkedHashMap<>(System.getenv())
    private static Date currentTimeOverride = null

    static void overrideCurrentTime(Date date) {
        currentTimeOverride = date
    }

    static void overrideEnvironmentVariables(Map<String, String> variableOverrides) {
        environmentVariables.putAll(variableOverrides)
    }

    static void clearEnvironmentVariables() {
        environmentVariables.clear()
    }

    static BuildInfo getBuildInfo() {
        def info = CIBuildSystem.getBuildSystemInfo(environmentVariables)
        info.buildTime = getTime()
        info
    }

    private static Date getTime() {
        if (currentTimeOverride != null) {
            return currentTimeOverride
        }
        return new Date()
    }
}
