/**
 * https://leetcode.com/problems/subsets/submissions/
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        result.add(new ArrayList());
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> prev = new ArrayList();
            for (List<Integer> list : result) {
                prev.add(new ArrayList(list));
            }
            
            for (List<Integer> list : prev) {
                list.add(nums[i]);
                result.add(list);
            }
        }
        
        return result;
    }
}