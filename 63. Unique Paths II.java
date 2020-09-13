/**
 * https://leetcode.com/problems/unique-paths-ii/submissions/
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] grid = new int[m][n];
        grid[m-1][n-1] = obstacleGrid[m-1][n-1] == 1 ? 0 : 1;
        
        for (int i = n-2; i >= 0; i--) {
            grid[m-1][i] = obstacleGrid[m-1][i] == 1 ? 0 : grid[m-1][i+1];
        }
        
        for (int i = m-2; i >= 0; i--) {
            grid[i][n-1] = obstacleGrid[i][n-1] == 1 ? 0 : grid[i+1][n-1];
        }
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                grid[i][j] = obstacleGrid[i][j] == 1 ? 0 : grid[i+1][j] + grid[i][j+1];
            }
        }
        
        return grid[0][0];
    }
}