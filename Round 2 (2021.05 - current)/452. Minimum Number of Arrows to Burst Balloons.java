class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 1) {
            return 0;
        }
        
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] < b[1] ? -1 : a[1] == b[1] ? 0 : 1;
            }
        });
        
        int count = 1;
        int end = points[0][1];
        
        for (int[] point : points) {
            int start = point[0];
            
            if (start > end) {
                count++;
                end = point[1];
            }
        }
        
        return count;
    }
}