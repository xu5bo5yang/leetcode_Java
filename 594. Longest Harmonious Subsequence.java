/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/submissions/
 */
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap();
        int result = 0;
        
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            
            if (numCount.containsKey(num - 1)) {
                result = Math.max(result, numCount.get(num) + numCount.get(num - 1));
            }
            
            if (numCount.containsKey(num + 1)) {
                result = Math.max(result, numCount.get(num) + numCount.get(num + 1));
            }
        }
        
        return result;
    }
}