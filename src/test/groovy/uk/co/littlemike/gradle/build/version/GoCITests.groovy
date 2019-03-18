package uk.co.littlemike.gradle.build.version

import org.junit.Before
import org.junit.Test

class GoCITests extends AbstractCITest {

    @Before
    void ciAgentIsGo() {
        environment.variables.GO_PIPELINE_LABEL = "Go label is always set"
    }

    @Test
    void buildInfoContainsBuildIdAndRevision() {
        // Given
        environment.variables.putAll([
                GO_PIPELINE_LABEL : "A GO build",
                GO_REVISION : "A GO material revision"
        ])

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildId == "A GO build"
        assert buildInfo.revision == "A GO material revision"
    }

    @Test
    void buildInfoContainsRevisionOfFirstMaterial() {
        // Given
        environment.variables.putAll([
                GO_REVISION_MATERIAL_1 : "Revision 1",
                GO_REVISION_MATERIAL_2 : "Revision 2"
        ])

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.revision == "Revision 1"
    }

    @Test
    void buildInfoContainsLinkToBuildJob() {
        // Given
        environment.variables.putAll([
                GO_SERVER_URL : "http://gourl.com/go/",
                GO_PIPELINE_NAME : "my-pipeline",
                GO_PIPELINE_COUNTER : "6",
                GO_STAGE_NAME : "build-stuff",
                GO_STAGE_COUNTER : "2"
        ])

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildLink == "http://gourl.com/go/pipelines/my-pipeline/6/build-stuff/2"
    }

    @Test
    void canOverrideServerUrl() {
        // Given
        environment.variables.putAll([
                GO_SERVER_URL : "http://gourl.com/go/",
                GO_PIPELINE_NAME : "my-pipeline",
                GO_PIPELINE_COUNTER : "6",
                GO_STAGE_NAME : "build-stuff",
                GO_STAGE_COUNTER : "2"
        ])
        project.apply(plugin: BuildVersionPlugin)

        // When
        project.buildInfo {
            server = 'http://a-different-go-url.com/go/'
        }

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildLink == "http://a-different-go-url.com/go/pipelines/my-pipeline/6/build-stuff/2"
    }

    @Test
    void buildInfoContainsTriggeredBy() {
        // Given
        environment.variables.putAll([
                GO_TRIGGER_USER: 'A person'
        ])

        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.triggeredBy == 'A person'
    }
}
