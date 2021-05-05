/**
 * https://leetcode.com/problems/contiguous-array/submissions/
 */
class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> sumIndex = new HashMap();
        sumIndex.put(0, -1);
        
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sumIndex.containsKey(sum)) {
                result = Math.max(result, i - sumIndex.get(sum));
            }
            else {
                sumIndex.put(sum, i);
            }
        }
        
        return result;
    }
}