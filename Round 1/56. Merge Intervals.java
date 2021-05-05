/**
 * https://leetcode.com/problems/merge-intervals/submissions/
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, new SortArray());
                
        int[] cur = intervals[0];
        List<int[]> result = new ArrayList();
        result.add(cur);
        
        for (int i = 1; i < intervals.length; i++) {
            int preLeft = cur[0];
            int preRight = cur[1];
            int newLeft = intervals[i][0];
            int newRight = intervals[i][1];
            
            if(newLeft > preRight) {
                cur = intervals[i];
                result.add(intervals[i]);
            } else {
                int lastIndex = result.size() - 1;
                int[] newRange = new int[2];
                newRange[0] = Math.min(cur[0], intervals[i][0]);
                newRange[1] = Math.max(cur[1], intervals[i][1]);
                cur = newRange;
                
                result.set(lastIndex, newRange);
            }
        }
        
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            int[] item = result.get(i);
            resultArray[i][0] = item[0];
            resultArray[i][1] = item[1];
        }
        
        return resultArray;
    }
    
    class SortArray implements Comparator<int[]> {
        public int compare(int[] a, int[] b) { 
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return 0;
                } else {
                    return a[1] < b[1] ? -1 : 1;
                }
            } else {
                return a[0] < b[0] ? -1 : 1;
            }
        } 
    } 
}