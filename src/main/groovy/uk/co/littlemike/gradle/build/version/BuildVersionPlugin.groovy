package uk.co.littlemike.gradle.build.version

import org.gradle.api.Plugin
import org.gradle.api.Project
import uk.co.littlemike.gradle.build.version.buildsystems.BuildSystem

class BuildVersionPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.add("buildInfo", BuildSystem.getBuildSystemInfo(BuildEnvironment.environment))
    }
}
