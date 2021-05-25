class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // If A is the set of nums with +,
        // B is the set of nums with -,
        // then Sum_A - Sum_B = S -> Sum_A = S + Sum_B
        // -> 2 * Sum_A = S + Sum_B + Sum_A = S + Sum_nums
        
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        
        return findWays(nums, (sum + S) / 2);
    }
    
    private int findWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][target];
    }
}