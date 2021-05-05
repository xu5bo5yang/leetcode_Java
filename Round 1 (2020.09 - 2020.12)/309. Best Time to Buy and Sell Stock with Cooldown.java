/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/
 */
class Solution {
    public int maxProfit(int[] prices) {
        int preProfit = 0; 
        int profit = 0;
        int profitAfterBuy = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            int temp = profit;
            
            profit = Math.max(profit, profitAfterBuy + prices[i]);
            profitAfterBuy = Math.max(profitAfterBuy, preProfit - prices[i]);
            preProfit = temp;
        }
        
        return profit;
    }
}