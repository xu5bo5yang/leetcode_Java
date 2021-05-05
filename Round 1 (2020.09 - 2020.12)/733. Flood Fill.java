/**
 * https://leetcode.com/problems/flood-fill/submissions/
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            fill(image, sr, sc, image[sr][sc], newColor);
        }
        
        return image;
    }
    
    void fill(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }
        
        image[i][j] = newColor;
        
        fill(image, i - 1, j, oldColor, newColor);
        fill(image, i + 1, j, oldColor, newColor);
        fill(image, i, j - 1, oldColor, newColor);
        fill(image, i, j + 1, oldColor, newColor);
    }
}