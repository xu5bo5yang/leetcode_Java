/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int[] result = new int[2];
        result[0] = binarySearch(nums, 0, nums.length-1, target, true);
        result[1] = binarySearch(nums, 0, nums.length-1, target, false);
        
        return result;
    }
    
    int binarySearch(int[] nums, int left, int right, int target, boolean findSmaller) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        } else if (nums[left] > target || nums[right] < target) {
            return -1;
        } else {
            int leftResult = binarySearch(nums, left, left + (right-left)/2, target, findSmaller);
            int rightResult = binarySearch(nums, left + (right-left)/2 + 1, right, target, findSmaller);
            
            if (leftResult == -1) {
                return rightResult;
            } else if (rightResult == -1) {
                return leftResult;
            } else {
                return findSmaller ? leftResult : rightResult;
            }
        }
    }
}