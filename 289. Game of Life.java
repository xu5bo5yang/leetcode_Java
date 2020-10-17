/**
 * https://leetcode.com/problems/game-of-life/submissions/
 */
class Solution {
    public void gameOfLife(int[][] board) {
        // 2: 0 -> 1
        // 3: 1 -> 0

        int row = board.length;
        int col = board[0].length;

        // Iterate through board cell by cell.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int liveNeighbors = 0;

                for (int p = -1; p <= 1; p++) {
                    for (int q = -1; q <= 1; q++) {
                        if (p == 0 && q == 0) {
                            continue;
                        }
                        
                        int r = i + p;
                        int c = j + q;
                        
                        if (r < 0 || r == row || c < 0 || c == col) {
                            continue;
                        }
                        
                        if (board[r][c] == 1 || board[r][c] == 3) {
                            liveNeighbors++;
                        }
                    }
                }

                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 3;
                }

                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}