/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int day = 0;
        int buyDay = 0;
        int sellDay = 0;
        
        while(day < prices.length) {
            while(day < prices.length - 1 && prices[day+1] < prices[day]) {
                day++;
            }
            buyDay = day;
            
            while(day < prices.length - 1 && prices[day+1] > prices[day]) {
                day++;
            }
            sellDay = day;
            
            maxProfit += prices[sellDay] - prices[buyDay];
            day++;
        }
        
        return maxProfit;
    }
}