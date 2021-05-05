/**
 * https://leetcode.com/problems/maximal-rectangle/submissions/
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[] heights = new int[n];
        Arrays.fill(heights, 0);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            
            result = Math.max(result, largestRectangleArea(heights));
        }
        
        return result;
    }
    
    int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int[] leftMost = new int[heights.length];
        int[] rightMost = new int[heights.length];
        int result = 0;
        
        leftMost[0] = 0;
        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (heights[j] < heights[i]) {
                    break;
                } else {
                    j = leftMost[j];
                }
                
                j--;
            }
            
            leftMost[i] = j + 1;
        }
        
        for (int i = heights.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < heights.length) {
                if (heights[j] < heights[i]) {
                    break;
                } else {
                    j = rightMost[j];
                }
                
                j++;
            }
            
            rightMost[i] = j - 1;
        }
                
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, (rightMost[i] - leftMost[i] + 1) * heights[i]);
        }
        
        return result;
    }
}