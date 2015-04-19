package uk.co.littlemike.gradle.build.version

enum CIBuildSystem {
    TeamCity("BUILD_NUMBER", "BUILD_VCS_NUMBER")

    private final String buildIdProperty
    private final String revisionProperty

    private CIBuildSystem(String buildIdProperty, String revisionProperty) {
        this.buildIdProperty = buildIdProperty
        this.revisionProperty = revisionProperty
    }

    static BuildInfo getBuildSystemInfo(Map<String, String> environmentVariables) {
        for (def system : values()) {
            if (environmentVariables.containsKey(system.buildIdProperty)) {
                return new BuildInfo(
                        buildId: environmentVariables.get(system.buildIdProperty),
                        revision: environmentVariables.get(system.revisionProperty)
                )
            }
        }
        return new BuildInfo(
                buildId: "Local build",
                revision: "Local copy"
        )
    }
}
