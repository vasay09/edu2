package edu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

// Utility class for utility method
public class Utils {

    // Utility methods are static because they do not rely on any object
    public static String stringFromFile(String path) throws IOException {
        return Files.readString(Paths.get(path), StandardCharsets.UTF_8);
    }

    public static String jsonFromFile(String path) throws IOException {
        return stringFromFile(path).replaceAll("[\u0000-\u001f]", "");
    }
}
