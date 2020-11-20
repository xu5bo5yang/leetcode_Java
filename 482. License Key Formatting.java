/**
 * https://leetcode.com/problems/license-key-formatting/submissions/
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int curLen = 0;
        
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') {
                continue;
            }
                        
            if (curLen > 0 && curLen % K == 0) {
                result.append('-');
            }
            
            result.append(Character.toUpperCase(S.charAt(i)));
            curLen++;

        }
        
        return result.reverse().toString();
    }
}