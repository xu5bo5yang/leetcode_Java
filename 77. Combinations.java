/**
 * https://leetcode.com/problems/combinations/submissions/
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> comb = new ArrayList();
                comb.add(i);
                result.add(comb);
            }
            
            return result;
        }
        
        if (k == n) {
            List<Integer> comb = new ArrayList();
            for (int i = 1; i <= n; i++) {
                comb.add(i);
            }
            
            result.add(comb);
            return result;
        }
        
        List<List<Integer>> prev = combine(n-1, k-1);
        for (List<Integer> list : prev) {
            list.add(n);
        }
        
        result.addAll(prev);
        result.addAll(combine(n-1, k));
        
        return result;
    }
}