/**
 * https://leetcode.com/problems/rotate-image/submissions/
 */
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        
        int length = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                rotatePoint(i, j, length, matrix);
            }
        }
        
        if (matrix.length % 2 != 0) {
            int i = matrix.length / 2;
            for (int j = 0; j < matrix.length / 2; j++) {
                rotatePoint(i, j, length, matrix);
            }
        }
    }
    
    void rotatePoint(int i, int j, int length, int[][] matrix) {
        int tmp = matrix[j][length-i];
        matrix[j][length-i] = matrix[i][j];
                
        int tmp2 = matrix[length-i][length-j];
        matrix[length-i][length-j] = tmp;
                
        tmp = matrix[length-j][i];
        matrix[length-j][i] = tmp2;
                
        matrix[i][j] = tmp;
    }
}