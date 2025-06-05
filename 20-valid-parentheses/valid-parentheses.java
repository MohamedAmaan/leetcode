import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push its pair
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket
            else {
                // If stack empty or top doesn't match
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        // At the end, stack should be empty if valid
        return stack.isEmpty();
    }
}
