import java.util.*;

public class Solution {
    public int colorTheGrid(int m, int n) {
        int MOD = 1_000_000_007;
        int maxState = (int) Math.pow(3, m);

        // Step 1: Generate all valid column states
        List<Integer> validStates = new ArrayList<>();
        for (int state = 0; state < maxState; state++) {
            if (isValid(state, m)) {
                validStates.add(state);
            }
        }

        // Step 2: Precompute compatible state transitions
        Map<Integer, List<Integer>> compatible = new HashMap<>();
        for (int s1 : validStates) {
            compatible.put(s1, new ArrayList<>());
            for (int s2 : validStates) {
                if (areCompatible(s1, s2, m)) {
                    compatible.get(s1).add(s2);
                }
            }
        }

        // Step 3: DP initialization
        Map<Integer, Integer> dp = new HashMap<>();
        for (int state : validStates) {
            dp.put(state, 1);
        }

        // Step 4: DP over columns
        for (int col = 1; col < n; col++) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (int curr : validStates) {
                int ways = 0;
                for (int prev : compatible.get(curr)) {
                    ways = (ways + dp.get(prev)) % MOD;
                }
                nextDp.put(curr, ways);
            }
            dp = nextDp;
        }

        // Step 5: Sum all ways for the last column
        int result = 0;
        for (int ways : dp.values()) {
            result = (result + ways) % MOD;
        }
        return result;
    }

    // Check if a column state is valid (no two adjacent cells have the same color)
    private boolean isValid(int state, int m) {
        int prev = -1;
        for (int i = 0; i < m; i++) {
            int color = state % 3;
            if (color == prev) return false;
            prev = color;
            state /= 3;
        }
        return true;
    }

    // Check if two column states are compatible (no same color in the same row)
    private boolean areCompatible(int s1, int s2, int m) {
        for (int i = 0; i < m; i++) {
            if ((s1 % 3) == (s2 % 3)) return false;
            s1 /= 3;
            s2 /= 3;
        }
        return true;
    }
}
