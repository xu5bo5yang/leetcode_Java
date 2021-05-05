/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/submissions/
 */
class Solution {
    public int getMoneyAmount(int n) {
        int[][] moneyAmounts = new int[n+1][n+1];
        return findMinMoney(moneyAmounts, 1, n);
    }
    
    int findMinMoney(int[][] moneyAmounts, int low, int high){
        if(low >= high) {
            return 0;
        }
        
        if(moneyAmounts[low][high] != 0) {
            return moneyAmounts[low][high];
        }
        
        int amount = Integer.MAX_VALUE;
        for(int i = low; i <= high; i++){
            int tmp = i + Math.max(findMinMoney(moneyAmounts, low, i-1), findMinMoney(moneyAmounts, i+1, high));
            amount = Math.min(amount, tmp);
        }
        
        moneyAmounts[low][high] = amount;
        return amount;
    }
}