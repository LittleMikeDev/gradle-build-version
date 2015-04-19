package uk.co.littlemike.gradle.build.version
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.notNullValue
import static org.hamcrest.MatcherAssert.assertThat

class BuildInfoTests {
    Project project;

    @Before
    void setUp() {
        BuildEnvironment.clearEnvironmentVariables()
        project = ProjectBuilder.builder().build()
    }

    @Test
    void buildInfoShouldIncludeBuildTime() {
        // Given
        Date buildTime = new Date()
        BuildEnvironment.overrideCurrentTime(buildTime)

        // When
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assertThat(buildInfo, notNullValue())
        assertThat(buildInfo.buildTime, equalTo(buildTime))
    }

    @Test
    void buildInfoShouldContainLocalBuildDetailsIfNoCIEnvironmentVariablesPresent() {
        // When
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assertThat(buildInfo.buildId, equalTo("Local build"))
        assertThat(buildInfo.revision, equalTo("Local copy"))
    }

    @Test
    void buildInfoShouldContainTeamcityBuildDetails() {
        // Given
        BuildEnvironment.overrideEnvironmentVariables([
                BUILD_NUMBER : "A build",
                BUILD_VCS_NUMBER : "A revision"
        ])

        // When
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assertThat(buildInfo.buildId, equalTo("A build"))
        assertThat(buildInfo.revision, equalTo("A revision"))
    }
}
