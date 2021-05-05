/**
 * https://leetcode.com/problems/distinct-subsequences/submissions/
 */
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] result = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            result[i][0] = 1;
        }
        
        for (int j = 1; j <= n; j++) {
            result[0][j] = 0;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    result[i][j] = result[i-1][j-1] + result[i-1][j];
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        
        return result[m][n];
    }
}