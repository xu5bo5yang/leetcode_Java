/**
 * https://leetcode.com/problems/container-with-most-water/submissions/
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int currentMax = 0;
        
        while (left < right) {
            currentMax = Math.max(currentMax, Math.min(height[left], height[right]) * (right - left));
            
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        
        return currentMax;
    }
}