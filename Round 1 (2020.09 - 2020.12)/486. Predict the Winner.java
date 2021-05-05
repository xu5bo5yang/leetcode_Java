/**
 * https://leetcode.com/problems/predict-the-winner/submissions/
 */
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[] result = new int[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    result[i] = nums[i];
                } else {
                    result[j] = Math.max(nums[i] - result[j], nums[j] - result[j - 1]);
                }
            }
        }
        
        return result[nums.length - 1] >= 0;
    }
}