/**
 * https://leetcode.com/problems/find-peak-element/submissions/
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
                
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }
        
        return nums.length - 1;
    }
}