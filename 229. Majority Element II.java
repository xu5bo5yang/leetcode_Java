/**
 * https://leetcode.com/problems/majority-element-ii/submissions/
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList();
        }
        
        Map<Integer, Integer> timesMap = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int times = timesMap.getOrDefault(nums[i], 0);
            times++;
            
            timesMap.put(nums[i], times);
        }
        
        int threshold = nums.length / 3;
        List<Integer> result = new ArrayList();
        
        for (Map.Entry<Integer, Integer> entry : timesMap.entrySet()) {
            if (entry.getValue() > threshold) {
                result.add(entry.getKey());
            }
        }
        
        return result;
    }
}