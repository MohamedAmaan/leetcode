import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int palindromeLength = 0;
        boolean hasMiddlePalindrome = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            
            // If reverse word exists in map, pair them to form a palindrome
            if (map.getOrDefault(reversed, 0) > 0) {
                palindromeLength += 4;  // each pair contributes 4 characters
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check if any palindromic word like "gg", "cc", etc. can be used in the middle
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                hasMiddlePalindrome = true;
                break;
            }
        }

        // One such middle word can be added (like "gg") which adds 2 characters
        if (hasMiddlePalindrome) {
            palindromeLength += 2;
        }

        return palindromeLength;
    }
}
