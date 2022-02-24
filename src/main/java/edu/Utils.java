package edu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

// Utility class for utility method
public class Utils {
    static final String DEFAULT_PATH = "src/main/resources/";
    static final String GIVER_FILENAME = "GiverV2.keys.json";
    static final String DEFAULT_JSON_TAG_PUBLIC = "public";
    static final String DEFAULT_JSON_TAG_SECRET = "secret";

    // Utility methods are static because they do not rely on any object
    public static String stringFromFile(String path) throws IOException {
        return Files.readString(Paths.get(path), StandardCharsets.UTF_8);
    }

    public static String jsonFromFile(String path) throws IOException {
        return stringFromFile(path).replaceAll("[\u0000-\u001f]", "");
    }
}
