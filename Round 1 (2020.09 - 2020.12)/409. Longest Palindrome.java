/**
 * https://leetcode.com/problems/longest-palindrome/submissions/
 */
class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        Set<Character> charSet = new HashSet();
        int result = 0;
        
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.remove(c);
                result += 2;
            } else {
                charSet.add(c);
            }
        }
        
        if (!charSet.isEmpty()) {
            result++;
        }
        
        return result;
    }
}