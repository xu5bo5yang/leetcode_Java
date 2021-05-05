/**
 * https://leetcode.com/problems/battleships-in-a-board/submissions/
 */
class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'X' && downAndRightIsNotX(board, row, col)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    boolean downAndRightIsNotX(char[][] board, int row, int col) {
        return (board.length - 1 <= row || board[row + 1][col] == '.')
            && (board[0].length -1 <= col || board[row][col + 1] == '.');
    }
}