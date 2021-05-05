/**
 * https://leetcode.com/problems/minimum-path-sum/submissions/
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] sum = new int[row][col];
        
        sum[row-1][col-1] = grid[row-1][col-1];
        
        for (int i = col-2; i >= 0; i--) {
            sum[row-1][i] = sum[row-1][i+1] + grid[row-1][i];
        }
        
        for (int i = row-2; i >= 0; i--) {
            sum[i][col-1] = sum[i+1][col-1] + grid[i][col-1];
        }
        
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                sum[i][j] = grid[i][j] + Math.min(sum[i+1][j], sum[i][j+1]);
            }
        }
        
        return sum[0][0];
    }
}