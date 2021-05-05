/**
 * https://leetcode.com/problems/longest-increasing-subsequence/submissions/
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] lengths = new int[nums.length];
        lengths[0] = 1;
        
        int result = 1;
        
        for (int i = 1; i < lengths.length; i++) {
            int tmpMax = 0;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmpMax = Math.max(tmpMax, lengths[j]);
                }
            }
            
            lengths[i] = tmpMax + 1;
            
            result = Math.max(result, lengths[i]);
        }
        
        return result;
    }
}