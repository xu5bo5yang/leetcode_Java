/**
 * https://leetcode.com/problems/degree-of-an-array/submissions/
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        Map<Integer, Integer> count = new HashMap();
        Map<Integer, Integer> firstIndex = new HashMap();
        int result = nums.length;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!firstIndex.containsKey(nums[i])) {
                firstIndex.put(nums[i], i);
            }
            
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            
            if (count.get(nums[i]) > max) {
                max = count.get(nums[i]);
                result = i - firstIndex.get(nums[i]) + 1;
            } else if (count.get(nums[i]) == max) {
                result = Math.min(result, i - firstIndex.get(nums[i]) + 1);
            }
        }
        
        return result;
    }
}