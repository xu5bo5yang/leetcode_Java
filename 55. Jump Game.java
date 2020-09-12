/**
 * https://leetcode.com/problems/jump-game/submissions/
 */
class Solution {
    public boolean canJump(int[] nums) {
        int maxRight = 0;
        int curMax = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(nums[i] + i, curMax);

            if (i == maxRight) { 
                maxRight = curMax;
            }
        }
        
        if (maxRight < nums.length - 1) {
            return false;
        } else {
            return true;
        }
    }
}