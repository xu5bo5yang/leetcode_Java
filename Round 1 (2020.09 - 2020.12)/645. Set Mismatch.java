/**
 * https://leetcode.com/problems/set-mismatch/submissions/
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        
        int[] result = new int[2];
        int[] count = new int[nums.length + 1];
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 0) {
                count[nums[i]] = 1;
                sum += nums[i];
            } else {
                result[0] = nums[i];
            }
        }
        
        result[1] = nums.length * (nums.length + 1) / 2 - sum;
        
        return result;
    }
}