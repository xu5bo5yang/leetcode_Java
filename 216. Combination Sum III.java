/**
 * https://leetcode.com/problems/combination-sum-iii/submissions/
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        
        if (k > 9 || n > 45 || k < 1 || n < 1) {
            return result;
        }
        
        findCombination(result, new ArrayList(), k, n, 1);
        
        return result;
    }
    
    void findCombination(List<List<Integer>> result, List<Integer> prev, int k, int n, int start) {
        if (prev.size() == k && n == 0) {
            List<Integer> combination = new ArrayList();
            combination.addAll(prev);
            result.add(combination);
            
            return;
        }
        
        for (int i = start; i <= 9 && i <= n; i++) {
            if (prev.contains(i)) {
                continue;
            }
            
            prev.add(i);
            findCombination(result, prev, k, n-i, i);
            prev.remove(prev.size() - 1);
        }
    }
}