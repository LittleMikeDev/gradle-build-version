package uk.co.littlemike.gradle.build.version

import org.junit.Before
import org.junit.Test

class CircleCITests extends AbstractCITest {

    @Before
    void ciAgentIsCircleCI() {
        environment.variables.CIRCLE_BUILD_NUM = "Build num is always set"
    }

    @Test
    void buildInfoContainsBuildIdAndRevision() {
        // Given
        environment.variables.putAll([
                CIRCLE_BUILD_NUM : "123",
                CIRCLE_SHA1 : "Git revision"
        ])

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildId == "123"
        assert buildInfo.revision == "Git revision"
    }

    @Test
    void buildInfoContainsLinkToBuildJob() {
        // Given
        environment.variables.putAll([
                CIRCLE_BUILD_URL : "Build url"
        ])

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildLink == "Build url"
    }

    @Test
    void buildInfoContainsTriggeredBy() {
        // Given
        environment.variables.putAll([
                CIRCLE_USERNAME: 'A person'
        ])

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.triggeredBy == 'A person'
    }
}
