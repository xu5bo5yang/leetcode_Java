/**
 * https://leetcode.com/problems/set-intersection-size-at-least-two/submissions/
 */
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b)-> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);

        int result = 0;
        int left = intervals[0][1] - 1;
        int right = intervals[0][1];
        
        result += 2;
        
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            
            if (left < cur[0] && cur[0] <= right) {
                result++;
                left = right;
                right = cur[1];
            } else if (cur[0] > right) {
                result += 2;
                left = cur[1] - 1;
                right = cur[1];
            }
        }
        
        return result;
    }
}