package Lab.OtherProjects.hust.soict.hedspi.Lab01.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "/Users/macbook/Downloads/robots.txt";
        byte[] inputBytes = null;
        long startTime, endTime;
        try {
            // Read all bytes from the file into inputBytes
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            // Use StringBuilder for efficient concatenation
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Ho Tuan Huy - 20225856: Processing time (using StringBuilder): " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
