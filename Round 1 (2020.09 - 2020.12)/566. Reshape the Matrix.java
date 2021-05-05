/**
 * https://leetcode.com/problems/reshape-the-matrix/submissions/
 */
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length < 1 || nums[0].length < 1 || r < 1 || c < 1) {
            return nums;
        }
        
        int m = nums.length;
        int n = nums[0].length;
        
        if (m * n != r * c) {
            return nums;
        }
        
        int[][] result = new int[r][c];
        int i = 0;
        int j = 0;
        
        for (int p = 0; p < r; p++) {
            for (int q = 0; q < c; q++) {
                result[p][q] = nums[i][j];
                
                j++;
                
                if (j == n) {
                    i++;
                    j = 0;
                }
            }
        }
        
        return result;
    }
}