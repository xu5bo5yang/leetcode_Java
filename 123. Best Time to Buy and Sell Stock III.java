/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/
 */
class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MAX_VALUE;
        int secondSell = 0;
        
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            
            firstBuy = Math.min(firstBuy, price);
            firstSell = Math.max(firstSell, price - firstBuy);
            secondBuy = Math.min(secondBuy, price - firstSell);
            secondSell = Math.max(secondSell, price - secondBuy);
        }
        
        return secondSell;
    }
}