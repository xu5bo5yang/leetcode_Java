/**
 * https://leetcode.com/problems/find-pivot-index/submissions/
 */
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        int left = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (left * 2 == sum - nums[i]) {
                return i;
            }
            
            left += nums[i];
        }
        
        return -1;  
    }
}