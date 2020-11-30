/**
 * https://leetcode.com/problems/array-partition-i/submissions/
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int result = 0;
        
        for (int i = nums.length - 2; i >= 0; i -= 2) {
            result += nums[i];
        }
        
        return result;
    }
}