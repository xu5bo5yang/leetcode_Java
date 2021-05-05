/**
 * https://leetcode.com/problems/spiral-matrix/submissions/
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int index = 0;
        int rowUp = 0;
        int rowDown = matrix.length - 1;
        int columnLeft = 0;
        int columnRight = matrix[0].length - 1;
        
        while (rowUp <= rowDown && columnLeft <= columnRight) {
            for (int i = columnLeft; i <= columnRight; i++) {
                result.add(matrix[rowUp][i]);
            }
            
            for (int i = rowUp + 1; i <= rowDown; i++) {
                result.add(matrix[i][columnRight]);
            }
            
            if (rowUp < rowDown && columnLeft < columnRight) {
                for (int i = columnRight - 1; i > columnLeft; i--) {
                    result.add(matrix[rowDown][i]);
                }

                for (int i = rowDown; i > rowUp; i--) {
                    result.add(matrix[i][columnLeft]);
                }
            }
            
            rowUp++;
            rowDown--;
            columnLeft++;
            columnRight--;
        }
        
        return result;
    }
}