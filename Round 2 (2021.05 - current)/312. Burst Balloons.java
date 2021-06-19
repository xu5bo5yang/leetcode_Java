class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] ballons = new int[n + 2];
        
        ballons[0] = 1;
        ballons[n + 1] = 1;

        for (int i = 1; i < n + 1; i++) {
            ballons[i] = nums[i - 1];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + ballons[i] * ballons[j] * ballons[k]);
                }
            }
        }
        
        return dp[0][n + 1];
    }
}