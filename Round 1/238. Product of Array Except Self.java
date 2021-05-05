/**
 * https://leetcode.com/problems/product-of-array-except-self/submissions/
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] output = new int[nums.length];
        output[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] *= right * nums[i+1];
            right *= nums[i+1];
        }
        
        return output;
    }
}