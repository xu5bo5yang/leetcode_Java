/**
 * https://leetcode.com/problems/valid-parenthesis-string/submissions/
 */
class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        
        int leftCount = 0;
        int leftWithStar = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
                leftWithStar++;
            } else if (c == '*') {
                leftCount--;
                leftWithStar++;
            } else if (c == ')') {
                leftCount--;
                leftWithStar--;
            }
            
            if (leftWithStar < 0) {
                return false;
            }
            
            leftCount = Math.max(leftCount, 0);
        }
        
        return leftCount == 0;
    }
}