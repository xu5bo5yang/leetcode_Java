/**
 * https://leetcode.com/problems/rotate-string/submissions/
 */
class Solution {
    public boolean rotateString(String A, String B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        }
        
        if (A.equals(B)) {
            return true;
        }
        
        if (A.length() != B.length()) {
            return false;
        }
        
        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == A.charAt(0)) {
                String newString = B.substring(i, B.length()) + B.substring(0, i);
                
                if (newString.equals(A)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}