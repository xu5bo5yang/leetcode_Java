/**
 * https://leetcode.com/problems/single-number-ii/submissions/
 */
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i += 3) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        
        return nums[nums.length-1];
    }
}