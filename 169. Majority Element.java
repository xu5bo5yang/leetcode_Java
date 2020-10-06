/**
 * https://leetcode.com/problems/majority-element/submissions/
 */
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        Map<Integer, Integer> numMap = new HashMap();
        
        for (int i = 0; i < len; i++) {
            int times = numMap.getOrDefault(nums[i], 0) + 1;
            
            if (times > len / 2) {
                return nums[i];
            }
            
            numMap.put(nums[i], times);
        }
        
        return 0;
    }
}