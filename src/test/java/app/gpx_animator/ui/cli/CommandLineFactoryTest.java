package app.gpx_animator.ui.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommandLineFactoryTest {

    @Test
    void parseMultipleInputFiles() throws Exception {
        // given
        final var args = new String[]{
                "--input", FileTestHelper.checkFileSeparator("./src/test/resources/gpx/bikeride.gpx"),
                FileTestHelper.checkFileSeparator("./src/test/resources/gpx/bikeride.gpx"),
                "--output", FileTestHelper.getTemporaryOutputFile()
        };

        // when
        var commandLineFactory = new CommandLineConfigurationFactory(args);

        // then

        assertEquals(2, commandLineFactory.getConfiguration().getTrackConfigurationList().size());
        assertEquals(commandLineFactory.getConfiguration().getTrackConfigurationList().get(0).getLabel())
    }
}
