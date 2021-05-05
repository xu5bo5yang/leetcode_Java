/**
 * https://leetcode.com/problems/132-pattern/submissions/
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        Stack<Integer> stack = new Stack();
        int max = Integer.MIN_VALUE;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max = stack.pop();
            }
            
            if (max < nums[i]) {
                stack.push(nums[i]);
            } else if (nums[i] < max) {
                return true;
            }
        }
        
        return false;
    }
}