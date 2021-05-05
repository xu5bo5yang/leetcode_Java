/**
 * https://leetcode.com/problems/find-the-difference/submissions/
 */
class Solution {
    public char findTheDifference(String s, String t) {
        if (s == null || t == null) {
            return ' ';
        }
        
        int[] letters = new int[26];
        
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (letters[i] < 0) {
                return (char) ('a' + i);
            }
        }
        
        return ' ';
    }
}