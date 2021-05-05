/**
 * https://leetcode.com/problems/palindromic-substrings/submissions/
 */
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += extractPalindrome(s, i, i);
            count += extractPalindrome(s, i, i+1);
        }
        
        return count;
    }
    
    int extractPalindrome(String s, int left, int right) {
        int count = 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        
        return count;
    }
}