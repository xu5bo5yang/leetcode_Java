/**
 * https://leetcode.com/problems/01-matrix/submissions/
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return matrix;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0;
                }
                else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            
            for (int[] dir : dirs) {
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];
                
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    result[r][c] <= result[cell[0]][cell[1]] + 1) {
                    continue;
                }
                
                queue.add(new int[]{r, c});
                result[r][c] = result[cell[0]][cell[1]] + 1;
            }
        }
        
        return result;
    }
}