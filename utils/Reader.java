package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;


public class Reader {
    public static List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}

