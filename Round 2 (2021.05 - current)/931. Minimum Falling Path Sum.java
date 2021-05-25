class Solution {
    
    private int[][] dp;
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int result = Integer.MAX_VALUE;
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 99999;
            }
        }
        
        for (int i = 0; i < n; i++) {
            result = Math.min(result, findMinPath(matrix, n - 1, i));
        }
                              
        return result;
    }
    
    private int findMinPath(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length) {
            return 11111;
        }
        
        if (i == 0) {
            return matrix[0][j];
        }
        
        if (dp[i][j] != 99999) {
            return dp[i][j];
        }
        
        dp[i][j] = matrix[i][j] + Math.min(findMinPath(matrix, i - 1, j), Math.min(findMinPath(matrix, i - 1, j - 1), findMinPath(matrix, i - 1, j  + 1)));
        
        return dp[i][j];
    }
}