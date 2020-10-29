/** 
 * https://leetcode.com/problems/combination-sum-iv/submissions/
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        return findSumCount(nums, target, new HashMap());
    }
    
    int findSumCount(int[] nums, int target, Map<Integer, Integer> sumCounts) {
        if (target < 0)  {
            return 0;
        }
        
        if (target == 0) {
            return 1;
        }
        
        if (sumCounts.containsKey(target)) {
            return sumCounts.get(target);
        }
        
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int count = findSumCount(nums, target - nums[i], sumCounts);
            
            if (target >= nums[i]) {
                sumCounts.put(target - nums[i], count);
            }
            
            result += count;
        }
        
        return result;
    }    
}