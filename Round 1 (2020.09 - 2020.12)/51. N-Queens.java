/**
 * https://leetcode.com/problems/n-queens/submissions/
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], 
            new String[n], result);
        
        return result;
    }
     
    void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, 
                        String[] board, List<List<String>> result) {
        if (r == board.length) {
            result.add(Arrays.asList(board.clone()));
        }
        else {
            for (int i = 0; i < board.length; i++) {
                int id1 = r - i + board.length;
                int id2 = 2 * board.length - r - i - 1;
                if (!cols[i] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[board.length];
                    Arrays.fill(row, '.');
                    row[i] = 'Q';
                    board[i] = new String(row);
                    cols[i] = true; 
                    d1[id1] = true; 
                    d2[id2] = true;
                    helper(r+1, cols, d1, d2, board, result);
                    cols[i] = false; 
                    d1[id1] = false; 
                    d2[id2] = false;
                }
            }
        }
    }
}