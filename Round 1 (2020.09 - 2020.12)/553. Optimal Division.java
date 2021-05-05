/**
 * https://leetcode.com/problems/optimal-division/submissions/
 */
class Solution {
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "";
        }
        
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        
        if (nums.length == 2) {
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        }
        
        String result = String.valueOf(nums[0]) + "/(" + String.valueOf(nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            result += "/" + String.valueOf(nums[i]);
        }
        
        result += ")";
        
        return result;
    }
}