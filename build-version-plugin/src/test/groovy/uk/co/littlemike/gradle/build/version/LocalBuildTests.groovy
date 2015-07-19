package uk.co.littlemike.gradle.build.version

import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

class LocalBuildTests extends AbstractCITest {

    @Test
    void buildInfoShouldContainLocalBuildDetailsIfNoCIEnvironmentVariablesPresent() {
        // When
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assertThat(buildInfo.buildId, equalTo("Local build"))
        assertThat(buildInfo.revision, equalTo("Local copy"))
    }
}
