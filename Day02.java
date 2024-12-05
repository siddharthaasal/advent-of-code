import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Day02 {
    public static void main(String[] args) {
        String input = readInput("inputs/day02.txt");
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
        String[] lines = input.split("\\R");
        int ans = 0;
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("\\s+"); // Split on one or more spaces
            ans += part1Helper(parts);
        }
        return ans;
    }

    private static int solvePart2(String input) {
        String[] lines = input.split("\\R");
        int ans = 0;
        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("\\s+"); // Split on one or more spaces
            ans += part2Helper(parts);
        }
        return ans;
    }

    private static int part1Helper(String[] parts) {
        int[] nums = Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isIncreasing = nums[1] > nums[0];

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return 0; // Invalid difference
            }

            // Check if the order matches the expected direction
            if ((isIncreasing && nums[i] < nums[i - 1]) ||
                    (!isIncreasing && nums[i] > nums[i - 1])) {
                return 0; // Order mismatch
            }
        }

        return 1;
    }

    private static int part2Helper(String[] parts) {
        // Convert parts to integers for easier processing
        int[] nums = Arrays.stream(parts)
                .mapToInt(Integer::parseInt)
                .toArray();

        // Base check: is the sequence already valid?
        if (isValidSequence(nums)) {
            return 1; // Safe without removing any level
        }

        // Try removing each element and check if the sequence becomes valid
        for (int i = 0; i < nums.length; i++) {
            // Create a new sequence with the ith element removed
            int[] modified = new int[nums.length - 1];
            for (int j = 0, k = 0; j < nums.length; j++) {
                if (j != i) {
                    modified[k++] = nums[j];
                }
            }

            // Check if the modified sequence is valid
            if (isValidSequence(modified)) {
                return 1; // Safe by removing one level
            }
        }

        return 0; // Unsafe regardless of removal
    }

    // Helper function to validate a sequence
    private static boolean isValidSequence(int[] nums) {
        if (nums.length < 2) {
            return true; // A single number or empty input is trivially valid
        }

        boolean isIncreasing = nums[1] > nums[0];

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            // Check if the difference is invalid
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false; // Invalid difference
            }

            // Check for order mismatch
            if ((isIncreasing && nums[i] < nums[i - 1]) ||
                    (!isIncreasing && nums[i] > nums[i - 1])) {
                return false; // Order mismatch
            }
        }

        return true; // Sequence is valid
    }

}
