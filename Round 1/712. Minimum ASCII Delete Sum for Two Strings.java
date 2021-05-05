/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/submissions/
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] result = new int[m + 1][n + 1];
        
        for (int i = 0;i <= m; i++) {
            for (int j = 0;j <= n; j++) {
                if (i==0 || j==0) {
                    int sum = 0;
                    
                    for (int k = 1; k <= Math.max(j, i); k++) {
                        if (i == 0) {
                            sum += s2.charAt(k - 1);
                        } else {
                            sum += s1.charAt(k - 1);
                        }
                    }
                    
                    result[i][j] = sum;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    result[i][j] = result[i-1][j-1];
                } else {
                    result[i][j] = Math.min(s1.charAt(i-1) + result[i-1][j], s2.charAt(j-1) + result[i][j-1]);
                    result[i][j] = Math.min(result[i][j], s1.charAt(i-1) + s2.charAt(j-1) + result[i-1][j-1]);
                }
            }
        }
        
        return result[m][n];
    }
}