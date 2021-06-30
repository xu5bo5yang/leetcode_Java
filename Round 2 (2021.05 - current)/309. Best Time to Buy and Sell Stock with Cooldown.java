class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int tmp = dp1;
            
            dp1 = Math.max(dp1, dp2 + prices[i]);
            dp2 = Math.max(dp2, dp0 - prices[i]);
            dp0 = tmp;
        }
        
        return dp1;
    }
}