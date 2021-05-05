/**
 * https://leetcode.com/problems/next-permutation/submissions/
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        
        int i = nums.length - 2;
        
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            
            swap(nums, i, j - 1);
        }
        
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            swap(nums, j, k);
            j++;
            k--;
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}