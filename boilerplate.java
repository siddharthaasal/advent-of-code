import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class boilerplate {
    public static void main(String[] args) {
        String input = readInput("inputs/day01.txt");
        int ans1 = solvePart1(input);
        int ans2 = solvePart2(input);
        System.out.println(ans1 + " " + ans2);
    }

    private static String readInput(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file", e);
        }
    }

    private static int solvePart1(String input) {
        return 0;
    }

    private static int solvePart2(String input) {
        return 0;
    }

}
