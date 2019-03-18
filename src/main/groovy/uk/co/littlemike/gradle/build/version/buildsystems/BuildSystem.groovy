package uk.co.littlemike.gradle.build.version.buildsystems

import uk.co.littlemike.gradle.build.version.BuildEnvironment
import uk.co.littlemike.gradle.build.version.BuildInfo

abstract class BuildSystem {
    private static def buildSystems = [
            new Travis(),
            new TeamCity(),
            new Go(),
            new CircleCi(),
            new LocalBuild()
    ]

    abstract BuildInfo getBuildInfo(BuildEnvironment environment)

    abstract boolean matches(BuildEnvironment environment)

    static BuildInfo getBuildSystemInfo(BuildEnvironment environment) {
        buildSystems.find {
            it.matches(environment)
        }.getBuildInfo(environment)
    }
}
