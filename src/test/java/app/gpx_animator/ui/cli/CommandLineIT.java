package app.gpx_animator.ui.cli;

import app.gpx_animator.Main;
import app.gpx_animator.MemoryAppender;
import app.gpx_animator.core.renderer.Renderer;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

final class CommandLineIT {

    private MemoryAppender memoryAppender = null;

    private void assertDone() {
        final var done = memoryAppender.search("Done", Level.INFO).get(0).getMessage().contains("Movie written to");
        assertTrue(done, "Rendering not finished successfully! Check console and log output.");
    }

    @BeforeEach
    public void beforeEachTest() {
        final var logger = (Logger) LoggerFactory.getLogger(Renderer.class);
        memoryAppender = new MemoryAppender();
        memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
        logger.setLevel(Level.DEBUG);
        logger.addAppender(memoryAppender);
        memoryAppender.start();
    }

    @Test
    void testBasicCommandLine() throws Exception {
        final var outputFile = FileTestHelper.getTemporaryOutputFile();
        final var args = new String[]{
                "--input", FileTestHelper.checkFileSeparator("./src/test/resources/gpx/bikeride.gpx"),
                "--output", outputFile
        };

        Main.start(args);
        assertDone();

        final var fileSize = new File(outputFile).length();
        assertTrue(fileSize > 150_000, "Output file size (%s bytes) too small, check content".formatted(fileSize));
        assertTrue(fileSize < 350_000, "Output file size (%s bytes) too big, check content".formatted(fileSize));
    }

    @AfterEach
    public void afterEachTest() {
        memoryAppender.stop();
        memoryAppender.reset();
    }

}
