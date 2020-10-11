/**
 * https://leetcode.com/problems/maximal-square/submissions/
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maxSquare = new int[m][n];
        int result = 0;
        
        for (int i = 0; i < m; i++) {
            maxSquare[i][0] = matrix[i][0] == '0' ? 0 : 1;
            result = Math.max(result, maxSquare[i][0]);
        }
        
        for (int j = 0; j < n; j++) {
            maxSquare[0][j] = matrix[0][j] == '0' ? 0 : 1;
            result = Math.max(result, maxSquare[0][j]);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    maxSquare[i][j] = 0;
                } else {
                    maxSquare[i][j] = Math.min(maxSquare[i-1][j-1], Math.min(maxSquare[i-1][j], maxSquare[i][j-1])) + 1;
                    
                    result = Math.max(result, maxSquare[i][j]);
                }
            }
        }
        
        return result * result;
    }
}