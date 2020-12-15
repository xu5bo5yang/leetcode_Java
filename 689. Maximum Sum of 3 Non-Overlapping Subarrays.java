/**
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/submissions/
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < 3 * k) {
            return new int[0];
        }
        
        int len = nums.length;        
        int[] result = new int[3];
        int[] sums = new int[len + 1];
        int[][] dp = new int[4][len + 1];
        int[][] pos = new int[4][len + 1];
        
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        for (int i = 1; i <= 3; i++) {
            for (int j = k * i; j <= len; j++) {
                int curSum = sums[j] - sums[j - k] + dp[i - 1][j - k];
                
                if (curSum > dp[i][j - 1]) {
                    dp[i][j] = curSum;
                    pos[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    pos[i][j] = pos[i][j - 1];              
                }
            }
        }
        
        int index = len;
        
        for (int i = 2; i >= 0; i--) {
            result[i] = pos[i + 1][index];
            index = result[i];
        }
        
        return result;
    }
}