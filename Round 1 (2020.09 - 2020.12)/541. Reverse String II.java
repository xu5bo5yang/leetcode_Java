/**
 * https://leetcode.com/problems/reverse-string-ii/submissions/
 */
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        
        for (int start = 0; start < chars.length; start += k * 2) {
            int i = start;
            int j = Math.min(start + k - 1, chars.length - 1);
            
            while (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                
                i++;
                j--;
            }
        }
        
        return new String(chars);
    }
}