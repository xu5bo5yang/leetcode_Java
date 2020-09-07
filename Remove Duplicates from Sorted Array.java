/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        
        int cur = 0;
        int lastNonDup = 0;
        int lastNum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                lastNonDup++;
                lastNum = nums[i];
                nums[lastNonDup] = nums[i];
            }
        }
        
        return lastNonDup + 1;
    }
}