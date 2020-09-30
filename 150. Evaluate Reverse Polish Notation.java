/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack();
        int value;
        int num;
        
        for (String token : tokens) {
            if (token.equals("+")) {
                num = nums.pop();
                value = nums.pop();
                value += num;
                nums.push(value);
            } else if (token.equals("-")) {              
                num = nums.pop();
                value = nums.pop();
                value -= num;
                nums.push(value);
            } else if (token.equals("*")) {
                num = nums.pop();
                value = nums.pop();
                value *= num;
                nums.push(value);
            } else if (token.equals("/")) {
                num = nums.pop();
                value = nums.pop();
                value /= num;
                nums.push(value);
            } else {
                nums.push(Integer.valueOf(token));
            }
        }
        
        return nums.pop();
    }
}