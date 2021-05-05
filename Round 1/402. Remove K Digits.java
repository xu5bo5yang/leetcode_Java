/**
 * https://leetcode.com/problems/remove-k-digits/submissions/
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() < 1 || num.length() <= k) {
            return "0";
        }
        
        Stack<Character> stack = new Stack();
        int index = 0;

        while (index < num.length()) {
            while (k > 0 && !stack.isEmpty() && num.charAt(index) < stack.peek()){
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(index));
            index++;
        }
        
        while (0 < k) {
            stack.pop();
            k--;            
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        result.reverse();
        
        while(1 < result.length() && result.charAt(0)=='0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}