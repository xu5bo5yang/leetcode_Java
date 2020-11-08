/**
 * https://leetcode.com/problems/non-overlapping-intervals/submissions/
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int j = 0;
        int count = 1;
        int len = intervals.length;
        
        for(int i = 1; i < intervals.length; i++){
            if (intervals[j][1] <= intervals[i][0]) {
                j = i;
                count++;
            }
        }
        
        return intervals.length - count;
    }
}