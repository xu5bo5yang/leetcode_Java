/**
 * https://leetcode.com/problems/jump-game-ii/submissions/
 */
class Solution {
    public int jump(int[] nums) {
        if (nums == null) {
            return -1;
        }
        
        if (nums.length < 2) {
            return 0;
        }
        
        int farthest = 0;
        int end = 0;
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            
            if (i == end) {
                jump++;
                end = farthest;
            }
            
            if (end >= nums.length - 1) {
                break;
            }
        }
        
        if (end < nums.length - 1) {
            return -1;
        } else {
            return jump;
        }
    }
}