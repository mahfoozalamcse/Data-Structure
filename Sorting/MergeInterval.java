package Sorting;
import java.util.*;;
public class MergeInterval {
   
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: List to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Add first interval
        merged.add(intervals[0]);

        // Step 4: Traverse and merge
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = intervals[i];

            // If overlap → merge
            
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current); // No overlap → add
            }
        }

        // Step 5: Convert to 2D array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3}, {2, 4}, {5, 7}, {6, 8}
        };

        int[][] result = merge(intervals);

        // Print result
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
    }
 
}
