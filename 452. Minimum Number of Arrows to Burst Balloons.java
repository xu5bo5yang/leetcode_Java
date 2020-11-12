/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrowIndex = points[0][1];
        int arrowCount = 1;
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arrowIndex) {
                continue;
            }
            
            arrowCount++;
            arrowIndex = points[i][1];
        }
        
        return arrowCount;
    }
}