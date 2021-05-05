/**
 * https://leetcode.com/problems/valid-palindrome/submissions/
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            
            while(!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}