/**
 * https://leetcode.com/problems/interleaving-string/submissions/
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] result = new boolean[s1.length()+1][s2.length()+1];
        
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = true;
                } else if (i == 0) {
                    result[i][j] = result[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1));
                } else if (j == 0) {
                    result[i][j] = result[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1));
                } else {
                    result[i][j] = result[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)) || (result[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)));
                }
            }
        }
        
        return result[s1.length()][s2.length()];
    }
}