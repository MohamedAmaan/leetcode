import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        Integer prevGroup = null;

        for (int i = 0; i < words.length; i++) {
            if (prevGroup == null || groups[i] != prevGroup) {
                result.add(words[i]);
                prevGroup = groups[i];
            }
        }

        return result;
    }
}
