/**
 * https://leetcode.com/problems/binary-search/submissions/
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1 || nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    int binarySearch(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }
}