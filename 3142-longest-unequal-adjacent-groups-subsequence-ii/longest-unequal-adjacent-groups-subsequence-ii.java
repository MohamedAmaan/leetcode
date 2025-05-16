import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length()) {
                    if (hammingDistance(words[i], words[j]) == 1) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            prev[i] = j;
                        }
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        LinkedList<String> result = new LinkedList<>();
        while (lastIndex != -1) {
            result.addFirst(words[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        return result;
    }

    private int hammingDistance(String s1, String s2) {
        int distance = 0;
        for (int k = 0; k < s1.length(); k++) {
            if (s1.charAt(k) != s2.charAt(k)) {
                distance++;
            }
        }
        return distance;
    }
}
