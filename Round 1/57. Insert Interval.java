/**
 * https://leetcode.com/problems/insert-interval/submissions/
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] resultArray = new int[1][2];
            resultArray[0] = newInterval;
            return resultArray;
        }
        
        List<int[]> result = new ArrayList<int[]>();
        int n = intervals.length - 1;
        boolean foundRight = false;
        
        if (intervals[n][1] < newInterval[0]) {
            result = new ArrayList<int[]>(Arrays.asList(intervals));
            result.add(newInterval);
        } else if (newInterval[1] < intervals[0][0]) {
            result = new ArrayList<int[]>(Arrays.asList(intervals));
            result.add(0, newInterval);
        } else {
            int left = newInterval[0];
            int right = newInterval[1];
            int cur = 0;
            
            for(int i = cur; i <= n; i++) {
                if (newInterval[0] <= intervals[i][1]) {
                    cur = i;
                    left = Math.min(newInterval[0], intervals[i][0]);
                    break;
                } else {
                    result.add(intervals[i]);
                }
            }
            
            while(cur <= n && intervals[cur][0] <= newInterval[1]) {
                right = Math.max(intervals[cur][1], newInterval[1]);
                cur++;
            }
            
            int[] newRange = new int[2];
            newRange[0] = left;
            newRange[1] = right;
            result.add(newRange);
            
            for (int i = cur; i <= n; i++) {
                result.add(intervals[i]);
            }
        }
        
        int[][] resultArray = new int[result.size()][2];
        resultArray = result.toArray(resultArray);
        
        return resultArray;
    }
}