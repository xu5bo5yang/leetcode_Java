/**
 * https://leetcode.com/problems/largest-plus-sign/submissions/
 */
class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = N;
            }
        }

        for (int[] row : mines) {
            dp[row[0]][row[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            int left = 0;
            int up = 0;
            int right = 0;
            int down = 0;
            
            for (int j = 0, k = N - 1; j < N && k >= 0; j++, k--) {
                dp[i][j] = Math.min(dp[i][j], left = (dp[i][j] == 0 ? 0 : left + 1));
                dp[j][i] = Math.min(dp[j][i], up = (dp[j][i] == 0 ? 0 : up + 1));
                dp[i][k] = Math.min(dp[i][k], right = (dp[i][k] == 0 ? 0 : right + 1));
                dp[k][i] = Math.min(dp[k][i], down = (dp[k][i] == 0 ? 0 : down + 1));
            }
        }

        int result = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        
        return result;
    }
}