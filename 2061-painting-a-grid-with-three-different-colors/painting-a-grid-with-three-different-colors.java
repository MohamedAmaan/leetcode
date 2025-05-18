import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        // Generate valid states and their color sequences
        List<Integer> validStates = new ArrayList<>();
        List<int[]> colorSequences = new ArrayList<>();
        for (int state = 0; state < (int) Math.pow(3, m); state++) {
            if (isValid(state, m)) {
                validStates.add(state);
                colorSequences.add(getColors(state, m));
            }
        }
        int k = validStates.size();
        if (k == 0 || n == 1) return k;

        // Precompute compatible state indices
        List<Integer>[] transitions = new List[k];
        for (int i = 0; i < k; i++) {
            transitions[i] = new ArrayList<>();
            int[] c1 = colorSequences.get(i);
            for (int j = 0; j < k; j++) {
                if (isCompatible(c1, colorSequences.get(j))) {
                    transitions[i].add(j);
                }
            }
        }

        // Array-based DP
        int[] dp = new int[k];
        Arrays.fill(dp, 1);
        
        for (int col = 1; col < n; col++) {
            int[] next = new int[k];
            for (int i = 0; i < k; i++) {
                long sum = 0;
                for (int j : transitions[i]) {
                    sum += dp[j];
                    if (sum >= MOD) sum -= MOD;
                }
                next[i] = (int) sum;
            }
            dp = next;
        }

        // Calculate final result
        long total = 0;
        for (int val : dp) {
            total = (total + val) % MOD;
        }
        return (int) total;
    }

    // Check column validity
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

    // Get color sequence for a state
    private int[] getColors(int state, int m) {
        int[] colors = new int[m];
        for (int i = 0; state > 0; i++, state /= 3) {
            colors[i] = state % 3;
        }
        return colors;
    }

    // Check row compatibility
    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
