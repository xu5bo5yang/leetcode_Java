/**
 * https://leetcode.com/problems/valid-parentheses/submissions/
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch =='{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char previous = stack.pop();

                    if (!isPair(previous, ch)) {
                        return false;
                    }
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    boolean isPair(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }
}