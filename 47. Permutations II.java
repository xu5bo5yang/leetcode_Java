/**
 * https://leetcode.com/problems/permutations-ii/submissions/
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> ans0 = new ArrayList<Integer>();
        ans0.add(nums[0]);
        result.add(ans0);
        
        for (int i = 1; i < nums.length; i++) {
            Set<List<Integer>> newResult = new HashSet<List<Integer>>();
            
            for (int j = 0; j < i; j++) {
                for (List<Integer> prev : result) {
                    List<Integer> newList = new ArrayList<Integer>(prev);
                    newList.add(j, nums[i]);
                    newResult.add(newList);
                }
            }
            
            for (List<Integer> prev : result) {
                List<Integer> newList = new ArrayList<Integer>(prev);
                newList.add(nums[i]);
                newResult.add(newList);
            }
            
            result = newResult;
        }
        
        return new ArrayList<List<Integer>>(result);
    }
}