import java.util.*;

public class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // Sort queries by start index ascending
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        // Max-heap of available query ends (queries that can still be activated)
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap of running query ends (currently active queries)
        PriorityQueue<Integer> running = new PriorityQueue<>();

        int queryIndex = 0;

        for (int i = 0; i < n; i++) {
            // Add all queries that start at or before i to available heap
            while (queryIndex < m && queries[queryIndex][0] <= i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }

            // Remove expired queries from running heap
            while (!running.isEmpty() && running.peek() < i) {
                running.poll();
            }

            // Activate queries until coverage at i is sufficient
            while (running.size() < nums[i]) {
                if (available.isEmpty() || available.peek() < i) {
                    // No available query to cover position i
                    return -1;
                }
                // Move query from available to running
                running.offer(available.poll());
            }
        }

        // Remaining queries in available heap can be removed
        return available.size();
    }
}
