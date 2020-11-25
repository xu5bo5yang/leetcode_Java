/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        
        Map<Integer, Integer> numCount = new HashMap();
        int result = 0;
        
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                if (k == 0 && numCount.get(num) == 1) {
                    result++;
                }
                
                numCount.put(num, numCount.get(num) + 1);
            } else {
                if (numCount.containsKey(num - k)) {
                    result++;
                }
                
                if (numCount.containsKey(num + k)) {
                    result++;
                }
                
                numCount.put(num, 1);
            }
        }
        
        return result;
    }
}