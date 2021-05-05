/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/submissions/
 */
class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int len = nums.length;
        
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }
}