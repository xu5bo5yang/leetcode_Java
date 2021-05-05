/**
 * https://leetcode.com/problems/gas-station/submissions/
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int tank = gas[start] - cost[start];
        
        while (end < start) {
            if (tank >= 0) {
                tank += gas[end] - cost[end];
                end++;
            } else {
                start--;
                tank += gas[start] - cost[start];
            }
        }
        
        return tank >= 0 ? start : -1;
    }
}