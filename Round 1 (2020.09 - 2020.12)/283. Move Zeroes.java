/**
 * https://leetcode.com/problems/move-zeroes/submissions/
 */
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        
        int len = nums.length;
        int indexZero = 0;
        int indexNonZero = 0;
        
        while (indexZero < len && indexNonZero < len) {
            while (indexZero < len && nums[indexZero] != 0) {
                indexZero++;
            }
            
            while (indexNonZero < len && nums[indexNonZero] == 0) {
                indexNonZero++;
            }
            
            if (indexZero == len || indexNonZero == len) {
                break;
            }
            
            if (indexZero < indexNonZero) {
                nums[indexZero] = nums[indexNonZero];
                nums[indexNonZero] = 0;
                indexZero++;
            }
            
            indexNonZero++;
        }
    }
}