/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
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