/**
 * https://leetcode.com/problems/pascals-triangle/submissions/
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        
        if (numRows < 1) {
            return result;
        }
        
        List<Integer> row0 = new ArrayList();
        row0.add(1);
        result.add(row0);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> rowIminus = result.get(i-1);
            List<Integer> rowI = new ArrayList();
            rowI.add(1);
            
            for (int j = 1; j < i; j++) {
                rowI.add(rowIminus.get(j) + rowIminus.get(j-1));
            }
            
            rowI.add(1);
            result.add(rowI);
        }
        
        return result;
    }
}