/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxTmp = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (maxTmp < 0) {
                maxTmp = nums[i];
            } else {
                maxTmp += nums[i];
            }
            
            result = Math.max(result, maxTmp);
        }
        
        return result;
    }
}