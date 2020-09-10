/**
 * https://leetcode.com/problems/first-missing-positive/submissions/
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        Arrays.sort(nums);
        
        int missing = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < missing) {
                continue;
            } else if (nums[i] == missing) {
                missing++;
            } else {
                break;
            }
        }
        
        return missing;
    }
}