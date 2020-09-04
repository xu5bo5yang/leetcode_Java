/**
 * https://leetcode.com/problems/longest-common-prefix/submissions/
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        boolean shouldCheckNextChar = true;
        
        while (shouldCheckNextChar) {
            if (i >= strs[0].length()) {
                break;
            } 
            
            char currentChar = strs[0].charAt(i);
            
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    shouldCheckNextChar = false;
                    break;
                } else if (strs[j].charAt(i) != currentChar) {
                    shouldCheckNextChar = false;
                    break;
                }
            }
            
            if (shouldCheckNextChar) {
                result.append(currentChar);
            }
            
            i++;
        }
        
        return result.toString();
    }
}