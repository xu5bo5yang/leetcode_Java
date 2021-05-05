/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        
        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                result.append(word.charAt(i));
            }
            
            result.append(" ");
        }
        
        result.setLength(result.length() - 1);
        
        return result.toString();
    }
}