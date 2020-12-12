/**
 * https://leetcode.com/problems/valid-palindrome-ii/submissions/
 */
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
    
    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}