import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Day01 {
    public static void main(String[] args) {
        String input = readInput("inputs/day01.txt");
        // int ans = solvePart1(input);
        int ans = solvePart2(input);
        System.out.println(ans);
    }

    private static String readInput(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file", e);
        }
    }

    private static int solvePart1(String input){

        String[] lines = input.split("\\R");
        int[] l1 = new int[lines.length];
        int[] l2 = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("\\s+"); // Split on one or more spaces
            l1[i] = Integer.parseInt(parts[0]); 
            l2[i] = Integer.parseInt(parts[1]);
        }

        Arrays.sort(l1);
        Arrays.sort(l2);

        int ans = 0;

        for(int i=0; i<lines.length; i++){
            ans += Math.abs(l1[i] - l2[i]);
        }

        return ans;
    }

    private static int solvePart2(String input){
       String[] lines = input.split("\\R");
        int[] l1 = new int[lines.length];
        int[] l2 = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] parts = lines[i].split("\\s+"); // Split on one or more spaces
            l1[i] = Integer.parseInt(parts[0]); 
            l2[i] = Integer.parseInt(parts[1]);
        }
        
        HashMap<Integer, Integer> rightListFreq = new HashMap<>();

        for (int i = 0; i < l2.length; i++) {
            int n = l2[i];
            rightListFreq.put(n, rightListFreq.getOrDefault(n, 0) + 1);
        }

        int ans = 0;

        for(int i=0; i<l1.length; i++){
            int n = l1[i];
            if(rightListFreq.containsKey(n)){
                ans += n*rightListFreq.get(n);
            }
        }

        return ans;
    }

}
