/**
 * https://leetcode.com/problems/reverse-words-in-a-string/submissions/
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        s.trim();
        String[] splitted = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = splitted.length - 1; i >= 0; i--) {            
            if (splitted[i].equals(" ") || splitted[i].isEmpty()) {
                continue;
            }
            
            result.append(splitted[i]);
            result.append(" ");
        }
        
        return result.toString().trim();
    }
}