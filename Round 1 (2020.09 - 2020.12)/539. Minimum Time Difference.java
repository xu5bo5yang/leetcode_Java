/**
 * https://leetcode.com/problems/minimum-time-difference/submissions/
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) {
            return 0;
        }
        
        int len = timePoints.size();
        int[] times = new int[len];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            String timePoint = timePoints.get(i);
            times[i] = Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3, 5));
        }
        
        Arrays.sort(times);
        
        for (int i = 1; i < len; i++) {
            result = Math.min(result, times[i] - times[i - 1]);
        }
        
        result = Math.min(result, times[0] + (24 * 60 - times[len - 1]));
        
        return result;
    }
}