package app.gpx_animator.ui.cli;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;

public class FileTestHelper {

    static String checkFileSeparator(@SuppressWarnings("SameParameterValue") final String path) {
        return System.getProperty("os.name").toLowerCase(Locale.getDefault()).startsWith("windows")
                ? path.replaceAll("/", Matcher.quoteReplacement(File.separator))
                : path;
    }

    static String getTemporaryOutputFile() throws IOException {
        final var output = File.createTempFile("gpx-animator-test_", ".mp4");
        output.deleteOnExit();
        return output.getAbsolutePath();
    }
}
