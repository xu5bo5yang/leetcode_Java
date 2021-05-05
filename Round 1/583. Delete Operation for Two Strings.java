/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/submissions/
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubString(word1, word2);
        
        return (word1.length() - lcs) + (word2.length() - lcs);
    }
    
    int longestCommonSubString(String word1, String word2) {
        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 1; i < result.length; i ++) {
            for (int j = 1; j < result[0].length; j ++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
                }
            }
        }
        
        return result[word1.length()][word2.length()];
    }
}