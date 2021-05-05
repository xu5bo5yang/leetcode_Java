/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/submissions/
 */
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        
        int max = -1;
        int second = -1;
        int result = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                result = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        
        return max >= 2 * second ? result : -1;
    }
}