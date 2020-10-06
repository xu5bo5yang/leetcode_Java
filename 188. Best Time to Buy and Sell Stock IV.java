/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;

        if (k >=  len / 2) {
            int result = 0;
            
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i-1]) {
                    result += prices[i] - prices[i-1];
                }
            }
            return result;
        }
        
        int[][] result = new int[len][k+1];
        
        for (int i = 0; i < len; i++) {
            result[i][0] = 0;
        }
        
        for (int j = 0; j <= k; j++) {
            result[0][j] = 0;
        }
        
        for (int j = 1; j <= k; j++) {
            int profit = result[0][j-1] - prices[0];
            
            for (int i = 1; i < len; i++) {
                result[i][j] = Math.max(result[i-1][j],  prices[i] + profit);
    		    profit = Math.max(profit, result[i][j-1] - prices[i]);
            }
        }
        
        return result[len-1][k];
    }
}