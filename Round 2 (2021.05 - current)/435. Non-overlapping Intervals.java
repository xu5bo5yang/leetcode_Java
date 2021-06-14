class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 1) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int count = 1;
        int end = intervals[0][1];
        
        for (int[] interval : intervals) {
            int start = interval[0];
            
            if (start >= end) {
                count++;
                end = interval[1];
            }
        }
        
        return intervals.length - count;
    }
}