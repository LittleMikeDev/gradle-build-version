package uk.co.littlemike.gradle.build.version
import org.junit.Test

class LocalBuildTests extends AbstractCITest {

    @Test
    void buildInfoShouldContainLocalBuildDetailsIfNoCIEnvironmentVariablesPresent() {
        // When
        project.apply(plugin: BuildVersionPlugin)

        // Then
        BuildInfo buildInfo = project.buildInfo
        assert buildInfo.buildId == "Local build"
        assert buildInfo.revision == "Local copy"
        assert buildInfo.triggeredBy == "Local user"
    }
}
