/**
 * https://leetcode.com/problems/missing-number/submissions/
 */
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int n = nums.length;
        int expSum = n * (n + 1) / 2;
        int actSum = 0;
        
        for (int num : nums) {
            actSum += num;
        }
        
        return expSum - actSum;
    }
}