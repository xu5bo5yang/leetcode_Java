class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, tmp - prices[i]);
        }
        
        return dp0;
    }
}