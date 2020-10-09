/**
 * https://leetcode.com/problems/shortest-palindrome/submissions/
 */
class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        int cutOff = 0;
        String result = "";
        
        for (int i = len; i > 0; i--) {
            if (s.charAt(i-1) != s.charAt(0)) {
                continue;
            }
            
            if (isPalindrome(s.substring(0, i))) {
                cutOff = i;
                break;
            }
        }
        
        for (int i = len - 1; i >= cutOff; i--) {
            result += s.charAt(i);
        }
        
        return result + s;
    }
    
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
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