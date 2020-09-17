/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 1;
        }
        
        boolean duplicate = false;
        int left = 1;
        int index = 1;
        
        while (index < nums.length) {
            if (nums[index] != nums[left-1]) {
                nums[left] = nums[index];
                duplicate = false;
            } else if (duplicate) {
                while (index < nums.length && nums[index] == nums[left-1]) {
                    index++;
                }
                
                if (index == nums.length) {
                    break;
                }
                
                nums[left] = nums[index];
                duplicate = false;
            } else {
                nums[left] = nums[index];
                duplicate = true;
            }
            
            index++;
            left++;
        }
        
        return left;
    }
}