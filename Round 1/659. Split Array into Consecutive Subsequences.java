/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/submissions/
 */
class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        Map<Integer, Integer> numCount = new HashMap();
        Map<Integer, Integer> subCount = new HashMap();
        
        for (int i : nums) {
            numCount.put(i, numCount.getOrDefault(i,0) + 1);
        }
        
        for (int i : nums) {
            if (numCount.get(i) == 0) {
                continue;
            } else if (subCount.getOrDefault(i, 0) > 0) {
                subCount.put(i, subCount.get(i) - 1);
                subCount.put(i + 1, subCount.getOrDefault(i + 1, 0) + 1);
            } else if (numCount.getOrDefault(i + 1, 0) > 0 && numCount.getOrDefault(i + 2, 0) > 0) {
                numCount.put(i + 1, numCount.get(i + 1) - 1);
                numCount.put(i + 2, numCount.get(i + 2) - 1);
                subCount.put(i + 3, subCount.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            
            numCount.put(i, numCount.get(i) - 1);
        }
        
        return true;
    }
}