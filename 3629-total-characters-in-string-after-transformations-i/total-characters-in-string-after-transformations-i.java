class Solution {
    static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long[] newFreq = new long[26];

            for (int j = 0; j < 25; j++) {
                newFreq[j + 1] = (newFreq[j + 1] + freq[j]) % MOD;
            }

            newFreq[0] = (newFreq[0] + freq[25]) % MOD;
            newFreq[1] = (newFreq[1] + freq[25]) % MOD;

            freq = newFreq;
        }

        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + freq[i]) % MOD;
        }

        return (int) total;
    }
}
