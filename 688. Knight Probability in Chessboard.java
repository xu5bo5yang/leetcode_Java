/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/submissions/
 */
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        if (N < 1) {
            return 0;
        }
        
        int[][] dirs = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        double result = 1;
        double[][] board = new double[N][N];
        board[r][c] = 1;
        
        for (int i = 0; i < K; ++i) {
            double[][] newBoard = new double[N][N];
            double newResult = 0;
            
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (board[row][col] != 0) {
                        for (int[] dir : dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];
                            
                            if (0 <= newRow && newRow < N && 0 <= newCol && newCol < N) {
                                newBoard[newRow][newCol] += board[row][col] / 8.0;
                                newResult += board[row][col] / 8.0;
                            }
                        }
                    }
                }
            }  
            
            board = newBoard;
            result = newResult;
        }
        
        return result;
    }
}