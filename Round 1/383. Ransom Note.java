/**
 * https://leetcode.com/problems/ransom-note/submissions/
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        
        for (char c : ransomNote.toCharArray()) {
            letters[c - 'a']++;
        }
        
        for (char c : magazine.toCharArray()) {
            letters[c - 'a']--;
        }
        
        for (int letter : letters) {
            if (letter > 0) {
                return false;
            }
        }
        
        return true;
    }
}