/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 1) {
            return 0;
        }
        
        int firstStep = cost[0];
        int secondStep = cost[1];
        
        for (int i = 2; i < cost.length; i++) {
            int cur = cost[i] + Math.min(firstStep, secondStep);
            firstStep = secondStep;
            secondStep = cur;
        }
        
        return Math.min(firstStep, secondStep);
    }
}