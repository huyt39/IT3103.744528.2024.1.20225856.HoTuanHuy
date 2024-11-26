package Lab.OtherProjects.hust.soict.hedspi.Lab01.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "/Users/macbook/Downloads/robots.txt";
        byte[] inputBytes = null;
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Ho Tuan Huy - 20225856: Processing time (using +): " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
