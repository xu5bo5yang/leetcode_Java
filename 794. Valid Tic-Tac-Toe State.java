/**
 * https://leetcode.com/problems/valid-tic-tac-toe-state/submissions/
 */
class Solution {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length < 1) {
            return false;
        }

        int turns = 0;
        boolean xWin = isGameOver(board, 'X');
        boolean oWin = isGameOver(board, 'O');

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++;
                } else if (board[i].charAt(j) == 'O') {
                    turns--;
                }
            }
        }

        if (turns < 0 || turns > 1 || turns == 0 && xWin || turns == 1 && oWin) {
            return false;
        }
        
        return true;
    }
    
    boolean isGameOver(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && 
                board[i].charAt(0) == board[i].charAt(1) && 
                board[i].charAt(1) == board[i].charAt(2)) {
                return true;
            }
            
            if (board[0].charAt(i) == player && 
                board[0].charAt(i) == board[1].charAt(i) && 
                board[1].charAt(i) == board[2].charAt(i)) {
                return true;
            }
        }

        if (board[1].charAt(1) == player && 
            ((board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2))
                || 
             (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)))) {
            return true;
        }

        return false;
    }
}