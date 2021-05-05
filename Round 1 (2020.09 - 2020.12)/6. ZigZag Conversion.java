/**
 * https://leetcode.com/problems/zigzag-conversion/submissions/
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        int row = 0;
        boolean downwards = false;
        
        for (int i = 0; i < s.length(); i++) {
            rows.get(row).append(s.charAt(i));
            
            if (row == numRows - 1 || row == 0) {
                downwards = !downwards;
            }
            
            row += downwards ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder strBuilder : rows) {
            result.append(strBuilder);
        }
        
        return result.toString();
    }
}