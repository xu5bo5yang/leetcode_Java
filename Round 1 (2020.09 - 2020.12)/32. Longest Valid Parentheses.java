/**
 * https://leetcode.com/problems/longest-valid-parentheses/submissions/
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int longest = 0;
        int length = 0;
        int index = 0;
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                longest = Math.max(longest, left + right);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }
        
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                longest = Math.max(longest, left + right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        
        return longest;
    }
}