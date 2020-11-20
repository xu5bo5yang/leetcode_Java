/**
 * https://leetcode.com/problems/max-consecutive-ones/submissions/
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int left = 0;
        int result = 0;
        
        while (left < nums.length) {
            while (left < nums.length && nums[left] == 0) {
                left++;
            }
            
            int right = left;
            
            while (right < nums.length && nums[right] == 1) {
                right++;
            }
            
            result = Math.max(result, right - left);
            left = right + 1;
        }
        
        return result;
    }
}