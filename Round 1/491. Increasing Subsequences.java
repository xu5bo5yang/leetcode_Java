/**
 * https://leetcode.com/problems/increasing-subsequences/submissions/
 */
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new ArrayList();
        }
        
        List<List<Integer>> result = new ArrayList();
        
        findSequence(nums, 0, new ArrayList(), result);
        
        return result;
    }
    
    void findSequence(int[] nums, int index, List<Integer> prev, List<List<Integer>> result) {
        if (index > nums.length - 1) {
            if (prev.size() > 1) {
                result.add(new ArrayList<>(prev));
            }
            
            return;
        } 
        
        if (prev.isEmpty() || prev.get(prev.size() - 1) <= nums[index]) {
            prev.add(nums[index]);
            findSequence(nums, index + 1, prev, result);
            prev.remove(prev.size() - 1);
        }
        
        if (index > 0 && prev.size() > 0 && prev.get(prev.size() - 1) == nums[index]) {
            return;
        }
        
        findSequence(nums, index + 1, prev, result);
    }
}