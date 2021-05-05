/**
 * https://leetcode.com/problems/erect-the-fence/submissions/
 */
class Solution {
    public int[][] outerTrees(int[][] points) {
        Set<int[]> result = new HashSet();
        
        int leftMost = getLeftMostXIndex(points);
        int cur = leftMost;
        
        do {
            int next = 0;
            
            for (int i = 0; i < points.length; i++) {
                int orient = orientation(points[cur], points[i], points[next]);
                
                if (orient < 0 || (orient == 0 && inBetween(points[next], points[cur], points[i]))) {
                    next = i;
                }
            }

            for (int i = 0; i < points.length; i++) {
                if (i != cur && i != next && orientation(points[cur], points[i], points[next]) == 0) {
                    result.add(points[i]);
                }
            }

            result.add(points[next]);
            cur = next;
        } while (cur != leftMost);
        
        int[][] resultArray = new int[result.size()][2];
        int i = 0;
        
        for (int[] point : result) {
            resultArray[i] = point;
            i++;
        }
        
        return resultArray;
    }
    
    int getLeftMostXIndex(int[][] points) {
        int leftMost = 0;
        
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] < points[leftMost][0]) {
                leftMost = i;
            }
        }
        
        return leftMost;
    }
    
    int orientation(int[] p, int[] q, int[] r) {
        return Integer.signum((q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]));
    }
    
    boolean inBetween(int[] i, int[] p, int[] q) {
        return (i[0] >= p[0] && i[0] <= q[0] || i[0] <= p[0]&& i[0] >= q[0]) &&
               (i[1] >= p[1] && i[1] <= q[1] || i[1] <= p[1]&& i[1]>= q[1]);
    }
}