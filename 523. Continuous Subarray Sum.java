/**
 * https://leetcode.com/problems/continuous-subarray-sum/submissions/
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int sum = 0;
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }
            
            if (remainderIndex.containsKey(sum)) {
                if (i - remainderIndex.get(sum) > 1) {
                    return true;
                }
            } else {
                remainderIndex.put(sum, i);
            }
        }
        
        return false;
    }
}
