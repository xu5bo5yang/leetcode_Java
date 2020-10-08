/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            while (sum >= s) {
                result = Math.min(result, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}