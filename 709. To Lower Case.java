/**
 * https://leetcode.com/problems/to-lower-case/submissions/
 */
class Solution {
    public String toLowerCase(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        
        char[] chars = str.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            int diff = chars[i] - 'A';
            
            if (diff >= 0 && diff < 26) {
                chars[i] = (char) ('a' + diff);
            }
        }
        
        return new String(chars);
    }
}