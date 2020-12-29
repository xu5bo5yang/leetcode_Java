/**
 * https://leetcode.com/problems/transform-to-chessboard/submissions/
 */
class Solution {
    public int movesToChessboard(int[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return -1;
        }
        
        int n = board.length;
        int sumRow = 0;
        int sumCol = 0;
        int swapRow = 0;
        int swapCol = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            sumRow += board[0][i];
            sumCol += board[i][0];
            
            if (board[i][0] == i % 2) {
                swapRow++;
            }
            
            if (board[0][i] == i % 2) {
                swapCol++;
            }
        }
        
        if ((sumRow != n / 2 && sumRow != (n + 1) / 2) ||
           (sumCol != n / 2 && sumCol != (n + 1) / 2)){
            return -1;
        }
        
        if (n % 2 == 1) {
            swapRow = swapRow % 2 == 0 ? swapRow : n - swapRow;
            swapCol = swapCol % 2 == 0 ? swapCol : n - swapCol;
        } else {
            swapRow = Math.min(swapRow, n - swapRow);
            swapCol = Math.min(swapCol, n - swapCol);
        }
        
        return (swapCol + swapRow) / 2;
    }
}