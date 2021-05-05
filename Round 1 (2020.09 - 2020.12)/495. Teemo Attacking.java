/**
 * https://leetcode.com/problems/teemo-attacking/submissions/
 */
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length < 1 || duration < 1) {
            return 0;
        }
        
        int result = 0;
        
        for (int i = 0; i < timeSeries.length - 1; i++) {
            result += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        
        result += duration;
        
        return result;
    }
}