/**
 * https://leetcode.com/problems/non-decreasing-array/submissions/
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        
        int count = 0;                                              
        
        for (int i = 1; i < nums.length && count <= 1 ; i++){
            if (nums[i - 1] > nums[i]) {
                count++;
                
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i-1];
                }
            }
        }
    
        return count <= 1;
    }
}