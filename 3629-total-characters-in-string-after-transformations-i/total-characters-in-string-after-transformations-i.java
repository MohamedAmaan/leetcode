class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];

        // Step 1: Initialize frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 2: Perform t transformations
        for (int i = 0; i < t; i++) {
            long[] newFreq = new long[26];

            // Shift a-y to b-z
            for (int j = 0; j < 25; j++) {
                newFreq[j + 1] = freq[j]; // No modulo needed here yet
            }

            // z → "ab" (i.e., one 'a' and one 'b')
            newFreq[0] = (newFreq[0] + freq[25]) % MOD;
            newFreq[1] = (newFreq[1] + freq[25]) % MOD;

            freq = newFreq; // Reassign for next iteration
        }

        // Step 3: Sum all frequencies to get final length
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total += freq[i];
        }

        return (int)(total % MOD);
    }
}
