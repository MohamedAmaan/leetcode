
public class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        // Using difference array for O(q) time complexity for all queries
        int[] delta = new int[n + 1];
        
        // Apply all range updates in O(q) time
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            delta[l]++;
            delta[r + 1]--;
        }
        
        // Check if each element can be decremented to zero in one pass
        int runningSum = 0;
        for (int i = 0; i < n; i++) {
            runningSum += delta[i];
            if (runningSum < nums[i]) {
                return false;
            }
        }
        
        return true;
    }
}