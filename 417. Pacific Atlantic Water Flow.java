/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/submissions/
 */
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList();
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] count = new int[m][n];
       
        for (int i = 0; i < m; i++) {
            flow(matrix, i, 0, count, 0, 1);
            flow(matrix, i, n - 1, count, 0, 2);
        }
        
        for (int j = 0; j < n; j++) {
            flow(matrix, 0, j, count, 0, 1);
            flow(matrix, m - 1, j, count, 0, 2);
        }

        List<List<Integer>> results = new ArrayList();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 3) {
                    List<Integer> result = new ArrayList();
                    result.add(i);
                    result.add(j);
                    
                    results.add(result);
                }
            }
        }
        
        return results;
    }
    
    void flow(int[][] matrix, int row, int col, int[][] count, int prev, int val) {
        if (row < 0. || row == matrix.length || col < 0 || col == matrix[row].length) {
            return;
        }
        
        if (count[row][col] == val || count[row][col] == 3 || matrix[row][col] < prev) {
            return;
        }
        
        count[row][col] += val;
        
        flow(matrix, row + 1, col, count, matrix[row][col], val);
        flow(matrix, row - 1, col, count, matrix[row][col], val);
        flow(matrix, row, col + 1, count, matrix[row][col], val);
        flow(matrix, row, col - 1, count, matrix[row][col], val);
    }
}
