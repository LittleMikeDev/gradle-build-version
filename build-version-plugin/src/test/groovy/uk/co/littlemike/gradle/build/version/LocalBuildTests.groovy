package uk.co.littlemike.gradle.build.version

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.isA
import static org.hamcrest.CoreMatchers.notNullValue
import static org.hamcrest.MatcherAssert.assertThat

class LocalBuildTests {
    Project project;

    @Before
    void setUp() {
        project = ProjectBuilder.builder().build()
    }

    @Test
    void shouldReturnLocalBuildProperties() {
        // When
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assertThat(buildInfo, notNullValue())
        assertThat(buildInfo.buildId, equalTo("Local build"))
        assertThat(buildInfo.buildTime, isA(Date.class))
        assertThat(buildInfo.revision, equalTo("Local copy"))
    }
}
