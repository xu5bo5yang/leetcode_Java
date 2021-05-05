/**
 * https://leetcode.com/problems/partition-equal-subset-sum/submissions/
 */
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int partitionSum = sum / 2;
        boolean[] result = new boolean[partitionSum + 1];
        result[0] = true;
        
        for (int num : nums) {
            for (int j = partitionSum; j >= num; j--) {
                result[j] = result[j] | result[j - num];
            }
        }
        
        return result[partitionSum];
    }
}
