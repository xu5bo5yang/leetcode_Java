/**
 * https://leetcode.com/problems/sudoku-solver/submissions/
 */
class Solution {
    private boolean findSolution = false;
    
    public void solveSudoku(char[][] board) {
        Set[] columnSet = new Set[9];
        Set[] rowSet = new Set[9];
        Set[][] gridSet = new Set[3][3];
        
        for (int i = 0; i < 9; i++) {
            columnSet[i] = new HashSet<Integer>();
            rowSet[i] = new HashSet<Integer>();
            gridSet[i/3][i%3] = new HashSet<Integer>();
        }
        
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }
                
                int digit = board[row][column] - '0';
                columnSet[column].add(digit);
                rowSet[row].add(digit);
                gridSet[row/3][column/3].add(digit);
            }
        }
        
        exploreDigit(board, columnSet, rowSet, gridSet, 0, 0);
    }
    
    void exploreDigit(char[][] board, Set[] columnSet, Set[] rowSet, Set[][] gridSet, int row, int column) {
        if (row > 8) {
            findSolution = true;
            return;
        }
        
        if (board[row][column] != '.') {
            if (column < 8) {
                exploreDigit(board, columnSet, rowSet, gridSet, row, column + 1);
            } else {
                exploreDigit(board, columnSet, rowSet, gridSet, row + 1, 0);
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (columnSet[column].contains(i) || rowSet[row].contains(i) || gridSet[row/3][column/3].contains(i)) {
                    continue;
                }

                columnSet[column].add(i);
                rowSet[row].add(i);
                gridSet[row/3][column/3].add(i);
                board[row][column] = (char) ('0' + i);

                if (column < 8) {
                    exploreDigit(board, columnSet, rowSet, gridSet, row, column + 1);
                } else {
                    exploreDigit(board, columnSet, rowSet, gridSet, row + 1, 0);
                }

                if (findSolution) {
                    return;
                }
                
                columnSet[column].remove(i);
                rowSet[row].remove(i);
                gridSet[row/3][column/3].remove(i);
            }
            
            board[row][column] = '.';
        }
    }
}