/**
 * https://leetcode.com/problems/subarray-sum-equals-k/submissions/
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumCount = new HashMap();
        sumCount.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sumCount.containsKey(sum - k)){
                result += sumCount.get(sum - k);
            }
            
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}