/**
 * https://leetcode.com/problems/remove-duplicate-letters/submissions/
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();
        
        while (s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            
            int pos = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                
                count[ch - 'a']--;
                
                if (ch < s.charAt(pos)) {
                    pos = i;
                }
                
                if (count[ch - 'a'] == 0) {
                    break;
                }
            }
            
            char letter = s.charAt(pos);
            result.append(letter);
            s = s.substring(pos + 1);
            s = s.replaceAll("" + letter, "");
            Arrays.fill(count, 0);
        }
        
        return result.toString();
    }
}