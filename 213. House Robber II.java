/**
 * https://leetcode.com/problems/house-robber-ii/submissions/
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int prevRobbed = 0;
        int prevNotRobbed = 0;
        int result = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            int curRobbed = prevNotRobbed + nums[i];
            int curNotRobbed = Math.max(prevNotRobbed, prevRobbed);
            
            prevRobbed = curRobbed;
            prevNotRobbed = curNotRobbed;
        }
        
        result = Math.max(prevRobbed, prevNotRobbed);
        
        prevRobbed = 0;
        prevNotRobbed = 0;
        
        for (int i = 1; i < nums.length; i++) {
            int curRobbed = prevNotRobbed + nums[i];
            int curNotRobbed = Math.max(prevNotRobbed, prevRobbed);
            
            prevRobbed = curRobbed;
            prevNotRobbed = curNotRobbed;
        }
        
        return Math.max(result, Math.max(prevRobbed, prevNotRobbed));
    }
}