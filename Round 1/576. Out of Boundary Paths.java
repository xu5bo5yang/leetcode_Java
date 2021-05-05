/**
 * https://leetcode.com/problems/out-of-boundary-paths/submissions/
 */
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N < 1) {
            return 0;
        }
        
        int MOD = 1000000007;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int result = 0;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        
        for (int step = 0; step < N; step++) {
            int[][] tmp = new int[m][n];
            
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    for (int[] dir : dirs) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        
                        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                            result = (result + count[row][col]) % MOD;
                        } else {
                            tmp[newRow][newCol] = (tmp[newRow][newCol] + count[row][col]) % MOD;
                        }
                    }
                }
            }
            
            count = tmp;
        }
        
        return result;
    }
}