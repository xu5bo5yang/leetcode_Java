/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/solution/
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    boolean binarySearch(int[] nums, int left, int right, int target) {       
        if (right - left <= 1) {
            return nums[left] == target || nums[right] == target;
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[right] > nums[left]) {
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid, right, target);
            } else {
                return binarySearch(nums, left, mid, target);
            }
        } else {
            return binarySearch(nums, left, mid, target) || binarySearch(nums, mid, right, target);
        }
    }
}