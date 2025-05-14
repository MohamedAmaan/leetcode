import java.util.List;

public class Solution {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t, List<Integer> numsList) {
        // Convert List<Integer> to int[] for easier access
        int[] nums = new int[26];
        for (int i = 0; i < 26; i++) {
            nums[i] = numsList.get(i);
        }

        if (t == 0) {
            return s.length() % MOD;
        }

        // Build the transition matrix
        long[][] M = new long[26][26];
        for (int i = 0; i < 26; i++) {
            int k = nums[i];
            for (int step = 1; step <= k; step++) {
                int j = (i + step) % 26;
                M[i][j] = (M[i][j] + 1) % MOD;
            }
        }

        // Matrix exponentiation: M^(t-1)
        long[][] M_exp = matrixPower(M, t - 1);

        // Initial count vector
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Multiply count vector by M_exp
        long[] countAfter = multiplyVector(count, M_exp);

        // Calculate the final length
        long sum = 0;
        for (int j = 0; j < 26; j++) {
            sum = (sum + countAfter[j] * nums[j]) % MOD;
        }

        return (int) sum;
    }

    // Matrix exponentiation
    private long[][] matrixPower(long[][] matrix, int power) {
        long[][] result = new long[26][26];
        for (int i = 0; i < 26; i++) {
            result[i][i] = 1;
        }
        while (power > 0) {
            if ((power & 1) == 1) {
                result = matrixMultiply(result, matrix);
            }
            matrix = matrixMultiply(matrix, matrix);
            power >>= 1;
        }
        return result;
    }

    // Matrix multiplication
    private long[][] matrixMultiply(long[][] a, long[][] b) {
        long[][] res = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }

    // Vector-matrix multiplication
    private long[] multiplyVector(long[] vector, long[][] matrix) {
        long[] res = new long[26];
        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < 26; i++) {
                res[j] = (res[j] + vector[i] * matrix[i][j]) % MOD;
            }
        }
        return res;
    }
}
