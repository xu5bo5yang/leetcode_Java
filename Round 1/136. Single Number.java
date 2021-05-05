/**
 * https://leetcode.com/problems/single-number/submissions/
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        
        return nums[nums.length-1];
    }
}