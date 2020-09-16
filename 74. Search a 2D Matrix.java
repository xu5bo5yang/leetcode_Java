/**
 * https://leetcode.com/problems/search-a-2d-matrix/submissions/
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = findRow(matrix, 0, matrix.length - 1, target);
        
        if (matrix[row][0] > target) {
            return false;
        } else if (matrix[row][0] == target) {
            return true;
        }
        
        return findCol(matrix[row], 0, matrix[row].length - 1, target);
    }
    
    int findRow(int[][] matrix, int low, int high, int target) {
        if (matrix[high][0] <= target) {
            return high;
        }
        
        if (high - low <= 1) {
            return low;
        }

        
        int mid = low + (high - low) / 2;

        if (matrix[mid][0] == target) {
            return mid;
        } else if (matrix[mid][0] > target) {
            return findRow(matrix, low, mid, target);
        } else {
            return findRow(matrix, mid, high, target);
        }
    }
    
    boolean findCol(int[] row, int low, int high, int target) {        
        if (high - low <= 1) {
            return row[low] == target || row[high] == target;
        }
        
        int mid = low + (high - low) / 2;
        
        if (row[mid] == target) {
            return true;
        } else if (row[mid] > target) {
            return findCol(row, low, mid, target);
        } else {
            return findCol(row, mid, high, target);
        }
    }
}