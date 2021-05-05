/**
 * https://leetcode.com/problems/coin-change/submissions/
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        result[0] = 0;
        
        Arrays.sort(coins);
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                result[i] = Math.min(result[i], result[i - coins[j]] + 1);
            }
        }
        
        return result[amount] > amount ? -1 : result[amount];
    }
}