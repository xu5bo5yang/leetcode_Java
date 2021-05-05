/**
 * https://leetcode.com/problems/valid-anagram/submissions/
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charS = new int[26];
        int[] charT = new int[26];
        
        for (char c : s.toCharArray()) {
            charS[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            charT[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (charS[i] != charT[i]) {
                return false;
            }
        }
        
        return true;
    }
}