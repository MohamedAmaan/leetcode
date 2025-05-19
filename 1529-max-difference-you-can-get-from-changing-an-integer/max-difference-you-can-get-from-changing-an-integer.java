class Solution {
    public int maxDiff(int num) {
        // Convert number to string for easy manipulation
        String numStr = String.valueOf(num);

        // Case 1: Maximize the number by replacing a digit with 9
        char[] maxChars = numStr.toCharArray();
        char toReplaceMax = ' ';
        for (char c : maxChars) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        if (toReplaceMax != ' ') {
            for (int i = 0; i < maxChars.length; i++) {
                if (maxChars[i] == toReplaceMax) {
                    maxChars[i] = '9';
                }
            }
        }
        int maxNum = Integer.parseInt(new String(maxChars));

        // Case 2: Minimize the number by replacing a digit with 0 or 1
        char[] minChars = numStr.toCharArray();
        char toReplaceMin = ' ';
        char replaceWith = ' ';
        if (minChars[0] != '1') {
            toReplaceMin = minChars[0];
            replaceWith = '1';
        } else {
            for (int i = 1; i < minChars.length; i++) {
                if (minChars[i] != '0' && minChars[i] != '1') {
                    toReplaceMin = minChars[i];
                    replaceWith = '0';
                    break;
                }
            }
        }

        if (toReplaceMin != ' ') {
            for (int i = 0; i < minChars.length; i++) {
                if (minChars[i] == toReplaceMin) {
                    minChars[i] = replaceWith;
                }
            }
        }

        int minNum = Integer.parseInt(new String(minChars));

        return maxNum - minNum;
    }
}
