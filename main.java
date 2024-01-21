import java.io.IOException;
import java.util.List;

import utils.Reader;

public class main {
    public static void main(String[] args) {
        String filePath = "./OK_File.txt";

        try {
            List<String> lines = Reader.read(filePath);

            // Process the lines from the file
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

