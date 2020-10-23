/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
 */
class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] results = new int[m][n];
        int maxPath = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = findLongestPath(matrix, i, j, m, n, results);
                maxPath = Math.max(maxPath, len);
            }
        }   
        return maxPath;
    }
    
    int findLongestPath(int[][] matrix, int i, int j, int m, int n, int[][] results) {
        if(results[i][j] != 0) {
            return results[i][j];
        }
        
        int maxPath = 1;
        
        for(int[] direction: directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            
            int len = 1 + findLongestPath(matrix, x, y, m, n, results);
            maxPath = Math.max(maxPath, len);
        }
        
        results[i][j] = maxPath;
        
        return maxPath;
    }
}