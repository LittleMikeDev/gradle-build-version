package uk.co.littlemike.gradle.build.version

import org.junit.Before
import org.junit.Test

class TravisCITests extends AbstractCITest {

    @Before
    void ciAgentIsTravis() {
        environment.variables.TRAVIS = "true"
    }

    @Test
    void buildInfoContainsBuildIdAndRevision() {
        // Given
        environment.variables.putAll([
                TRAVIS_BUILD_NUMBER : "A build",
                TRAVIS_COMMIT : "A revision"
        ])

        // When
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildId == "A build"
        assert buildInfo.revision == "A revision"
    }
}
