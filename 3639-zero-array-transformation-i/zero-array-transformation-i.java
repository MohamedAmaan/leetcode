public class Solution {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] delta = new int[n + 1];  // range update difference array

        // Step 1: Range update using difference array
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            delta[l] += 1;
            if (r + 1 < n) delta[r + 1] -= 1;
        }

        // Step 2: Check if each element can be decremented to zero
        int currentFreq = 0; // This will hold the current frequency from the difference array
        for (int i = 0; i < n; i++) {
            currentFreq += delta[i]; // Update current frequency
            if (currentFreq < nums[i]) { // Check if we can decrement nums[i] to zero
                return false;
            }
        }

        return true; // All elements can be decremented to zero
    }
}