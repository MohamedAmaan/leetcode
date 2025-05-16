import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        // Map to store words by their lengths for quick access
        Map<Integer, List<Integer>> lengthMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lengthMap.computeIfAbsent(words[i].length(), k -> new ArrayList<>()).add(i);
        }

        int maxLength = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> candidates = lengthMap.get(words[i].length());
            for (int j : candidates) {
                if (j >= i) break; // Ensure j < i
                if (groups[i] != groups[j] && hammingDistance(words[i], words[j]) == 1) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
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
                if (distance > 1) break; // Early exit if distance exceeds 1
            }
        }
        return distance;
    }
}
