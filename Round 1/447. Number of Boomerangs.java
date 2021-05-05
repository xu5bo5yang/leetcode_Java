/**
 * https://leetcode.com/problems/number-of-boomerangs/submissions/
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 1 || points[0].length < 1) {
            return 0;
        }
        
        int result = 0;
        Map<Integer, Integer> distanceToPoints = new HashMap();
        
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int distance = getDistanceSquare(points[i], points[j]);                
                distanceToPoints.put(distance, distanceToPoints.getOrDefault(distance, 0) + 1);
            }

            for (int count : distanceToPoints.values()) {
                result += count * (count - 1);
            }            
            
            distanceToPoints.clear();
        }

        return result;
    }
    
    int getDistanceSquare(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }
}