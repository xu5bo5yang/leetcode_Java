/**
 * https://leetcode.com/problems/spiral-matrix-ii/submissions/
 */
class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        
        int[][] directions = new int[4][2];
        directions[0] = new int[]{0, 1};
        directions[1] = new int[]{1, 0};
        directions[2] = new int[]{0, -1};
        directions[3] = new int[]{-1, 0};
        
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], 0);
        }
        result[0][0] = 1;
        
        int row = 0;
        int col = 0;
        int turn = 0;
        int[] direction = directions[turn];
        
        for (int i = 0; i < n*n - 1; i++) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if (newCol >= n || newCol < 0 || newRow >= n || newRow < 0 || result[newRow][newCol] != 0) {
                turn++;
                direction = directions[turn % 4];
            }
            
            row = row + direction[0];
            col = col + direction[1];
            result[row][col] = i + 2;
        }
        
        return result;
    }
}