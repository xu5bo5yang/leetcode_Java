/**
 * https://leetcode.com/problems/sort-colors/submissions/
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        
        int firstWhite = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            if (nums[left] == 0) {
                if (firstWhite == left) {
                    left++;
                    firstWhite++;
                } else {
                    swap(nums, firstWhite, left);
                    firstWhite++;
                }
            } else if (nums[left] == 2) {
                while (left < right && nums[right] == 2) {
                    right--;
                }
                
                if (left == right) {
                    break;
                }
                
                swap(nums, left, right);
            } else {
                left++;
            }
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}