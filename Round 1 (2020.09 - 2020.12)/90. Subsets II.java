/**
 * https://leetcode.com/problems/subsets-ii/submissions/
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> result = new HashSet();
        result.add(new ArrayList());
        
        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> prev = result;
            Set<List<Integer>> newResult = new HashSet();
            
            for (List<Integer> list : prev) {
                newResult.add(list);
                
                List<Integer> newList = new ArrayList();
                newList.addAll(list);
                newList.add(nums[i]);
                newResult.add(newList);
            }
            
            result = newResult;
        }
        
        return result.stream().collect(Collectors.toList());
    }
}