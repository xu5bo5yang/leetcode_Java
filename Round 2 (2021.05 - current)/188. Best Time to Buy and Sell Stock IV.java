class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        
        for (int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        
        return dp[n - 1][k][0];
    }
}