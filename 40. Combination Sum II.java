/**
 * https://leetcode.com/problems/combination-sum-ii/submissions/
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        Set<List<Integer>> results = new HashSet<>();
        List<Integer> prev = new ArrayList<>();
        
        computeCombination(candidates, target, 0, prev, results);
        
        return new ArrayList(results);
    }
    
    void computeCombination(int[] candidates, int target, int index, List<Integer> prev, Set<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList(prev));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }

            prev.add(candidates[i]);
            computeCombination(candidates, target - candidates[i], i + 1, prev, results);
            prev.remove(prev.size() - 1);
        }
    }
}