package uk.co.littlemike.gradle.build.version

import org.junit.Before
import org.junit.Test

class TeamCityCITests extends AbstractCITest {

    @Before
    void ciAgentIsTeamcity() {
        environment.variables.BUILD_NUMBER = "Teamcity build number is always set"
    }

    @Test
    void buildInfoContainsBuildIdAndRevision() {
        // Given
        environment.variables.putAll([
                BUILD_NUMBER : "A build",
                BUILD_VCS_NUMBER : "A revision"
        ])

        // When
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildId == "A build"
        assert buildInfo.revision == "A revision"
    }
}
