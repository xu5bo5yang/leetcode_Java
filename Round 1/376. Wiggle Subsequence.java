/**
 * https://leetcode.com/problems/wiggle-subsequence/submissions/
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        if (nums.length < 2) {
            return nums.length;
        }
        
        int len = nums.length;
        int[] wiggleUp = new int[len];
        int[] wiggleDown = new int[len];
        wiggleUp[0] = 1;
        wiggleDown[0] = 1;
        
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                wiggleUp[i] = wiggleDown[i - 1] + 1;
                wiggleDown[i] = wiggleDown[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                wiggleDown[i] = wiggleUp[i - 1] + 1;
                wiggleUp[i] = wiggleUp[i - 1];
            } else {
                wiggleDown[i] = wiggleDown[i - 1];
                wiggleUp[i] = wiggleUp[i - 1];
            }
        }
        return Math.max(wiggleDown[len - 1], wiggleUp[len - 1]);
    }
}