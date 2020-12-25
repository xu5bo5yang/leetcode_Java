/**
 * https://leetcode.com/problems/cherry-pickup/submissions/
 */
class Solution {
    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        
        int len = grid.length;
        int[][] dp = new int[len][len];
        
        dp[0][0] = grid[0][0];

        for (int n = 1; n < 2 * len - 1; n++) {
            for (int i = len - 1; i >= 0; i--) {
                for (int p = len - 1; p >= 0; p--) {
                    int j = n - i;
                    int q = n - p;

                    if (j < 0 || j >= len || q < 0 || q >= len || grid[i][j] < 0 || grid[p][q] < 0) {
                        dp[i][p] = -1;
                        continue;
                    }
                    
                    if (i > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
                    }
                    
                    if (p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
                    }
                    
                    if (i > 0 && p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
                    }
                    
                    if (dp[i][p] >= 0) {
                        dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0);
                    }
                 }
             }
        }

        return Math.max(dp[len - 1][len - 1], 0);
    }
}