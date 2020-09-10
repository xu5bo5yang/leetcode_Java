/**
 * https://leetcode.com/problems/wildcard-matching/submissions/
 */
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        
        match[0][0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            match[i][0] = false;
        }
        
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*') {
                match[0][i] = true;
            } else {
                break;
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    match[i][j] = match[i-1][j] || match[i][j-1];
                } else {
                    match[i][j] = match[i-1][j-1] && (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1));
                }
            }
        }
        
        return match[s.length()][p.length()];
    }
}