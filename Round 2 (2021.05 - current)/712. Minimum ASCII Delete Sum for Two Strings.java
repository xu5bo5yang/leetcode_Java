class Solution {
    private int[][] memo;
    
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        memo = new int[l1][l2];
        
        for (int i = 0; i < l1; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return dp(s1, 0, s2, 0);
    }
    
    private int dp(String s1, int i, String s2, int j) {
        int result = 0;
        
        if (i == s1.length()) {
            while (j < s2.length()) {
                result += s2.charAt(j);
                j++;
            }
            
            return result;
        }
        
        if (j == s2.length()) {
            while (i < s1.length()) {
                result += s1.charAt(i);
                i++;
            }
            
            return result;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i + 1, s2, j),
                                 s2.charAt(j) + dp(s1, i, s2, j + 1));
        }
        
        return memo[i][j];
    }
}