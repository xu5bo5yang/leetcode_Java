class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        
        dp[m - 1][n - 1] = 1 - dungeon[m - 1][n - 1] > 0 ? 1 - dungeon[m - 1][n - 1] : 1;
        
        for (int i = m - 2; i >= 0; i--) {
            int value = dp[i + 1][n - 1] - dungeon[i][n - 1];
            
            dp[i][n - 1] = value > 0 ? value : 1;
        }
        
        for (int j = n - 2; j >= 0; j--) {
            int value = dp[m - 1][j + 1] - dungeon[m - 1][j];
            
            dp[m - 1][j] = value > 0 ? value : 1;
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int value = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                
                dp[i][j] = value > 0 ? value : 1;
            }
        }
        
        return dp[0][0];
    }
}