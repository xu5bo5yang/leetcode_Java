/**
 * https://leetcode.com/problems/basic-calculator/submissions/
 */
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int result = 0;
        int sign = 1;
        int number = 0;
        Stack<Integer> results = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                results.push(result);
                results.push(sign);
                
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                result *= results.pop();
                result += results.pop();
                number = 0;
            } else if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else {
                number = number * 10 + (c - '0');
            }
        }
        
        return result + sign * number;
    }
}