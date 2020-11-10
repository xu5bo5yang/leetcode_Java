/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();
        
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            
            if (nums[val] < 0) {
                result.add(val + 1);
            }
            
            nums[val] = 0 - nums[val];
        }
        
        return result;
    }
}