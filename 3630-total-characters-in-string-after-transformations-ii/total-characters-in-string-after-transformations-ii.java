import java.util.List;

public class Solution {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t, List<Integer> numsList) {
        int[] nums = new int[26];
        for (int i = 0; i < 26; i++) nums[i] = numsList.get(i);

        // Special case: t == 0, return original length
        if (t == 0) return s.length() % MOD;

        // Special case: t == 1, just sum up the nums for each character in s
        if (t == 1) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum = (sum + nums[c - 'a']) % MOD;
            }
            return sum;
        }

        // Build transition matrix
        int[][] M = new int[26][26];
        for (int i = 0; i < 26; i++) {
            int k = nums[i];
            for (int step = 1; step <= k; step++) {
                int j = (i + step) % 26;
                M[i][j] = (M[i][j] + 1) % MOD;
            }
        }

        // Matrix exponentiation: M^(t-1)
        int[][] M_exp = matrixPower(M, t - 1);

        // Initial count vector
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;

        // Multiply count vector by M_exp
        int[] countAfter = multiplyVector(count, M_exp);

        // Calculate the final length
        long sum = 0;
        for (int j = 0; j < 26; j++) {
            sum = (sum + 1L * countAfter[j] * nums[j]) % MOD;
        }
        return (int) sum;
    }

    // Matrix exponentiation
    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) result[i][i] = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            power >>= 1;
        }
        return result;
    }

    // Matrix multiplication with zero-skipping
    private int[][] matrixMultiply(int[][] a, int[][] b) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                int aik = a[i][k];
                if (aik == 0) continue;
                for (int j = 0; j < 26; j++) {
                    res[i][j] = (int)((res[i][j] + 1L * aik * b[k][j]) % MOD);
                }
            }
        }
        return res;
    }

    // Vector-matrix multiplication
    private int[] multiplyVector(int[] vector, int[][] matrix) {
        int[] res = new int[26];
        for (int j = 0; j < 26; j++) {
            long sum = 0;
            for (int i = 0; i < 26; i++) {
                sum = (sum + 1L * vector[i] * matrix[i][j]) % MOD;
            }
            res[j] = (int) sum;
        }
        return res;
    }
}
