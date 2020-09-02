/**
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < s.length(); i++){
            int[] pair1 = getLongestPalindromePos(s, i, i);
            int[] pair2 = getLongestPalindromePos(s, i, i+1);
            
            int length1 = pair1[1] - pair1[0];
            int length2 = pair2[1] - pair2[0];
            int currentLength = right - left;
            
            if (length1 > length2 && length1 > currentLength) {
                left = pair1[0];
                right = pair1[1];
            } else if (length2 > currentLength) {
                left = pair2[0];
                right = pair2[1];
            }
        }
        
        return s.substring(left, right+1);
    }
    
     int[] getLongestPalindromePos (String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
            
        return new int[]{left+1, right-1};
    }
}