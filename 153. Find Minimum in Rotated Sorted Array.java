/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] < nums[i]) {
                return nums[i+1];
            }
        }
        
        return nums[0];
    }
}