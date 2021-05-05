/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();
        
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            
            nums[val] = nums[val] < 0 ? nums[val] : 0 - nums[val];
        }
        
        for (int i = 0; i < nums.length; i++) {            
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}