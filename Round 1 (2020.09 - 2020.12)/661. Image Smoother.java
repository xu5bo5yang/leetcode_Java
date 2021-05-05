/**
 * https://leetcode.com/problems/image-smoother/submissions/
 */
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] result = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                int count = 0;
                
                for(int r = i - 1; r < i + 2; r++) {
                    for(int c = j - 1; c < j + 2; c++) {
                        if (r >= 0 && r < row && c >= 0 && c < col) {
                            sum += M[r][c];
                            count++;
                        }
                    }
                }
                
                result[i][j] = sum / count;
            }
        }
        
        return result;
    }
}