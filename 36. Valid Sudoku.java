/**
 * https://leetcode.com/problems/valid-sudoku/submissions/
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) {
            return false;
        }
        
        int length = 9;
        Set[] columnSet = new Set[length];
        Set[] rowSet = new Set[length];
        Set[][] gridSet = new Set[length/3][length/3];
        
        for (int i = 0; i < length; i++) {
            columnSet[i] = new HashSet<Integer>();
            rowSet[i] = new HashSet<Integer>();
            gridSet[i/3][i%3] = new HashSet<Integer>();
        }
        
        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                if (board[row][column] == '.') {
                    continue;
                } else {
                    int digit = board[row][column] - '0';
                    
                    if (columnSet[column].contains(digit) || rowSet[row].contains(digit) ||
                       gridSet[row/3][column/3].contains(digit)) {
                        return false;
                    }
                    
                    columnSet[column].add(digit);
                    rowSet[row].add(digit);
                    gridSet[row/3][column/3].add(digit);
                }
            }
        }
        
        return true;
    }
}