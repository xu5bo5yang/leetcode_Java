/**
 * https://leetcode.com/problems/custom-sort-string/submissions/
 */
class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();
        
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : S.toCharArray()) {
            while (count[c - 'a'] > 0) {
                result.append(c);
                count[c - 'a']--;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                result.append((char)(i + 'a'));
                count[i]--;
            }
        }
        
        return result.toString();
    }
}