/**
 * https://leetcode.com/problems/maximum-product-subarray/submissions/
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int result = nums[0];
        int minProduct = nums[0];
        int maxProduct = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tmp = maxProduct;
            maxProduct = Math.max(nums[i], Math.max(nums[i] * maxProduct, nums[i] * minProduct));
            minProduct = Math.min(nums[i], Math.min(nums[i] * tmp, nums[i] * minProduct));
            
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
}