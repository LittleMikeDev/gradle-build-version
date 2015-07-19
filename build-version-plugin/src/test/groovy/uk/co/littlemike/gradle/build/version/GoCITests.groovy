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
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

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
        project.apply(plugin: 'uk.co.littlemike.build-version-plugin')

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.revision == "Revision 1"
    }
}
