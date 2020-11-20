/**
 * https://leetcode.com/problems/next-greater-element-ii/submissions/
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1);
        
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                result[stack.pop()] = nums[i % len];
            }
            
            stack.push(i % len);
        }
        
        return result;
    }
}