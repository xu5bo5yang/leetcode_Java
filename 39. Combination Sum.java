/**
 * https://leetcode.com/problems/combination-sum/submissions/
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        computeCombination(candidates, target, 0, new LinkedList<>(), results);
        
        return results;
    }
    
    void computeCombination(int[] candidates, int target, int index, LinkedList<Integer> prev, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList(prev));
            return;
        }
        
        if (target < 0) {
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            prev.add(candidates[i]);
            computeCombination(candidates, target - candidates[i], i, prev, results);
            prev.removeLast();
        }
    }
}