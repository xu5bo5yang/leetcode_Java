/**
 * https://leetcode.com/problems/edit-distance/submissions/
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] results = new int[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            results[i][0] = i;
        }
        
        for (int j = 0; j <= n; j++) {
            results[0][j] = j;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    results[i+1][j+1] = results[i][j];
                } else {
                    results[i+1][j+1] = Math.min(results[i][j], Math.min(results[i+1][j], results[i][j+1])) + 1;
                }
            }
        }
        
        return results[m][n];
    }
}