/**
 * https://leetcode.com/problems/patching-array/submissions/
 */
class Solution {
    public int minPatches(int[] nums, int n) {
        long number = 1;
        int result = 0;
        int i = 0;
        
        while (number <= n) {
            if (i < nums.length && nums[i] <= number) {
                number += nums[i];
                i++;
            } else {
                number += number;
                result++;
            }
        }
        
        return result;
    }
}