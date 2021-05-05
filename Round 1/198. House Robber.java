/**
 * https://leetcode.com/problems/house-robber/submissions/
 */
class Solution {
    public int rob(int[] nums) {
        int prevRobbed = 0;
        int prevNotRobbed = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int curRobbed = prevNotRobbed + nums[i];
            int curNotRobbed = Math.max(prevNotRobbed, prevRobbed);
            
            prevRobbed = curRobbed;
            prevNotRobbed = curNotRobbed;
        }
        
        return Math.max(prevRobbed, prevNotRobbed);
    }
}