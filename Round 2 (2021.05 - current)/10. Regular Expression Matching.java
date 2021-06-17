class Solution {
    
    private int[][] memo;
    
    public boolean isMatch(String s, String p) {      
        memo = new int[s.length()][p.length()];
        
        return dp(s, 0, p, 0);
    }
    
    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        
        if (j == n) {
            return i == m;
        }
        
        if (i == m) {
            if ((n - j) % 2 != 0) {
                return false;
            }
            
            for (int k = j; k < n - 1; k += 2) {
                if (p.charAt(k + 1) != '*') {
                    return false;
                }
            }
            
            return true;
        }
        
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }
        
        boolean result;
        
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                result = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                result = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                result = dp(s, i, p, j + 2);
            } else {
                result = false;
            }
        }
        
        memo[i][j] = result ? 1 : -1;
        
        return result;
    }
}