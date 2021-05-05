/**
 * https://leetcode.com/problems/diagonal-traverse/submissions/
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        
        int dir = 1;
        int[] nextDir = new int[2];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int i = 0;
        int j = 0;
        boolean reachEdge = false;
        
        for (int k = 0; k < m * n; k++) {
            result[k] = matrix[i][j];

            int nextI = i + (dir == 1 ? -1 : 1);
            int nextJ = j + (dir == 1 ? 1 : -1);

            if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n) {
                if (dir == 1) {
                    i += (j == n - 1 ? 1 : 0) ;
                    j += (j < n - 1 ? 1 : 0); 
                } else {
                    j += (i == m - 1 ? 1 : 0);
                    i += (i < m - 1 ? 1 : 0);
                }
                
                dir = -dir;        
                        
            } else {
                i = nextI;
                j = nextJ;
            }
        }
        
        return result;
    }
}