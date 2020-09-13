/**
 * https://leetcode.com/problems/valid-number/submissions/
 */
class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim();
        
        boolean isExp = false;
        boolean isDouble = false;
        boolean hasNum = false;
        boolean numAfterExp = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                if (isExp || !hasNum) {
                    return false;
                }
                
                isExp = true;
                numAfterExp = false;
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else if (s.charAt(i) == '.') {
                if (isExp || isDouble) {
                    return false;
                }
                
                isDouble = true;
                continue;
            } else if (isDigit(s.charAt(i))) {
                hasNum = true;
                numAfterExp = true;
            } else {
                return false;
            }
        }
        
        return hasNum && numAfterExp;
    }
    
    boolean isDigit(char c) {
        return 0 <= (c - '0') && (c - '0') <= 9;
    }
}