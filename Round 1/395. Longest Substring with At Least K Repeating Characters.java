/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/submissions/
 */
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        int[] charCount = new int[26];
        
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        boolean isValid = true;
        for (int i = 0; i < 26; i++) {
            if(0 < charCount[i] && charCount[i] < k) {
                isValid = false;
            }
        }
        
        if (isValid) {
            return s.length();
        }
        
        int result = 0;
        int start = 0;
        int cur = 0;
        
        while (cur < s.length()) {
            if (charCount[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            
            cur++;
        }
        
        return Math.max(result, longestSubstring(s.substring(start), k));
    }
}