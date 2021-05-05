/**
 * https://leetcode.com/problems/unique-binary-search-trees/submissions/
 */
class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                result[i] += result[i-root] * result[root-1];
            }
        }
        
        return result[n];
    }
}