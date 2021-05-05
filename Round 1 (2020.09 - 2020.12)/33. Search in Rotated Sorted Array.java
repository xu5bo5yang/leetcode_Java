/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        
        if (target == nums[left]) {
            return left;
        }
        
        if (target == nums[right]) {
            return right;
        } 
        
        if (nums[left] < nums[right]) {
            if (target < nums[left] || target > nums[right]) {
                return -1;
            } else {
                int leftResult = binarySearch(nums, left, left + (right-left)/2, target);
                int rightResult = binarySearch(nums, left + (right-left)/2 + 1, right, target);
                
                return leftResult == -1 ? rightResult : leftResult;
            }
        } else {
            int leftResult = binarySearch(nums, left, left + (right-left)/2, target);
            int rightResult = binarySearch(nums, left + (right-left)/2 + 1, right, target);
                
            return leftResult == -1 ? rightResult : leftResult;
        }
    }
}