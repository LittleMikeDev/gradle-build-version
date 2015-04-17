package uk.co.littlemike.gradle.build.version

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildVersionPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('hello') << {
            println 'Hello world!'
        }
    }
}
