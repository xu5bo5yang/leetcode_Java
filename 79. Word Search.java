/**
 * https://leetcode.com/problems/word-search/submissions/
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isMatch(board, visited, word, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean isMatch(char[][] board, boolean[][] visited, String word, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            visited[row][col] || board[row][col] != word.charAt(0)) {
            return false;
        }
        
        if (word.length() == 1) {
            return true;
        }
        
        visited[row][col] = true;
            
        if (isMatch(board, visited, word.substring(1), row-1, col) ||
            isMatch(board, visited, word.substring(1), row+1, col) ||
            isMatch(board, visited, word.substring(1), row, col-1) ||
            isMatch(board, visited, word.substring(1), row, col+1)) {
            return true;
        }
        
        visited[row][col] = false;
        return false;
    }
}