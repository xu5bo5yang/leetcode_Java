/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/submissions/
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int days = prices.length;
        int[] buy = new int[days];
        int[] sell = new int[days];
        buy[0] = -prices[0] - fee;
        
        for (int i = 1; i < days; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        
        return sell[days - 1];
    }
}