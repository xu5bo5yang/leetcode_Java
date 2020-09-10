/**
 * https://leetcode.com/problems/implement-strstr/submissions/
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.isEmpty()) {
            return 0;
        }
        
        boolean foundMatch = true;
        int result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            while (j < needle.length() && i + j < haystack.length()) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                
                j++;
            }
            
            if (j == needle.length()) {
                result = i;
                break;
            }
        }
        
        return result;
    }
}