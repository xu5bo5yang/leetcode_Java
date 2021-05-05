/**
 * https://leetcode.com/problems/target-sum/submissions/
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }

        if (S < -sum || S > sum) {
            return 0;
        }

        int left = 0;
        int right = sum * 2;
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = left; j <= right; j++) {
                if (j + nums[i - 1] <= right) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                
                if (j - nums[i - 1] >= left) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[nums.length][sum + S];
    }
}