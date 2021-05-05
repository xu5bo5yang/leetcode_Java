/**
 * https://leetcode.com/problems/permutations/submissions/
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ans0 = new ArrayList<Integer>();
        ans0.add(nums[0]);
        result.add(ans0);
        
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            for (int j = 0; j < i; j++) {
                for (List<Integer> pre : result) {
                    List<Integer> newList = new ArrayList<Integer>(pre);
                    newList.add(j, nums[i]);
                    newResult.add(newList);
                }
            }
            
            for (List<Integer> pre : result) {
                List<Integer> newList = new ArrayList(pre);
                newList.add(nums[i]);
                newResult.add(newList);
            }
            
            result = newResult;
        }
        
        return result;
    }
}