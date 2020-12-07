/**
 * https://leetcode.com/problems/maximum-average-subarray-i/submissions/
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1 || nums.length < k) {
            return 0;
        }
        
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        
        while (i < k) {
            sum += nums[i];
            i++;
        }
        
        maxSum = sum;
        
        for (i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum * 1.0 / k;
    }
}