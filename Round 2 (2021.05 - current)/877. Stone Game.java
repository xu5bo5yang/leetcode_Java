class Solution {
    
    private class Pair {
        int first;
        int second;
        
        public Pair(int fir, int sec) {
            this.first = fir;
            this.second = sec;
        }
    }
    
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
            
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        }
        
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;
                
                if (left < right) {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                } else {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                }
            }
        }
        
        return dp[0][n - 1].first > dp[0][n - 1].second;
    }
}