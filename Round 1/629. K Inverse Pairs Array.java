/**
 * https://leetcode.com/problems/k-inverse-pairs-array/submissions/
 */
class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        
        if (k < 0 || k > n * (n - 1) / 2) {
            return 0;
        }
        
        if (k == 0 || k == n * (n - 1) / 2) {
            return 1;
        }
        
        long[][] result = new long[n + 1][k + 1];
        result[2][0] = 1;
        result[2][1] = 1;
        
        for (int i = 3; i <= n; i++) {
            result[i][0] = 1;
            
            for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++) {
                result[i][j] = result[i][j-1] + result[i-1][j];
                
                if (i <= j) {
                    result[i][j] -= result[i-1][j-i];
                }
                
                result[i][j] = (result[i][j] + mod) % mod;
            }
        }
        return (int) result[n][k];
    }
}