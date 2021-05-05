/**
 * https://leetcode.com/problems/pascals-triangle-ii/submissions/
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList();
        List<Integer> result = new ArrayList();
        prev.add(1);
        
        if (rowIndex == 0) {
            return prev;
        }
        
        for (int i = 1; i <= rowIndex; i++) {
            result.clear();
            result.add(1);
            for (int j = 1; j < i; j++) {
                result.add(prev.get(j) + prev.get(j-1));
            }
            result.add(1);
            
            prev.clear();
            prev.addAll(result);
        }
        
        return result;
    }
}