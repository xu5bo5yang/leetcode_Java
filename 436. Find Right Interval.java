/**
 * 
 */
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return new int[0];
        }
        
        TreeMap<Integer, Integer> starts = new TreeMap();
        
        for (int i = 0; i < intervals.length; i++) {
            starts.put(intervals[i][0], i);
        }
        
        int[] result = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            Integer nextStart = starts.ceilingKey(intervals[i][1]);
            
            result[i] = nextStart == null ? -1 : starts.get(nextStart);
        }
        
        return result;
    }
}