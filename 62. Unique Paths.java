/**
 * https://leetcode.com/problems/unique-paths/submissions/
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            board[i][n-1] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            board[m-1][i] = 1;
        }
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                board[i][j] = board[i+1][j] + board[i][j+1];
            }
        }
        
        return board[0][0];
    }
}