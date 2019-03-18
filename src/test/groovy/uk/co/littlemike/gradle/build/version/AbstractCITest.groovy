package uk.co.littlemike.gradle.build.version

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

abstract class AbstractCITest {
    BuildEnvironment environment
    Project project;

    @Before
    void setUp() {
        environment = BuildEnvironment.environment
        environment.variables.clear()
        project = ProjectBuilder.builder().build()
    }

    @Test
    void buildInfoIncludesBuildTime() {
        // Given
        Date buildTime = new Date()
        environment.currentTime = buildTime

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo != null
        assert buildInfo.buildTime == buildTime
    }

    @Test
    void canSetServerRegardlessOfCiSystem() {
        // Given
        project.apply(plugin: BuildVersionPlugin)

        // When
        project.buildInfo.server = 'http://my-ci-server.com'

        // Then
        // no errors
    }
}
