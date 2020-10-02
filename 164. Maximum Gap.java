/**
 * https://leetcode.com/problems/maximum-gap/solution/
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(result, nums[i+1] - nums[i]);
        }
        
        return result;
    }
}