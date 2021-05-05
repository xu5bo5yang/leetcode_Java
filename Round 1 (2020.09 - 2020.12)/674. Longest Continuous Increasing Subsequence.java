/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/submissions/
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int index = 0;
        int max = 0;
        
        while (index < nums.length) {
            int cur = index + 1;
            
            while (cur < nums.length && nums[cur] > nums[cur - 1]) {
                cur++;
            }
            
            max = Math.max(max, cur - index);
            index = cur;
        }
        
        return max;
    }
}