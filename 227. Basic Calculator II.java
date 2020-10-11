/**
 * https://leetcode.com/problems/basic-calculator-ii/submissions/
 */
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        char sign = '+';
        int number = 0;
        Stack<Integer> stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            
            if ((!Character.isDigit(c) && c != ' ') || 
                i == s.length() - 1) {
                if (sign == '*') {
                    int prev = stack.pop();
                    prev *= number;
                    stack.push(prev);
                } else if (sign == '/') {
                    int prev = stack.pop();
                    prev /= number;
                    stack.push(prev);
                } else if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    number *= -1;
                    stack.push(number);
                } 
                
                sign = c;
                number = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}