/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/submissions/
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, dp[i][j] = A[i] == B[j] ? 1 + dp[i + 1][j + 1] : 0);
            }
        }
        
        return max;     
    }
}