/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    
    int binarySearch(int[] nums, int left, int right) {
        if (right - left < 2) {
            return nums[left];
        }
        
        int mid = left + (right - left) / 2;
        
        if (mid % 2 != 0) {
            mid--;
        }
        
        if (nums[mid] == nums[mid + 1]) {
            left = mid + 2;
        } else {
            right = mid;
        }
        
        return binarySearch(nums, left, right);
    }
}