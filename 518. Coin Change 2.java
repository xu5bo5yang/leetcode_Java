/**
 * https://leetcode.com/problems/coin-change-2/submissions/
 */
class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length < 1) {
            return amount == 0 ? 1 : 0;
        }
        
        int[] result = new int[amount + 1];
        result[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                result[i] += result[i - coin];
            }
        }
        
        return result[amount];
    }
}